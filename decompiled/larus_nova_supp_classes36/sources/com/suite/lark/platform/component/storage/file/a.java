package com.suite.lark.platform.component.storage.file;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.FileAccessCompatManager;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.EncryptException;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements FileAccessCompatManager.b {
    public final boolean a;

    public a() {
        this.a = true;
    }

    public final File a(PolarisFileWrapper r4) {
        Intrinsics.checkNotNullParameter(r4, "origin");
    L7:
        e = move-exception;
        Log.e("LarkFileStorage", "[cipher] file encrypt failed, original path = " + r4.getAbsolutePath() + ", " + e.getErrorCode());
    L9:
        return r4;
    L4:
        if (this.a == false) goto L9;
        CipherManager.c(r4);     // Catch: EncryptException -> L7
        goto L9
    }

    public final void accept(File r2) {
        Intrinsics.checkNotNullParameter(r2, "file");
    }

    public final File b(File r4) {
        Intrinsics.checkNotNullParameter(r4, "origin");
        return CipherManager.e(r4, false);
    L5:
        e = move-exception;
        Log.e("LarkFileStorage", "[cipher] file decrypt failed, original path = " + r4.getAbsolutePath() + ", " + e.getErrorCode());
        return r4;
    }
}
