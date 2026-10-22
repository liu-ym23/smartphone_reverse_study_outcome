package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.forest.model.Response;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch$fetchGecko$2$job$1", f = "NativePrefetch.kt", i = {}, l = {243, 251, 256, 260}, m = "invokeSuspend", n = {}, s = {})
public final class NativePrefetch$fetchGecko$2$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Response $response;
    int label;
    final /* synthetic */ NativePrefetch$fetchGecko$2 this$0;

    public NativePrefetch$fetchGecko$2$job$1(NativePrefetch$fetchGecko$2 r1, Response r10, Continuation r11) {
        this.this$0 = r1;
        this.$response = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new NativePrefetch$fetchGecko$2$job$1(this.this$0, this.$response, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        if (r1 == 4) goto L13;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);     // Catch: JSONException -> L34
    L39:
    L38:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r10);
        goto L38
    L14:
        ResultKt.throwOnFailure(r10);
    L21:
        return Unit.INSTANCE;
    L15:
        ResultKt.throwOnFailure(r10);
        if (NativePrefetch.a(this.this$0.this$0, this.$response) == true) goto L22;
        Channel r11 = this.this$0.$channel;
        this.label = 1;
        if (r11.send(null, this) != r0) goto L21;
        return r0;
    L22:
        byte[] r12 = this.$response.j();
        if (r12 == null) goto L25;
        String r13 = new String(r12, Charset.forName("utf-8"));
    L26:
        ConcurrentHashMap<String, NativePrefetch> r14 = NativePrefetchUtil.a;
        NativePrefetchUtil.k("NativePrefetch", "gecko resp is " + r13);
        if (r13 != null) goto L31;
        int r15 = u.a;
        u.a(this.this$0.$configUrl, Boxing.boxInt(1002), "config is null", null);
        NativePrefetchUtil.k("NativePrefetch", "get from config error , json is null");
        Channel r16 = this.this$0.$channel;
        this.label = 2;
        if (r16.send(null, this) != r0) goto L38;
        return r0;
    L31:
        NativePrefetchUtil.k("NativePrefetch", "get from config success");     // Catch: JSONException -> L34
        JSONObject r17 = new JSONObject(r13);     // Catch: JSONException -> L34
        Channel r18 = this.this$0.$channel;     // Catch: JSONException -> L34
        this.label = 3;     // Catch: JSONException -> L34
        if (r18.send(r17, this) != r0) goto L39;
        return r0;
    L25:
        r13 = null;
    L34:
        int r19 = u.a;
        u.a(this.this$0.$configUrl, Boxing.boxInt(1003), "config is null", null);
        ConcurrentHashMap<String, NativePrefetch> r110 = NativePrefetchUtil.a;
        NativePrefetchUtil.k("NativePrefetch", "config is not json");
        Channel r111 = this.this$0.$channel;
        this.label = 4;
        if (r111.send(null, this) != r0) goto L38;
        return r0;
    }
}
