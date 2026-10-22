package com.larus.settings.provider.im;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/settings/provider/im/ImageUploadOptConfig;", "", "albumResize", "", "albumQuality", "cameraResize", "cameraQuality", "<init>", "(IIII)V", "getAlbumResize", "()I", "getAlbumQuality", "getCameraResize", "getCameraQuality", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageUploadOptConfig {

    @SerializedName("album_quality")
    private final int albumQuality;

    @SerializedName("album_resize")
    private final int albumResize;

    @SerializedName("camera_quality")
    private final int cameraQuality;

    @SerializedName("camera_resize")
    private final int cameraResize;

    public ImageUploadOptConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ImageUploadOptConfig copy$default(ImageUploadOptConfig r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.albumResize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.albumQuality;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.cameraResize;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.cameraQuality;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.albumResize;
    }

    public final int component2() {
        return this.albumQuality;
    }

    public final int component3() {
        return this.cameraResize;
    }

    public final int component4() {
        return this.cameraQuality;
    }

    public final ImageUploadOptConfig copy(int r2, int r3, int r4, int r5) {
        return new ImageUploadOptConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageUploadOptConfig) == true) goto L8;
        return false;
    L8:
        ImageUploadOptConfig r6 = (ImageUploadOptConfig) r5;
        if (this.albumResize == r6.albumResize) goto L12;
        return false;
    L12:
        if (this.albumQuality == r6.albumQuality) goto L15;
        return false;
    L15:
        if (this.cameraResize == r6.cameraResize) goto L18;
        return false;
    L18:
        if (this.cameraQuality == r6.cameraQuality) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.albumResize * 31) + this.albumQuality) * 31) + this.cameraResize) * 31) + this.cameraQuality;
    }

    public String toString() {
        return "ImageUploadOptConfig(albumResize=" + this.albumResize + ", albumQuality=" + this.albumQuality + ", cameraResize=" + this.cameraResize + ", cameraQuality=" + this.cameraQuality + ')';
    }

    public final int getAlbumQuality() {
        return this.albumQuality;
    }

    public final int getAlbumResize() {
        return this.albumResize;
    }

    public final int getCameraQuality() {
        return this.cameraQuality;
    }

    public final int getCameraResize() {
        return this.cameraResize;
    }

    public ImageUploadOptConfig(int r1, int r2, int r3, int r4) {
        this.albumResize = r1;
        this.albumQuality = r2;
        this.cameraResize = r3;
        this.cameraQuality = r4;
    }

    public /* synthetic */ ImageUploadOptConfig(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 1080;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 95;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 95;
    L14:
        this(r2, r3, r4, r5);
    }
}
