package com.ss.android.lark.diskmanage.storage;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.ChainedFileSystem;
import com.ss.android.lark.vfs.FileSystem;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.g;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.DecryptException;
import com.ss.lark.android.encryption.exception.EncryptException;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import ikc.f;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0002()B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/diskmanage/storage/KAFileEncryptFileSystem;", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "onlyDecrypt", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/vfs/FileSystem;Z)V", "TAG", BuildConfig.FLAVOR, "cipherStatus", BuildConfig.FLAVOR, "getName", "isEncryptOn", "isStreamCipherOn", "onInstalled", BuildConfig.FLAVOR, "fms", "Lcom/ss/android/lark/vfs/FileSystemManager;", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "openInput", "Ljava/io/InputStream;", "getReadFile", "Ljava/io/File;", "openOutput", "Ljava/io/OutputStream;", "append", "randomAccessFile", "Ljava/io/RandomAccessFile;", "mode", "afterWriteCompat", "originalFile", "Lcom/ss/android/lark/vfs/VFSFile;", "beforeReadCompat", "size", BuildConfig.FLAVOR, "encryptFile", "decryptFile", "file", "Companion", "KAFileEncryptFileSystemFactory", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KAFileEncryptFileSystem extends ChainedFileSystem {
    public static final a Companion = null;
    public static final WeakHashMap<String, WeakReference<ReentrantLock>> a = null;
    private final String TAG;
    private int cipherStatus;
    private final boolean onlyDecrypt;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/diskmanage/storage/KAFileEncryptFileSystem$KAFileEncryptFileSystemFactory;", "Lcom/ss/android/lark/vfs/FileSystemManager$FileSystemFactory;", "onlyDecrypt", BuildConfig.FLAVOR, "<init>", "(Z)V", "create", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class KAFileEncryptFileSystemFactory extends FileSystemManager.FileSystemFactory {
        private final boolean onlyDecrypt;

        public KAFileEncryptFileSystemFactory() {
            boolean r2 = false;
            this(r2, 1, null);
        }

        public KAFileEncryptFileSystemFactory(boolean r1) {
            this.onlyDecrypt = r1;
        }

        public ChainedFileSystem create(FileSystem r3) {
            Intrinsics.checkNotNullParameter(r3, "delegate");
            return new KAFileEncryptFileSystem(r3, this.onlyDecrypt);
        }

        public /* synthetic */ KAFileEncryptFileSystemFactory(boolean r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1);
        }
    }

    public static final class a {
        public a() {
        }

        public static Lock a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "filePath");
            WeakHashMap r0 = KAFileEncryptFileSystem.access$getFileLockCache$cp();
            monitor-enter(r0);
            WeakReference r1 = (WeakReference) KAFileEncryptFileSystem.access$getFileLockCache$cp().get(r4);     // Catch: Throwable -> L12
            if (r1 == null) goto L7;
            Lock r2 = (Lock) r1.get();     // Catch: Throwable -> L12
        L8:
            if (r2 != null) goto L10;
            r2 = new ReentrantLock();     // Catch: Throwable -> L12
            KAFileEncryptFileSystem.access$getFileLockCache$cp().put(r4, new WeakReference(r2));     // Catch: Throwable -> L12
        L10:
            monitor-exit(r0);
            return r2;
        L7:
            r2 = null;
        L12:
            th = move-exception;
            throw th;
        }
    }

    static {
        Companion = new a();
        a = new WeakHashMap();
    }

    public static final /* synthetic */ WeakHashMap access$getFileLockCache$cp() {
        return a;
    }

    public String getName() {
        return this.TAG;
    }

    public final File a(File r11) {
        Log.i(this.TAG, "start decrypt file: " + r11.getAbsolutePath());
        PolarisFileWrapper r4 = null;
        a r5 = Companion;     // Catch: Throwable -> L13 DecryptException -> L15
        String r6 = r11.getAbsolutePath();     // Catch: Throwable -> L13 DecryptException -> L15
        r5.getClass();     // Catch: Throwable -> L13 DecryptException -> L15
        PolarisFileWrapper r7 = a.a(r6);     // Catch: Throwable -> L13 DecryptException -> L15
        r7.lock();     // Catch: Throwable -> L9 DecryptException -> L11
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L9 DecryptException -> L11
        com.ss.android.lark.storage.monitor.b.a.getClass();     // Catch: Throwable -> L9 DecryptException -> L11
        r4 = CipherManager.e(r11, false);     // Catch: Throwable -> L9 DecryptException -> L11
        Intrinsics.checkNotNullParameter(r11, "file");     // Catch: Throwable -> L9 DecryptException -> L11
        long r9 = System.currentTimeMillis() - r8;     // Catch: Throwable -> L9 DecryptException -> L11
        if (Intrinsics.areEqual(r4.getPath(), r11.getPath()) == true) goto L7;
        Log.i(this.TAG, "decrypt success, cost: " + r9 + ", " + r11.getAbsolutePath() + "\n  -> " + r4.getAbsolutePath());     // Catch: Throwable -> L9 DecryptException -> L11
    L8:
        r7.unlock();
    L21:
        if (r4 != null) goto L24;
        return r11;
    L24:
        return r4;
    L7:
        Log.i(this.TAG, "not encrypt file: " + r11.getAbsolutePath());     // Catch: Throwable -> L9 DecryptException -> L11
    L11:
        e = e;
        r4 = r7;
    L17:
        com.ss.android.lark.storage.monitor.b r10 = com.ss.android.lark.storage.monitor.b.a;     // Catch: Throwable -> L13
        e.getErrorCode();     // Catch: Throwable -> L13
        r10.getClass();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r11, "file");     // Catch: Throwable -> L13
        Log.e(this.TAG, "decrypt fail: " + r11.getAbsolutePath());     // Catch: Throwable -> L13
        if (r4 == null) goto L20;
        r4.unlock();
    L20:
        r4 = null;
    L9:
        th = th;
    L26:
        if (r7 == null) goto L28;
        r7.unlock();
    L28:
        throw th;
    L13:
        th = th;
        r7 = r4;
    L15:
        e = e;
        goto L17
    }

    public File afterWriteCompat(VFSFile r2) {
        Intrinsics.checkNotNullParameter(r2, "originalFile");
        File r3 = super.afterWriteCompat(r2);
        if (this.onlyDecrypt == true) goto L5;
        b(r3);
    L5:
        return r3;
    }

    public final void b(File r14) {
        if (this.onlyDecrypt == true) goto L30;
        int r4 = this.cipherStatus;
        boolean r5 = true;
        if (r4 == 1) goto L9;
        if (r4 == 0) goto L9;
        this.cipherStatus = CipherManager.d();
    L9:
        if (this.cipherStatus == 1) goto L12;
        r5 = false;
    L12:
        if (r5 == false) goto L36;
        Log.i(this.TAG, "start encrypt file: " + r14.getAbsolutePath());
        Lock r6 = null;
        a r7 = Companion;     // Catch: Throwable -> L20 EncryptException -> L22
        String r8 = r14.getAbsolutePath();     // Catch: Throwable -> L20 EncryptException -> L22
        r7.getClass();     // Catch: Throwable -> L20 EncryptException -> L22
        r6 = a.a(r8);     // Catch: Throwable -> L20 EncryptException -> L22
        r6.lock();     // Catch: Throwable -> L20 EncryptException -> L22
        long r9 = r14.lastModified();     // Catch: Throwable -> L20 EncryptException -> L22
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L20 EncryptException -> L22
        com.ss.android.lark.storage.monitor.b.a.getClass();     // Catch: Throwable -> L20 EncryptException -> L22
        CipherManager.c(r14);     // Catch: Throwable -> L20 EncryptException -> L22
        Intrinsics.checkNotNullParameter(r14, "file");     // Catch: Throwable -> L20 EncryptException -> L22
        long r11 = r14.lastModified();     // Catch: Throwable -> L20 EncryptException -> L22
        long r12 = System.currentTimeMillis() - r10;     // Catch: Throwable -> L20 EncryptException -> L22
        if (r9 != r11) goto L18;
        Log.w(this.TAG, "encrypt status is open, but encrypt not worked, may file is encrypt already. " + r14);     // Catch: Throwable -> L20 EncryptException -> L22
    L33:
    L25:
        r6.unlock();
        return;
    L18:
        Log.w(this.TAG, "encrypt file success, cost:" + r12 + ", " + r14);     // Catch: Throwable -> L20 EncryptException -> L22
    L20:
        th = move-exception;
        if (r6 == null) goto L29;
        r6.unlock();
    L29:
        throw th;
    L22:
        e = move-exception;
        com.ss.android.lark.storage.monitor.b r2 = com.ss.android.lark.storage.monitor.b.a;     // Catch: Throwable -> L20
        e.getErrorCode();     // Catch: Throwable -> L20
        r2.getClass();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r14, "file");     // Catch: Throwable -> L20
        Log.e(this.TAG, "encrypt file failed: " + r14, e);     // Catch: Throwable -> L20
        if (r6 != null) goto L25;
        return;
    L36:
        return;
    }

    public File beforeReadCompat(VFSFile r2) {
        Intrinsics.checkNotNullParameter(r2, "originalFile");
        return a(super.beforeReadCompat(r2));
    }

    public File getReadFile(VFSPath r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return a(super.getReadFile(r2));
    }

    public InputStream openInput(VFSPath r4) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Log.i(this.TAG, "openInput: " + r4.getRealPath());
        if (this.onlyDecrypt == true) goto L5;
        f.a.a.b();
    L5:
        VFSFiles r0 = VFSFiles.b;
        VFSPath r1 = r0.t(getReadFile(r4));
        if (Intrinsics.areEqual(r1, r4) == false) goto L9;
        return super.openInput(r4);
    L9:
        return r0.l(r1);
    }

    public long size(VFSPath r3) {
        Intrinsics.checkNotNullParameter(r3, "path");
        return CipherManager.f(super.getReadFile(r3).getAbsolutePath());
    }

    public KAFileEncryptFileSystem(FileSystem r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        super(r2);
        this.onlyDecrypt = r3;
        this.TAG = "KAFileEncryptFileSystem";
        this.cipherStatus = -1;
    }

    public static final /* synthetic */ void access$encryptFile(KAFileEncryptFileSystem r0, File r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ File access$getWriteFile$s17248747(KAFileEncryptFileSystem r0, VFSPath r1) {
        return super.getWriteFile(r1);
    }

    public void onInstalled(FileSystemManager r2, VFSPath r3) {
        Intrinsics.checkNotNullParameter(r2, "fms");
        Intrinsics.checkNotNullParameter(r3, "path");
        super.onInstalled(r2, r3);
    }

    public OutputStream openOutput(final VFSPath r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Log.i(this.TAG, "openOutput: " + r4.getRealPath() + ", append:" + r5);
        if (this.onlyDecrypt == false) goto L7;
        if (r5 == false) goto L10;
        return new PolarisFileOutputStreamWrapper(a(getWriteFile(r4)));
    L10:
        return super.openOutput(r4, r5);
    L7:
        f.a.a.b();
        return new g(super.openOutput(r4, r5), new KAFileEncryptFileSystem$openOutput$outputStream$2(this, r4));
    }

    public RandomAccessFile randomAccessFile(VFSPath r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "mode");
        File r4 = getReadFile(r2);
        return super.randomAccessFile(VFSFiles.b.t(r4), r3);
    }

    public /* synthetic */ KAFileEncryptFileSystem(FileSystem r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }
}
