package com.larus.platform.model.camera.ve;

import android.graphics.Bitmap;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006*"}, d2 = {"Lcom/larus/platform/model/camera/ve/VeCameraOutputParam;", "Ljava/io/Serializable;", "<init>", "()V", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "isPhoto", "", "()Z", "setPhoto", "(Z)V", "photoBitmap", "Landroid/graphics/Bitmap;", "getPhotoBitmap", "()Landroid/graphics/Bitmap;", "setPhotoBitmap", "(Landroid/graphics/Bitmap;)V", "width", "", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "size", "", "getSize", "()J", "setSize", "(J)V", "equals", "other", "", "hashCode", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class VeCameraOutputParam implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private int height;
    private boolean isPhoto;
    private String path;
    private Bitmap photoBitmap;
    private long size;
    private int width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "path=" + this.path + ",isPhoto=" + this.isPhoto + ",width=" + this.width + ",height=" + this.height + ",size=" + this.size;
    }

    public VeCameraOutputParam() {
        this.path = "";
        this.isPhoto = true;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getPath() {
        return this.path;
    }

    public final Bitmap getPhotoBitmap() {
        return this.photoBitmap;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isPhoto() {
        return this.isPhoto;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof VeCameraOutputParam) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toString(), ((VeCameraOutputParam) r2).toString());
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.path = r2;
    }

    public final void setPhoto(boolean r1) {
        this.isPhoto = r1;
    }

    public final void setPhotoBitmap(Bitmap r1) {
        this.photoBitmap = r1;
    }

    public final void setSize(long r1) {
        this.size = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }
}
