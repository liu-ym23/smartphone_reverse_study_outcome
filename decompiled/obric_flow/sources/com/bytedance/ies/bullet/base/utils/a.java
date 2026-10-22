package com.bytedance.ies.bullet.base.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ies.bullet.core.h;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
import td.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f5228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f5229b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f5230c = null;

    static {
        HashMap r5 = new HashMap();
        f5229b = r5;
        f5230c = new HashMap();
        e.f(32, r5, "armeabi", 32, "armeabi-v7a");
        e.f(64, r5, "arm64-v8a", 32, "x86");
        e.f(64, r5, "x86_64", 32, "mips");
        r5.put("mips64", 64);
        f5228a = e();
    }

    public static Object a(ApplicationInfo r10) {
        if (r10 == null) goto L41;
        Class<?> r5 = r10.getClass();
        if (TextUtils.isEmpty("primaryCpuAbi") == true) goto L39;
        String r11 = r5.toString() + "#primaryCpuAbi";
        HashMap r12 = f5230c;
        monitor-enter(r12);
        Field r13 = (Field) r12.get(r11);     // Catch: Throwable -> L35
        monitor-exit(r12);     // Catch: Throwable -> L35
        if (r13 != null) goto L13;
    L15:
        if (r5 == null) goto L28;
        r13 = r5.getDeclaredField("primaryCpuAbi");     // Catch: NoSuchFieldException -> L27
        if (r13.isAccessible() == true) goto L19;
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L27
    L19:
        HashMap r14 = f5230c;     // Catch: NoSuchFieldException -> L27
        monitor-enter(r14);     // Catch: NoSuchFieldException -> L27
        r14.put(r11, r13);     // Catch: Throwable -> L24
        monitor-exit(r14);     // Catch: Throwable -> L24
    L29:
        if (r13 != null) goto L31;
        return null;
    L31:
        if (r13.isAccessible() == true) goto L34;
        r13.setAccessible(true);
    L34:
        return r13.get(r10);
    L24:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L27
    L27:
        r5 = r5.getSuperclass();
        goto L15
    L28:
        r13 = null;
        goto L29
    L13:
        if (r13.isAccessible() == true) goto L29;
        r13.setAccessible(true);
    L35:
        th = move-exception;
        throw th;
    L39:
        throw new IllegalArgumentException("The field name must not be blank");
    L41:
        throw new IllegalArgumentException("target object must not be null");
    }

    public static HashMap b(ZipFile r10) {
        HashMap r5 = new HashMap();
        Enumeration<? extends ZipEntry> r11 = r10.entries();
        Pattern r12 = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
    L4:
        if (r11.hasMoreElements() == false) goto L23;
        ZipEntry r13 = r11.nextElement();
        if (r13.isDirectory() == true) goto L4;
        boolean r14 = r12.matcher(r13.getName()).matches();     // Catch: Exception -> L10
    L12:
        if (r14 == false) goto L4;
        String[] r15 = r13.getName().split(File.separator);
        if (r15 == null) goto L4;
        if (r15.length < 2) goto L4;
        String r16 = r15[r15.length - 2];
        if (f5229b.containsKey(r16) == false) goto L4;
        if (r5.get(r16) != null) goto L22;
        r5.put(r16, new LinkedList());
    L22:
        ((List) r5.get(r16)).add(r13);
    L10:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "AbiUtil getAllSoZipEntries failed, match error=", "AbiUtil");
        r14 = false;
        goto L12
    L23:
        Log.i("AbiUtil", "AbiUtil getAllSoZipEntries, zipFile=" + r10.getName() + ", soEntries=" + r5.toString());
        return r5;
    }

    public static void c(JSONObject r5, String r10, String r11) {
        r5.put(r10, r11);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static String d() {
        if (f5228a != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f5228a != null) goto L11;
        f5228a = e();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f5228a;
    }

    public static String e() {
        JSONObject r10 = new JSONObject();
        r10.put("primaryCpuAbi", "0");     // Catch: JSONException -> L5
        r10.put("processMode", "0");     // Catch: JSONException -> L5
        r10.put("supportedABI0", "0");     // Catch: JSONException -> L5
        r10.put("matchCpuAbi", "0");     // Catch: JSONException -> L5
        r10.put("defaultABI0", "0");     // Catch: JSONException -> L5
        r10.put("defaultABI", "0");     // Catch: JSONException -> L5
        r10.put("autoError", "0");     // Catch: JSONException -> L5
        r10.put("manualError", "0");     // Catch: JSONException -> L5
    L7:
        Application r12 = h.g.f5316b;
        if (r12 != null) goto L60;
    L29:
        String r13 = null;
    L30:
        if (r13 == null) goto L63;
        return r13;
    L63:
        Application r5 = h.g.f5316b;     // Catch: PackageManager.NameNotFoundException -> L37 Throwable -> L53
        if (r5 == null) goto L38;
        String r11 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 0).applicationInfo.sourceDir;     // Catch: PackageManager.NameNotFoundException -> L37 Throwable -> L53
    L39:
        ZipFile r14 = new ZipFile(new File(r11));     // Catch: Throwable -> L53
        HashSet r15 = new HashSet(b(r14).keySet());     // Catch: Throwable -> L53
        r14.close();     // Catch: IOException -> L42 Throwable -> L53
    L43:
        String[] r16 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L53
        if (r15.isEmpty() == false) goto L46;
        Log.w("AbiUtil", "AbiUtil inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + r16[0]);     // Catch: Throwable -> L53
        c(r10, "supportedABI0", r16[0]);     // Catch: Throwable -> L53
        return r16[0];
    L46:
        int r17 = r16.length;     // Catch: Throwable -> L53
        int r18 = 0;
    L47:
        if (r18 >= r17) goto L54;
        String r19 = r16[r18];     // Catch: Throwable -> L53
        if (r15.contains(r19) == true) goto L50;
        r18 = r18 + 1;
        goto L47
    L50:
        Log.w("AbiUtil", "AbiUtil inferHostAbiManual, match cpuAbi=" + r19);     // Catch: Throwable -> L53
        c(r10, "matchCpuAbi", r19);     // Catch: Throwable -> L53
        return r19;
    L54:
        String[] r20 = Build.SUPPORTED_ABIS;
        c(r10, "defaultABI0", r20[0]);
        return r20[0];
    L42:
        Log.w("AbiUtil", "AbiUtil inferHostAbiManual, close sourceApkZipFile error!");     // Catch: Throwable -> L53
        goto L43
    L38:
        r11 = null;
    L53:
        Log.e("AbiUtil", "AbiUtil inferHostAbiManual failed!");
        c(r10, "manualError", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L37:
        Log.e("AbiUtil", "AbiUtil inferHostAbiManual, get host sourceDir PackageInfo failed!");     // Catch: Throwable -> L53
        goto L38
    L60:
        r13 = (String) a(r12.getApplicationInfo());     // Catch: Throwable -> L28
        Log.w("AbiUtil", "AbiUtil inferHostAbiAuto, primaryCpuAbi=" + r13);     // Catch: Throwable -> L28
        c(r10, "primaryCpuAbi", r13);     // Catch: Throwable -> L28
        if (r13 == null) goto L29;
        if (Process.is64Bit() == false) goto L15;
        int r110 = 64;
    L67:
        Log.w("AbiUtil", "AbiUtil inferHostAbiAuto, processMode=" + r110);     // Catch: Exception -> L57 NoSuchMethodError -> L56 Throwable -> L28
    L20:
        Log.w("AbiUtil", "AbiUtil inferHostAbiAuto, processMode exception default=" + r110);     // Catch: Throwable -> L28
    L21:
        c(r10, "processMode", "" + r110);     // Catch: Throwable -> L28
        if (r110 != 0) goto L24;
        Log.w("AbiUtil", "AbiUtil inferHostAbiAuto1, sHostAbi=".concat(r13));     // Catch: Throwable -> L28
        goto L30
    L24:
        if (((Integer) f5229b.get(r13)).intValue() != r110) goto L29;
        Log.w("AbiUtil", "AbiUtil inferHostAbiAuto2, sHostAbi=".concat(r13));     // Catch: Throwable -> L28
        goto L30
    L15:
        r110 = 32;
        goto L67
    L19:
        r110 = 0;
    L18:
        r110 = 0;
    L28:
        Log.e("AbiUtil", "AbiUtil inferHostAbiAuto failed!");
        c(r10, "autoError", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
