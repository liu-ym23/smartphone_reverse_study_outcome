package g80;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.clipboard.ClipboardEntry;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final ClipData b(TokenCert r13) throws BPEAException {
        Object r0 = jc1.a.b().getSystemService("clipboard");
        if (r0 == null) goto L13;
        ClipboardManager r1 = (ClipboardManager) r0;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        ClipboardEntry.a.getClass();
        return ClipboardEntry.Companion.b(r1, r13);
    L7:
        f06.c r14 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r11 = new f06.b();
        f06.d r12 = r14.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r1, r9, "android.content.ClipData", r11);
        if (r12.a == false) goto L10;
        r14.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r1, r9, null, r11, false);
        return (ClipData) r12.b;
    L10:
        ClipData r15 = r1.getPrimaryClip();
        r14.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r1, r9, r15, r11, true);
        return r15;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public static void a(ClipboardManager r18, ClipData r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101807);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.setPrimaryClip(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @JvmStatic
    public static final void c(ClipData r3, Cert r4) throws BPEAException {
        Intrinsics.checkNotNullParameter(r3, "clip");
        Object r1 = jc1.a.b().getSystemService("clipboard");
        if (r1 == null) goto L14;
        ClipboardManager r2 = (ClipboardManager) r1;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        ClipboardEntry.a.getClass();
        ClipboardEntry.Companion.c(r2, r3, r4);
        return;
    L7:
        Intrinsics.checkNotNullParameter(r3, "clip");
        FLogger.a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L10
        a(r2, r3);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    @JvmStatic
    public static final void d(CharSequence r21, TokenCert r22) throws BPEAException {
        Intrinsics.checkNotNullParameter(r21, "text");
        Object r1 = jc1.a.b().getSystemService("clipboard");
        if (r1 == null) goto L27;
        ClipboardManager r2 = (ClipboardManager) r1;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        ClipboardEntry.a.getClass();
        ClipboardEntry.Companion.d(r2, r21, r22);
        return;
    L7:
        ArrayList r11 = new ArrayList();
        Object[] r12 = {r21};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(101808);
        if (r3 == null) goto L10;
        f06.a[] r4 = r3.i;
    L11:
        f06.a[] r9 = r4;
        int r8 = r9.length;
        int r7 = 0;
    L13:
        if (r7 >= r8) goto L20;
        f06.a r6 = r9[r7];
        int r17 = r7;
        int r18 = r8;
        f06.a[] r19 = r9;
        f06.d r5 = r6.preInvoke(101808, "android/content/ClipboardManager", "setText", r2, r12, "void", r13);     // Catch: Exception -> L28
        if (r5.a == true) goto L22;
        r11.add(r6);     // Catch: Exception -> L28
    L22:
        if (r5.a == true) goto L35;
        r2.setText(r21);
        return;
    L35:
        return;
    L19:
        r7 = r17 + 1;
        r8 = r18;
        r9 = r19;
        goto L13
    L20:
        r5 = new f06.d(false, null);
        goto L22
    L10:
        r4 = ApiHookConfig.d;
        goto L11
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
}
