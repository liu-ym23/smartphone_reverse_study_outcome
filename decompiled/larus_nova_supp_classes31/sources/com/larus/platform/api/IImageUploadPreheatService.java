package com.larus.platform.api;

import com.larus.platform.model.upload.UploadDataType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/api/IImageUploadPreheatService;", "", "preheat", "", "context", "Landroid/content/Context;", "targetCount", "", "threshold", "scene", "", "dataType", "Lcom/larus/platform/model/upload/UploadDataType;", "(Landroid/content/Context;IILjava/lang/String;Lcom/larus/platform/model/upload/UploadDataType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IImageUploadPreheatService {
    Object a(int r1, int r2, String r3, UploadDataType r4, Continuation r5);
}
