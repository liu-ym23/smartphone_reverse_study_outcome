package com.obric.assistant.chat.component.bottom.attachment;

import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.special_input.j;
import com.obric.assistant.special_input.t0;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.component.bottom.attachment.ConfigAttachmentPanelComponent$observePhoneOperationAttachmentSkillBarState$3", f = "ConfigAttachmentPanelComponent.kt", i = {}, l = {SpeechEvent.SERVER_DOWNLINK_EVENT_ASR_INFO}, m = "invokeSuspend", n = {}, s = {})
final class ConfigAttachmentPanelComponent$observePhoneOperationAttachmentSkillBarState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConfigAttachmentPanelComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ConfigAttachmentPanelComponent a;

        public a(ConfigAttachmentPanelComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            t0 r5 = (t0) r3;
            boolean r0 = false;
            if (r5.e != 1) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == true) goto L8;
        L10:
            ConfigAttachmentPanelComponent r7 = this.a;
            if (r7.v == r0) goto L19;
            r7.v = r0;
            if (r0 == false) goto L16;
            String r8 = "skill_extension_enabled";
        L17:
            r7.F2(r8);
            return Unit.INSTANCE;
        L16:
            r8 = "skill_extension_disabled";
            goto L17
        L19:
            return Unit.INSTANCE;
        L8:
            if (r5.a == false) goto L10;
            r0 = true;
            goto L10
        L5:
            r6 = false;
            goto L6
        }
    }

    public ConfigAttachmentPanelComponent$observePhoneOperationAttachmentSkillBarState$3(ConfigAttachmentPanelComponent r1, Continuation<? super ConfigAttachmentPanelComponent$observePhoneOperationAttachmentSkillBarState$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ConfigAttachmentPanelComponent$observePhoneOperationAttachmentSkillBarState$3(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        b1 r6 = j.a;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
