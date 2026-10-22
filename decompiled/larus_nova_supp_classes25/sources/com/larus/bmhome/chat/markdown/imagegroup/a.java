package com.larus.bmhome.chat.markdown.imagegroup;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014Jh\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0007\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\t\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\"\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagegroup/ImageGroupData;", "", "imageShowType", "", "images", "", "Lcom/larus/im/bean/message/SearchImageInfo;", "isPlaceholder", "", "isEmptySearch", "imageShowTypeVersion", "forbiddenPadding", "isTop", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getImageShowType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImages", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageShowTypeVersion", "getForbiddenPadding", "setTop", "(Ljava/lang/Boolean;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/markdown/imagegroup/ImageGroupData;", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class a {

    @SerializedName("forbidden_padding")
    private final Boolean forbiddenPadding;

    @SerializedName("image_show_type")
    private final Integer imageShowType;

    @SerializedName("image_show_type_version")
    private final Integer imageShowTypeVersion;

    @SerializedName("images")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<SearchImageInfo> images;

    @SerializedName("is_empty_search")
    private final Boolean isEmptySearch;

    @SerializedName("is_placeholder")
    private final Boolean isPlaceholder;

    @SerializedName("is_top")
    private Boolean isTop;

    public a() {
        this(null, null, null, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.imageShowType, r6.imageShowType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.images, r6.images) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isPlaceholder, r6.isPlaceholder) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isEmptySearch, r6.isEmptySearch) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageShowTypeVersion, r6.imageShowTypeVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.forbiddenPadding, r6.forbiddenPadding) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isTop, r6.isTop) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.imageShowType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<SearchImageInfo> r4 = this.images;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.isPlaceholder;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isEmptySearch;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.imageShowTypeVersion;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.forbiddenPadding;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.isTop;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "ImageGroupData(imageShowType=" + this.imageShowType + ", images=" + this.images + ", isPlaceholder=" + this.isPlaceholder + ", isEmptySearch=" + this.isEmptySearch + ", imageShowTypeVersion=" + this.imageShowTypeVersion + ", forbiddenPadding=" + this.forbiddenPadding + ", isTop=" + this.isTop + ')';
    }

    public final Integer b() {
        return this.imageShowType;
    }

    public final List<SearchImageInfo> c() {
        return this.images;
    }

    public final Boolean d() {
        return this.isTop;
    }

    public static a a(a r8, List r9) {
        Integer r1 = r8.imageShowType;
        Boolean r3 = r8.isPlaceholder;
        Boolean r4 = r8.isEmptySearch;
        Integer r5 = r8.imageShowTypeVersion;
        Boolean r6 = r8.forbiddenPadding;
        Boolean r7 = r8.isTop;
        r8.getClass();
        return new a(r1, r9, r3, r4, r5, r6, r7);
    }

    public /* synthetic */ a(Integer r11, List r12, Integer r13, Boolean r14, int r15) {
        Boolean r1 = null;
        if ((r15 & 1) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        List r4 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        Boolean r5 = Boolean.FALSE;
    L15:
        if ((r15 & 8) == 0) goto L17;
        Boolean r6 = Boolean.FALSE;
    L19:
        if ((r15 & 16) == 0) goto L21;
        r13 = 0;
    L21:
        Integer r7 = r13;
        if ((r15 & 32) == 0) goto L24;
        r1 = Boolean.FALSE;
    L24:
        Boolean r8 = r1;
        if ((r15 & 64) == 0) goto L27;
        r14 = Boolean.FALSE;
    L27:
        this(r3, r4, r5, r6, r7, r8, r14);
        return;
    L17:
        r6 = null;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public a(Integer r1, List<SearchImageInfo> r2, Boolean r3, Boolean r4, Integer r5, Boolean r6, Boolean r7) {
        this.imageShowType = r1;
        this.images = r2;
        this.isPlaceholder = r3;
        this.isEmptySearch = r4;
        this.imageShowTypeVersion = r5;
        this.forbiddenPadding = r6;
        this.isTop = r7;
    }
}
