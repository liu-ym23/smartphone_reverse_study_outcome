package com.ss.android.lark.diskmanage.storage;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.vfs.ChainedFileSystem;
import com.ss.android.lark.vfs.FileSystem;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.g;
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
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0002)*B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/diskmanage/storage/UserScopeCipherFileSystem;", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "cipherManager", "Lcom/ss/lark/android/encryption/interfaces/ICipherManager;", "onlyDecrypt", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/vfs/FileSystem;Lcom/ss/lark/android/encryption/interfaces/ICipherManager;Z)V", "cipherStatus", BuildConfig.FLAVOR, "getName", BuildConfig.FLAVOR, "isEncryptOn", "isStreamCipherOn", "onInstalled", BuildConfig.FLAVOR, "fms", "Lcom/ss/android/lark/vfs/FileSystemManager;", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "openInput", "Ljava/io/InputStream;", "getReadFile", "Ljava/io/File;", "openOutput", "Ljava/io/OutputStream;", "append", "randomAccessFile", "Ljava/io/RandomAccessFile;", "mode", "afterWriteCompat", "originalFile", "Lcom/ss/android/lark/vfs/VFSFile;", "beforeReadCompat", "size", BuildConfig.FLAVOR, "encryptFile", "decryptFile", "file", "Companion", "UserScopeCipherFileSystemFactory", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserScopeCipherFileSystem extends ChainedFileSystem {
    public static final a Companion = null;
    public static final WeakHashMap<String, WeakReference<ReentrantLock>> a = null;
    private final jkc.c cipherManager;
    private int cipherStatus;
    private final boolean onlyDecrypt;

    @UserScope
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/diskmanage/storage/UserScopeCipherFileSystem$UserScopeCipherFileSystemFactory;", "Lcom/ss/android/lark/vfs/FileSystemManager$FileSystemFactory;", "cipherManager", "Lcom/ss/lark/android/encryption/interfaces/ICipherManager;", "<init>", "(Lcom/ss/lark/android/encryption/interfaces/ICipherManager;)V", "onlyDecrypt", BuildConfig.FLAVOR, "setOnlyDecrypt", "create", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserScopeCipherFileSystemFactory extends FileSystemManager.FileSystemFactory {
        private final jkc.c cipherManager;
        private boolean onlyDecrypt;

        @Inject
        public UserScopeCipherFileSystemFactory(jkc.c r2) {
            Intrinsics.checkNotNullParameter(r2, "cipherManager");
            this.cipherManager = r2;
        }

        public ChainedFileSystem create(FileSystem r4) {
            Intrinsics.checkNotNullParameter(r4, "delegate");
            return new UserScopeCipherFileSystem(r4, this.cipherManager, this.onlyDecrypt);
        }

        public final UserScopeCipherFileSystemFactory setOnlyDecrypt(boolean r1) {
            this.onlyDecrypt = r1;
            return this;
        }
    }

    public static final class a {
        public a() {
        }

        public static Lock a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "filePath");
            WeakHashMap r0 = UserScopeCipherFileSystem.access$getFileLockCache$cp();
            monitor-enter(r0);
            WeakReference r1 = (WeakReference) UserScopeCipherFileSystem.access$getFileLockCache$cp().get(r4);     // Catch: Throwable -> L12
            if (r1 == null) goto L7;
            Lock r2 = (Lock) r1.get();     // Catch: Throwable -> L12
        L8:
            if (r2 != null) goto L10;
            r2 = new ReentrantLock();     // Catch: Throwable -> L12
            UserScopeCipherFileSystem.access$getFileLockCache$cp().put(r4, new WeakReference(r2));     // Catch: Throwable -> L12
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

    public String getName() {
        return "KAFileEncryptFileSystem";
    }

    static {
        Companion = new a();
        a = new WeakHashMap();
    }

    public static final /* synthetic */ WeakHashMap access$getFileLockCache$cp() {
        return a;
    }

    public final File a(File r13) {
        Log.i("KAFileEncryptFileSystem", "start decrypt file: " + r13.getAbsolutePath());
        PolarisFileWrapper r4 = null;
        a r6 = Companion;     // Catch: Throwable -> L16 DecryptException -> L18
        String r7 = r13.getAbsolutePath();     // Catch: Throwable -> L16 DecryptException -> L18
        r6.getClass();     // Catch: Throwable -> L16 DecryptException -> L18
        PolarisFileWrapper r8 = a.a(r7);     // Catch: Throwable -> L16 DecryptException -> L18
        r8.lock();     // Catch: Throwable -> L12 DecryptException -> L14
        long r9 = System.currentTimeMillis();     // Catch: Throwable -> L12 DecryptException -> L14
        com.ss.android.lark.storage.monitor.b.a.getClass();     // Catch: Throwable -> L12 DecryptException -> L14
        PolarisFileWrapper r10 = new PolarisFileWrapper((String) this.cipherManager.m3(r13).second);     // Catch: Throwable -> L12 DecryptException -> L14
        Intrinsics.checkNotNullParameter(r13, "file");     // Catch: DecryptException -> L10 Throwable -> L12
        long r11 = System.currentTimeMillis() - r9;     // Catch: DecryptException -> L10 Throwable -> L12
        if (Intrinsics.areEqual(r10.getPath(), r13.getPath()) == true) goto L8;
        Log.i("KAFileEncryptFileSystem", "decrypt success, cost: " + r11 + ", " + r13.getAbsolutePath() + "\n  -> " + r10.getAbsolutePath());     // Catch: DecryptException -> L10 Throwable -> L12
    L9:
        r8.unlock();
    L24:
        if (r10 != null) goto L27;
        return r13;
    L27:
        return r10;
    L8:
        Log.i("KAFileEncryptFileSystem", "not encrypt file: " + r13.getAbsolutePath());     // Catch: DecryptException -> L10 Throwable -> L12
    L10:
        e = e;
        r4 = r10;
    L15:
        PolarisFileWrapper r2 = r4;
        r4 = r8;
    L20:
        com.ss.android.lark.storage.monitor.b r12 = com.ss.android.lark.storage.monitor.b.a;     // Catch: Throwable -> L16
        e.getErrorCode();     // Catch: Throwable -> L16
        r12.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r13, "file");     // Catch: Throwable -> L16
        Log.e("KAFileEncryptFileSystem", "decrypt fail: " + r13.getAbsolutePath());     // Catch: Throwable -> L16
        if (r4 == null) goto L23;
        r4.unlock();
    L23:
        r10 = r2;
    L12:
        th = th;
    L29:
        if (r8 == null) goto L31;
        r8.unlock();
    L31:
        throw th;
    L14:
        e = e;
    L18:
        e = e;
        r2 = null;
    L16:
        th = th;
        r8 = r4;
        goto L29
    }

    public File afterWriteCompat(VFSFile r2) {
        Intrinsics.checkNotNullParameter(r2, "originalFile");
        File r3 = super.afterWriteCompat(r2);
        if (this.onlyDecrypt == true) goto L5;
        b(r3);
    L5:
        return r3;
    }

    public final void b(File r18) {
        if (this.onlyDecrypt == true) goto L33;
        int r7 = this.cipherStatus;
        boolean r8 = true;
        if (r7 == 1) goto L9;
        if (r7 == 0) goto L9;
        this.cipherStatus = this.cipherManager.o1();
    L9:
        if (this.cipherStatus == 1) goto L12;
        r8 = false;
    L12:
        if (r8 == false) goto L36;
        Log.i("KAFileEncryptFileSystem", "start encrypt file: " + r18.getAbsolutePath());
        Lock r9 = null;
        a r10 = Companion;     // Catch: Throwable -> L23 EncryptException -> L25
        String r11 = r18.getAbsolutePath();     // Catch: Throwable -> L23 EncryptException -> L25
        r10.getClass();     // Catch: Throwable -> L23 EncryptException -> L25
        r9 = a.a(r11);     // Catch: Throwable -> L23 EncryptException -> L25
        r9.lock();     // Catch: Throwable -> L23 EncryptException -> L25
        long r12 = r18.lastModified();     // Catch: Throwable -> L23 EncryptException -> L25
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L23 EncryptException -> L25
        com.ss.android.lark.storage.monitor.b.a.getClass();     // Catch: Throwable -> L23 EncryptException -> L25
        int r14 = this.cipherManager.Q9(r18);     // Catch: Throwable -> L23 EncryptException -> L25
        if (r14 == 0) goto L18;
        Log.e("KAFileEncryptFileSystem", "encrypt file failed. file=" + r18.getAbsolutePath() + ", code=" + r14);     // Catch: Throwable -> L23 EncryptException -> L25
    L18:
        Intrinsics.checkNotNullParameter(r18, "file");     // Catch: Throwable -> L23 EncryptException -> L25
        long r15 = r18.lastModified();     // Catch: Throwable -> L23 EncryptException -> L25
        long r16 = System.currentTimeMillis() - r13;     // Catch: Throwable -> L23 EncryptException -> L25
        if (r12 != r15) goto L21;
        Log.w("KAFileEncryptFileSystem", "encrypt status is open, but encrypt not worked, may file is encrypt already. " + r18.getAbsolutePath());     // Catch: Throwable -> L23 EncryptException -> L25
    L28:
        r9.unlock();
        return;
    L21:
        Log.w("KAFileEncryptFileSystem", "encrypt file success, cost:" + r16 + ", " + r18);     // Catch: Throwable -> L23 EncryptException -> L25
    L23:
        th = move-exception;
        if (0 == 0) goto L32;
        r9.unlock();
    L32:
        throw th;
    L25:
        e = move-exception;
        com.ss.android.lark.storage.monitor.b r4 = com.ss.android.lark.storage.monitor.b.a;     // Catch: Throwable -> L23
        e.getErrorCode();     // Catch: Throwable -> L23
        r4.getClass();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r18, "file");     // Catch: Throwable -> L23
        Log.e("KAFileEncryptFileSystem", "encrypt file failed: " + r18.getAbsolutePath(), e);     // Catch: Throwable -> L23
        if (0 != 0) goto L28;
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
        Log.i("KAFileEncryptFileSystem", "openInput: " + r4.getRealPath());
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
        return new PolarisFileWrapper((String) this.cipherManager.m3(super.getReadFile(r3)).second).length();
    }

    public static final /* synthetic */ void access$encryptFile(UserScopeCipherFileSystem r0, File r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ File access$getWriteFile$s17248747(UserScopeCipherFileSystem r0, VFSPath r1) {
        return super.getWriteFile(r1);
    }

    public void onInstalled(FileSystemManager r2, VFSPath r3) {
        Intrinsics.checkNotNullParameter(r2, "fms");
        Intrinsics.checkNotNullParameter(r3, "path");
        super.onInstalled(r2, r3);
    }

    public OutputStream openOutput(final VFSPath r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "path");
        Log.i("KAFileEncryptFileSystem", "openOutput: " + r3.getRealPath() + ", append:" + r4);
        if (this.onlyDecrypt == false) goto L7;
        if (r4 == false) goto L10;
        return new PolarisFileOutputStreamWrapper(a(getWriteFile(r3)));
    L10:
        return super.openOutput(r3, r4);
    L7:
        f.a.a.b();
        return new g(super.openOutput(r3, r4), new UserScopeCipherFileSystem$openOutput$outputStream$2(this, r3));
    }

    public RandomAccessFile randomAccessFile(VFSPath r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "mode");
        File r4 = getReadFile(r2);
        return super.randomAccessFile(VFSFiles.b.t(r4), r3);
    }

    public UserScopeCipherFileSystem(FileSystem r2, jkc.c r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r3, "cipherManager");
        super(r2);
        this.cipherManager = r3;
        this.onlyDecrypt = r4;
        this.cipherStatus = -1;
    }

    public /* synthetic */ UserScopeCipherFileSystem(FileSystem r1, jkc.c r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }
}
