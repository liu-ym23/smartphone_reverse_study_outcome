package com.obric.aikernel.res.integrity;

import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aikernel.res.metadata.config.f;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u00017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ!\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0010H\u0000¢\u0006\u0002\b\u0012J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\nJ\u001f\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u001fJ \u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017H\u0002J\u0016\u0010%\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000eJ\u0016\u0010'\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#J\u001c\u0010(\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020#0*J\u000e\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\nJ(\u0010-\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J(\u0010.\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000eH\u0002J\u0016\u00102\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#J\u0016\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u000eJ\u0016\u00106\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00105\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/aikernel/res/integrity/ModelArtifactIntegrity;", "", "()V", "FULL_MD5_HEX_LENGTH", "", "READ_ONLY_MODE", "WRITE_MODE_MASK", "commitPayload", "", "staging", "Ljava/io/File;", TypedValues.AttributesType.S_TARGET, "backup", "computeFullMd5Hex", "", "readChunk", "Lkotlin/Function1;", "", "computeFullMd5Hex$resource_manager_release", "fd", "Ljava/io/FileDescriptor;", "deleteDurably", "isPathInside", "", "path", "root", "isReadOnly", "file", "normalizeFullMd5Spec", "expectedMd5", "fileName", "normalizeFullMd5Spec$resource_manager_release", "openDescriptor", "Lcom/obric/aikernel/res/integrity/ModelArtifactIntegrity$OpenedDescriptor;", "spec", "Lcom/obric/aikernel/res/metadata/config/ModelArtifactSpec;", "writable", "resolveContainedFile", "relativePath", "sealFile", "sealPayload", "specs", "", "syncDirectory", "directory", "verifyDescriptorContent", "verifyPathIdentity", "descriptorStat", "Landroid/system/StructStat;", "context", "verifySealedFile", "writeDurableMarker", "marker", EventBody.KEY_VALUE, "writeDurableText", "OpenedDescriptor", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6050a = null;

    /* JADX INFO: renamed from: com.obric.aikernel.res.integrity.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/aikernel/res/integrity/ModelArtifactIntegrity$OpenedDescriptor;", "Ljava/lang/AutoCloseable;", "fd", "Ljava/io/FileDescriptor;", "(Ljava/io/FileDescriptor;)V", "getFd", "()Ljava/io/FileDescriptor;", IslandSession.REOPEN_VALUE_CLOSE, "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class C0260a implements AutoCloseable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FileDescriptor f6051a;

        public C0260a(FileDescriptor r2) {
            Intrinsics.checkNotNullParameter(r2, "fd");
            this.f6051a = r2;
        }

        public final FileDescriptor a() {
            return this.f6051a;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.f6051a.valid() == false) goto L6;
            Os.close(this.f6051a);
            return;
        }
    }

    static {
        f6050a = new a();
    }

    private a() {
    }

    private final C0260a a(File r9, f r10, boolean r11) {
        boolean r0 = true;
        if (r10.c() <= 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L58;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L56;
        if (r9.isFile() == false) goto L54;
        StructStat r12 = Os.lstat(r9.getPath());
        if (OsConstants.S_ISREG(r12.st_mode) == false) goto L52;
        int r2 = OsConstants.O_CLOEXEC | OsConstants.O_NOFOLLOW;
        if (r11 == false) goto L16;
        int r13 = OsConstants.O_RDWR;
    L17:
        FileDescriptor r14 = Os.open(r9.getPath(), r13 | r2, 0);
        StructStat r3 = Os.fstat(r14);     // Catch: Throwable -> L45
        StructStat r4 = Os.stat(r9.getPath());     // Catch: Throwable -> L45
        if (r12.st_dev == r4.st_dev) goto L21;
    L23:
        boolean r15 = false;
    L24:
        if (r15 == false) goto L44;
        if (r3.st_dev == r4.st_dev) goto L28;
    L30:
        boolean r16 = false;
    L31:
        if (r16 == false) goto L42;
        if (r3.st_size == r10.c()) goto L36;
        r0 = false;
    L36:
        if (r0 == false) goto L40;
        Intrinsics.checkNotNullExpressionValue(r14, "fd");     // Catch: Throwable -> L45
        return new C0260a(r14);
    L40:
        throw new IllegalArgumentException(("final model size mismatch: " + r9.getPath() + ' ' + r3.st_size + '/' + r10.c()).toString());     // Catch: Throwable -> L45
    L42:
        throw new IllegalArgumentException(("final model file changed during open: " + r9.getPath()).toString());     // Catch: Throwable -> L45
    L28:
        if (r3.st_ino != r4.st_ino) goto L30;
        r16 = true;
        goto L31
    L44:
        throw new IllegalArgumentException(("symbolic-link model artifact is forbidden: " + r9.getPath()).toString());     // Catch: Throwable -> L45
    L21:
        if (r12.st_ino != r4.st_ino) goto L23;
        r15 = true;
    L45:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L48
        Os.close(r14);     // Catch: Throwable -> L48
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L48
    L50:
        throw th;
    L48:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L50
    L16:
        r13 = OsConstants.O_RDONLY;
        goto L17
    L52:
        throw new IllegalArgumentException(("final model artifact is not a regular file: " + r9.getPath()).toString());
    L54:
        throw new IllegalArgumentException(("missing final model file: " + r9.getPath()).toString());
    L56:
        throw new IllegalArgumentException(("missing final md5 for " + r10.a()).toString());
    L58:
        throw new IllegalArgumentException(("missing final size for " + r10.a()).toString());
    L5:
        r8 = false;
        goto L6
    }

    private final String a(final FileDescriptor r4) {
        Os.lseek(r4, 0, OsConstants.SEEK_SET);
        return a((Function1) ZeusTransformUtils.preCheckCast(new ModelArtifactIntegrity$computeFullMd5Hex$2(r4), Function1.class, "com.obric.memorydata.plugin"));
    }

    private final void a(File r9, f r10, StructStat r11, String r12) {
        StructStat r8 = Os.lstat(r9.getPath());
        StructStat r0 = Os.stat(r9.getPath());
        boolean r2 = true;
        if (r8.st_dev == r0.st_dev) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L35;
        if (r0.st_dev == r11.st_dev) goto L12;
    L14:
        boolean r14 = false;
    L16:
        if (r14 == false) goto L33;
        if (r0.st_size != r10.c()) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L31;
        if ((r0.st_mode & 146) == 0) goto L26;
        r2 = false;
    L26:
        if (r2 == false) goto L29;
        return;
    L29:
        throw new IllegalArgumentException(("final model remains writable after " + r12 + ": " + r9.getPath() + " mode=" + r0.st_mode).toString());
    L31:
        throw new IllegalArgumentException(("final model size changed during " + r12 + ": " + r9.getPath()).toString());
    L20:
        r15 = false;
        goto L21
    L33:
        throw new IllegalArgumentException(("final model file changed during " + r12 + ": " + r9.getPath()).toString());
    L12:
        if (r0.st_ino != r11.st_ino) goto L14;
        r14 = true;
        goto L16
    L35:
        throw new IllegalArgumentException(("symbolic-link model artifact is forbidden: " + r9.getPath()).toString());
    L5:
        if (r8.st_ino != r0.st_ino) goto L7;
        r13 = true;
        goto L8
    }

    private final void a(FileDescriptor r9, File r10, f r11, String r12) {
        StructStat r0 = Os.fstat(r9);
        boolean r2 = true;
        if (r0.st_size != r11.c()) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L37;
        String r8 = a(r9);
        StructStat r13 = Os.fstat(r9);
        if (r13.st_dev == r0.st_dev) goto L10;
    L12:
        boolean r14 = false;
    L13:
        if (r14 == false) goto L35;
        if (r13.st_size == r0.st_size) goto L18;
        r2 = false;
    L18:
        if (r2 == false) goto L33;
        if (Intrinsics.areEqual(r13.st_mtim, r0.st_mtim) == false) goto L31;
        if (Intrinsics.areEqual(r13.st_ctim, r0.st_ctim) == false) goto L29;
        if (Intrinsics.areEqual(r8, r12) == false) goto L27;
        return;
    L27:
        throw new IllegalArgumentException(("final model md5 mismatch: " + r10.getPath()).toString());
    L29:
        throw new IllegalArgumentException(("final model ctime changed while reading: " + r10.getPath()).toString());
    L31:
        throw new IllegalArgumentException(("final model mtime changed while reading: " + r10.getPath()).toString());
    L33:
        throw new IllegalArgumentException(("final model size changed while reading: " + r10.getPath()).toString());
    L35:
        throw new IllegalArgumentException(("final model file changed while reading: " + r10.getPath()).toString());
    L10:
        if (r13.st_ino != r0.st_ino) goto L12;
        r14 = true;
        goto L13
    L37:
        throw new IllegalArgumentException(("final model size mismatch: " + r10.getPath() + ' ' + r0.st_size + '/' + r11.c()).toString());
    L5:
        r1 = false;
        goto L6
    }

    public final File a(File r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "root");
        Intrinsics.checkNotNullParameter(r7, "relativePath");
        boolean r0 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L20;
        if ((!new File(r7).isAbsolute()) == false) goto L18;
        File r5 = r6.getCanonicalFile();
        File r8 = new File(r5, r7).getCanonicalFile();
        if (Intrinsics.areEqual(r8.getPath(), r5.getPath()) == true) goto L12;
        String r1 = r8.getPath();
        Intrinsics.checkNotNullExpressionValue(r1, "target.path");
        if (StringsKt.startsWith$default(r1, r5.getPath() + File.separator, false, 2, null) == true) goto L12;
        r0 = false;
    L12:
        if (r0 == false) goto L16;
        Intrinsics.checkNotNullExpressionValue(r8, TypedValues.AttributesType.S_TARGET);
        return r8;
    L16:
        throw new IllegalArgumentException(("model artifact escapes payload root: " + r7).toString());
    L18:
        throw new IllegalArgumentException(("absolute model artifact path is forbidden: " + r7).toString());
    L20:
        throw new IllegalArgumentException("model artifact path is blank".toString());
    }

    public final String a(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "expectedMd5");
        Intrinsics.checkNotNullParameter(r8, "fileName");
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        boolean r2 = true;
        if (r6.length() != 32) goto L30;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L6:
        if (r1 >= r0.length()) goto L27;
        char r4 = r0.charAt(r1);
        if ('0' <= r4) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L15;
    L23:
        boolean r9 = true;
    L24:
        if (r9 == false) goto L25;
        r1 = r1 + 1;
        goto L6
    L25:
        boolean r3 = false;
    L28:
        if (r3 == false) goto L30;
    L31:
        if (r2 == false) goto L34;
        return r6;
    L34:
        throw new IllegalArgumentException(("final model md5 must be a full 32-hex digest for " + r8 + ": " + r7).toString());
    L15:
        if ('a' <= r4) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == true) goto L23;
        r9 = false;
        goto L24
    L17:
        if (r4 >= 'g') goto L19;
        r10 = true;
        goto L20
    L10:
        if (r4 >= ':') goto L12;
        r5 = true;
        goto L13
    L27:
        r3 = true;
    L30:
        r2 = false;
        goto L31
    }

    public final String a(Function1<? super byte[], Integer> r13) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "readChunk");
        MessageDigest r14 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);
        byte[] r1 = new byte[8192];
    L3:
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r12.invoke(r1), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r2 <= 0) goto L5;
        r14.update(r1, 0, r2);
        goto L3
    L5:
        byte[] r3 = r14.digest();
        Intrinsics.checkNotNullExpressionValue(r3, "digest.digest()");
        return ArraysKt.joinToString$default(r3, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(ModelArtifactIntegrity$computeFullMd5Hex$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 30, null);
    }

    public final void a(File r9, f r10) {
        Intrinsics.checkNotNullParameter(r9, "file");
        Intrinsics.checkNotNullParameter(r10, "spec");
        String r0 = a(r10.b(), r10.a());
        boolean r1 = true;
        AutoCloseable r2 = (AutoCloseable) ZeusTransformUtils.preCheckCast(a(r9, r10, true), AutoCloseable.class, "com.obric.memorydata.plugin");
        C0260a r3 = (C0260a) ZeusTransformUtils.preCheckCast(r2, C0260a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        f6050a.a(r3.a(), r9, r10, r0);     // Catch: Throwable -> L20
        Os.fsync(r3.a());     // Catch: Throwable -> L20
        Os.fchmod(r3.a(), 292);     // Catch: Throwable -> L20
        StructStat r4 = Os.fstat(r3.a());     // Catch: Throwable -> L20
        if (r4.st_size != r10.c()) goto L6;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L19;
        if ((r4.st_mode & 146) == 0) goto L12;
        r1 = false;
    L12:
        if (r1 == false) goto L17;
        Os.fsync(r3.a());     // Catch: Throwable -> L20
        AutoCloseableKt.closeFinally(r2, null);
        Intrinsics.checkNotNullExpressionValue(r4, "sealedDescriptor");
        a(r9, r10, r4, "sealing");
        return;
    L17:
        throw new IllegalArgumentException(("final model remains writable after fchmod: " + r9.getPath() + " mode=" + r4.st_mode).toString());     // Catch: Throwable -> L20
    L19:
        throw new IllegalArgumentException(("final model size changed while sealing: " + r9.getPath()).toString());     // Catch: Throwable -> L20
    L6:
        r5 = false;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        AutoCloseableKt.closeFinally(r2, th);
        throw th;
    }

    public final void a(File r3, File r4, File r5) {
        Intrinsics.checkNotNullParameter(r3, "staging");
        Intrinsics.checkNotNullParameter(r4, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r5, "backup");
        if (r3.isDirectory() == false) goto L33;
        if ((!r5.exists()) == false) goto L31;
        boolean r0 = r4.exists();
        if (r0 == false) goto L14;
        if (r4.renameTo(r5) == true) goto L14;
        throw new IllegalStateException("cannot move current model payload to backup: " + r4);
    L14:
        if (r3.renameTo(r4) == true) goto L24;
        if (r0 == false) goto L23;
        if (r5.exists() == false) goto L23;
        if (r5.renameTo(r4) == true) goto L23;
        throw new IllegalStateException("cannot publish staging or restore previous payload: " + r4);
    L23:
        throw new IllegalStateException("cannot publish model staging payload: " + r3);
    L24:
        File r6 = r4.getParentFile();
        if (r6 == null) goto L29;
        c(r6);
        return;
    L29:
        throw new IllegalStateException("model payload has no parent: " + r4);
    L31:
        throw new IllegalArgumentException(("stale model backup blocks publish: " + r5).toString());
    L33:
        throw new IllegalArgumentException(("model staging payload is missing: " + r3).toString());
    }

    public final void a(File r7, List<f> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "root");
        Intrinsics.checkNotNullParameter(r9, "specs");
        boolean r2 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r3.add(((f) ZeusTransformUtils.preCheckCast(r1.next(), f.class, "com.obric.memorydata.plugin")).a());
        goto L6
    L9:
        if (CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).size() == r9.size()) goto L12;
        r2 = false;
    L12:
        if (r2 == false) goto L20;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r10.next(), f.class, "com.obric.memorydata.plugin");
        a r5 = f6050a;
        r5.a(r5.a(r7, r4.a()), r4);
        goto L15
    L17:
        c(r7);
        return;
    L20:
        throw new IllegalArgumentException("model has duplicate artifact names".toString());
    L22:
        throw new IllegalArgumentException("model has no declared artifacts".toString());
    }

    public final boolean a(File r4) {
        Intrinsics.checkNotNullParameter(r4, "file");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if ((Os.stat(r4.getPath()).st_mode & 146) != 0) goto L6;
        boolean r5 = true;
    L7:
        Object r6 = Result.m1421constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r6) == false) goto L15;
        r6 = false;
    L15:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        r5 = false;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final boolean a(File r4, File r5) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r5, "root");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        String r6 = r4.getCanonicalFile().getPath();     // Catch: Throwable -> L12
        String r7 = r5.getCanonicalFile().getPath();     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r6, r7) == true) goto L9;
        Intrinsics.checkNotNullExpressionValue(r6, "canonicalPath");     // Catch: Throwable -> L12
        if (StringsKt.startsWith$default(r6, r7 + File.separator, false, 2, null) == true) goto L9;
        boolean r8 = false;
    L10:
        Object r9 = Result.m1421constructorimpl(Boolean.valueOf(r8));     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r9) == false) goto L18;
        r9 = false;
    L18:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L9:
        r8 = true;
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final void b(File r3) {
        Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
        if (r3.exists() == true) goto L6;
        return;
    L6:
        if (FilesKt.deleteRecursively(r3) == false) goto L14;
        File r0 = r3.getParentFile();
        if (r0 == null) goto L12;
        c(r0);
        return;
    L12:
        throw new IllegalStateException("target has no parent: " + r3);
    L14:
        throw new IllegalStateException(("cannot delete durable path: " + r3).toString());
    }

    public final void b(File r7, f r8) {
        Intrinsics.checkNotNullParameter(r7, "file");
        Intrinsics.checkNotNullParameter(r8, "spec");
        String r0 = a(r8.b(), r8.a());
        boolean r1 = false;
        AutoCloseable r2 = (AutoCloseable) ZeusTransformUtils.preCheckCast(a(r7, r8, false), AutoCloseable.class, "com.obric.memorydata.plugin");
        C0260a r3 = (C0260a) ZeusTransformUtils.preCheckCast(r2, C0260a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        f6050a.a(r3.a(), r7, r8, r0);     // Catch: Throwable -> L12
        StructStat r4 = Os.fstat(r3.a());     // Catch: Throwable -> L12
        if ((r4.st_mode & 146) != 0) goto L7;
        r1 = true;
    L7:
        if (r1 == false) goto L11;
        AutoCloseableKt.closeFinally(r2, null);
        Intrinsics.checkNotNullExpressionValue(r4, "verified");
        a(r7, r8, r4, "verification");
        return;
    L11:
        throw new IllegalArgumentException(("sealed model became writable during verification: " + r7.getPath() + " mode=" + r4.st_mode).toString());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        AutoCloseableKt.closeFinally(r2, th);
        throw th;
    }

    public final void b(File r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "marker");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        c(r2, r3);
    }

    public final void c(File r2) {
        Intrinsics.checkNotNullParameter(r2, "directory");
        FileDescriptor r1 = Os.open(r2.getPath(), OsConstants.O_RDONLY, 0);
        Os.fsync(r1);     // Catch: Throwable -> L6
        Os.close(r1);
        return;
    L6:
        th = move-exception;
        Os.close(r1);
        throw th;
    }

    public final void c(File r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r8, EventBody.KEY_VALUE);
        File r1 = r7.getParentFile();
        if (r1 == null) goto L30;
        if (r1.exists() == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L28;
        File r3 = File.createTempFile('.' + r7.getName() + '.', ".tmp", r1);
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3, false), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        FileOutputStream r0 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r4, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        byte[] r9 = r8.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L19
        r0.write(r9);     // Catch: Throwable -> L19
        r0.flush();     // Catch: Throwable -> L19
        r0.getFD().sync();     // Catch: Throwable -> L19
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L24
        Os.rename(r3.getPath(), r7.getPath());     // Catch: Throwable -> L24
        c(r1);     // Catch: Throwable -> L24
        r3.delete();
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r3.delete();
        throw th;
    L28:
        throw new IllegalArgumentException(("cannot create target directory: " + r1).toString());
    L7:
        if (r1.mkdirs() == true) goto L10;
        r2 = false;
        goto L11
    L30:
        throw new IllegalStateException("target has no parent: " + r7);
    }
}
