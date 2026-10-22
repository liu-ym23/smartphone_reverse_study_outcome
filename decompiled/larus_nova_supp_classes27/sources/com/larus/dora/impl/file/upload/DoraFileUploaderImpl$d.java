package com.larus.dora.impl.file.upload;

import com.larus.dora.api.model.FlowDoraConnectReason;
import com.ttnetuploader.uploader.api.IUploadCallback;
import com.ttnetuploader.uploader.api.ResultInfo;
import g49.d;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraFileUploaderImpl$d implements IUploadCallback {
    public final /* synthetic */ DoraFileUploaderTrigger a;
    public final /* synthetic */ CompletableDeferred<DoraFileUploaderImpl$b> b;

    public final void onProgress(long r1, long r3, long r5, long r7) {
    }

    public final void onFailed(ResultInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "uploadInfo");
        d.b("DoraFileUploaderImpl", "uploadFileInternal: upload failed, code=" + r5.code + ", errorLog=" + r5.getUploadLog() + ", trigger=" + this.a);
        CompletableDeferred<DoraFileUploaderImpl$b> r0 = this.b;
        StringBuilder r2 = new StringBuilder("uploadFailed(");
        r2.append(r5.code);
        r2.append(')');
        r0.complete(new DoraFileUploaderImpl$b(false, r2.toString()));
    }

    public final void onSuccess(ResultInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "uploadInfo");
        d.d("DoraFileUploaderImpl", "uploadFileInternal: upload success, response=" + r5.getStringBody() + ", trigger=" + this.a);     // Catch: Exception -> L5
        this.b.complete(new DoraFileUploaderImpl$b(true, FlowDoraConnectReason.SUCCESS));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.c("DoraFileUploaderImpl", "uploadFileInternal: parse success response error, trigger=" + this.a, e);
        this.b.complete(new DoraFileUploaderImpl$b(false, "uploadFailed(-1)"));
    }

    public DoraFileUploaderImpl$d(DoraFileUploaderTrigger r1, CompletableDeferred<DoraFileUploaderImpl$b> r2) {
        this.a = r1;
        this.b = r2;
    }
}
