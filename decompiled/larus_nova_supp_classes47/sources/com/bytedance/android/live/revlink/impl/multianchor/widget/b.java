package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.FollowImpl;
import com.bytedance.android.live.revlink.impl.pk.ui.MultiOptFrameLayout;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.DoubleRematchType;
import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.revlink.link.domain.anchorimpl.g {
    public final BackgroundImpl a;
    public final FollowImpl b;
    public final h c;
    public final j d;
    public final Context e;
    public final IRoom f;
    public final DataCenter g;
    public final FrameLayout h;
    public final l i;
    public final View j;

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void g() {
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.g
    public final void i() {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.e;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, null);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.g
    public final boolean l() {
        dq2.i r0 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getAdventureService();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final h h() {
        return this.c;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.g
    public final j k() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void a(boolean r2) {
        BackgroundImpl r0 = this.a;
        r0.g = r2;
        r0.b();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.g
    public final View c(DoubleRematchType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        int r5 = a.a[r4.ordinal()];
        if (r5 == 1) goto L9;
        if (r5 == 2) goto L11;
        return null;
    L11:
        return new com.bytedance.android.live.revlink.impl.pk.ui.g(this.e, this.f, this.g);
    L9:
        return new com.bytedance.android.live.revlink.impl.pk.ui.b(this.e, this.f, this.g);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void d(com.bytedance.android.live.revlink.link.domain.anchorimpl.b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a.c(r2);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void j(f31.f r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutStatus");
        BackgroundImpl r0 = this.a;
        RectF r1 = r4.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "visibleArea");
        r0.e = r1;
        r0.a();
        this.i.d(r4);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final Disposable b(String r2, String r3, Function0<Unit> r4, Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        Intrinsics.checkNotNullParameter(r5, "onFail");
        return this.b.b(r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final Disposable e(String r2, RevLiveFollowScene r3, Function0<Unit> r4, Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        Intrinsics.checkNotNullParameter(r5, "onFail");
        return this.b.a(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context r2, IRoom r3, DataCenter r4, FrameLayout r5, l r6, WidgetManager r7, MultiOptFrameLayout r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "containerView");
        Intrinsics.checkNotNullParameter(r6, "windowServiceImpl");
        Intrinsics.checkNotNullParameter(r7, "widgetManager");
        Intrinsics.checkNotNullParameter(r8, "lynxCentralContainer");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r8;
        this.a = new BackgroundImpl(r5, r2);
        this.b = new FollowImpl(r2);
        this.c = new h(r7);
        this.d = new j();
    }
}
