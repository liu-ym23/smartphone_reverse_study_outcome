package com.bytedance.android.live.revlink.impl.pk.feedview;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class FeedPkLynxWidget$initHubLynx$5 extends FunctionReferenceImpl implements Function0<Unit> {
    public FeedPkLynxWidget$initHubLynx$5(FeedPkLynxWidget r8) {
        super(0, r8, FeedPkLynxWidget.class, "handleBack", "handleBack()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m808invoke() {
        FeedPkLynxWidget r0 = (FeedPkLynxWidget) ((CallableReference) this).receiver;
        zy0.b r1 = r0.m;
        View r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.c();
    L7:
        if (r0.u() == false) goto L14;
        if (r3 == null) goto L12;
        ViewParent r4 = r3.getParent();
        if (r4 == null) goto L12;
        ViewParent r5 = r4.getParent();
    L13:
        boolean r6 = Intrinsics.areEqual(r5, r0.y);
    L18:
        if (r6 == false) goto L21;
        return;
    L21:
        if (r0.y.getWidth() != 0) goto L23;
        return;
    L23:
        if (r0.y.getHeight() == 0) goto L30;
        zy0.b r7 = r0.m;
        if (r7 == null) goto L27;
        r2 = r7.c();
    L27:
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        com.bytedance.android.live.revlink.impl.lynxcontainer.c.a(r0.n, r8, r0.y.getWidth(), r0.y.getHeight());
        r0.p(r0.n, r8, r0.y, r2);
        return;
    L30:
        return;
    L12:
        r5 = null;
        goto L13
    L14:
        if (r3 == null) goto L16;
        ViewParent r9 = r3.getParent();
    L17:
        r6 = Intrinsics.areEqual(r9, r0.y);
        goto L18
    L16:
        r9 = null;
        goto L17
    L5:
        r3 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m808invoke();
        return Unit.INSTANCE;
    }
}
