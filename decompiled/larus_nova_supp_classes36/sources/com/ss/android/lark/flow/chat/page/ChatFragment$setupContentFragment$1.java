package com.ss.android.lark.flow.chat.page;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.flow.chat.page.flow.FlowChatFragment;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.ChatFragment$setupContentFragment$1", f = "ChatFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatFragment$setupContentFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    int label;
    final /* synthetic */ ChatFragment this$0;

    public ChatFragment$setupContentFragment$1(ChatFragment r1, Bundle r2, Continuation<? super ChatFragment$setupContentFragment$1> r3) {
        this.this$0 = r1;
        this.$args = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatFragment$setupContentFragment$1(this.this$0, this.$args, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r8);
        long r0 = SystemClock.uptimeMillis();
        long r2 = SystemClock.uptimeMillis() - r0;
        ChatFragment r9 = this.this$0;
        FlowChatFragment r4 = new FlowChatFragment();
        r4.setArguments(this.$args);
        r9.j = r4;
        ChatFragment r10 = this.this$0;
        Fragment r5 = r10.j;
        if (r5 == null) goto L7;
        FragmentTransaction r11 = r10.getChildFragmentManager().beginTransaction();
        INVOKEVIRTUAL_com_ss_android_lark_flow_chat_page_ChatFragment$setupContentFragment$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r11, 2131365524, r5, "content_fragment");
        r11.commitNowAllowingStateLoss();
    L7:
        this.this$0.getClass();
        Log.i("ChatFragment", "getChatDestination,du:" + r2 + ",fragmentDu:" + (SystemClock.uptimeMillis() - r0));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_ss_android_lark_flow_chat_page_ChatFragment$setupContentFragment$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.replace(r2, r3, r4);
    }
}
