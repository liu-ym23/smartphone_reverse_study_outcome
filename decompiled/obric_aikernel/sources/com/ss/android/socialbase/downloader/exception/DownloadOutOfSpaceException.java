package com.ss.android.socialbase.downloader.exception;

import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.utils.g;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadOutOfSpaceException extends BaseException {
    private final long avaliableSpaceBytes;
    private final long requiredSpaceBytes;

    public DownloadOutOfSpaceException(long r10, long r11) {
        super(PointerIconCompat.TYPE_CELL, String.format(Locale.US, "space is not enough required space is : %d but available space is :%d", new Object[]{Long.valueOf(r11), Long.valueOf(g.A(r10) * 1048576)}));
        this.avaliableSpaceBytes = r10;
        this.requiredSpaceBytes = r11;
    }

    public long getAvaliableSpaceBytes() {
        return this.avaliableSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
