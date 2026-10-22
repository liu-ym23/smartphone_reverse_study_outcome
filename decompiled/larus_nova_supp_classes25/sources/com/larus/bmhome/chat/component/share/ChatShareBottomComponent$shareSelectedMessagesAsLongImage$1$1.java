package com.larus.bmhome.chat.component.share;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import by7.e;
import com.bytedance.crash.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.panel.b;
import com.larus.bmhome.share.panel.h;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$shareSelectedMessagesAsLongImage$1$1", f = "ChatShareBottomComponent.kt", i = {0}, l = {1246}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class ChatShareBottomComponent$shareSelectedMessagesAsLongImage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Context $context;
    final /* synthetic */ SaveMessageShareInfo $shareInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    public ChatShareBottomComponent$shareSelectedMessagesAsLongImage$1$1(ChatShareBottomComponent r1, Bitmap r2, SaveMessageShareInfo r3, Context r4, Continuation<? super ChatShareBottomComponent$shareSelectedMessagesAsLongImage$1$1> r5) {
        this.this$0 = r1;
        this.$bitmap = r2;
        this.$shareInfo = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ChatShareBottomComponent$shareSelectedMessagesAsLongImage$1$1 r6 = new ChatShareBottomComponent$shareSelectedMessagesAsLongImage$1$1(this.this$0, this.$bitmap, this.$shareInfo, this.$context, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_chat_component_share_ChatShareBottomComponent$shareSelectedMessagesAsLongImage$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(DialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Object invokeSuspend(Object r90) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        e r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r90);
        Object r5 = r90;
    L18:
        b r6 = (b) r5;
        if (r6 != null) goto L22;
        t19.s.a.g(s1a.a.c(this.this$0).getContext(), 2131900870, false);
        return Unit.INSTANCE;
    L22:
        ShareServiceDelegate r7 = ShareServiceDelegate.b;
        FragmentActivity r8 = this.$context;
        if ((r8 instanceof FragmentActivity) == false) goto L25;
        FragmentActivity r9 = r8;
    L26:
        ChatShareBottomComponent r10 = this.this$0;
        int r11 = ChatShareBottomComponent.R;
        boolean r12 = r10.W3().g().C();
        h r13 = new h(this.this$0.h(), this.this$0.E3(), null, null, null, null, ChatShareBottomComponent.z3(this.this$0), null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this.this$0.c4(), null, null, null, false, null, null, null, null, -132, -1, 1021);
        Fragment r14 = s1a.a.c(this.this$0);
        if ((r14 instanceof e) == false) goto L29;
        r4 = (e) r14;
    L29:
        r7.j(r9, new com.larus.bmhome.share.panel.e(r12, null, r13, r4, false, null, 202), r6);
        return Unit.INSTANCE;
    L25:
        r9 = null;
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r90);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        DialogFragment r16 = this.this$0.p;
        if (r16 == null) goto L11;
        INVOKEVIRTUAL_com_larus_bmhome_chat_component_share_ChatShareBottomComponent$shareSelectedMessagesAsLongImage$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(r16);
    L11:
        this.this$0.e4().exitSelectMode();
        ChatShareBottomComponent r17 = this.this$0;
        Bitmap r18 = this.$bitmap;
        SaveMessageShareInfo r19 = this.$shareInfo;
        if (r19 == null) goto L14;
        String r20 = r19.getShareUrl();
    L15:
        String r21 = ShareServiceDelegate.b.p(s1a.a.c(this.this$0).getContext(), this.this$0.E3());
        String r22 = s1a.a.c(this.this$0).getString(2131909359);
        this.L$0 = r15;
        this.label = 1;
        r5 = ChatShareBottomComponent.m3(r17, r18, r20, r21, r22);
        if (r5 != r1) goto L18;
        return r1;
    L14:
        r20 = null;
        goto L15
    }
}
