package com.suite.lark.platform.component.storage.file.cache;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.diskmanage.storage.KAFileEncryptFileSystem;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.g;
import com.ss.android.lark.vfs.h;
import com.ss.lark.android.encryption.CipherManager;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import znc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements b {
    public final h a;

    public a(h r1) {
        this.a = r1;
    }

    public final OutputStream a(final PolarisFileWrapper r4) {
        Intrinsics.checkNotNullParameter(r4, "file");
        h r0 = this.a;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.C() != true) goto L7;
    L8:
        if (r1 == false) goto L11;
        return this.a.E(r4);
    L11:
        return new g(new PolarisFileOutputStreamWrapper(r4), new VFSCacheAccessor$newOutputStream$1(r4));
    L7:
        r1 = false;
        goto L8
    }

    public final File b(File r3) {
        Intrinsics.checkNotNullParameter(r3, "file");
        h r0 = this.a;
        if (r0 == null) goto L9;
        File r1 = r0.n(r3, true);
        if (r1 != null) goto L8;
        return r3;
    L8:
        return r1;
    L9:
        return r3;
    }

    public final void c(PolarisFileWrapper r5) {
        Intrinsics.checkNotNullParameter(r5, "directory");
        h r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        FileSystemManager.a r2 = FileSystemManager.a();
        r2.c(r5.getAbsolutePath());
        r2.a(new KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory(false, 1, null));
        r2.b(false);
        return;
    L11:
        return;
    L5:
        if (r0.C() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final InputStream j(File r4) {
        Intrinsics.checkNotNullParameter(r4, "file");
        h r0 = this.a;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.C() != true) goto L7;
    L8:
        if (r2 == false) goto L11;
        return this.a.j(r4);
    L11:
        return new PolarisFileInputStreamWrapper(CipherManager.e(r4, false));
    L7:
        r2 = false;
        goto L8
    }
}
