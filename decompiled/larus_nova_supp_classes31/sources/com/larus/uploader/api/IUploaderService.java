package com.larus.uploader.api;

import android.content.Context;
import com.larus.uploader.impl.ImageXUploaderImpl;
import com.larus.uploader.impl.a;
import com.larus.uploader.impl.g;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/larus/uploader/api/IUploaderService;", "", "getImageXUploader", "Lcom/larus/platform/api/IUploader;", "param", "Lcom/larus/platform/model/upload/ResourceUploadParam;", "getVideoUploader", "getBDMediaDataReaderImplFD", "context", "Landroid/content/Context;", "fileUri", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IUploaderService {
    g a(j r1);

    ImageXUploaderImpl b(j r1);

    a c(Context r1, String r2);
}
