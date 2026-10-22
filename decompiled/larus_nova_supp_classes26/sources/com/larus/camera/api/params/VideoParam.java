package com.larus.camera.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/larus/camera/api/params/VideoParam;", "Lcom/larus/camera/api/params/BaseResultParam;", "<init>", "()V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "uri", "", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "recordMode", "getRecordMode", "setRecordMode", "clone", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoParam extends BaseResultParam {
    private long duration;
    private String recordMode;
    private String uri;

    @Override // com.larus.camera.api.params.BaseResultParam
    public VideoParam clone() {
        VideoParam r0 = new VideoParam();
        r0.setPath(getPath());
        r0.setWidth(getWidth());
        r0.setHeight(getHeight());
        r0.setSize(getSize());
        r0.setCreatedTime(getCreatedTime());
        r0.duration = this.duration;
        r0.uri = this.uri;
        r0.recordMode = this.recordMode;
        return r0;
    }

    public String toString() {
        return "[path=" + getPath() + ", width=" + getWidth() + ",height=" + getHeight() + ",size=" + getSize() + ",createTime:" + getCreatedTime() + " duration=" + this.duration + ",uri=" + this.uri + ",recordMode:" + this.recordMode + ']';
    }

    public VideoParam() {
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getRecordMode() {
        return this.recordMode;
    }

    public final String getUri() {
        return this.uri;
    }

    @Override // com.larus.camera.api.params.BaseResultParam
    public /* bridge */ /* synthetic */ BaseResultParam clone() {
        return clone();
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setRecordMode(String r1) {
        this.recordMode = r1;
    }

    public final void setUri(String r1) {
        this.uri = r1;
    }
}
