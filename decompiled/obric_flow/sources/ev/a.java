package ev;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f16871a = null;

    static {
        HashMap r5 = new HashMap();
        f16871a = r5;
        r5.put("x86", "x86");
        r5.put("i386", "x86");
        r5.put("i486", "x86");
        r5.put("i586", "x86");
        r5.put("i686", "x86");
        r5.put("pentium", "x86");
        r5.put("x86_64", "x86_64");
        r5.put("amd64", "x86_64");
        r5.put("em64t", "x86_64");
        r5.put("universal", "x86_64");
        r5.put("ia64", "ia64");
        r5.put("ia64w", "ia64");
        r5.put("ia64_32", "ia64_32");
        r5.put("ia64n", "ia64_32");
        r5.put("ppc", "ppc");
        r5.put("power", "ppc");
        r5.put("powerpc", "ppc");
        r5.put("power_pc", "ppc");
        r5.put("power_rs", "ppc");
        r5.put("ppc64", "ppc64");
        r5.put("power64", "ppc64");
        r5.put("powerpc64", "ppc64");
        r5.put("power_pc64", "ppc64");
        r5.put("power_rs64", "ppc64");
    }

    public static String a() {
        String r5 = System.getProperty("os.arch");
        if (System.getProperty("java.runtime.name", "").toLowerCase().contains("android") == false) goto L7;
        return "android-arm";
    L7:
        if (r5.startsWith("arm") == true) goto L9;
        String r10 = r5.toLowerCase(Locale.US);
        HashMap r11 = f16871a;
        if (r11.containsKey(r10) == true) goto L53;
    L55:
        return r5.replaceAll("\\W", "");
    L53:
        return (String) r11.get(r10);
    L9:
        if (System.getProperty("os.name").contains("Linux") == false) goto L33;
        Process r12 = Runtime.getRuntime().exec("uname -m");     // Catch: Throwable -> L19
        r12.waitFor();     // Catch: Throwable -> L19
        InputStream r13 = r12.getInputStream();     // Catch: Throwable -> L19
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        byte[] r15 = new byte[32];     // Catch: Throwable -> L15
    L12:
        int r16 = r13.read(r15, 0, 32);     // Catch: Throwable -> L15
        if (r16 < 0) goto L17;
        r14.write(r15, 0, r16);     // Catch: Throwable -> L15
        goto L12
    L17:
        String r17 = r14.toString();     // Catch: Throwable -> L15
        r13.close();     // Catch: Throwable -> L19
    L25:
        r5 = "armv6";
        if (r17.startsWith("armv6") == true) goto L55;
        r5 = "armv7";
        if (r17.startsWith("armv7") == true) goto L55;
        if (r17.startsWith("armv5") == true) goto L33;
        if (r17.startsWith("aarch64") == false) goto L37;
        r5 = "aarch64";
        goto L55
    L37:
        String r18 = System.getProperty("sun.arch.abi");
        if (r18 != null) goto L40;
    L42:
        String r19 = System.getProperty("java.home");
        if (Runtime.getRuntime().exec("which readelf").waitFor() == 0) goto L46;
        System.err.println("WARNING! readelf not found. Cannot check if running on an armhf system, armel architecture will be presumed.");     // Catch: Throwable -> L56
    L58:
        goto L33
    L46:
        if (Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", "find '" + r19 + "' -name 'libjvm.so' | head -1 | xargs readelf -A | grep 'Tag_ABI_VFP_args: VFP registers'"}).waitFor() != 0) goto L58;
    L40:
        if (r18.startsWith("gnueabihf") == false) goto L42;
    L15:
        th = move-exception;
        if (r13 == null) goto L23;
        r13.close();     // Catch: Throwable -> L19
    L23:
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        System.err.println("Error while running uname -m: " + th.getMessage());
        r17 = "unknown";
    L33:
        r5 = "arm";
        goto L55
    }

    public static String b() {
        String r5 = System.getProperty("os.name");
        if (r5.contains("Windows") == false) goto L6;
        return "Windows";
    L6:
        if (r5.contains("Mac") == false) goto L8;
        return "Mac";
    L8:
        if (r5.contains("Darwin") == true) goto L41;
        boolean r10 = false;
        Process r11 = Runtime.getRuntime().exec("cat /etc/os-release | grep ^ID");     // Catch: Throwable -> L33
        r11.waitFor(300, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L33
        InputStream r12 = r11.getInputStream();     // Catch: Throwable -> L33
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();     // Catch: Throwable -> L16
        byte[] r14 = new byte[32];     // Catch: Throwable -> L16
    L13:
        int r15 = r12.read(r14, 0, 32);     // Catch: Throwable -> L16
        if (r15 < 0) goto L18;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L16
        goto L13
    L18:
        boolean r16 = r13.toString().toLowerCase().contains("alpine");     // Catch: Throwable -> L16
        r12.close();     // Catch: Throwable -> L33
        r10 = r16;
        goto L23
    L16:
        th = move-exception;
        if (r12 == null) goto L22;
        r12.close();     // Catch: Throwable -> L33
    L22:
        throw th;     // Catch: Throwable -> L33
    L23:
        if (r10 == false) goto L26;
        return "Linux-Alpine";
    L26:
        if (r5.contains("Linux") == false) goto L29;
        return "Linux";
    L29:
        if (r5.contains("AIX") == false) goto L32;
        return "AIX";
    L32:
        return r5.replaceAll("\\W", "");
    L41:
        return "Mac";
    }
}
