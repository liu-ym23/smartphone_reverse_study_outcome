package com.ss.android.lark.export.entity.preview;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0016J\u0006\u0010\u0018\u001a\u00020\u0000J$\u0010\u0019\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0000J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u001aHÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006'"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UDIcon;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "key", BuildConfig.FLAVOR, "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "unicode", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getThemeColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setThemeColor", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getUnicode", "setUnicode", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "clone", "patchData", BuildConfig.FLAVOR, "previewData", "Lcom/ss/android/lark/export/entity/preview/PreviewData;", "udIcon", "component1", "component2", "component3", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDIcon implements Serializable, b<UDIcon> {
    private String key;
    private ThemeColor themeColor;
    private String unicode;

    public UDIcon() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UDIcon copy$default(UDIcon r0, String r1, ThemeColor r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.key;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.themeColor;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.unicode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.key;
    }

    public final ThemeColor component2() {
        return this.themeColor;
    }

    public final String component3() {
        return this.unicode;
    }

    public final UDIcon copy(String r2, ThemeColor r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return new UDIcon(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UDIcon) == true) goto L8;
        return false;
    L8:
        UDIcon r6 = (UDIcon) r5;
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.themeColor, r6.themeColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.unicode, r6.unicode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.key.hashCode() * 31;
        ThemeColor r1 = this.themeColor;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.unicode;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "UDIcon(key=" + this.key + ", themeColor=" + this.themeColor + ", unicode=" + this.unicode + ')';
    }

    public final UDIcon clone() {
        String r1 = this.key;
        ThemeColor r2 = this.themeColor;
        if (r2 == null) goto L5;
        ThemeColor r3 = r2.clone();
    L7:
        return new UDIcon(r1, r3, this.unicode);
    L5:
        r3 = null;
        goto L7
    }

    public final String getKey() {
        return this.key;
    }

    public final ThemeColor getThemeColor() {
        return this.themeColor;
    }

    public final String getUnicode() {
        return this.unicode;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((UDIcon) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((UDIcon) r1);
    }

    public final void setKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.key = r2;
    }

    public final void setThemeColor(ThemeColor r1) {
        this.themeColor = r1;
    }

    public final void setUnicode(String r1) {
        this.unicode = r1;
    }

    public boolean isContentSame(UDIcon r1) {
        return Intrinsics.areEqual(this, r1);
    }

    public boolean isItemSame(UDIcon r1) {
        return Intrinsics.areEqual(this, r1);
    }

    public UDIcon(String r2, ThemeColor r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.themeColor = r3;
        this.unicode = r4;
    }

    public final UDIcon patchData(int r9, PreviewData r10, UDIcon r11) {
        if (r9 != ComponentAttribute.ud_icon_key.getValue()) goto L20;
        String r12 = BuildConfig.FLAVOR;
        if (r11 == null) goto L7;
        if (r10 == null) goto L19;
        String r13 = r10.getString();
        if (r13 == null) goto L19;
        r12 = r13;
    L19:
        r11.key = r12;
    L40:
        return r11;
    L7:
        if (r10 == null) goto L12;
        String r14 = r10.getString();
        if (r14 == null) goto L12;
        String r1 = r14;
    L13:
        r11 = new UDIcon(r1, null, null, 6, null);
    L12:
        r1 = BuildConfig.FLAVOR;
        goto L13
    L20:
        String r2 = null;
        ThemeColor r3 = null;
        ThemeColor r4 = null;
        String r5 = null;
        if (r9 != ComponentAttribute.ud_icon_theme_color.getValue()) goto L31;
        if (r11 != null) goto L27;
        String r6 = null;
        if (r10 == null) goto L26;
        r3 = r10.getThemeColor();
    L26:
        r11 = new UDIcon(r6, r3, null, 5, null);
        goto L40
    L27:
        if (r10 == null) goto L29;
        r4 = r10.getThemeColor();
    L29:
        r11.themeColor = r4;
        goto L40
    L31:
        if (r9 != ComponentAttribute.unicode.getValue()) goto L40;
        if (r11 != null) goto L37;
        String r7 = null;
        ThemeColor r8 = null;
        if (r10 == null) goto L36;
        r5 = r10.getString();
    L36:
        r11 = new UDIcon(r7, r8, r5, 3, null);
        goto L40
    L37:
        if (r10 == null) goto L39;
        r2 = r10.getString();
    L39:
        r11.unicode = r2;
        goto L40
    }

    public /* synthetic */ UDIcon(String r2, ThemeColor r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = BuildConfig.FLAVOR;
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
