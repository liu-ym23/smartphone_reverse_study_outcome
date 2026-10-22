package j2a;

import bu9.j;
import bu9.m;
import bu9.o;
import com.larus.platform.model.camera.ve.Ratio;
import com.ss.android.vesdk.VEAudioEncodeSettings;
import com.ss.android.vesdk.VEVideoEncodeSettings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import pq9.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b extends c {
    public final Ratio d;
    public final Lazy e;

    @Override // j2a.c
    public final int c() {
        if (this.d != Ratio.RATIO_FULL_SCREEN) goto L6;
        k.a.getClass();
        return ((Number) k.d.getFirst()).intValue();
    L6:
        return this.b;
    }

    public final VEAudioEncodeSettings d() {
        j r0 = ((m) this.e.getValue()).a();
        if (r0 == null) goto L14;
        VEAudioEncodeSettings.Builder r1 = new VEAudioEncodeSettings.Builder();
        int r2 = r0.a();
        if (r2 != 0) goto L7;
        VEAudioEncodeSettings.ENCODE_STANDARD r3 = VEAudioEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_WAV;
    L11:
        VEAudioEncodeSettings r4 = r1.setCodec(r3).Build();
        if (r4 == null) goto L14;
        return r4;
    L7:
        if (r2 == 1) goto L9;
        r3 = VEAudioEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_AAC;
        goto L11
    L9:
        r3 = VEAudioEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_PCM;
    L14:
        return new VEAudioEncodeSettings.Builder().setCodec(VEAudioEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_AAC).Build();
    }

    public final VEVideoEncodeSettings e() {
        Pair<Integer, Integer> r0 = b();
        o r1 = ((m) this.e.getValue()).b();
        if (r1 == null) goto L13;
        VEVideoEncodeSettings.Builder r2 = new VEVideoEncodeSettings.Builder(1).setSupportHwEnc(r1.d()).setVideoRes(((Number) r0.getFirst()).intValue(), ((Number) r0.getSecond()).intValue()).enableRecordingMp4(r1.a());
        int r3 = r1.b();
        if (r3 != 0) goto L7;
        VEVideoEncodeSettings.ENCODE_STANDARD r4 = VEVideoEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_H264;
    L11:
        VEVideoEncodeSettings r5 = r2.setEncodeStandard(r4).setEncodeProfile(VEVideoEncodeSettings.ENCODE_PROFILE.ENCODE_PROFILE_MAIN).setFps(r1.c()).build();
        if (r5 == null) goto L13;
        return r5;
    L7:
        if (r3 == 2) goto L9;
        r4 = VEVideoEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_ByteVC1;
        goto L11
    L9:
        r4 = VEVideoEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_MPEG4;
    L13:
        Pair<Integer, Integer> r6 = b();
        return new VEVideoEncodeSettings.Builder(1).setSupportHwEnc(true).setVideoRes(((Number) r6.getFirst()).intValue(), ((Number) r6.getSecond()).intValue()).enableRecordingMp4(true).setEncodeStandard(VEVideoEncodeSettings.ENCODE_STANDARD.ENCODE_STANDARD_ByteVC1).setEncodeProfile(VEVideoEncodeSettings.ENCODE_PROFILE.ENCODE_PROFILE_MAIN).build();
    }

    public b(Ratio r2) {
        Intrinsics.checkNotNullParameter(r2, "ratio");
        super(r2);
        this.d = r2;
        this.e = LazyKt.lazy(new a());
    }
}
