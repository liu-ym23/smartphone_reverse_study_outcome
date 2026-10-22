package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import com.larus.dora.impl.device.ailab.AiLabViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.conversation_settings.DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1$ret$1", f = "DoraObricGDoubaoConversationSettingsFragment.kt", i = {}, l = {637}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1$ret$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;
    final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment this$0;

    public DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1$ret$1(DoraObricGDoubaoConversationSettingsFragment r1, boolean r2, Continuation<? super DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1$ret$1> r3) {
        this.this$0 = r1;
        this.$isChecked = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1$ret$1(this.this$0, this.$isChecked, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DoraObricGDoubaoConversationSettingsFragment r5 = this.this$0;
        int r2 = DoraObricGDoubaoConversationSettingsFragment.w;
        AiLabViewModel r6 = r5.ea0();
        boolean r3 = this.$isChecked;
        this.label = 1;
        r4 = r6.setVoiceWakeEnable(r3, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
