package com.byted.mgl.merge.base.service.protocol.media.entity;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, d2 = {"Lcom/byted/mgl/merge/base/service/protocol/media/entity/ImageInfo;", "", "width", "", "height", "path", "", "type", "orientation", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeight", "()I", "setHeight", "(I)V", "getOrientation", "()Ljava/lang/String;", "setOrientation", "(Ljava/lang/String;)V", "getPath", "setPath", "getType", "setType", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "bdp-appbase_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public final class ImageInfo {
    private int height;
    private String orientation;
    private String path;
    private String type;
    private int width;

    public static /* synthetic */ ImageInfo copy$default(ImageInfo r10, int r11, int r12, String r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.width;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.height;
    L8:
        int r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.path;
    L11:
        String r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.type;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.orientation;
    L17:
        int r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final String component3() {
        return this.path;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.orientation;
    }

    public final ImageInfo copy(int r10, int r11, String r12, String r13, String r14) {
        return new ImageInfo(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ImageInfo) == false) goto L16;
        ImageInfo r11 = (ImageInfo) r10;
        if (this.width == r11.width) goto L8;
        return false;
    L8:
        if (this.height == r11.height) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.path, r11.path) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r11.type) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.orientation, r11.orientation) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = ((this.width * 31) + this.height) * 31;
        String r1 = this.path;
        int r10 = 0;
        if (r1 == null) goto L5;
        int r11 = r1.hashCode();
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.type;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.orientation;
        if (r16 == null) goto L14;
        r10 = r16.hashCode();
    L14:
        return r15 + r10;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        return "ImageInfo(width=" + this.width + ", height=" + this.height + ", path=" + this.path + ", type=" + this.type + ", orientation=" + this.orientation + ")";
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getOrientation() {
        return this.orientation;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setOrientation(String r1) {
        this.orientation = r1;
    }

    public final void setPath(String r1) {
        this.path = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public ImageInfo(int r1, int r10, String r11, String r12, String r13) {
        this.width = r1;
        this.height = r10;
        this.path = r11;
        this.type = r12;
        this.orientation = r13;
    }

    public /* synthetic */ ImageInfo(int r10, int r11, String r12, String r13, String r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L5;
        r14 = "up";
    L5:
        this(r10, r11, r12, r13, r14);
    }
}
