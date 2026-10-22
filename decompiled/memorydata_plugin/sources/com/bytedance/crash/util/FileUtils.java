package com.bytedance.crash.util;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    public FileUtils() {
    }

    public static void clearFile(File r4) {
        r4.getParentFile().mkdirs();
        FileOutputStream r1 = null;
        FileOutputStream r2 = new FileOutputStream(r4, false);     // Catch: Throwable -> L9
        r2.write("".getBytes());     // Catch: Throwable -> L7
        r2.flush();     // Catch: Throwable -> L7
        FileSystemUtils.close(r2);
        return;
    L7:
        th = th;
        r1 = r2;
    L10:
        FileSystemUtils.close(r1);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static void copy(File r1, File r2) {
        copy(r1, r2, Integer.MAX_VALUE);
    }

    public static void copy(File r1, File r2, int r3) {
        copy(r1, r2, r3, false);
    }

    public static void copy(File r3, File r4, int r5, boolean r6) {
        if (r3 == null) goto L46;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3.exists() == true) goto L7;
        return;
    L7:
        if (r4.exists() == false) goto L10;
        if (r6 == true) goto L10;
        return;
    L10:
        FileInputStream r0 = null;
        r4.getParentFile().mkdirs();     // Catch: Throwable -> L28 Exception -> L32
        FileInputStream r1 = new FileInputStream(r3);     // Catch: Throwable -> L28 Exception -> L32
    L41:
        FileOutputStream r7 = new FileOutputStream(r4, r6);     // Catch: Throwable -> L23 Exception -> L26
    L39:
        byte[] r8 = new byte[8192];     // Catch: Throwable -> L21 Exception -> L36
        int r2 = 0;
    L15:
        int r9 = r1.read(r8);     // Catch: Throwable -> L21 Exception -> L36
        if (r9 <= 0) goto L20;
        r7.write(r8, 0, r9);     // Catch: Throwable -> L21 Exception -> L36
        r2 = r2 + r9;
        if (r2 < r5) goto L15;
    L20:
        FileSystemUtils.close(r1);
    L34:
        FileSystemUtils.close(r7);
        return;
    L21:
        th = th;
    L25:
        r0 = r1;
    L30:
        FileSystemUtils.close(r0);
        FileSystemUtils.close(r7);
        throw th;
    L27:
        r0 = r1;
    L33:
        FileSystemUtils.close(r0);
    L26:
        r7 = null;
    L23:
        th = th;
        r7 = null;
    L32:
        r7 = null;
    L28:
        th = th;
        r7 = null;
        goto L30
    }

    public static void copyAppend(File r2, File r3) {
        copy(r2, r3, Integer.MAX_VALUE, true);
    }

    public static void copyDir(File r6, File r7) {
        if (r6.exists() == true) goto L6;
        return;
    L6:
        if (r6.isFile() == false) goto L16;
        if (r7.exists() == true) goto L10;
    L13:
        copy(r6, r7, Integer.MAX_VALUE);
        return;
    L10:
        if (r7.isDirectory() == false) goto L12;
        return;
    L12:
        r7.delete();
        goto L13
    L16:
        if (r7.exists() == true) goto L18;
        r7.mkdirs();
    L24:
        String[] r0 = r6.list();
        int r1 = r0.length;
        int r2 = 0;
    L25:
        if (r2 >= r1) goto L27;
        String r3 = r0[r2];
        copyDir(new File(r6, r3), new File(r7, r3));
        r2 = r2 + 1;
        goto L25
    L27:
        return;
    L18:
        if (r7.isFile() == false) goto L21;
        r7.delete();
        goto L24
    L21:
        if (r7.getName().equals(r6.getName()) == true) goto L24;
    }

    public static boolean deleteFile(File r5) {
        boolean r1 = true;
        if (r5.exists() == true) goto L6;
        return true;
    L6:
        if (r5.canWrite() == true) goto L9;
        return false;
    L9:
        if (r5.isFile() == false) goto L13;
        return r5.delete();
    L13:
        if (r5.isDirectory() == false) goto L33;
        File[] r0 = r5.listFiles();
        int r3 = 0;
    L15:
        if (r0 == null) goto L28;
        if (r3 >= r0.length) goto L28;
        if (r0[r3].isFile() == true) goto L21;
        boolean r4 = deleteFile(r0[r3]);
    L25:
        r1 = r1 & r4;
    L26:
        r3 = r3 + 1;
        goto L15
    L21:
        if (r0[r3].canWrite() == false) goto L23;
        r4 = r0[r3].delete();
        goto L25
    L23:
        r1 = false;
    L28:
        return r1 & r5.delete();
    L33:
        return true;
    }

    public static boolean deleteFile(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return deleteFile(new File(r1));
    }

    public static File getExceptionLogDir(File r6) {
        if (r6 != null) goto L20;
        return null;
    L20:
        File[] r1 = r6.listFiles();     // Catch: Throwable -> L17
        if (r1 != null) goto L8;
    L16:
        return null;
    L8:
        if (r1.length <= 0) goto L16;
        int r2 = r1.length;     // Catch: Throwable -> L17
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L19;
        File r4 = r1[r3];     // Catch: Throwable -> L17
        if (r4.isFile() == false) goto L15;
        r3 = r3 + 1;
        goto L11
    L15:
        return r4;
    L19:
        return null;
    L17:
        th = move-exception;
        NpthLog.e("NPTH", " path:" + r6 + " exception:" + th);
        goto L19
    }

    public static boolean isEmpty(File r0) {
        String[] r1 = r0.list();
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1.length == 0) goto L8;
        return false;
    }

    public static boolean isEmpty(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(File[] r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length == 0) goto L7;
        return false;
    }

    public static String readFile(File r1) {
        return readFile(r1, "\n");
    }

    public static String readFile(File r1, long r2) {
        return readFile(r1, "\n", r2);
    }

    public static String readFile(File r2, String r3) {
        return readFile(r2, r3, -1);
    }

    public static String readFile(File r5, String r6, long r7) {
        if (r5 != null) goto L4;
        return "";
    L4:
        if (r5.exists() == false) goto L37;
        StringBuilder r0 = new StringBuilder();
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L23
        if (r7 <= 0) goto L11;
        r2.skip(r7);     // Catch: Throwable -> L21
        r2.readLine();     // Catch: Throwable -> L21
    L21:
        th = th;
        r1 = r2;
    L24:
        FileSystemUtils.close(r1);
        throw th;
    L11:
        String r8 = r2.readLine();     // Catch: Throwable -> L21
        if (r8 == null) goto L19;
        if (r0.length() == 0) goto L17;
        if (r6 == null) goto L17;
        r0.append(r6);     // Catch: Throwable -> L21
    L17:
        r0.append(r8);     // Catch: Throwable -> L21
        goto L11
    L19:
        FileSystemUtils.close(r2);
        return r0.toString();
    L23:
        th = th;
        goto L24
    L37:
        return "";
    }

    public static String readFile(String r1) {
        return readFile(r1, "\n");
    }

    public static String readFile(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return null;
    L7:
        return readFile(new File(r1), r2);
    }

    public static JSONArray readFileArray(File r2) {
        return readFileArray(r2, -1);
    }

    public static JSONArray readFileArray(File r5, long r6) {
        JSONArray r0 = new JSONArray();
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L15
        if (r6 <= 0) goto L7;
        r2.skip(r6);     // Catch: Throwable -> L13
        r2.readLine();     // Catch: Throwable -> L13
    L13:
        th = th;
        r1 = r2;
    L16:
        FileSystemUtils.close(r1);
        throw th;
    L7:
        String r7 = r2.readLine();     // Catch: Throwable -> L13
        if (r7 == null) goto L11;
        r0.put(r7);     // Catch: Throwable -> L13
        goto L7
    L11:
        FileSystemUtils.close(r2);
        return r0;
    L15:
        th = th;
        goto L16
    }

    public static JSONArray readFileArray(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return null;
    L7:
        return readFileArray(new File(r3), -1);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0049: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:21:0x0049 */
    public static Map<String, String> readPropertiesFile(File r7) {
        Closeable r0 = null;
        Properties r1 = new Properties();     // Catch: Throwable -> L13 IOException -> L15
        FileInputStream r2 = new FileInputStream(r7);     // Catch: Throwable -> L13 IOException -> L15
        r1.load(r2);     // Catch: IOException -> L11 Throwable -> L20
        Set<String> r8 = r1.stringPropertyNames();     // Catch: IOException -> L11 Throwable -> L20
        HashMap r3 = new HashMap();     // Catch: IOException -> L11 Throwable -> L20
        Iterator<String> r9 = r8.iterator();     // Catch: IOException -> L11 Throwable -> L20
    L6:
        if (r9.hasNext() == false) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L11 Throwable -> L20
        r3.put(r4, r1.getProperty(r4));     // Catch: IOException -> L11 Throwable -> L20
        goto L6
    L9:
        FileSystemUtils.close(r2);
        return r3;
    L11:
        e = e;
    L17:
        NpthLog.w(e);     // Catch: Throwable -> L20
        FileSystemUtils.close(r2);
        return null;
    L20:
        th = th;
        r0 = r2;
    L22:
        FileSystemUtils.close(r0);
        throw th;
    L15:
        e = e;
        r2 = null;
    L13:
        th = th;
        goto L22
    }

    public static String safeReadFile(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return "";
    L8:
        return readFile(new File(r2), "\n");
    L7:
        return "";
    }

    public static void safeWriteFile(File r4, JSONArray r5, boolean r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        r4.getParentFile().mkdirs();
        Closeable r0 = null;
        if (r5 != null) goto L10;
        Closeable r7 = new FileOutputStream(r4, false);     // Catch: Throwable -> L17
        ((FileOutputStream) ZeusTransformUtils.preCheckCast(r7, FileOutputStream.class, "com.obric.memorydata.plugin")).write("".getBytes());     // Catch: Throwable -> L9
        ((FileOutputStream) ZeusTransformUtils.preCheckCast(r7, FileOutputStream.class, "com.obric.memorydata.plugin")).flush();     // Catch: Throwable -> L9
    L13:
        FileSystemUtils.close(r7);
        return;
    L9:
        r0 = r7;
        goto L15
    L10:
        BufferedWriter r2 = new BufferedWriter(new FileWriter(r4, r6));     // Catch: Throwable -> L17
        JSONWriter.writeTo(r5, (BufferedWriter) ZeusTransformUtils.preCheckCast(r2, BufferedWriter.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        r7 = r2;
    L14:
        r0 = r2;
    L15:
        FileSystemUtils.close(r0);
    }

    public static String tryReadFile(File r0) {
        return readFile(r0);
    L4:
        return null;
    }

    public static void writeFile(File r2, String r3, boolean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        r2.getParentFile().mkdirs();
        FileOutputStream r0 = null;
        FileOutputStream r1 = new FileOutputStream(r2, r4);     // Catch: Throwable -> L12
        r1.write(r3.getBytes());     // Catch: Throwable -> L10
        r1.flush();     // Catch: Throwable -> L10
        FileSystemUtils.close(r1);
        return;
    L10:
        th = th;
        r0 = r1;
    L13:
        FileSystemUtils.close(r0);
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static void writeFile(File r3, JSONArray r4, boolean r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        r3.getParentFile().mkdirs();
        BufferedWriter r0 = null;
        BufferedWriter r1 = new BufferedWriter(new FileWriter(r3, r5));     // Catch: Throwable -> L11
        JSONWriter.writeTo(r4, r1);     // Catch: Throwable -> L8
        FileSystemUtils.close(r1);
        return;
    L8:
        r0 = r1;
    L9:
        FileSystemUtils.close(r0);
    }

    public static void writeFile(File r3, JSONObject r4, boolean r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        r3.getParentFile().mkdirs();
        BufferedWriter r0 = null;
        BufferedWriter r1 = new BufferedWriter(new FileWriter(r3, r5));     // Catch: Throwable -> L11
        JSONWriter.writeTo(r4, r1);     // Catch: Throwable -> L8
        FileSystemUtils.close(r1);
        return;
    L8:
        r0 = r1;
    L9:
        FileSystemUtils.close(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static void writePropertiesFile(File r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isEmpty() == true) goto L35;
        ?? r0 = 0;
        String r1 = null;
        FileOutputStream r2 = null;
        Properties r3 = new Properties();     // Catch: Throwable -> L19 IOException -> L21
        FileOutputStream r4 = new FileOutputStream(r5);     // Catch: Throwable -> L19 IOException -> L21
        Iterator r8 = r7.entrySet().iterator();     // Catch: Throwable -> L15 IOException -> L17
    L11:
        if (r8.hasNext() == false) goto L13;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 IOException -> L17
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 IOException -> L17
        r3.setProperty(r10, (String) ZeusTransformUtils.preCheckCast(r9.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15 IOException -> L17
        r1 = r10;
        goto L11
    L13:
        r3.store(r4, "no");     // Catch: Throwable -> L15 IOException -> L17
        FileSystemUtils.close(r4);
        r0 = r1;
    L28:
        return;
    L17:
        e = e;
        r2 = r4;
    L22:
        NpthLog.w(e);     // Catch: Throwable -> L19
        FileSystemUtils.close(r2);
        r0 = r2;
    L15:
        th = th;
        r0 = r4;
    L25:
        FileSystemUtils.close(r0);
        throw th;
    L19:
        th = th;
    L21:
        e = e;
        goto L22
    }

    public static void zip(OutputStream r3, List<File> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5.size() == 0) goto L17;
        ZipOutputStream r0 = null;
        ZipOutputStream r2 = new ZipOutputStream(r3);     // Catch: Throwable -> L14
        r2.putNextEntry(new ZipEntry("/"));     // Catch: Throwable -> L12
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L12
    L8:
        if (r6.hasNext() == false) goto L11;
        zip(r2, (File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.memorydata.plugin"), true);     // Catch: Throwable -> L12
        goto L8
    L11:
        FileSystemUtils.close(r2);
        return;
    L12:
        th = th;
        r0 = r2;
    L15:
        FileSystemUtils.close(r0);
        throw th;
    L14:
        th = th;
        goto L15
    }

    private static void zip(String r3, File r4) {
        ZipOutputStream r0 = null;
        new File(r3).getParentFile().mkdirs();     // Catch: Throwable -> L9
        ZipOutputStream r1 = new ZipOutputStream(new FileOutputStream(r3));     // Catch: Throwable -> L9
        zip(r1, r4, "");     // Catch: Throwable -> L7
        FileSystemUtils.close(r1);
        return;
    L7:
        th = th;
        r0 = r1;
    L10:
        FileSystemUtils.close(r0);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static void zip(String r1, String r2) {
        zip(r2, new File(r1));
    }

    private static void zip(ZipOutputStream r5, File r6, String r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.exists() == false) goto L42;
        int r1 = 0;
        if (r6.isDirectory() == false) goto L18;
        File[] r8 = r6.listFiles();
        if (r8 != null) goto L11;
        return;
    L11:
        r5.putNextEntry(new ZipEntry(r7 + "/"));
        if (r7.length() != 0) goto L14;
        String r9 = "";
    L15:
        int r0 = r8.length;
    L16:
        if (r1 >= r0) goto L41;
        File r2 = r8[r1];
        zip(r5, r2, r9 + r2.getName());
        r1 = r1 + 1;
        goto L16
    L41:
        return;
    L14:
        r9 = r7 + "/";
        goto L15
    L18:
        r5.putNextEntry(new ZipEntry(r7));
        FileInputStream r10 = null;
        FileInputStream r3 = new FileInputStream(r6);     // Catch: Throwable -> L30
        byte[] r11 = new byte[4096];     // Catch: Throwable -> L28
    L22:
        int r4 = r3.read(r11);     // Catch: Throwable -> L28
        if ((-1) == r4) goto L26;
        r5.write(r11, 0, r4);     // Catch: Throwable -> L28
        goto L22
    L26:
        FileSystemUtils.close(r3);
        return;
    L28:
        th = th;
        r10 = r3;
    L31:
        FileSystemUtils.close(r10);
        throw th;
    L30:
        th = th;
        goto L31
    }

    private static void zip(ZipOutputStream r3, File r4, boolean r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.exists() == false) goto L22;
        if (r5 == false) goto L8;
    L11:
        int r0 = 0;
        if (r4.isDirectory() == false) goto L14;
        File[] r6 = r4.listFiles();
    L15:
        if (r6 != null) goto L17;
        return;
    L17:
        int r7 = r6.length;
    L18:
        if (r0 >= r7) goto L23;
        File r1 = r6[r0];
        zip(r3, r1, r1.getName());
        r0 = r0 + 1;
        goto L18
    L23:
        return;
    L14:
        r6 = new File[]{r4};
        goto L15
    L8:
        if (r4.isDirectory() == false) goto L11;
        zip(r3, r4, r4.getName());
        return;
    }
}
