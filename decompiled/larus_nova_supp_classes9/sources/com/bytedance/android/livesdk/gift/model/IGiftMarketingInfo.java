package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00000\u0001:\u000298R\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u0004\u0018\u00010 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\u00020\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0007\u001a\u0004\b%\u0010\u001dR\u001a\u0010*\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0007\u001a\u0004\b(\u0010\u0012R\"\u0010-\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0007\u001a\u0004\b+\u0010\u0005R\"\u00100\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0007\u001a\u0004\b.\u0010\u0005R\u001a\u00103\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0007\u001a\u0004\b1\u0010\u0012R.\u00107\u001a\u0016\u0012\u0004\u0012\u000204\u0018\u00010\tj\n\u0012\u0004\u0012\u000204\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0007\u001a\u0004\b5\u0010\r¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIcon", "()Lpy/k;", "getIcon$annotations", "()V", "icon", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/IRichText;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMainTitle", "()Ljava/util/List;", "getMainTitle$annotations", "mainTitle", BuildConfig.FLAVOR, "getMainTitleAfterMission", "()Ljava/lang/String;", "getMainTitleAfterMission$annotations", "mainTitleAfterMission", "getSubTitle", "getSubTitle$annotations", "subTitle", "getSubTitleSchema", "getSubTitleSchema$annotations", "subTitleSchema", BuildConfig.FLAVOR, "getLeftCount", "()I", "getLeftCount$annotations", "leftCount", "Lcom/bytedance/android/livesdk/gift/model/v1;", "getGiftMarketingButton", "()Lcom/bytedance/android/livesdk/gift/model/v1;", "getGiftMarketingButton$annotations", "giftMarketingButton", "getBuffMergeType", "getBuffMergeType$annotations", "buffMergeType", "getMarketingType", "getMarketingType$annotations", "marketingType", "getMainTitleImg", "getMainTitleImg$annotations", "mainTitleImg", "getJumpIcon", "getJumpIcon$annotations", "jumpIcon", "getSubMarketingType", "getSubMarketingType$annotations", "subMarketingType", BuildConfig.FLAVOR, "getRelatedGiftIds", "getRelatedGiftIds$annotations", "relatedGiftIds", "Companion", "BuffMergeType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IGiftMarketingInfo extends vh7.c<IGiftMarketingInfo> {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo$BuffMergeType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "setValue", "(I)V", "OnlyBuff", "OnlyMarketing", "Both", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BuffMergeType extends Enum<BuffMergeType> {
        public static final BuffMergeType Both = null;
        public static final BuffMergeType OnlyBuff = null;
        public static final BuffMergeType OnlyMarketing = null;
        public static final /* synthetic */ BuffMergeType[] a = null;
        private int value;

        static {
            BuffMergeType r1 = new BuffMergeType("OnlyBuff", 0, 0);
            OnlyBuff = r1;
            BuffMergeType r2 = new BuffMergeType("OnlyMarketing", 1, 1);
            OnlyMarketing = r2;
            BuffMergeType r3 = new BuffMergeType("Both", 2, 2);
            Both = r3;
            a = new BuffMergeType[]{r1, r2, r3};
        }

        public static BuffMergeType valueOf(String r1) {
            return (BuffMergeType) r27.a.a(BuffMergeType.class, r1);
        }

        public static BuffMergeType[] values() {
            return (BuffMergeType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int r1) {
            this.value = r1;
        }

        public BuffMergeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Companion {
        public static final Lazy a = null;
        public static final /* synthetic */ Companion b = null;

        public Companion() {
        }

        static {
            b = new Companion();
            a = LazyKt.lazy(IGiftMarketingInfo$Companion$EMPTY_INSTANCE$2.INSTANCE);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    static {
        Companion = Companion.b;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "buff_merge_type")
    int getBuffMergeType();

    @FieldName(name = "gift_marketing_button")
    v1 getGiftMarketingButton();

    @FieldName(name = "icon")
    py.k getIcon();

    @FieldName(name = "jump_icon")
    py.k getJumpIcon();

    @FieldName(name = "left_count")
    int getLeftCount();

    @FieldName(name = "main_title")
    List<IRichText> getMainTitle();

    @FieldName(name = "main_title_after_mission")
    String getMainTitleAfterMission();

    @FieldName(name = "main_title_img")
    py.k getMainTitleImg();

    @FieldName(name = "marketing_type")
    String getMarketingType();

    @FieldName(name = "related_gift_ids")
    List<Long> getRelatedGiftIds();

    @FieldName(name = "sub_marketing_type")
    String getSubMarketingType();

    @FieldName(name = "sub_title")
    String getSubTitle();

    @FieldName(name = "sub_title_schema")
    String getSubTitleSchema();
}
