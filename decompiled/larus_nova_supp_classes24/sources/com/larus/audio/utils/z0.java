package com.larus.audio.utils;

import android.os.SystemClock;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.audio.SoundsSource;
import com.larus.platform.service.z2;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class z0 implements Runnable {
    public final /* synthetic */ SoundsSource a;
    public final /* synthetic */ String b;

    public /* synthetic */ z0(SoundsSource r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoundsSource r0 = this.a;
        String r2 = this.b;
        SoundsMobHelper.g = SystemClock.elapsedRealtime();
        SoundsMobHelper.u = null;
        SoundsMobHelper r8 = SoundsMobHelper.a;
        SoundsSource r9 = SoundsMobHelper.h;
        SoundsSource r10 = SoundsSource.NOT_PLAY;
        if (r0 != r10) goto L9;
        if (com.larus.utils.o0.d(SoundsMobHelper.k) == false) goto L7;
        SoundsMobHelper.j = SoundsMobHelper.k;
    L7:
        SoundsMobHelper.k = "";
    L9:
        if (r9 == r10) goto L11;
        SoundsMobHelper.p = false;
        SoundsMobHelper.s = SystemClock.elapsedRealtime();
        SoundsMobHelper.i = r9;
    L11:
        SoundsMobHelper.h = r0;
        if (com.larus.utils.o0.d(SoundsMobHelper.k) == false) goto L14;
        SoundsMobHelper.j = SoundsMobHelper.k;
    L14:
        SoundsMobHelper.k = r2;
        if (SoundsMobHelper.p == true) goto L17;
    L46:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L37
        if (r0 != SoundsSource.MESSAGE_TTS) goto L22;
    L25:
        boolean r1 = true;
    L26:
        if (r1 == false) goto L35;
        float r4 = Random.Default.nextFloat();     // Catch: Throwable -> L37
        z2 r5 = z2.a;     // Catch: Throwable -> L37
        if (r4 > r5.audioSoundsQualityConfig().b()) goto L34;
        SoundsMobHelper.r = 0;     // Catch: Throwable -> L37
        SoundsMobHelper.q = true;     // Catch: Throwable -> L37
        SoundsMobHelper.l().reset();     // Catch: Throwable -> L37
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L37
        r6.put("sample_rate", r5.Y());     // Catch: Throwable -> L37
        r6.put("num_channel", 1);     // Catch: Throwable -> L37
        r6.put("max_block_size", r5.audioSoundsQualityConfig().a());     // Catch: Throwable -> L37
        r6.put("online", true);     // Catch: Throwable -> L37
        r6.put("cutoff_freq", true);     // Catch: Throwable -> L37
        r6.put("phase_check", true);     // Catch: Throwable -> L37
        r6.put("rms_stats", true);     // Catch: Throwable -> L37
        r6.put("clipping", true);     // Catch: Throwable -> L37
        r6.put("loudness", true);     // Catch: Throwable -> L37
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L37
        r7.put("enable_fake_stereo", true);     // Catch: Throwable -> L37
        r7.put("enable_cutoff_frequency", true);     // Catch: Throwable -> L37
        r7.put("enable_clipping", true);     // Catch: Throwable -> L37
        r7.put("enable_pure_silence", true);     // Catch: Throwable -> L37
        r7.put("enable_silence", true);     // Catch: Throwable -> L37
        r7.put("enable_dc_offset", true);     // Catch: Throwable -> L37
        r7.put("enable_too_loud", true);     // Catch: Throwable -> L37
        r7.put("enable_dynamic_range", true);     // Catch: Throwable -> L37
        r7.put("enable_peak_gt3", true);     // Catch: Throwable -> L37
        r7.put("enable_snr_lte0", true);     // Catch: Throwable -> L37
        r7.put("enable_phase", true);     // Catch: Throwable -> L37
        r7.put("enable_noise", true);     // Catch: Throwable -> L37
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L37
        r11.put("type", "alg_param");     // Catch: Throwable -> L37
        r11.put("param", r6);     // Catch: Throwable -> L37
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L37
        r12.put("type", "business_param");     // Catch: Throwable -> L37
        r12.put("param", r7);     // Catch: Throwable -> L37
        JSONArray r13 = new JSONArray();     // Catch: Throwable -> L37
        r13.put(r11);     // Catch: Throwable -> L37
        r13.put(r12);     // Catch: Throwable -> L37
        int r14 = SoundsMobHelper.l().prepare(r13.toString());     // Catch: Throwable -> L37
        if (r14 == 0) goto L35;
        m58.v r15 = m58.h.i;     // Catch: Throwable -> L37
        if (r15 == null) goto L35;
        r15.e("SoundsMobHelper", "prepare audioMetricsLite error! result=" + r14);     // Catch: Throwable -> L37
        goto L35
    L34:
        SoundsMobHelper.q = false;     // Catch: Throwable -> L37
        return;
    L35:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L49;
        EnsureManager.ensureNotReachHere(r17);
        m58.v r19 = m58.h.i;
        if (r19 == null) goto L48;
        r19.e("SoundsMobHelper", "onPlayStart. err=" + r17);
        return;
    L48:
        return;
    L49:
        return;
    L22:
        if (r0 == SoundsSource.REALTIME_CALL) goto L25;
        r1 = false;
    L37:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L17:
        if (SoundsMobHelper.o != (-1)) goto L46;
        SoundsMobHelper.o = SystemClock.elapsedRealtime();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new SoundsMobHelper$onPlayStart$1$1(null), 2, null);
        goto L46
    }
}
