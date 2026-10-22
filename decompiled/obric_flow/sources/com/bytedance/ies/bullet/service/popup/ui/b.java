package com.bytedance.ies.bullet.service.popup.ui;

import android.animation.Animator;
import com.lynx.tasm.utils.d;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function f6098c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(c r5, Function0 r10, int r11) {
        this.f6096a = r11;
        switch(r11) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f6097b = r5;
        this.f6098c = r10;
        return;
    L6:
        this.f6097b = r5;
        this.f6098c = (Lambda) r10;
    }

    private final void a(Animator r5) {
    }

    private final void b(Animator r5) {
    }

    private final void c(Animator r5) {
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        switch(this.f6096a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "animation");
        AnimController$AnimProcessType r10 = AnimController$AnimProcessType.f6093c;
        c r11 = (c) this.f6097b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r11.f6101c = r10;
        ((Lambda) this.f6098c).invoke();
        return;
    L7:
        Intrinsics.checkNotNullParameter(r5, "animation");
        AnimController$AnimProcessType r12 = AnimController$AnimProcessType.f6093c;
        c r13 = (c) this.f6097b;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r13.f6100b = r12;
        ((Function0) this.f6098c).invoke();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r3v5, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        switch(this.f6096a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ((Function0) this.f6098c).invoke();
        com.obric.flow.cardlistpage.ui.popup.b r10 = (com.obric.flow.cardlistpage.ui.popup.b) this.f6097b;
        r10.f11811c.invoke();
        r10.e = null;
        d.w(r10.f11809a);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "animation");
        AnimController$AnimProcessType r11 = AnimController$AnimProcessType.f6093c;
        c r12 = (c) this.f6097b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r12.f6101c = r11;
        ((Lambda) this.f6098c).invoke();
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "animation");
        AnimController$AnimProcessType r13 = AnimController$AnimProcessType.f6093c;
        c r14 = (c) this.f6097b;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r14.f6100b = r13;
        ((Function0) this.f6098c).invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r5) {
        switch(this.f6096a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "animation");
        return;
    L7:
        Intrinsics.checkNotNullParameter(r5, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        switch(this.f6096a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "animation");
        AnimController$AnimProcessType r10 = AnimController$AnimProcessType.f6092b;
        c r11 = (c) this.f6097b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r11.f6101c = r10;
        return;
    L7:
        Intrinsics.checkNotNullParameter(r5, "animation");
        AnimController$AnimProcessType r12 = AnimController$AnimProcessType.f6092b;
        c r13 = (c) this.f6097b;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r13.f6100b = r12;
    }

    public b(Function0 r5, com.obric.flow.cardlistpage.ui.popup.b r10) {
        this.f6096a = 2;
        this.f6098c = r5;
        this.f6097b = r10;
    }
}
