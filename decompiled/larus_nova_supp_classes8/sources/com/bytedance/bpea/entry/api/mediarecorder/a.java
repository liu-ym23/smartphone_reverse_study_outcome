package com.bytedance.bpea.entry.api.mediarecorder;

import android.media.MediaRecorder;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.bytedance.bpea.entry.common.DataType;
import kotlin.jvm.JvmStatic;
import qc4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final C0371a a = null;

    /* JADX INFO: renamed from: com.bytedance.bpea.entry.api.mediarecorder.a$a, reason: collision with other inner class name */
    public static final class C0371a {
        public C0371a() {
        }

        @JvmStatic
        public static void b(final MediaRecorder r3, TokenCert r4) throws BPEAException {
            BaseAuthEntry.a.a(a(r4, "mediaRecord_release", 100501), new MediaRecorderEntry$Companion$release$1(r3));
        }

        @JvmStatic
        public static void c(final MediaRecorder r3, TokenCert r4) throws BPEAException, IllegalStateException {
            BaseAuthEntry.a.a(a(r4, "mediaRecord_start", 100502), new MediaRecorderEntry$Companion$start$1(r3));
        }

        @JvmStatic
        public static void d(final MediaRecorder r3, TokenCert r4) throws BPEAException, IllegalStateException {
            BaseAuthEntry.a.a(a(r4, "mediaRecord_stop", 100503), new MediaRecorderEntry$Companion$stop$1(r3));
        }

        public static c a(TokenCert r7, String r8, int r9) {
            return new c(r7, r8, r9, new String[]{DataType.AUDIO, DataType.VIDEO}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
        }
    }

    static {
        a = new C0371a();
    }
}
