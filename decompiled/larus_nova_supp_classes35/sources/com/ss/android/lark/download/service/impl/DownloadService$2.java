package com.ss.android.lark.download.service.impl;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.EncryptException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
class DownloadService$2 implements IGetDataCallback<wbb.d.b> {
    final /* synthetic */ j this$0;
    final /* synthetic */ IGetDataCallback val$callback;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Token val$token;

    public void onError(ErrorResult r2) {
        IGetDataCallback r0 = this.val$callback;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    public void onSuccess(wbb.d.b r7) {
        if (r7.b == true) goto L14;
        String r0 = r7.a;
        int r2 = xbb.a.a;
        VFSFiles r3 = VFSFiles.b;
        r3.getClass();
        if (VFSFiles.b(true).i(r0).exists() == true) goto L18;
        Log.e("DownloadFile", "file not exists");
    L18:
        r3.getClass();     // Catch: EncryptException -> L9
        CipherManager.c(VFSFiles.b(true).i(r0));     // Catch: EncryptException -> L9
        Log.i("DownloadFile", "[cipher] file encrypt success, path = " + r0);     // Catch: EncryptException -> L9
    L10:
        IGetDataCallback r1 = this.val$callback;
        if (r1 == null) goto L13;
        r1.onSuccess(r7);
    L13:
        j.a(this.val$context, r0, this.val$token);
        return;
    L9:
        Log.e("DownloadFile", "[cipher] file encrypt failed, path = " + r0);
        goto L10
    L14:
        IGetDataCallback r4 = this.val$callback;
        if (r4 == null) goto L21;
        r4.onSuccess(r7);
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((wbb.d.b) r1);
    }

    public DownloadService$2(j r1, IGetDataCallback r2, Context r3, Token r4) {
        this.this$0 = r1;
        this.val$callback = r2;
        this.val$context = r3;
        this.val$token = r4;
    }
}
