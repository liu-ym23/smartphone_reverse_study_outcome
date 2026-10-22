package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u000f\u0016B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/ik1;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "logEnable", "d", "setLogEnable", "Lcom/bytedance/android/livesdk/config/ik1$a;", "anchorConfig", "Lcom/bytedance/android/livesdk/config/ik1$a;", "a", "()Lcom/bytedance/android/livesdk/config/ik1$a;", "setAnchorConfig", "(Lcom/bytedance/android/livesdk/config/ik1$a;)V", "Lcom/bytedance/android/livesdk/config/ik1$b;", "audienceConfig", "Lcom/bytedance/android/livesdk/config/ik1$b;", "b", "()Lcom/bytedance/android/livesdk/config/ik1$b;", "setAudienceConfig", "(Lcom/bytedance/android/livesdk/config/ik1$b;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ik1 {

    @SerializedName("anchor_config")
    private a anchorConfig;

    @SerializedName("audience_config")
    private b audienceConfig;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("log_enable")
    private boolean logEnable;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/config/ik1$a;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "minFps", "I", "c", "()I", "setMinFps", "(I)V", "queueSize", "d", "setQueueSize", "", "checkDelay", "J", "a", "()J", "setCheckDelay", "(J)V", "reportInterval", "e", "setReportInterval", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("check_delay")
        private long checkDelay;

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("min_fps")
        private int minFps;

        @SerializedName("queue_size")
        private int queueSize;

        @SerializedName("report_interval")
        private long reportInterval;

        public a() {
            this.minFps = 8;
            this.queueSize = 30;
            this.checkDelay = 2000;
            this.reportInterval = 60;
        }

        public final long a() {
            return this.checkDelay;
        }

        public final boolean b() {
            return this.enable;
        }

        public final int c() {
            return this.minFps;
        }

        public final int d() {
            return this.queueSize;
        }

        public final long e() {
            return this.reportInterval;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/config/ik1$b;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "", "checkDelay", "J", "a", "()J", "setCheckDelay", "(J)V", "", "compressRate", "F", "b", "()F", "setCompressRate", "(F)V", "pixelThreshold", "d", "setPixelThreshold", "useCache", "f", "setUseCache", "useFullDetect", "g", "setUseFullDetect", "uploadBitmap", "e", "setUploadBitmap", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("check_delay")
        private long checkDelay;

        @SerializedName("compress_rate")
        private float compressRate;

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("pixel_threshold")
        private float pixelThreshold;

        @SerializedName("upload_bitmap")
        private boolean uploadBitmap;

        @SerializedName("use_cache")
        private boolean useCache;

        @SerializedName("use_full_detect")
        private boolean useFullDetect;

        public b() {
            this.checkDelay = AppointmentService.SOURCE_UNDEFINED;
            this.compressRate = 0.1f;
            this.pixelThreshold = 0.98f;
            this.useCache = true;
            this.useFullDetect = true;
            this.uploadBitmap = true;
        }

        public final long a() {
            return this.checkDelay;
        }

        public final float b() {
            return this.compressRate;
        }

        public final boolean c() {
            return this.enable;
        }

        public final float d() {
            return this.pixelThreshold;
        }

        public final boolean e() {
            return this.uploadBitmap;
        }

        public final boolean f() {
            return this.useCache;
        }

        public final boolean g() {
            return this.useFullDetect;
        }
    }

    public ik1() {
        this.anchorConfig = new a();
        this.audienceConfig = new b();
    }

    public final a a() {
        return this.anchorConfig;
    }

    public final b b() {
        return this.audienceConfig;
    }

    public final boolean c() {
        return this.enable;
    }

    public final boolean d() {
        return this.logEnable;
    }
}
