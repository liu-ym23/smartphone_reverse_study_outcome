package k3;

import android.animation.Animator;
import android.widget.LinearLayout;
import com.bytedance.ai.view.popup.anim.AnimController$AnimProcessType;
import ko.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f18586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f18587c;
    public final /* synthetic */ Function0 d;

    public /* synthetic */ a(b r5, Ref.ObjectRef r10, Function0 r11, int r12) {
        this.f18585a = r12;
        this.f18586b = r5;
        this.f18587c = r10;
        this.d = r11;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        Function0 r10 = this.d;
        b r11 = this.f18586b;
        int r12 = this.f18585a;
        Intrinsics.checkNotNullParameter(r5, "animation");
        switch(r12) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        r r13 = (r) r11.d;
        AnimController$AnimProcessType r14 = AnimController$AnimProcessType.f2879a;
        r13.m(true);
        if (r10 == null) goto L10;
        r10.invoke();
        return;
    L10:
        return;
    L8:
        AnimController$AnimProcessType r15 = AnimController$AnimProcessType.f2879a;
        ((r) r11.d).m(false);
        ((h3.b) r10).invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Function0 r10 = this.d;
        b r11 = this.f18586b;
        int r12 = this.f18585a;
        Intrinsics.checkNotNullParameter(r5, "animation");
        switch(r12) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        r r13 = (r) r11.d;
        AnimController$AnimProcessType r14 = AnimController$AnimProcessType.f2879a;
        r13.m(true);
        if (r10 == null) goto L10;
        r10.invoke();
        return;
    L10:
        return;
    L8:
        AnimController$AnimProcessType r15 = AnimController$AnimProcessType.f2879a;
        ((r) r11.d).m(false);
        ((h3.b) r10).invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r5) {
        switch(this.f18585a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "animation");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "animation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        switch(this.f18585a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "animation");
        b r10 = this.f18586b;
        ((LinearLayout) r10.f18590c).setVisibility(0);
        r r11 = (r) r10.d;
        AnimController$AnimProcessType r12 = AnimController$AnimProcessType.f2880b;
        String r13 = (String) this.f18587c.element;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "processType");
        r11.f18728b = r12;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "animation");
        r r14 = (r) this.f18586b.d;
        AnimController$AnimProcessType r15 = AnimController$AnimProcessType.f2880b;
        String r16 = (String) this.f18587c.element;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "processType");
        r14.f18729c = r15;
    }
}
