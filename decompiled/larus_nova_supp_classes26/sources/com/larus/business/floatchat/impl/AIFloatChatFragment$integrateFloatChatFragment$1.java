package com.larus.business.floatchat.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.floatchat.impl.AIFloatChatFragment$integrateFloatChatFragment$1", f = "AIFloatChatFragment.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
public final class AIFloatChatFragment$integrateFloatChatFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ int $generation;
    int label;
    final /* synthetic */ AIFloatChatFragment this$0;

    public AIFloatChatFragment$integrateFloatChatFragment$1(AIFloatChatFragment r1, String r2, int r3, Continuation<? super AIFloatChatFragment$integrateFloatChatFragment$1> r4) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$generation = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AIFloatChatFragment$integrateFloatChatFragment$1(this.this$0, this.$conversationId, this.$generation, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Fragment r2 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L55
    L53:
        r2 = (Fragment) r13;     // Catch: Throwable -> L55
    L57:
        if (r2 != null) goto L61;
        FLogger.a.i("AIFloatChatFragment", "integrateFloatChatFragment return null");
        return Unit.INSTANCE;
    L61:
        if (this.this$0.isAdded() == true) goto L64;
        FLogger.a.i("AIFloatChatFragment", "fragment is not added, skip attach float chat");
        return Unit.INSTANCE;
    L64:
        int r14 = this.$generation;
        AIFloatChatFragment r3 = this.this$0;
        if (r14 == r3.j) goto L68;
        FLogger.a.i("AIFloatChatFragment", "ignore stale float chat fragment, generation=" + this.$generation + " current=" + this.this$0.j);
        return Unit.INSTANCE;
    L68:
        r3.V90(r3.e);
        AIFloatChatFragment r15 = this.this$0;
        r15.e = r2;
        INVOKEVIRTUAL_com_larus_business_floatchat_impl_AIFloatChatFragment$integrateFloatChatFragment$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r15.getChildFragmentManager().beginTransaction(), this.this$0.d, r2, "tag_ai_float_chat_fragment").commitNowAllowingStateLoss();
        this.this$0.U90(r2);
        AIFloatChatFragment.b r16 = this.this$0.i;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r2, "fragment");
        if (r16.e == null) goto L71;
        r16.g(r2);
    L71:
        FLogger.a.i("AIFloatChatFragment", "integrateFloatChatFragment applied, conversationId=" + this.$conversationId);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
        AIFloatChatFragment r17 = this.this$0;
        String r4 = this.$conversationId;
        int r5 = AIFloatChatFragment.E;
        Bundle r6 = r17.getArguments();
        if (r6 == null) goto L12;
        String r7 = r6.getString("key_action_bar_scene", null);
    L13:
        Bundle r8 = r17.getArguments();
        if (r8 == null) goto L16;
        String r9 = r8.getString("enter_from", null);
    L17:
        Bundle r10 = r17.getArguments();
        if (r10 == null) goto L20;
        String r11 = r10.getString("enter_method", null);
    L21:
        Bundle r12 = new Bundle();
        Bundle r18 = r17.getArguments();
        if (r18 == null) goto L24;
        r12.putAll(r18);
    L24:
        if (r7 == null) goto L26;
        r12.putString("key_action_bar_scene", r7);
    L26:
        if (r9 == null) goto L28;
        r12.putString("enter_from", r9);
    L28:
        if (r11 == null) goto L31;
        r12.putString("enter_method", r11);
    L31:
        if (r12.containsKey("custom_suffix") == true) goto L34;
        r12.putString("custom_suffix", "-ai_float");
    L34:
        if (r12.containsKey("adapt_padding") == true) goto L37;
        r12.putBoolean("adapt_padding", false);
    L37:
        if (r12.containsKey("answer_intent_logic") == true) goto L40;
        r12.putInt("answer_intent_logic", 0);
    L40:
        if (r12.containsKey("filter_sug_type") == true) goto L42;
        r12.putInt("filter_sug_type", 0);
    L42:
        r12.putString("suggested_action_provider", "none");
        if (r4 != null) goto L49;
        r4 = r12.getString(MusicAppletPage.KEY_CONVERSATION_ID, null);
        if (r4 != null) goto L49;
        r4 = r12.getString("argConversationId", null);
        if (r4 != null) goto L49;
        r4 = "";
    L49:
        r12.putString(MusicAppletPage.KEY_CONVERSATION_ID, r4);
        r12.putString("argConversationId", r4);
        AIChatInputUtils r19 = AIChatInputUtils.a;     // Catch: Throwable -> L55
        AIFloatChatFragment r110 = this.this$0;     // Catch: Throwable -> L55
        AIChatInputConfig r20 = r110.m;     // Catch: Throwable -> L55
        AIFloatChatFragment.h r21 = r110.B;     // Catch: Throwable -> L55
        this.label = 1;     // Catch: Throwable -> L55
        r13 = AIChatInputUtils.f(r110, r12, r20, r21, this);     // Catch: Throwable -> L55
        if (r13 != r0) goto L53;
        return r0;
    L20:
        r11 = null;
        goto L21
    L16:
        r9 = null;
        goto L17
    L12:
        r7 = null;
    L55:
        th = move-exception;
        FLogger.a.e("AIFloatChatFragment", "integrateFloatChatFragment failed", th);
        goto L57
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_business_floatchat_impl_AIFloatChatFragment$integrateFloatChatFragment$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.replace(r2, r3, r4);
    }
}
