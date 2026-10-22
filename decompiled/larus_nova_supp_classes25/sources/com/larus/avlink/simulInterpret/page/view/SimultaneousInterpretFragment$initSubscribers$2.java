package com.larus.avlink.simulInterpret.page.view;

import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larus.avlink.impl.databinding.LayoutFragmentBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.avlink.simulInterpret.page.model.SliderLevel;
import com.larus.avlink.simulInterpret.page.ui.BottomControlView;
import com.larus.avlink.simulInterpret.page.ui.BottomTranslatePanelView;
import com.larus.avlink.simulInterpret.page.ui.OnboardingPanelView;
import com.larus.avlink.simulInterpret.page.ui.TitleView;
import com.larus.avlink.simulInterpret.page.ui.TopTranslatePanelView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.simulInterpret.page.view.SimultaneousInterpretFragment$initSubscribers$2", f = "SimultaneousInterpretFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SimultaneousInterpretFragment$initSubscribers$2 extends SuspendLambda implements Function2<com.larus.avlink.simulInterpret.page.model.b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SimultaneousInterpretFragment this$0;

    public SimultaneousInterpretFragment$initSubscribers$2(SimultaneousInterpretFragment r1, Continuation<? super SimultaneousInterpretFragment$initSubscribers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        SimultaneousInterpretFragment$initSubscribers$2 r0 = new SimultaneousInterpretFragment$initSubscribers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larus.avlink.simulInterpret.page.model.b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.avlink.simulInterpret.page.model.b) r1, (Continuation) r2);
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
    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L202;
        ResultKt.throwOnFailure(r15);
        com.larus.avlink.simulInterpret.page.model.b r16 = (com.larus.avlink.simulInterpret.page.model.b) this.L$0;
        boolean r1 = true;
        DoraDeviceType r3 = null;
        if (DoraConfig.f() == false) goto L12;
        DoraDeviceType r0 = this.this$0.k;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r0 = null;
    L10:
        if (r0 != DoraDeviceType.DEVICE_G) goto L12;
        boolean r2 = true;
    L14:
        if ((r16 instanceof com.larus.avlink.simulInterpret.page.model.b.C0027b) == false) goto L98;
        LayoutFragmentBinding r17 = this.this$0.l;
        if (r17 == null) goto L25;
        TitleView r18 = r17.l;
        if (r18 == null) goto L25;
        if (r18.a.h.getVisibility() != 0) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == false) goto L25;
        r18.a.g.setVisibility(8);
        r18.a.f.setVisibility(8);
        goto L25
    L22:
        r5 = false;
    L25:
        LayoutFragmentBinding r19 = this.this$0.l;
        if (r19 == null) goto L30;
        ConstraintLayout r110 = r19.i;
        if (r110 == null) goto L30;
        r110.setVisibility(0);
    L30:
        LayoutFragmentBinding r111 = this.this$0.l;
        if (r111 == null) goto L46;
        OnboardingPanelView r112 = r111.i;
        if (r112 == null) goto L46;
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L41;
        DeviceService r8 = r7.device();
        if (r8 == null) goto L41;
        if (r8.f() != true) goto L41;
    L42:
        if (r1 == false) goto L44;
        int r4 = 4;
    L45:
        r112.setShortcutViewVisibility(r4);
        goto L46
    L44:
        r4 = 0;
    L41:
        r1 = false;
    L46:
        SimultaneousInterpretFragment r113 = this.this$0;
        LayoutFragmentBinding r6 = r113.l;
        if (r6 == null) goto L58;
        ImageView r9 = r6.h;
        if (r9 == null) goto L58;
        DoraDeviceType r114 = r113.k;
        if (r114 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
        r114 = null;
    L54:
        if (r114 != DoraDeviceType.DEVICE_LITE) goto L56;
        int r115 = 0;
    L57:
        r9.setVisibility(r115);
        goto L58
    L56:
        r115 = 8;
    L58:
        LayoutFragmentBinding r116 = this.this$0.l;
        if (r116 == null) goto L63;
        ConstraintLayout r117 = r116.k;
        if (r117 == null) goto L63;
        r117.setVisibility(8);
    L63:
        SimultaneousInterpretFragment r118 = this.this$0;
        r118.i = false;
        LayoutFragmentBinding r119 = r118.l;
        if (r119 == null) goto L68;
        TopTranslatePanelView r120 = r119.m;
        if (r120 == null) goto L68;
        r120.a.c.setVisibility(0);
        r120.a.d.setVisibility(8);
        r120.a.h.setVisibility(8);
        r120.a.i.setVisibility(8);
        r120.a.k.setVisibility(8);
        r120.a.b.setVisibility(8);
        ConstraintLayout r10 = r120.a.a;
        ConstraintSet r11 = new ConstraintSet();
        r11.clone(r10);
        r11.constrainWidth(r120.a.e.getId(), c7.b(64));
        r11.constrainHeight(r120.a.e.getId(), c7.b(64));
        r11.setMargin(r120.a.e.getId(), 3, c7.b(26));
        r11.setMargin(r120.a.e.getId(), 4, c7.b(12));
        r11.applyTo(r10);
    L68:
        LayoutFragmentBinding r121 = this.this$0.l;
        if (r121 == null) goto L73;
        BottomTranslatePanelView r122 = r121.d;
        if (r122 == null) goto L73;
        r122.a.c.setVisibility(0);
        r122.a.d.setVisibility(8);
        r122.a.g.setVisibility(8);
        r122.a.h.setVisibility(8);
        r122.a.j.setVisibility(8);
        r122.a.b.setVisibility(8);
        ConstraintLayout r12 = r122.a.a;
        ConstraintSet r13 = new ConstraintSet();
        r13.clone(r12);
        r13.constrainWidth(r122.a.e.getId(), c7.b(64));
        r13.constrainHeight(r122.a.e.getId(), c7.b(64));
        r13.setMargin(r122.a.e.getId(), 3, c7.b(12));
        r13.setMargin(r122.a.e.getId(), 4, c7.b(26));
        r13.applyTo(r12);
    L73:
        SimultaneousInterpretFragment r123 = this.this$0;
        LayoutFragmentBinding r14 = r123.l;
        if (r14 == null) goto L76;
        int r20 = r123.getResources().getDimensionPixelSize(v19.c.b(2130971440, r123.getContext(), 2131167249));
        ConstraintSet r21 = new ConstraintSet();
        r21.clone(r14.e);
        r21.constrainHeight(r14.b.getId(), r20);
        r21.clear(r14.b.getId(), 4);
        r21.applyTo(r14.e);
    L76:
        DoraDeviceType r22 = r123.k;
        if (r22 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
    L81:
        if (r3 != DoraDeviceType.DEVICE_G) goto L92;
        r123.ba0(r2);
        LayoutFragmentBinding r23 = r123.l;
        if (r23 == null) goto L92;
        ConstraintLayout r24 = r23.b;
        if (r24 == null) goto L92;
        if (r24.isLaidOut() == true) goto L89;
    L91:
        r24.addOnLayoutChangeListener(new d0(r123));
        goto L92
    L89:
        if (r24.isLayoutRequested() == true) goto L91;
        r123.aa0(r123.W90(SliderLevel.MIDDLE));
    L92:
        LayoutFragmentBinding r124 = this.this$0.l;
        if (r124 == null) goto L198;
        BottomControlView r125 = r124.c;
        if (r125 == null) goto L198;
        r125.a.b.setVisibility(8);
        r125.a.d.setVisibility(0);
        r125.a.c.setVisibility(8);
    L198:
        return Unit.INSTANCE;
    L79:
        r3 = r22;
        goto L81
    L98:
        if (Intrinsics.areEqual(r16, com.larus.avlink.simulInterpret.page.model.b.a.a) == false) goto L148;
        LayoutFragmentBinding r126 = this.this$0.l;
        if (r126 == null) goto L109;
        TitleView r127 = r126.l;
        if (r127 == null) goto L109;
        if (r127.a.h.getVisibility() == 0) goto L107;
        r1 = false;
    L107:
        if (r1 == false) goto L109;
        r127.a.g.setVisibility(0);
        r127.a.f.setVisibility(0);
    L109:
        LayoutFragmentBinding r128 = this.this$0.l;
        if (r128 == null) goto L114;
        ConstraintLayout r129 = r128.i;
        if (r129 == null) goto L114;
        r129.setVisibility(8);
    L114:
        LayoutFragmentBinding r130 = this.this$0.l;
        if (r130 == null) goto L119;
        ImageView r131 = r130.h;
        if (r131 == null) goto L119;
        r131.setVisibility(8);
    L119:
        SimultaneousInterpretFragment r132 = this.this$0;
        LayoutFragmentBinding r25 = r132.l;
        if (r25 == null) goto L132;
        ConstraintLayout r26 = r25.k;
        if (r26 == null) goto L132;
        DoraDeviceType r133 = r132.k;
        if (r133 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
    L128:
        if (r3 != DoraDeviceType.DEVICE_G) goto L130;
        int r134 = 0;
    L131:
        r26.setVisibility(r134);
        goto L132
    L130:
        r134 = 8;
        goto L131
    L126:
        r3 = r133;
    L132:
        LayoutFragmentBinding r135 = this.this$0.l;
        if (r135 == null) goto L137;
        TopTranslatePanelView r136 = r135.m;
        if (r136 == null) goto L137;
        r136.a.c.setVisibility(8);
        r136.a.d.setVisibility(0);
        r136.a.h.setVisibility(0);
        r136.a.i.setVisibility(0);
        r136.a.k.setVisibility(8);
        r136.a.b.setVisibility(8);
    L137:
        LayoutFragmentBinding r137 = this.this$0.l;
        if (r137 == null) goto L142;
        BottomTranslatePanelView r138 = r137.d;
        if (r138 == null) goto L142;
        r138.a.c.setVisibility(8);
        r138.a.d.setVisibility(0);
        r138.a.g.setVisibility(0);
        r138.a.h.setVisibility(0);
        r138.a.j.setVisibility(8);
        r138.a.b.setVisibility(8);
    L142:
        SimultaneousInterpretFragment.U90(this.this$0, r2);
        LayoutFragmentBinding r139 = this.this$0.l;
        if (r139 == null) goto L198;
        BottomControlView r140 = r139.c;
        if (r140 == null) goto L198;
        r140.a.b.setVisibility(0);
        r140.a.d.setVisibility(8);
        boolean r27 = ha8.d.a;
        r140.a.c.setVisibility(8);
        goto L198
    L148:
        if (Intrinsics.areEqual(r16, com.larus.avlink.simulInterpret.page.model.b.c.a) == false) goto L200;
        LayoutFragmentBinding r141 = this.this$0.l;
        if (r141 == null) goto L159;
        TitleView r142 = r141.l;
        if (r142 == null) goto L159;
        if (r142.a.h.getVisibility() == 0) goto L157;
        r1 = false;
    L157:
        if (r1 == false) goto L159;
        r142.a.g.setVisibility(0);
        r142.a.f.setVisibility(0);
    L159:
        LayoutFragmentBinding r143 = this.this$0.l;
        if (r143 == null) goto L164;
        ConstraintLayout r144 = r143.i;
        if (r144 == null) goto L164;
        r144.setVisibility(8);
    L164:
        LayoutFragmentBinding r145 = this.this$0.l;
        if (r145 == null) goto L169;
        ImageView r146 = r145.h;
        if (r146 == null) goto L169;
        r146.setVisibility(8);
    L169:
        SimultaneousInterpretFragment r147 = this.this$0;
        LayoutFragmentBinding r28 = r147.l;
        if (r28 == null) goto L182;
        ConstraintLayout r29 = r28.k;
        if (r29 == null) goto L182;
        DoraDeviceType r148 = r147.k;
        if (r148 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("deviceType");
    L178:
        if (r3 != DoraDeviceType.DEVICE_G) goto L180;
        int r149 = 0;
    L181:
        r29.setVisibility(r149);
        goto L182
    L180:
        r149 = 8;
        goto L181
    L176:
        r3 = r148;
    L182:
        LayoutFragmentBinding r150 = this.this$0.l;
        if (r150 == null) goto L187;
        TopTranslatePanelView r151 = r150.m;
        if (r151 == null) goto L187;
        r151.a.c.setVisibility(8);
        r151.a.d.setVisibility(0);
        r151.a.h.setVisibility(0);
        r151.a.i.setVisibility(8);
        r151.a.k.setVisibility(0);
        r151.a.b.setVisibility(8);
    L187:
        LayoutFragmentBinding r152 = this.this$0.l;
        if (r152 == null) goto L192;
        BottomTranslatePanelView r153 = r152.d;
        if (r153 == null) goto L192;
        r153.a.c.setVisibility(8);
        r153.a.d.setVisibility(0);
        r153.a.g.setVisibility(0);
        r153.a.h.setVisibility(8);
        r153.a.j.setVisibility(0);
        r153.a.b.setVisibility(8);
    L192:
        SimultaneousInterpretFragment.U90(this.this$0, r2);
        LayoutFragmentBinding r154 = this.this$0.l;
        if (r154 == null) goto L198;
        BottomControlView r155 = r154.c;
        if (r155 == null) goto L198;
        r155.a.b.setVisibility(0);
        r155.a.d.setVisibility(8);
        boolean r30 = ha8.d.a;
        r155.a.c.setVisibility(8);
        goto L198
    L200:
        throw new NoWhenBranchMatchedException();
    L12:
        r2 = false;
        goto L14
    L202:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
