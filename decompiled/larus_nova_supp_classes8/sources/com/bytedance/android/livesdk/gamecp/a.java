package com.bytedance.android.livesdk.gamecp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.gz;
import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.bytedance.android.livesdkapi.livetrace.ILiveCloudGameTraceMonitor;
import com.bytedance.android.livesdkapi.livetrace.TraceMetaWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ILiveCloudGameTraceMonitor {
    public static final boolean a = false;
    public static HandlerThread b;
    public static Handler c;
    public static final a d = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamecp.a$a, reason: collision with other inner class name */
    public static final class HandlerC0355a extends Handler {
        public HandlerC0355a(Looper r2) {
            Intrinsics.checkNotNullParameter(r2, "looper");
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            int r0 = r5.what;
            Object r2 = null;
            if (r0 == (-1)) goto L18;
            if (r0 != 0) goto L32;
            removeMessages(-1);
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
            Object r6 = r5.obj;     // Catch: Throwable -> L15
            if (TypeIntrinsics.isFunctionOfArity(r6, 0) == true) goto L10;
            r6 = null;
        L10:
            Function0 r7 = (Function0) r6;     // Catch: Throwable -> L15
            if (r7 == null) goto L13;
            r2 = r7.invoke();     // Catch: Throwable -> L15
        L13:
            Result.constructor-impl(r2);     // Catch: Throwable -> L15
        L17:
            sendEmptyMessageDelayed(-1, AppointmentService.SOURCE_UNDEFINED);
            return;
        L15:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        L32:
            return;
        L18:
            removeCallbacksAndMessages(null);
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L24
            boolean r9 = a.a;     // Catch: Throwable -> L24
            HandlerThread r10 = a.b;     // Catch: Throwable -> L24
            if (r10 == null) goto L22;
            r10.quitSafely();     // Catch: Throwable -> L24
        L22:
            a.b = null;     // Catch: Throwable -> L24
            a.c = null;     // Catch: Throwable -> L24
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final class b implements Function0<Unit> {
        public final /* synthetic */ com.bytedance.android.live.core.monitor.trace.e a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ JSONObject d;

        public final Object invoke() {
            TraceMonitor.i(this.a, this.b, this.c, this.d);
            return Unit.INSTANCE;
        }

        public b(com.bytedance.android.live.core.monitor.trace.e r1, JSONObject r2, JSONObject r3, JSONObject r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public a() {
    }

    static {
        d = new a();
        a = gz.a.getValue().a();
    }

    public static com.bytedance.android.live.core.monitor.trace.e a(TraceMetaWrapper r3) {
        int r0 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r1 = com.bytedance.android.live.core.monitor.trace.e.b.a(r3.getEventType(), r3.getBusinessType());
        r1.g = r3.getUserId();
        r1.f = r3.getAnchorId();
        r1.a = r3.getTraceId();
        r1.e = r3.getRoomId();
        Map r2 = r3.getIndex();
        if (r2 != null) goto L5;
        r2 = new LinkedHashMap();
    L5:
        Intrinsics.checkNotNullParameter(r2, "index");
        r1.j = r2;
        r1.b = r3.getLogId();
        r1.d = r3.getStep();
        r1.c = r3.getProductId();
        r1.h = r3.getStatusCode();
        r1.i = r3.getStatusMsg();
        return r1.a();
    }

    public final void reportTraceEvent(String r4, String r5, String r6, String r7, String r8, Map<String, Object> r9, JSONObject r10, JSONObject r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r4, "businessType");
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r6, "step");
        if (a == true) goto L5;
        return;
    L5:
        TraceMetaWrapper.Builder r13 = TraceMetaWrapper.Companion.builder(r5, r4).productId("webcast_client_game").step(r6).traceId(r7).userId(jc1.k.n(IUserService.class).user().n()).roomId(r8);
        Boolean r14 = null;
        if (r9 != null) goto L8;
    L17:
        String r15 = "";
        if (r9 != null) goto L20;
    L28:
        if (r9 != null) goto L30;
    L39:
        if (r9 == null) goto L41;
        r9.put("report_source", "Android");
    L41:
        if (r9 != null) goto L43;
        r9 = new LinkedHashMap();
    L43:
        r13.index(r9);
        TraceMetaWrapper r16 = r13.build();
        if (b != null) goto L60;
        x8.a.d("CloudGameTraceMonitor", "initialize monitor thread", false);
        PthreadHandlerThreadV2 r17 = new PthreadHandlerThreadV2("cloud_game_monitor");
        b = r17;
        ThreadMethodProxy.start(r17);
        Handler r18 = c;
        if (r18 == null) goto L48;
        r18.removeCallbacksAndMessages(null);
    L48:
        c = new HandlerC0355a(r17.getLooper());
    L60:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L54
        com.bytedance.android.live.core.monitor.trace.e r20 = a(r16);     // Catch: Throwable -> L54
        Message r21 = Message.obtain();     // Catch: Throwable -> L54
        r21.what = 0;     // Catch: Throwable -> L54
        r21.obj = new b(r20, r10, r11, r12);     // Catch: Throwable -> L54
        Handler r22 = c;     // Catch: Throwable -> L54
        if (r22 == null) goto L52;
        r14 = Boolean.valueOf(r22.sendMessage(r21));     // Catch: Throwable -> L54
    L52:
        Object r23 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L62;
        x8.a.c("CloudGameTraceMonitor", r24, false);
        return;
    L62:
        return;
    L54:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L30:
        if (r9.containsKey("log_id") != true) goto L39;
        Object r26 = r9.get("log_id");
        if ((r26 instanceof String) == true) goto L34;
        r26 = null;
    L34:
        String r27 = (String) r26;
        if (r27 == null) goto L38;
        r15 = r27;
    L38:
        r13.logId(r15);
        r9.remove("log_id");
        goto L39
    L20:
        if (r9.containsKey("error_msg") != true) goto L28;
        Object r1 = r9.get("error_msg");
        if ((r1 instanceof String) == true) goto L24;
        r1 = null;
    L24:
        String r2 = (String) r1;
        if (r2 != null) goto L27;
        r2 = "";
    L27:
        r13.statusMsg(r2);
        r9.remove("error_msg");
        goto L28
    L8:
        if (r9.containsKey("error_code") != true) goto L17;
        Object r0 = r9.get("error_code");
        if ((r0 instanceof Integer) == true) goto L12;
        r0 = null;
    L12:
        Integer r3 = (Integer) r0;
        if (r3 == null) goto L15;
        int r28 = r3.intValue();
    L16:
        r13.statusCode(Integer.valueOf(r28));
        r9.remove("error_code");
        goto L17
    L15:
        r28 = 0;
        goto L16
    }
}
