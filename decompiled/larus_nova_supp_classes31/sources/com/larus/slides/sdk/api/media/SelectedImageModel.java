package com.larus.slides.sdk.api.media;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/slides/sdk/api/media/SelectedImageModel;", "", "width", "", "height", "url", "", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getWidth", "()Ljava/lang/Float;", "setWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getHeight", "setHeight", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SelectedImageModel {

    @SerializedName("height")
    private Float height;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private Float width;

    public SelectedImageModel() {
        this(null, null, null, 7, null);
    }

    public final Float getHeight() {
        return this.height;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Float getWidth() {
        return this.width;
    }

    public final void setHeight(Float r1) {
        this.height = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setWidth(Float r1) {
        this.width = r1;
    }

    public SelectedImageModel(Float r1, Float r2, String r3) {
        this.width = r1;
        this.height = r2;
        this.url = r3;
    }

    public /* synthetic */ SelectedImageModel(Float r2, Float r3, String r4, int r5, DefaultConstructorMarker r6) {
        int r7 = r5 & 1;
        Float r0 = Float.valueOf(0.0f);
        if (r7 == 0) goto L6;
        r2 = r0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
