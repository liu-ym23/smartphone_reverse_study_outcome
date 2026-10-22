package com.bytedance.bpea.entry.api.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.bytedance.bpea.entry.common.DataType;
import kotlin.jvm.JvmStatic;
import qc4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ClipboardEntry {
    public static final Companion a = null;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static ClipData b(final ClipboardManager r3, TokenCert r4) throws BPEAException {
            return (ClipData) BaseAuthEntry.a.a(a(r4, "clipboard_getClip", 101803), new ClipboardEntry$Companion$getPrimaryClip$1(r3));
        }

        public static c a(Cert r7, String r8, int r9) {
            return new c(r7, r8, r9, new String[]{DataType.CLIPBOARD}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
        }

        @JvmStatic
        public static void c(final ClipboardManager r3, final ClipData r4, Cert r5) throws BPEAException {
            BaseAuthEntry.a.a(a(r5, "clipboard_setClip", 101807), new ClipboardEntry$Companion$setPrimaryClip$1(r3, r4));
        }

        @JvmStatic
        public static void d(final ClipboardManager r3, final CharSequence r4, TokenCert r5) throws BPEAException {
            BaseAuthEntry.a.a(a(r5, "clipboard_setText", 101808), new ClipboardEntry$Companion$setText$1(r3, r4));
        }
    }

    static {
        a = new Companion();
    }
}
