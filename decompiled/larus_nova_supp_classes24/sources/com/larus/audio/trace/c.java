package com.larus.audio.trace;

import androidx.collection.LruCache;
import com.larus.audio.v0;
import com.larus.platform.service.z2;
import com.larus.trace.tracespan.span.SpanWrapImpl;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wx9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements v0 {
    public static final c a = null;
    public static final LruCache<String, com.larus.trace.tracespan.span.b> b = null;
    public static final LruCache<String, String> c = null;
    public static final LruCache<String, String> d = null;
    public static String e;

    public c() {
    }

    static {
        a = new c();
        b = new LruCache(10);
        c = new LruCache(10);
        d = new LruCache(10);
    }

    public static boolean j() {
        return z2.a.disableAudioTraceSpan();
    }

    @Override // com.larus.audio.v0
    public final String f() {
        return e;
    }

    public static com.larus.trace.tracespan.span.b k(String r2) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "getRootSpan disableAudioTraceSpan");
        return null;
    L6:
        if (r2 != null) goto L9;
        return null;
    L9:
        return (com.larus.trace.tracespan.span.b) b.get(r2);
    }

    public static String l(String r2) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "getTraceSpanHeader disableAudioTraceSpan");
        return null;
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        com.larus.trace.tracespan.span.b r3 = (com.larus.trace.tracespan.span.b) b.get(r2);
        if (r3 != null) goto L11;
        return null;
    L11:
        String r4 = r3.f();
        JSONObject r0 = new JSONObject();
        r0.put("span_header", r4);
        return r0.toString();
    }

    @Override // com.larus.audio.v0
    public final String b(String r3) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "getLocalSendMsgId disableAudioTraceSpan");
        return null;
    L6:
        if (r3 != null) goto L9;
        return null;
    L9:
        return (String) c.get(r3);
    }

    @Override // com.larus.audio.v0
    public final String c(String r3) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "getLocalSendMsgIdFromSend disableAudioTraceSpan");
        return null;
    L6:
        if (r3 != null) goto L9;
        return null;
    L9:
        return (String) d.get(r3);
    }

    @Override // com.larus.audio.v0
    public final void e(String r3) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "updateOnlyNewestSendLocalMsgId disableAudioTraceSpan");
        return;
    L6:
        int r0 = c68.b.a;
        c68.b.d("AudioTraceSpanManager", "updateOnlyNewestSendLocalMsgId sendLocalMsgId=".concat(r3));
        e = r3;
    }

    @Override // com.larus.audio.v0
    public final com.larus.trace.tracespan.span.b a(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "commonParams");
        if (j() == false) goto L7;
        c68.b.d("AudioTraceSpanManager", "startRootSpan disableAudioTraceSpan");
        return null;
    L7:
        if (r5.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return null;
    L12:
        FLogger.a.w("AudioTraceSpanManager", "startRootSpan localMsgId=".concat(r5));
        LruCache<String, com.larus.trace.tracespan.span.b> r1 = b;
        com.larus.trace.tracespan.span.b r2 = (com.larus.trace.tracespan.span.b) r1.get(r5);
        if (r2 != null) goto L15;
        vx9.b.a r3 = new vx9.b.a();
        r3.e = 600000;
        Intrinsics.checkNotNullParameter("audio_message", "spanEventName");
        r3.c = "audio_message";
        Intrinsics.checkNotNullParameter("audio_message", "spanName");
        r3.a = "audio_message";
        Intrinsics.checkNotNullParameter("audio_message", "scene");
        r3.b = "audio_message";
        r2 = r3.a();
        r2.setTag("audio_message");
        r1.put(r5, r2);
    L15:
        r2.b(r6);
        return r2;
    L9:
        r0 = false;
        goto L10
    }

    @Override // com.larus.audio.v0
    public final void d(String r4, String r5) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "addSendMsgIdToLocalSendMsgIdPair disableAudioTraceSpan");
        return;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (r5 != null) goto L10;
        return;
    L10:
        int r0 = c68.b.a;
        c68.b.d("AudioTraceSpanManager", "addSendMsgIdToLocalSendMsgIdPair sendMsgId=" + r4 + " localSendMsgId=" + r5);
        LruCache<String, String> r1 = d;
        String r2 = (String) r1.get(r4);
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L20;
        r1.put(r4, r5);
        return;
    L20:
        return;
    L13:
        if (r2.length() == 0) goto L16;
        r3 = false;
        goto L17
    }

    @Override // com.larus.audio.v0
    public final void g(String r3, String r4) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "addRecToSendLocalMsgIdPair disableAudioTraceSpan");
        return;
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r4 != null) goto L10;
        return;
    L10:
        LruCache<String, String> r0 = c;
        if (((String) r0.get(r3)) != null) goto L14;
        r0.put(r3, r4);
        return;
    }

    public static void m(String r5, a r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r5, "spanName");
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "startAudioMessageSpan disableAudioTraceSpan");
        return;
    L6:
        FLogger r1 = FLogger.a;
        r1.i("AudioTraceSpanManager", "startAudioMessageSpan, spanName=" + r5);
        if (j() == false) goto L9;
        c68.b.d("AudioTraceSpanManager", "startSpan disableAudioTraceSpan");
        return;
    L9:
        r1.i("AudioTraceSpanManager", "startSpan, spanEventName=audio_message spanName=" + r5 + " spanScene=audio_message");
        if (r5 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == true) goto L22;
        vx9.b.a r3 = new vx9.b.a();
        Intrinsics.checkNotNullParameter("audio_message", "spanEventName");
        r3.c = "audio_message";
        Intrinsics.checkNotNullParameter(r5, "spanName");
        r3.a = r5;
        Intrinsics.checkNotNullParameter("audio_message", "scene");
        r3.b = "audio_message";
        r3.d = r6;
        com.larus.trace.tracespan.span.b r8 = r3.a();
        r8.setTag(r5);
        if (r7 == null) goto L23;
        r8.b(r7);
        return;
    L23:
        return;
    L22:
        return;
    L12:
        if (r5.length() == 0) goto L15;
        r2 = false;
        goto L16
    }

    public static void h(String r7, Integer r8, String r9, String r10) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "endRootSpan disableAudioTraceSpan");
        return;
    L6:
        if (r7 != null) goto L9;
        FLogger.a.w("AudioTraceSpanManager", "endRootSpan failed, localMessageId is null");
        return;
    L9:
        com.larus.trace.tracespan.span.b r0 = (com.larus.trace.tracespan.span.b) b.get(r7);
        if (r0 != null) goto L13;
        FLogger.a.w("AudioTraceSpanManager", "endRootSpan failed, rootSpan is null");
        return;
    L13:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("endRootSpan localMsgId:");
        r3.append(r7);
        r3.append(" span:");
        StringBuilder r4 = new StringBuilder("traceId=");
        r4.append(r0.getTraceId());
        r4.append(", parentSpanId=");
        com.larus.trace.tracespan.span.b r5 = r0.getParent();
        if (r5 == null) goto L16;
        String r6 = r5.a();
    L17:
        r4.append(r6);
        r4.append(", spanId=");
        r4.append(r0.a());
        r3.append(r4.toString());
        r2.i("AudioTraceSpanManager", r3.toString());
        vx9.b r11 = vx9.b.a;
        String r12 = r0.getTraceId();
        r11.getClass();
        SpanWrapImpl r13 = vx9.b.a(r12, "audio_message");
        if (r13 == null) goto L25;
        List r14 = r13.k();
        if (r14 == null) goto L25;
        Iterator r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L25;
        com.larus.trace.tracespan.span.b r16 = (com.larus.trace.tracespan.span.b) r15.next();
        FLogger.a.i("AudioTraceSpanManager", "endRootSpan cancel spanName=" + r16.getTag() + '}');
        r16.cancel(true);
    L25:
        if (r10 == null) goto L27;
        r0.d("error_ext_msg", r10);
    L27:
        r0.g(r8, r9);
        b.remove(r7);
        return;
    L16:
        r6 = null;
        goto L17
    }

    public static void i(String r5, String r6, Integer r7, String r8, JSONObject r9) {
        if (j() == false) goto L6;
        c68.b.d("AudioTraceSpanManager", "endSpan disableAudioTraceSpan");
        return;
    L6:
        boolean r0 = true;
        if (r5 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L34;
        if (r6 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == true) goto L34;
        vx9.b.a.getClass();
        SpanWrapImpl r10 = vx9.b.a(r5, r6);
        if (r9 == null) goto L26;
        if (r10 == null) goto L26;
        r10.b(r9);
    L26:
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("endSpan, spanName=");
        r12.append(r6);
        r12.append(", isSpanExist=");
        if (r10 != null) goto L30;
        r0 = false;
    L30:
        r12.append(r0);
        r11.i("AudioTraceSpanManager", r12.toString());
        if (r10 == null) goto L36;
        r10.g(r7, r8);
        return;
    L36:
        return;
    L16:
        if (r6.length() == 0) goto L19;
        r4 = false;
    L34:
        FLogger.a.w("AudioTraceSpanManager", "endSpan failed, traceId=" + r5 + ", spanName=" + r6);
        return;
    L9:
        if (r5.length() == 0) goto L12;
        r3 = false;
        goto L13
    }
}
