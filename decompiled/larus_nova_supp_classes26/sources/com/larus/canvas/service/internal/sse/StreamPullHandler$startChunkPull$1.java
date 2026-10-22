package com.larus.canvas.service.internal.sse;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.io.BufferedReader;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.internal.sse.StreamPullHandler$startChunkPull$1", f = "StreamPullHandler.kt", i = {1, 1}, l = {80, 91}, m = "invokeSuspend", n = {"logId", "br"}, s = {"L$0", "L$1"})
public final class StreamPullHandler$startChunkPull$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ StreamPullHandler this$0;

    public StreamPullHandler$startChunkPull$1(StreamPullHandler r1, Continuation<? super StreamPullHandler$startChunkPull$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        StreamPullHandler$startChunkPull$1 r0 = new StreamPullHandler$startChunkPull$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r3 = "";
        int r6 = 1;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L12;
        BufferedReader r4 = (BufferedReader) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L9
    L82:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L87:
        StreamPullHandler r7 = this.this$0;
        Throwable r8 = Result.exceptionOrNull-impl(r1);
        if (r8 == null) goto L96;
        String r9 = r8.getMessage();
        if (r9 == null) goto L94;
        r3 = r9;
    L94:
        r4.close();
        FLogger r10 = FLogger.a;
        int r11 = StreamPullHandler.k;
        r10.i("SSEHandler", "line end = ".concat(r3));
        r7.j.a(new f(1, r5, 1, r3));
    L96:
        return Unit.INSTANCE;
    L9:
        th = th;
        BufferedReader r12 = r4;
        String r13 = r5;
    L86:
        Result.Companion r14 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        r5 = r13;
        r4 = r12;
        goto L87
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r19);
    L108:
        this.this$0.a();
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        StreamPullHandler r16 = this.this$0;
        boolean r17 = false;
        if (r16.f != StreamPullHandler.k) goto L21;
        int r18 = d.a;
        String r20 = r16.a;
        Intrinsics.checkNotNullParameter("json", "binaryType");
        Intrinsics.checkNotNullParameter(r20, MusicAppletPage.KEY_PATH);
        o.a.b("flow_canvas_chunk_request", com.larus.utils.f.c(new Pair[]{TuplesKt.to("binary_type", "json"), TuplesKt.to("request_path", r20), TuplesKt.to("scene", "start")}));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        FLogger.a.e("flow_canvas_chunk_request_start", "reportEvent error", e);
    L21:
        StreamPullHandler r21 = this.this$0;
        String r110 = r21.a;
        Object r111 = r21.b;
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put("Content-Type", "application/json; encoding=utf-8");
        int r22 = dy8.a.a;     // Catch: Throwable -> L24
        dy8.c r113 = dy8.c.a;     // Catch: Throwable -> L24
        Map<String, String> r114 = MapsKt.emptyMap();     // Catch: Throwable -> L24
        z2 r115 = z2.a;     // Catch: Throwable -> L24
        ey8.a r23 = r113.a(r110, r111, r114, r112, MapsKt.mapOf(new Pair[]{TuplesKt.to("connect_timeout", Long.valueOf(r115.getCreationCanvasClientConfig().d)), TuplesKt.to("interval_timeout", Long.valueOf(r115.getCreationCanvasClientConfig().e)), TuplesKt.to("write_timeout", Long.valueOf(r115.getCreationCanvasClientConfig().f)), TuplesKt.to("protect_timeout", Long.valueOf(r115.getCreationCanvasClientConfig().g))}));     // Catch: Throwable -> L24
    L26:
        if (r23 == null) goto L31;
        Map<String, String> r24 = r23.c;
        if (r24 == null) goto L31;
        r13 = r24.get("X-Tt-Logid".toLowerCase(Locale.getDefault()));
        if (r13 == null) goto L31;
    L32:
        FLogger r25 = FLogger.a;
        int r116 = StreamPullHandler.k;
        StringBuilder r117 = new StringBuilder("startChunkPull , request start, uplink = ");
        r117.append(this.this$0.b);
        r117.append(" path = ");
        r117.append(this.this$0.a);
        r117.append(" logId = ");
        r117.append(r13);
        r117.append(" success = ");
        if (r23 == null) goto L40;
        int r118 = r23.b;
        if (200 > r118) goto L38;
        if (r118 >= 300) goto L38;
        boolean r119 = true;
    L39:
        Boolean r120 = Boxing.boxBoolean(r119);
    L41:
        r117.append(r120);
        r117.append(" status = ");
        if (r23 == null) goto L44;
        Integer r121 = Boxing.boxInt(r23.b);
    L45:
        r117.append(r121);
        r117.append(" message = ");
        if (r23 == null) goto L48;
        String r122 = r23.e;
    L49:
        r117.append(r122);
        r25.i("SSEHandler", r117.toString());
        IntRange r123 = new IntRange(400, 599);
        if (r23 == null) goto L52;
        Integer r124 = Boxing.boxInt(r23.b);
    L53:
        if (r124 != null) goto L55;
    L57:
        boolean r125 = false;
    L58:
        int r126 = -1;
        if (r125 == false) goto L65;
        g r26 = this.this$0.j;
        if (r23 == null) goto L63;
        r126 = r23.b;
    L63:
        r26.a(new f(r126, r13, 12));
        return Unit.INSTANCE;
    L65:
        if (r23 == null) goto L97;
        int r127 = r23.b;
        if (200 > r127) goto L70;
        if (r127 >= 300) goto L70;
        r17 = true;
    L70:
        if (r17 == false) goto L97;
        r12 = r23.f;
        if (r12 == null) goto L97;
        Intrinsics.checkNotNull(r12);
        StreamPullHandler r27 = this.this$0;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L85
        g r29 = r27.j;     // Catch: Throwable -> L85
        this.L$0 = r13;     // Catch: Throwable -> L85
        this.L$1 = r12;     // Catch: Throwable -> L85
        this.label = 2;     // Catch: Throwable -> L85
        Object r30 = CanvasChunkParser.a.a(r12, new StreamPullHandler$receiveStream$2(r29, r27, r13, null), this);     // Catch: Throwable -> L85
        if (r30 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L79;
        r30 = Unit.INSTANCE;     // Catch: Throwable -> L85
    L79:
        if (r30 != r2) goto L81;
        return r2;
    L81:
        r5 = r13;
        r4 = r12;
    L85:
        th = th;
    L97:
        StreamPullHandler r31 = this.this$0;
        int r32 = r31.f;
        if (r32 <= 0) goto L110;
        r31.f = r32 - 1;
        StringBuilder r33 = new StringBuilder("receiveStream failed error = call not success , error ");
        if (r23 == null) goto L104;
        Throwable r34 = r23.g;
        if (r34 == null) goto L104;
        String r35 = r34.getMessage();
    L105:
        r33.append(r35);
        r33.append(" do retry retryTimes = ");
        r33.append(this.this$0.f);
        r25.i("SSEHandler", r33.toString());
        long r36 = this.this$0.g;
        this.label = 1;
        if (DelayKt.delay(r36, this) != r2) goto L108;
        return r2;
    L104:
        r35 = null;
        goto L105
    L110:
        if (r23 == null) goto L112;
        r6 = r23.b;
    L112:
        if (r23 == null) goto L114;
        String r37 = r23.e;
    L115:
        if (r37 == null) goto L118;
        r3 = r37;
    L118:
        r31.j.a(new f(r6, r13, r6, r3));
        return Unit.INSTANCE;
    L114:
        r37 = null;
        goto L115
    L55:
        if (r123.contains(r124.intValue()) == false) goto L57;
        r125 = true;
        goto L58
    L52:
        r124 = null;
        goto L53
    L48:
        r122 = null;
        goto L49
    L44:
        r121 = null;
    L38:
        r119 = false;
        goto L39
    L40:
        r120 = null;
    L31:
        r13 = "";
    L24:
        th = move-exception;
        FLogger.a.e("SSEHandler", "networkApi error = " + th.getMessage());
        r23 = null;
        goto L26
    }
}
