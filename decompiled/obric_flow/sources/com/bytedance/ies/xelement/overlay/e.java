package com.bytedance.ies.xelement.overlay;

import android.view.ViewTreeObserver;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6495b;

    public /* synthetic */ e(Object r5, int r10) {
        this.f6494a = r10;
        this.f6495b = r5;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        Object r5 = this.f6495b;
        switch(this.f6494a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        xe.i r10 = (xe.i) r5;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.d();
        return;
    L6:
        int r11 = LynxOverlayView.f6470t;
        LynxOverlayView r12 = (LynxOverlayView) r5;
        Intrinsics.checkNotNullParameter(r12, "this$0");
        LynxContext r13 = r12.getLynxContext();
        if (r13 == null) goto L12;
        y r14 = r13.f10155x;
        if (r14 == null) goto L13;
        r14.h();
        return;
    L13:
        return;
    }
}
