package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import android.media.MediaRecorder;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AudioRecordHelper {
    public static final TokenCert a = null;
    public static long b;
    public static MediaRecorder c;
    public static int d;
    public static PolarisFileWrapper e;
    public static final Lazy f = null;

    static {
        a = TokenCert.Companion.with("bpea-vip_request_record_permission");
        f = LazyKt.lazy(AudioRecordHelper$outputPath$2.INSTANCE);
    }

    public static void a(MediaRecorder r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100500, "android/media/MediaRecorder", "prepare", r13, r9, "void", r10).a == false) goto L6;
        r8.a(100500, "android/media/MediaRecorder", "prepare", r13, r9, null, r10, false);
        return;
    L6:
        r13.prepare();
        r8.a(100500, "android/media/MediaRecorder", "prepare", r13, r9, null, r10, true);
    }
}
