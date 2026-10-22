package com.larus.business.debug.base.audio.module;

import android.os.Handler;
import com.bytedance.keva.Keva;
import com.larus.platform.service.z2;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ASRModule implements m58.n {
    public final ASRModule$itemMap$1 a;
    public final String b;

    public final int b() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return 0;
    L6:
        return f.a().getInt("keva_asr_mock_sami_core_force_count", -1);
    }

    public final boolean c() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return z2.a.l0();
    L6:
        return f.a().getBoolean("keva_rtc_use_sami_processor", true);
    }

    public final long e() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return 0;
    L6:
        return f.a().getLong("keva_asr_end_force_delay", 0);
    }

    public final long f() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return 0;
    L6:
        return f.a().getLong("keva_asr_mock_sami_core_force_delay", 0);
    }

    public final int g() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return 0;
    L6:
        return f.a().getInt("keva_asr_mock_sami_core_error_type", 0);
    }

    public final long h() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return 0;
    L6:
        return f.a().getLong("keva_asr_stream_force_delay", 0);
    }

    public final long i() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return 0;
    L6:
        return f.a().getLong("keva_init_audio_task_force_delay", 0);
    }

    public final Boolean j() {
        boolean r0 = c78.a.a;
        Keva r1 = c78.a.g;
        if (r1.contains("key_enable_main_bot_mmt") == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r1.getBoolean("key_enable_main_bot_mmt", true));
    }

    public final int k() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return 0;
    L6:
        return f.a().getInt("keva_realtime_call_hangup_time_interval", 0);
    }

    public final Boolean l() {
        boolean r0 = c78.a.a;
        Keva r1 = c78.a.g;
        if (r1.contains("key_enable_ugc_bot_mmt") == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r1.getBoolean("key_enable_ugc_bot_mmt", true));
    }

    public final boolean m() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return false;
    L6:
        return f.a().getBoolean("keva_asr_mock_sami_core_open", false);
    }

    public final boolean n() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return false;
    L6:
        return f.a().getBoolean("keva_asr_stream_force_open", false);
    }

    public final boolean o() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return false;
    L6:
        return f.a().getBoolean("keva_asr_stream_tag_open", false);
    }

    public final int p() {
        int r0 = d.a;
        if (f.b == true) goto L6;
        return -1;
    L6:
        return f.a().getInt("keva_rtc_token_expire", -1);
    }

    public final boolean q() {
        int r0 = d.a;
        boolean r1 = true;
        if (f.b == false) goto L5;
        Keva r2 = f.a();
        if (d.a() == true) goto L13;
    L15:
        r1 = false;
    L17:
        return r2.getBoolean("keva_rtc_new_conn_impl_v2", r1);
    L13:
        if (z2.a.c() == false) goto L15;
    L5:
        if (d.a() == true) goto L7;
    L9:
        return false;
    L7:
        if (z2.a.c() == false) goto L9;
        return true;
    }

    public ASRModule() {
        this.a = new ASRModule$itemMap$1();
        StringBuilder r0 = new StringBuilder();
        boolean r1 = AudioDebugUtil.a;
        r0.append(AudioDebugUtil.b);
        r0.append(File.separator);
        r0.append("asr_info.log");
        this.b = r0.toString();
    }

    public final void a(int r3) {
        int r0 = d.a;
        f.a().storeInt("keva_asr_mock_sami_core_force_count", r3);
    }

    public final a68.a d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        return (a68.a) this.a.get(r2);
    }

    public final void r(final String r3, final byte[] r4, final y58.a r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r5 != null) goto L6;
        return;
    L6:
        boolean r0 = AudioDebugUtil.a;
        Handler r1 = AudioDebugUtil.l;
        if (r1 == null) goto L10;
        r1.post(new b(this, r3, r5, r4));
        return;
    }
}
