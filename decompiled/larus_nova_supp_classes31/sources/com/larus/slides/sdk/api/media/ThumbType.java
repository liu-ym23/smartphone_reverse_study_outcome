package com.larus.slides.sdk.api.media;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006'"}, d2 = {"Lcom/larus/slides/sdk/api/media/ThumbType;", "", "contentType", "", "fileName", "duration", "", "fileSize", "", "height", "width", "src", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "getFileName", "setFileName", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFileSize", "()Ljava/lang/Long;", "setFileSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getHeight", "setHeight", "getWidth", "setWidth", "getSrc", "setSrc", "getUuid", "setUuid", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ThumbType {

    @SerializedName("contentType")
    private String contentType;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("fileName")
    private String fileName;

    @SerializedName("fileSize")
    private Long fileSize;

    @SerializedName("height")
    private Integer height;

    @SerializedName("src")
    private String src;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("width")
    private Integer width;

    public ThumbType() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getSrc() {
        return this.src;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setContentType(String r1) {
        this.contentType = r1;
    }

    public final void setDuration(Integer r1) {
        this.duration = r1;
    }

    public final void setFileName(String r1) {
        this.fileName = r1;
    }

    public final void setFileSize(Long r1) {
        this.fileSize = r1;
    }

    public final void setHeight(Integer r1) {
        this.height = r1;
    }

    public final void setSrc(String r1) {
        this.src = r1;
    }

    public final void setUuid(String r1) {
        this.uuid = r1;
    }

    public final void setWidth(Integer r1) {
        this.width = r1;
    }

    public ThumbType(String r1, String r2, Integer r3, Long r4, Integer r5, Integer r6, String r7, String r8) {
        this.contentType = r1;
        this.fileName = r2;
        this.duration = r3;
        this.fileSize = r4;
        this.height = r5;
        this.width = r6;
        this.src = r7;
        this.uuid = r8;
    }

    public /* synthetic */ ThumbType(String r10, String r11, Integer r12, Long r13, Integer r14, Integer r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = 0;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Long r6 = 0L;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r7 = 0;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r5 = 0;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r6, r7, r5, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r5 = r15;
        goto L27
    L21:
        r7 = r14;
        goto L23
    L17:
        r6 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
