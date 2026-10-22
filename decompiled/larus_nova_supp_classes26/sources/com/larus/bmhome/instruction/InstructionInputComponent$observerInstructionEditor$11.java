package com.larus.bmhome.instruction;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$observerInstructionEditor$11", f = "InstructionInputComponent.kt", i = {}, l = {1713}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$observerInstructionEditor$11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionInputComponent a;

        public a(InstructionInputComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r51, Continuation r52) {
            String r1 = (String) r51;
            InstructionInputComponent r2 = this.a;
            String r3 = InstructionInputComponent.Z2;
            if (r2.G3() == null) goto L51;
            InstructionInputComponent r4 = this.a;
            if (com.larus.utils.o0.d(r1) == false) goto L51;
            Map<String, String> r9 = r4.a4().getMsgExtMap();
            String r5 = null;
            if (r9 == null) goto L11;
            String r6 = r9.get("creation_template");
            if (r6 == null) goto L11;
            JSONObject r12 = com.larus.utils.p0.b(r6);
        L12:
            if (r12 == null) goto L14;
            String r17 = r12.optString("current_creation_ref_img_url");
        L15:
            if (r12 == null) goto L17;
            String r18 = r12.optString("current_creation_ref_face_num");
        L18:
            if (r12 == null) goto L20;
            String r19 = r12.optString("current_creation_ref_width");
        L21:
            if (r12 == null) goto L23;
            String r20 = r12.optString("current_creation_ref_height");
        L24:
            if (r17 == null) goto L34;
            com.larus.bmhome.actionbar.model.r r7 = r4.a4().getCurrentInstructionConf();
            if (r7 == null) goto L34;
            com.larus.bmhome.actionbar.model.r r8 = r4.a4().getCurrentInstructionConf();
            if (r8 == null) goto L32;
            com.larus.bmhome.actionbar.model.j1 r13 = r8.e;
            if (r13 == null) goto L32;
            com.larus.bmhome.actionbar.model.j1 r24 = com.larus.bmhome.actionbar.model.j1.a(r13, null, null, null, r17, r18, r19, r20, null, null, 16285695);
        L33:
            r4.a4().setCurrentInstructionConfig(com.larus.bmhome.actionbar.model.r.a(r7, null, null, r24, null, 4079));
        L32:
            r24 = null;
        L34:
            c2 r10 = c2.a;
            com.larus.bmhome.actionbar.model.z0 r11 = r4.yF();
            if (r11 == null) goto L38;
            String r14 = r11.b;
            if (r14 == null) goto L38;
        L39:
            Map r110 = j.a.c(r10, r14, String.valueOf(r4.Q1()), r4.Qh(r1), com.larus.utils.o0.d(r1), r9, null, 32);
            if (r12 == null) goto L43;
            r5 = r12.optString("tpl_button_type");
        L43:
            if (Intrinsics.areEqual(r5, "gen_avatar") == false) goto L45;
            String r15 = r1;
        L46:
            ICoreInputAbility.OnSendParams r16 = new ICoreInputAbility.OnSendParams(r15, "", null, null, null, r110, null, null, r4.Q1(), false, "", false, false, false, null, null, null, null, true, null, MapsKt.mapOf(TuplesKt.to("original_content_source", "use_template")), null, null, null, null, null, null, null, null, s1a.d.a(r4).a(ChatPageContext.class), null, null, null, -538197824, 1, null);
            ICoreInputAbility r21 = r4.G3();
            if (r21 == null) goto L49;
            r21.E0(r16);
        L49:
            FLogger.a.i("InstructionInputComponent", "sendMessageWithNoInput prompt:" + r1);
            r4.S1 = true;
            r4.FP();
            goto L51
        L45:
            r15 = r4.kb(r1);
        L38:
            r14 = "";
            goto L39
        L23:
            r20 = null;
            goto L24
        L20:
            r19 = null;
            goto L21
        L17:
            r18 = null;
            goto L18
        L14:
            r17 = null;
        L11:
            r12 = null;
        L51:
            return Unit.INSTANCE;
        }
    }

    public InstructionInputComponent$observerInstructionEditor$11(InstructionInputComponent r1, Continuation<? super InstructionInputComponent$observerInstructionEditor$11> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionInputComponent$observerInstructionEditor$11(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        InstructionInputComponent r6 = this.this$0;
        String r2 = InstructionInputComponent.Z2;
        InstructionEditorViewModel r7 = r6.a4();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.d1<String> r8 = r7.getInvokeSendMessage();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
