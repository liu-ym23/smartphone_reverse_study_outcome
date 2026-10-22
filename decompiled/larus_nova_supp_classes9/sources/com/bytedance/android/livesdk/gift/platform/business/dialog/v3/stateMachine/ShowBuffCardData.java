package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b;\u0010<J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0017\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0087\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\n2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\u0013\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010%R%\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0016\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0017\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0018\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u001a\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b5\u0010+R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u001b\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b9\u0010.R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b:\u0010.¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowBuffCardData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "component1", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "component2", BuildConfig.FLAVOR, "component3", "component4", "Lcom/bytedance/android/livesdk/gift/model/h1;", "component5", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/l1;", "component6", "component7", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "component8", "component9", "component10", "canShow", "params", "defaultBuffLevel", "defaultJumpSchema", "gift", "buffInfo", "pageType", "giftMarketingInfo", "bannerInfo", "giftSceneMarketingInfo", "copy", "toString", "hashCode", "other", "equals", "Z", "getCanShow", "()Z", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "I", "getDefaultBuffLevel", "()I", "Ljava/lang/String;", "getDefaultJumpSchema", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "Ljava/util/List;", "getBuffInfo", "()Ljava/util/List;", "getPageType", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "getGiftMarketingInfo", "()Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "getBannerInfo", "getGiftSceneMarketingInfo", "<init>", "(ZLjava/util/Map;ILjava/lang/String;Lcom/bytedance/android/livesdk/gift/model/h1;Ljava/util/List;ILcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;Ljava/lang/String;Ljava/lang/String;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowBuffCardData {
    private final String bannerInfo;
    private final List<l1> buffInfo;
    private final boolean canShow;
    private final int defaultBuffLevel;
    private final String defaultJumpSchema;
    private final h1 gift;
    private final IGiftMarketingInfo giftMarketingInfo;
    private final String giftSceneMarketingInfo;
    private final int pageType;
    private final Map<String, Object> params;

    public ShowBuffCardData() {
        this(false, null, 0, null, null, null, 0, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowBuffCardData copy$default(ShowBuffCardData r11, boolean r13, Map r14, int r15, String r16, h1 r17, List r18, int r19, IGiftMarketingInfo r110, String r20, String r21, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        boolean r2 = r11.canShow;
    L7:
        if ((r23 & 2) == 0) goto L9;
        Map r3 = r11.params;
    L11:
        if ((r23 & 4) == 0) goto L13;
        int r4 = r11.defaultBuffLevel;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r5 = r11.defaultJumpSchema;
    L19:
        if ((r23 & 16) == 0) goto L21;
        h1 r6 = r11.gift;
    L23:
        if ((r23 & 32) == 0) goto L25;
        List r7 = r11.buffInfo;
    L27:
        if ((r23 & 64) == 0) goto L29;
        int r8 = r11.pageType;
    L31:
        if ((r23 & 128) == 0) goto L33;
        IGiftMarketingInfo r9 = r11.giftMarketingInfo;
    L35:
        if ((r23 & 256) == 0) goto L37;
        String r10 = r11.bannerInfo;
    L39:
        if ((r23 & 512) == 0) goto L41;
        String r1 = r11.giftSceneMarketingInfo;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
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

    public final boolean component1() {
        return this.canShow;
    }

    public final String component10() {
        return this.giftSceneMarketingInfo;
    }

    public final Map<String, Object> component2() {
        return this.params;
    }

    public final int component3() {
        return this.defaultBuffLevel;
    }

    public final String component4() {
        return this.defaultJumpSchema;
    }

    public final h1 component5() {
        return this.gift;
    }

    public final List<l1> component6() {
        return this.buffInfo;
    }

    public final int component7() {
        return this.pageType;
    }

    public final IGiftMarketingInfo component8() {
        return this.giftMarketingInfo;
    }

    public final String component9() {
        return this.bannerInfo;
    }

    public final ShowBuffCardData copy(boolean r13, Map<String, ? extends Object> r14, int r15, String r16, h1 r17, List<? extends l1> r18, int r19, IGiftMarketingInfo r20, String r21, String r23) {
        Intrinsics.checkNotNullParameter(r16, "defaultJumpSchema");
        Intrinsics.checkNotNullParameter(r17, "gift");
        Intrinsics.checkNotNullParameter(r18, "buffInfo");
        return new ShowBuffCardData(r13, r14, r15, r16, r17, r18, r19, r20, r21, r23);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShowBuffCardData) == false) goto L26;
        ShowBuffCardData r4 = (ShowBuffCardData) r3;
        if (this.canShow == r4.canShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L10;
        return false;
    L10:
        if (this.defaultBuffLevel == r4.defaultBuffLevel) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultJumpSchema, r4.defaultJumpSchema) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.gift, r4.gift) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.buffInfo, r4.buffInfo) == true) goto L18;
        return false;
    L18:
        if (this.pageType == r4.pageType) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.giftMarketingInfo, r4.giftMarketingInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bannerInfo, r4.bannerInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.giftSceneMarketingInfo, r4.giftSceneMarketingInfo) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    public int hashCode() {
        boolean r0 = this.canShow;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        Map<String, Object> r3 = this.params;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (((r2 + r5) * 31) + this.defaultBuffLevel) * 31;
        String r7 = this.defaultJumpSchema;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        h1 r10 = this.gift;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r13 = (r9 + r11) * 31;
        List<l1> r14 = this.buffInfo;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (((r13 + r15) * 31) + this.pageType) * 31;
        IGiftMarketingInfo r17 = this.giftMarketingInfo;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        String r20 = this.bannerInfo;
        if (r20 == null) goto L28;
        int r21 = r20.hashCode();
    L29:
        int r23 = (r19 + r21) * 31;
        String r24 = this.giftSceneMarketingInfo;
        if (r24 == null) goto L33;
        r4 = r24.hashCode();
    L33:
        return r23 + r4;
    L28:
        r21 = 0;
        goto L29
    L24:
        r18 = 0;
        goto L25
    L20:
        r15 = 0;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public String toString() {
        return "ShowBuffCardData(canShow=" + this.canShow + ", params=" + this.params + ", defaultBuffLevel=" + this.defaultBuffLevel + ", defaultJumpSchema=" + this.defaultJumpSchema + ", gift=" + this.gift + ", buffInfo=" + this.buffInfo + ", pageType=" + this.pageType + ", giftMarketingInfo=" + this.giftMarketingInfo + ", bannerInfo=" + this.bannerInfo + ", giftSceneMarketingInfo=" + this.giftSceneMarketingInfo + ")";
    }

    public final String getBannerInfo() {
        return this.bannerInfo;
    }

    public final List<l1> getBuffInfo() {
        return this.buffInfo;
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final int getDefaultBuffLevel() {
        return this.defaultBuffLevel;
    }

    public final String getDefaultJumpSchema() {
        return this.defaultJumpSchema;
    }

    public final h1 getGift() {
        return this.gift;
    }

    public final IGiftMarketingInfo getGiftMarketingInfo() {
        return this.giftMarketingInfo;
    }

    public final String getGiftSceneMarketingInfo() {
        return this.giftSceneMarketingInfo;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShowBuffCardData(boolean r2, Map<String, ? extends Object> r3, int r4, String r5, h1 r6, List<? extends l1> r7, int r8, IGiftMarketingInfo r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "defaultJumpSchema");
        Intrinsics.checkNotNullParameter(r6, "gift");
        Intrinsics.checkNotNullParameter(r7, "buffInfo");
        this.canShow = r2;
        this.params = r3;
        this.defaultBuffLevel = r4;
        this.defaultJumpSchema = r5;
        this.gift = r6;
        this.buffInfo = r7;
        this.pageType = r8;
        this.giftMarketingInfo = r9;
        this.bannerInfo = r10;
        this.giftSceneMarketingInfo = r11;
    }

    public /* synthetic */ ShowBuffCardData(boolean r13, Map r14, int r15, String r16, h1 r17, List r18, int r19, IGiftMarketingInfo r110, String r20, String r21, int r23, DefaultConstructorMarker r24) {
        int r2 = 0;
        if ((r23 & 1) == 0) goto L5;
        boolean r1 = false;
    L6:
        String r4 = null;
        if ((r23 & 2) == 0) goto L9;
        Map r3 = null;
    L11:
        if ((r23 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r6 = BuildConfig.FLAVOR;
    L19:
        if ((r23 & 16) == 0) goto L21;
        h1 r7 = (h1) f.c(h1.class);
    L23:
        if ((r23 & 32) == 0) goto L25;
        List r8 = CollectionsKt.emptyList();
    L27:
        if ((r23 & 64) != 0) goto L31;
        r2 = r19;
    L31:
        if ((r23 & 128) == 0) goto L33;
        IGiftMarketingInfo r9 = null;
    L35:
        if ((r23 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r23 & 512) != 0) goto L42;
        r4 = r21;
    L42:
        this(r1, r3, r5, r6, r7, r8, r2, r9, r10, r4);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r110;
        goto L35
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L6
    }
}
