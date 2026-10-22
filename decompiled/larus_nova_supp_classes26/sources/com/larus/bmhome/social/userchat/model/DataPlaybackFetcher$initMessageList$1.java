package com.larus.bmhome.social.userchat.model;

import com.google.gson.Gson;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.DataPlaybackFetcher$initMessageList$1", f = "DataPlaybackFetcher.kt", i = {}, l = {86, 94, 100}, m = "invokeSuspend", n = {}, s = {})
final class DataPlaybackFetcher$initMessageList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<Message>, Unit> $callback;
    final /* synthetic */ String $fromDate;
    final /* synthetic */ List<Message> $playbackList;
    final /* synthetic */ List<List<String>> $sublist;
    final /* synthetic */ String $toDate;
    Object L$0;
    int label;
    final /* synthetic */ a0 this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.social.userchat.model.DataPlaybackFetcher$initMessageList$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.userchat.model.DataPlaybackFetcher$initMessageList$1$1", f = "DataPlaybackFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            t19.s.j(t19.s.a, AppHost.a.getApplication(), "接口错误", null, false, 28);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.social.userchat.model.DataPlaybackFetcher$initMessageList$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.userchat.model.DataPlaybackFetcher$initMessageList$1$2", f = "DataPlaybackFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<List<Message>, Unit> $callback;
        final /* synthetic */ List<Message> $playbackList;
        int label;
        final /* synthetic */ a0 this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super List<Message>, Unit> r1, a0 r2, List<Message> r3, Continuation<? super AnonymousClass2> r4) {
            this.$callback = r1;
            this.this$0 = r2;
            this.$playbackList = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$callback, this.this$0, this.$playbackList, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r55) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L21;
            ResultKt.throwOnFailure(r55);
            Function1<List<Message>, Unit> r1 = this.$callback;
            if (r1 == null) goto L19;
            a0 r2 = this.this$0;
            List<Message> r3 = this.$playbackList;
            r2.getClass();
            ArrayList r4 = new ArrayList();
            int r5 = r3.size();
            String r6 = AccountService.a.getUserId();
            Iterator<T> r7 = r3.iterator();
            int r8 = 0;
        L8:
            if (r7.hasNext() == false) goto L17;
            Object r9 = r7.next();
            int r10 = r8 + 1;
            if (r8 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            Message r11 = (Message) r9;
            String r25 = "UUID.randomUUID()" + r8;
            long r26 = ((long) r5) - ((long) r8);
            String r24 = "UUID.randomUUID()" + r8;
            if (r11.getUserType() != 1) goto L15;
            String r12 = r6;
        L16:
            r4.add(Message.copy$default(r11, null, null, r12, 0, 21, null, 0, false, null, null, null, null, null, null, r24, r25, r26, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -114709, 31, null));
            r8 = r10;
            goto L8
        L15:
            r12 = "";
            goto L16
        L17:
            r1.invoke(r4);
        L19:
            return Unit.INSTANCE;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataPlaybackFetcher$initMessageList$1(List<? extends List<String>> r1, a0 r2, String r3, String r4, List<Message> r5, Function1<? super List<Message>, Unit> r6, Continuation<? super DataPlaybackFetcher$initMessageList$1> r7) {
        this.$sublist = r1;
        this.this$0 = r2;
        this.$fromDate = r3;
        this.$toDate = r4;
        this.$playbackList = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DataPlaybackFetcher$initMessageList$1(this.$sublist, this.this$0, this.$fromDate, this.$toDate, this.$playbackList, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r6 = 1;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r22);
    L59:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Iterator<List<String>> r3 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r22);
        DataPlaybackFetcher$initMessageList$1 r15 = this;
    L54:
        r6 = 1;
    L15:
        if (r3.hasNext() == false) goto L55;
        List<String> r8 = r3.next();
        a0 r9 = r15.this$0;
        String r10 = r15.$fromDate;
        String r11 = r15.$toDate;
        r15.L$0 = r3;
        r15.label = r6;
        r9.getClass();
        JSONObject r14 = new JSONObject();
        JSONArray r7 = new JSONArray();
        Iterator<T> r12 = r8.iterator();
    L18:
        if (r12.hasNext() == false) goto L20;
        r7.put((String) r12.next());
        goto L18
    L20:
        Unit r4 = Unit.INSTANCE;
        r14.put("encryption_message_id_list", r7);
        r14.put("from_date", r10);
        r14.put("to_date", r11);
        r14.put(MusicAppletPage.KEY_SOURCE, "app");
        DataPlaybackFetcher$initMessageList$1 r5 = r15;
        Object r13 = HttpExtKt.k("Basic", CloudTestResponse.class, "/alice/message/session_playback", r14, null, null, true, null, null, null, r5, 944);
        if (r13 != r0) goto L23;
        return r0;
    L23:
        r15 = r5;
    L12:
        Iterator<List<String>> r16 = r3;
        Object r17 = r0;
        com.larus.network.http.y r18 = (com.larus.network.http.a) r13;
        FLogger r1 = FLogger.a;
        String r19 = com.larus.network.http.d.a;
        r1.d("CloudTest", "DataPlaybackFetcher fetchMessageList result " + ((com.larus.network.http.a) r18).b);
        if ((r18 instanceof com.larus.network.http.y) == false) goto L49;
        a0 r20 = r15.this$0;
        CloudTestResponse r21 = (CloudTestResponse) ((com.larus.network.http.a) r18).b;
        if (r21 == null) goto L29;
        String r23 = r21.getData();
    L30:
        r20.getClass();
        int r24 = 0;
        if (r23 != null) goto L33;
    L36:
        boolean r25 = true;
    L37:
        if (r25 == false) goto L39;
        List r26 = CollectionsKt.emptyList();
    L47:
        r15.$playbackList.addAll(r26);
        goto L49
    L39:
        ArrayList r27 = new ArrayList();
        JSONArray r110 = new JSONArray(r23);     // Catch: Exception -> L44
        int r28 = r110.length();     // Catch: Exception -> L44
    L41:
        if (r24 >= r28) goto L46;
        Message r111 = (Message) new Gson().fromJson(r110.get(r24).toString(), Message.class);     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L44
        r27.add(r111);     // Catch: Exception -> L44
        r24 = r24 + 1;
    L46:
        r26 = r27;
    L44:
        e = move-exception;
        FLogger r29 = FLogger.a;
        String r112 = com.larus.network.http.d.a;
        r29.d("CloudTest", "tryParseMessage fail " + u0.a(e));
        goto L46
    L33:
        if (r23.length() == 0) goto L36;
        r25 = false;
        goto L37
    L29:
        r23 = null;
    L49:
        if ((r18 instanceof com.larus.network.http.f) == false) goto L53;
        FLogger r30 = FLogger.a;
        String r31 = com.larus.network.http.d.a;
        r30.d("CloudTest", "DataPlaybackFetcher Fail " + ((com.larus.network.http.a) ((com.larus.network.http.f) r18)).b);
        MainCoroutineDispatcher r32 = Dispatchers.getMain();
        AnonymousClass1 r33 = new AnonymousClass1(null);
        r15.L$0 = r16;
        r15.label = 2;
        if (BuildersKt.withContext(r32, r33, r15) != r17) goto L53;
        return r17;
    L53:
        r0 = r17;
        r3 = r16;
        goto L54
    L62:
        r0 = r17;
        r3 = r16;
        goto L54
    L55:
        DataPlaybackFetcher$initMessageList$1 r34 = r15;
        FLogger r35 = FLogger.a;
        String r36 = com.larus.network.http.d.a;
        r35.d("CloudTest", "DataPlaybackFetcher Success playbackList " + r34.$playbackList);
        MainCoroutineDispatcher r37 = Dispatchers.getMain();
        AnonymousClass2 r38 = new AnonymousClass2(r34.$callback, r34.this$0, r34.$playbackList, null);
        r34.L$0 = null;
        r34.label = 3;
        if (BuildersKt.withContext(r37, r38, r34) != r0) goto L59;
        return r0;
    L11:
        r3 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r22);
        r13 = r22;
        r15 = this;
        goto L12
    L13:
        ResultKt.throwOnFailure(r22);
        FLogger r39 = FLogger.a;
        String r40 = com.larus.network.http.d.a;
        r39.d("CloudTest", "DataPlaybackFetcher  initMessageList sublist=  " + this.$sublist + ' ');
        r3 = this.$sublist.iterator();
        r15 = this;
        goto L15
    }
}
