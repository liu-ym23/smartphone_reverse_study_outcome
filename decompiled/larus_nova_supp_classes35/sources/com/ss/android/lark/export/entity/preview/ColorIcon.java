package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ColorIcon;", "Ljava/io/Serializable;", "imageSet", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "faviconUrl", BuildConfig.FLAVOR, "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "getImageSet", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "getFaviconUrl", "()Ljava/lang/String;", "getThemeColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "getUdIcon", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorIcon implements Serializable {
    private final String faviconUrl;
    private final ImageSet imageSet;
    private final ThemeColor themeColor;
    private final UDIcon udIcon;

    public static /* synthetic */ ColorIcon copy$default(ColorIcon r0, ImageSet r1, String r2, ThemeColor r3, UDIcon r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.imageSet;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.faviconUrl;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.themeColor;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.udIcon;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final ImageSet component1() {
        return this.imageSet;
    }

    public final String component2() {
        return this.faviconUrl;
    }

    public final ThemeColor component3() {
        return this.themeColor;
    }

    public final UDIcon component4() {
        return this.udIcon;
    }

    public final ColorIcon copy(ImageSet r2, String r3, ThemeColor r4, UDIcon r5) {
        return new ColorIcon(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ColorIcon) == true) goto L8;
        return false;
    L8:
        ColorIcon r6 = (ColorIcon) r5;
        if (Intrinsics.areEqual(this.imageSet, r6.imageSet) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.faviconUrl, r6.faviconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.themeColor, r6.themeColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.udIcon, r6.udIcon) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        ImageSet r0 = this.imageSet;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.faviconUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ThemeColor r7 = this.themeColor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        UDIcon r10 = this.udIcon;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ColorIcon(imageSet=" + this.imageSet + ", faviconUrl=" + this.faviconUrl + ", themeColor=" + this.themeColor + ", udIcon=" + this.udIcon + ')';
    }

    public final String getFaviconUrl() {
        return this.faviconUrl;
    }

    public final ImageSet getImageSet() {
        return this.imageSet;
    }

    public final ThemeColor getThemeColor() {
        return this.themeColor;
    }

    public final UDIcon getUdIcon() {
        return this.udIcon;
    }

    public ColorIcon(ImageSet r1, String r2, ThemeColor r3, UDIcon r4) {
        this.imageSet = r1;
        this.faviconUrl = r2;
        this.themeColor = r3;
        this.udIcon = r4;
    }
}
