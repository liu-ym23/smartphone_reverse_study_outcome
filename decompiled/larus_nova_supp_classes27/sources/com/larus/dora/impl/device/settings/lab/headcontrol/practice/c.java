package com.larus.dora.impl.device.settings.lab.headcontrol.practice;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlPracticeBinding;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import w49.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c<T> implements FlowCollector {
    public final /* synthetic */ HeadControlPracticeFragment a;

    public c(HeadControlPracticeFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object emit(Object r8, Continuation r9) {
        d r10 = (d) r8;
        HeadControlPracticeFragment r11 = this.a;
        LarusDoraPageHeadControlPracticeBinding r0 = r11.f;
        if (r0 == null) goto L34;
        HeadControlGestureType r1 = r10.a;
        AppCompatTextView r2 = r0.h;
        if (r1 != HeadControlGestureType.NOD) goto L7;
        CharSequence r3 = r11.getString(2131902768);
    L8:
        r2.setText(r3);
        r0.e.setText(r11.getString(2131902986));
        LarusDoraPageHeadControlPracticeBinding r4 = r11.f;
        if (r4 == null) goto L28;
        LottieAnimationView r5 = r4.g;
        if (r5 == null) goto L28;
        AppCompatImageView r6 = r4.f;
        if (r6 == null) goto L28;
        if (r10.b == false) goto L19;
        r5.cancelAnimation();
        r5.setVisibility(8);
        r6.setVisibility(0);
        goto L28
    L19:
        r6.setVisibility(8);
        r5.setVisibility(0);
        HeadControlGestureType r7 = r10.a;
        int r12 = HeadControlPracticeFragment.b.a[r7.ordinal()];
        if (r12 != 1) goto L22;
        int r13 = 2131820586;
    L27:
        r5.setAnimation(r13);
        r5.playAnimation();
        goto L28
    L22:
        if (r12 != 2) goto L25;
        r13 = 2131820587;
        goto L27
    L25:
        throw new NoWhenBranchMatchedException();
    L28:
        r0.c.setVisibility(0);
        r0.c.setEnabled(r10.b);
        AppCompatTextView r14 = r0.c;
        if (r1 != HeadControlGestureType.SHAKE) goto L31;
        CharSequence r15 = r11.getString(2131902340);
    L32:
        r14.setText(r15);
        Unit r16 = Unit.INSTANCE;
        goto L34
    L31:
        r15 = r11.getString(2131902632);
        goto L32
    L7:
        r3 = r11.getString(2131902964);
    L34:
        return Unit.INSTANCE;
    }
}
