package com.larus.dora.impl.core;

import com.google.gson.reflect.TypeToken;
import com.larus.network.http.HttpExtKt;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraConnectExt$postConnectedToNetwork$1", f = "DoraConnectExt.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, s = {})
final class DoraConnectExt$postConnectedToNetwork$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/network/http/HttpExtKt$httpPost2$2", "Lcom/google/gson/reflect/TypeToken;", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Object> {
        public a() {
        }
    }

    public DoraConnectExt$postConnectedToNetwork$1(Continuation<? super DoraConnectExt$postConnectedToNetwork$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraConnectExt$postConnectedToNetwork$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L13:
        g49.d.d("DoraConnectExt", "postConnectedToNetwork: response=" + ((com.larus.network.http.a) r12));     // Catch: Throwable -> L15
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L15
        Map r8 = MapsKt.emptyMap();     // Catch: Throwable -> L15
        Type r5 = new a().getType();     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r12 = HttpExtKt.m("Audio", r5, "/alice/audio/dora_libra_launch", r7, r8, false, this);     // Catch: Throwable -> L15
        if (r12 != r1) goto L13;
        return r1;
    L15:
        th = move-exception;
        g49.d.c("DoraConnectExt", "postConnectedToNetwork exception", th);
        goto L18
    }
}
