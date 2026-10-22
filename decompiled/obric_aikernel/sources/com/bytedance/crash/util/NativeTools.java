package com.bytedance.crash.util;

import android.text.TextUtils;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NativeTools {
    private static NativeTools sInstance;
    private static HashMap<String, String> sSoUUID;

    static {
        sSoUUID = new HashMap();
    }

    public NativeTools() {
    }

    public static String compatibleBuildID(String r10) {
        StringBuilder r11 = new StringBuilder();
        if (r10 == null) goto L5;
        if (r10.length() >= 16) goto L9;
        r11.append(r10);     // Catch: Throwable -> L14
    L15:
        goto L13
    L9:
        r11.append(r10.charAt(6));     // Catch: Throwable -> L14
        r11.append(r10.charAt(7));     // Catch: Throwable -> L14
        r11.append(r10.charAt(4));     // Catch: Throwable -> L14
        r11.append(r10.charAt(5));     // Catch: Throwable -> L14
        r11.append(r10.charAt(2));     // Catch: Throwable -> L14
        r11.append(r10.charAt(3));     // Catch: Throwable -> L14
        r11.append(r10.charAt(0));     // Catch: Throwable -> L14
        r11.append(r10.charAt(1));     // Catch: Throwable -> L14
        r11.append(r10.charAt(10));     // Catch: Throwable -> L14
        r11.append(r10.charAt(11));     // Catch: Throwable -> L14
        r11.append(r10.charAt(8));     // Catch: Throwable -> L14
        r11.append(r10.charAt(9));     // Catch: Throwable -> L14
        r11.append(r10.charAt(14));     // Catch: Throwable -> L14
        r11.append(r10.charAt(15));     // Catch: Throwable -> L14
        r11.append(r10.charAt(12));     // Catch: Throwable -> L14
        r11.append(r10.charAt(13));     // Catch: Throwable -> L14
        if (r10.length() < 32) goto L15;
        r11.append(r10, 16, 32);     // Catch: Throwable -> L14
        r11.append('0');     // Catch: Throwable -> L14
    L13:
        return r11.toString().toUpperCase();
    L5:
        return r11.toString();
    }

    public static NativeTools get() {
        if (sInstance != null) goto L15;
        monitor-enter(NativeTools.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NativeTools();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NativeTools.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static String[] getAppSoNameFromBacktraceLine(String r10) {
        String[] r11 = r10.split("\\s+");
        String[] r12 = {"", ""};
        if (r11.length < 4) goto L27;
        int r13 = r11.length;
        String r14 = null;
        int r15 = 0;
    L6:
        if (r15 >= r13) goto L14;
        String r16 = r11[r15];
        if (r16.startsWith("/") == false) goto L12;
        if (r16.endsWith(".so") == false) goto L12;
        r14 = r16;
    L12:
        r15 = r15 + 1;
        goto L6
    L14:
        if (TextUtils.isEmpty(r14) == false) goto L17;
        return null;
    L17:
        if (r14.endsWith(".so") == false) goto L27;
        if (r14.contains("/system/lib") == true) goto L27;
        int r17 = r14.lastIndexOf(47);
        if (r17 == (-1)) goto L27;
        int r18 = r17 + 1;
        String r19 = r14.substring(r18);
        if (r19.contains(".apk!") == false) goto L25;
        r19 = r19.substring(r19.indexOf(".apk!") + 5);
    L25:
        String r20 = r14.substring(0, r18) + r19;
        r12[0] = r19;
        r12[1] = r20;
        return r12;
    L27:
        return null;
    }

    public int dumpLogcat(String r10) {
        NativeBridge.dumpLogcat(r10, 0, false);     // Catch: Throwable -> L5
        return 0;
    L5:
        return -1;
    }

    public int dumpLogcat(String r10, String r11) {
        NativeBridge.dumpLogcat(r10, 0, false);     // Catch: Throwable -> L5
        return 0;
    L5:
        return -1;
    }

    public String getBuildID(String r10) {
        return NativeBridge.GetBuildID(r10);
    L4:
        return null;
    }

    public List<String> getFdListForAPM() {
        return NativeBridge.getFdListForAPM();
    }

    public JSONArray getSoUUID(String r10) {
        JSONArray r11 = new JSONArray();
        HashSet r12 = new HashSet();
        String[] r13 = r10.split("\n");
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L13;
        String[] r16 = getAppSoNameFromBacktraceLine(r13[r15]);
        if (r16 == null) goto L12;
        String r17 = get().getSoUUIDCurrent(r16[1]);
        if (TextUtils.isEmpty(r17) == true) goto L12;
        if (r12.contains(r16[0]) == true) goto L12;
        r12.add(r16[0]);
        JSONObject r18 = new JSONObject();
        JSONUtils.put(r18, CrashBody.LIB_NAME, r16[0]);
        JSONUtils.put(r18, CrashBody.LIB_UUID, r17);
        r11.put(r18);
    L12:
        r15 = r15 + 1;
        goto L3
    L13:
        return r11;
    }

    public String getSoUUIDCurrent(String r10) {
        String r11 = sSoUUID.get(r10);
        if (TextUtils.isEmpty(r11) == false) goto L6;
        String r12 = compatibleBuildID(get().getBuildID(r10));
        sSoUUID.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    public boolean is64BitRuntime() {
        return NativeBridge.is64BitRuntime();
    }

    public void setResendSigquit(boolean r10) {
    }
}
