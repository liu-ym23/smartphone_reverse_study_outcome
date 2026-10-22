package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "visible", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteFragment$subscribeState$8", f = "MmAINoteFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmAINoteFragment$subscribeState$8 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmAINoteFragment this$0;

    public MmAINoteFragment$subscribeState$8(MmAINoteFragment r1, Continuation<? super MmAINoteFragment$subscribeState$8> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmAINoteFragment$subscribeState$8 r0 = new MmAINoteFragment$subscribeState$8(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
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
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L72;
        ResultKt.throwOnFailure(r9);
        boolean r10 = this.Z$0;
        MmAINoteFragment r0 = this.this$0;
        mwb.b r1 = r0.p;
        if (r1 == null) goto L70;
        View r2 = r1.E;
        int r3 = 8;
        if (r10 == false) goto L9;
        int r5 = 0;
    L10:
        r2.setVisibility(r5);
        View r4 = r1.u;
        if (r10 == false) goto L13;
        int r6 = 8;
    L14:
        r4.setVisibility(r6);
        View r7 = r1.n;
        if (r10 == false) goto L17;
        int r8 = 0;
    L18:
        r7.setVisibility(r8);
        View r11 = r1.r;
        if (r10 == false) goto L21;
        int r12 = 8;
    L22:
        r11.setVisibility(r12);
        ViewGroup.LayoutParams r13 = r1.m.getLayoutParams();
        LinearLayout.LayoutParams r14 = null;
        if ((r13 instanceof FrameLayout.LayoutParams) == false) goto L25;
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r13;
    L26:
        if (r15 == null) goto L41;
        Resources r16 = r1.a.getResources();
        float r17 = WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics()).density;
        if (r10 == false) goto L31;
        int r18 = 8388691;
    L32:
        r15.gravity = r18;
        if (r10 == false) goto L35;
        int r19 = 0;
    L36:
        r15.topMargin = r19;
        if (r10 == false) goto L39;
        int r20 = 6;
    L40:
        r15.bottomMargin = (int) (r20 * r17);
        r1.m.setLayoutParams(r15);
        goto L41
    L39:
        r20 = 4;
        goto L40
    L35:
        r19 = (int) (20 * r17);
        goto L36
    L31:
        r18 = 8388659;
    L41:
        ViewGroup.LayoutParams r21 = r1.g.getLayoutParams();
        if (r21 == null) goto L52;
        Resources r22 = r1.a.getResources();
        float r23 = WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics()).density;
        if (r10 == false) goto L47;
        int r24 = 54;
    L48:
        int r25 = (int) (r24 * r23);
        if (r21.height == r25) goto L52;
        r21.height = r25;
        r1.g.setLayoutParams(r21);
        goto L52
    L47:
        r24 = 50;
    L52:
        View r26 = r1.y;
        if (r10 == false) goto L55;
        int r27 = 0;
    L56:
        r26.setVisibility(r27);
        View r28 = r1.A;
        if (r10 == true) goto L60;
        r3 = 0;
    L60:
        r28.setVisibility(r3);
        r0.ia0(r1.v, r1.w, r1.x, r10);
        r0.ia0(r1.B, r1.C, r1.D, r10);
        View r29 = r1.z;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        if ((r30 instanceof LinearLayout.LayoutParams) == false) goto L63;
        r14 = (LinearLayout.LayoutParams) r30;
    L63:
        if (r14 != null) goto L65;
        r14 = new LinearLayout.LayoutParams(0, 0);
    L65:
        if (r10 == false) goto L67;
        r14.width = r0.da0(r29, 12);
        r14.height = 0;
        r14.weight = 0.0f;
    L68:
        r29.setLayoutParams(r14);
        r29.setVisibility(0);
        goto L70
    L67:
        r14.width = 0;
        r14.height = 0;
        r14.weight = 1.0f;
        goto L68
    L55:
        r27 = 8;
        goto L56
    L25:
        r15 = null;
        goto L26
    L21:
        r12 = 0;
        goto L22
    L17:
        r8 = 8;
        goto L18
    L13:
        r6 = 0;
        goto L14
    L9:
        r5 = 8;
    L70:
        return Unit.INSTANCE;
    L72:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
