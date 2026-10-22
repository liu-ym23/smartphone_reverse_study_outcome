package com.larus.dora.impl.device.settings.lab.headdown;

import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.databinding.LarusDoraPageHeadDownDetectionBinding;
import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements FlowCollector, FunctionAdapter {
    public final /* synthetic */ HeadDownDetectionFragment a;

    public g(HeadDownDetectionFragment r1) {
        this.a = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof FlowCollector) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new AdaptedFunctionReference(2, this.a, HeadDownDetectionFragment.class, "renderState", "renderState(Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionUiState;)Lkotlin/Unit;", 12);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
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
    public final Object emit(Object r10, Continuation r11) {
        i r12 = (i) r10;
        final HeadDownDetectionFragment r13 = this.a;
        LarusDoraPageHeadDownDetectionBinding r0 = r13.f;
        if (r0 == null) goto L47;
        NovaTitleBarEx r1 = r0.o;
        if (r1 != null) goto L7;
    L10:
        a r14 = r12.a;
        if (Intrinsics.areEqual(r14, a.c.a) == false) goto L14;
        r13.Z90(2131167065, 2131167025);
        r13.Y90();
        r0.d.setVisibility(8);
        r0.i.setVisibility(0);
        r0.i.setImageResource(2131240491);
        r0.f.setVisibility(8);
        r0.l.setVisibility(8);
        r0.m.setText(r13.getString(2131902761));
        r0.h.setText(r13.W90(2131902760, 2131902759));
        r0.c.setVisibility(0);
        r0.c.setText(r13.getString(2131902966));
    L44:
        Unit r15 = Unit.INSTANCE;
        goto L47
    L14:
        if ((r14 instanceof a.d) == false) goto L17;
        r13.Z90(2131166969, 2131166969);
        r13.Y90();
        r0.d.setVisibility(0);
        a.d r16 = (a.d) r14;
        r0.d.setProgress(r16.b);
        r0.i.setVisibility(8);
        r0.f.setVisibility(0);
        r0.e.setText(String.valueOf(r16.a));
        r0.e.setTextSize(2, 64.0f);
        r0.e.setTextColor(ContextCompat.getColor(r13.requireContext(), 2131103203));
        r0.g.setVisibility(0);
        r0.l.setVisibility(8);
        r0.m.setText(r13.getString(2131902610));
        r0.h.setText(r13.W90(2131902612, 2131902611));
        r0.c.setVisibility(8);
        goto L44
    L17:
        if ((r14 instanceof a.C0049a) == false) goto L32;
        r13.Z90(2131167065, 2131167025);
        LarusDoraPageHeadDownDetectionBinding r17 = r13.f;
        if (r17 == null) goto L25;
        LottieAnimationView r18 = r17.k;
        if (r18 == null) goto L25;
        r18.setVisibility(0);
        if (r18.isAnimating() == true) goto L25;
        r18.setAnimation(2131820588);
        r18.playAnimation();
    L25:
        LarusDoraPageHeadDownDetectionBinding r110 = r13.f;
        if (r110 == null) goto L30;
        ImageView r111 = r110.j;
        if (r111 == null) goto L30;
        r111.setVisibility(0);
    L30:
        r0.d.setVisibility(8);
        r0.i.setVisibility(8);
        r0.f.setVisibility(8);
        r0.l.setVisibility(8);
        r0.m.setText(r13.getString(2131902614));
        r0.h.setText(r13.W90(2131902616, 2131902615));
        r0.c.setVisibility(8);
        goto L44
    L32:
        if (Intrinsics.areEqual(r14, a.e.a) == false) goto L35;
        r13.Z90(2131167065, 2131167025);
        r13.Y90();
        r0.d.setVisibility(8);
        r0.i.setVisibility(0);
        r0.i.setImageResource(2131240488);
        r0.f.setVisibility(8);
        r0.l.setVisibility(8);
        r0.m.setText(r13.getString(2131902617));
        r0.h.setText(r13.getString(2131902618));
        r0.c.setVisibility(0);
        r0.c.setText(r13.getString(2131902340));
        goto L44
    L35:
        if ((r14 instanceof a.b) == false) goto L46;
        r13.Z90(2131167065, 2131167025);
        r13.Y90();
        r0.d.setVisibility(8);
        r0.i.setVisibility(0);
        r0.i.setImageResource(2131240490);
        r0.f.setVisibility(8);
        r0.l.setVisibility(8);
        r0.m.setText(r13.getString(2131902608));
        AppCompatTextView r2 = r0.h;
        HeadDownCalibrationFailureReason r112 = ((a.b) r14).a;
        if (r112 != HeadDownCalibrationFailureReason.MOTION) goto L40;
        CharSequence r113 = r13.getString(2131902609);
    L43:
        r2.setText(r113);
        r0.c.setVisibility(0);
        r0.c.setText(r13.getString(2131902344));
        goto L44
    L40:
        if (r112 != HeadDownCalibrationFailureReason.TIMEOUT) goto L42;
        r113 = r13.getString(2131902958);
        goto L43
    L42:
        r113 = r13.getString(2131902985);
        goto L43
    L46:
        throw new NoWhenBranchMatchedException();
    L7:
        if (r12.b() == false) goto L9;
        NovaTitleBarEx.b6(r1, 2131241477, false, null, null, new e(r13), 14);
        goto L10
    L9:
        r1.getBinding().c.setVisibility(8);
    L47:
        Unit r114 = Unit.INSTANCE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r114;
    }
}
