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
@DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$trackChangeUserNickName$1", f = "BotNickNameEditDialog.kt", i = {0, 1, 1}, l = {409, 410}, m = "invokeSuspend", n = {"it", "it", "chatConversationInfo"}, s = {"L$2", "L$2", "L$3"})
final class BotNickNameEditDialog$trackChangeUserNickName$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $nickName;
    final /* synthetic */ boolean $overallChange;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ BotNickNameEditDialog this$0;

    public BotNickNameEditDialog$trackChangeUserNickName$1(BotNickNameEditDialog r1, String r2, boolean r3, boolean r4, Continuation<? super BotNickNameEditDialog$trackChangeUserNickName$1> r5) {
        this.this$0 = r1;
        this.$nickName = r2;
        this.$overallChange = r3;
        this.$isSuccess = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BotNickNameEditDialog$trackChangeUserNickName$1(this.this$0, this.$nickName, this.$overallChange, this.$isSuccess, r8);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        boolean r2 = this.Z$1;
        boolean r3 = this.Z$0;
        wc9.e r4 = (wc9.e) this.L$3;
        String r5 = (String) this.L$2;
        String r6 = (String) this.L$1;
        BotNickNameEditDialog r7 = (BotNickNameEditDialog) this.L$0;
        ResultKt.throwOnFailure(r15);
    L25:
        BotModel r16 = (BotModel) r15;
        String r8 = null;
        if (r4 == null) goto L28;
        Integer r9 = r4.v;
    L29:
        if (r16 == null) goto L31;
        Integer r10 = r16.getBotType();
    L32:
        if (r16 == null) goto L36;
        BotCreatorInfo r17 = r16.getBotCreatorInfo();
        if (r17 == null) goto L36;
        String r18 = r17.getId();
    L37:
        boolean r19 = Intrinsics.areEqual(r18, AccountService.a.getUserId());
        r7.getClass();
        String r110 = BotNickNameEditDialog.U90(r9, r10, r19);
        if (r4 == null) goto L40;
        r8 = r4.a;
    L40:
        String r11 = r7.m;
        String r12 = "1";
        if (r3 == false) goto L43;
        Object r13 = "1";
    L44:
        if (r2 == true) goto L47;
        r12 = "0";
    L47:
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r5 != null) goto L64;
    L50:
        r14.put("bot_type", r110);     // Catch: JSONException -> L59
        if (r8 == null) goto L53;
        r14.put("conversation_id", r8);     // Catch: JSONException -> L59
    L53:
        if (r11 == null) goto L55;
        r14.put("current_page", r11);     // Catch: JSONException -> L59
    L55:
        if (r6 == null) goto L57;
        r14.put("nickname", r6);     // Catch: JSONException -> L59
    L57:
        r14.put("overall_change", r13);     // Catch: JSONException -> L59
        r14.put("success", r12);     // Catch: JSONException -> L59
    L61:
        TrackParams r111 = new TrackParams().merge(r14);
        by7.a r20 = new by7.a("change_user_nickname");
        r20.a.merge(r111);
        r20.b();
    L63:
        return Unit.INSTANCE;
    L59:
        e = move-exception;
        FLogger.a.e("ChangeEventHelper", "error in ChangeEventHelper changeUserNickname " + e.getLocalizedMessage());
        goto L61
    L64:
        r14.put("bot_id", r5);     // Catch: JSONException -> L59
        goto L50
    L43:
        r13 = "0";
    L36:
        r18 = null;
        goto L37
    L31:
        r10 = null;
        goto L32
    L28:
        r9 = null;
        goto L29
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        boolean r21 = this.Z$1;
        boolean r22 = this.Z$0;
        String r23 = (String) this.L$2;
        String r24 = (String) this.L$1;
        BotNickNameEditDialog r25 = (BotNickNameEditDialog) this.L$0;
        ResultKt.throwOnFailure(r15);
    L16:
        wc9.e r112 = (wc9.e) r15;
        RepoDispatcher.a.getClass();
        BotRepo r26 = RepoDispatcher.g;
        if (r112 == null) goto L20;
        String r27 = r112.a;
        if (r27 == null) goto L20;
    L21:
        this.L$0 = r25;
        this.L$1 = r24;
        this.L$2 = r23;
        this.L$3 = r112;
        this.Z$0 = r22;
        this.Z$1 = r21;
        this.label = 2;
        Object r28 = r26.j1(r27, false, this);
        if (r28 != r0) goto L24;
        return r0;
    L24:
        r2 = r21;
        r3 = r22;
        r5 = r23;
        r6 = r24;
        r7 = r25;
        r4 = r112;
        r15 = r28;
    L20:
        r27 = "";
        goto L21
    L10:
        ResultKt.throwOnFailure(r15);
        BotNickNameEditDialog r113 = this.this$0;
        String r29 = r113.i;
        if (r29 == null) goto L63;
        String r114 = this.$nickName;
        boolean r115 = this.$overallChange;
        boolean r116 = this.$isSuccess;
        RepoDispatcher.a.getClass();
        ConversationRepo r30 = RepoDispatcher.f;
        this.L$0 = r113;
        this.L$1 = r114;
        this.L$2 = r29;
        this.Z$0 = r115;
        this.Z$1 = r116;
        this.label = 1;
        Object r31 = IConversationRepoService$a.c(r30, r29, false, null, this, 6);
        if (r31 != r0) goto L15;
        return r0;
    L15:
        r25 = r113;
        r23 = r29;
        r15 = r31;
        r24 = r114;
        r22 = r115;
        r21 = r116;
        goto L16
    }
}
