package com.larus.bmhome.debug;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/debug/ChatDebugViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "messageDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getChatDataFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/bmhome/debug/ChatDebugViewModel$ChatData;", "messageId", "", "localMessageId", "Companion", "ChatData", "debug_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatDebugViewModel extends AndroidViewModel {
    public static final b Companion = null;
    public static final String TAG = "ChatDebugViewModel";
    private final ExecutorCoroutineDispatcher messageDispatcher;

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.bmhome.debug.ChatDebugViewModel$a$a, reason: collision with other inner class name */
        public static final class C0013a extends a {
            public final BotModel a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0013a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0013a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                BotModel r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "Bot(bot=" + this.a + ')';
            }

            public C0013a(BotModel r1) {
                this.a = r1;
            }
        }

        public static final class b extends a {
            public final wc9.e a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                wc9.e r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "Conversation(conversation=" + this.a + ')';
            }

            public b(wc9.e r1) {
                this.a = r1;
            }
        }

        public static final class c extends a {
            public final Message a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                Message r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "Message(message=" + this.a + ')';
            }

            public c(Message r1) {
                this.a = r1;
            }
        }

        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.debug.ChatDebugViewModel$getChatDataFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/bmhome/debug/ChatDebugViewModel$ChatData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.debug.ChatDebugViewModel$getChatDataFlow$1", f = "ChatDebugViewModel.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5}, l = {23, 24, 28, 29, 33, 35, 37}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "chatMessage", "$this$flow", "chatMessage", "cvsId", "$this$flow", "chatMessage", "cvsId", "chatConversation", "$this$flow", "$this$flow"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super a>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $localMessageId;
        final /* synthetic */ String $messageId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass1(String r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$messageId = r1;
            this.$localMessageId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$messageId, this.$localMessageId, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((FlowCollector) r1, (Continuation) r2);
        }

        public final Object invoke(FlowCollector<? super a> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r17) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean r1 = true;
            switch(this.label) {
                case 0: goto L13;
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r17);
        L66:
            return Unit.INSTANCE;
        L7:
            FlowCollector r0 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r17);
            FlowCollector r12 = r0;
            Object r2 = r17;
        L61:
            BotModel r3 = (BotModel) r2;
        L62:
            a.C0013a r4 = new a.C0013a(r3);
            this.L$0 = null;
            this.label = 7;
            if (r12.emit(r4, this) != r8) goto L66;
            return r8;
        L8:
            FlowCollector r5 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r17);
            r12 = r5;
            Object r6 = r17;
        L57:
            r3 = (BotModel) r6;
            goto L62
        L9:
            wc9.e r7 = (wc9.e) this.L$3;
            String r9 = (String) this.L$2;
            Message r10 = (Message) this.L$1;
            FlowCollector r11 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r17);
            r12 = r11;
        L43:
            if (r7 == null) goto L66;
            Integer r13 = r7.j;
            if (r13 == null) goto L66;
            if (r13.intValue() != 3) goto L66;
            if (r10.getUserType() != 2) goto L58;
            IBotRepoService r14 = RepoDispatcherDelegate.b.b();
            String r15 = r10.getSenderId();
            if (r15 != null) goto L54;
            r15 = "";
        L54:
            this.L$0 = r12;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 5;
            r6 = IBotRepoService.b.a(r14, r15, false, null, false, this, 30);
            if (r6 != r8) goto L57;
            return r8;
        L58:
            IBotRepoService r16 = RepoDispatcherDelegate.b.b();
            this.L$0 = r12;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 6;
            r2 = r16.j1(r9, false, this);
            if (r2 != r8) goto L61;
            return r8;
        L10:
            String r18 = (String) this.L$2;
            Message r19 = (Message) this.L$1;
            FlowCollector r20 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r17);
            Message r110 = r19;
            r9 = r18;
            Object r21 = r17;
        L39:
            r7 = (wc9.e) r21;
            a.b r22 = new a.b(r7);
            this.L$0 = r20;
            this.L$1 = r110;
            this.L$2 = r9;
            this.L$3 = r7;
            this.label = 4;
            if (r20.emit(r22, this) != r8) goto L42;
            return r8;
        L42:
            Message r111 = r110;
            r12 = r20;
            r10 = r111;
            goto L43
        L11:
            Message r23 = (Message) this.L$1;
            FlowCollector r24 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r17);
            r110 = r23;
            FlowCollector r112 = r24;
        L26:
            if (r110 == null) goto L28;
            String r113 = r110.getConversationId();
        L29:
            if (r113 != null) goto L31;
        L34:
            if (r1 == true) goto L66;
            IConversationRepoService r25 = RepoDispatcherDelegate.b.f();
            this.L$0 = r112;
            this.L$1 = r110;
            this.L$2 = r113;
            this.label = 3;
            r21 = IConversationRepoService.a.c(r25, r113, false, null, this, 6);
            if (r21 != r8) goto L38;
            return r8;
        L38:
            r20 = r112;
            r9 = r113;
            goto L39
        L31:
            if (StringsKt.isBlank(r113) == true) goto L34;
            r1 = false;
            goto L34
        L28:
            r113 = null;
            goto L29
        L12:
            FlowCollector r26 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r17);
            Object r27 = r17;
        L22:
            Message r28 = (Message) r27;
            a.c r29 = new a.c(r28);
            this.L$0 = r26;
            this.L$1 = r28;
            this.label = 2;
            if (r26.emit(r29, this) != r8) goto L25;
            return r8;
        L25:
            r112 = r26;
            r110 = r28;
            goto L26
        L13:
            ResultKt.throwOnFailure(r17);
            r26 = (FlowCollector) this.L$0;
            IChatRepoService r30 = RepoDispatcherDelegate.b.e();
            String r31 = this.$messageId;
            String r32 = this.$localMessageId;
            if (r31.length() != 0) goto L16;
            boolean r33 = true;
        L17:
            if (r33 == false) goto L19;
            r31 = r32;
        L19:
            this.L$0 = r26;
            this.label = 1;
            r27 = r30.E1(r31, this);
            if (r27 != r8) goto L22;
            return r8;
        L16:
            r33 = false;
            goto L17
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new b();
    }

    public ChatDebugViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.messageDispatcher = RepoDispatcherDelegate.b.g();
    }

    public final Flow<a> getChatDataFlow(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "localMessageId");
        return kotlinx.coroutines.flow.e.w(new c1(new AnonymousClass1(r3, r4, null)), this.messageDispatcher);
    }
}
