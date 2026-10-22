package com.obric.audio.continuous_talk;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreAudioBuffer;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreExtractorCreateParam;
import com.mammon.audiosdk.structures.SAMICoreExtractorParam;
import com.mammon.audiosdk.structures.SAMICoreFeature;
import com.mammon.audiosdk.structures.SAMICoreFeatureArray;
import com.mammon.audiosdk.structures.SAMICoreFeatureSet;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s0 {
    public final int a;
    public final SAMICore b;
    public final Object c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public float[] h;

    public static final class a {
    }

    static {
    }

    public s0() {
        this(null);
    }

    public final boolean a() {
        if (this.d == true) goto L5;
    L74:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Result.constructor-impl(Integer.valueOf(this.b.SAMICoreDestroyHandle()));     // Catch: Throwable -> L11
    L13:
        this.e = 16000;
        this.f = 1;
        this.g = 8000;
        SAMICoreExtractorCreateParam r1 = new SAMICoreExtractorCreateParam();
        r1.sampleRate = 16000;
        r1.numChannel = 1;
        r1.maxBlockSize = this.g;
        int r2 = this.b.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Extractor_FLUTEVAD, r1);
        boolean r3 = false;
        if (r2 == 0) goto L17;
        FLogger.a.e("ObricVadModel", "Create SAMICoreIdentify_Extractor_FLUTEVAD failed, ret=" + r2);
        this.d = false;
        return false;
    L17:
        Object r4 = null;
        InputStream r5 = AppHost.a.getApplication().getAssets().open("vad_model_20251124_v1.0.0.model");     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L22
        byte[] r6 = ByteStreamsKt.readBytes(r5);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L27
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L27
    L29:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L33;
        FLogger.a.e("ObricVadModel", "readAssetBinary failed: vad_model_20251124_v1.0.0.model", r8);
    L33:
        if (Result.isFailure-impl(r7) == true) goto L36;
        r4 = r7;
    L36:
        byte[] r9 = (byte[]) r4;
        if (r9 != null) goto L39;
    L45:
        boolean r10 = true;
    L46:
        if (r10 == false) goto L54;
        FLogger.a.e("ObricVadModel", "Load model asset failed: vad_model_20251124_v1.0.0.model");
        Result.constructor-impl(Integer.valueOf(this.b.SAMICoreDestroyHandle()));     // Catch: Throwable -> L50
    L52:
        this.d = false;
        return false;
    L50:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L54:
        SAMICoreProperty r12 = new SAMICoreProperty();
        SAMICorePropertyId r13 = SAMICorePropertyId.SAMICorePropertyId_LoadModelBinary;
        r12.id = r13;
        r12.type = SAMICoreDataType.SAMICoreDataType_ModelBin;
        r12.dataByteArray = r9;
        r12.dataArrayLen = r9.length;
        int r14 = this.b.SAMICoreSetProperty(r13, r12);
        if (r14 == 0) goto L57;
        FLogger.a.e("ObricVadModel", "LoadModelBinary failed ret=" + r14);
        boolean r15 = false;
    L58:
        if (r15 == false) goto L72;
        String r16 = StringsKt.trimIndent("\n            {\n              \"likelihood_threshold\":0.5,\n              \"begin_smooth_window_ms\":480,\n              \"begin_smooth_voice_proportion\":0.5,\n              \"end_smooth_window_ms\":" + this.a + ",\n              \"end_smooth_voice_proportion\":0.925\n            }\n        ");
        SAMICoreExtractorParam r17 = new SAMICoreExtractorParam();
        r17.name = "param";
        r17.strValue = r16;
        SAMICoreProperty r18 = new SAMICoreProperty();
        SAMICorePropertyId r19 = SAMICorePropertyId.SAMICorePropertyID_SetExtractorStringParameter;
        r18.id = r19;
        r18.type = SAMICoreDataType.SAMICoreDataType_ExtractorParameter;
        r18.dataObjectArray = new SAMICoreExtractorParam[]{r17};
        r18.dataArrayLen = 1;
        if (this.b.SAMICoreSetProperty(r19, r18) != 0) goto L68;
        r3 = true;
    L68:
        if (r3 == true) goto L70;
        FLogger.a.w("ObricVadModel", "SetExtractorStringParameter failed, continue with engine defaults");
    L70:
        this.d = true;
        return true;
    L72:
        Result.constructor-impl(Integer.valueOf(this.b.SAMICoreDestroyHandle()));     // Catch: Throwable -> L61
    L63:
        this.d = false;
        return false;
    L61:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    L57:
        r15 = true;
        goto L58
    L39:
        if (r9.length != 0) goto L41;
        boolean r21 = true;
    L42:
        if (r21 == true) goto L45;
        r10 = false;
        goto L46
    L41:
        r21 = false;
        goto L42
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L5:
        if (this.e != 16000) goto L74;
        if (this.f != 1) goto L74;
        return true;
    }

    public final boolean c() {
        Object r0 = this.c;
        monitor-enter(r0);
        boolean r1 = a();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void d() {
        Object r0 = this.c;
        monitor-enter(r0);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        Object r2 = Result.constructor-impl(Integer.valueOf(this.b.SAMICoreDestroyHandle()));     // Catch: Throwable -> L6
    L8:
        Throwable r3 = Result.exceptionOrNull-impl(r2);     // Catch: Throwable -> L14
        if (r3 == null) goto L11;
        FLogger.a.e("ObricVadModel", "release vad model failed", r3);     // Catch: Throwable -> L14
    L11:
        this.d = false;     // Catch: Throwable -> L14
        this.e = 16000;     // Catch: Throwable -> L14
        this.f = 1;     // Catch: Throwable -> L14
        this.g = 8000;     // Catch: Throwable -> L14
        this.h = null;     // Catch: Throwable -> L14
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L14:
        th = move-exception;
        throw th;
    L6:
        th = move-exception;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14
        r2 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L14
        goto L8
    }

    public s0(int r1) {
        this.a = r1;
        this.b = new SAMICore();
        this.c = new Object();
        this.e = 16000;
        this.f = 1;
        this.g = 8000;
    }

    public /* synthetic */ s0(Object r1) {
        this(800);
    }

    public final boolean b(byte[] r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "buffer");
        Object r2 = this.c;
        monitor-enter(r2);
    L63:
        th = move-exception;
        throw th;
    L5:
        boolean r4 = false;
        if (a() == true) goto L9;
        monitor-exit(r2);
        return false;
    L9:
        int r3 = RangesKt.coerceAtLeast(Math.min(r15, r13.length - r14), 0);     // Catch: Throwable -> L63
        if (r3 > 0) goto L15;
        FLogger.a.w("ObricVadModel", "skip empty vad frame, sizeInBytes=" + r15 + ", offsetInBytes=" + r14);     // Catch: Throwable -> L63
        monitor-exit(r2);
        return false;
    L15:
        if (r3 <= 16000) goto L17;
        FLogger.a.w("ObricVadModel", "vad frame too large, clamp to max. maxBytes=16000 actual=" + r3);     // Catch: Throwable -> L63
        r3 = 16000;
    L17:
        int r16 = r3 / 2;     // Catch: Throwable -> L63
        SAMICoreAudioBuffer r0 = new SAMICoreAudioBuffer();     // Catch: Throwable -> L63
        r0.isInterleave = 0;     // Catch: Throwable -> L63
        int r1 = this.f;     // Catch: Throwable -> L63
        r0.numberChannels = r1;     // Catch: Throwable -> L63
        r0.numberSamples = r16;     // Catch: Throwable -> L63
        float[][] r5 = new float[r1][];     // Catch: Throwable -> L63
        int r6 = 0;
    L18:
        if (r6 >= r1) goto L26;
        float[] r7 = new float[r16];     // Catch: Throwable -> L63
        if (r6 != 0) goto L25;
        if (r16 <= 0) goto L25;
        ByteBuffer r8 = ByteBuffer.wrap(r13, r14, r16 * 2).order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L63
        int r9 = 0;
    L23:
        if (r9 >= r16) goto L25;
        r7[r9] = (r8.getShort() / 32767.0f) / 6.0f;     // Catch: Throwable -> L63
        r9 = r9 + 1;     // Catch: Throwable -> L63
    L25:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L63
        r5[r6] = r7;     // Catch: Throwable -> L63
        r6 = r6 + 1;     // Catch: Throwable -> L63
        goto L18
    L26:
        r0.data = r5;     // Catch: Throwable -> L63
        SAMICoreBlock r17 = new SAMICoreBlock();     // Catch: Throwable -> L63
        r17.dataType = SAMICoreDataType.SAMICoreDataType_AudioBuffer;     // Catch: Throwable -> L63
        r17.numberAudioData = 1;     // Catch: Throwable -> L63
        r17.audioData = new SAMICoreAudioBuffer[]{r0};     // Catch: Throwable -> L63
        int r18 = this.b.SAMICoreProcess(r17, null);     // Catch: Throwable -> L63
        if (r18 == 0) goto L31;
        FLogger.a.e("ObricVadModel", "process audio data failed, ret=" + r18 + ", sampleRate=" + this.e + ", maxBlockSize=" + this.g + ", numberSamples=" + r16 + ", inputBytes=" + r3);     // Catch: Throwable -> L63
        monitor-exit(r2);
        return false;
    L31:
        SAMICoreProperty r19 = new SAMICoreProperty();     // Catch: Throwable -> L63
        int r110 = this.b.SAMICoreGetPropertyById(SAMICorePropertyId.SAMICorePropertyID_FrameFeatures, r19);     // Catch: Throwable -> L63
        if (r110 == 0) goto L36;
        FLogger.a.e("ObricVadModel", "get frame features failed, ret=" + r110);     // Catch: Throwable -> L63
        monitor-exit(r2);
        return false;
    L36:
        Object[] r111 = r19.dataObjectArray;     // Catch: Throwable -> L63
        if (r111 != null) goto L40;
        monitor-exit(r2);
        return false;
    L40:
        int r112 = r111.length;     // Catch: Throwable -> L63
        int r11 = 0;
    L41:
        if (r11 >= r112) goto L61;
        Object r12 = r111[r11];     // Catch: Throwable -> L63
        if ((r12 instanceof SAMICoreFeatureSet) == false) goto L45;
        SAMICoreFeatureSet r20 = (SAMICoreFeatureSet) r12;     // Catch: Throwable -> L63
    L46:
        if (r20 == null) goto L60;
        int r21 = r20.numFeatureTypes;     // Catch: Throwable -> L63
        int r22 = 0;
    L49:
        if (r22 >= r21) goto L60;
        SAMICoreFeatureArray r23 = r20.set[r22];     // Catch: Throwable -> L63
        if (r23.featureID != SAMICorePropertyId.SAMICorePropertyID_FrameFeature_FLUTEVAD.getValue()) goto L59;
        SAMICoreFeature[] r24 = r23.array;     // Catch: Throwable -> L63
        if (r24.length <= 0) goto L59;
        SAMICoreFeature r113 = r24[0];     // Catch: Throwable -> L63
        float[] r114 = r113.values;     // Catch: Throwable -> L63
        this.h = Arrays.copyOf(r114, r114.length);     // Catch: Throwable -> L63
        if (r113.numValues <= 0) goto L57;
        r4 = true;
    L57:
        monitor-exit(r2);
        return r4;
    L59:
        r22 = r22 + 1;
    L60:
        r11 = r11 + 1;
        goto L41
    L45:
        r20 = null;
        goto L46
    L61:
        monitor-exit(r2);
        return false;
    }
}
