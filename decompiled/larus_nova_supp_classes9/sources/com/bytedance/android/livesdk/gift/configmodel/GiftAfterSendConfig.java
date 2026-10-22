package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\n\u000e\u0005B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig$b;", "giftDialogConfig", "Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig$b;", "b", "()Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig$b;", "Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig$a;", "fePageConfig", "Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig$a;", "a", "()Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig$a;", "<init>", "()V", "FePageConfigType", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftAfterSendConfig {

    @SerializedName("fe_page_config")
    private final a fePageConfig;

    @SerializedName("gift_dialog_config")
    private final b giftDialogConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig$FePageConfigType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "I", "getType", "()I", "UNSUPPORTED", "DURATION_TYPE", "COMBO_TYPE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FePageConfigType extends Enum<FePageConfigType> {
        public static final FePageConfigType COMBO_TYPE = null;
        public static final FePageConfigType DURATION_TYPE = null;
        public static final FePageConfigType UNSUPPORTED = null;
        public static final /* synthetic */ FePageConfigType[] a = null;
        private final int type;

        static {
            FePageConfigType r1 = new FePageConfigType("UNSUPPORTED", 0, 0);
            UNSUPPORTED = r1;
            FePageConfigType r2 = new FePageConfigType("DURATION_TYPE", 1, 1);
            DURATION_TYPE = r2;
            FePageConfigType r3 = new FePageConfigType("COMBO_TYPE", 2, 2);
            COMBO_TYPE = r3;
            a = new FePageConfigType[]{r1, r2, r3};
        }

        public static FePageConfigType valueOf(String r1) {
            return (FePageConfigType) r27.a.a(FePageConfigType.class, r1);
        }

        public static FePageConfigType[] values() {
            return (FePageConfigType[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public FePageConfigType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "I", "getType", "()I", BuildConfig.FLAVOR, "directBackDuration", "J", "b", "()J", "comboBufferDuration", "a", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("combo_buffer_duration")
        private final long comboBufferDuration;

        @SerializedName("direct_back_duration")
        private final long directBackDuration;

        @SerializedName("type")
        private final int type;

        public a() {
            this.type = FePageConfigType.UNSUPPORTED.getType();
        }

        public final long a() {
            return this.comboBufferDuration;
        }

        public final long b() {
            return this.directBackDuration;
        }

        public final int getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig$b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "b", "()Z", BuildConfig.FLAVOR, "bufferDuration", "J", "a", "()J", "maxDuration", "c", BuildConfig.FLAVOR, "unsupportedGiftList", "Ljava/util/List;", "d", "()Ljava/util/List;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("buffer_duration")
        private final long bufferDuration;

        @SerializedName("enable")
        private final boolean enable;

        @SerializedName("max_duration")
        private final long maxDuration;

        @SerializedName("unsupported_gift_list")
        private final List<Long> unsupportedGiftList;

        public b() {
            this.unsupportedGiftList = CollectionsKt.listOf(0L);
        }

        public final long a() {
            return this.bufferDuration;
        }

        public final boolean b() {
            return this.enable;
        }

        public final long c() {
            return this.maxDuration;
        }

        public final List<Long> d() {
            return this.unsupportedGiftList;
        }
    }

    public GiftAfterSendConfig() {
        this.giftDialogConfig = new b();
        this.fePageConfig = new a();
    }

    public final a a() {
        return this.fePageConfig;
    }

    public final b b() {
        return this.giftDialogConfig;
    }
}
