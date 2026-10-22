package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.content.Context;
import android.view.View;
import androidx.collection.LruCache;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.answeraction.RegenInstructionPanel;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.ActionCreator$handleInstructionResult$1", f = "ActionCreator.kt", i = {}, l = {830}, m = "invokeSuspend", n = {}, s = {})
final class ActionCreator$handleInstructionResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Long> $chatKey;
    final /* synthetic */ Message $msg;
    final /* synthetic */ RegenInstructionPanel $panel;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ z this$0;

    public ActionCreator$handleInstructionResult$1(RegenInstructionPanel r1, z r2, View r3, Message r4, Function0<Long> r5, Continuation<? super ActionCreator$handleInstructionResult$1> r6) {
        this.$panel = r1;
        this.this$0 = r2;
        this.$view = r3;
        this.$msg = r4;
        this.$chatKey = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ActionCreator$handleInstructionResult$1(this.$panel, this.this$0, this.$view, this.$msg, this.$chatKey, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L11:
        com.larus.bmhome.chat.layout.holder.answeraction.e r16 = (com.larus.bmhome.chat.layout.holder.answeraction.e) r15;
        if (r16 != null) goto L16;
        return Unit.INSTANCE;
    L16:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L19;
        z r17 = this.this$0;
        final Context r3 = this.$view.getContext();
        int r4 = z.g;
        r17.getClass();
        com.larus.utils.l0.b(new a(r3));
        return Unit.INSTANCE;
    L19:
        com.larus.bmhome.actionbar.model.r r5 = com.larus.bmhome.actionbar.util.h.a(this.$msg);
        Integer r6 = null;
        if ((r16 instanceof com.larus.bmhome.chat.layout.holder.answeraction.b) == false) goto L41;
        com.larus.bmhome.chat.layout.holder.answeraction.b r18 = (com.larus.bmhome.chat.layout.holder.answeraction.b) r16;
        String r7 = r18.a.getRegenInstruction();
        LruCache r8 = ko8.a.a;
        Message r9 = this.$msg;
        long r10 = ((Number) this.$chatKey.invoke()).longValue();
        if (r7 != null) goto L24;
        String r11 = "";
    L25:
        if (r5 == null) goto L27;
        String r12 = r5.g;
    L28:
        if (r5 == null) goto L30;
        r6 = r5.a;
    L30:
        Intrinsics.checkNotNullParameter(r9, "message");
        Intrinsics.checkNotNullParameter(r11, "regenInstruction");
        IAIChatControlTraceService.a.Ba(r9, r10, r11, r12, r6);
        if (r7 != null) goto L33;
    L36:
        if (r2 == false) goto L39;
        FLogger.a.d("ActionCreator", "regenInstruction is null, msgId: " + this.$msg.getMessageId() + ", instruction: " + r18.a);
        return Unit.INSTANCE;
    L39:
        z r13 = this.this$0;
        Message r14 = this.$msg;
        long r19 = ((Number) this.$chatKey.invoke()).longValue();
        String r110 = r18.a.getRegenInstruction();
        int r20 = z.g;
        r13.g(r14, r19, r110);
    L51:
        return Unit.INSTANCE;
    L33:
        if (r7.length() == 0) goto L36;
        r2 = false;
        goto L36
    L27:
        r12 = null;
        goto L28
    L24:
        r11 = r7;
        goto L25
    L41:
        if ((r16 instanceof com.larus.bmhome.chat.layout.holder.answeraction.a) == false) goto L53;
        LruCache r111 = ko8.a.a;
        Message r21 = this.$msg;
        long r22 = ((Number) this.$chatKey.invoke()).longValue();
        if (r5 == null) goto L45;
        String r112 = r5.g;
    L46:
        if (r5 == null) goto L48;
        Integer r113 = r5.a;
    L49:
        Intrinsics.checkNotNullParameter(r21, "message");
        Intrinsics.checkNotNullParameter("default", "regenInstruction");
        IAIChatControlTraceService.a.Ba(r21, r22, "default", r112, r113);
        z r114 = this.this$0;
        Message r23 = this.$msg;
        long r24 = ((Number) this.$chatKey.invoke()).longValue();
        int r25 = z.g;
        r114.g(r23, r24, null);
        goto L51
    L48:
        r113 = null;
        goto L49
    L45:
        r112 = null;
        goto L46
    L53:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        RegenInstructionPanel r115 = this.$panel;
        this.label = 1;
        r15 = r115.a(this);
        if (r15 != r0) goto L11;
        return r0;
    }
}
