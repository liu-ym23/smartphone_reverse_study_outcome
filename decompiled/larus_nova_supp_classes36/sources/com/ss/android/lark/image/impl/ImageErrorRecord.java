package com.ss.android.lark.image.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/impl/ImageErrorRecord;", "", "<init>", "()V", "errorMap", "Ljava/util/concurrent/ConcurrentMap;", "", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "record", "", "imageKey", "errorResult", "getErrorResult", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageErrorRecord {
    public static final int $stable = 0;
    public static final ImageErrorRecord INSTANCE = null;
    private static final ConcurrentMap<String, ErrorResult> errorMap = null;

    private ImageErrorRecord() {
    }

    static {
        INSTANCE = new ImageErrorRecord();
        errorMap = new ConcurrentHashMap();
        $stable = 8;
    }

    public final ErrorResult getErrorResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "imageKey");
        return errorMap.get(r2);
    }

    public final void record(String r2, ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r2, "imageKey");
        if (r3 == null) goto L6;
        errorMap.put(r2, r3);
        return;
    }
}
