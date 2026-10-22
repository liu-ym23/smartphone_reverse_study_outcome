package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010 \u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012(\b\u0002\u0010#\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0018¢\u0006\u0004\bB\u0010CJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u0012\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003J)\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0018HÆ\u0003JÄ\u0001\u0010$\u001a\u00020\u00002\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\u001b\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u001d\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\u0010\b\u0002\u0010\u001e\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010 \u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00152(\b\u0002\u0010#\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0018HÆ\u0001¢\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020'HÖ\u0001J\u0013\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001f\u0010\u001a\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b,\u0010\u0007R\u001f\u0010\u001b\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b1\u00102R\u001f\u0010\u001d\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b3\u0010/R\u001f\u0010\u001e\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0006¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b5\u00106R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b7\u00102R\u001f\u0010 \u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b8\u0010/R\u0019\u0010!\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b!\u00109\u001a\u0004\b:\u0010;R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\b=\u0010>R7\u0010#\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00188\u0006¢\u0006\f\n\u0004\b#\u0010?\u001a\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;", "", "", "canShowBgPop", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "component1", "()Ljava/lang/Long;", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "component2", "", "component3", "component4", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "component5", "component6", "component7", "Lcom/bytedance/android/live/profit/privilege/model/touch/i;", "component8", "Lcom/bytedance/android/live/profit/privilege/model/touch/c;", "component9", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "component10", "metaId", "panelDetail", "panelUrl", "bubbleText", "bubbleBackgroundImg", "bubbleUrl", "awardTips", "lightInfo", "dynamicInfo", "extra", "copy", "(Ljava/lang/Long;Lcom/bytedance/android/live/base/model/message/a5;Ljava/lang/String;Lcom/bytedance/android/live/base/model/message/a5;Lpy/k;Ljava/lang/String;Lcom/bytedance/android/live/base/model/message/a5;Lcom/bytedance/android/live/profit/privilege/model/touch/i;Lcom/bytedance/android/live/profit/privilege/model/touch/c;Ljava/util/Map;)Lcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;", "toString", "", "hashCode", "other", "equals", "Ljava/lang/Long;", "getMetaId", "Lcom/bytedance/android/live/base/model/message/a5;", "getPanelDetail", "()Lcom/bytedance/android/live/base/model/message/a5;", "Ljava/lang/String;", "getPanelUrl", "()Ljava/lang/String;", "getBubbleText", "Lpy/k;", "getBubbleBackgroundImg", "()Lpy/k;", "getBubbleUrl", "getAwardTips", "Lcom/bytedance/android/live/profit/privilege/model/touch/i;", "getLightInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/i;", "Lcom/bytedance/android/live/profit/privilege/model/touch/c;", "getDynamicInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/c;", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "<init>", "(Ljava/lang/Long;Lcom/bytedance/android/live/base/model/message/a5;Ljava/lang/String;Lcom/bytedance/android/live/base/model/message/a5;Lpy/k;Ljava/lang/String;Lcom/bytedance/android/live/base/model/message/a5;Lcom/bytedance/android/live/profit/privilege/model/touch/i;Lcom/bytedance/android/live/profit/privilege/model/touch/c;Ljava/util/Map;)V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PrivilegeEntranceInfo {
    private final a5 awardTips;
    private final py.k bubbleBackgroundImg;
    private final a5 bubbleText;
    private final String bubbleUrl;
    private final c dynamicInfo;
    private final Map<String, String> extra;
    private final i lightInfo;
    private final Long metaId;
    private final a5 panelDetail;
    private final String panelUrl;

    public PrivilegeEntranceInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrivilegeEntranceInfo copy$default(PrivilegeEntranceInfo r12, Long r13, a5 r14, String r15, a5 r16, py.k r17, String r18, a5 r19, i r110, c r20, Map r22, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        Long r2 = r12.metaId;
    L7:
        if ((r23 & 2) == 0) goto L9;
        a5 r3 = r12.panelDetail;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r4 = r12.panelUrl;
    L15:
        if ((r23 & 8) == 0) goto L17;
        a5 r5 = r12.bubbleText;
    L19:
        if ((r23 & 16) == 0) goto L21;
        py.k r6 = r12.bubbleBackgroundImg;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r7 = r12.bubbleUrl;
    L27:
        if ((r23 & 64) == 0) goto L29;
        a5 r8 = r12.awardTips;
    L31:
        if ((r23 & 128) == 0) goto L33;
        i r9 = r12.lightInfo;
    L35:
        if ((r23 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L37;
        c r10 = r12.dynamicInfo;
    L39:
        if ((r23 & 512) == 0) goto L41;
        Map r1 = r12.extra;
    L43:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r22;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r110;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final Long component1() {
        return this.metaId;
    }

    public final Map<String, String> component10() {
        return this.extra;
    }

    public final a5 component2() {
        return this.panelDetail;
    }

    public final String component3() {
        return this.panelUrl;
    }

    public final a5 component4() {
        return this.bubbleText;
    }

    public final py.k component5() {
        return this.bubbleBackgroundImg;
    }

    public final String component6() {
        return this.bubbleUrl;
    }

    public final a5 component7() {
        return this.awardTips;
    }

    public final i component8() {
        return this.lightInfo;
    }

    public final c component9() {
        return this.dynamicInfo;
    }

    public final PrivilegeEntranceInfo copy(Long r13, a5 r14, String r15, a5 r16, py.k r17, String r18, a5 r19, i r20, c r22, Map<String, String> r23) {
        return new PrivilegeEntranceInfo(r13, r14, r15, r16, r17, r18, r19, r20, r22, r23);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PrivilegeEntranceInfo) == false) goto L26;
        PrivilegeEntranceInfo r4 = (PrivilegeEntranceInfo) r3;
        if (Intrinsics.areEqual(this.metaId, r4.metaId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.panelDetail, r4.panelDetail) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.panelUrl, r4.panelUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bubbleText, r4.bubbleText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bubbleBackgroundImg, r4.bubbleBackgroundImg) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bubbleUrl, r4.bubbleUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.awardTips, r4.awardTips) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.lightInfo, r4.lightInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.dynamicInfo, r4.dynamicInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        Long r0 = this.metaId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        a5 r4 = this.panelDetail;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.panelUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        a5 r10 = this.bubbleText;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        py.k r14 = this.bubbleBackgroundImg;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.bubbleUrl;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        a5 r20 = this.awardTips;
        if (r20 == null) goto L29;
        int r22 = r20.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        i r24 = this.lightInfo;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        c r27 = this.dynamicInfo;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        Map<String, String> r30 = this.extra;
        if (r30 == null) goto L42;
        r1 = r30.hashCode();
    L42:
        return r29 + r1;
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PrivilegeEntranceInfo(metaId=" + this.metaId + ", panelDetail=" + this.panelDetail + ", panelUrl=" + this.panelUrl + ", bubbleText=" + this.bubbleText + ", bubbleBackgroundImg=" + this.bubbleBackgroundImg + ", bubbleUrl=" + this.bubbleUrl + ", awardTips=" + this.awardTips + ", lightInfo=" + this.lightInfo + ", dynamicInfo=" + this.dynamicInfo + ", extra=" + this.extra + ")";
    }

    public final boolean canShowBgPop() {
        py.k r0 = this.bubbleBackgroundImg;
        if (r0 == null) goto L7;
        List r1 = r0.getUrls();
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        if (r2 <= 0) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = 0;
        goto L8
    }

    public final a5 getAwardTips() {
        return this.awardTips;
    }

    public final py.k getBubbleBackgroundImg() {
        return this.bubbleBackgroundImg;
    }

    public final a5 getBubbleText() {
        return this.bubbleText;
    }

    public final String getBubbleUrl() {
        return this.bubbleUrl;
    }

    public final c getDynamicInfo() {
        return this.dynamicInfo;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final i getLightInfo() {
        return this.lightInfo;
    }

    public final Long getMetaId() {
        return this.metaId;
    }

    public final a5 getPanelDetail() {
        return this.panelDetail;
    }

    public final String getPanelUrl() {
        return this.panelUrl;
    }

    public PrivilegeEntranceInfo(Long r1, a5 r2, String r3, a5 r4, py.k r5, String r6, a5 r7, i r8, c r9, Map<String, String> r10) {
        this.metaId = r1;
        this.panelDetail = r2;
        this.panelUrl = r3;
        this.bubbleText = r4;
        this.bubbleBackgroundImg = r5;
        this.bubbleUrl = r6;
        this.awardTips = r7;
        this.lightInfo = r8;
        this.dynamicInfo = r9;
        this.extra = r10;
    }

    public /* synthetic */ PrivilegeEntranceInfo(Long r12, a5 r13, String r14, a5 r15, py.k r16, String r17, a5 r18, i r19, c r20, Map r22, int r23, DefaultConstructorMarker r24) {
        Map r2 = null;
        if ((r23 & 1) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r23 & 2) == 0) goto L9;
        a5 r3 = null;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r23 & 8) == 0) goto L17;
        a5 r5 = null;
    L19:
        if ((r23 & 16) == 0) goto L21;
        py.k r6 = null;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r23 & 64) == 0) goto L29;
        a5 r8 = null;
    L31:
        if ((r23 & 128) == 0) goto L33;
        i r9 = null;
    L35:
        if ((r23 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L37;
        c r10 = null;
    L39:
        if ((r23 & 512) != 0) goto L42;
        r2 = r22;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
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
        r1 = r12;
        goto L7
    }
}
