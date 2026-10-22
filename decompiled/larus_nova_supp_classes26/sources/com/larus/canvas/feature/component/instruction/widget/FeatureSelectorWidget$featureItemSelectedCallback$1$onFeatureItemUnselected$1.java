package com.larus.canvas.feature.component.instruction.widget;

import com.larus.canvas.feature.component.instruction.InstructionTabEventType;
import com.larus.canvas.service.bean.FeatureOptionPanelItem;
import com.larus.canvas.service.bean.OptionItem;
import iy8.i;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.instruction.widget.FeatureSelectorWidget$featureItemSelectedCallback$1$onFeatureItemUnselected$1", f = "FeatureSelectorWidget.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
public final class FeatureSelectorWidget$featureItemSelectedCallback$1$onFeatureItemUnselected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i $unSelectedOptionItem;
    final /* synthetic */ Long $unSelectedOptionPanelId;
    int label;
    final /* synthetic */ FeatureSelectorWidget this$0;

    public FeatureSelectorWidget$featureItemSelectedCallback$1$onFeatureItemUnselected$1(FeatureSelectorWidget r1, i r2, Long r3, Continuation<? super FeatureSelectorWidget$featureItemSelectedCallback$1$onFeatureItemUnselected$1> r4) {
        this.this$0 = r1;
        this.$unSelectedOptionItem = r2;
        this.$unSelectedOptionPanelId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FeatureSelectorWidget$featureItemSelectedCallback$1$onFeatureItemUnselected$1(this.this$0, this.$unSelectedOptionItem, this.$unSelectedOptionPanelId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r56) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r56);
    L53:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r56);
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        Ref.IntRef r4 = new Ref.IntRef();
        r4.element = -1;
        FeatureSelectorWidget r6 = this.this$0;
        int r7 = FeatureSelectorWidget.j;
        List<FeatureOptionPanelItem> r8 = r6.i().getFeatureOptionPanelList();
        if (r8 == null) goto L37;
        Long r9 = this.$unSelectedOptionPanelId;
        i r10 = this.$unSelectedOptionItem;
        Iterator<T> r11 = r8.iterator();
        int r12 = 0;
    L12:
        if (r11.hasNext() == false) goto L37;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        FeatureOptionPanelItem r15 = (FeatureOptionPanelItem) r13;
        if (Intrinsics.areEqual(r15.getId(), r9) == false) goto L35;
        List<OptionItem> r16 = r15.getOptionList();
        if (r16 == null) goto L35;
        Iterator<T> r17 = r16.iterator();
    L22:
        if (r17.hasNext() == false) goto L35;
        OptionItem r18 = (OptionItem) r17.next();
        if (r10 == null) goto L31;
        long r19 = r18.getId();
        Long r5 = r10.a;
        if (r5 == null) goto L31;
        if (r19 != r5.longValue()) goto L31;
        boolean r20 = true;
    L32:
        if (r20 == false) goto L22;
        r4.element = r12;
        r3.element = r18;
    L31:
        r20 = false;
    L35:
        r12 = r14;
    L37:
        if (r3.element == null) goto L55;
        if (r4.element == (-1)) goto L55;
        String r110 = this.this$0.j().get("action_bar_template_id");
        String r21 = this.this$0.j().get("action_bar_key");
        String r111 = this.this$0.j().get("bot_id");
        i r22 = this.$unSelectedOptionItem;
        if (r22 == null) goto L44;
        Long r23 = r22.a;
    L45:
        String r24 = String.valueOf(r23);
        i r25 = this.$unSelectedOptionItem;
        if (r25 == null) goto L48;
        String r26 = r25.b;
    L49:
        tx9.b.e(r111, null, null, r110, r21, null, "", r26, r24, Boxing.boxInt(0), Boxing.boxInt(0), Boxing.boxInt(r4.element), "cancel", null, null, null, null, "original", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -270298, 127);
        MutableSharedFlow<com.larus.canvas.feature.component.instruction.c> r27 = com.larus.canvas.feature.component.instruction.d.a;
        com.larus.canvas.feature.component.instruction.c r28 = new com.larus.canvas.feature.component.instruction.c(InstructionTabEventType.EVENT_SELECTOR_PANEL_STATUS_UNSELECTED, this.this$0.i(), (OptionItem) r3.element, false, 8);
        this.label = 1;
        if (com.larus.canvas.feature.component.instruction.d.a(r28, this) != r1) goto L53;
        return r1;
    L48:
        r26 = null;
        goto L49
    L44:
        r23 = null;
    L55:
        return Unit.INSTANCE;
    }
}
