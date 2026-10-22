package com.larus.bmhome.chat.component.cvs;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONException;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onConversationDeletedOrInvalid$1", f = "ChatConversationComponent.kt", i = {}, l = {294, 298, 304}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$onConversationDeletedOrInvalid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $delete;
    int label;
    final /* synthetic */ ChatConversationComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onConversationDeletedOrInvalid$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onConversationDeletedOrInvalid$1$1", f = "ChatConversationComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e $latestMainCvs;
        int label;
        final /* synthetic */ ChatConversationComponent this$0;

        public AnonymousClass1(e r1, ChatConversationComponent r2, Continuation<? super AnonymousClass1> r3) {
            this.$latestMainCvs = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$latestMainCvs, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r5);
            AuthModelDelegate.b.f(this.$latestMainCvs);
            ChatConversationComponent r6 = this.this$0;
            int r0 = ChatConversationComponent.r;
            r6.L2(true);
            e r7 = this.$latestMainCvs;
            if (r7 == null) goto L7;
            String r8 = r7.a;
        L8:
            String r1 = this.this$0.F2().getState().getConversationId();
            JSONObject r2 = new JSONObject();
            Intrinsics.checkNotNullParameter(r2, "params");
        L15:
            e = move-exception;
            FLogger.a.e("MinorEventHelper", "error in MinorEventHelper defaultTrendingPlaceholderShow " + e.getLocalizedMessage());
        L17:
            TrackParams r9 = new TrackParams().merge(r2);
            by7.a r3 = new by7.a("minor_page_deterioration");
            r3.a.merge(r9);
            r3.b();
            return Unit.INSTANCE;
        L10:
            if (o0.d(r8) == false) goto L12;
        L13:
            r2.put("op", "mix");     // Catch: JSONException -> L15
            goto L17
        L12:
            if (o0.d(r1) == false) goto L17;
        L7:
            r8 = null;
            goto L8
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onConversationDeletedOrInvalid$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onConversationDeletedOrInvalid$1$2", f = "ChatConversationComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $delete;
        int label;
        final /* synthetic */ ChatConversationComponent this$0;

        public AnonymousClass2(ChatConversationComponent r1, boolean r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$delete = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$delete, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            ChatConversationComponent r4 = this.this$0;
            boolean r0 = this.$delete;
            int r1 = ChatConversationComponent.r;
            r4.P2(r0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatConversationComponent$onConversationDeletedOrInvalid$1(ChatConversationComponent r1, boolean r2, Continuation<? super ChatConversationComponent$onConversationDeletedOrInvalid$1> r3) {
        this.this$0 = r1;
        this.$delete = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatConversationComponent$onConversationDeletedOrInvalid$1(this.this$0, this.$delete, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L32:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r10);
    L17:
        e r11 = (e) r10;
        FLogger r2 = FLogger.a;
        StringBuilder r4 = new StringBuilder("latestMainCvs = ");
        if (r11 == null) goto L20;
        String r6 = r11.a;
    L21:
        r4.append(r6);
        r2.e("ChatConversationComponent", r4.toString());
        if (r11 == null) goto L28;
        String r5 = r11.a;
        ChatConversationComponent r7 = this.this$0;
        int r8 = ChatConversationComponent.r;
        if (Intrinsics.areEqual(r5, r7.F2().getState().getConversationId()) == true) goto L28;
        r2.e("ChatConversationComponent", "current cvsId is != SDK, replace it, current = " + this.this$0.F2().getState().getConversationId() + " SDK = " + r11);
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        AnonymousClass1 r9 = new AnonymousClass1(r11, this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r3, r9, this) != r0) goto L32;
        return r0;
    L28:
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AnonymousClass2 r13 = new AnonymousClass2(this.this$0, this.$delete, null);
        this.label = 3;
        if (BuildersKt.withContext(r12, r13, this) != r0) goto L32;
        return r0;
    L20:
        r6 = null;
        goto L21
    L12:
        ResultKt.throwOnFailure(r10);
        ChatConversationComponent r14 = this.this$0;
        this.label = 1;
        int r15 = ChatConversationComponent.r;
        r14.getClass();
        kotlinx.coroutines.j r16 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r16.C();
        com.larus.im.d.d().getMainConversation(new k(r16));
        r10 = r16.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r10 != r0) goto L17;
        return r0;
    }
}
