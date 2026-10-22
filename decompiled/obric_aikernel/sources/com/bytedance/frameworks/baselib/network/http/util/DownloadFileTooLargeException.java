package com.bytedance.frameworks.baselib.network.http.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DownloadFileTooLargeException extends IOException {
    private static final long serialVersionUID = -1098012010869697449L;
    final long length;
    final int maxSize;

    public DownloadFileTooLargeException(int r10, long r11) {
        super("Download file too large: " + r11 + " exceed maxsize: " + r10);
        this.maxSize = r10;
        this.length = r11;
    }

    public long getLength() {
        return this.length;
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}
