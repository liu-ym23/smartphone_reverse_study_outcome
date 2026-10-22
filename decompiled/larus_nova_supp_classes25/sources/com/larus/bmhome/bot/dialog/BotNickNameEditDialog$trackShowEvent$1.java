package com.larus.bmhome.bot.dialog;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$trackShowEvent$1", f = "BotNickNameEditDialog.kt", i = {0, 1, 1}, l = {154, 155}, m = "invokeSuspend", n = {"it", "it", "chatConversationInfo"}, s = {"L$1", "L$1", "L$2"})
final class BotNickNameEditDialog$trackShowEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BotNickNameEditDialog this$0;

    public BotNickNameEditDialog$trackShowEvent$1(BotNickNameEditDialog r1, Continuation<? super BotNickNameEditDialog$trackShowEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotNickNameEditDialog$trackShowEvent$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        wc9.e r2 = (wc9.e) this.L$2;
        String r3 = (String) this.L$1;
        BotNickNameEditDialog r4 = (BotNickNameEditDialog) this.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        BotModel r13 = (BotModel) r12;
        String r5 = null;
        if (r2 == null) goto L28;
        Integer r6 = r2.v;
    L29:
        if (r13 == null) goto L31;
        Integer r7 = r13.getBotType();
    L32:
        if (r13 == null) goto L36;
        BotCreatorInfo r14 = r13.getBotCreatorInfo();
        if (r14 == null) goto L36;
        String r15 = r14.getId();
    L37:
        boolean r16 = Intrinsics.areEqual(r15, AccountService.a.getUserId());
        r4.getClass();
        String r17 = BotNickNameEditDialog.U90(r6, r7, r16);
        if (r2 == null) goto L40;
        r5 = r2.a;
    L40:
        String r8 = r4.m;
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r3 != null) goto L54;
    L43:
        r9.put("bot_type", r17);     // Catch: JSONException -> L49
        if (r5 == null) goto L46;
        r9.put("conversation_id", r5);     // Catch: JSONException -> L49
    L46:
        if (r8 == null) goto L51;
        r9.put("current_page", r8);     // Catch: JSONException -> L49
    L49:
        e = move-exception;
        FLogger.a.e("PopupEventHelper", "error in PopupEventHelper popupChangename " + e.getLocalizedMessage());
    L51:
        TrackParams r18 = new TrackParams().merge(r9);
        by7.a r10 = new by7.a("popup_changename");
        r10.a.merge(r18);
        r10.b();
    L53:
        return Unit.INSTANCE;
    L54:
        r9.put("bot_id", r3);     // Catch: JSONException -> L49
    L36:
        r15 = null;
        goto L37
    L31:
        r7 = null;
        goto L32
    L28:
        r6 = null;
        goto L29
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r3 = (String) this.L$1;
        BotNickNameEditDialog r11 = (BotNickNameEditDialog) this.L$0;
        ResultKt.throwOnFailure(r12);
    L16:
        wc9.e r19 = (wc9.e) r12;
        RepoDispatcher.a.getClass();
        BotRepo r20 = RepoDispatcher.g;
        if (r19 == null) goto L20;
        String r21 = r19.a;
        if (r21 == null) goto L20;
    L21:
        this.L$0 = r11;
        this.L$1 = r3;
        this.L$2 = r19;
        this.label = 2;
        Object r22 = r20.j1(r21, false, this);
        if (r22 != r0) goto L24;
        return r0;
    L24:
        r2 = r19;
        r12 = r22;
        r4 = r11;
    L20:
        r21 = "";
        goto L21
    L10:
        ResultKt.throwOnFailure(r12);
        BotNickNameEditDialog r110 = this.this$0;
        r3 = r110.i;
        if (r3 == null) goto L53;
        RepoDispatcher.a.getClass();
        ConversationRepo r23 = RepoDispatcher.f;
        this.L$0 = r110;
        this.L$1 = r3;
        this.label = 1;
        Object r24 = IConversationRepoService$a.c(r23, r3, false, null, this, 6);
        if (r24 != r0) goto L15;
        return r0;
    L15:
        r11 = r110;
        r12 = r24;
        goto L16
    }
}
