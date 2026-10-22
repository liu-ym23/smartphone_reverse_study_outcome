package com.ss.android.lark.chat.entity.media;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MediaExtra implements Serializable {
    private long duration;
    private String filePath;
    private String key;
    private String mime;
    private long size;
    private String url;

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.url, this.filePath, Long.valueOf(this.size), this.mime, Long.valueOf(this.duration)});
    }

    public MediaExtra() {
        this.key = BuildConfig.FLAVOR;
        this.url = BuildConfig.FLAVOR;
        this.filePath = BuildConfig.FLAVOR;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getKey() {
        return this.key;
    }

    public String getMime() {
        return this.mime;
    }

    public long getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L21;
        MediaExtra r9 = (MediaExtra) r8;
        if (this.duration == r9.duration) goto L13;
    L19:
        return false;
    L13:
        if (Objects.equals(this.key, r9.key) == false) goto L19;
        if (Objects.equals(this.url, r9.url) == false) goto L19;
        if (Objects.equals(this.mime, r9.mime) == false) goto L19;
        return true;
    }

    public void setDuration(long r1) {
        this.duration = r1;
    }

    public void setFilePath(String r1) {
        this.filePath = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setMime(String r1) {
        this.mime = r1;
    }

    public void setSize(long r1) {
        this.size = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
