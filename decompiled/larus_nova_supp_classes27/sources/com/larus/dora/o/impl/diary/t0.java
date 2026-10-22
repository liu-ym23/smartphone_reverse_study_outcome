package com.larus.dora.o.impl.diary;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\t\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larus/dora/o/impl/diary/ODiaryStyleInfo;", "", "styleType", "", "userDefinedInfo", "", "title", "styleId", "icon", "isSelected", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getStyleType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserDefinedInfo", "()Ljava/lang/String;", "getTitle", "getStyleId", "getIcon", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/dora/o/impl/diary/ODiaryStyleInfo;", "equals", "other", "hashCode", "toString", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t0 {

    @SerializedName("icon")
    private final String icon;

    @SerializedName("is_selected")
    private final Boolean isSelected;

    @SerializedName("style_id")
    private final String styleId;

    @SerializedName("style_type")
    private final Integer styleType;

    @SerializedName("title")
    private final String title;

    @SerializedName("user_defined_info")
    private final String userDefinedInfo;

    public t0() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r6 = (t0) r5;
        if (Intrinsics.areEqual(this.styleType, r6.styleType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userDefinedInfo, r6.userDefinedInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.styleId, r6.styleId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isSelected, r6.isSelected) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.styleType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.userDefinedInfo;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.title;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.styleId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.icon;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.isSelected;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
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

    public final String toString() {
        return "ODiaryStyleInfo(styleType=" + this.styleType + ", userDefinedInfo=" + this.userDefinedInfo + ", title=" + this.title + ", styleId=" + this.styleId + ", icon=" + this.icon + ", isSelected=" + this.isSelected + ')';
    }

    public final String a() {
        return this.icon;
    }

    public final String b() {
        return this.styleId;
    }

    public final Integer c() {
        return this.styleType;
    }

    public final String d() {
        return this.title;
    }

    public final String e() {
        return this.userDefinedInfo;
    }

    public final Boolean f() {
        return this.isSelected;
    }

    public t0(Integer r1, String r2, String r3, String r4, String r5, Boolean r6) {
        this.styleType = r1;
        this.userDefinedInfo = r2;
        this.title = r3;
        this.styleId = r4;
        this.icon = r5;
        this.isSelected = r6;
    }
}
