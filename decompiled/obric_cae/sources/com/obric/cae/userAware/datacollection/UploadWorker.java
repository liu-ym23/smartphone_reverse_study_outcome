package com.obric.cae.userAware.datacollection;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.e;
import androidx.work.l;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import m0.a;

/* JADX INFO: loaded from: classes2.dex */
public class UploadWorker extends Worker {
    private static final long BYTES_IN_MB = 1048576;
    public static final String KEY_PROGRESS_COMPRESSION_COMPLETED_FOLDERS = "compression_completed_folders";
    public static final String KEY_PROGRESS_COMPRESSION_CURRENT_FOLDER_NAME = "compression_current_folder_name";
    public static final String KEY_PROGRESS_COMPRESSION_PERCENTAGE = "compression_percentage";
    public static final String KEY_PROGRESS_COMPRESSION_STAGE = "compression_stage";
    public static final String KEY_PROGRESS_COMPRESSION_TOTAL_FOLDERS = "compression_total_folders";
    public static final String KEY_PROGRESS_CURRENT_FILE_PERCENTAGE = "current_file_percentage_by_size";
    public static final String KEY_PROGRESS_DATA_TYPE = "type";
    public static final String KEY_PROGRESS_DATA_TYPE_COMPRESSION = "compression_progress";
    public static final String KEY_PROGRESS_DATA_TYPE_CURRENT_FILE = "current_file";
    public static final String KEY_PROGRESS_DATA_TYPE_OVERALL = "overall";
    public static final String KEY_PROGRESS_FILE_NAME = "file_name";
    public static final String KEY_PROGRESS_PERCENTAGE_BY_SIZE = "percentage_by_size";
    public static final String KEY_PROGRESS_TOTAL_FILE_COUNT_TO_UPLOAD = "total_bytes_to_upload";
    public static final String KEY_PROGRESS_UPLOADED_FILE_COUNT = "uploaded_bytes";
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 10000;
    private static final String TAG = "UploadWorker";
    private static final String UPLOAD_PARAM_AK = "cell";
    private static final String UPLOAD_PARAM_SK = "41788027ea42af8c9ed12b770d31bd55";
    private static final String mUploadUrl = "https://os.oceancloudapi.com/cloud/os/api/cell/collect/upload?user_id=";
    private final CompressFileUtil.CompressionProgressListener compressionProgressListener;
    private final NetworkClient.UploadProgressListener fileProgressListener;
    private final Context mContext;
    private final String mDeviceId;
    private final String mDirectoryPath;
    private NetworkClient mNetworkClient;

    public UploadWorker(Context r8, WorkerParameters r10) {
        super(r8, r10);
        this.compressionProgressListener = new AnonymousClass1(this);
        this.fileProgressListener = new a(this);
        this.mDirectoryPath = r10.f2779b.d("DirectoryPath");
        this.mDeviceId = r10.f2779b.d("DeviceId");
        this.mContext = r8;
        this.mNetworkClient = new NetworkClient(generateUploadUrl());
    }

    public static /* synthetic */ void a(UploadWorker r8, String r10, long r11, long r12) {
        r8.lambda$new$0(r10, r11, r12);
    }

    public static /* synthetic */ void access$000(UploadWorker r8, int r10, int r11, String r12, String r13) {
        r8.sendCompressionProgress(r10, r11, r12, r13);
    }

    private boolean attemptUploadWithRetry(File r8, NetworkClient.UploadProgressListener r10) {
        if (isStopped() == false) goto L5;
        return false;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= 3) goto L20;
        if (r11 <= 0) goto L11;
        CaeLog.d(TAG, "Retrying upload for " + r8.getName() + ", attempt " + (r11 + 1));     // Catch: InterruptedException -> L17
        Thread.sleep(10000);     // Catch: InterruptedException -> L17
    L17:
        e = move-exception;
        CaeLog.w(TAG, "Upload retry sleep interrupted for file " + r8.getName() + ": " + e.getMessage());
        Thread.currentThread().interrupt();
        return false;
    L11:
        if (isStopped() == true) goto L16;
        if (this.mNetworkClient.uploadFile(r8, getFileMediaType(r8), r10) == false) goto L16;
        return true;
    L16:
        r11 = r11 + 1;
        goto L7
    L20:
        CaeLog.e(TAG, "Failed to upload file after 3 attempts: " + r8.getName());
        return false;
    }

    private String generateSignature(String r8, String r10, String r11, String r12) {
        byte[] r13 = MessageDigest.getInstance("MD5").digest((r8 + r10 + r11 + r12).getBytes());     // Catch: NoSuchAlgorithmException -> L10
        StringBuilder r14 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L10
        int r15 = r13.length;     // Catch: NoSuchAlgorithmException -> L10
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L8;
        String r17 = Integer.toHexString(r13[r16] & 255);     // Catch: NoSuchAlgorithmException -> L10
        if (r17.length() != 1) goto L7;
        r14.append('0');     // Catch: NoSuchAlgorithmException -> L10
    L7:
        r14.append(r17);     // Catch: NoSuchAlgorithmException -> L10
        r16 = r16 + 1;     // Catch: NoSuchAlgorithmException -> L10
        goto L3
    L8:
        return r14.toString();
    L10:
        e = move-exception;
        throw new RuntimeException("The MD5 algorithm is not available", e);
    }

    private String generateUploadUrl() {
        String r8 = String.valueOf(System.currentTimeMillis() / 1000);
        return mUploadUrl + this.mDeviceId + "&ak=cell&ts=" + r8 + "&sign=" + generateSignature("cell", UPLOAD_PARAM_SK, r8, this.mDeviceId);
    }

    private String getFileMediaType(File r8) {
        if (r8 != null) goto L5;
        return NetworkClient.UPLOAD_FILE_TYPE_JSON;
    L5:
        if (r8.isFile() == false) goto L28;
        String r10 = r8.getName().toLowerCase();
        if (r10.endsWith(".aac") == false) goto L12;
        return NetworkClient.UPLOAD_FILE_TYPE_AAC;
    L12:
        if (r10.endsWith(".json") == false) goto L15;
        return NetworkClient.UPLOAD_FILE_TYPE_JSON;
    L15:
        if (r10.endsWith(".txt") == false) goto L17;
    L25:
        return NetworkClient.UPLOAD_FILE_TYPE_TEXT;
    L17:
        if (r10.endsWith(".log") == true) goto L25;
        if (r10.endsWith(".zip") == false) goto L23;
        return NetworkClient.UPLOAD_FILE_TYPE_ZIP;
    L23:
        CaeLog.w(TAG, "Unknown file extension for: " + r10 + ". Using application/json");
        return NetworkClient.UPLOAD_FILE_TYPE_JSON;
    L28:
        return NetworkClient.UPLOAD_FILE_TYPE_JSON;
    }

    private l.a handleFileLockConflict() {
        Set<String> r8 = getTags();
        if (r8.contains("FileController_periodic") == false) goto L7;
        CaeLog.i(TAG, "Periodic task detected, skipping upload due to active worker");
        return new l.a.c();
    L7:
        if (r8.contains("FileController_one_time") == false) goto L10;
        CaeLog.w(TAG, "One-time task detected file lock conflict, returning failure to avoid infinite retry");
        return new l.a.C0025a();
    L10:
        CaeLog.w(TAG, "Unknown task type with file lock conflict, returning retry");
        return new l.a.b();
    }

    private /* synthetic */ void lambda$new$0(String r8, long r10, long r11) {
        if (r11 <= 0) goto L5;
        double r12 = (r10 * 100.0d) / r11;
    L6:
        sendCurrentFileProgress(r8, r12);
        return;
    L5:
        r12 = 0.0d;
        goto L6
    }

    private void releaseFileLock(FileLock r8, FileOutputStream r10, File r11) {
        if (r8 != null) goto L20;
    L7:
        if (r10 != null) goto L22;
    L12:
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.exists() == true) goto L16;
        return;
    L16:
        if (r11.delete() == false) goto L18;
        CaeLog.d(TAG, "Deleted lock file");
        return;
    L18:
        CaeLog.w(TAG, "Failed to delete lock file");
        return;
    L22:
        r10.close();     // Catch: IOException -> L10
    L10:
        e = move-exception;
        CaeLog.e(TAG, "Failed to close lock stream: " + e.getMessage());
        goto L12
    L20:
        r8.release();     // Catch: IOException -> L5
        CaeLog.d(TAG, "Released file lock");     // Catch: IOException -> L5
    L5:
        e = move-exception;
        CaeLog.e(TAG, "Failed to release file lock: " + e.getMessage());
        goto L7
    }

    private void sendCompressionProgress(int r8, int r10, String r11, String r12) {
        if (isStopped() == false) goto L5;
        return;
    L5:
        if (r10 <= 0) goto L7;
        double r13 = (((double) r8) * 100.0d) / ((double) r10);
    L8:
        e.a r14 = new e.a();
        HashMap r15 = r14.f2825a;
        r15.put(KEY_PROGRESS_COMPRESSION_COMPLETED_FOLDERS, Integer.valueOf(r8));
        r15.put(KEY_PROGRESS_COMPRESSION_TOTAL_FOLDERS, Integer.valueOf(r10));
        r15.put(KEY_PROGRESS_COMPRESSION_PERCENTAGE, Double.valueOf(r13));
        r14.c(KEY_PROGRESS_COMPRESSION_CURRENT_FOLDER_NAME, r11);
        r14.c(KEY_PROGRESS_COMPRESSION_STAGE, r12);
        r14.c("type", KEY_PROGRESS_DATA_TYPE_COMPRESSION);
        setProgressAsync(r14.a());
        CaeLog.d(TAG, String.format(Locale.getDefault(), "Compression Progress: Stage: %s, Folder: '%s', %d/%d (%.2f%%)", new Object[]{r12, r11, Integer.valueOf(r8), Integer.valueOf(r10), Double.valueOf(r13)}));
        return;
    L7:
        r13 = 0.0d;
        goto L8
    }

    private void sendCurrentFileProgress(String r8, double r10) {
        if (isStopped() == false) goto L5;
        return;
    L5:
        e.a r11 = new e.a();
        r11.c(KEY_PROGRESS_FILE_NAME, r8);
        r11.f2825a.put(KEY_PROGRESS_CURRENT_FILE_PERCENTAGE, Double.valueOf(r10));
        r11.c("type", KEY_PROGRESS_DATA_TYPE_CURRENT_FILE);
        setProgressAsync(r11.a());
    }

    private void sendOverallByteProgress(double r8, double r10, int r11, int r12) {
        if (isStopped() == false) goto L5;
        return;
    L5:
        double r13 = 0.0d;
        if (r10 <= 0.0d) goto L8;
        r13 = (r8 * 100.0d) / r10;
    L8:
        e.a r14 = new e.a();
        HashMap r15 = r14.f2825a;
        r15.put(KEY_PROGRESS_UPLOADED_FILE_COUNT, Long.valueOf(r11));
        r15.put(KEY_PROGRESS_TOTAL_FILE_COUNT_TO_UPLOAD, Long.valueOf(r12));
        r15.put(KEY_PROGRESS_PERCENTAGE_BY_SIZE, Double.valueOf(r13));
        r14.c("type", KEY_PROGRESS_DATA_TYPE_OVERALL);
        setProgressAsync(r14.a());
        CaeLog.d(TAG, String.format(Locale.getDefault(), "Progress Update: %d/%d files (%.2f%%)", new Object[]{Integer.valueOf(r11), Integer.valueOf(r12), Double.valueOf(r13)}));
    }

    @Override // androidx.work.Worker
    public l.a doWork() {
        String r8 = TAG;
        CaeLog.i(r8, "=== UploadWorker.doWork() Started ===");
        File r10 = new File(this.mDirectoryPath, ".upload_lock");
        FileOutputStream r11 = new FileOutputStream(r10);     // Catch: IOException -> L52
        FileLock r12 = r11.getChannel().tryLock();     // Catch: OverlappingFileLockException -> L48 IOException -> L52
        if (r12 != null) goto L8;
        CaeLog.w(r8, "Another upload worker is already processing directory: " + this.mDirectoryPath);     // Catch: IOException -> L52
        return handleFileLockConflict();
    L8:
        CaeLog.i(r8, "Acquired file lock for upload directory: " + this.mDirectoryPath);     // Catch: IOException -> L52
        File r13 = new File(this.mDirectoryPath);     // Catch: Throwable -> L45
        if (r13.exists() == true) goto L15;
        CaeLog.e(r8, "Directory does not exist: " + this.mDirectoryPath);     // Catch: Throwable -> L45
        l.a r14 = new l.a.C0025a();     // Catch: Throwable -> L45
    L13:
        releaseFileLock(r12, r11, r10);
        CaeLog.isUploading.set(false);
        return r14;
    L15:
        CaeLog.d(r8, "pause Record first");     // Catch: Throwable -> L45
        CaeLog.isUploading.set(true);     // Catch: Throwable -> L45
        UserAwareManager.getInstance().copyEventLogsToNearbyLogFile(false);     // Catch: Throwable -> L45
        CaeLog.d(r8, "UploadWorker started doing work, Directory exists: " + this.mDirectoryPath);     // Catch: Throwable -> L45
        CaeLog.i(r8, "Starting compression phase...");     // Catch: Throwable -> L45
        CompressFileUtil.compressSubfoldersInDirectory(r13, this.mDeviceId, this.compressionProgressListener);     // Catch: Throwable -> L45
        if (isStopped() == false) goto L18;
        CaeLog.i(r8, "Worker stopped during or after compression phase.");     // Catch: Throwable -> L45
        r14 = new l.a.C0025a();     // Catch: Throwable -> L45
        goto L13
    L18:
        CaeLog.i(r8, "Compression phase completed.");     // Catch: Throwable -> L45
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L45
        UserAwareUtil.findFilesRecursively(r13, r15);     // Catch: Throwable -> L45
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L45
        double r17 = 0.0d;
        double r18 = 0.0d;
    L20:
        if (r16.hasNext() == false) goto L22;
        r18 = r18 + (((File) r16.next()).length() / 1048576.0d);     // Catch: Throwable -> L45
        goto L20
    L22:
        int r19 = r15.size();     // Catch: Throwable -> L45
        String r20 = TAG;     // Catch: Throwable -> L45
        CaeLog.d(r20, "totalMbToUpload: " + r18 + ", totalFilesCount: " + r19 + ", uploadedBytesSoFar: 0.0, filesUploadedCount: 0");     // Catch: Throwable -> L45
        double r21 = r18;
        int r22 = r19;
        sendOverallByteProgress(0.0d, r18, 0, r22);     // Catch: Throwable -> L45
        if (r22 != 0) goto L25;
        CaeLog.i(r20, "No files matching device ID to upload.");     // Catch: Throwable -> L45
        r14 = new l.a.c();     // Catch: Throwable -> L45
        goto L13
    L25:
        CaeLog.i(r20, "Attempting to upload " + r22 + " files, total size: 0.0 Mb.");     // Catch: Throwable -> L45
        if (isStopped() == false) goto L28;
    L43:
        CaeLog.i(r20, "WiFi is not connected or not validated, skipping upload ");     // Catch: Throwable -> L45
        this.mNetworkClient = null;     // Catch: Throwable -> L45
        r14 = new l.a.C0025a();     // Catch: Throwable -> L45
        goto L13
    L28:
        if (UserAwareUtil.isWifiConnectedAndValidated(this.mContext) == false) goto L43;
        Iterator r23 = r15.iterator();     // Catch: Throwable -> L45
        int r24 = 0;
        boolean r110 = false;
    L31:
        if (r23.hasNext() == false) goto L39;
        File r25 = (File) r23.next();     // Catch: Throwable -> L45
        String r26 = TAG;     // Catch: Throwable -> L45
        CaeLog.d(r26, "Attempting to upload file: " + r25.getName() + " (" + r25.length() + " bytes)");     // Catch: Throwable -> L45
        if (isStopped() == false) goto L35;
    L37:
        CaeLog.e(r26, "Failed to upload file after retries: " + r25.getName());     // Catch: Throwable -> L45
        r110 = true;
    L38:
        r22 = r22;
        goto L31
    L35:
        if (attemptUploadWithRetry(r25, this.fileProgressListener) == false) goto L37;
        r17 = r17 + (r25.length() / 1048576.0d);     // Catch: Throwable -> L45
        int r111 = r24 + 1;     // Catch: Throwable -> L45
        sendOverallByteProgress(r17, r21, r111, r22);     // Catch: Throwable -> L45
        UserAwareUtil.handleFileDeletion(r25);     // Catch: Throwable -> L45
        r24 = r111;
        goto L38
    L39:
        UserAwareManager.getInstance().createNearbyInfoFile(this.mContext);     // Catch: Throwable -> L45
        CaeLog.isUploading.set(false);     // Catch: Throwable -> L45
        CaeLog.d(TAG, "UploadWorker finished work, returning success");     // Catch: Throwable -> L45
        if (r110 == false) goto L42;
        r14 = new l.a.C0025a();     // Catch: Throwable -> L45
        goto L13
    L42:
        r14 = new l.a.c();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        releaseFileLock(r12, r11, r10);
        CaeLog.isUploading.set(false);
        throw th;
    L48:
        e = move-exception;
        CaeLog.w(TAG, "Overlapping file lock detected, another worker is active" + e);     // Catch: IOException -> L52
        return handleFileLockConflict();
    L52:
        e = move-exception;
        CaeLog.e(TAG, "Failed to create or lock file: " + e.getMessage());
        return new l.a.b();
    }
}
