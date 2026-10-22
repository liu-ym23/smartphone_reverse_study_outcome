package com.bytedance.android.live.room.api.screenrotation.entrance;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import z51.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class EntranceChecker {
    public final e<Boolean> a;
    public final e b;
    public final CompositeDisposable c;
    public final Lazy d;
    public final RoomContext e;
    public final DataCenter f;

    public final List<a> c() {
        return (List) this.d.getValue();
    }

    public abstract void e();

    public abstract void f();

    public abstract List<a> g();

    public final void d() {
        RoomContext r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        DataCenter r1 = this.f;
        if (r1 != null) goto L8;
        return;
    L8:
        com.bytedance.android.live.room.api.screenrotation.rotate.d r2 = ((IScreenRotateService) k.n(IScreenRotateService.class)).rotateSession(r1, r0);
        Iterator<T> r3 = c().iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        ((a) r3.next()).b(r2);
        goto L10
    L12:
        e();
    }

    public final void h() {
        this.c.clear();
        Iterator<T> r0 = c().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).onUnload();
        goto L4
    L6:
        f();
    }

    public final boolean a(IRotateEntrance r5) {
        Intrinsics.checkNotNullParameter(r5, "entrance");
        Iterator<T> r0 = c().iterator();
    L3:
        boolean r2 = true;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((!((a) r1).c(r5)) == false) goto L3;
    L9:
        a r3 = (a) r1;
        if (r3 == null) goto L13;
        SimpleAlogArgsBuilder r4 = new SimpleAlogArgsBuilder();
        r4.d("EntranceVisibility");
        r4.c("entrance UIVisible [" + r5 + "] invisible by judger [" + r3.getTag() + ']');
        f81.a.a(r4.b());
    L15:
        r2 = false;
    L17:
        if (sh6.c.b((sh6.b) this.a.a.a) != null) goto L19;
        this.a.b(Boolean.valueOf(r2));
    L19:
        return r2;
    L13:
        if (c().isEmpty() == true) goto L15;
    L8:
        r1 = null;
        goto L9
    }

    public final boolean b(IRotateEntrance r5) {
        Intrinsics.checkNotNullParameter(r5, "entrance");
        Iterator<T> r0 = c().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((!((a) r1).a(r5)) == false) goto L4;
    L9:
        a r2 = (a) r1;
        if (r2 == null) goto L13;
        SimpleAlogArgsBuilder r3 = new SimpleAlogArgsBuilder();
        r3.d("EntranceVisibility");
        r3.c("entrance [" + r5 + "] nonsupport by judger [" + r2.getTag() + ']');
        f81.a.a(r3.b());
    L15:
        return false;
    L13:
        if (c().isEmpty() == true) goto L15;
        return true;
    L8:
        r1 = null;
        goto L9
    }

    public EntranceChecker(RoomContext r1, DataCenter r2) {
        this.e = r1;
        this.f = r2;
        int r3 = e.c;
        e<Boolean> r4 = e.a.a();
        this.a = r4;
        this.b = r4;
        this.c = new CompositeDisposable();
        this.d = LazyKt.lazy(new EntranceChecker$judges$2(this));
    }
}
