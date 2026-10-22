package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J}\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006-"}, d2 = {"Lcom/larus/bmhome/chat/resp/CommonNoticeData;", "", "leftButton", "Lcom/larus/bmhome/chat/resp/Button;", "title", "", "titleSchema", "titleTargetPage", "body", "boldBodyRangeList", "", "Lcom/larus/bmhome/chat/resp/Range;", "schema", "targetPage", "rightButton", "<init>", "(Lcom/larus/bmhome/chat/resp/Button;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/Button;)V", "getLeftButton", "()Lcom/larus/bmhome/chat/resp/Button;", "getTitle", "()Ljava/lang/String;", "getTitleSchema", "getTitleTargetPage", "getBody", "getBoldBodyRangeList", "()Ljava/util/List;", "getSchema", "getTargetPage", "getRightButton", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CommonNoticeData {

    @SerializedName("body")
    private final String body;

    @SerializedName("bold_body_range_list")
    private final List<Range> boldBodyRangeList;

    @SerializedName("left_button")
    private final Button leftButton;

    @SerializedName("right_button")
    private final Button rightButton;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("target_page")
    private final String targetPage;

    @SerializedName("title")
    private final String title;

    @SerializedName("title_schema")
    private final String titleSchema;

    @SerializedName("title_target_page")
    private final String titleTargetPage;

    public CommonNoticeData() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonNoticeData copy$default(CommonNoticeData r10, Button r11, String r12, String r13, String r14, String r15, List r16, String r17, String r18, Button r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        Button r2 = r10.leftButton;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.title;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.titleSchema;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.titleTargetPage;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.body;
    L23:
        if ((r20 & 32) == 0) goto L25;
        List r7 = r10.boldBodyRangeList;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.schema;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = r10.targetPage;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Button r1 = r10.rightButton;
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

    public final Button component1() {
        return this.leftButton;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.titleSchema;
    }

    public final String component4() {
        return this.titleTargetPage;
    }

    public final String component5() {
        return this.body;
    }

    public final List<Range> component6() {
        return this.boldBodyRangeList;
    }

    public final String component7() {
        return this.schema;
    }

    public final String component8() {
        return this.targetPage;
    }

    public final Button component9() {
        return this.rightButton;
    }

    public final CommonNoticeData copy(Button r12, String r13, String r14, String r15, String r16, List<Range> r17, String r18, String r19, Button r20) {
        return new CommonNoticeData(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CommonNoticeData) == true) goto L8;
        return false;
    L8:
        CommonNoticeData r6 = (CommonNoticeData) r5;
        if (Intrinsics.areEqual(this.leftButton, r6.leftButton) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.titleSchema, r6.titleSchema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.titleTargetPage, r6.titleTargetPage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.body, r6.body) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.boldBodyRangeList, r6.boldBodyRangeList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.schema, r6.schema) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.targetPage, r6.targetPage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.rightButton, r6.rightButton) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Button r0 = this.leftButton;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.titleSchema;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.titleTargetPage;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.body;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<Range> r16 = this.boldBodyRangeList;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.schema;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.targetPage;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Button r25 = this.rightButton;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
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
        return "CommonNoticeData(leftButton=" + this.leftButton + ", title=" + this.title + ", titleSchema=" + this.titleSchema + ", titleTargetPage=" + this.titleTargetPage + ", body=" + this.body + ", boldBodyRangeList=" + this.boldBodyRangeList + ", schema=" + this.schema + ", targetPage=" + this.targetPage + ", rightButton=" + this.rightButton + ')';
    }

    public final String getBody() {
        return this.body;
    }

    public final List<Range> getBoldBodyRangeList() {
        return this.boldBodyRangeList;
    }

    public final Button getLeftButton() {
        return this.leftButton;
    }

    public final Button getRightButton() {
        return this.rightButton;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getTargetPage() {
        return this.targetPage;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleSchema() {
        return this.titleSchema;
    }

    public final String getTitleTargetPage() {
        return this.titleTargetPage;
    }

    public CommonNoticeData(Button r1, String r2, String r3, String r4, String r5, List<Range> r6, String r7, String r8, Button r9) {
        this.leftButton = r1;
        this.title = r2;
        this.titleSchema = r3;
        this.titleTargetPage = r4;
        this.body = r5;
        this.boldBodyRangeList = r6;
        this.schema = r7;
        this.targetPage = r8;
        this.rightButton = r9;
    }

    public /* synthetic */ CommonNoticeData(Button r11, String r12, String r13, String r14, String r15, List r16, String r17, String r18, Button r19, int r20, DefaultConstructorMarker r21) {
        Button r2 = null;
        if ((r20 & 1) == 0) goto L5;
        Button r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
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
        r1 = r11;
        goto L7
    }
}
