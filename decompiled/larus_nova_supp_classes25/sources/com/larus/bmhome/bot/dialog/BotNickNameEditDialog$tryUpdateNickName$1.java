package com.larus.bmhome.bot.dialog;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.f0;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.w;
import com.larus.network.http.y;
import com.larus.network.http.z;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$tryUpdateNickName$1", f = "BotNickNameEditDialog.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
public final class BotNickNameEditDialog$tryUpdateNickName$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nickName;
    int label;
    final /* synthetic */ BotNickNameEditDialog this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.bot.dialog.BotNickNameEditDialog$tryUpdateNickName$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$tryUpdateNickName$1$1", f = "BotNickNameEditDialog.kt", i = {}, l = {339, 348}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $nickName;
        int label;
        final /* synthetic */ BotNickNameEditDialog this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.bot.dialog.BotNickNameEditDialog$tryUpdateNickName$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$tryUpdateNickName$1$1$1", f = "BotNickNameEditDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ com.larus.network.http.a<BotNickNameEditDialog.b> $editNickNameRes;
            final /* synthetic */ String $nickName;
            int label;
            final /* synthetic */ BotNickNameEditDialog this$0;

            public C00381(com.larus.network.http.a<BotNickNameEditDialog.b> r1, BotNickNameEditDialog r2, String r3, Continuation<? super C00381> r4) {
                this.$editNickNameRes = r1;
                this.this$0 = r2;
                this.$nickName = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00381(this.$editNickNameRes, this.this$0, this.$nickName, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r7) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L44;
                ResultKt.throwOnFailure(r7);
                com.larus.network.http.a<BotNickNameEditDialog.b> r8 = this.$editNickNameRes;
                boolean r2 = true;
                if ((r8 instanceof y) == false) goto L24;
                String r9 = this.this$0.h;
                if (r9 == null) goto L9;
                final String r0 = this.$nickName;
                FLogger r3 = FLogger.a;
                int r4 = BotNickNameEditDialog.n;
                r3.d("BotNickNameEditDialog", "yyyy NickNameEditResultListener updateBotCallerName " + r9 + ' ' + r0);
                RepoDispatcher.a.getClass();
                RepoDispatcher.g.getClass();
                Intrinsics.checkNotNullParameter(r9, "botId");
                Intrinsics.checkNotNullParameter(r0, "callerName");
                com.larus.im.d.a().updateLocalBot(r9, new f0(r0), null);
            L9:
                BotNickNameEditDialog.b r10 = (BotNickNameEditDialog.b) ((com.larus.network.http.a) this.$editNickNameRes).b;
                if (r10 == null) goto L22;
                BotNickNameEditDialog r1 = this.this$0;
                String r5 = this.$nickName;
                String r6 = r10.a();
                if (r6 == null) goto L16;
                BotNickNameEditDialog.c r11 = r1.k;
                if (r11 == null) goto L16;
                r11.a(r5, r6);
            L16:
                Boolean r12 = r10.b();
                if (r12 != null) goto L19;
            L21:
                BotNickNameEditDialog.S90(r1, r5, Intrinsics.areEqual(r10.b(), Boxing.boxBoolean(true)), true);
                goto L22
            L19:
                if (r12.booleanValue() == false) goto L21;
                r1.getClass();
                com.larus.bmhome.bot.utils.b r13 = com.larus.bmhome.bot.utils.b.a;
                Intrinsics.checkNotNullParameter(r5, "newGlobalNickName");
                com.larus.bmhome.bot.utils.b.b = r5;
            L22:
                this.this$0.V90(false);
                this.this$0.hideKeyboard();
            L42:
                return Unit.INSTANCE;
            L24:
                if ((r8 instanceof com.larus.network.http.f) == false) goto L35;
                BotNickNameEditDialog r14 = this.this$0;
                int r15 = BotNickNameEditDialog.n;
                r14.V90(false);
                String r16 = this.$editNickNameRes.d.getMessage();
                if (r16 != null) goto L28;
            L31:
                if (r2 == true) goto L33;
                s r17 = s.a;
                FragmentActivity r18 = this.this$0.getActivity();
                r17.getClass();
                s.c(r18, r16);
            L33:
                BotNickNameEditDialog.S90(this.this$0, this.$nickName, false, false);
                goto L42
            L28:
                if (r16.length() == 0) goto L31;
                r2 = false;
                goto L31
            L35:
                if ((r8 instanceof w) == true) goto L42;
                if (Intrinsics.areEqual(r8, z.d) == true) goto L42;
                throw new NoWhenBranchMatchedException();
            L44:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(BotNickNameEditDialog r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$nickName = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$nickName, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            ResultKt.throwOnFailure(r16);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r16);
            Object r1 = r16;
        L13:
            MainCoroutineDispatcher r2 = Dispatchers.getMain();
            C00381 r3 = new C00381((com.larus.network.http.a) r1, this.this$0, this.$nickName, null);
            this.label = 2;
            if (BuildersKt.withContext(r2, r3, this) != r13) goto L17;
            return r13;
        L10:
            ResultKt.throwOnFailure(r16);
            JSONObject r4 = new JSONObject().put("bot_id", this.this$0.h).put("caller_name", this.$nickName).put("entity_id", AccountService.a.getUserId());
            this.label = 1;
            r1 = HttpExtKt.k("Social", BotNickNameEditDialog.b.class, "/alice/bot/update_caller_name", r4, null, null, false, null, null, null, this, 1008);
            if (r1 != r13) goto L13;
            return r13;
        }
    }

    public BotNickNameEditDialog$tryUpdateNickName$1(BotNickNameEditDialog r1, String r2, Continuation<? super BotNickNameEditDialog$tryUpdateNickName$1> r3) {
        this.this$0 = r1;
        this.$nickName = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotNickNameEditDialog$tryUpdateNickName$1(this.this$0, this.$nickName, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$nickName, null);
        this.label = 1;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
