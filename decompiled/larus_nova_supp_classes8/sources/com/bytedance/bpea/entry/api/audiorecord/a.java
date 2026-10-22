package com.bytedance.bpea.entry.api.audiorecord;

import android.media.AudioRecord;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.bytedance.bpea.entry.common.DataType;
import kotlin.jvm.JvmStatic;
import qc4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final C0368a a = null;

    /* JADX INFO: renamed from: com.bytedance.bpea.entry.api.audiorecord.a$a, reason: collision with other inner class name */
    public static final class C0368a {
        public C0368a() {
        }

        @JvmStatic
        public static void b(final AudioRecord r3, TokenCert r4) throws BPEAException {
            BaseAuthEntry.a.a(a(r4, "audio_release", 100403), new AudioRecordEntry$Companion$release$1(r3));
        }

        @JvmStatic
        public static void c(final AudioRecord r3, TokenCert r4) throws BPEAException, IllegalStateException {
            BaseAuthEntry.a.a(a(r4, "audio_start", 100400), new AudioRecordEntry$Companion$startRecording$1(r3));
        }

        @JvmStatic
        public static void d(final AudioRecord r3, TokenCert r4) throws BPEAException, IllegalStateException {
            BaseAuthEntry.a.a(a(r4, "audio_stop", 100401), new AudioRecordEntry$Companion$stop$1(r3));
        }

        public static c a(TokenCert r7, String r8, int r9) {
            return new c(r7, r8, r9, new String[]{DataType.AUDIO}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
        }
    }

    static {
        a = new C0368a();
    }
}
