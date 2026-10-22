package com.larus.camera.api.params;

import android.graphics.Bitmap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020\u0000H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/larus/camera/api/params/ImageParam;", "Lcom/larus/camera/api/params/BaseResultParam;", "<init>", "()V", "isPhotoMarked", "", "()Z", "setPhotoMarked", "(Z)V", "isPhotoCropped", "setPhotoCropped", "isAiCreation", "setAiCreation", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "markedMaskBitmap", "getMarkedMaskBitmap", "setMarkedMaskBitmap", "rotation", "", "getRotation", "()I", "setRotation", "(I)V", "detectIntent", "getDetectIntent", "setDetectIntent", "bitmapChangedTime", "", "getBitmapChangedTime", "()J", "setBitmapChangedTime", "(J)V", "clone", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageParam extends BaseResultParam {
    public transient Bitmap a;
    public transient Bitmap b;
    private long bitmapChangedTime;
    private int detectIntent;
    private boolean isAiCreation;
    private boolean isPhotoCropped;
    private boolean isPhotoMarked;
    private int rotation;

    @Override // com.larus.camera.api.params.BaseResultParam
    public ImageParam clone() {
        ImageParam r0 = new ImageParam();
        r0.setCreatedTime(getCreatedTime());
        r0.setPath(getPath());
        r0.isPhotoMarked = this.isPhotoMarked;
        r0.isPhotoCropped = this.isPhotoCropped;
        r0.isAiCreation = this.isAiCreation;
        r0.setWidth(getWidth());
        r0.setHeight(getHeight());
        r0.setSize(getSize());
        r0.a = this.a;
        r0.b = this.b;
        r0.rotation = this.rotation;
        r0.detectIntent = this.detectIntent;
        r0.bitmapChangedTime = this.bitmapChangedTime;
        return r0;
    }

    public String toString() {
        return "[createTime=" + getCreatedTime() + ", path=" + getPath() + ", width=" + getWidth() + ",height=" + getHeight() + ",size=" + getSize() + " bitmapChangedTime=" + this.bitmapChangedTime + ']';
    }

    public ImageParam() {
        this.bitmapChangedTime = getCreatedTime();
    }

    public final Bitmap getBitmap() {
        return this.a;
    }

    public final long getBitmapChangedTime() {
        return this.bitmapChangedTime;
    }

    public final int getDetectIntent() {
        return this.detectIntent;
    }

    public final Bitmap getMarkedMaskBitmap() {
        return this.b;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final boolean isAiCreation() {
        return this.isAiCreation;
    }

    public final boolean isPhotoCropped() {
        return this.isPhotoCropped;
    }

    public final boolean isPhotoMarked() {
        return this.isPhotoMarked;
    }

    @Override // com.larus.camera.api.params.BaseResultParam
    public /* bridge */ /* synthetic */ BaseResultParam clone() {
        return clone();
    }

    public final void setAiCreation(boolean r1) {
        this.isAiCreation = r1;
    }

    public final void setBitmap(Bitmap r1) {
        this.a = r1;
    }

    public final void setBitmapChangedTime(long r1) {
        this.bitmapChangedTime = r1;
    }

    public final void setDetectIntent(int r1) {
        this.detectIntent = r1;
    }

    public final void setMarkedMaskBitmap(Bitmap r1) {
        this.b = r1;
    }

    public final void setPhotoCropped(boolean r1) {
        this.isPhotoCropped = r1;
    }

    public final void setPhotoMarked(boolean r1) {
        this.isPhotoMarked = r1;
    }

    public final void setRotation(int r1) {
        this.rotation = r1;
    }
}
