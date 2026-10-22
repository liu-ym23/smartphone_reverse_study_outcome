package com.larus.avlink.e.mock;

import com.larus.avlink.e.mock.scenario.TimingStrategy;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final AtomicBoolean a;
    public h49.d b;

    public static final class a {
    }

    static {
    }

    public f() {
        new c();
        new AtomicBoolean(false);
        this.a = new AtomicBoolean(false);
        new AtomicBoolean(true);
    }

    public final void c(CameraCallbackRecord r7) {
        h49.d r3 = this.b;     // Catch: Exception -> L48
        if (r3 != null) goto L7;
        return;
    L7:
        if (r7.getParams() != null) goto L9;
        return;
    L9:
        String r4 = r7.getCallbackType();     // Catch: Exception -> L48
        if (r4 != null) goto L12;
    L45:
        FLogger.a.w("CameraMockPlayer", "Unknown callback type: " + r7.getCallbackType());     // Catch: Exception -> L48
    L46:
        FLogger.a.i("CameraMockPlayer", "Playback callback: " + r7.getCallbackType() + ", seq=" + r7.getSequence());     // Catch: Exception -> L48
        return;
    L12:
        switch(r4.hashCode()) {
            case -417316668: goto L42;
            case -103534882: goto L27;
            case -57227364: goto L23;
            case 637830808: goto L19;
            case 1975921694: goto L15;
            default: goto L45;
        };     // Catch: Exception -> L48
    L15:
        if (r4.equals("onCameraCompleteImage") == false) goto L45;
        d(r3, r7.getParams());     // Catch: Exception -> L48
        goto L46
    L19:
        if (r4.equals("onImageOcrStateUpdate") == false) goto L45;
        f(r3, r7.getParams());     // Catch: Exception -> L48
        goto L46
    L23:
        if (r4.equals("onTakeImageState") == false) goto L45;
        g(r3, r7.getParams());     // Catch: Exception -> L48
        goto L46
    L27:
        if (r4.equals("onTakeImageHotWordIDReceived") == false) goto L45;
        Object r2 = r7.getParams().get("hotWordId");     // Catch: Exception -> L39
        if ((r2 instanceof Number) == false) goto L33;
        Number r5 = (Number) r2;     // Catch: Exception -> L39
    L34:
        if (r5 == null) goto L36;
        int r6 = r5.intValue();     // Catch: Exception -> L39
    L37:
        r3.a(r6);     // Catch: Exception -> L39
    L36:
        r6 = 0;
        goto L37
    L33:
        r5 = null;
    L39:
        e = move-exception;
        FLogger.a.e("CameraMockPlayer", "playbackOnTakeImageHotWordID failed", e);     // Catch: Exception -> L48
        goto L46
    L42:
        if (r4.equals("onDataFrame") == false) goto L45;
        e(r3, r7.getParams());     // Catch: Exception -> L48
    L48:
        e = move-exception;
        FLogger.a.e("CameraMockPlayer", "playbackCallback failed for type=" + r7.getCallbackType(), e);
    }

    public static void d(h49.d r5, Map r6) {
        Object r0 = r6.get("imageInfo");     // Catch: Exception -> L32
        b49.d r2 = null;
        if ((r0 instanceof Map) == false) goto L5;
        Map r1 = (Map) r0;     // Catch: Exception -> L32
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Object r7 = r6.get("error");     // Catch: Exception -> L32
        if ((r7 instanceof Map) == false) goto L11;
        Map r8 = (Map) r7;     // Catch: Exception -> L32
    L12:
        b49.h r3 = h.b((CameraImageInfoJson) h.c(h.d(r1), CameraImageInfoJson.class));     // Catch: Exception -> L32
        if (r3 != null) goto L15;
        return;
    L15:
        if (r8 == null) goto L30;
        CameraErrorJson r9 = (CameraErrorJson) h.c(h.d(r8), CameraErrorJson.class);     // Catch: Exception -> L32
        if (r9 == null) goto L30;
        Integer r4 = r9.getCode();     // Catch: Exception -> L28
        if (r4 == null) goto L22;
        int r10 = r4.intValue();     // Catch: Exception -> L28
    L23:
        String r11 = r9.getMessage();     // Catch: Exception -> L28
        if (r11 != null) goto L26;
        r11 = "";
    L26:
        r2 = new b49.d(r10, r11);     // Catch: Exception -> L28
        goto L30
    L22:
        r10 = 0;
    L28:
        e = move-exception;
        FLogger.a.e("CameraMockSerializer", "deserializeError failed", e);     // Catch: Exception -> L32
    L30:
        r5.c(r3, r2);     // Catch: Exception -> L32
        return;
    L11:
        r8 = null;
        goto L12
    L5:
        r1 = null;
    L32:
        e = move-exception;
        FLogger.a.e("CameraMockPlayer", "playbackOnCameraCompleteImage failed", e);
    }

    public static void e(h49.d r2, Map r3) {
        Object r4 = r3.get("frame");     // Catch: Exception -> L10
        if ((r4 instanceof Map) == false) goto L5;
        Map r5 = (Map) r4;     // Catch: Exception -> L10
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        r2.d(h.a((CameraDataFrameJson) h.c(h.d(r5), CameraDataFrameJson.class)));     // Catch: Exception -> L10
        return;
    L5:
        r5 = null;
    L10:
        e = move-exception;
        FLogger.a.e("CameraMockPlayer", "playbackOnDataFrame failed", e);
    }

    public static void f(h49.d r4, Map r5) {
        Object r0 = r5.get("result");     // Catch: Exception -> L17
        Number r2 = null;
        if ((r0 instanceof Boolean) == false) goto L5;
        Boolean r1 = (Boolean) r0;     // Catch: Exception -> L17
    L6:
        int r3 = 0;
        if (r1 == null) goto L9;
        boolean r6 = r1.booleanValue();     // Catch: Exception -> L17
    L10:
        Object r7 = r5.get("imageUuid");     // Catch: Exception -> L17
        if ((r7 instanceof Number) == false) goto L13;
        r2 = (Number) r7;     // Catch: Exception -> L17
    L13:
        if (r2 == null) goto L15;
        r3 = r2.intValue();     // Catch: Exception -> L17
    L15:
        r4.j(r6, r3, (byte) 48);     // Catch: Exception -> L17
        return;
    L9:
        r6 = false;
        goto L10
    L5:
        r1 = null;
    L17:
        e = move-exception;
        FLogger.a.e("CameraMockPlayer", "playbackOnImageOcrStateUpdate failed", e);
    }

    public static void g(h49.d r24, Map r25) {
        Object r1 = r25.get("imageState");     // Catch: Exception -> L131
        Number r3 = null;
        if ((r1 instanceof Number) == false) goto L6;
        Number r2 = (Number) r1;     // Catch: Exception -> L131
    L8:
        if (r2 == null) goto L10;
        int r5 = r2.intValue();     // Catch: Exception -> L131
    L11:
        Object r4 = r25.get("imageUuid");     // Catch: Exception -> L131
        if ((r4 instanceof Number) == false) goto L14;
        Number r6 = (Number) r4;     // Catch: Exception -> L131
    L15:
        if (r6 == null) goto L17;
        int r7 = r6.intValue();     // Catch: Exception -> L131
    L18:
        Object r8 = r25.get("wkrId");     // Catch: Exception -> L131
        if ((r8 instanceof Number) == false) goto L21;
        Number r9 = (Number) r8;     // Catch: Exception -> L131
    L22:
        if (r9 == null) goto L24;
        int r10 = r9.intValue();     // Catch: Exception -> L131
    L25:
        Object r11 = r25.get("vuiId");     // Catch: Exception -> L131
        if ((r11 instanceof Number) == false) goto L28;
        Number r12 = (Number) r11;     // Catch: Exception -> L131
    L29:
        if (r12 == null) goto L31;
        int r13 = r12.intValue();     // Catch: Exception -> L131
    L32:
        Object r14 = r25.get("imageCount");     // Catch: Exception -> L131
        if ((r14 instanceof Number) == false) goto L35;
        Number r15 = (Number) r14;     // Catch: Exception -> L131
    L36:
        if (r15 == null) goto L38;
        int r16 = r15.intValue();     // Catch: Exception -> L131
    L39:
        Object r17 = r25.get("side");     // Catch: Exception -> L131
        if ((r17 instanceof Number) == false) goto L42;
        Number r18 = (Number) r17;     // Catch: Exception -> L131
    L43:
        if (r18 == null) goto L45;
        int r19 = r18.intValue();     // Catch: Exception -> L131
    L46:
        Object r20 = r25.get("mode");     // Catch: Exception -> L131
        if ((r20 instanceof Number) == false) goto L49;
        Number r21 = (Number) r20;     // Catch: Exception -> L131
    L50:
        if (r21 == null) goto L52;
        int r110 = r21.intValue();     // Catch: Exception -> L131
    L53:
        Object r22 = r25.get("transmitResult");     // Catch: Exception -> L131
        if ((r22 instanceof Number) == false) goto L56;
        Number r23 = (Number) r22;     // Catch: Exception -> L131
    L57:
        if (r23 == null) goto L59;
        int r111 = r23.intValue();     // Catch: Exception -> L131
    L60:
        Object r26 = r25.get("imageWidth");     // Catch: Exception -> L131
        if ((r26 instanceof Number) == false) goto L63;
        Number r27 = (Number) r26;     // Catch: Exception -> L131
    L64:
        if (r27 == null) goto L66;
        int r112 = r27.intValue();     // Catch: Exception -> L131
    L67:
        Object r28 = r25.get("imageHeight");     // Catch: Exception -> L131
        if ((r28 instanceof Number) == false) goto L70;
        Number r29 = (Number) r28;     // Catch: Exception -> L131
    L71:
        if (r29 == null) goto L73;
        int r113 = r29.intValue();     // Catch: Exception -> L131
    L74:
        Object r30 = r25.get("qualityValue");     // Catch: Exception -> L131
        if ((r30 instanceof Number) == false) goto L77;
        Number r31 = (Number) r30;     // Catch: Exception -> L131
    L78:
        if (r31 == null) goto L80;
        int r114 = r31.intValue();     // Catch: Exception -> L131
    L81:
        Object r32 = r25.get("definitionValue");     // Catch: Exception -> L131
        if ((r32 instanceof Number) == false) goto L84;
        Number r33 = (Number) r32;     // Catch: Exception -> L131
    L85:
        if (r33 == null) goto L87;
        int r115 = r33.intValue();     // Catch: Exception -> L131
    L88:
        Object r34 = r25.get("format");     // Catch: Exception -> L131
        if ((r34 instanceof Number) == false) goto L91;
        Number r35 = (Number) r34;     // Catch: Exception -> L131
    L92:
        if (r35 == null) goto L94;
        int r116 = r35.intValue();     // Catch: Exception -> L131
    L95:
        Object r36 = r25.get("hasOcr");     // Catch: Exception -> L131
        if ((r36 instanceof Number) == false) goto L98;
        Number r37 = (Number) r36;     // Catch: Exception -> L131
    L99:
        if (r37 == null) goto L101;
        int r117 = r37.intValue();     // Catch: Exception -> L131
    L102:
        Object r38 = r25.get("imageCreateTimeStamp");     // Catch: Exception -> L131
        if ((r38 instanceof Number) == false) goto L105;
        Number r39 = (Number) r38;     // Catch: Exception -> L131
    L106:
        if (r39 == null) goto L108;
        long r118 = r39.longValue();     // Catch: Exception -> L131
    L109:
        Object r40 = r25.get("cameraOutputStrategy");     // Catch: Exception -> L131
        if ((r40 instanceof Number) == false) goto L112;
        Number r41 = (Number) r40;     // Catch: Exception -> L131
    L113:
        if (r41 == null) goto L115;
        int r210 = r41.intValue();     // Catch: Exception -> L131
    L116:
        Object r42 = r25.get("ocrTextLines");     // Catch: Exception -> L131
        if ((r42 instanceof Number) == false) goto L119;
        Number r43 = (Number) r42;     // Catch: Exception -> L131
    L120:
        if (r43 == null) goto L122;
        int r211 = r43.intValue();     // Catch: Exception -> L131
    L123:
        Object r0 = r25.get("obsSubMode");     // Catch: Exception -> L131
        if ((r0 instanceof Number) == false) goto L126;
        r3 = (Number) r0;     // Catch: Exception -> L131
    L126:
        if (r3 == null) goto L128;
        int r212 = r3.intValue();     // Catch: Exception -> L131
    L129:
        r24.b(r5, r7, r10, r13, r16, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212);     // Catch: Exception -> L131
        return;
    L128:
        r212 = 0;
        goto L129
    L122:
        r211 = 0;
        goto L123
    L119:
        r43 = null;
        goto L120
    L115:
        r210 = 0;
        goto L116
    L112:
        r41 = null;
        goto L113
    L108:
        r118 = 0;
        goto L109
    L105:
        r39 = null;
        goto L106
    L101:
        r117 = 0;
        goto L102
    L98:
        r37 = null;
        goto L99
    L94:
        r116 = 2;
        goto L95
    L91:
        r35 = null;
        goto L92
    L87:
        r115 = 0;
        goto L88
    L84:
        r33 = null;
        goto L85
    L80:
        r114 = 0;
        goto L81
    L77:
        r31 = null;
        goto L78
    L73:
        r113 = 0;
        goto L74
    L70:
        r29 = null;
        goto L71
    L66:
        r112 = 0;
        goto L67
    L63:
        r27 = null;
        goto L64
    L59:
        r111 = 0;
        goto L60
    L56:
        r23 = null;
        goto L57
    L52:
        r110 = 0;
        goto L53
    L49:
        r21 = null;
        goto L50
    L45:
        r19 = 0;
        goto L46
    L42:
        r18 = null;
        goto L43
    L38:
        r16 = 0;
        goto L39
    L35:
        r15 = null;
        goto L36
    L31:
        r13 = 0;
        goto L32
    L28:
        r12 = null;
        goto L29
    L24:
        r10 = 0;
        goto L25
    L21:
        r9 = null;
        goto L22
    L17:
        r7 = 0;
        goto L18
    L14:
        r6 = null;
        goto L15
    L10:
        r5 = 0;
        goto L11
    L6:
        r2 = null;
    L131:
        e = move-exception;
        FLogger.a.e("CameraMockPlayer", "playbackOnTakeImageState failed", e);
    }

    public static final List a(f r8, List r9, Map r10) {
        r8.getClass();
        if (r10.isEmpty() == true) goto L26;
        List r11 = r9;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L19;
        CameraCallbackRecord r1 = (CameraCallbackRecord) r13.next();
        Map<String, Object> r0 = r1.getParams();
        if (r0 == null) goto L25;
        Map r5 = MapsKt.toMutableMap(r0);
        if (r5 == null) goto L25;
        Iterator r2 = r10.entrySet().iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) r2.next();
        r5.put((String) r3.getKey(), r3.getValue());
        goto L15
    L17:
        r12.add(CameraCallbackRecord.copy$default(r1, null, null, null, r5, 7, null));
    L25:
        return CollectionsKt.emptyList();
    L19:
        FLogger.a.i("CameraMockPlayer", "Applied parameter mapping to " + r12.size() + " callbacks");
        return r12;
    L26:
        return r9;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d1 -> B:39:0x00f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00de -> B:39:0x00f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00f0 -> B:38:0x00f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x015a -> B:53:0x015e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0166 -> B:55:0x0167). Please report as a decompilation issue!!! */
    public static final Object b(f r17, List r18, TimingStrategy r19, Continuation r20) {
        r17.getClass();
        if ((r20 instanceof CameraMockPlayer$playbackCallbacksWithTiming$1) == false) goto L7;
        CameraMockPlayer$playbackCallbacksWithTiming$1 r3 = (CameraMockPlayer$playbackCallbacksWithTiming$1) r20;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r1 = r3.I$0;
        CameraCallbackRecord r7 = (CameraCallbackRecord) r3.L$3;
        Iterator r8 = (Iterator) r3.L$2;
        TimingStrategy r12 = (TimingStrategy) r3.L$1;
        List r13 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L53:
        TimingStrategy r9 = r12;
        CameraCallbackRecord r16 = r7;
        int r10 = r1;
        List r11 = r13;
        CameraCallbackRecord r14 = r16;
    L55:
        r17.c(r14);
    L46:
        if (r8.hasNext() == false) goto L56;
        int r15 = r10 + 1;
        r14 = (CameraCallbackRecord) r8.next();
        if (r10 <= 0) goto L54;
        ((TimingStrategy.a) r9).getClass();
        r3.L$0 = r11;
        r3.L$1 = r9;
        r3.L$2 = r8;
        r3.L$3 = r14;
        r3.I$0 = r15;
        r3.label = 2;
        if (DelayKt.delay(0, r3) == r5) goto L64;
        r7 = r14;
        r13 = r11;
        r1 = r15;
        r12 = r9;
        goto L53
    L64:
        return r5;
    L54:
        r10 = r15;
        goto L55
    L56:
        FLogger r0 = FLogger.a;
        ((TimingStrategy.a) r9).getClass();
        r0.i("CameraMockPlayer", "Executed " + r11.size() + " callbacks with custom delay: 0ms");
    L58:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        CameraCallbackRecord r21 = (CameraCallbackRecord) r3.L$2;
        Iterator r22 = (Iterator) r3.L$1;
        List r23 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L38:
        CameraCallbackRecord r24 = r21;
        List r25 = r23;
    L39:
        r17.c(r24);
        long r110 = r24.getTimestamp().longValue();
    L27:
        if (r22.hasNext() == false) goto L41;
        r24 = (CameraCallbackRecord) r22.next();
        Long r26 = r24.getTimestamp();
        if (r26 == null) goto L62;
        r26.longValue();
        if (r24.getTimestamp().longValue() <= r110) goto L39;
        long r111 = r24.getTimestamp().longValue() - r110;
        if (r111 <= 0) goto L39;
        r3.L$0 = r25;
        r3.L$1 = r22;
        r3.L$2 = r24;
        r3.label = 1;
        if (DelayKt.delay(r111, r3) == r5) goto L63;
        r23 = r25;
        r21 = r24;
        goto L38
    L63:
        return r5;
    L62:
        return Unit.INSTANCE;
    L41:
        FLogger.a.i("CameraMockPlayer", "Executed " + r25.size() + " callbacks in realtime mode");
        goto L58
    L16:
        ResultKt.throwOnFailure(r2);
        if (Intrinsics.areEqual(r19, TimingStrategy.b.a) == false) goto L24;
        Iterator r27 = r18.iterator();
    L20:
        if (r27.hasNext() == false) goto L22;
        r17.c((CameraCallbackRecord) r27.next());
        goto L20
    L22:
        FLogger.a.i("CameraMockPlayer", "Executed " + r18.size() + " callbacks immediately");
        goto L58
    L24:
        if (Intrinsics.areEqual(r19, TimingStrategy.c.a) == false) goto L43;
        r22 = r18.iterator();
        r110 = 0;
        r25 = r18;
        goto L27
    L43:
        if ((r19 instanceof TimingStrategy.a) == false) goto L60;
        r10 = 0;
        r8 = r18.iterator();
        r9 = r19;
        r11 = r18;
        goto L46
    L60:
        throw new NoWhenBranchMatchedException();
    L7:
        r3 = new CameraMockPlayer$playbackCallbacksWithTiming$1(r17, r20);
        goto L8
    }
}
