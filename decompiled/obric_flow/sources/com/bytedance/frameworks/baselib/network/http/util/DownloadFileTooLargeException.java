package com.bytedance.frameworks.baselib.network.http.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadFileTooLargeException extends IOException {
    private static final long serialVersionUID = -1098012010869697449L;
    final long length;
    final int maxSize;

    public DownloadFileTooLargeException(int r5, long r10) {
        super("Download file too large: " + r10 + " exceed maxsize: " + r5);
        this.maxSize = r5;
        this.length = r10;
    }

    public long getLength() {
        return this.length;
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}
