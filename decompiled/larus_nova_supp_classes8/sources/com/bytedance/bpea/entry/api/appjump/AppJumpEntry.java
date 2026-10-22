package com.bytedance.bpea.entry.api.appjump;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import qc4.c;
import qc4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class AppJumpEntry {

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    static {
    }

    public static void b(TokenCert r3, final Function1 r4) {
        final d r2 = null;
        c r5 = a(r3, "customize_start_activity", -1, null);     // Catch: BPEAException -> L4
        BaseAuthEntry.Companion r0 = BaseAuthEntry.a;     // Catch: BPEAException -> L4
        r0.getClass();     // Catch: BPEAException -> L4
        com.bytedance.bpea.entry.common.d.b(r5);     // Catch: BPEAException -> L4
        r0.call(r5, null, new AppJumpEntry$checkStartActivityAuthUnsafe$1(r4, r2));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void c(final Context r3, final Intent r4, Cert r5) throws BPEAException {
        BaseAuthEntry.a.a(a(r5, "ctx_start_activity", 130003, r4), new AppJumpEntry$startActivityUnsafe$5(r3, r4));
    }

    @JvmStatic
    public static final void startActivity(final Activity r3, final Intent r4, Cert r5) {
        BaseAuthEntry.a.a(a(r5, "act_start_activity", 130001, r4), new AppJumpEntry$startActivityUnsafe$1(r3, r4));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final Fragment r3, final Intent r4, Cert r5) {
        BaseAuthEntry.a.a(a(r5, "frg_start_activity", 130004, r4), new AppJumpEntry$startActivityUnsafe$3(r3, r4));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final androidx.fragment.app.Fragment r3, final Intent r4, Cert r5) {
        BaseAuthEntry.a.a(a(r5, "compat_fragment_start_activity", 130006, r4), new AppJumpEntry$startActivityUnsafe$7(r3, r4));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(Context r0, Intent r1, Cert r2) {
        c(r0, r1, r2);     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static c a(Cert r8, String r9, int r10, Intent r11) {
        int r0 = a.a;
        if (r8 == null) goto L9;
        String r1 = r8.certToken();
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (r11 == null) goto L9;
        r11.putExtra("__security_bpea_auth_through__", r1);
    L9:
        return new c(r8, r9, new String[]{"appjump"}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()), r10);
    }

    @JvmStatic
    public static final void startActivity(final Activity r3, final Intent r4, final Bundle r5, Cert r6) {
        BaseAuthEntry.a.a(a(r6, "act_start_activity", 130001, r4), new AppJumpEntry$startActivityUnsafe$2(r3, r4, r5));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final Activity r3, final Intent r4, final int r5, Cert r6) {
        BaseAuthEntry.a.a(a(r6, "act_start_activity_for_result", 130002, r4), new AppJumpEntry$startActivityForResultUnsafe$1(r3, r4, r5));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final Fragment r3, final Intent r4, final Bundle r5, Cert r6) {
        BaseAuthEntry.a.a(a(r6, "frg_start_activity", 130004, r4), new AppJumpEntry$startActivityUnsafe$4(r3, r4, r5));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final Fragment r3, final Intent r4, final int r5, Cert r6) {
        BaseAuthEntry.a.a(a(r6, "frg_start_activity_for_result", 130005, r4), new AppJumpEntry$startActivityForResultUnsafe$3(r3, r4, r5));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final Context r3, final Intent r4, final Bundle r5, Cert r6) {
        BaseAuthEntry.a.a(a(r6, "ctx_start_activity", 130003, r4), new AppJumpEntry$startActivityUnsafe$6(r3, r4, r5));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final androidx.fragment.app.Fragment r3, final Intent r4, final int r5, Cert r6) {
        BaseAuthEntry.a.a(a(r6, "compat_fragment_start_activity_for_result", 130007, r4), new AppJumpEntry$startActivityForResultUnsafe$5(r3, r4, r5));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivity(final androidx.fragment.app.Fragment r3, final Intent r4, final Bundle r5, Cert r6) {
        BaseAuthEntry.a.a(a(r6, "compat_fragment_start_activity", 130006, r4), new AppJumpEntry$startActivityUnsafe$8(r3, r4, r5));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final Activity r3, final Intent r4, final int r5, final Bundle r6, Cert r7) {
        BaseAuthEntry.a.a(a(r7, "act_start_activity_for_result", 130002, r4), new AppJumpEntry$startActivityForResultUnsafe$2(r3, r4, r5, r6));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final Fragment r3, final Intent r4, final int r5, final Bundle r6, Cert r7) {
        BaseAuthEntry.a.a(a(r7, "frg_start_activity_for_result", 130005, r4), new AppJumpEntry$startActivityForResultUnsafe$4(r3, r4, r5, r6));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static final void startActivityForResult(final androidx.fragment.app.Fragment r3, final Intent r4, final int r5, final Bundle r6, Cert r7) {
        BaseAuthEntry.a.a(a(r7, "compat_fragment_start_activity_for_result", 130007, r4), new AppJumpEntry$startActivityForResultUnsafe$6(r3, r4, r5, r6));     // Catch: BPEAException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
