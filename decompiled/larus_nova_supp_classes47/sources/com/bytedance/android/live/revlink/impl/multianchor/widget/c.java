package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe.FollowImpl;
import com.bytedance.android.live.revlink.impl.pk.ui.MultiOptFrameLayout;
import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.live.revlink.link.domain.anchorimpl.h {
    public final BackgroundImpl a;
    public final List<Function1<Boolean, Unit>> b;
    public final FollowImpl c;
    public final h d;
    public final IRoom e;
    public final FrameLayout f;
    public final l g;
    public final View h;
    public final View i;

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.h
    public final void f() {
        View r0 = this.h;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getWidth() > 0) goto L8;
        return;
    L8:
        if (r0.getHeight() <= 0) goto L12;
        int r1 = RevBitmapTranslateUtils.a;
        Intrinsics.checkNotNullParameter(r0, "view");
        Bitmap r2 = Bitmap.createBitmap(r0.getWidth(), r0.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        r0.layout(0, 0, r0.getMeasuredWidth(), r0.getMeasuredHeight());
        r0.draw(r3);
        wq2.e.a().e(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void g() {
        BackgroundImpl r0 = this.a;
        r0.f = null;
        r0.h.removeAllViews();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final h h() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final void a(boolean r2) {
        BackgroundImpl r0 = this.a;
        r0.g = r2;
        r0.b();
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
        this.g.d(r4);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final Disposable b(String r2, String r3, Function0<Unit> r4, Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        Intrinsics.checkNotNullParameter(r5, "onFail");
        return this.c.b(r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.j
    public final Disposable e(String r2, RevLiveFollowScene r3, Function0<Unit> r4, Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        Intrinsics.checkNotNullParameter(r5, "onFail");
        return this.c.a(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Context r2, IRoom r3, DataCenter r4, FrameLayout r5, l r6, WidgetManager r7, View r8, MultiOptFrameLayout r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "containerView");
        Intrinsics.checkNotNullParameter(r6, "windowServiceImpl");
        Intrinsics.checkNotNullParameter(r7, "widgetManager");
        Intrinsics.checkNotNullParameter(r8, "widgetContainerView");
        Intrinsics.checkNotNullParameter(r9, "lynxCentralContainer");
        this.e = r3;
        this.f = r5;
        this.g = r6;
        this.h = r8;
        this.i = r9;
        this.a = new BackgroundImpl(r5, r2);
        this.b = new ArrayList();
        this.c = new FollowImpl(r2);
        this.d = new h(r7);
    }
}
