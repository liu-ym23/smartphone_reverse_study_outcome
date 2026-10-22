package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/title/MenuItemSrc;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "itemId", BuildConfig.FLAVOR, "udIconKey", "imageBase64", "badgeStyle", "badgeText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBadgeStyle", "()Ljava/lang/String;", "getBadgeText", "getImageBase64", "getItemId", "getUdIconKey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "getBadgeNum", BuildConfig.FLAVOR, "hashCode", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MenuItemSrc implements NonProguard {
    private final String badgeStyle;
    private final String badgeText;
    private final String imageBase64;
    private final String itemId;
    private final String udIconKey;

    public static /* synthetic */ MenuItemSrc copy$default(MenuItemSrc r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.itemId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.udIconKey;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.imageBase64;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.badgeStyle;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.badgeText;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.itemId;
    }

    public final String component2() {
        return this.udIconKey;
    }

    public final String component3() {
        return this.imageBase64;
    }

    public final String component4() {
        return this.badgeStyle;
    }

    public final String component5() {
        return this.badgeText;
    }

    public final MenuItemSrc copy(String r8, String r9, String r10, String r11, String r12) {
        return new MenuItemSrc(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MenuItemSrc) == true) goto L8;
        return false;
    L8:
        MenuItemSrc r6 = (MenuItemSrc) r5;
        if (Intrinsics.areEqual(this.itemId, r6.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.udIconKey, r6.udIconKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageBase64, r6.imageBase64) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.badgeStyle, r6.badgeStyle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.badgeText, r6.badgeText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getBadgeNum() {
        String r1 = this.badgeStyle;     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(r1, WebappBadgeStyle.NUM.getValue()) == false) goto L9;
        String r2 = this.badgeText;     // Catch: Throwable -> L21
        if (r2 != null) goto L24;
        return -1;
    L24:
        return CastIntegerProtector.parseInt(r2);
    L9:
        if (Intrinsics.areEqual(r1, WebappBadgeStyle.DOT.getValue()) == false) goto L25;
        String r3 = this.badgeText;     // Catch: Throwable -> L21
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L20;
        return 1;
    L20:
        return CastIntegerProtector.parseInt(this.badgeText);
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
        goto L17
    L25:
        return -1;
    L27:
        return -1;
    }

    public int hashCode() {
        String r0 = this.itemId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.udIconKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.imageBase64;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.badgeStyle;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.badgeText;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "MenuItemSrc(itemId=" + this.itemId + ", udIconKey=" + this.udIconKey + ", imageBase64=" + this.imageBase64 + ", badgeStyle=" + this.badgeStyle + ", badgeText=" + this.badgeText + ')';
    }

    public final String getBadgeStyle() {
        return this.badgeStyle;
    }

    public final String getBadgeText() {
        return this.badgeText;
    }

    public final String getImageBase64() {
        return this.imageBase64;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getUdIconKey() {
        return this.udIconKey;
    }

    public MenuItemSrc(String r1, String r2, String r3, String r4, String r5) {
        this.itemId = r1;
        this.udIconKey = r2;
        this.imageBase64 = r3;
        this.badgeStyle = r4;
        this.badgeText = r5;
    }

    public /* synthetic */ MenuItemSrc(String r8, String r9, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        String r6 = null;
    L14:
        this(r8, r9, r4, r5, r6);
        return;
    L13:
        r6 = r12;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
