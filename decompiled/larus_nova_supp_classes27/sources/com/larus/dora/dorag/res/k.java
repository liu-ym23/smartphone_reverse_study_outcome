package com.larus.dora.dorag.res;

import com.byted.cast.common.api.CodecType;
import com.byted.cast.common.sink.CastInfo;
import com.byted.cast.common.sink.IMirrorListener;
import com.byted.cast.common.sink.Statistics;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.im.service.audio.vlm.EncodedVideoCodecType;
import com.larus.im.service.audio.vlm.EncodedVideoFrameType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements IMirrorListener {
    public final /* synthetic */ DoraByteCastManager a;

    public final void onAudioOutput(String r1, CodecType.ACODEC_ID r2, byte[] r3, int r4, int r5, int r6, int r7, long r8) {
    }

    public k(DoraByteCastManager r1) {
        this.a = r1;
    }

    public final void onInviteResult(boolean r5) {
        FLogger.a.i(this.a.a, "mirror onInviteResult: success: " + r5);
    }

    public final void onStatistics(Statistics r5) {
        FLogger.a.i(this.a.a, "mirror onStatistics. stat: " + r5);
    }

    public final void onCast(int r8, CastInfo r9) {
        FLogger r0 = FLogger.a;
        String r1 = this.a.a;
        StringBuilder r2 = new StringBuilder("mirror onCast: clientId: ");
        r2.append(r8);
        r2.append(", castInfo: ");
        r2.append(r9);
        r2.append(", extra: ");
        Integer r3 = null;
        if (r9 == null) goto L5;
        String r4 = r9.extra;
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        if (r9 == null) goto L9;
        r3 = Integer.valueOf(r9.infoType);
    L9:
        if (r3 != null) goto L12;
    L17:
        if (r3 != null) goto L20;
    L22:
        if (r3 != null) goto L25;
    L70:
        if (r3 != null) goto L73;
        return;
    L73:
        if (r3.intValue() != 102) goto L88;
        ((ConcurrentHashMap) this.a.g).remove(String.valueOf(r8));
        return;
    L88:
        return;
    L25:
        if (r3.intValue() != 109) goto L70;
        DoraByteCastManager r10 = this.a;
        r10.getClass();
        if (r9.infoType != 109) goto L49;
        String r11 = r9.extra;
        if (r11 != null) goto L32;
    L35:
        boolean r5 = true;
    L36:
        if (r5 == true) goto L49;
        JSONObject r6 = new JSONObject(r11);     // Catch: Exception -> L47
        String r7 = r6.optString("msg");     // Catch: Exception -> L47
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L47
        if (r7.length() <= 0) goto L41;
        boolean r12 = true;
    L42:
        if (r12 == false) goto L44;
        r6 = new JSONObject(r7);     // Catch: Exception -> L47
    L44:
        int r13 = r6.optInt("videoChan", -1);     // Catch: Exception -> L47
        int r14 = r6.optInt("videoPort", 0);     // Catch: Exception -> L47
        if (r13 != 2) goto L49;
    L50:
        if (r14 > 0) goto L53;
        FLogger.a.i(this.a.a, "mirror onCast: skip register channel 2, invalid videoPort: " + r14);
        return;
    L53:
        b49.c r15 = new b49.c(2, r14, InetAddress.getByName("127.0.0.1"));
        DoraByteCastManager r16 = this.a;
        List<b49.c> r17 = r16.A;
        if (r17 != null) goto L56;
        r17 = CollectionsKt.emptyList();
    L56:
        ArrayList r18 = new ArrayList();
        Iterator<T> r20 = r17.iterator();
    L58:
        if (r20.hasNext() == false) goto L65;
        Object r21 = r20.next();
        if (((b49.c) r21).a != r15.a) goto L62;
        boolean r22 = true;
    L63:
        if (r22 == true) goto L58;
        r18.add(r21);
        goto L58
    L62:
        r22 = false;
        goto L63
    L65:
        r16.A = CollectionsKt.plus(r18, r15);
        IDoraService r23 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r23 == null) goto L85;
        AbilityService r24 = r23.o0();
        if (r24 == null) goto L86;
        r24.o(CollectionsKt.listOf(r15));
        return;
    L86:
        return;
    L85:
        return;
    L41:
        r12 = false;
    L47:
        e = move-exception;
        FLogger.a.e(r10.a, "parseVideoPort error, extra: " + r11, e);
        goto L49
    L32:
        if (r11.length() == 0) goto L35;
        r5 = false;
    L49:
        r14 = 0;
        goto L50
    L20:
        if (r3.intValue() != 101) goto L22;
        DoraByteCastManager r25 = this.a;
        r25.p = r9;
        r0.i(r25.a, "mirror onCast: TYPE_CAST, act : " + AppHost.a.a().getCurrentActivity());
        return;
    L12:
        if (r3.intValue() != 100) goto L17;
        DoraByteCastManager r26 = this.a;
        String r27 = r9.clientID;
        if (r27 != null) goto L16;
        r27 = "";
    L16:
        r26.f = r27;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onVolume(String r5, int r6) {
        FLogger.a.i(this.a.a, "mirror onVolume. clientId: " + r5 + ", desiredVolume: " + r6);
    }

    public final void onError(String r5, int r6, String r7) {
        FLogger.a.e(this.a.a, "mirror onError. clientId: " + r5 + ", errCode: " + r6 + ", errMsg: " + r7);
    }

    public final void onNotifyLatency(String r5, Long r6, HashMap<String, Long> r7) {
        FLogger.a.i(this.a.a, "mirror onNotifyLatency. clientId: " + r5 + ", frameIndex: " + r6 + ", latencyMap: " + r7);
    }

    public final void onSinkLatencyStat(int r5, String r6, String r7) {
        FLogger.a.i(this.a.a, "mirror onSinkLatencyStat: id: " + r5 + ", ip: " + r6 + ", stat: " + r7);
    }

    public final void onSinkStuckStat(int r5, String r6, String r7) {
        FLogger.a.i(this.a.a, "mirror onSinkStuckStat: id: " + r5 + ", ip: " + r6 + ", stat: " + r7);
    }

    public final void onVideoOutput(String r24, CodecType.VCODEC_ID r25, byte[] r26, int r27, int r28, long r210, int r31) {
        long r9 = r210 / 1000;
        boolean r4 = Intrinsics.areEqual(r24, "127.0.0.1");
        FLogger r13 = FLogger.a;
        r13.i(this.a.a, "mirror onVideoOutput. clientId: " + r24 + ", vcodecId: " + r25 + " width: " + r27 + ", height:" + r28 + ", timestampMs: " + r9 + ", timestampUs: " + r210 + ", nalType: " + r31 + ", has_ocr=" + r4);
        if (r26 == null) goto L70;
        if (r24 == null) goto L70;
        if (r31 != 1) goto L9;
        this.a.getClass();
        this.a.getClass();
        if (r25 != null) goto L40;
        int r2 = -1;
    L42:
        if (r2 != 1) goto L44;
        EncodedVideoCodecType r3 = EncodedVideoCodecType.H265;
    L45:
        EncodedVideoCodecType r14 = r3;
        EncodedVideoFrameType r15 = EncodedVideoFrameType.DELTA;
        JSONObject r5 = new JSONObject();
        DoraByteCastManager r12 = this.a;
        r5.put("gen_utc_timestamp", r9);
        r5.put("trans_type", r12.n);
        r5.put("has_ocr", r4);
        Unit r6 = Unit.INSTANCE;
        DoraByteCastManager.j(this.a, r24, new tf9.a(r26, null, r210, r27, r28, 90, r14, r15, r5.toString().getBytes(Charsets.UTF_8), 514));
    L46:
        DoraByteCastManager r7 = this.a;
        if (r7.z == false) goto L78;
    L67:
        e = move-exception;
        FLogger.a.e(r7.a, "[dumpVideo] error=" + e.getMessage());
        return;
    L49:
        if (r7.y != null) goto L62;
        String r0 = new SimpleDateFormat("yyyy_MMdd_HH_mm_ss").format(new Date());     // Catch: IOException -> L67
        StringBuilder r8 = new StringBuilder();     // Catch: IOException -> L67
        File r10 = AppHost.a.getApplication().getExternalFilesDir(null);     // Catch: IOException -> L67
        if (r10 == null) goto L54;
        String r11 = r10.getAbsolutePath();     // Catch: IOException -> L67
        if (r11 == null) goto L54;
    L55:
        r8.append(r11);     // Catch: IOException -> L67
        String r16 = File.separator;     // Catch: IOException -> L67
        r8.append(r16);     // Catch: IOException -> L67
        r8.append("bytecast");     // Catch: IOException -> L67
        r8.append(r16);     // Catch: IOException -> L67
        r8.append("video");     // Catch: IOException -> L67
        r8.append(r16);     // Catch: IOException -> L67
        r8.append(r0);     // Catch: IOException -> L67
        r8.append("_VIDEO.bitstream");     // Catch: IOException -> L67
        PolarisFileWrapper r17 = new PolarisFileWrapper(r8.toString());     // Catch: IOException -> L67
        File r1 = r17.getParentFile();     // Catch: IOException -> L67
        if (r1 == null) goto L59;
        r1.mkdirs();     // Catch: IOException -> L67
    L59:
        if (r17.exists() == true) goto L61;
        r17.createNewFile();     // Catch: IOException -> L67
    L61:
        r7.y = new PolarisFileOutputStreamWrapper(r17, true);     // Catch: IOException -> L67
    L54:
        r11 = "";
    L62:
        PolarisFileOutputStreamWrapper r18 = r7.y;     // Catch: IOException -> L67
        if (r18 == null) goto L65;
        r18.write(r26);     // Catch: IOException -> L67
    L65:
        r13.i(r7.a, "[dumpVideo] dump VIDEO success");     // Catch: IOException -> L67
        return;
    L78:
        return;
    L44:
        r3 = EncodedVideoCodecType.H264;
        goto L45
    L40:
        r2 = DoraByteCastManager.b.a[r25.ordinal()];
        goto L42
    L9:
        if (r31 != 5) goto L11;
        byte[] r20 = (byte[]) ((ConcurrentHashMap) this.a.g).get(r24);
        if (r20 != null) goto L22;
        r20 = new byte[0];
    L22:
        if (r20.length != 0) goto L24;
        boolean r110 = true;
    L25:
        if (r110 == false) goto L28;
        r13.w(this.a.a, "key video frame has no codec config, clientId=" + r24 + ", codec=" + r25 + ", timestampUs=" + r210 + ", dataSize=" + r26.length);
    L28:
        this.a.getClass();
        this.a.getClass();
        if (r25 != null) goto L31;
        int r21 = -1;
    L33:
        if (r21 != 1) goto L35;
        EncodedVideoCodecType r22 = EncodedVideoCodecType.H265;
    L36:
        EncodedVideoCodecType r111 = r22;
        EncodedVideoFrameType r112 = EncodedVideoFrameType.KEY;
        JSONObject r23 = new JSONObject();
        DoraByteCastManager r30 = this.a;
        r23.put("gen_utc_timestamp", r9);
        r23.put("trans_type", r30.n);
        r23.put("has_ocr", r4);
        Unit r32 = Unit.INSTANCE;
        DoraByteCastManager.j(this.a, r24, new tf9.a(r26, r20, r210, r27, r28, 90, r111, r112, r23.toString().getBytes(Charsets.UTF_8), 512));
        goto L46
    L35:
        r22 = EncodedVideoCodecType.H264;
        goto L36
    L31:
        r21 = DoraByteCastManager.b.a[r25.ordinal()];
        goto L33
    L24:
        r110 = false;
        goto L25
    L11:
        if (r31 == 7) goto L13;
        r13.w(this.a.a, "drop video output: unsupported nalType=" + r31 + ", clientId=" + r24 + ", codec=" + r25 + ", timestampUs=" + r210 + ", dataSize=" + r26.length);
        goto L46
    L13:
        ((ConcurrentHashMap) this.a.g).put(r24, r26);
        DoraByteCastManager r33 = this.a;
        t39.g r34 = r33.b;
        if (r34 != null) goto L16;
        r13.w(r33.a, "drop video codec callback: callback not registered, clientId=" + r24 + ", codec=" + r25 + ", codecConfigSize=" + r26.length);
        goto L46
    L16:
        r13.i(r33.a, "cache video codec info, clientId=" + r24 + ", codec=" + r25 + ", codecConfigSize=" + r26.length);
        r34.c();
    L70:
        String r35 = this.a.a;
        StringBuilder r36 = new StringBuilder("drop video output: invalid input, clientId=");
        r36.append(r24);
        r36.append(", hasData=");
        if (r26 == null) goto L73;
        boolean r113 = true;
    L74:
        r36.append(r113);
        r36.append(", width=");
        r36.append(r27);
        r36.append(", height=");
        r36.append(r28);
        r36.append(", timestampUs=");
        r36.append(r210);
        r36.append(", nalType=");
        r36.append(r31);
        r13.w(r35, r36.toString());
        return;
    L73:
        r113 = false;
        goto L74
    }
}
