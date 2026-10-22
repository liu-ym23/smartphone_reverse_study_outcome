package com.bytedance.android.live.ktv.common.music.download;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/ktv/common/music/download/DownLoadFailException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errCode", "", "errMsg", "", "(ILjava/lang/String;)V", "getErrCode", "()I", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DownLoadFailException extends Exception {
    private final int errCode;

    public final int getErrCode() {
        return this.errCode;
    }

    public DownLoadFailException(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        super(r3);
        this.errCode = r2;
    }
}
