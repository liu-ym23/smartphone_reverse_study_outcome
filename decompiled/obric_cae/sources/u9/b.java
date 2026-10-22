package u9;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d {
    public StateListAnimator I;

    @Override // com.google.android.material.floatingactionbutton.d
    public final float e() {
        return this.f4793q.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void f(Rect r8) {
        if (((FloatingActionButton.b) this.f4794r).f4764a.f4760t == false) goto L5;
        super.f(r8);
        return;
    L5:
        boolean r10 = this.f4778b;
        int r11 = 0;
        FloatingActionButton r12 = this.f4793q;
        if (r10 == true) goto L8;
    L11:
        boolean r13 = true;
    L12:
        if (r13 == true) goto L14;
        r11 = (0 - r12.getSizeDimension()) / 2;
    L14:
        r8.set(r11, r11, r11, r11);
        return;
    L8:
        if (r12.getSizeDimension() >= 0) goto L11;
        r13 = false;
        goto L12
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void g() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void h() {
        n();
        throw null;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void i(int[] r8) {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.material.floatingactionbutton.d
    public final void j(float r8, float r10, float r11) {
        FloatingActionButton r12 = this.f4793q;
        if (r12.getStateListAnimator() != this.I) goto L6;
        StateListAnimator r13 = new StateListAnimator();
        r13.addState(d.C, o(r8, r11));
        r13.addState(d.D, o(r8, r10));
        r13.addState(d.E, o(r8, r10));
        r13.addState(d.F, o(r8, r10));
        AnimatorSet r14 = new AnimatorSet();
        ArrayList r15 = new ArrayList();
        r15.add(ObjectAnimator.ofFloat(r12, "elevation", new float[]{r8}).setDuration(0));
        r15.add(ObjectAnimator.ofFloat(r12, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        r14.playSequentially((Animator[]) r15.toArray(new Animator[0]));
        r14.setInterpolator(d.f4774x);
        r13.addState(d.G, r14);
        r13.addState(d.H, o(0.0f, 0.0f));
        this.I = r13;
        r12.setStateListAnimator(r13);
    L6:
        if (p() == true) goto L8;
        return;
    L8:
        n();
        throw null;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void l() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public final void m() {
    }

    public final AnimatorSet o(float r8, float r10) {
        AnimatorSet r11 = new AnimatorSet();
        FloatingActionButton r12 = this.f4793q;
        r11.play(ObjectAnimator.ofFloat(r12, "elevation", new float[]{r8}).setDuration(0)).with(ObjectAnimator.ofFloat(r12, View.TRANSLATION_Z, new float[]{r10}).setDuration(100));
        r11.setInterpolator(d.f4774x);
        return r11;
    }

    public final boolean p() {
        if (((FloatingActionButton.b) this.f4794r).f4764a.f4760t == false) goto L5;
        return true;
    L5:
        if (this.f4778b == true) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (this.f4793q.getSizeDimension() >= 0) goto L10;
        r8 = false;
        goto L11
    }
}
