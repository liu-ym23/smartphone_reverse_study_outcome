package com.ss.android.lark.im.sdk.message.send;

import android.content.Context;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.m0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.lark.android.encryption.CipherManager;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements e.b {
    public d() {
    }

    @Override // com.ss.android.lark.im.sdk.message.send.e.b
    public final File a(File r4) {
        Intrinsics.checkNotNullParameter(r4, "file");
        int r0 = com.ss.android.lark.videosend.tools.l.a;
        Intrinsics.checkNotNullParameter(r4, "originFile");
        if (com.ss.android.lark.videosend.tools.l.c() == false) goto L6;
        Log.i("VideoStorage", "decrypted file by unistore");
        return com.ss.android.lark.videosend.tools.l.b().n(r4, true);
    L6:
        return CipherManager.e(r4, true);
    }

    @Override // com.ss.android.lark.im.sdk.message.send.e.b
    public final PolarisFileWrapper d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "originFilePath");
        return CipherManager.e(VFSFiles.b.i(r2), true);
    }

    @Override // com.ss.android.lark.im.sdk.message.send.e.b
    public final PolarisFileWrapper b(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return m0.b(r2, r3, false);
    }

    @Override // com.ss.android.lark.im.sdk.message.send.e.b
    public final Uri c(Context r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        int r1 = CipherManager.a;
        Intrinsics.checkNotNullParameter(r4, "uri");
        Intrinsics.checkNotNullParameter(r4, "uri");
        return CipherManager.b(r3, r4);
    L5:
        e = move-exception;
        CipherManager.j(e);
        throw e;
    }
}
