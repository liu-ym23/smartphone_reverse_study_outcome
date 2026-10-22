package com.larus.bmhome.chat.map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.cache.DiskCache;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.map.PoiRouteStore$readPolylineByMessageId$1", f = "PoiRouteStore.kt", i = {0, 1}, l = {MessageCellStateTransformerType.SUMMARY_CARD, MessageCellStateTransformerType.DEEP_SEARCH_TEXT}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240", "polylineOptions"}, s = {"L$0", "L$0"})
final class PoiRouteStore$readPolylineByMessageId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<wq9.a>, Unit> $callback;
    final /* synthetic */ String $messageId;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.map.PoiRouteStore$readPolylineByMessageId$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.map.PoiRouteStore$readPolylineByMessageId$1$1", f = "PoiRouteStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<List<wq9.a>, Unit> $callback;
        final /* synthetic */ List<wq9.a> $polylineOptions;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super List<wq9.a>, Unit> r1, List<wq9.a> r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$polylineOptions = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$polylineOptions, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$callback.invoke(this.$polylineOptions);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/map/PoiRouteStore$readPolylineByMessageId$1$polylineOptions$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/platform/model/map/FlowLatLng;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<List<wq9.a>> {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PoiRouteStore$readPolylineByMessageId$1(String r1, Function1<? super List<wq9.a>, Unit> r2, Continuation<? super PoiRouteStore$readPolylineByMessageId$1> r3) {
        this.$messageId = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PoiRouteStore$readPolylineByMessageId$1(this.$messageId, this.$callback, r4);
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
        boolean r3 = true;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        List<wq9.a> r2 = (List) this.L$0;
        ResultKt.throwOnFailure(r7);
    L34:
        Map<String, List<wq9.a>> r8 = s.d;
        String r4 = this.$messageId;
        if (r2 == null) goto L37;
        r8.put(r4, r2);
        return Unit.INSTANCE;
    L37:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Gson r5 = (Gson) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L25
    L16:
        String r9 = (String) r7;     // Catch: Throwable -> L25
        if (r9.length() == 0) goto L20;
        r3 = false;
    L20:
        if (r3 == true) goto L22;
        Object r10 = Result.constructor-impl((List) r5.fromJson(r9, new a().getType()));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r10) == false) goto L30;
        r10 = null;
    L30:
        List<wq9.a> r11 = (List) r10;
        FLogger.a.d("PoiRouteStore", "[readPolylineByMessageId] from disk with messageId:" + this.$messageId);
        MainCoroutineDispatcher r6 = Dispatchers.getMain();
        AnonymousClass1 r12 = new AnonymousClass1(this.$callback, r11, null);
        this.L$0 = r11;
        this.label = 2;
        if (BuildersKt.withContext(r6, r12, this) != r0) goto L33;
        return r0;
    L33:
        r2 = r11;
        goto L34
    L22:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r7);
        r5 = s.a;
        String r13 = this.$messageId;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L25
        DiskCache r15 = s.c;     // Catch: Throwable -> L25
        this.L$0 = r5;     // Catch: Throwable -> L25
        this.label = 1;     // Catch: Throwable -> L25
        r7 = r15.c(r13, this);     // Catch: Throwable -> L25
        if (r7 != r0) goto L16;
        return r0;
    L25:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
