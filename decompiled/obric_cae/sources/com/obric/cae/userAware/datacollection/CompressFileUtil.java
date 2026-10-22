package com.obric.cae.userAware.datacollection;

import android.aimedia.a;
import com.obric.cae.log.CaeLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class CompressFileUtil {
    private static final long MAX_ZIP_FILE_SIZE_BYTES = 52428800;
    public static final String STAGE_COMPRESSING = "Compressing";
    public static final String STAGE_DELETING_ORIGINAL = "Deleting Original";
    public static final String STAGE_FINISHED_FOLDER_PROCESSING = "Folder Processed";
    public static final String STAGE_PREPARING = "Preparing";
    private static final String TAG = "CompressFileUtil";

    public interface CompressionProgressListener {
        boolean isCancelled();

        void onProgress(int r8, int r10, String r11, String r12);
    }

    public static class FileEntryInfo {
        File file;
        String zipEntryPath;

        public FileEntryInfo(File r8, String r10) {
            this.file = r8;
            this.zipEntryPath = r10;
        }
    }

    public CompressFileUtil() {
    }

    private static void collectFilesRecursive(File r8, String r10, List<FileEntryInfo> r11) {
        String r12 = r8.getName();
        if (r10.isEmpty() == true) goto L6;
        r12 = a.i(a.j(r10), File.separator, r12);
    L6:
        String r13 = r12.replace(File.separatorChar, '/');
        if (r8.isDirectory() == true) goto L9;
        r11.add(new FileEntryInfo(r8, r13));
        return;
    L9:
        if (r13.endsWith("/") == false) goto L11;
        String r14 = r13;
    L12:
        r11.add(new FileEntryInfo(r8, r14));
        File[] r15 = r8.listFiles();
        if (r15 == null) goto L20;
        int r16 = r15.length;
        int r17 = 0;
    L15:
        if (r17 >= r16) goto L21;
        collectFilesRecursive(r15[r17], r13, r11);
        r17 = r17 + 1;
        goto L15
    L21:
        return;
    L20:
        return;
    L11:
        r14 = r13.concat("/");
        goto L12
    }

    private static boolean compressSingleDirectory(File r23, String r24, File r25, CompressionProgressListener r26) {
        String r8 = "/";
        int r10 = 0;
        boolean r11 = false;
        if (r26 != null) goto L5;
    L7:
        ArrayList r12 = new ArrayList();
        File[] r13 = r23.listFiles();
        if (r13 == null) goto L17;
        int r14 = r13.length;
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L17;
        File r16 = r13[r15];
        if (r26 == null) goto L16;
        if (r26.isCancelled() == false) goto L16;
        return false;
    L16:
        collectFilesRecursive(r16, "", r12);
        r15 = r15 + 1;
    L17:
        int r17 = 1;
        if (r12.isEmpty() == false) goto L21;
        CaeLog.i(TAG, "Directory " + r23.getName() + " is empty. No zip will be created.");
        return true;
    L21:
        boolean r18 = false;
    L23:
        if (r10 >= r12.size()) goto L190;
        if (r26 != null) goto L27;
    L31:
        StringBuilder r19 = new StringBuilder();
        r19.append(r23.getName());
        r19.append("_");
        r19.append(r24);
        r19.append("-part");
        File r20 = new File(r25, a.h(r19, r17, ".zip"));
        FileOutputStream r21 = new FileOutputStream(r20);     // Catch: IOException -> L183
        ZipOutputStream r110 = new ZipOutputStream(r21);     // Catch: Throwable -> L172
        long r111 = 0;
        boolean r112 = r18;
    L223:
    L162:
        th = th;
    L163:
        Throwable r22 = th;
        r110.close();     // Catch: Throwable -> L166
    L245:
        throw r22;     // Catch: Throwable -> L170
    L166:
        th = move-exception;
        r22.addSuppressed(th);     // Catch: Throwable -> L170
        throw r22;     // Catch: Throwable -> L170
    L170:
        th = th;
        boolean r27 = r112;
    L174:
        boolean r28 = r27;
        Throwable r29 = th;
        r21.close();     // Catch: Throwable -> L177
    L246:
        throw r29;     // Catch: IOException -> L181
    L181:
        e = e;
        boolean r30 = r28;
    L185:
        String r31 = TAG;
        CaeLog.e(r31, "Error creating zip part " + r20.getName() + ": " + e.getMessage(), e);
        if (r20.exists() == true) goto L188;
        return r30;
    L188:
        if (r20.delete() == true) goto L248;
        CaeLog.w(r31, "Failed to delete partially created zip file on error: " + r20.getAbsolutePath());
        return r30;
    L248:
        return r30;
    L177:
        th = move-exception;
        r29.addSuppressed(th);     // Catch: IOException -> L181
        throw r29;     // Catch: IOException -> L181
    L36:
        if (r10 >= r12.size()) goto L148;
        if (r26 != null) goto L39;
    L52:
        FileEntryInfo r113 = (FileEntryInfo) r12.get(r10);     // Catch: Throwable -> L162
        File r114 = r113.file;     // Catch: Throwable -> L162
        String r115 = r113.zipEntryPath;     // Catch: Throwable -> L162
        if (r114.isDirectory() == false) goto L55;
        long r116 = 0;
    L57:
        if (r18 == false) goto L64;
        if ((r111 + r116) <= MAX_ZIP_FILE_SIZE_BYTES) goto L64;
        if (r116 < MAX_ZIP_FILE_SIZE_BYTES) goto L148;
    L64:
        if (r114.isDirectory() == false) goto L71;
        if (r115.endsWith(r8) == true) goto L69;
        r115 = r115 + r8;     // Catch: Throwable -> L162
    L69:
        r110.putNextEntry(new ZipEntry(r115));     // Catch: Throwable -> L162
        r110.closeEntry();     // Catch: Throwable -> L162
        String r210 = r8;
        ArrayList r211 = r12;
    L131:
        r18 = true;
        if (r20.length() <= MAX_ZIP_FILE_SIZE_BYTES) goto L134;
    L149:
        r110.finish();     // Catch: Throwable -> L162
        if (r18 == false) goto L153;
        r17 = r17 + 1;     // Catch: Throwable -> L162
    L204:
        r110.close();     // Catch: Throwable -> L170
        r21.close();     // Catch: IOException -> L160
        r18 = r112;
        r8 = r210;
        r12 = r211;
    L160:
        e = e;
        r30 = r112;
        goto L185
    L153:
        if (r20.exists() == false) goto L204;
        if (r20.delete() == true) goto L204;
        CaeLog.w(TAG, "Failed to delete empty zip part: " + r20.getAbsolutePath());     // Catch: Throwable -> L162
    L134:
        r10 = r10 + 1;
        r8 = r210;
        r12 = r211;
        goto L223
    L71:
        if (r114.exists() == true) goto L77;
        String r117 = TAG;     // Catch: Throwable -> L162
        r210 = r8;
        StringBuilder r32 = new StringBuilder();     // Catch: Throwable -> L162
        r32.append("File not found, skipping: ");     // Catch: Throwable -> L75
        r32.append(r114.getAbsolutePath());     // Catch: Throwable -> L75
        CaeLog.w(r117, r32.toString());     // Catch: Throwable -> L75
        r112 = false;
        r211 = r12;
    L75:
        th = th;
        r112 = false;
        goto L163
    L77:
        r210 = r8;
        r110.putNextEntry(new ZipEntry(r115));     // Catch: Throwable -> L146
        FileInputStream r118 = new FileInputStream(r114);     // Catch: Throwable -> L146
        byte[] r33 = new byte[8192];     // Catch: Throwable -> L135
    L81:
        int r119 = r118.read(r33);     // Catch: Throwable -> L135
        if (r119 <= 0) goto L107;
        if (r26 != null) goto L212;
    L102:
        ArrayList r212 = r12;
        r110.write(r33, 0, r119);     // Catch: Throwable -> L105
        r12 = r212;
    L105:
        th = th;
        boolean r34 = false;
    L137:
        boolean r35 = r34;
        Throwable r36 = th;
        r118.close();     // Catch: Throwable -> L140
    L244:
        throw r36;     // Catch: Throwable -> L144
    L140:
        th = move-exception;
        r36.addSuppressed(th);     // Catch: Throwable -> L144
        throw r36;     // Catch: Throwable -> L144
    L144:
        th = th;
        r112 = r35;
        goto L163
    L212:
    L100:
        th = th;
    L101:
        r34 = false;
        goto L137
    L85:
        if (r26.isCancelled() == false) goto L102;
        r118.close();     // Catch: Throwable -> L100
        r110.closeEntry();     // Catch: Throwable -> L100
        r110.close();     // Catch: Throwable -> L100
        if (r20.exists() == false) goto L90;
        if (r18 == true) goto L90;
        r20.delete();     // Catch: Throwable -> L100
    L90:
        r118.close();     // Catch: Throwable -> L75
        r110.close();     // Catch: Throwable -> L97
        r21.close();     // Catch: IOException -> L95
        return false;
    L97:
        th = th;
    L98:
        r27 = false;
        goto L174
    L107:
        r211 = r12;
        r118.close();     // Catch: Throwable -> L146
        r110.closeEntry();     // Catch: Throwable -> L146
        r111 = r111 + r116;     // Catch: Throwable -> L146
        if (r26 != null) goto L111;
    L120:
        r112 = false;
        if (r114.exists() == true) goto L124;
        String r37 = TAG;     // Catch: Throwable -> L162
        StringBuilder r38 = new StringBuilder();     // Catch: Throwable -> L162
        r38.append("File already deleted, skipping deletion: ");     // Catch: Throwable -> L162
        r38.append(r114.getAbsolutePath());     // Catch: Throwable -> L162
    L129:
        CaeLog.w(r37, r38.toString());     // Catch: Throwable -> L162
        goto L131
    L124:
        if (r114.delete() == true) goto L127;
        r37 = TAG;     // Catch: Throwable -> L162
        r38 = new StringBuilder();     // Catch: Throwable -> L162
        r38.append("Failed to delete original file after zipping: ");     // Catch: Throwable -> L162
        r38.append(r114.getAbsolutePath());     // Catch: Throwable -> L162
        goto L129
    L127:
        CaeLog.d(TAG, "Successfully deleted original file after zipping: " + r114.getAbsolutePath());     // Catch: Throwable -> L162
        goto L131
    L111:
        if (r26.isCancelled() == false) goto L120;
        CaeLog.i(TAG, "Cancelled before deleting file: " + r114.getName());     // Catch: Throwable -> L146
        r110.close();     // Catch: Throwable -> L118
        r21.close();     // Catch: IOException -> L95
        return false;
    L118:
        th = th;
    L95:
        e = e;
        r30 = false;
    L135:
        th = th;
    L146:
        th = th;
        r112 = false;
        goto L163
    L55:
        r116 = r114.length();     // Catch: Throwable -> L162
        goto L57
    L39:
        if (r26.isCancelled() == false) goto L52;
        r110.close();     // Catch: Throwable -> L162
        if (r20.exists() == false) goto L44;
        if (r18 == true) goto L44;
        r20.delete();     // Catch: Throwable -> L162
    L44:
        CaeLog.i(TAG, "Compression of " + r23.getName() + " cancelled mid-part.");     // Catch: Throwable -> L162
        r110.close();     // Catch: Throwable -> L50
        r21.close();     // Catch: IOException -> L48
        return r112;
    L48:
        e = e;
        r18 = r112;
    L184:
        r30 = r18;
    L50:
        th = th;
        r18 = r112;
    L173:
        r27 = r18;
    L148:
        r210 = r8;
        r211 = r12;
    L172:
        th = th;
    L183:
        e = e;
        goto L184
    L27:
        if (r26.isCancelled() == false) goto L31;
        String r39 = TAG;
        StringBuilder r40 = new StringBuilder("Compression of ");
        r40.append(r23.getName());
        boolean r213 = r18;
        String r41 = " cancelled before starting new part.";
        r11 = r213;
    L29:
        a.r(r40, r41, r39);
        return r11;
    L190:
        return true;
    L5:
        if (r26.isCancelled() == false) goto L7;
        r39 = TAG;
        r40 = new StringBuilder("compressSingleDirectory cancelled at start for: ");
        r41 = r23.getName();
        goto L29
    }

    public static void compressSubfoldersInDirectory(File r10, String r11, CompressionProgressListener r12) {
        if (r10 != null) goto L4;
    L78:
        String r13 = TAG;
        StringBuilder r14 = new StringBuilder("Invalid main directory for compression: ");
        if (r10 == null) goto L81;
        String r15 = r10.getAbsolutePath();
    L82:
        r14.append(r15);
        CaeLog.e(r13, r14.toString());
        return;
    L81:
        r15 = "null";
        goto L82
    L4:
        if (r10.isDirectory() == false) goto L78;
        if (r10.exists() == false) goto L78;
        if (r11 != null) goto L10;
    L76:
        CaeLog.e(TAG, "Device ID cannot be null or empty for compression.");
        return;
    L10:
        if (r11.isEmpty() == true) goto L76;
        File[] r8 = r10.listFiles();
        int r16 = 0;
        if (r8 != null) goto L18;
        CaeLog.w(TAG, "Cannot list files in main directory: " + r10.getAbsolutePath());
        if (r12 == null) goto L103;
        r12.onProgress(0, 0, "Error listing files", "Error");
        return;
    L103:
        return;
    L18:
        ArrayList r17 = new ArrayList();
        int r18 = r8.length;
        int r19 = 0;
    L19:
        if (r19 >= r18) goto L30;
        File r20 = r8[r19];
        if (r20.isDirectory() == false) goto L28;
        File[] r21 = r20.listFiles();
        if (r21 != null) goto L25;
    L27:
        CaeLog.d(TAG, "Skipping empty subfolder: " + r20.getName());
        goto L28
    L25:
        if (r21.length <= 0) goto L27;
        r17.add(r20);
    L28:
        r19 = r19 + 1;
        goto L19
    L30:
        if (r17.isEmpty() == false) goto L35;
        CaeLog.i(TAG, "No non-empty subfolders to compress in " + r10.getName());
        if (r12 == null) goto L104;
        r12.onProgress(0, 0, "", "No Folders");
        return;
    L104:
        return;
    L35:
        int r22 = r17.size();
        if (r12 == null) goto L38;
        r12.onProgress(0, r22, "", STAGE_PREPARING);
    L38:
        Iterator r23 = r17.iterator();
    L40:
        if (r23.hasNext() == false) goto L72;
        File r24 = (File) r23.next();
        if (r12 != null) goto L44;
    L47:
        String r25 = TAG;
        CaeLog.d(r25, "Processing subfolder: " + r24.getName());
        if (r12 == null) goto L51;
        r12.onProgress(r16, r22, r24.getName(), STAGE_COMPRESSING);
    L51:
        if (compressSingleDirectory(r24, r11, r10, r12) == true) goto L52;
        CaeLog.e(r25, "Failed to compress subfolder: " + r24.getName() + ". Original will not be deleted.");
        if (r12 == null) goto L40;
        String r26 = r24.getName();
        String r27 = "Compression Failed";
    L65:
        r12.onProgress(r16, r22, r26, r27);
        goto L40
    L52:
        if (r12 != null) goto L54;
    L57:
        CaeLog.d(r25, "Compression successful for " + r24.getName() + ". Attempting to delete original.");
        if (r12 == null) goto L61;
        r12.onProgress(r16, r22, r24.getName(), STAGE_DELETING_ORIGINAL);
    L61:
        if (deleteDirectoryRecursively(r24, r12) == true) goto L62;
        CaeLog.e(r25, "Failed to delete original subfolder: " + r24.getAbsolutePath() + " after successful compression.");
        r16 = r16 + 1;
        if (r12 == null) goto L40;
        r26 = r24.getName();
        r27 = "Folder Processed (Delete Failed)";
        goto L65
    L62:
        CaeLog.i(r25, "Successfully deleted original subfolder: " + r24.getAbsolutePath());
        r16 = r16 + 1;
        if (r12 == null) goto L40;
        r26 = r24.getName();
        r27 = STAGE_FINISHED_FOLDER_PROCESSING;
        goto L65
    L54:
        if (r12.isCancelled() == false) goto L57;
        CaeLog.i(r25, "Cancelled before deleting original folder: " + r24.getName());
        return;
    L44:
        if (r12.isCancelled() == false) goto L47;
        CaeLog.i(TAG, "Compression process cancelled by listener.");
        return;
    L72:
        CaeLog.i(TAG, "Finished compression. Successfully processed " + r16 + "/" + r22 + " subfolders.");
        if (r12 == null) goto L105;
        r12.onProgress(r16, r22, "", "All Folders Processed");
        return;
    }

    private static boolean deleteDirectoryRecursively(File r8, CompressionProgressListener r10) {
        if (r10 != null) goto L5;
    L8:
        File[] r11 = r8.listFiles();
        if (r11 == null) goto L28;
        int r12 = r11.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L28;
        File r14 = r11[r13];
        if (r10 == null) goto L18;
        if (r10.isCancelled() == false) goto L18;
        return false;
    L18:
        if (r14.isDirectory() == false) goto L23;
        if (deleteDirectoryRecursively(r14, r10) == true) goto L26;
        return false;
    L26:
        r13 = r13 + 1;
        goto L11
    L23:
        if (r14.delete() == true) goto L26;
        CaeLog.w(TAG, "Failed to delete file: " + r14.getAbsolutePath());
        return false;
    L28:
        return r8.delete();
    L5:
        if (r10.isCancelled() == false) goto L8;
        CaeLog.i(TAG, "deleteDirectoryRecursively cancelled at start for: " + r8.getName());
        return false;
    }
}
