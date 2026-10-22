package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class Cdid {
    public static final String KEY_CDID = "cdid";
    private static final String KEY_MIGRATE = "cdid_migrate";
    private static Map<String, String> sCdidMap;

    static {
        sCdidMap = new ConcurrentHashMap(4);
    }

    private Cdid() {
    }

    static /* synthetic */ Map access$000() {
        return sCdidMap;
    }

    public static void clearCdid(Context r10, InstallOptions r11) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L15;
        sCdidMap.remove(r11.getAidString());
        LocalConstants.getCommonSp(r10, r11).edit().remove(KEY_CDID).apply();
        if (r11.isMainInstance() == false) goto L8;
        String r12 = LocalConstants.getOldSpName();
    L9:
        SharedPreferences r13 = r10.getSharedPreferences(r12, 0);
        if (r13.contains(KEY_CDID) == false) goto L14;
        r13.edit().remove(KEY_CDID).apply();
        return;
    L14:
        return;
    L8:
        r12 = LocalConstants.getOldSpName() + "_" + r11.getAid();
        goto L9
    L15:
        return;
    }

    public static String get(InstallOptions r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = r10.getAidString();
        String r12 = sCdidMap.get(r11);
        if (r12 == null) goto L8;
    L19:
        return r12;
    L8:
        monitor-enter(Cdid.class);
        if (r12 == null) goto L20;
    L14:
        monitor-exit(Cdid.class);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L20:
        if (Utils.isMainProcess(r10.getContext()) == false) goto L13;
        r12 = getCdidLocked(r10);     // Catch: Throwable -> L16
        sCdidMap.put(r11, r12);     // Catch: Throwable -> L16
        SubpSyncManager.inst(r10.getContext()).sendSubpEvent(r10.getAidString(), KEY_CDID, r12);     // Catch: Throwable -> L16
        goto L14
    L13:
        r12 = getCdidWithChildProcess(r10.getContext(), r10);     // Catch: Throwable -> L16
        goto L14
    }

    private static String getCdidLocked(InstallOptions r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        SharedPreferences r11 = LocalConstants.getCommonSp(r10.getContext(), r10);
        String r12 = r11.getString(KEY_CDID, null);
        if (TextUtils.isEmpty(r12) == true) goto L8;
        return r12;
    L8:
        if (r10.isMainInstance() == false) goto L10;
        String r13 = LocalConstants.getOldSpName();
    L11:
        SharedPreferences r14 = r10.getContext().getSharedPreferences(r13, 0);
        String r15 = r14.getString(KEY_CDID, null);
        if (TextUtils.isEmpty(r15) == false) goto L14;
        r15 = UUID.randomUUID().toString();
    L14:
        String r16 = r15;
        r14.edit().putString(KEY_CDID, r16).apply();
        r11.edit().putString(KEY_CDID, r16).putBoolean(KEY_MIGRATE, true).apply();
        return r16;
    L10:
        r13 = LocalConstants.getOldSpName() + "_" + r10.getAid();
        goto L11
    }

    private static String getCdidWithChildProcess(Context r10, InstallOptions r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L9;
        SubpSyncManager.inst(r10).observer(r11.getAidString(), KEY_CDID, new AnonymousClass1());
        return sCdidMap.get(r11.getAidString());
    L9:
        return null;
    L7:
        return null;
    }

    public static String getMainInstanceCdid(Context r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        SharedPreferences r11 = r10.getSharedPreferences(LocalConstants.getOldSpName(), 0);
        String r12 = r11.getString(KEY_CDID, null);
        if (TextUtils.isEmpty(r12) == false) goto L9;
        String r13 = UUID.randomUUID().toString();
        r11.edit().putString(KEY_CDID, r13).apply();
        return r13;
    L9:
        return r12;
    }
}
