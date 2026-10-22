package com.bytedance.sdk.xbridge.cn.runtime.depend;

import ai.j0;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PageTitleBar;", "", Constant.TITLE, "", "titleColor", "navBarColor", "navBtnType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNavBarColor", "()Ljava/lang/String;", "getNavBtnType", "getTitle", "getTitleColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PageTitleBar {
    private final String navBarColor;
    private final String navBtnType;
    private final String title;
    private final String titleColor;

    public PageTitleBar() {
        String r5 = null;
        String r10 = null;
        String r11 = null;
        String r12 = null;
        this(r5, r10, r11, r12, 15, null);
    }

    public static /* synthetic */ PageTitleBar copy$default(PageTitleBar r5, String r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.title;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.titleColor;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.navBarColor;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.navBtnType;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.titleColor;
    }

    public final String component3() {
        return this.navBarColor;
    }

    public final String component4() {
        return this.navBtnType;
    }

    public final PageTitleBar copy(String r5, String r10, String r11, String r12) {
        return new PageTitleBar(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PageTitleBar) == true) goto L8;
        return false;
    L8:
        PageTitleBar r10 = (PageTitleBar) r5;
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleColor, r10.titleColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.navBarColor, r10.navBarColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.navBtnType, r10.navBtnType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getNavBarColor() {
        return this.navBarColor;
    }

    public final String getNavBtnType() {
        return this.navBtnType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleColor() {
        return this.titleColor;
    }

    public int hashCode() {
        String r5 = this.title;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.titleColor;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.navBarColor;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.navBtnType;
        if (r19 == null) goto L19;
        r10 = r19.hashCode();
    L19:
        return r18 + r10;
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("PageTitleBar(title=");
        r5.append(this.title);
        r5.append(", titleColor=");
        r5.append(this.titleColor);
        r5.append(", navBarColor=");
        r5.append(this.navBarColor);
        r5.append(", navBtnType=");
        return j0.p(r5, this.navBtnType, ')');
    }

    public PageTitleBar(String r5, String r10, String r11, String r12) {
        this.title = r5;
        this.titleColor = r10;
        this.navBarColor = r11;
        this.navBtnType = r12;
    }

    public /* synthetic */ PageTitleBar(String r5, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = null;
    L12:
        if ((r13 & 8) == 0) goto L14;
        r12 = null;
    L14:
        this(r5, r10, r11, r12);
    }
}
