package com.ss.android.lark.download.service;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DownloadProgress implements Serializable {
    private static final long serialVersionUID = 845768575142564090L;
    private String channelId;
    private String key;
    private String messageId;
    private int progress;
    private String sourceId;
    private FileDownloadState state;

    public DownloadProgress() {
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public FileDownloadState getState() {
        return this.state;
    }

    public void setChannelId(String r1) {
        this.channelId = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setProgress(int r1) {
        this.progress = r1;
    }

    public void setSourceId(String r1) {
        this.sourceId = r1;
    }

    public void setState(FileDownloadState r1) {
        this.state = r1;
    }
}
