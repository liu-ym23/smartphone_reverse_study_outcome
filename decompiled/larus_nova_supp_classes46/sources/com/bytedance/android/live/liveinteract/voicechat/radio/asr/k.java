package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import ec2.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements Handler.Callback {
    public static final TokenCert m = null;
    public static final TokenCert n = null;
    public static final TokenCert o = null;
    public static final TokenCert p = null;
    public com.bytedance.android.live.liveinteract.voicechat.radio.asr.b a;
    public h b;
    public PthreadHandlerThreadV2 c;
    public Handler d;
    public volatile boolean e;
    public volatile boolean f;
    public b g;
    public String h;
    public final Integer i;
    public final m j;
    public final l k;
    public final MultiLinkAsrManager.a l;

    public static final class a {
    }

    public interface b {
        void a(e r1);

        void b(String r1);

        void c(String r1);

        void onStart(String r1);

        void onStop(String r1);
    }

    static {
        TokenCert.Companion r0 = TokenCert.Companion;
        m = r0.with("bpea-live_audiocomment_check_permssion_v1");
        n = r0.with("bpea-live_audiocomment_req_permssion");
        o = r0.with("bpea-live_audio_comment_record");
        p = r0.with("bpea-live_audio_comment_record_stop");
        r0.with("bpea-live_audio_comment_record_release");
    }

    public k(MultiLinkAsrManager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.l = r2;
        this.f = true;
        this.h = "";
        this.i = (Integer) a0.a.getValue();
        this.j = new m(this);
        this.k = new l(this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r19) {
        Intrinsics.checkNotNullParameter(r19, "msg");
        int r0 = r19.what;
        if (r0 != 24) goto L5;
        h r1 = this.b;
        if (r1 == null) goto L79;
        r1.e();
        return false;
    L79:
        return false;
    L5:
        if (r0 != 103) goto L7;
        com.bytedance.android.live.liveinteract.voicechat.radio.asr.a r3 = new com.bytedance.android.live.liveinteract.voicechat.radio.asr.a();
        r3.a = "radio_user_asr_audio";
        if (v.a() == false) goto L24;
        r3.b = "radio_user_asr_debug";
    L24:
        h r7 = this.b;
        if (r7 == null) goto L55;
        String r10 = this.l.a();
        if (r10 != null) goto L29;
        r10 = "qhlmASv0ZqsxPE2o";
    L29:
        String r11 = this.l.b();
        if (r11 != null) goto L32;
        r11 = "Wkj5kLd-EPaB6ntGdeZ7Ljgu7ED_NKCj";
    L32:
        String r12 = this.l.c();
        if (r12 != null) goto L35;
        r12 = "volc_input_common";
    L35:
        Intrinsics.checkNotNullParameter(r10, "appId");
        Intrinsics.checkNotNullParameter(r11, "appToken");
        Intrinsics.checkNotNullParameter(r12, "cluster");
        Intrinsics.checkNotNullParameter(r3, "config");
        if (r7.c == true) goto L55;
        long r16 = System.currentTimeMillis();
        SpeechEngine r9 = r7.b;     // Catch: Exception -> L53
        r7.c("start create " + r7.e);     // Catch: Exception -> L53
        r7.b.setContext(jc1.a.b());     // Catch: Exception -> L53
        r9.createEngine();     // Catch: Exception -> L53
        r7.c("create " + r7.e + " done");     // Catch: Exception -> L53
        r9.setOptionString("engine_name", "asr");     // Catch: Exception -> L53
        r9.setOptionString("appid", r10);     // Catch: Exception -> L53
        r9.setOptionString("token", "Bearer;".concat(r11));     // Catch: Exception -> L53
        r9.setOptionString("asr_address", "wss://speech.bytedance.com");     // Catch: Exception -> L53
        r9.setOptionString("asr_uri", "/api/v2/asr");     // Catch: Exception -> L53
        r9.setOptionString("asr_cluster", r12);     // Catch: Exception -> L53
        r9.setOptionString("uid", gh0.a.c());     // Catch: Exception -> L53
        String r2 = jc1.k.n(IMiddleWareHostContext.class).getServerDeviceId();     // Catch: Exception -> L53
        if (r2 == null) goto L42;
        r9.setOptionString("device_id", r2);     // Catch: Exception -> L53
    L42:
        r9.setOptionBoolean("asr_auto_stop", false);     // Catch: Exception -> L53
        r9.setOptionBoolean("asr_show_punctuation", true);     // Catch: Exception -> L53
        r9.setOptionBoolean("asr_enable_itn", true);     // Catch: Exception -> L53
        PolarisFileWrapper r4 = c.a(r3.b);     // Catch: Exception -> L53
        if (r4 == null) goto L45;
        r9.setOptionString("log_level", "TRACE");     // Catch: Exception -> L53
        r9.setOptionString("debug_path", r4.getPath());     // Catch: Exception -> L53
    L45:
        PolarisFileWrapper r5 = c.a(r3.a);     // Catch: Exception -> L53
        if (r5 == null) goto L48;
        r9.setOptionInt("rec_file_type", 1);     // Catch: Exception -> L53
        r9.setOptionString("rec_path", r5.getPath());     // Catch: Exception -> L53
        r5.deleteOnExit();     // Catch: Exception -> L53
    L48:
        r9.setOptionString("recorder_data_source_type", "Stream");     // Catch: Exception -> L53
        r9.setOptionBoolean("enable_resampler", true);     // Catch: Exception -> L53
        r9.setOptionInt("custom_channel", 2);     // Catch: Exception -> L53
        r9.setOptionInt("custom_sample_rate", 0);     // Catch: Exception -> L53
        r9.setOptionInt("channel", 1);     // Catch: Exception -> L53
        r9.setOptionInt("sample_rate", 16000);     // Catch: Exception -> L53
        r7.c("start init " + r7.e);     // Catch: Exception -> L53
        int r6 = r7.b.initEngine();     // Catch: Exception -> L53
        r7.c("init engine cost " + (System.currentTimeMillis() - r16) + " ms. sampleRate=0");     // Catch: Exception -> L53
        if (r6 != 0) goto L51;
        r7.c = true;     // Catch: Exception -> L53
        r7.a.set(1);     // Catch: Exception -> L53
        r7.b.setListener(new i(r7));     // Catch: Exception -> L53
        goto L55
    L51:
        r7.d("init engine failed. code=" + r6);     // Catch: Exception -> L53
    L53:
        e = move-exception;
        SafetyGuard.a("AnchorAsr create " + r7.e + " error", e, null);
    L55:
        h r8 = this.b;
        if (r8 != null) goto L58;
        return false;
    L58:
        if (r8.c == true) goto L61;
        return false;
    L61:
        if (r8.c == false) goto L64;
        r8.b.sendDirective(2001, "");
    L64:
        r8.a.set(2);
        int r13 = r8.b.sendDirective(1000, "");
        if (r13 != 0) goto L67;
        r8.c("start engine success");
        r8.b();
        return false;
    L67:
        r8.a.set(1);
        r8.d("start engine failed. code=" + r13);
        return false;
    L7:
        if (r0 != 105) goto L80;
        h r14 = this.b;
        if (r14 == null) goto L12;
        r14.f = false;
    L12:
        h r15 = this.b;
        if (r15 == null) goto L15;
        r15.e();
    L15:
        h r17 = this.b;
        if (r17 != null) goto L18;
        return false;
    L18:
        if (r17.c == false) goto L81;
        r17.b.sendDirective(2001, "");
        return false;
    L81:
        return false;
    L80:
        return false;
    }
}
