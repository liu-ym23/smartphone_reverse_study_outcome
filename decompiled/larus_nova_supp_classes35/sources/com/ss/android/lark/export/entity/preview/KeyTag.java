package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u0000J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/KeyTag;", "Ljava/io/Serializable;", "tag", BuildConfig.FLAVOR, "textColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "backgroundColor", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getTag", "()Ljava/lang/String;", "getTextColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "getBackgroundColor", "clone", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyTag implements Serializable {
    private final ThemeColor backgroundColor;
    private final String tag;
    private final ThemeColor textColor;

    public static /* synthetic */ KeyTag copy$default(KeyTag r0, String r1, ThemeColor r2, ThemeColor r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.tag;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.textColor;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.backgroundColor;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.tag;
    }

    public final ThemeColor component2() {
        return this.textColor;
    }

    public final ThemeColor component3() {
        return this.backgroundColor;
    }

    public final KeyTag copy(String r2, ThemeColor r3, ThemeColor r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return new KeyTag(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KeyTag) == true) goto L8;
        return false;
    L8:
        KeyTag r6 = (KeyTag) r5;
        if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.tag.hashCode() * 31;
        ThemeColor r1 = this.textColor;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ThemeColor r5 = this.backgroundColor;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "KeyTag(tag=" + this.tag + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ')';
    }

    public final KeyTag clone() {
        String r1 = this.tag;
        ThemeColor r2 = this.textColor;
        ThemeColor r3 = null;
        if (r2 == null) goto L5;
        ThemeColor r4 = r2.clone();
    L6:
        ThemeColor r5 = this.backgroundColor;
        if (r5 == null) goto L10;
        r3 = r5.clone();
    L10:
        return new KeyTag(r1, r4, r3);
    L5:
        r4 = null;
        goto L6
    }

    public final ThemeColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getTag() {
        return this.tag;
    }

    public final ThemeColor getTextColor() {
        return this.textColor;
    }

    public KeyTag(String r2, ThemeColor r3, ThemeColor r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.tag = r2;
        this.textColor = r3;
        this.backgroundColor = r4;
    }

    public /* synthetic */ KeyTag(String r1, ThemeColor r2, ThemeColor r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        this(r1, r2, r3);
    }
}
