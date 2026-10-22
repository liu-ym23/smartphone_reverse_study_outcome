package com.bytedance.android.live.broadcastgame.xplay.container;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.xplay.g;
import com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.j;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements o, com.bytedance.android.live.broadcastgame.api.xplay.d {
    public final KProperty0 a;
    public final a b;
    public final IXplayCoreService c;
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.b d;
    public final l20.a e;

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.d
    public final Observable<Unit> f() {
        return (Observable) this.a.get();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.d
    public final ViewGroup a() {
        return this.b.a();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.d
    public final Observable<g> c() {
        return this.c.L();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.d
    public final Rect d() {
        Rect r0 = this.d.d();
        if (r0 == null) goto L6;
        Rect r1 = new Rect(r0);
        this.b.n().offsetDescendantRectToMyCoords(this.d.a(), r1);
        return r1;
    L6:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.d
    public final Boolean g() {
        return this.c.g();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.d
    public final String getRtcExtInfo() {
        return this.c.getRtcExtInfo();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.d
    public final Rect h() {
        IXplayCoreService.a r0 = this.c.U();
        if (r0 != null) goto L6;
        return null;
    L6:
        ViewGroup r1 = this.b.c();
        return q1.a(new j(r1.getWidth(), r1.getHeight()), new j(r0.e, r0.f));
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.d
    public final Rect i() {
        e r0 = this.b.n();
        return new Rect(0, 0, r0.getWidth(), r0.getHeight());
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.d
    public final ViewGroup j() {
        return this.b.n();
    }

    public f(a r2, IXplayCoreService r3, final com.bytedance.android.live.broadcastgame.xplay.littlewindow.b r4, XplayInternalContext r5, l20.a r6) {
        Intrinsics.checkNotNullParameter(r2, "containerImpl");
        Intrinsics.checkNotNullParameter(r3, "xplayCoreService");
        Intrinsics.checkNotNullParameter(r4, "littleWindowService");
        Intrinsics.checkNotNullParameter(r5, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r6, "xplayMessageService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        new XplayExtContainerService$littleWindowPos$2(r4);
        this.a = new XplayExtContainerService$onLittleWindowSpecChanged$2(r4);
    }
}
