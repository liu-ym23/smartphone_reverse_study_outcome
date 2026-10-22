package com.larus.bmhome.taskskill;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.common.apphost.AppHost;
import com.larus.platform.spi.IAIChatConversationService;
import com.larus.utils.logger.FLogger;
import ic8.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$openNewSubConversationWithDevice$2", f = "SkillComponent.kt", i = {}, l = {1387}, m = "invokeSuspend", n = {}, s = {})
final class SkillComponent$openNewSubConversationWithDevice$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ be8.d $device;
    final /* synthetic */ wc9.e $mainConversation;
    final /* synthetic */ ReplyOption $replyOption;
    final /* synthetic */ String $sourceConversationId;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$openNewSubConversationWithDevice$2(wc9.e r1, SkillComponent r2, be8.d r3, ReplyOption r4, String r5, Continuation<? super SkillComponent$openNewSubConversationWithDevice$2> r6) {
        this.$mainConversation = r1;
        this.this$0 = r2;
        this.$device = r3;
        this.$replyOption = r4;
        this.$sourceConversationId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SkillComponent$openNewSubConversationWithDevice$2(this.$mainConversation, this.this$0, this.$device, this.$replyOption, this.$sourceConversationId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        String r5 = (String) CollectionsKt.firstOrNull((List) r12);
        if (r5 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        FLogger.a.w("SkillComponent", "[openNewSubConversationWithDevice] botId is blank");
        return Unit.INSTANCE;
    L21:
        IAIChatConversationService.Companion r3 = IAIChatConversationService.a;
        Context r4 = this.this$0.getContext();
        wc9.e r6 = this.$mainConversation;
        SkillComponent r7 = this.this$0;
        Regex r8 = SkillComponent.F2;
        String r9 = r7.Z3();
        Bundle r10 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("pending_pc_device_id", this.$device.a), TuplesKt.to("pending_pc_device_name", this.$device.b), TuplesKt.to("pending_pc_device_type", this.$device.c), TuplesKt.to("pending_reply_mode", this.$replyOption)});
        SkillComponent r13 = this.this$0;
        String r11 = this.$sourceConversationId;
        r13.getClass();
        if (SkillComponent.i4() == false) goto L24;
        com.larus.bmhome.chat.mode.a.a(r10);
        r10.putString("task_skill_transfer_from_conversation_id", r11);
    L24:
        Unit r14 = Unit.INSTANCE;
        IAIChatConversationService.a.a(r3, r4, r5, r6, null, r9, r10, 392);
        String r15 = this.this$0.getContext().getString(2131906916);
        s r16 = s.a;
        Application r17 = AppHost.a.getApplication();
        r16.getClass();
        s.q(r17, r15, 3000);
        return Unit.INSTANCE;
    L14:
        if (StringsKt.isBlank(r5) == true) goto L17;
        r2 = false;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        String r18 = this.$mainConversation.a;
        this.label = 1;
        r12 = n.b(r18, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
