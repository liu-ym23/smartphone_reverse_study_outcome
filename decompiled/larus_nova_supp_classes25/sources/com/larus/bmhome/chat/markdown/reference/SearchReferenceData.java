package com.larus.bmhome.chat.markdown.reference;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Reference;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\u0090\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\"¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/SearchReferenceData;", "", "title", "", "reference", "", "Lcom/larus/im/bean/message/Reference;", "queries", "searchLoadingText", "stage", "", "idx", "icon", "iconDark", "toolType", "isHeaderWrapContent", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getReference", "()Ljava/util/List;", "getQueries", "getSearchLoadingText", "getStage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIdx", "getIcon", "getIconDark", "getToolType", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/larus/bmhome/chat/markdown/reference/SearchReferenceData;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchReferenceData {

    @SerializedName("icon")
    private final String icon;

    @SerializedName("icon_dark")
    private final String iconDark;

    @SerializedName("idx")
    private final Integer idx;

    @SerializedName("is_header_wrap_content")
    private final boolean isHeaderWrapContent;

    @SerializedName("queries")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> queries;

    @SerializedName("data")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Reference> reference;

    @SerializedName("search_loading_text")
    private final String searchLoadingText;

    @SerializedName("stage")
    private final Integer stage;

    @SerializedName("title")
    private String title;

    @SerializedName("tool_type")
    private final String toolType;

    public SearchReferenceData() {
        this(null, null, null, null, null, null, null, null, null, false, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchReferenceData copy$default(SearchReferenceData r11, String r12, List r13, List r14, String r15, Integer r16, Integer r17, String r18, String r19, String r20, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.title;
    L7:
        if ((r22 & 2) == 0) goto L9;
        List r3 = r11.reference;
    L11:
        if ((r22 & 4) == 0) goto L13;
        List r4 = r11.queries;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.searchLoadingText;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Integer r6 = r11.stage;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Integer r7 = r11.idx;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.icon;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.iconDark;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.toolType;
    L39:
        if ((r22 & 512) == 0) goto L41;
        boolean r1 = r11.isHeaderWrapContent;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component10() {
        return this.isHeaderWrapContent;
    }

    public final List<Reference> component2() {
        return this.reference;
    }

    public final List<String> component3() {
        return this.queries;
    }

    public final String component4() {
        return this.searchLoadingText;
    }

    public final Integer component5() {
        return this.stage;
    }

    public final Integer component6() {
        return this.idx;
    }

    public final String component7() {
        return this.icon;
    }

    public final String component8() {
        return this.iconDark;
    }

    public final String component9() {
        return this.toolType;
    }

    public final SearchReferenceData copy(String r13, List<Reference> r14, List<String> r15, String r16, Integer r17, Integer r18, String r19, String r20, String r21, boolean r22) {
        return new SearchReferenceData(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SearchReferenceData) == true) goto L8;
        return false;
    L8:
        SearchReferenceData r6 = (SearchReferenceData) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reference, r6.reference) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queries, r6.queries) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.searchLoadingText, r6.searchLoadingText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.stage, r6.stage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.idx, r6.idx) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.iconDark, r6.iconDark) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.toolType, r6.toolType) == true) goto L36;
        return false;
    L36:
        if (this.isHeaderWrapContent == r6.isHeaderWrapContent) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Reference> r4 = this.reference;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.queries;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.searchLoadingText;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.stage;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.idx;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.icon;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.iconDark;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.toolType;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        int r26 = (r24 + r1) * 31;
        if (this.isHeaderWrapContent == false) goto L41;
        int r27 = 1231;
    L43:
        return r26 + r27;
    L41:
        r27 = 1237;
        goto L43
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
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

    public String toString() {
        return "SearchReferenceData(title=" + this.title + ", reference=" + this.reference + ", queries=" + this.queries + ", searchLoadingText=" + this.searchLoadingText + ", stage=" + this.stage + ", idx=" + this.idx + ", icon=" + this.icon + ", iconDark=" + this.iconDark + ", toolType=" + this.toolType + ", isHeaderWrapContent=" + this.isHeaderWrapContent + ')';
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconDark() {
        return this.iconDark;
    }

    public final Integer getIdx() {
        return this.idx;
    }

    public final List<String> getQueries() {
        return this.queries;
    }

    public final List<Reference> getReference() {
        return this.reference;
    }

    public final String getSearchLoadingText() {
        return this.searchLoadingText;
    }

    public final Integer getStage() {
        return this.stage;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToolType() {
        return this.toolType;
    }

    public final boolean isHeaderWrapContent() {
        return this.isHeaderWrapContent;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public SearchReferenceData(String r1, List<Reference> r2, List<String> r3, String r4, Integer r5, Integer r6, String r7, String r8, String r9, boolean r10) {
        this.title = r1;
        this.reference = r2;
        this.queries = r3;
        this.searchLoadingText = r4;
        this.stage = r5;
        this.idx = r6;
        this.icon = r7;
        this.iconDark = r8;
        this.toolType = r9;
        this.isHeaderWrapContent = r10;
    }

    public /* synthetic */ SearchReferenceData(String r12, List r13, List r14, String r15, Integer r16, Integer r17, String r18, String r19, String r20, boolean r21, int r22, DefaultConstructorMarker r23) {
        String r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        List r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Integer r6 = -1;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Integer r7 = -1;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & 256) != 0) goto L39;
        r2 = r20;
    L39:
        if ((r22 & 512) == 0) goto L41;
        boolean r0 = false;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2, r0);
        return;
    L41:
        r0 = r21;
        goto L42
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
