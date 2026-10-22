package com.bytedance.ies.xelement.overlay;

import android.view.ViewTreeObserver;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6493b;

    public /* synthetic */ d(Object r5, int r10) {
        this.f6492a = r10;
        this.f6493b = r5;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        Object r5 = this.f6493b;
        switch(this.f6492a) {
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
