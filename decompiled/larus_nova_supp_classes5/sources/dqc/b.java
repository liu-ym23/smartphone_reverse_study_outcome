package dqc;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import mqc.f;
import mqc.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static String a;
    public static final Map<String, Integer> b = null;

    static {
        HashMap r0 = new HashMap();
        b = r0;
        r0.put("arm64-v8a", 64);
        r0.put("armeabi-v7a", 32);
        r0.put("armeabi", 32);
        r0.put("x86_64", 64);
        r0.put("x86", 32);
        r0.put("mips64", 64);
        r0.put("mips", 32);
        a = h();
    }

    public static String f() {
        String r0 = a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = h();
        a = r1;
        return r1;
    }

    public static String h() {
        JSONObject r10 = new JSONObject();
        r10.put("primaryCpuAbi", "0");     // Catch: JSONException -> L5
        r10.put("processMode", "0");     // Catch: JSONException -> L5
        r10.put("supportedABI0", "0");     // Catch: JSONException -> L5
        r10.put("matchCpuAbi", "0");     // Catch: JSONException -> L5
        r10.put("defaultABI0", "0");     // Catch: JSONException -> L5
        r10.put("defaultABI", "0");     // Catch: JSONException -> L5
        r10.put("autoError", "0");     // Catch: JSONException -> L5
        r10.put("manualError", "0");     // Catch: JSONException -> L5
    L64:
        String r5 = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");     // Catch: Exception -> L36
        String r17 = "manualError";
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=" + r5);     // Catch: Exception -> L32
        a(r10, "primaryCpuAbi", r5);     // Catch: Exception -> L32
        if (r5 != null) goto L14;
    L39:
        r5 = null;
    L40:
        if (r5 == null) goto L70;
        return r5;
    L70:
        PolarisZipFileWrapper r4 = new PolarisZipFileWrapper(new PolarisFileWrapper(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));     // Catch: Throwable -> L56
        HashSet r6 = new HashSet(((HashMap) e(r4)).keySet());     // Catch: Throwable -> L56
        r4.close();     // Catch: IOException -> L45 Throwable -> L56
    L46:
        String[] r3 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L56
        if (r6.isEmpty() == false) goto L49;
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + r3[0]);     // Catch: Throwable -> L56
        a(r10, "supportedABI0", r3[0]);     // Catch: Throwable -> L56
        String r0 = r3[0];     // Catch: Throwable -> L56
    L60:
        return r0;
    L49:
        int r1 = r3.length;     // Catch: Throwable -> L56
        int r7 = 0;
    L50:
        if (r7 >= r1) goto L58;
        String r8 = r3[r7];     // Catch: Throwable -> L56
        if (r6.contains(r8) == true) goto L53;
        r7 = r7 + 1;
        goto L50
    L53:
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper inferHostAbiManual, match cpuAbi=" + r8);     // Catch: Throwable -> L56
        a(r10, "matchCpuAbi", r8);     // Catch: Throwable -> L56
        return r8;
    L58:
        String[] r2 = Build.SUPPORTED_ABIS;
        a(r10, "defaultABI0", r2[0]);
        r0 = r2[0];
        goto L60
    L45:
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        ZeusLogger.errReport("Zeus/so_zeus", "NativeLibHelper inferHostAbiManual failed!", th);
        a(r10, r17, "1");
        goto L58
    L14:
        if (Build.VERSION.SDK_INT < 23) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == true) goto L62;
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper inferHostAbiAuto, processMode default=0");     // Catch: Exception -> L32
        int r11 = 0;
    L27:
        a(r10, "processMode", "" + r11);     // Catch: Exception -> L32
        if (r11 != 0) goto L30;
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(r5));     // Catch: Exception -> L32
        goto L40
    L30:
        if (((Integer) ((HashMap) b).get(r5)).intValue() != r11) goto L39;
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(r5));     // Catch: Exception -> L32
        goto L40
    L62:
        if (Process.is64Bit() == false) goto L21;
        r11 = 64;
    L72:
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper inferHostAbiAuto, processMode=" + r11);     // Catch: Exception -> L61
    L25:
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper inferHostAbiAuto, processMode exception default=" + r11);     // Catch: Exception -> L32
        goto L27
    L21:
        r11 = 32;
    L24:
        r11 = 0;
        goto L25
    L16:
        r9 = false;
    L32:
        e = e;
    L38:
        ZeusLogger.errReport("Zeus/so_zeus", "NativeLibHelper inferHostAbiAuto failed!", e);
        a(r10, "autoError", "1");
    L36:
        e = e;
        r17 = "manualError";
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L64
    }

    public static Map e(PolarisZipFileWrapper r7) {
        HashMap r0 = new HashMap();
        Enumeration<? extends ZipEntry> r1 = r7.entries();
        Pattern r2 = PatternProtector.compile("^lib/[^/]+/lib[^/]+.so$");
    L4:
        if (r1.hasMoreElements() == false) goto L24;
        ZipEntry r3 = r1.nextElement();
        if (r3.isDirectory() == true) goto L4;
        if (r3.getName().contains("../") == true) goto L4;
        if (r3.getName().startsWith("lib/") == false) goto L4;
        if (r2.matcher(r3.getName()).matches() == false) goto L4;
        String[] r4 = r3.getName().split(File.separator);
        if (r4 == null) goto L4;
        if (r4.length < 2) goto L4;
        String r5 = r4[r4.length - 2];
        if (((HashMap) b).containsKey(r5) == false) goto L4;
        if (r0.get(r5) != null) goto L23;
        r0.put(r5, new LinkedList());
    L23:
        ((List) r0.get(r5)).add(r3);
        goto L4
    L24:
        ZeusLogger.i("Zeus/so_zeus", "NativeLibHelper getAllSoZipEntries, zipFile=" + r7.getName() + ", soEntries=" + r0.toString());
        return r0;
    }

    public static List<ZipEntry> g(Map<String, List<ZipEntry>> r12) {
        if (r12.isEmpty() == false) goto L6;
        return null;
    L6:
        LinkedList r0 = new LinkedList();
        HashSet r1 = new HashSet();
        String r2 = a;
        r2.getClass();
        byte r11 = -1;
        switch(r2.hashCode()) {
            case -1073971299: goto L34;
            case -806050265: goto L30;
            case -738963905: goto L26;
            case 117110: goto L22;
            case 3351711: goto L18;
            case 145444210: goto L14;
            case 1431565292: goto L10;
            default: goto L37;
        };
    L37:
        switch(r11) {
            case 0: goto L45;
            case 1: goto L44;
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L39;
            default: goto L46;
        };
    L39:
        b(r12, "arm64-v8a", r0, r1);
        goto L46
    L40:
        b(r12, "armeabi-v7a", r0, r1);
        b(r12, "armeabi", r0, r1);
        goto L46
    L41:
        b(r12, "mips", r0, r1);
        goto L46
    L42:
        b(r12, "x86", r0, r1);
        goto L46
    L43:
        b(r12, "armeabi", r0, r1);
        b(r12, "armeabi-v7a", r0, r1);
        goto L46
    L44:
        b(r12, "x86_64", r0, r1);
        goto L46
    L45:
        b(r12, "mips64", r0, r1);
    L46:
        return r0;
    L10:
        if (r2.equals("arm64-v8a") == false) goto L37;
        r11 = 6;
        goto L37
    L14:
        if (r2.equals("armeabi-v7a") == false) goto L37;
        r11 = 5;
        goto L37
    L18:
        if (r2.equals("mips") == false) goto L37;
        r11 = 4;
        goto L37
    L22:
        if (r2.equals("x86") == false) goto L37;
        r11 = 3;
        goto L37
    L26:
        if (r2.equals("armeabi") == false) goto L37;
        r11 = 2;
        goto L37
    L30:
        if (r2.equals("x86_64") == false) goto L37;
        r11 = 1;
        goto L37
    L34:
        if (r2.equals("mips64") == false) goto L37;
        r11 = 0;
        goto L37
    }

    public static f<Boolean, Map<String, List<ZipEntry>>> i(File r8) {
        String r3 = f();
        HashMap r4 = new HashMap();
        ZipFile r5 = null;
        ZipFile r6 = new PolarisZipFileWrapper(r8);     // Catch: Throwable -> L23 IOException -> L25
        r4.putAll(e(r6));     // Catch: IOException -> L18 Throwable -> L20
        if (r4.isEmpty() == false) goto L7;
        ZeusLogger.i("Zeus/so_zeus", "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, " + r8);     // Catch: IOException -> L18 Throwable -> L20
        boolean r9 = true;
    L13:
        f<Boolean, Map<String, List<ZipEntry>>> r2 = new f(Boolean.valueOf(r9), r4);     // Catch: IOException -> L18 Throwable -> L20
        r6.close();     // Catch: IOException -> L16
    L17:
        return r2;
    L16:
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
        goto L17
    L7:
        boolean r7 = j(r4, r3);     // Catch: IOException -> L18 Throwable -> L20
        if (r7 == false) goto L11;
        ZeusLogger.i("Zeus/so_zeus", "NativeLibHelper isPluginApkMatchHostAbi [" + r7 + "], " + r8);     // Catch: IOException -> L18 Throwable -> L20
    L12:
        r9 = r7;
        goto L13
    L11:
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper isPluginApkMatchHostAbi [" + r7 + "], " + r8);     // Catch: IOException -> L18 Throwable -> L20
    L18:
        e = e;
        r5 = r6;
    L26:
        ZeusLogger.errReport("Zeus/so_zeus", "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);     // Catch: Throwable -> L23
        f<Boolean, Map<String, List<ZipEntry>>> r10 = new f(Boolean.FALSE, r4);     // Catch: Throwable -> L23
        if (r5 != null) goto L40;
    L31:
        return r10;
    L40:
        r5.close();     // Catch: IOException -> L30
    L30:
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
    L20:
        th = th;
    L33:
        if (r6 != null) goto L45;
    L37:
        throw th;
    L45:
        r6.close();     // Catch: IOException -> L36
    L36:
        ZeusLogger.w("Zeus/so_zeus", "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
    L23:
        th = th;
        r6 = r5;
    L25:
        e = e;
        goto L26
    }

    public static boolean j(Map<String, List<ZipEntry>> r3, String r4) {
        if (TextUtils.equals(r4, "armeabi") == true) goto L10;
        if (TextUtils.equals(r4, "armeabi-v7a") == true) goto L10;
        return r3.containsKey(r4);
    L10:
        if (r3.containsKey("armeabi") == false) goto L12;
    L15:
        return true;
    L12:
        if (r3.containsKey("armeabi-v7a") == true) goto L15;
        return false;
    }

    public static void a(JSONObject r0, String r1, String r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(PolarisZipFileWrapper r6, ZipEntry r7, PolarisFileWrapper r8) throws IOException {
        String r0 = r7.getName();
        if (r0.contains(DownloadConstants.VULNERABILITY_PATH) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r8, r0.substring(r0.lastIndexOf(File.separator) + 1));
        int r9 = 0;
        boolean r2 = false;
    L7:
        if (r1.exists() == false) goto L18;
        r1.delete();
    L18:
        ZeusLogger.i("Zeus/install_zeus", "NativeLibHelper copySoZipEntry, soZipEntry=" + r7 + ", targetSoFile=" + r1);     // Catch: IOException -> L11
        i.d(r6.getInputStream(r7), new PolarisFileOutputStreamWrapper(r1));     // Catch: IOException -> L11
        r2 = true;
    L15:
        if (r2 == false) goto L7;
        return;
    L11:
        e = move-exception;
        if (r9 >= 3) goto L17;
        r9 = r9 + 1;
        goto L15
    L17:
        throw e;
    }

    public static void b(Map<String, List<ZipEntry>> r3, String r4, List<ZipEntry> r5, Set<String> r6) {
        List<ZipEntry> r7 = r3.get(r4);
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.size() == 0) goto L19;
        Iterator<ZipEntry> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L20;
        ZipEntry r9 = r8.next();
        String r0 = r9.getName().substring(r9.getName().lastIndexOf(File.separator) + 1);
        HashSet r1 = (HashSet) r6;
        if (r1.contains(r0) == true) goto L9;
        ((LinkedList) r5).add(r9);
        r1.add(r0);
        goto L9
    L20:
        return;
    }

    public static void c(PolarisFileWrapper r6, PolarisFileWrapper r7, String r8, Map r9) throws IOException {
        PolarisZipFileWrapper r4 = new PolarisZipFileWrapper(r6);     // Catch: Throwable -> L29 IOException -> L31
        if (r9 == null) goto L40;
    L8:
        boolean r10 = j(r9, f());     // Catch: Throwable -> L6 IOException -> L27
        ZeusLogger.i("Zeus/so_zeus", "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + r10 + "], pkg=" + r8 + ", plugin so entries = " + r9.keySet());     // Catch: Throwable -> L6 IOException -> L27
        if (r10 == false) goto L25;
        List<ZipEntry> r11 = g(r9);     // Catch: Throwable -> L6 IOException -> L27
        if (r11 != null) goto L13;
    L22:
        ZeusLogger.i("Zeus/install_zeus", "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=" + r8);     // Catch: Throwable -> L6 IOException -> L27
        r4.close();
        return;
    L13:
        if (r11.isEmpty() == true) goto L22;
        if (r7.exists() == true) goto L18;
        r7.mkdirs();     // Catch: Throwable -> L6 IOException -> L27
    L18:
        Iterator<ZipEntry> r12 = r11.iterator();     // Catch: Throwable -> L6 IOException -> L27
    L20:
        if (r12.hasNext() == false) goto L25;
        d(r4, r12.next(), r7);     // Catch: Throwable -> L6 IOException -> L27
    L25:
        r4.close();
        return;
    L40:
        r9 = e(r4);     // Catch: Throwable -> L6 IOException -> L27
    L27:
        e = e;
    L32:
        ZeusLogger.w("Zeus/install_zeus", "NativeLibHelper copyNativeLib, IOException, pkg=" + r8, e);     // Catch: Throwable -> L29
        throw e;     // Catch: Throwable -> L29
    L6:
        th = th;
    L35:
        if (r4 == null) goto L37;
        r4.close();
    L37:
        throw th;
    L29:
        th = th;
        r4 = null;
    L31:
        e = e;
        goto L32
    }
}
