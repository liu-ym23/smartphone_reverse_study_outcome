package com.ss.android.lark.player.player;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IMPlayerSettings {
    public static final Lazy a = null;
    public static final Lazy b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b%\b\u0007\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u0006("}, d2 = {"Lcom/ss/android/lark/player/player/IMPlayerSettings$VideoLarkConfig;", "", "badAVDiff", "", "badAVWaitTime", "useCacheFromBiz", "preloadEnable", "preloadSize", "preloadFooterSize", "preloadDelay", "cellularPreloadEnable", "clickPreloadEnable", "cancelPreloadDelayEnable", "reuseSurfaceView", "<init>", "(IIIIIIIIIII)V", "getBadAVDiff", "()I", "setBadAVDiff", "(I)V", "getBadAVWaitTime", "setBadAVWaitTime", "getUseCacheFromBiz", "setUseCacheFromBiz", "getPreloadEnable", "setPreloadEnable", "getPreloadSize", "setPreloadSize", "getPreloadFooterSize", "setPreloadFooterSize", "getPreloadDelay", "setPreloadDelay", "getCellularPreloadEnable", "setCellularPreloadEnable", "getClickPreloadEnable", "setClickPreloadEnable", "getCancelPreloadDelayEnable", "setCancelPreloadDelayEnable", "getReuseSurfaceView", "setReuseSurfaceView", "videoview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class VideoLarkConfig {

        @SerializedName("BAD_AV_DIFF")
        private int badAVDiff;

        @SerializedName("BAD_AV_WAIT_TIME")
        private int badAVWaitTime;

        @SerializedName("cancel_preload_delay_enable")
        private int cancelPreloadDelayEnable;

        @SerializedName("cellular_preload_enable")
        private int cellularPreloadEnable;

        @SerializedName("click_preload_enable")
        private int clickPreloadEnable;

        @SerializedName("preload_delay")
        private int preloadDelay;

        @SerializedName("preload_enable")
        private int preloadEnable;

        @SerializedName("preload_footer_size")
        private int preloadFooterSize;

        @SerializedName("preload_size")
        private int preloadSize;

        @SerializedName("reuse_surface_view_on_same_video")
        private int reuseSurfaceView;

        @SerializedName("USE_CACHE_FROM_BIZ")
        private int useCacheFromBiz;

        public VideoLarkConfig() {
            this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, null);
        }

        public final int getBadAVDiff() {
            return this.badAVDiff;
        }

        public final int getBadAVWaitTime() {
            return this.badAVWaitTime;
        }

        public final int getCancelPreloadDelayEnable() {
            return this.cancelPreloadDelayEnable;
        }

        public final int getCellularPreloadEnable() {
            return this.cellularPreloadEnable;
        }

        public final int getClickPreloadEnable() {
            return this.clickPreloadEnable;
        }

        public final int getPreloadDelay() {
            return this.preloadDelay;
        }

        public final int getPreloadEnable() {
            return this.preloadEnable;
        }

        public final int getPreloadFooterSize() {
            return this.preloadFooterSize;
        }

        public final int getPreloadSize() {
            return this.preloadSize;
        }

        public final int getReuseSurfaceView() {
            return this.reuseSurfaceView;
        }

        public final int getUseCacheFromBiz() {
            return this.useCacheFromBiz;
        }

        public final void setBadAVDiff(int r1) {
            this.badAVDiff = r1;
        }

        public final void setBadAVWaitTime(int r1) {
            this.badAVWaitTime = r1;
        }

        public final void setCancelPreloadDelayEnable(int r1) {
            this.cancelPreloadDelayEnable = r1;
        }

        public final void setCellularPreloadEnable(int r1) {
            this.cellularPreloadEnable = r1;
        }

        public final void setClickPreloadEnable(int r1) {
            this.clickPreloadEnable = r1;
        }

        public final void setPreloadDelay(int r1) {
            this.preloadDelay = r1;
        }

        public final void setPreloadEnable(int r1) {
            this.preloadEnable = r1;
        }

        public final void setPreloadFooterSize(int r1) {
            this.preloadFooterSize = r1;
        }

        public final void setPreloadSize(int r1) {
            this.preloadSize = r1;
        }

        public final void setReuseSurfaceView(int r1) {
            this.reuseSurfaceView = r1;
        }

        public final void setUseCacheFromBiz(int r1) {
            this.useCacheFromBiz = r1;
        }

        public VideoLarkConfig(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
            this.badAVDiff = r1;
            this.badAVWaitTime = r2;
            this.useCacheFromBiz = r3;
            this.preloadEnable = r4;
            this.preloadSize = r5;
            this.preloadFooterSize = r6;
            this.preloadDelay = r7;
            this.cellularPreloadEnable = r8;
            this.clickPreloadEnable = r9;
            this.cancelPreloadDelayEnable = r10;
            this.reuseSurfaceView = r11;
        }

        public /* synthetic */ VideoLarkConfig(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, DefaultConstructorMarker r25) {
            if ((r24 & 1) == 0) goto L5;
            int r1 = 350000;
        L7:
            if ((r24 & 2) == 0) goto L9;
            int r2 = 5000;
        L10:
            int r4 = 1;
            if ((r24 & 4) == 0) goto L13;
            int r3 = 1;
        L15:
            if ((r24 & 8) == 0) goto L17;
            int r5 = 1;
        L19:
            if ((r24 & 16) == 0) goto L21;
            int r6 = 819200;
        L23:
            if ((r24 & 32) == 0) goto L25;
            int r7 = 307200;
        L27:
            if ((r24 & 64) == 0) goto L29;
            int r8 = BaseField.FIELD_TYPE_NAME_CARD_PHONE;
        L31:
            if ((r24 & 128) == 0) goto L33;
            int r9 = 1;
        L35:
            if ((r24 & 256) == 0) goto L37;
            int r10 = 1;
        L39:
            if ((r24 & 512) == 0) goto L41;
            int r11 = 1;
        L43:
            if ((r24 & 1024) != 0) goto L46;
            r4 = r23;
        L46:
            this(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r4);
            return;
        L41:
            r11 = r22;
            goto L43
        L37:
            r10 = r21;
            goto L39
        L33:
            r9 = r20;
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
            r3 = r15;
            goto L15
        L9:
            r2 = r14;
            goto L10
        L5:
            r1 = r13;
            goto L7
        }
    }

    @AppConfig(key = "im_video_player_config")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/player/player/IMPlayerSettings$VideoPlayerConfig;", "", "<init>", "()V", "videoview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class VideoPlayerConfig {
        public VideoPlayerConfig() {
        }
    }

    static {
        a = LazyKt.lazy(IMPlayerSettings$remoteSetting$2.INSTANCE);
        b = LazyKt.lazy(IMPlayerSettings$larkConfig$2.INSTANCE);
    }

    public static final VideoLarkConfig a() {
        return (VideoLarkConfig) b.getValue();
    }
}
