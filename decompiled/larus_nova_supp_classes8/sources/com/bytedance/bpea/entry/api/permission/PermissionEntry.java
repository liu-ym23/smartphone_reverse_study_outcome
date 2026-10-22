package com.bytedance.bpea.entry.api.permission;

import android.app.Activity;
import android.app.Fragment;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;
import qc4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PermissionEntry {
    public static final Companion a = null;

    public static final class Companion {
        public Companion() {
        }

        public static c a(String[] r8, Cert r9, int r10) {
            c r6 = new c(r9, "permission_request", r10, new String[]{"permission"}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
            r6.f.put("permission", r8);
            return r6;
        }

        @JvmStatic
        public final void requestPermissions(final Activity r3, final String[] r4, final int r5, Cert r6) throws BPEAException {
            BaseAuthEntry.a.a(a(r4, r6, 102600), new PermissionEntry$Companion$requestPermissions$1(r3, r4, r5));
        }

        @JvmStatic
        public final void requestPermissions(final Fragment r3, final String[] r4, final int r5, Cert r6) throws BPEAException {
            BaseAuthEntry.a.a(a(r4, r6, 102601), new PermissionEntry$Companion$requestPermissions$2(r3, r4, r5));
        }

        @JvmStatic
        public final void requestPermissions(final androidx.fragment.app.Fragment r3, final String[] r4, final int r5, Cert r6) throws BPEAException {
            BaseAuthEntry.a.a(a(r4, r6, 102600), new PermissionEntry$Companion$requestPermissions$3(r3, r4, r5));
        }
    }

    @JvmStatic
    public static final void requestPermissions(Activity r1, String[] r2, int r3, Cert r4) throws BPEAException {
        a.requestPermissions(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final void requestPermissions(Fragment r1, String[] r2, int r3, Cert r4) throws BPEAException {
        a.requestPermissions(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final void requestPermissions(androidx.fragment.app.Fragment r1, String[] r2, int r3, Cert r4) throws BPEAException {
        a.requestPermissions(r1, r2, r3, r4);
    }

    static {
        a = new Companion();
    }

    @JvmStatic
    public static final void a(final Activity r2, final String[] r3, final int r4, TokenCert r5) throws BPEAException {
        a.getClass();
        BaseAuthEntry.a.a(Companion.a(r3, r5, 102600), new PermissionEntry$Companion$requestPermissionsByActivityCompat$1(r2, r3, r4));
    }
}
