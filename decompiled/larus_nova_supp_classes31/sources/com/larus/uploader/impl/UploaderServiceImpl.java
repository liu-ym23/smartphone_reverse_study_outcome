package com.larus.uploader.impl;

import android.content.Context;
import com.larus.platform.service.z2;
import com.larus.uploader.api.IUploaderService;
import com.larus.utils.logger.FLogger;
import com.ss.bduploader.BDUploadLog;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/uploader/impl/UploaderServiceImpl;", "Lcom/larus/uploader/api/IUploaderService;", "<init>", "()V", "getImageXUploader", "Lcom/larus/platform/api/IUploader;", "param", "Lcom/larus/platform/model/upload/ResourceUploadParam;", "getVideoUploader", "getBDMediaDataReaderImplFD", "", "context", "Landroid/content/Context;", "fileUri", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class UploaderServiceImpl implements IUploaderService {
    public UploaderServiceImpl() {
        boolean r0 = z2.a.getBDImageXUploadOptConfig().c;
        FLogger.a.i("UploaderServiceImpl", "[UploaderServiceImpl] init. enablePrint: " + r0);
        if (r0 == false) goto L6;
        BDUploadLog.setLogPrintType(3);
        BDUploadLog.setALogCallback(new b());
        return;
    }

    @Override // com.larus.uploader.api.IUploaderService
    public final g a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        return new g(r2);
    }

    @Override // com.larus.uploader.api.IUploaderService
    public final ImageXUploaderImpl b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        return new ImageXUploaderImpl(r2);
    }

    @Override // com.larus.uploader.api.IUploaderService
    public final a c(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "fileUri");
        return new a(r2, r3);
    }
}
