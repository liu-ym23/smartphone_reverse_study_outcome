package com.bytedance.crash.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    public FileUtils() {
    }

    public static void clearFile(@NonNull File r10) {
        r10.getParentFile().mkdirs();
        FileOutputStream r11 = null;
        FileOutputStream r12 = new FileOutputStream(r10, false);     // Catch: Throwable -> L9
        r12.write("".getBytes());     // Catch: Throwable -> L7
        r12.flush();     // Catch: Throwable -> L7
        FileSystemUtils.close(r12);
        return;
    L7:
        th = th;
        r11 = r12;
    L10:
        FileSystemUtils.close(r11);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static void copy(File r10, File r11) {
        copy(r10, r11, Integer.MAX_VALUE);
    }

    public static void copy(File r10, File r11, int r12) {
        copy(r10, r11, r12, false);
    }

    public static void copy(File r10, File r11, int r12, boolean r13) {
        if (r10 == null) goto L46;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10.exists() == true) goto L7;
        return;
    L7:
        if (r11.exists() == false) goto L10;
        if (r13 == true) goto L10;
        return;
    L10:
        FileInputStream r14 = null;
        r11.getParentFile().mkdirs();     // Catch: Throwable -> L28 Exception -> L32
        FileInputStream r15 = new FileInputStream(r10);     // Catch: Throwable -> L28 Exception -> L32
    L41:
        FileOutputStream r16 = new FileOutputStream(r11, r13);     // Catch: Throwable -> L23 Exception -> L26
    L39:
        byte[] r17 = new byte[8192];     // Catch: Throwable -> L21 Exception -> L36
        int r18 = 0;
    L15:
        int r19 = r15.read(r17);     // Catch: Throwable -> L21 Exception -> L36
        if (r19 <= 0) goto L20;
        r16.write(r17, 0, r19);     // Catch: Throwable -> L21 Exception -> L36
        r18 = r18 + r19;
        if (r18 < r12) goto L15;
    L20:
        FileSystemUtils.close(r15);
    L34:
        FileSystemUtils.close(r16);
        return;
    L21:
        th = th;
    L25:
        r14 = r15;
    L30:
        FileSystemUtils.close(r14);
        FileSystemUtils.close(r16);
        throw th;
    L27:
        r14 = r15;
    L33:
        FileSystemUtils.close(r14);
    L26:
        r16 = null;
    L23:
        th = th;
        r16 = null;
    L32:
        r16 = null;
    L28:
        th = th;
        r16 = null;
        goto L30
    }

    public static void copyAppend(File r10, File r11) {
        copy(r10, r11, Integer.MAX_VALUE, true);
    }

    public static void copyDir(File r10, File r11) {
        if (r10.exists() == true) goto L6;
        return;
    L6:
        if (r10.isFile() == false) goto L16;
        if (r11.exists() == true) goto L10;
    L13:
        copy(r10, r11, Integer.MAX_VALUE);
        return;
    L10:
        if (r11.isDirectory() == false) goto L12;
        return;
    L12:
        r11.delete();
        goto L13
    L16:
        if (r11.exists() == true) goto L18;
        r11.mkdirs();
    L24:
        String[] r12 = r10.list();
        int r13 = r12.length;
        int r14 = 0;
    L25:
        if (r14 >= r13) goto L27;
        String r15 = r12[r14];
        copyDir(new File(r10, r15), new File(r11, r15));
        r14 = r14 + 1;
        goto L25
    L27:
        return;
    L18:
        if (r11.isFile() == false) goto L21;
        r11.delete();
        goto L24
    L21:
        if (r11.getName().equals(r10.getName()) == true) goto L24;
    }

    public static boolean deleteFile(@NonNull File r10) {
        boolean r11 = true;
        if (r10.exists() == true) goto L6;
        return true;
    L6:
        if (r10.canWrite() == true) goto L9;
        return false;
    L9:
        if (r10.isFile() == false) goto L13;
        return r10.delete();
    L13:
        if (r10.isDirectory() == false) goto L33;
        File[] r12 = r10.listFiles();
        int r13 = 0;
    L15:
        if (r12 == null) goto L28;
        if (r13 >= r12.length) goto L28;
        if (r12[r13].isFile() == true) goto L21;
        boolean r14 = deleteFile(r12[r13]);
    L25:
        r11 = r11 & r14;
    L26:
        r13 = r13 + 1;
        goto L15
    L21:
        if (r12[r13].canWrite() == false) goto L23;
        r14 = r12[r13].delete();
        goto L25
    L23:
        r11 = false;
    L28:
        return r11 & r10.delete();
    L33:
        return true;
    }

    public static boolean deleteFile(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return false;
    L7:
        return deleteFile(new File(r10));
    }

    public static File getExceptionLogDir(File r10) {
        if (r10 != null) goto L20;
        return null;
    L20:
        File[] r11 = r10.listFiles();     // Catch: Throwable -> L17
        if (r11 != null) goto L8;
    L16:
        return null;
    L8:
        if (r11.length <= 0) goto L16;
        int r12 = r11.length;     // Catch: Throwable -> L17
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L19;
        File r14 = r11[r13];     // Catch: Throwable -> L17
        if (r14.isFile() == false) goto L15;
        r13 = r13 + 1;
        goto L11
    L15:
        return r14;
    L19:
        return null;
    L17:
        th = move-exception;
        NpthLog.e("NPTH", " path:" + r10 + " exception:" + th);
        goto L19
    }

    public static boolean isEmpty(File r10) {
        String[] r11 = r10.list();
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (r11.length == 0) goto L8;
        return false;
    }

    public static boolean isEmpty(JSONArray r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(File[] r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length == 0) goto L7;
        return false;
    }

    public static String readFile(File r10) {
        return readFile(r10, "\n");
    }

    public static String readFile(File r10, long r11) {
        return readFile(r10, "\n", r11);
    }

    public static String readFile(File r10, String r11) {
        return readFile(r10, r11, -1);
    }

    public static String readFile(File r10, String r11, long r12) {
        if (r10 != null) goto L4;
        return "";
    L4:
        if (r10.exists() == false) goto L37;
        StringBuilder r13 = new StringBuilder();
        BufferedReader r14 = null;
        BufferedReader r15 = new BufferedReader(new FileReader(r10));     // Catch: Throwable -> L23
        if (r12 <= 0) goto L11;
        r15.skip(r12);     // Catch: Throwable -> L21
        r15.readLine();     // Catch: Throwable -> L21
    L21:
        th = th;
        r14 = r15;
    L24:
        FileSystemUtils.close(r14);
        throw th;
    L11:
        String r16 = r15.readLine();     // Catch: Throwable -> L21
        if (r16 == null) goto L19;
        if (r13.length() == 0) goto L17;
        if (r11 == null) goto L17;
        r13.append(r11);     // Catch: Throwable -> L21
    L17:
        r13.append(r16);     // Catch: Throwable -> L21
        goto L11
    L19:
        FileSystemUtils.close(r15);
        return r13.toString();
    L23:
        th = th;
        goto L24
    L37:
        return "";
    }

    public static String readFile(String r10) {
        return readFile(r10, "\n");
    }

    @Nullable
    public static String readFile(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return null;
    L7:
        return readFile(new File(r10), r11);
    }

    public static JSONArray readFileArray(File r10) {
        return readFileArray(r10, -1);
    }

    public static JSONArray readFileArray(@NonNull File r10, long r11) {
        JSONArray r12 = new JSONArray();
        BufferedReader r13 = null;
        BufferedReader r14 = new BufferedReader(new FileReader(r10));     // Catch: Throwable -> L15
        if (r11 <= 0) goto L7;
        r14.skip(r11);     // Catch: Throwable -> L13
        r14.readLine();     // Catch: Throwable -> L13
    L13:
        th = th;
        r13 = r14;
    L16:
        FileSystemUtils.close(r13);
        throw th;
    L7:
        String r15 = r14.readLine();     // Catch: Throwable -> L13
        if (r15 == null) goto L11;
        r12.put(r15);     // Catch: Throwable -> L13
        goto L7
    L11:
        FileSystemUtils.close(r14);
        return r12;
    L15:
        th = th;
        goto L16
    }

    @Nullable
    public static JSONArray readFileArray(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return null;
    L7:
        return readFileArray(new File(r10), -1);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0041: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:21:0x0041 */
    @Nullable
    public static Map<String, String> readPropertiesFile(File r10) {
        Closeable r11 = null;
        Properties r12 = new Properties();     // Catch: Throwable -> L13 IOException -> L15
        FileInputStream r13 = new FileInputStream(r10);     // Catch: Throwable -> L13 IOException -> L15
        r12.load(r13);     // Catch: IOException -> L11 Throwable -> L20
        Set<String> r14 = r12.stringPropertyNames();     // Catch: IOException -> L11 Throwable -> L20
        HashMap r15 = new HashMap();     // Catch: IOException -> L11 Throwable -> L20
        Iterator<String> r16 = r14.iterator();     // Catch: IOException -> L11 Throwable -> L20
    L6:
        if (r16.hasNext() == false) goto L9;
        String r17 = r16.next();     // Catch: IOException -> L11 Throwable -> L20
        r15.put(r17, r12.getProperty(r17));     // Catch: IOException -> L11 Throwable -> L20
        goto L6
    L9:
        FileSystemUtils.close(r13);
        return r15;
    L11:
        e = e;
    L17:
        NpthLog.w(e);     // Catch: Throwable -> L20
        FileSystemUtils.close(r13);
        return null;
    L20:
        th = th;
        r11 = r2;
    L22:
        FileSystemUtils.close(r11);
        throw th;
    L15:
        e = e;
        r13 = null;
    L13:
        th = th;
        goto L22
    }

    public static String safeReadFile(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return "";
    L8:
        return readFile(new File(r10), "\n");
    L7:
        return "";
    }

    public static void safeWriteFile(File r10, JSONArray r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.getParentFile().mkdirs();
        Closeable r13 = null;
        if (r11 != null) goto L10;
        FileOutputStream r14 = new FileOutputStream(r10, false);     // Catch: Throwable -> L17
        r14.write("".getBytes());     // Catch: Throwable -> L9
        r14.flush();     // Catch: Throwable -> L9
        Closeable r15 = r14;
    L13:
        FileSystemUtils.close(r15);
        return;
    L9:
        r13 = r14;
        goto L15
    L10:
        BufferedWriter r16 = new BufferedWriter(new FileWriter(r10, r12));     // Catch: Throwable -> L17
        JSONWriter.writeTo(r11, r16);     // Catch: Throwable -> L14
        r15 = r16;
    L14:
        r13 = r16;
    L15:
        FileSystemUtils.close(r13);
    }

    @Nullable
    public static String tryReadFile(File r10) {
        return readFile(r10);
    L4:
        return null;
    }

    public static void writeFile(@NonNull File r10, @NonNull String r11, boolean r12) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        r10.getParentFile().mkdirs();
        FileOutputStream r13 = null;
        FileOutputStream r14 = new FileOutputStream(r10, r12);     // Catch: Throwable -> L12
        r14.write(r11.getBytes());     // Catch: Throwable -> L10
        r14.flush();     // Catch: Throwable -> L10
        FileSystemUtils.close(r14);
        return;
    L10:
        th = th;
        r13 = r14;
    L13:
        FileSystemUtils.close(r13);
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static void writeFile(@NonNull File r10, @NonNull JSONArray r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        r10.getParentFile().mkdirs();
        BufferedWriter r13 = null;
        BufferedWriter r14 = new BufferedWriter(new FileWriter(r10, r12));     // Catch: Throwable -> L11
        JSONWriter.writeTo(r11, r14);     // Catch: Throwable -> L8
        FileSystemUtils.close(r14);
        return;
    L8:
        r13 = r14;
    L9:
        FileSystemUtils.close(r13);
    }

    public static void writeFile(@NonNull File r10, @NonNull JSONObject r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        r10.getParentFile().mkdirs();
        BufferedWriter r13 = null;
        BufferedWriter r14 = new BufferedWriter(new FileWriter(r10, r12));     // Catch: Throwable -> L11
        JSONWriter.writeTo(r11, r14);     // Catch: Throwable -> L8
        FileSystemUtils.close(r14);
        return;
    L8:
        r13 = r14;
    L9:
        FileSystemUtils.close(r13);
    }

    @Nullable
    public static void writePropertiesFile(File r10, Map<String, String> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L34;
        FileOutputStream r12 = null;
        Properties r13 = new Properties();     // Catch: Throwable -> L18 IOException -> L20
        FileOutputStream r14 = new FileOutputStream(r10);     // Catch: Throwable -> L18 IOException -> L20
        Iterator<Map.Entry<String, String>> r15 = r11.entrySet().iterator();     // Catch: Throwable -> L14 IOException -> L16
    L10:
        if (r15.hasNext() == false) goto L12;
        Map.Entry<String, String> r16 = r15.next();     // Catch: Throwable -> L14 IOException -> L16
        r13.setProperty(r16.getKey(), r16.getValue());     // Catch: Throwable -> L14 IOException -> L16
        goto L10
    L12:
        r13.store(r14, "no");     // Catch: Throwable -> L14 IOException -> L16
        FileSystemUtils.close(r14);
        return;
    L16:
        e = e;
        r12 = r14;
    L21:
        NpthLog.w(e);     // Catch: Throwable -> L18
        FileSystemUtils.close(r12);
        return;
    L14:
        th = th;
        r12 = r14;
    L24:
        FileSystemUtils.close(r12);
        throw th;
    L20:
        e = e;
    L18:
        th = th;
        goto L24
    }

    public static void zip(OutputStream r10, @NonNull List<File> r11) {
        if (r11.size() == 0) goto L17;
        ZipOutputStream r12 = null;
        ZipOutputStream r13 = new ZipOutputStream(r10);     // Catch: Throwable -> L14
        r13.putNextEntry(new ZipEntry("/"));     // Catch: Throwable -> L12
        Iterator<File> r14 = r11.iterator();     // Catch: Throwable -> L12
    L8:
        if (r14.hasNext() == false) goto L11;
        zip(r13, r14.next(), true);     // Catch: Throwable -> L12
        goto L8
    L11:
        FileSystemUtils.close(r13);
        return;
    L12:
        th = th;
        r12 = r13;
    L15:
        FileSystemUtils.close(r12);
        throw th;
    L14:
        th = th;
        goto L15
    }

    private static void zip(String r10, File r11) {
        ZipOutputStream r12 = null;
        new File(r10).getParentFile().mkdirs();     // Catch: Throwable -> L9
        ZipOutputStream r13 = new ZipOutputStream(new FileOutputStream(r10));     // Catch: Throwable -> L9
        zip(r13, r11, "");     // Catch: Throwable -> L7
        FileSystemUtils.close(r13);
        return;
    L7:
        th = th;
        r12 = r13;
    L10:
        FileSystemUtils.close(r12);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static void zip(String r10, String r11) {
        zip(r11, new File(r10));
    }

    private static void zip(ZipOutputStream r10, File r11, String r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.exists() == false) goto L42;
        int r13 = 0;
        if (r11.isDirectory() == false) goto L18;
        File[] r14 = r11.listFiles();
        if (r14 != null) goto L11;
        return;
    L11:
        r10.putNextEntry(new ZipEntry(r12 + "/"));
        if (r12.length() != 0) goto L14;
        String r15 = "";
    L15:
        int r16 = r14.length;
    L16:
        if (r13 >= r16) goto L41;
        File r17 = r14[r13];
        zip(r10, r17, r15 + r17.getName());
        r13 = r13 + 1;
        goto L16
    L41:
        return;
    L14:
        r15 = r12 + "/";
        goto L15
    L18:
        r10.putNextEntry(new ZipEntry(r12));
        FileInputStream r18 = null;
        FileInputStream r19 = new FileInputStream(r11);     // Catch: Throwable -> L30
        byte[] r20 = new byte[4096];     // Catch: Throwable -> L28
    L22:
        int r21 = r19.read(r20);     // Catch: Throwable -> L28
        if ((-1) == r21) goto L26;
        r10.write(r20, 0, r21);     // Catch: Throwable -> L28
        goto L22
    L26:
        FileSystemUtils.close(r19);
        return;
    L28:
        th = th;
        r18 = r19;
    L31:
        FileSystemUtils.close(r18);
        throw th;
    L30:
        th = th;
        goto L31
    }

    private static void zip(ZipOutputStream r10, File r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.exists() == false) goto L22;
        if (r12 == false) goto L8;
    L11:
        int r13 = 0;
        if (r11.isDirectory() == false) goto L14;
        File[] r14 = r11.listFiles();
    L15:
        if (r14 != null) goto L17;
        return;
    L17:
        int r15 = r14.length;
    L18:
        if (r13 >= r15) goto L23;
        File r16 = r14[r13];
        zip(r10, r16, r16.getName());
        r13 = r13 + 1;
        goto L18
    L23:
        return;
    L14:
        r14 = new File[]{r11};
        goto L15
    L8:
        if (r11.isDirectory() == false) goto L11;
        zip(r10, r11, r11.getName());
        return;
    }
}
