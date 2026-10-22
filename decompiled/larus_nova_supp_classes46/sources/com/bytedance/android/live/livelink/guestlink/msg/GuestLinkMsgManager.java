package com.bytedance.android.live.livelink.guestlink.msg;

import android.content.Context;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.liveinteract.multianchor.model.g;
import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import com.bytedance.android.live.multilink.common.message.MultiLinkMessageTypeKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.scope.m;
import com.bytedance.live.kmp.util.d;
import cy0.e;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import yz0.f;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GuestLinkMsgManager extends lb6.b implements qb6.a {
    public f b;
    public zh6.b c;
    public final CompositeDisposable d;
    public final CopyOnWriteArrayList<qb6.a.a> e;
    public final Lazy f;
    public final Context g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GuestLinkMsgManager a;

        public b(GuestLinkMsgManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            GuestLinkMsgManager r0 = this.a;
            GuestLinkMsgManager.F(r0, (g) r2);
        }
    }

    static {
    }

    public final void attach() {
        jy0.b.d("GuestLinkMsgManager", "attach");
        f r0 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), f.class);
        this.b = r0;
        if (r0 == null) goto L10;
        Observable r1 = h.a.a(r0, MultiLinkMessageTypeKt.c(com.bytedance.android.live.multilink.common.message.a.b), false, 6);
        if (r1 == null) goto L11;
        Disposable r2 = r1.subscribe(new b(this));
        if (r2 == null) goto L12;
        com.bytedance.revenue.platform.api.core.rx.f.a(r2, this.d);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void detach() {
        jy0.b.d("GuestLinkMsgManager", "detach");
        super.detach();
        this.d.clear();
        Iterator<qb6.a.a> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r(r0.next());
        goto L4
    L6:
        w("GuestLinkMsgManager#detach");
    }

    public final Context getContext() {
        return this.g;
    }

    public GuestLinkMsgManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.g = r2;
        this.d = new CompositeDisposable();
        this.e = new CopyOnWriteArrayList();
        this.f = LazyKt.lazy(new GuestLinkMsgManager$mOnMessageListener$2(this));
    }

    public final void r(qb6.a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e.remove(r2);
    }

    public final void w(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (this.c == null) goto L6;
        d.b(0, true, new GuestLinkMsgManager$releaseChannelMsgManager$$inlined$let$lambda$1(this, r5), 3);
        return;
    }

    public final void z(GuestLinkPipeLineManager.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e.add(r2);
    }

    public static final void F(GuestLinkMsgManager r3, g r4) {
        r3.getClass();
        StringBuilder r0 = new StringBuilder("received LinkmicGuestLinkMessage, msgType: ");
        r0.append(r4.getMsgType());
        r0.append(", messageId: ");
        Intrinsics.checkNotNullParameter(r4, "$this$messageId");
        m0 r1 = r4.getCommonData();
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "$this$messageIdKt");
        Long r2 = Long.valueOf(r1.getMessageId());
    L6:
        r0.append(r2);
        jy0.b.d("GuestLinkMsgManager", r0.toString());
        Iterator<qb6.a.a> r5 = r3.e.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r5.next().f(r4);
        goto L8
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void q(long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        zh6.b r0 = this.c;
        if (r0 == null) goto L5;
        r0.a(MultiLinkMessageTypeKt.c(com.bytedance.android.live.multilink.common.message.a.b), (zh6.b.a) this.f.getValue());
    L5:
        zh6.b r1 = this.c;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        oz0.a.a r2 = null;
        this.c = null;
        jy0.b.d("GuestLinkMsgManager", "startChannelMsgManager, channelId: " + r4 + ", source: " + r6);
        jy0.b.d("GuestLinkMsgManager", "startChannelMsgManager, create ChannelMessageManager success");
        yz0.g r7 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.g.class);
        if (r7 == null) goto L13;
        Context r8 = r7.getContext();
        if (r8 == null) goto L13;
        e.a.getClass();
        cy0.j r3 = e.a.a;
        m.e.getClass();
        Object r5 = m.b(r3).a(Reflection.getOrCreateKotlinClass(zh6.a.class));
        Intrinsics.checkNotNull(r5);
        r2 = ((f80.a) r5).f(String.valueOf(r4), r8, new LinkedHashMap());
    L13:
        this.c = r2;
        if (r2 == null) goto L16;
        r2.b(MultiLinkMessageTypeKt.c(com.bytedance.android.live.multilink.common.message.a.b), (zh6.b.a) this.f.getValue());
    L16:
        zh6.b r9 = this.c;
        if (r9 == null) goto L20;
        r9.startMessage();
        return;
    }
}
