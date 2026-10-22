package com.ss.android.lark.keyboard.base;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/keyboard/base/ImageCompressInfo;", "Ljava/io/Serializable;", "compressPath", "", "width", "", "height", "<init>", "(Ljava/lang/String;II)V", "getCompressPath", "()Ljava/lang/String;", "setCompressPath", "(Ljava/lang/String;)V", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "component1", "component2", "component3", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "toString", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageCompressInfo implements Serializable {
    private String compressPath;
    private int height;
    private int width;

    public ImageCompressInfo() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ ImageCompressInfo copy$default(ImageCompressInfo r0, String r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.compressPath;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.width;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.height;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.compressPath;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final ImageCompressInfo copy(String r2, int r3, int r4) {
        return new ImageCompressInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageCompressInfo) == true) goto L8;
        return false;
    L8:
        ImageCompressInfo r6 = (ImageCompressInfo) r5;
        if (Intrinsics.areEqual(this.compressPath, r6.compressPath) == true) goto L12;
        return false;
    L12:
        if (this.width == r6.width) goto L15;
        return false;
    L15:
        if (this.height == r6.height) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.compressPath;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.width) * 31) + this.height;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ImageCompressInfo(compressPath=" + this.compressPath + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final String getCompressPath() {
        return this.compressPath;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setCompressPath(String r1) {
        this.compressPath = r1;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public ImageCompressInfo(String r1, int r2, int r3) {
        this.compressPath = r1;
        this.width = r2;
        this.height = r3;
    }

    public /* synthetic */ ImageCompressInfo(String r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
