package com.obric.assistant.ipc;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.structures.SAMICoreTruthCollectorData;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.audio.IObricWakeupTruthUploadService;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.e;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import hga.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.CRC32;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tha.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0007\u0018\u0000 62\u00020\u0001:\u000256B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000bH\u0002J \u0010(\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u001d\u0010+\u001a\u0004\u0018\u0001H,\"\u0004\b\u0000\u0010,2\u0006\u0010-\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u00100\u001a\u00020\u000b*\u0004\u0018\u00010\u000bH\u0002J\u000e\u00101\u001a\u00020\u000b*\u0004\u0018\u00010\u000bH\u0002J\f\u00102\u001a\u00020\u000b*\u000203H\u0002J\b\u00104\u001a\u00020\u000fH\u0002¨\u00067"}, d2 = {"Lcom/obric/assistant/ipc/WakeupTruthUploadManager;", "Lcom/obric/assistant/spi/audio/IObricWakeupTruthUploadService;", "<init>", "()V", "onVoiceWakeupCaptureStarted", "", "onVoiceWakeupAudioCaptured", "data", "Lcom/obric/assistant/spi/audio/WakeupTruthUploadData;", "clearRegisterDataIdForUid", "uid", "", WindowEvent.Params.REASON, "markVoiceprintRecordedForNextWakeup", "consumeFirstWakeupAfterVoiceprintRecord", "", "markWakeupPocketMode", "wakeupId", "", "pocketMode", "consumeWakeupPocketMode", "uploadInternal", "ensureCryptoReady", "context", "Landroid/content/Context;", "buildTruthData", "Lcom/mammon/audiosdk/structures/SAMICoreTruthCollectorData;", "resolveObricDeviceUuid", "resolveRegisterDataIdKey", "resolveLegacyRegisterDataIdKey", "buildVoiceprintUid", "rawUid", "did", "logTruthUploadDataFields", "uploadData", "initContextAwareness", "releaseContextAwarenessIfIdle", "buildCreateParam", "Lcom/mammon/audiosdk/structures/SAMICoreServerCommonContextCreateParameter;", "header", "saveRegisterDataIdIfNeeded", "response", "parseRegisterDataId", "getMemoryFeature", "T", "featureName", "(Ljava/lang/String;)Ljava/lang/Object;", "buildVoiceprintDbPath", "toLogTail", "toPathTail", "crc32Hex", "", "isBluetoothConnected", "TruthUploadOutcome", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupTruthUploadManager implements IObricWakeupTruthUploadService {
    public static final ExecutorService a = null;
    public static final ExecutorService b = null;
    public static final ExecutorService c = null;
    public static final AtomicInteger d = null;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "TruthUploadOutcome(ret=" + this.a + ", response=" + this.b + ')';
        }

        public b(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "response");
            this.a = r2;
            this.b = r3;
        }
    }

    public WakeupTruthUploadManager() {
    }

    static {
        a = PThreadExecutorsUtils.newSingleThreadExecutor(new s());
        b = PThreadExecutorsUtils.newCachedThreadPool(new t());
        c = PThreadExecutorsUtils.newSingleThreadExecutor(new u());
        d = new AtomicInteger(0);
    }

    public static void l() {
        if (d.updateAndGet(new z()) != 0) goto L6;
        c.execute(new a0());
        return;
    }

    public static String m() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(obricDeviceManagerDelegate.b.getUuid());     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        FLogger.a.e("WakeupTruthUploadManager", "resolve obric device uuid failed: " + r2.getMessage(), r2);
    L10:
        if (Result.isFailure-impl(r1) == false) goto L13;
        r1 = "";
    L13:
        return (String) r1;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void b() {
        final Context r0 = AppHost.a.getApplication().getApplicationContext();
        d.incrementAndGet();
        if (NetworkUtils.isNetworkAvailable(r0) == true) goto L5;
        return;
    L5:
        c.execute(new v(this, r0));
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final boolean c() {
        Lazy r0 = r.a;
        boolean r1 = ((Keva) r0.getValue()).getBoolean("first_wakeup_after_voiceprint_record_pending", false);
        if (r1 == false) goto L5;
        ((Keva) r0.getValue()).storeBoolean("first_wakeup_after_voiceprint_record_pending", false);
    L5:
        FLogger.a.i("WakeupTruthUploadContextStore", "consume first wakeup after voiceprint record pending=" + r1);
        return r1;
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void a() {
        Intrinsics.checkNotNullParameter("voiceprint enroll success", WindowEvent.Params.REASON);
        Lazy r2 = r.a;
        Intrinsics.checkNotNullParameter("voiceprint enroll success", WindowEvent.Params.REASON);
        ((Keva) r.a.getValue()).storeBoolean("first_wakeup_after_voiceprint_record_pending", true);
        FLogger.a.i("WakeupTruthUploadContextStore", "mark first wakeup after voiceprint record pending reason=voiceprint enroll success");
    }

    public static Object j(String r8) {
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        MemoryResponse r5 = e.a.b(r8);     // Catch: Throwable -> L9
        if (r5.a() == false) goto L6;
        Object r2 = r5.c;     // Catch: Throwable -> L9
    L7:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L9
    L11:
        Throwable r6 = Result.exceptionOrNull-impl(r3);
        if (r6 == null) goto L15;
        FLogger.a.e("WakeupTruthUploadManager", "get memory feature exception feature=" + r8 + " msg=" + r6.getMessage());
    L15:
        if (Result.isFailure-impl(r3) == false) goto L18;
        return null;
    L18:
        return r3;
    L6:
        FLogger.a.w("WakeupTruthUploadManager", "get memory feature failed feature=" + r8 + " code=" + r5.a + " msg=" + r5.b);     // Catch: Throwable -> L9
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static String o(String r2) {
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        if (r2.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "";
    L12:
        return "***" + StringsKt.takeLast(r2, 4);
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void e(final g r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        a.execute(new w(this, r3));
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final boolean g(int r5) {
        Lazy r0 = r.a;
        boolean r1 = false;
        if (r5 <= 0) goto L9;
        Boolean r2 = r.b.remove(Integer.valueOf(r5));
        if (r2 == null) goto L8;
        r1 = r2.booleanValue();
    L8:
        FLogger.a.i("WakeupTruthUploadContextStore", "consume pocket mode wakeupId=" + r5 + " pocketMode=" + r1);
    L9:
        return r1;
    }

    public static SAMICoreTruthCollectorData h(Context r7, g r8) {
        Lazy r0 = d0.a;
        String r1 = r8.l;
        String r2 = r8.m;
        if (StringsKt.isBlank(r2) == false) goto L5;
        r2 = i(r8.l, r8.n);
    L5:
        Intrinsics.checkNotNullParameter(r1, "primaryUid");
        Intrinsics.checkNotNullParameter(r2, "legacyUid");
        String r3 = d0.b(r1);
        boolean r4 = true;
        if (r3.length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
    L16:
        String r6 = m();
        SAMICoreTruthCollectorData r9 = new SAMICoreTruthCollectorData();
        r9.audio_data = r8.f;
        r9.audio_config = "{\"format\":\"pcm\",\"sample_rate\":16000,\"channel\":4}";
        r9.event_type = "truth_collector_wakeup";
        r9.id = r6;
        r9.app_version = AppHost.a.getVersionName();
        r9.group_id = r8.k;
        r9.sn = r6;
        r9.vui_id = String.valueOf(r8.a);
        r9.uid = r8.m;
        r9.did = r8.n;
        r9.first_engine_version = r8.h;
        r9.kws_model_md5 = r8.i;
        r9.sid_model_md5 = r8.j;
        r9.bargin_status = r8.p;
        r9.volume = r8.q;
        r9.confidence = r8.r;
        Integer r10 = (Integer) j("har_activity_state");
        if (r10 == null) goto L19;
        int r11 = r10.intValue();
    L20:
        r9.scene = r11;
        String r12 = (String) j("current_location_type");
        String r13 = "";
        if (r12 != null) goto L23;
        r12 = "";
    L23:
        r9.current_location_type = r12;
        r9.ohr_hand = r8.s;
        r9.pocket_mode = r8.t;
        r9.first_wakeup_after_boot = r8.u;
        r9.first_wakeup_after_voiceprint_record = r8.v;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L38
        IBluetoothHeadSetAPI r15 = c.a();     // Catch: Throwable -> L38
        if (r15 != null) goto L27;
    L35:
        r4 = false;
    L36:
        Object r16 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L38
    L40:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L43;
        FLogger.a.w("WakeupTruthUploadManager", "truth upload get bluetooth state failed: " + r17.getMessage());
    L43:
        Boolean r18 = Boolean.FALSE;
        if (Result.isFailure-impl(r16) == false) goto L46;
        r16 = r18;
    L46:
        r9.is_bluetooth_on = ((Boolean) r16).booleanValue();
        r9.extra = "";
        File r19 = r7.getFilesDir();
        if (r19 == null) goto L55;
        File r20 = r19.getParentFile();
        if (r20 == null) goto L55;
        PolarisFileWrapper r21 = new PolarisFileWrapper(r20, "voiceprint_db");
        if (r21.exists() == true) goto L54;
        r21.mkdirs();
    L54:
        r13 = new PolarisFileWrapper(r21, "voice_print.db").getAbsolutePath();
    L55:
        r9.register_data_id = r3;
        r9.sid_embedding = r13;
        r9.register_audio_data = r13;
        return r9;
    L27:
        if (r15.a() == false) goto L29;
    L32:
        boolean r22 = true;
    L33:
        if (r22 != true) goto L35;
    L29:
        if (r15.h() == true) goto L32;
        r22 = false;
    L38:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L19:
        r11 = 0;
        goto L20
    L11:
        if (StringsKt.isBlank(r2) == true) goto L16;
        if (Intrinsics.areEqual(r2, r1) == true) goto L16;
        r3 = d0.b(r2);
        goto L16
    L8:
        r5 = false;
        goto L9
    }

    public static String i(String r1, String r2) {
        if ((!StringsKt.isBlank(r1)) == true) goto L5;
    L7:
        return "";
    L5:
        if ((!StringsKt.isBlank(r2)) == false) goto L7;
        return r1 + '-' + r2;
    }

    public static void k(g r9, SAMICoreTruthCollectorData r10) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("truth upload data fields wakeupId=");
        r1.append(r9.a);
        r1.append(" vuiId=");
        r1.append(r10.vui_id);
        r1.append(" eventType=");
        r1.append(r10.event_type);
        r1.append(" audioBytes=");
        byte[] r2 = r10.audio_data;
        boolean r3 = false;
        if (r2 == null) goto L5;
        int r4 = r2.length;
    L6:
        r1.append(r4);
        r1.append(" audioDurationMs=");
        r1.append(r9.g);
        r1.append(" audioCrc32=");
        byte[] r5 = r9.f;
        CRC32 r6 = new CRC32();
        r6.update(r5);
        r1.append(Long.toHexString(r6.getValue()));
        r1.append(" audioConfig=");
        r1.append(r10.audio_config);
        r1.append(" appVersion=");
        r1.append(r10.app_version);
        r1.append(" groupIdLen=");
        r1.append(r10.group_id.length());
        r1.append(" id=");
        r1.append(o(r10.id));
        r1.append(" sn=");
        r1.append(o(r10.sn));
        r1.append(" uid=");
        r1.append(o(r10.uid));
        r1.append(" did=");
        r1.append(o(r10.did));
        r1.append(" firstEngineVersion=");
        r1.append(r10.first_engine_version);
        r1.append(" kwsModelMd5=");
        r1.append(r10.kws_model_md5);
        r1.append(" sidModelMd5=");
        r1.append(r10.sid_model_md5);
        r1.append(" barginStatus=");
        r1.append(r10.bargin_status);
        r1.append(" volume=");
        r1.append(r10.volume);
        r1.append(" confidence=");
        r1.append(r10.confidence);
        r1.append(" scene=");
        r1.append(r10.scene);
        r1.append(" currentLocationType=");
        r1.append(r10.current_location_type);
        r1.append(" ohrHand=");
        r1.append(r10.ohr_hand);
        r1.append(" pocketMode=");
        r1.append(r9.t);
        r1.append(" firstWakeupAfterBoot=");
        r1.append(r9.u);
        r1.append(" firstWakeupAfterVoiceprintRecord=");
        r1.append(r9.v);
        r1.append(" isBluetoothOn=");
        r1.append(r10.is_bluetooth_on);
        r1.append(" extra=");
        r1.append(r10.extra);
        r1.append(" registerDataId=");
        r1.append(o(r10.register_data_id));
        r1.append(" sidEmbeddingPath=");
        String r11 = r10.sid_embedding;
        String r7 = "";
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        if (r11.length() != 0) goto L12;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L16;
        String r12 = "";
    L17:
        r1.append(r12);
        r1.append(" registerAudioDataPath=");
        String r13 = r10.register_audio_data;
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        if (r13.length() != 0) goto L23;
        r3 = true;
    L23:
        if (r3 == true) goto L26;
        r7 = StringsKt.substringAfterLast$default(r13, '/', null, 2, null);
    L26:
        r1.append(r7);
        r0.i("WakeupTruthUploadManager", r1.toString());
        return;
    L16:
        r12 = StringsKt.substringAfterLast$default(r11, '/', null, 2, null);
        goto L17
    L12:
        r8 = false;
        goto L14
    L5:
        r4 = 0;
        goto L6
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void d(int r6, boolean r7) {
        Lazy r0 = r.a;
        if (r6 > 0) goto L5;
        FLogger.a.i("WakeupTruthUploadContextStore", "mark pocket mode skipped invalid wakeupId=" + r6 + " pocketMode=" + r7);
        return;
    L5:
        if (r7 == false) goto L7;
        r.b.put(Integer.valueOf(r6), Boolean.TRUE);
    L8:
        FLogger.a.i("WakeupTruthUploadContextStore", "mark pocket mode wakeupId=" + r6 + " pocketMode=" + r7);
        return;
    L7:
        r.b.remove(Integer.valueOf(r6));
        goto L8
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void f(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.REASON);
        String r1 = i(r8, m());
        Lazy r2 = d0.a;
        Intrinsics.checkNotNullParameter(r1, "primaryUid");
        Intrinsics.checkNotNullParameter(r8, "legacyUid");
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.REASON);
        d0.a(r1, r9);
        if ((!StringsKt.isBlank(r8)) == false) goto L8;
        if (Intrinsics.areEqual(r8, r1) == true) goto L8;
        d0.a(r8, r9 + " legacy");
    L8:
        if (StringsKt.isBlank(r8) == true) goto L20;
        String r10 = d0.c(r8 + '-');
        Set r0 = ((Keva) d0.a.getValue()).getAll().keySet();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        Object r5 = r4.next();
        String r6 = (String) r5;
        Intrinsics.checkNotNull(r6);
        if (StringsKt.startsWith$default(r6, r10, false, 2, null) == false) goto L12;
        r3.add(r5);
        goto L12
    L16:
        Iterator r11 = r3.iterator();
    L18:
        if (r11.hasNext() == false) goto L27;
        String r7 = (String) r11.next();
        ((Keva) d0.a.getValue()).erase(r7);
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("clear register_data_id key=");
        Intrinsics.checkNotNull(r7);
        r13.append(StringsKt.padStart(StringsKt.takeLast(r7, 4), RangesKt.coerceAtMost(r7.length(), 4), '*'));
        r13.append(" reason=");
        r13.append(r9);
        r12.i("WakeupTruthUploadRegisterDataStore", r13.toString());
        goto L18
    L27:
        return;
    }

    public static void n(String r3, String r4, int r5) {
        boolean r1 = true;
        String r2 = "";
        String r6 = r2;
        if (StringsKt.isBlank(r4) == true) goto L19;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        String r7 = new JSONObject(r4).optString("payload");     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L11
        if ((!StringsKt.isBlank(r7)) == false) goto L8;
        String r8 = new JSONObject(r7).optString("register_data_id");     // Catch: Throwable -> L11
    L9:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L11
    L13:
        Object r10 = r2;
        if (Result.isFailure-impl(r9) == true) goto L17;
        r10 = r9;
    L17:
        r6 = (String) r10;
        goto L19
    L8:
        r8 = "";
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        if (r3.length() <= 0) goto L21;
        boolean r12 = true;
    L22:
        if (r12 == true) goto L24;
        return;
    L24:
        if (r6.length() > 0) goto L27;
        r1 = false;
    L27:
        if (r1 == false) goto L39;
        Lazy r13 = d0.a;
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r6, "registerDataId");
        if (StringsKt.isBlank(r3) == false) goto L31;
    L34:
        FLogger.a.i("WakeupTruthUploadManager", "truth upload register_data_id saved wakeupId=" + r5 + " uid=" + o(r3));
        return;
    L31:
        if (StringsKt.isBlank(r6) == true) goto L34;
        ((Keva) d0.a.getValue()).storeString(d0.c(r3), r6);
        goto L34
    L39:
        return;
    L21:
        r12 = false;
        goto L22
    }
}
