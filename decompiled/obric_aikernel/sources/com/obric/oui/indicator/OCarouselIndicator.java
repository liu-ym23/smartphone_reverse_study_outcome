package com.obric.oui.indicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator;", "Lcom/obric/oui/indicator/OBaseIndicator;", "Lcom/obric/oui/indicator/OBaseIndicator$a;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$a;", "custom", "", EventBody.KEY_VALUE, "A", "I", "getSelectedDotColor", "()I", "setSelectedDotColor", "(I)V", "selectedDotColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OCarouselIndicator extends OBaseIndicator {

    @ColorInt
    private int A;
    private final ArgbEvaluator B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private IndicatorGroupLayout f6829z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OCarouselIndicator f6830c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6831g;

        b(OCarouselIndicator r10, int r11) {
            this.f6830c = r10;
            this.f6831g = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            if (this.f6830c.getDotsClickable() == false) goto L13;
            int r11 = this.f6831g;
            OBaseIndicator.b r12 = this.f6830c.getPager();
            if (r12 == null) goto L7;
            int r13 = r12.getCount();
        L8:
            if (r11 >= r13) goto L14;
            OBaseIndicator.b r14 = this.f6830c.getPager();
            if (r14 == null) goto L15;
            r14.a(this.f6831g, false);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r13 = 0;
            goto L8
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ OCarouselIndicator f6832d;

        c(OCarouselIndicator r10) {
            this.f6832d = r10;
        }

        @Override // com.obric.oui.indicator.d
        public boolean a() {
            return true;
        }

        @Override // com.obric.oui.indicator.d
        public int b() {
            return this.f6832d.f6793l.size();
        }

        @Override // com.obric.oui.indicator.d
        public void d(int r10, int r11, float r12) {
            com.obric.oui.indicator.b r13 = this.f6832d.f6793l.get(r10);
            Intrinsics.checkNotNullExpressionValue(r13, "dots[selectedPosition]");
            com.obric.oui.indicator.b r14 = r13;
            r14.setWidth((int) this.f6832d.getDotsWidth());
            if (com.obric.oui.indicator.a.a(this.f6832d.f6793l, r11) == false) goto L12;
            com.obric.oui.indicator.b r15 = this.f6832d.f6793l.get(r11);
            Intrinsics.checkNotNullExpressionValue(r15, "dots[nextPosition]");
            com.obric.oui.indicator.b r16 = r15;
            r16.setWidth((int) this.f6832d.getDotsWidth());
            if (this.f6832d.getSelectedDotColor() == this.f6832d.getDotsColor()) goto L12;
            Object r17 = OCarouselIndicator.A(this.f6832d).evaluate(r12, Integer.valueOf(this.f6832d.getSelectedDotColor()), Integer.valueOf(this.f6832d.getDotsColor()));
            Objects.requireNonNull(r17, "null cannot be cast to non-null type kotlin.Int");
            int r18 = ((Integer) r17).intValue();
            Object r19 = OCarouselIndicator.A(this.f6832d).evaluate(r12, Integer.valueOf(this.f6832d.getDotsColor()), Integer.valueOf(this.f6832d.getSelectedDotColor()));
            Objects.requireNonNull(r19, "null cannot be cast to non-null type kotlin.Int");
            r16.setDotColor(((Integer) r19).intValue());
            OBaseIndicator.b r20 = this.f6832d.getPager();
            if (r20 != null) goto L9;
        L11:
            r14.setDotColor(r18);
            goto L12
        L9:
            if (r10 != r20.b()) goto L11;
            r14.setDotColor(this.f6832d.getSelectedDotColor());
        L12:
            this.f6832d.invalidate();
        }

        @Override // com.obric.oui.indicator.d
        public void e(int r10) {
            this.f6832d.f6793l.get(r10).setWidth((int) this.f6832d.getDotsWidth());
            this.f6832d.n(r10);
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OCarouselIndicator(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OCarouselIndicator(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OCarouselIndicator(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.A = ContextCompat.getColor(r10, u8.c.oui_text_1);
        this.B = new ArgbEvaluator();
        B(r11);
        x();
    }

    public /* synthetic */ OCarouselIndicator(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ ArgbEvaluator A(OCarouselIndicator r10) {
        return r10.B;
    }

    private final void B(AttributeSet r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        IndicatorGroupLayout r12 = new IndicatorGroupLayout(r11, null, 0, 6, null);
        this.f6829z = r12;
        r12.setOrientation(0);
        IndicatorGroupLayout r13 = this.f6829z;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L5:
        r13.setGravity(17);
        if (getType() != 1) goto L17;
        IndicatorGroupLayout r14 = this.f6829z;
        if (r14 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L10:
        r14.setBgColor(getResources().getColor(u8.c.carousel_indicator_bg_color, null));
        IndicatorGroupLayout r15 = this.f6829z;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L13:
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r15.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 100.0f, r16.getDisplayMetrics())));
        IndicatorGroupLayout r17 = this.f6829z;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L16:
        r17.setDrawBackground(true);
    L21:
        IndicatorGroupLayout r18 = this.f6829z;
        if (r18 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L24:
        r18.setPadding(getSidePadding(), 0, getSidePadding(), 0);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-2, (int) getLayoutHeight());
        IndicatorGroupLayout r20 = this.f6829z;
        if (r20 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L27:
        addView(r20, r19);
        if (r10 == null) goto L31;
        TypedArray r21 = getContext().obtainStyledAttributes(r10, getCustom().m());
        Intrinsics.checkNotNullExpressionValue(r21, "context.obtainStyledAttr…ttrs, custom.styleableId)");
        setSelectedDotColor(r21.getColor(l.OCarouselIndicator_oui_selectedDotColor, getDotsColor()));
        r21.recycle();
    L31:
        if (isInEditMode() == false) goto L34;
        j(5);
        o();
        return;
    L34:
        return;
    L17:
        IndicatorGroupLayout r22 = this.f6829z;
        if (r22 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L20:
        r22.setDrawBackground(false);
        goto L21
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public OBaseIndicator.a getCustom() {
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        float r11 = TypedValue.applyDimension(1, 24, r10.getDisplayMetrics());
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        float r13 = TypedValue.applyDimension(1, 4, r12.getDisplayMetrics());
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        float r15 = TypedValue.applyDimension(1, 3, r14.getDisplayMetrics());
        int[] r16 = l.OCarouselIndicator;
        Intrinsics.checkNotNullExpressionValue(r16, "R.styleable.OCarouselIndicator");
        return new OBaseIndicator.a(r11, r13, r15, r16, l.OCarouselIndicator_oui_type, l.OCarouselIndicator_oui_layoutHeight, l.OCarouselIndicator_oui_dotsWidth, l.OCarouselIndicator_oui_dotsHeight, l.OCarouselIndicator_oui_dotsSpacing, l.OCarouselIndicator_oui_dotsColor, l.OCarouselIndicator_oui_dotsCornerRadius, l.OCarouselIndicator_oui_dotsClickable, l.OCarouselIndicator_oui_dotsStrokeColor, l.OCarouselIndicator_oui_dotsStrokeWidth);
    }

    public final int getSelectedDotColor() {
        return this.A;
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
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v1 com.obric.oui.indicator.b
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // com.obric.oui.indicator.OBaseIndicator
    public void i(int r8) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v1 com.obric.oui.indicator.b
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            r7 = this;
            com.obric.oui.indicator.IndicatorDotView r6 = new com.obric.oui.indicator.IndicatorDotView
            android.content.Context r1 = r7.getContext()
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            float r1 = r7.getDotsWidth()
            int r1 = (int) r1
            float r2 = r7.getDotsHeight()
            int r2 = (int) r2
            r0.<init>(r1, r2)
            float r1 = r7.getDotsSpacing()
            int r1 = (int) r1
            float r2 = r7.getDotsSpacing()
            int r2 = (int) r2
            r0.setMargins(r1, r3, r2, r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r6.setLayoutParams(r0)
            float r0 = r7.getDotsCornerRadius()
            r6.setCornerRadius(r0)
            boolean r0 = r7.isInEditMode()
            if (r0 == 0) goto L4e
            if (r8 != 0) goto L46
        L43:
            int r0 = r7.A
            goto L4a
        L46:
            int r0 = r7.getDotsColor()
        L4a:
            r6.setDotColor(r0)
            goto L5b
        L4e:
            com.obric.oui.indicator.OBaseIndicator$b r0 = r7.getPager()
            if (r0 == 0) goto L46
            int r0 = r0.b()
            if (r0 != r8) goto L46
            goto L43
        L5b:
            float r0 = r7.getDotsStrokeWidth()
            r6.setStrokeWidth(r0)
            int r0 = r7.getDotsStrokeColor()
            r6.setStrokeColor(r0)
            com.obric.oui.indicator.OCarouselIndicator$b r0 = new com.obric.oui.indicator.OCarouselIndicator$b
            r0.<init>(r7, r8)
            r6.setOnClickListener(r0)
            java.util.ArrayList<com.obric.oui.indicator.b> r8 = r7.f6793l
            r8.add(r6)
            com.obric.oui.indicator.IndicatorGroupLayout r7 = r7.f6829z
            if (r7 != 0) goto L7f
            java.lang.String r8 = "linearLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L7f:
            r7.addView(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.oui.indicator.OCarouselIndicator.i(int):void");
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public d k() {
        return new c(this);
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void n(int r10) {
        com.obric.oui.indicator.b r11 = this.f6793l.get(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "dots[index]");
        com.obric.oui.indicator.b r12 = r11;
        OBaseIndicator.b r13 = getPager();
        Intrinsics.checkNotNull(r13);
        if (r10 != r13.b()) goto L5;
        int r14 = this.A;
    L6:
        r12.setDotColor(r14);
        r12.setCornerRadius(getDotsCornerRadius());
        r12.setStrokeWidth(getDotsStrokeWidth());
        r12.setStrokeColor(getDotsStrokeColor());
        r12.invalidate();
        return;
    L5:
        r14 = getDotsColor();
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setSelectedDotColor(int r10) {
        if (getType() != 1) goto L5;
        r10 = (int) 4076863487L;
    L8:
        this.A = r10;
        q();
        return;
    L5:
        if (this.A != r10) goto L8;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void u() {
        if (getInitialized() == true) goto L6;
        setPendingRefreshParentLayout(true);
        return;
    L6:
        setPendingRefreshParentLayout(false);
        if (getType() != 1) goto L18;
        IndicatorGroupLayout r10 = this.f6829z;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L11:
        r10.setBgColor(getResources().getColor(u8.c.carousel_indicator_bg_color, null));
        IndicatorGroupLayout r11 = this.f6829z;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L14:
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        r11.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 100.0f, r12.getDisplayMetrics())));
        IndicatorGroupLayout r13 = this.f6829z;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L17:
        r13.setDrawBackground(true);
    L25:
        IndicatorGroupLayout r14 = this.f6829z;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L28:
        r14.setPadding(getSidePadding(), 0, getSidePadding(), 0);
        IndicatorGroupLayout r15 = this.f6829z;
        if (r15 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L31:
        IndicatorGroupLayout r16 = this.f6829z;
        if (r16 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L34:
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        r17.height = (int) getLayoutHeight();
        Unit r18 = Unit.INSTANCE;
        r15.setLayoutParams(r17);
        requestLayout();
        return;
    L18:
        IndicatorGroupLayout r19 = this.f6829z;
        if (r19 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L21:
        Context r20 = getContext();
        Intrinsics.checkNotNullExpressionValue(r20, "context");
        r19.setBackgroundColor(r20.getResources().getColor(u8.c.Transparent));
        IndicatorGroupLayout r21 = this.f6829z;
        if (r21 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L24:
        r21.setDrawBackground(false);
        goto L25
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void v(int r10) {
        IndicatorGroupLayout r11 = this.f6829z;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L5:
        IndicatorGroupLayout r12 = this.f6829z;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L8:
        r11.removeViewAt(r12.getChildCount() - 1);
        ArrayList<com.obric.oui.indicator.b> r13 = this.f6793l;
        r13.remove(r13.size() - 1);
    }
}
