package com.bytedance.android.ec.core.imagex.opt;

import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/g0;", "", "", "originResizeWidth", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "originResizeHeight", "a", "useScale", "d", "specificScale", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {
    public static Integer d;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    @SerializedName("resize_height")
    private final Integer originResizeHeight;

    @SerializedName("resize_width")
    private final Integer originResizeWidth;

    @SerializedName("specific_scale")
    private final Integer specificScale;

    @SerializedName("use_scale")
    private final Integer useScale;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof g0) == false) goto L14;
        g0 r11 = (g0) r10;
        if (Intrinsics.areEqual(this.originResizeWidth, r11.originResizeWidth) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.originResizeHeight, r11.originResizeHeight) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.useScale, r11.useScale) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.specificScale, r11.specificScale) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.originResizeWidth;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Integer r12 = this.originResizeHeight;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Integer r15 = this.useScale;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.specificScale;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return r17 + r1;
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageXModifyResize(originResizeWidth=" + this.originResizeWidth + ", originResizeHeight=" + this.originResizeHeight + ", useScale=" + this.useScale + ", specificScale=" + this.specificScale + ")";
    }

    public g0() {
        this.originResizeWidth = null;
        this.originResizeHeight = null;
        this.useScale = null;
        this.specificScale = null;
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.PUBLICATION;
        this.a = LazyKt.lazy(r0, new ImageXModifyResize$scale$2(this));
        this.b = LazyKt.lazy(r0, new ImageXModifyResize$resizeWidth$2(this));
        this.c = LazyKt.lazy(r0, new ImageXModifyResize$resizeHeight$2(this));
    }

    public final Integer a() {
        return this.originResizeHeight;
    }

    public final Integer b() {
        return this.originResizeWidth;
    }

    public final Integer c() {
        return this.specificScale;
    }

    public final Integer d() {
        return this.useScale;
    }
}
