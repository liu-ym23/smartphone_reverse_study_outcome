package com.larus.avlink.e.mock;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements j {
    public final c a;
    public final AtomicBoolean b;
    public final AtomicInteger c;
    public final AtomicInteger d;
    public final ConcurrentHashMap<Integer, ConcurrentHashMap<String, AtomicInteger>> e;
    public final ConcurrentHashMap<Integer, List<CallbackSequenceItem>> f;
    public final ConcurrentHashMap<Integer, Long> g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.avlink.e.mock.j
    public final void c(b49.k r2) {
        Intrinsics.checkNotNullParameter(r2, "trackInfo");
    }

    public final void g() {
        List r0 = CollectionsKt.toList(this.f.keySet());
        if ((!r0.isEmpty()) == false) goto L27;
        FLogger.a.i("CameraMockRecorder", "💾 Flushing " + r0.size() + " pending imageUuid recordings: " + r0);
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        Integer r2 = (Integer) r1.next();
        Intrinsics.checkNotNull(r2);
        int r3 = r2.intValue();
        int r4 = this.c.get();
        int r5 = this.d.get();
        List<CallbackSequenceItem> r6 = this.f.get(Integer.valueOf(r3));
        if (r6 == null) goto L18;
        if ((!r6.isEmpty()) == false) goto L18;
        monitor-enter(r6);
        this.a.c(r4, r5, r3, CollectionsKt.toList(r6));     // Catch: Throwable -> L15
        FLogger.a.i("CameraMockRecorder", "✅ Finished recording for imageUuid=" + r3 + " (" + r6.size() + " callbacks)");     // Catch: Throwable -> L15
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r6);
    L15:
        th = move-exception;
        throw th;
    L18:
        this.e.remove(Integer.valueOf(r3));
        this.f.remove(Integer.valueOf(r3));
        this.g.remove(Integer.valueOf(r3));
        goto L6
    L19:
        FLogger.a.i("CameraMockRecorder", "✅ All pending imageUuid recordings flushed");
        return;
    }

    public final void i() {
        this.b.set(true);
        FLogger.a.i("CameraMockRecorder", "📹 Recording enabled: true (currentMode=" + this.c.get() + ", dataSetId=" + this.d.get() + ')');
    }

    public g() {
        this.a = new c();
        this.b = new AtomicBoolean(false);
        this.c = new AtomicInteger(0);
        this.d = new AtomicInteger(1);
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
    }

    @Override // com.larus.avlink.e.mock.j
    public final void a(int r4) {
        if (this.b.get() == true) goto L5;
        return;
    L5:
        FLogger.a.i("CameraMockRecorder", "interceptOnTakeImageHotWordIDReceived: hotWordId=" + r4);
    }

    @Override // com.larus.avlink.e.mock.j
    public final void f(b49.g r19) {
        if (this.b.get() == true) goto L5;
        return;
    L5:
        if (r19 != null) goto L7;
        return;
    L7:
        boolean r2 = true;
        Integer r3 = k.a("onDataFrame", new Object[]{r19});
        if (r3 != null) goto L10;
    L12:
        r2 = false;
    L14:
        if (r2 == true) goto L17;
        FLogger.a.w("CameraMockRecorder", "interceptOnDataFrame: invalid imageUuid=" + r3 + " (assId=" + r19.h + ')');
        return;
    L17:
        Intrinsics.checkNotNull(r3);
        int r4 = r3.intValue();
        Gson r7 = h.a;
        h(r4, "onDataFrame", MapsKt.mapOf(TuplesKt.to("frame", new CameraDataFrameJson(Integer.valueOf(r19.a), Integer.valueOf(r19.b), Integer.valueOf(r19.c), Integer.valueOf(r19.getType()), Integer.valueOf(r19.e), Integer.valueOf(r19.f), Base64.encodeToString(r19.g, 0), Integer.valueOf(r19.h), Base64.encodeToString(r19.i, 0)))));
        FLogger.a.d("CameraMockRecorder", "Intercepted onDataFrame: imageUuid=" + r3 + ", scene=" + r19.b);
        return;
    L10:
        if (r3.intValue() == 0) goto L12;
        goto L12
    }

    @Override // com.larus.avlink.e.mock.j
    public final void d(b49.h r23, b49.d r24) {
        Intrinsics.checkNotNullParameter(r23, "imageInfo");
        if (this.b.get() == true) goto L5;
        return;
    L5:
        Integer r5 = k.a("onCameraCompleteImage", new Object[]{r23, r24});
        if (r5 != null) goto L8;
    L10:
        boolean r9 = false;
    L12:
        if (r9 == true) goto L15;
        FLogger.a.w("CameraMockRecorder", "interceptOnCameraCompleteImage: invalid imageUuid=" + r5);
        return;
    L15:
        Intrinsics.checkNotNull(r5);
        int r10 = r5.intValue();
        Gson r11 = h.a;
        Intrinsics.checkNotNullParameter(r23, "imageInfo");
        Pair[] r4 = new Pair[2];
        Integer r13 = Integer.valueOf(r23.a);
        Integer r14 = Integer.valueOf(r23.f);
        byte[] r12 = r23.b;
        if (r12 == null) goto L18;
        int r15 = r12.length;
    L19:
        int r16 = r23.e;
        int r7 = r23.c;
        int r6 = r23.d;
        int r1 = r23.g;
        if (r12 == null) goto L22;
        String r20 = Base64.encodeToString(r12, 0);
    L23:
        r4[0] = TuplesKt.to("imageInfo", new CameraImageInfoJson(r13, r14, r15, r16, r7, r6, r1, r20));
        if (r24 != null) goto L26;
        CameraErrorJson r2 = null;
    L27:
        r4[1] = TuplesKt.to("error", r2);
        h(r10, "onCameraCompleteImage", MapsKt.mapOf(r4));
        FLogger.a.d("CameraMockRecorder", "Intercepted onCameraCompleteImage: imageUuid=" + r5);
        return;
    L26:
        r2 = new CameraErrorJson(Integer.valueOf(r24.a), r24.b);
        goto L27
    L22:
        r20 = null;
        goto L23
    L18:
        r15 = 0;
        goto L19
    L8:
        if (r5.intValue() == 0) goto L10;
        r9 = true;
        goto L12
    }

    @Override // com.larus.avlink.e.mock.j
    public final void e(boolean r7, int r8) {
        if (this.b.get() == true) goto L5;
        return;
    L5:
        int r0 = k.a;
        Integer r1 = Integer.valueOf(r8);
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L15;
        FLogger.a.w("CameraMockRecorder", "interceptOnImageOcrStateUpdate: invalid imageUuid=" + r8);
        return;
    L15:
        Gson r3 = h.a;
        h(r8, "onImageOcrStateUpdate", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(r7)), TuplesKt.to("imageUuid", Integer.valueOf(r8))}));
        FLogger.a.d("CameraMockRecorder", "Intercepted onImageOcrStateUpdate: imageUuid=" + r8 + ", result=" + r7);
        return;
    L8:
        if (r1.intValue() == 0) goto L10;
        r2 = true;
        goto L12
    }

    public final void h(int r19, String r20, Map<String, ? extends Object> r21) {
        int r4 = this.c.get();
        int r5 = this.d.get();
        if (this.f.containsKey(Integer.valueOf(r19)) == true) goto L5;
        FLogger.a.i("CameraMockRecorder", "📹 Starting recording for imageUuid=" + r19 + " -> mode_" + r4 + "/dataSet_" + r5);
    L5:
        ConcurrentHashMap<Integer, ConcurrentHashMap<String, AtomicInteger>> r6 = this.e;
        Integer r7 = Integer.valueOf(r19);
        ConcurrentHashMap<String, AtomicInteger> r8 = r6.get(r7);
        if (r8 != null) goto L11;
        r8 = new ConcurrentHashMap();
        ConcurrentHashMap<String, AtomicInteger> r9 = r6.putIfAbsent(r7, r8);
        if (r9 == null) goto L11;
        r8 = r9;
    L11:
        ConcurrentHashMap<String, AtomicInteger> r10 = r8;
        ConcurrentHashMap<Integer, List<CallbackSequenceItem>> r11 = this.f;
        Integer r12 = Integer.valueOf(r19);
        List<CallbackSequenceItem> r13 = r11.get(r12);
        if (r13 != null) goto L17;
        r13 = new ArrayList();
        List<CallbackSequenceItem> r14 = r11.putIfAbsent(r12, r13);
        if (r14 == null) goto L17;
        r13 = r14;
    L17:
        List<CallbackSequenceItem> r15 = r13;
        ConcurrentHashMap<Integer, Long> r16 = this.g;
        Integer r17 = Integer.valueOf(r19);
        Long r18 = r16.get(r17);
        if (r18 != null) goto L23;
        r18 = Long.valueOf(System.currentTimeMillis());
        Long r22 = r16.putIfAbsent(r17, r18);
        if (r22 == null) goto L23;
        r18 = r22;
    L23:
        Long r110 = r18;
        Intrinsics.checkNotNull(r10);
        AtomicInteger r23 = r10.get(r20);
        if (r23 != null) goto L29;
        r23 = new AtomicInteger(0);
        AtomicInteger r24 = r10.putIfAbsent(r20, r23);
        if (r24 == null) goto L29;
        r23 = r24;
    L29:
        int r25 = r23.incrementAndGet();
        long r111 = System.currentTimeMillis();
        Intrinsics.checkNotNull(r110);
        long r112 = r111 - r110.longValue();
        String r26 = r20 + '_' + r25 + ".json";
        c r113 = this.a;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r20, "callbackType");
        Intrinsics.checkNotNullParameter(r21, "params");
        PolarisFileWrapper r27 = r113.b(r4, r5, r19);     // Catch: Exception -> L32
        String r28 = r20 + '_' + r25 + ".json";     // Catch: Exception -> L32
        FilesKt.writeText$default(new PolarisFileWrapper(r27, r28), h.e(MapsKt.mapOf(new Pair[]{TuplesKt.to("callbackType", r20), TuplesKt.to("callIndex", Integer.valueOf(r25)), TuplesKt.to("params", r21)})), null, 2, null);     // Catch: Exception -> L32
        FLogger.a.d("CameraMockFileManager", "Callback saved to imageUuid dir: " + r28 + " -> index_" + r19);     // Catch: Exception -> L32
    L34:
        Intrinsics.checkNotNull(r15);
        monitor-enter(r15);
        r15.add(new CallbackSequenceItem(Integer.valueOf(r15.size() + 1), r26, Long.valueOf(r112)));     // Catch: Throwable -> L40
        monitor-exit(r15);
        FLogger.a.d("CameraMockRecorder", "📝 Recorded: imageUuid=" + r19 + ", " + r20 + " #" + r25 + " (seq=" + r15.size() + ", ts=" + r112 + "ms)");
        return;
    L40:
        th = move-exception;
        throw th;
    L32:
        e = move-exception;
        FLogger.a.e("CameraMockFileManager", "saveCallbackRecordToImageUuidDir failed: imageUuid=" + r19 + ", " + r20 + " #" + r25, e);
        goto L34
    }

    @Override // com.larus.avlink.e.mock.j
    public final void b(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, int r27, int r28) {
        if (this.b.get() == true) goto L5;
        return;
    L5:
        int r3 = k.a;
        Integer r4 = Integer.valueOf(r11);
        if (r4 != null) goto L8;
    L10:
        boolean r5 = false;
    L12:
        if (r5 == true) goto L16;
        FLogger.a.w("CameraMockRecorder", "interceptOnTakeImageState: invalid imageUuid=" + r11);
        return;
    L16:
        if (this.c.get() == r16) goto L18;
        this.c.set(r16);
        FLogger.a.i("CameraMockRecorder", "📹 Updated recording mode from callback: mode=" + r16);
    L18:
        Gson r6 = h.a;
        h(r11, "onTakeImageState", MapsKt.mapOf(new Pair[]{TuplesKt.to("imageState", Integer.valueOf(r10)), TuplesKt.to("imageUuid", Integer.valueOf(r11)), TuplesKt.to("wkrId", Integer.valueOf(r12)), TuplesKt.to("vuiId", Integer.valueOf(r13)), TuplesKt.to("imageCount", Integer.valueOf(r14)), TuplesKt.to("side", Integer.valueOf(r15)), TuplesKt.to("mode", Integer.valueOf(r16)), TuplesKt.to("transmitResult", Integer.valueOf(r17)), TuplesKt.to("imageWidth", Integer.valueOf(r18)), TuplesKt.to("imageHeight", Integer.valueOf(r19)), TuplesKt.to("qualityValue", Integer.valueOf(r20)), TuplesKt.to("definitionValue", Integer.valueOf(r21)), TuplesKt.to("format", Integer.valueOf(r22)), TuplesKt.to("hasOcr", Integer.valueOf(r23)), TuplesKt.to("imageCreateTimeStamp", Long.valueOf(r24)), TuplesKt.to("cameraOutputStrategy", Integer.valueOf(r26)), TuplesKt.to("ocrTextLines", Integer.valueOf(r27)), TuplesKt.to("obsSubMode", Integer.valueOf(r28))}));
        FLogger.a.d("CameraMockRecorder", "Intercepted onTakeImageState: imageUuid=" + r11 + ", stage=" + r10 + ", mode=" + r16);
        return;
    L8:
        if (r4.intValue() == 0) goto L10;
        r5 = true;
        goto L12
    }
}
