package com.ss.android.lark.download.service;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DownloadFileMeta implements Serializable {
    private static final long serialVersionUID = 5313799077813905082L;
    private String filePath;
    private int progress;

    public DownloadFileMeta() {
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setFilePath(String r1) {
        this.filePath = r1;
    }

    public void setProgress(int r1) {
        this.progress = r1;
    }
}
