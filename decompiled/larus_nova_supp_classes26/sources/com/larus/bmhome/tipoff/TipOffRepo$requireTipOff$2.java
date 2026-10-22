package com.larus.bmhome.tipoff;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;
import tx9.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.tipoff.TipOffRepo$requireTipOff$2", f = "TipOffRepo.kt", i = {1}, l = {32, 54}, m = "invokeSuspend", n = {"success"}, s = {"I$0"})
public final class TipOffRepo$requireTipOff$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<String> $batchIds;
    final /* synthetic */ Function1<Integer, Unit> $callback;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $entityId;
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ String $reasonDetail;
    final /* synthetic */ ArrayList<Integer> $reasonIds;
    final /* synthetic */ int $reportSource;
    final /* synthetic */ int $reportType;
    final /* synthetic */ String $serverIndex;
    int I$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.tipoff.TipOffRepo$requireTipOff$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.tipoff.TipOffRepo$requireTipOff$2$1", f = "TipOffRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Integer, Unit> $callback;
        final /* synthetic */ com.larus.network.http.a<Object> $resultAsync;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(com.larus.network.http.a<? extends Object> r1, Function1<? super Integer, Unit> r2, Continuation<? super AnonymousClass1> r3) {
            this.$resultAsync = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$resultAsync, this.$callback, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r4);
            y r5 = this.$resultAsync;
            if ((r5 instanceof y) == false) goto L11;
            Function1<Integer, Unit> r0 = this.$callback;
            Long r6 = r5.g;
            if (r6 == null) goto L9;
            int r7 = (int) r6.longValue();
        L10:
            r0.invoke(Boxing.boxInt(r7));
            goto L11
        L9:
            r7 = 0;
        L11:
            com.larus.network.http.f r8 = this.$resultAsync;
            if ((r8 instanceof com.larus.network.http.f) == false) goto L15;
            this.$callback.invoke(Boxing.boxInt((int) r8.d.getCode()));
        L15:
            return Unit.INSTANCE;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TipOffRepo$requireTipOff$2(String r1, String r2, int r3, ArrayList<Integer> r4, String r5, String r6, int r7, List<String> r8, Map<String, String> r9, Function1<? super Integer, Unit> r10, Continuation<? super TipOffRepo$requireTipOff$2> r11) {
        this.$conversationId = r1;
        this.$entityId = r2;
        this.$reportType = r3;
        this.$reasonIds = r4;
        this.$reasonDetail = r5;
        this.$serverIndex = r6;
        this.$reportSource = r7;
        this.$batchIds = r8;
        this.$extra = r9;
        this.$callback = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new TipOffRepo$requireTipOff$2(this.$conversationId, this.$entityId, this.$reportType, this.$reasonIds, this.$reasonDetail, this.$serverIndex, this.$reportSource, this.$batchIds, this.$extra, this.$callback, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        int r1 = this.I$0;
        ResultKt.throwOnFailure(r17);
    L22:
        String r2 = this.$conversationId;
        String r3 = this.$entityId;
        if (r1 == 0) goto L25;
        boolean r4 = true;
    L26:
        z1.a(r2, r3, "tipoff", Boxing.boxBoolean(r4));
        if (r1 == 0) goto L29;
        boolean r15 = true;
    L31:
        return Boxing.boxBoolean(r15);
    L29:
        r15 = false;
        goto L31
    L25:
        r4 = false;
        goto L26
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r17);
        Object r5 = r17;
    L18:
        com.larus.network.http.a r6 = (com.larus.network.http.a) r5;
        FLogger.a.d("RESULTASYNC", "RESULT ASYNC " + r6);
        boolean r7 = r6 instanceof y;
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass1 r9 = new AnonymousClass1(r6, this.$callback, null);
        this.I$0 = r7 ? 1 : 0;
        this.label = 2;
        if (BuildersKt.withContext(r8, r9, this) != r13) goto L21;
        return r13;
    L21:
        r1 = r7 ? 1 : 0;
        goto L22
    L10:
        ResultKt.throwOnFailure(r17);
        JSONObject r10 = new JSONObject();
        int r11 = this.$reportType;
        String r12 = this.$entityId;
        ArrayList<Integer> r14 = this.$reasonIds;
        String r16 = this.$reasonDetail;
        String r18 = this.$serverIndex;
        String r19 = this.$conversationId;
        int r110 = this.$reportSource;
        List<String> r111 = this.$batchIds;
        Map<String, String> r112 = this.$extra;
        r10.put("report_type", r11);
        r10.put("entity_id", r12);
        r10.put("reason_ids", new JSONArray(r14));
        r10.put("reason_detail", r16);
        r10.put("index_in_conversation", r18);
        r10.put(MusicAppletPage.KEY_CONVERSATION_ID, r19);
        r10.put("report_source", r110);
        if (r111 == null) goto L13;
        r10.put("batch_message_ids", new JSONArray(r111));
    L13:
        if (r112 == null) goto L15;
        r10.put("extra", new JSONObject(r112));
    L15:
        Unit r20 = Unit.INSTANCE;
        this.label = 1;
        r5 = HttpExtKt.k("Social", Object.class, "/alice/report/create", r10, null, null, false, null, null, null, this, 1008);
        if (r5 != r13) goto L18;
        return r13;
    }
}
