package com.larus.doc.sdk.impl.generalbiz.state.media;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003BI\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u000fJ\u0006\u0010)\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010&\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013¨\u0006*"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectedMediaItemV1;", "", "<init>", "()V", "contentType", "", "uuid", "mediaFile", "width", "", "height", "duration", "", "fileSize", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJJLjava/lang/String;)V", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "getUuid", "setUuid", "getMediaFile", "setMediaFile", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "getDuration", "()J", "setDuration", "(J)V", "getFileSize", "setFileSize", "getFileName", "setFileName", "src", "getSrc", "setSrc", "encodeFilePath", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectedMediaItemV1 {
    private String contentType;
    private long duration;
    private String fileName;
    private long fileSize;
    private int height;
    private String mediaFile;
    private String src;
    private String uuid;
    private int width;

    public final String encodeFilePath() {
        String r6 = this.mediaFile;
        return FileConst.DOC_PREFIX_URL + this.uuid + r6.substring(StringsKt.lastIndexOf$default(r6, ".", 0, false, 6, null));
    }

    public SelectedMediaItemV1() {
        this.contentType = "";
        this.uuid = "";
        this.mediaFile = "";
        this.fileName = "";
        this.src = "";
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getMediaFile() {
        return this.mediaFile;
    }

    public final String getSrc() {
        return this.src;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setContentType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentType = r2;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setFileName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileName = r2;
    }

    public final void setFileSize(long r1) {
        this.fileSize = r1;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setMediaFile(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mediaFile = r2;
    }

    public final void setSrc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.src = r2;
    }

    public final void setUuid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uuid = r2;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public SelectedMediaItemV1(String r2, String r3, String r4, int r5, int r6, long r7, long r9, String r11) {
        Intrinsics.checkNotNullParameter(r2, "contentType");
        Intrinsics.checkNotNullParameter(r3, "uuid");
        Intrinsics.checkNotNullParameter(r4, "mediaFile");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        this.src = "";
        this.contentType = r2;
        this.uuid = r3;
        this.mediaFile = r4;
        this.width = r5;
        this.height = r6;
        this.duration = r7;
        this.fileSize = r9;
        this.fileName = r11;
    }
}
