package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u007f\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006."}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmFeatureDetail;", "Ljava/io/Serializable;", "title", "", "titlePart2", "desc", "descPart2", "content", "", "buyBtnContent", "introLink", "dataTracking", "", "subscriptTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getTitlePart2", "getDesc", "getDescPart2", "getContent", "()Ljava/util/List;", "getBuyBtnContent", "getIntroLink", "getDataTracking", "()Ljava/util/Map;", "getSubscriptTag", "getReplaceTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmFeatureDetail implements Serializable {

    @SerializedName("buy_btn")
    private final String buyBtnContent;

    @SerializedName("content")
    private final List<String> content;

    @SerializedName("data_tracking")
    private final Map<String, String> dataTracking;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("desc_part2")
    private final String descPart2;

    @SerializedName("intro_link")
    private final String introLink;

    @SerializedName("subscript")
    private final String subscriptTag;

    @SerializedName("title")
    private final String title;

    @SerializedName("title_part2")
    private final String titlePart2;

    public MmFeatureDetail() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmFeatureDetail copy$default(MmFeatureDetail r10, String r11, String r12, String r13, String r14, List r15, String r16, String r17, Map r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.title;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.titlePart2;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.desc;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.descPart2;
    L19:
        if ((r20 & 16) == 0) goto L21;
        List r6 = r10.content;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.buyBtnContent;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.introLink;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Map r9 = r10.dataTracking;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.subscriptTag;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.titlePart2;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.descPart2;
    }

    public final List<String> component5() {
        return this.content;
    }

    public final String component6() {
        return this.buyBtnContent;
    }

    public final String component7() {
        return this.introLink;
    }

    public final Map<String, String> component8() {
        return this.dataTracking;
    }

    public final String component9() {
        return this.subscriptTag;
    }

    public final MmFeatureDetail copy(String r12, String r13, String r14, String r15, List<String> r16, String r17, String r18, Map<String, String> r19, String r20) {
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r13, "titlePart2");
        Intrinsics.checkNotNullParameter(r14, "desc");
        Intrinsics.checkNotNullParameter(r15, "descPart2");
        return new MmFeatureDetail(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmFeatureDetail) == true) goto L8;
        return false;
    L8:
        MmFeatureDetail r6 = (MmFeatureDetail) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titlePart2, r6.titlePart2) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.descPart2, r6.descPart2) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buyBtnContent, r6.buyBtnContent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.introLink, r6.introLink) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dataTracking, r6.dataTracking) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.subscriptTag, r6.subscriptTag) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.title.hashCode() * 31) + this.titlePart2.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.descPart2.hashCode()) * 31;
        List<String> r1 = this.content;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.buyBtnContent;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.introLink;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<String, String> r11 = this.dataTracking;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.subscriptTag;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MmFeatureDetail(title=" + this.title + ", titlePart2=" + this.titlePart2 + ", desc=" + this.desc + ", descPart2=" + this.descPart2 + ", content=" + this.content + ", buyBtnContent=" + this.buyBtnContent + ", introLink=" + this.introLink + ", dataTracking=" + this.dataTracking + ", subscriptTag=" + this.subscriptTag + ')';
    }

    public final String getReplaceTitle() {
        return StringsKt.replace$default(this.title, "\\n", "\n", false, 4, null);
    }

    public final String getBuyBtnContent() {
        return this.buyBtnContent;
    }

    public final List<String> getContent() {
        return this.content;
    }

    public final Map<String, String> getDataTracking() {
        return this.dataTracking;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDescPart2() {
        return this.descPart2;
    }

    public final String getIntroLink() {
        return this.introLink;
    }

    public final String getSubscriptTag() {
        return this.subscriptTag;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitlePart2() {
        return this.titlePart2;
    }

    public MmFeatureDetail(String r2, String r3, String r4, String r5, List<String> r6, String r7, String r8, Map<String, String> r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "titlePart2");
        Intrinsics.checkNotNullParameter(r4, "desc");
        Intrinsics.checkNotNullParameter(r5, "descPart2");
        this.title = r2;
        this.titlePart2 = r3;
        this.desc = r4;
        this.descPart2 = r5;
        this.content = r6;
        this.buyBtnContent = r7;
        this.introLink = r8;
        this.dataTracking = r9;
        this.subscriptTag = r10;
    }

    public /* synthetic */ MmFeatureDetail(String r11, String r12, String r13, String r14, List r15, String r16, String r17, Map r18, String r19, int r20, DefaultConstructorMarker r21) {
        String r2 = "";
        if ((r20 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r20 & 8) != 0) goto L18;
        r2 = r14;
    L18:
        String r6 = null;
        if ((r20 & 16) == 0) goto L21;
        List r5 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Map r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r6 = r19;
    L38:
        this(r1, r3, r4, r2, r5, r7, r8, r9, r6);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r5 = r15;
        goto L23
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
