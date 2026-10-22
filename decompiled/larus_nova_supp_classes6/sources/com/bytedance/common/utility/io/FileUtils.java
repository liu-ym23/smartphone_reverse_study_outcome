package com.bytedance.common.utility.io;

import android.content.Context;
import android.os.Environment;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.data.ISmModel;
import el9.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class FileUtils {
    private static final byte[] GIF87A = null;
    private static final byte[] GIF89A = null;
    private static final byte[] JPEG = null;
    private static final byte[] PNG = null;
    private static final String TAG = "FileUtils";

    static {
        GIF87A = new byte[]{71, 73, 70, 56, 55, 97};
        GIF89A = new byte[]{71, 73, 70, 56, 57, 97};
        JPEG = new byte[]{-1, -40, -1};
        PNG = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static boolean isExternalStorageReadable() {
        String r0 = Environment.getExternalStorageState();
        if ("mounted".equals(r0) == false) goto L5;
        return true;
    L5:
        if ("mounted_ro".equals(r0) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isExternalStorageWritable() {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private FileUtils() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_utility_io_FileUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static void clearDir(String r3) throws Exception {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r4 = r0.listFiles();
        int r1 = 0;
        if (r4 == null) goto L8;
        int r2 = r4.length;
    L9:
        if (r1 >= r2) goto L17;
        if (r4[r1].isDirectory() == false) goto L14;
        removeDir(r4[r1].getAbsolutePath());
    L16:
        r1 = r1 + 1;
        goto L9
    L14:
        if (r4[r1].isFile() == false) goto L16;
        r4[r1].delete();
        goto L16
    L17:
        return;
    L8:
        r2 = 0;
        goto L9
    }

    public static boolean exists(String r1) {
        if (StringUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        return new PolarisFileWrapper(r1).exists();
    }

    public static byte[] getByteArray(String r5) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r5);
        if (r0.exists() == true) goto L18;
        return null;
    L18:
        PolarisFileInputStreamWrapper r6 = new PolarisFileInputStreamWrapper(r0);     // Catch: Exception -> L10
        int r1 = (int) r0.length();     // Catch: Exception -> L10
        byte[] r2 = new byte[r1];     // Catch: Exception -> L10
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L8;
        r2[r3] = (byte) r6.read();     // Catch: Exception -> L10
        r3 = r3 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        r6.close();     // Catch: Exception -> L10
        return r2;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getCacheDirPath(Context r3) throws NullPointerException {
        if (r3 == null) goto L20;
        String r1 = null;
        if (r3.getCacheDir() == null) goto L9;
        String r4 = r3.getCacheDir().getPath();     // Catch: Throwable -> L13
    L8:
        r1 = r4;
        goto L15
    L9:
        File r5 = r3.getDir("/data/data/" + r3.getPackageName() + "/cache/", 0);     // Catch: Throwable -> L13
        if (r5 == null) goto L15;
        r4 = r5.getPath();     // Catch: Throwable -> L13
    L15:
        if (StringUtils.isEmpty(r1) == true) goto L18;
        return r1;
    L18:
        throw new NullPointerException("Cannot Create Cache Dir");
    L20:
        throw new NullPointerException("Context is NUll");
    }

    public static String getExtension(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = r2.lastIndexOf(".");
        if (r0 != (-1)) goto L10;
        return "";
    L10:
        return r2.substring(r0 + 1);
    }

    public static String getFileNameWithoutExtension(String r2) {
        String r3 = new PolarisFileWrapper(r2).getName();
        if (StringUtils.isEmpty(r3) == true) goto L8;
        int r0 = r3.lastIndexOf(".");
        if ((-1) != r0) goto L7;
        return "";
    L7:
        return r3.substring(0, r0);
    L8:
        return "";
    }

    public static String getFilesDirPath(Context r3) throws NullPointerException {
        if (r3 == null) goto L20;
        String r1 = null;
        if (r3.getFilesDir() == null) goto L9;
        String r4 = r3.getFilesDir().getPath();     // Catch: Throwable -> L13
    L8:
        r1 = r4;
        goto L15
    L9:
        File r5 = r3.getDir("/data/data/" + r3.getPackageName() + "/files/", 0);     // Catch: Throwable -> L13
        if (r5 == null) goto L15;
        r4 = r5.getPath();     // Catch: Throwable -> L13
    L15:
        if (StringUtils.isEmpty(r1) == true) goto L18;
        return r1;
    L18:
        throw new NullPointerException("Cannot Create Files Dir");
    L20:
        throw new NullPointerException("Context is NUll");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0072 -> B:64:0x0075). Please report as a decompilation issue!!! */
    public static ImageType getImageType(File r3) {
        if (r3 == null) goto L59;
        if (r3.exists() == false) goto L59;
        ImageType r0 = ImageType.UNKNOWN;
        ?? r1 = 0;
        FileInputStream r2 = null;
        r1 = 0;
        FileInputStream r4 = new PolarisFileInputStreamWrapper(r3);     // Catch: Throwable -> L42 Exception -> L44
        byte[] r5 = new byte[8];     // Catch: Throwable -> L38 Exception -> L40
        r4.read(r5);     // Catch: Throwable -> L38 Exception -> L40
        if (checkSignature(r5, GIF89A) == false) goto L12;
    L32:
        ImageType r6 = ImageType.GIF;     // Catch: Throwable -> L38 Exception -> L40
        r4.close();     // Catch: Exception -> L35
    L37:
        return r6;
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L12:
        if (checkSignature(r5, GIF87A) == true) goto L32;
        if (checkSignature(r5, JPEG) == false) goto L22;
        ImageType r7 = ImageType.JPG;     // Catch: Throwable -> L38 Exception -> L40
        r4.close();     // Catch: Exception -> L19
    L21:
        return r7;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L22:
        byte[] r8 = PNG;     // Catch: Throwable -> L38 Exception -> L40
        if (checkSignature(r5, r8) == false) goto L30;
        ImageType r9 = ImageType.PNG;     // Catch: Throwable -> L38 Exception -> L40
        r4.close();     // Catch: Exception -> L27
    L29:
        return r9;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L30:
        r4.close();     // Catch: Exception -> L49
        r1 = r8;
    L64:
        return r0;
    L40:
        e = e;
        r2 = r4;
    L45:
        e.printStackTrace();     // Catch: Throwable -> L42
        r1 = r2;
        if (r2 == null) goto L64;
        r2.close();     // Catch: Exception -> L49
        r1 = r2;
    L38:
        th = th;
        r1 = r4;
    L52:
        if (r1 != 0) goto L60;
    L57:
        throw th;
    L60:
        r1.close();     // Catch: Exception -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L42:
        th = th;
    L44:
        e = e;
    L49:
        e = move-exception;
        e.printStackTrace();
        r1 = r1;
    L59:
        return ImageType.UNKNOWN;
    }

    public static InputStream getInputStream(String r2) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        if (r0.exists() == true) goto L15;
        return null;
    L15:
        return new PolarisFileInputStreamWrapper(r0);
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L10
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean isGif(File r1) {
        if (getImageType(r1) != ImageType.GIF) goto L5;
        return true;
    L5:
        return false;
    }

    public static void removeDir(String r4) throws Exception {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L23;
        File[] r5 = r0.listFiles();
        int r1 = 0;
        if (r5 == null) goto L9;
        int r2 = r5.length;
    L10:
        if (r1 >= r2) goto L16;
        if (r5[r1].isDirectory() == false) goto L14;
        removeDir(r5[r1].getAbsolutePath());
    L15:
        r1 = r1 + 1;
        goto L10
    L14:
        r5[r1].delete();
        goto L15
    L16:
        r0.delete();
        return;
    L9:
        r2 = 0;
        goto L10
    }

    public static ImageType getImageType(String r1) {
        if (StringUtils.isEmpty(r1) == true) goto L7;
        return getImageType(new PolarisFileWrapper(r1));
    L7:
        return ImageType.UNKNOWN;
    }

    private static boolean checkSignature(byte[] r4, byte[] r5) {
        if (r4 == null) goto L17;
        if (r5 == null) goto L18;
        int r1 = 0;
    L8:
        if (r1 >= r5.length) goto L13;
        if (r4[r1] != r5[r1]) goto L19;
        r1 = r1 + 1;
        goto L8
    L19:
        return false;
    L13:
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public static void chmod(String r11, int r12) {
        Class r2 = INVOKESTATIC_com_bytedance_common_utility_io_FileUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.FileUtils");     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        if (r2 != null) goto L6;
        return;
    L6:
        Class<?> r6 = Integer.TYPE;     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        Method r3 = r2.getMethod("setPermissions", new Class[]{String.class, r6, r6, r6});     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        if (r3 != null) goto L9;
        return;
    L9:
        int r13 = ((Integer) r3.invoke(null, new Object[]{r11, Integer.valueOf(r12), -1, -1})).intValue();     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        if (r13 == 0) goto L21;
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() returned " + r13 + " for '" + r11 + "', probably didn't work.");     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        goto L26
    L25:
        return;
    L21:
        return;
    L16:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - ClassNotFoundException.");
        return;
    L15:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - IllegalAccessException.");
        return;
    L13:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - NoSuchMethodException.");
        return;
    L14:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - InvocationTargetException.");
        return;
    }

    public static void clearDir(String r3, Set<String> r4) throws Exception {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r5 = r0.listFiles();
        int r1 = 0;
        if (r5 == null) goto L8;
        int r2 = r5.length;
    L9:
        if (r1 >= r2) goto L21;
        if (r5[r1].isDirectory() == false) goto L14;
        removeDir(r5[r1].getAbsolutePath(), r4);
    L20:
        r1 = r1 + 1;
        goto L9
    L14:
        if (r5[r1].isFile() == false) goto L20;
        String r6 = r5[r1].getName();
        if (r4 != null) goto L18;
    L19:
        r5[r1].delete();
        goto L20
    L18:
        if (r4.contains(r6) == true) goto L20;
    L21:
        return;
    L8:
        r2 = 0;
        goto L9
    }

    public static long getDirectorySize(File r6, boolean r7) {
        long r0 = 0;
        if (r6.exists() == false) goto L6;
    L8:
        File[] r8 = r6.listFiles();     // Catch: Throwable -> L23
        int r2 = 0;
        if (r8 == null) goto L11;
        int r3 = r8.length;     // Catch: Throwable -> L23
    L12:
        if (r2 >= r3) goto L22;
        File r4 = r8[r2];     // Catch: Throwable -> L23
        if (r4.isDirectory() == false) goto L18;
        long r5 = getDirectorySize(r4, r7);     // Catch: Throwable -> L23
    L16:
        r0 = r0 + r5;     // Catch: Throwable -> L23
    L21:
        r2 = r2 + 1;
        goto L12
    L18:
        if (r4.isFile() == false) goto L21;
        r5 = r4.length();     // Catch: Throwable -> L23
        goto L16
    L11:
        r3 = 0;
        goto L12
    L6:
        if (r6.isDirectory() == false) goto L8;
        return 0;
    L22:
        return r0;
    }

    public static void removeDir(String r3, Set<String> r4) throws Exception {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L26;
        File[] r5 = r0.listFiles();
        int r1 = 0;
        if (r5 == null) goto L9;
        int r2 = r5.length;
    L10:
        if (r1 >= r2) goto L27;
        if (r5[r1].isDirectory() == false) goto L14;
        removeDir(r5[r1].getAbsolutePath(), r4);
    L19:
        r1 = r1 + 1;
        goto L10
    L14:
        String r6 = r5[r1].getName();
        if (r4 != null) goto L17;
    L18:
        r5[r1].delete();
        goto L19
    L17:
        if (r4.contains(r6) == true) goto L19;
    L27:
        return;
    L9:
        r2 = 0;
        goto L10
    }

    public static boolean copyFile(String r3, String r4, String r5) {
        if (StringUtils.isEmpty(r3) == false) goto L5;
    L37:
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L37;
        if (StringUtils.isEmpty(r5) == true) goto L37;
        FileInputStream r0 = null;
        FileInputStream r2 = new PolarisFileInputStreamWrapper(r3);     // Catch: Throwable -> L21 Exception -> L23
        boolean r6 = saveInputStream(r2, r4, r5);     // Catch: Throwable -> L17 Exception -> L19
        r2.close();     // Catch: Exception -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L19:
        e = e;
        r0 = r2;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r0 != null) goto L40;
    L30:
        return false;
    L40:
        r0.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
        r0 = r2;
    L31:
        if (r0 != null) goto L42;
    L36:
        throw th;
    L42:
        r0.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L21:
        th = th;
        goto L31
    }

    public static boolean saveInputStream(InputStream r4, String r5, String r6) {
        if (r4 != null) goto L5;
        return false;
    L5:
        FileOutputStream r1 = null;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r5);     // Catch: Throwable -> L33 Exception -> L35
        if (r2.exists() == false) goto L9;
    L15:
        FileOutputStream r7 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r2, r6));     // Catch: Throwable -> L33 Exception -> L35
        byte[] r8 = new byte[ISmModel.VERSION_0400];     // Catch: Throwable -> L29 Exception -> L31
    L18:
        int r3 = r4.read(r8);     // Catch: Throwable -> L29 Exception -> L31
        if (r3 == (-1)) goto L21;
        r7.write(r8, 0, r3);     // Catch: Throwable -> L29 Exception -> L31
        goto L18
    L21:
        r7.flush();     // Catch: Throwable -> L29 Exception -> L31
        r7.close();     // Catch: Throwable -> L29 Exception -> L31
        r4.close();     // Catch: Throwable -> L33 Exception -> L35
        r4.close();     // Catch: Exception -> L25
        return true;
    L25:
        e = move-exception;
        e.printStackTrace();
        return true;
    L31:
        e = e;
        r1 = r7;
    L36:
        Logger.d(TAG, "save inputstream error: " + e);     // Catch: Throwable -> L33
        if (r1 == null) goto L62;
        r1.close();     // Catch: Exception -> L52
    L62:
        r4.close();     // Catch: Exception -> L41
    L43:
        return false;
    L41:
        e = move-exception;
        e.printStackTrace();
    L29:
        th = th;
        r1 = r7;
    L44:
        if (r1 == null) goto L65;
        r1.close();     // Catch: Exception -> L51
    L65:
        r4.close();     // Catch: Exception -> L48
        throw th;
    L48:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L9:
        if (r2.mkdirs() == true) goto L15;
        r4.close();     // Catch: Exception -> L12
    L14:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
    L33:
        th = th;
    L35:
        e = e;
        goto L36
    }
}
