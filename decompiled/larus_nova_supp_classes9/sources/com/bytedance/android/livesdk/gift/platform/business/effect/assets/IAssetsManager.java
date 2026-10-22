package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import androidx.lifecycle.LiveData;
import com.bytedance.bdlocation.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface IAssetsManager extends j {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/IAssetsManager$DownloadAssetsSource;", BuildConfig.FLAVOR, "Companion", "a", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DownloadAssetsSource {
        public static final a Companion = null;
        public static final int SOURCE_APP_LAUNCH = 1;
        public static final int SOURCE_CLEAR_REMARK_RESOURCE = 13;
        public static final int SOURCE_CLIENTAI_DOWNLOAD = 1010;
        public static final int SOURCE_ENTER_ROOM = 2;
        public static final int SOURCE_FROM_LOCAL_MESSAGE = 12;
        public static final int SOURCE_GIFT_IN_APP = 6;
        public static final int SOURCE_GIFT_PANEL_LOAD_MORE = 1006;
        public static final int SOURCE_GIFT_UPDATE_MESSAGE = 5;
        public static final int SOURCE_INTERACT_GIFT_PANEL = 7;
        public static final int SOURCE_INVALID = -1;
        public static final int SOURCE_JSB_PLAY = 1007;
        public static final int SOURCE_JSB_PRELOADING = 1008;
        public static final int SOURCE_LOCAL_DRESS = 1001;
        public static final int SOURCE_LOCAL_GUEST_STICKER_GIFT = 1002;
        public static final int SOURCE_LOCAL_INTERACT_GIFT = 1005;
        public static final int SOURCE_LOCAL_SEND_GIFT_NOW = 1000;
        public static final int SOURCE_OPEN_GIFT_DIALOG = 3;
        public static final int SOURCE_PREDICT_SEND_GIFT = 1011;
        public static final int SOURCE_ROOM_MESSAGE = 4;
        public static final int SOURCE_UNKNOWN = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/IAssetsManager$FetchGiftListSource;", BuildConfig.FLAVOR, "Companion", "a", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FetchGiftListSource {
        public static final a Companion = null;
        public static final int SOURCE_AI_GIFT_ASYNC_SORT = 11;
        public static final int SOURCE_APP_LAUNCH = 1;
        public static final int SOURCE_ENTER_ROOM = 2;
        public static final int SOURCE_ENTER_ROOM_LITE = 13;
        public static final int SOURCE_GIFT_DETAIL = 14;
        public static final int SOURCE_GIFT_PANEL_LOAD_MORE = 12;
        public static final int SOURCE_GIFT_PRE_REQUEST = 15;
        public static final int SOURCE_GIFT_SEARCH = 17;
        public static final int SOURCE_GIFT_UPDATE_MESSAGE = 5;
        public static final int SOURCE_LOCAL = 99;
        public static final int SOURCE_MOSTLY_USED_PIN_STATUS_CHANGED = 18;
        public static final int SOURCE_OPEN_GIFT_DIALOG = 3;
        public static final int SOURCE_PK_PERIOD = 10;
        public static final int SOURCE_ROOM_MESSAGE = 4;
        public static final int SOURCE_SYNC_GIFT_FOR_SORT = 16;
        public static final int SOURCE_UNKNOWN = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public static AssetDownloadPriority a(AssetDownloadPriority r2, int r3) {
            if (r2 == null) goto L7;
            if (r2.getPriority() == AssetDownloadPriority.NORMAL.getPriority()) goto L7;
            return r2;
        L7:
            if (r3 == 1000) goto L22;
            if (r3 == 1010) goto L22;
            if (r3 != 4) goto L16;
            return AssetDownloadPriority.OTHER_SEND;
        L16:
            if (r3 != 1007) goto L20;
            return AssetDownloadPriority.JSB_PLAY;
        L20:
            return AssetDownloadPriority.NORMAL;
        L22:
            return AssetDownloadPriority.LOCAL;
        }
    }

    public interface b {
        void a();

        void b(List<? extends com.bytedance.android.live.core.resources.e> r1);
    }

    int B7();

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    String D1(long r1);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    com.bytedance.android.live.core.resources.e G1(long r1);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    String H0(long r1);

    boolean Ne(com.bytedance.android.live.core.resources.e r1, f r2, int r3);

    boolean O9(com.bytedance.android.live.core.resources.e r1);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    void T(b r1);

    void T2(int r1, String r2);

    void cb(String r1);

    void d4(int r1, boolean r2, long r3, String r5);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    boolean g1(long r1);

    String gn(long r1, boolean r3);

    LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0();

    boolean j4(long r1, f r3, int r4);

    void ji(int r1, boolean r2, List<Long> r3, String r4);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    void l0(b r1);

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.j
    boolean r0(long r1, f r3, int r4, AssetDownloadPriority r5);

    String vg();
}
