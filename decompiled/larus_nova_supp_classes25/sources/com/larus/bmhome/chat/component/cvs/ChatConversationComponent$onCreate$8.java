package com.larus.bmhome.chat.component.cvs;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onCreate$8", f = "ChatConversationComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$onCreate$8 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ ChatConversationComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onCreate$8$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onCreate$8$1", f = "ChatConversationComponent.kt", i = {}, l = {237, 240}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ String $pushContentId;
        final /* synthetic */ String $ugSchema;
        int label;
        final /* synthetic */ ChatConversationComponent this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onCreate$8$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onCreate$8$1$1", f = "ChatConversationComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $botId;
            final /* synthetic */ String $cid;
            final /* synthetic */ String $pushContentId;
            final /* synthetic */ String $ugSchema;
            int label;
            final /* synthetic */ ChatConversationComponent this$0;

            public C00561(String r1, ChatConversationComponent r2, String r3, String r4, String r5, Continuation<? super C00561> r6) {
                this.$cid = r1;
                this.this$0 = r2;
                this.$botId = r3;
                this.$pushContentId = r4;
                this.$ugSchema = r5;
                super(2, r6);
            }

            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                return new C00561(this.$cid, this.this$0, this.$botId, this.$pushContentId, this.$ugSchema, r9);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L14;
                ResultKt.throwOnFailure(r10);
                if (this.$cid.length() <= 0) goto L7;
                boolean r11 = true;
            L8:
                if (r11 == false) goto L10;
                ChatConversationComponent r12 = this.this$0;
                int r0 = ChatConversationComponent.r;
                ChatConversationVM.handleConversationIdInit$default(r12.F2(), this.$cid, this.$botId, null, false, null, 28, null);
            L12:
                return Unit.INSTANCE;
            L10:
                ChatConversationComponent r13 = this.this$0;
                int r1 = ChatConversationComponent.r;
                r13.F2().handleConversationIdEmpty(this.$pushContentId, this.$ugSchema);
                goto L12
            L7:
                r11 = false;
                goto L8
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(String r1, ChatConversationComponent r2, String r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.$botId = r1;
            this.this$0 = r2;
            this.$pushContentId = r3;
            this.$ugSchema = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$botId, this.this$0, this.$pushContentId, this.$ugSchema, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r11);
        L23:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L13:
            e r12 = (e) r11;
            if (r12 == null) goto L16;
            String r13 = r12.a;
        L17:
            if (r13 != null) goto L19;
            r13 = "";
        L19:
            String r4 = r13;
            MainCoroutineDispatcher r14 = Dispatchers.getMain();
            C00561 r2 = new C00561(r4, this.this$0, this.$botId, this.$pushContentId, this.$ugSchema, null);
            this.label = 2;
            if (BuildersKt.withContext(r14, r2, this) != r0) goto L23;
            return r0;
        L16:
            r13 = null;
            goto L17
        L10:
            ResultKt.throwOnFailure(r11);
            RepoDispatcher.a.getClass();
            ConversationRepo r15 = RepoDispatcher.f;
            String r3 = this.$botId;
            this.label = 1;
            r11 = r15.a(r3, this);
            if (r11 != r0) goto L13;
            return r0;
        }
    }

    public ChatConversationComponent$onCreate$8(ChatConversationComponent r1, Continuation<? super ChatConversationComponent$onCreate$8> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatConversationComponent$onCreate$8 r0 = new ChatConversationComponent$onCreate$8(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r18);
        if (this.Z$0 == false) goto L37;
        ChatConversationComponent r1 = this.this$0;
        boolean r3 = false;
        if (r1.q == true) goto L35;
        r1.q = true;
        de8.c r2 = r1.f1();
        String r4 = null;
        if (r2 == null) goto L13;
        Bundle r5 = r2.b;
        if (r5 == null) goto L13;
        String r6 = r5.getString("argPushContentId", "");
    L14:
        if (r6 != null) goto L16;
        String r9 = "";
    L17:
        de8.c r7 = this.this$0.f1();
        if (r7 == null) goto L20;
        String r10 = r7.r();
    L21:
        de8.c r8 = this.this$0.f1();
        if (r8 == null) goto L24;
        r4 = r8.f();
    L24:
        if (r4 != null) goto L26;
        String r11 = "";
    L28:
        if (r11.length() <= 0) goto L30;
        r3 = true;
    L30:
        if (r3 == false) goto L33;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), null, new AnonymousClass1(r11, this.this$0, r9, r10, null), 2, null);
        return Unit.INSTANCE;
    L33:
        this.this$0.F2().handleConversationIdEmpty(r9, r10);
        return Unit.INSTANCE;
    L26:
        r11 = r4;
        goto L28
    L20:
        r10 = null;
        goto L21
    L16:
        r9 = r6;
    L13:
        r6 = null;
        goto L14
    L35:
        FLogger.a.i("ChatConversationComponent", "conversation isNull performBack");
        this.this$0.N2(false);
    L37:
        return Unit.INSTANCE;
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
