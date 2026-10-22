package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public static void clearCdid(Context r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        if (r4 == null) goto L16;
        sCdidMap.remove(r4.getAidString());
        LocalConstants.getCommonSp(r5, r4).edit().remove(KEY_CDID).apply();
        if (r4.isMainInstance() == false) goto L9;
        String r6 = LocalConstants.getOldSpName();
    L10:
        SharedPreferences r7 = r5.getSharedPreferences(r6, 0);
        if (r7.contains(KEY_CDID) == false) goto L15;
        r7.edit().remove(KEY_CDID).apply();
        return;
    L15:
        return;
    L9:
        r6 = LocalConstants.getOldSpName() + "_" + r4.getAid();
        goto L10
    L16:
        return;
    }

    public static String get(InstallOptions r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        String r0 = r5.getAidString();
        String r1 = (String) ZeusTransformUtils.preCheckCast(sCdidMap.get(r0), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
    L19:
        return r1;
    L8:
        monitor-enter(Cdid.class);
        if (r1 == null) goto L20;
    L14:
        monitor-exit(Cdid.class);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L20:
        if (Utils.isMainProcess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L13;
        r1 = getCdidLocked(r5);     // Catch: Throwable -> L16
        sCdidMap.put(r0, r1);     // Catch: Throwable -> L16
        SubpSyncManager.inst((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).sendSubpEvent(r5.getAidString(), KEY_CDID, r1);     // Catch: Throwable -> L16
        goto L14
    L13:
        r1 = getCdidWithChildProcess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L16
        goto L14
    }

    private static String getCdidLocked(InstallOptions r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        SharedPreferences r1 = LocalConstants.getCommonSp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6);
        String r4 = r1.getString(KEY_CDID, null);
        if (TextUtils.isEmpty(r4) == true) goto L8;
        return r4;
    L8:
        if (r6.isMainInstance() == false) goto L10;
        String r5 = LocalConstants.getOldSpName();
    L11:
        SharedPreferences r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(r5, 0);
        String r0 = r7.getString(KEY_CDID, null);
        if (TextUtils.isEmpty(r0) == false) goto L14;
        r0 = UUID.randomUUID().toString();
    L14:
        String r8 = r0;
        r7.edit().putString(KEY_CDID, r8).apply();
        r1.edit().putString(KEY_CDID, r8).putBoolean(KEY_MIGRATE, true).apply();
        return r8;
    L10:
        r5 = LocalConstants.getOldSpName() + "_" + r6.getAid();
        goto L11
    }

    private static String getCdidWithChildProcess(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L8;
        if (r5 == null) goto L10;
        SubpSyncManager.inst(r6).observer(r5.getAidString(), KEY_CDID, new AnonymousClass1());
        return (String) ZeusTransformUtils.preCheckCast(sCdidMap.get(r5.getAidString()), String.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    L8:
        return null;
    }

    public static String getMainInstanceCdid(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        SharedPreferences r5 = r4.getSharedPreferences(LocalConstants.getOldSpName(), 0);
        String r0 = r5.getString(KEY_CDID, null);
        if (TextUtils.isEmpty(r0) == false) goto L9;
        String r1 = UUID.randomUUID().toString();
        r5.edit().putString(KEY_CDID, r1).apply();
        return r1;
    L9:
        return r0;
    }
}
