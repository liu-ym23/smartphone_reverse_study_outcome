package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0000J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Border;", "Ljava/io/Serializable;", "width", BuildConfig.FLAVOR, "cornerRadius", "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getWidth", "()Ljava/lang/Float;", "setWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getCornerRadius", "setCornerRadius", "getThemeColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setThemeColor", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "clone", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "component1", "component2", "component3", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Lcom/ss/android/lark/export/entity/preview/ThemeColor;)Lcom/ss/android/lark/export/entity/preview/Border;", "toString", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Border implements Serializable {
    private Float cornerRadius;
    private ThemeColor themeColor;
    private Float width;

    public Border() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Border copy$default(Border r0, Float r1, Float r2, ThemeColor r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.width;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.cornerRadius;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.themeColor;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Float component1() {
        return this.width;
    }

    public final Float component2() {
        return this.cornerRadius;
    }

    public final ThemeColor component3() {
        return this.themeColor;
    }

    public final Border copy(Float r2, Float r3, ThemeColor r4) {
        return new Border(r2, r3, r4);
    }

    public String toString() {
        return "Border(width=" + this.width + ", cornerRadius=" + this.cornerRadius + ", themeColor=" + this.themeColor + ')';
    }

    public final Border clone() {
        Float r1 = this.width;
        Float r2 = this.cornerRadius;
        ThemeColor r3 = this.themeColor;
        if (r3 == null) goto L5;
        ThemeColor r4 = r3.clone();
    L7:
        return new Border(r1, r2, r4);
    L5:
        r4 = null;
        goto L7
    }

    public int hashCode() {
        Float r0 = this.width;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Float r4 = this.cornerRadius;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ThemeColor r7 = this.themeColor;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    public final ThemeColor getThemeColor() {
        return this.themeColor;
    }

    public final Float getWidth() {
        return this.width;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Border) == true) goto L8;
        return false;
    L8:
        Border r6 = (Border) r5;
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cornerRadius, r6.cornerRadius) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.themeColor, r6.themeColor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final void setCornerRadius(Float r1) {
        this.cornerRadius = r1;
    }

    public final void setThemeColor(ThemeColor r1) {
        this.themeColor = r1;
    }

    public final void setWidth(Float r1) {
        this.width = r1;
    }

    public Border(Float r1, Float r2, ThemeColor r3) {
        this.width = r1;
        this.cornerRadius = r2;
        this.themeColor = r3;
    }

    public /* synthetic */ Border(Float r2, Float r3, ThemeColor r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
