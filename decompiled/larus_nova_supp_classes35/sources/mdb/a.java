package mdb;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u0018H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR.\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/ss/android/lark/featuregatingv2impl/settings/SettingsPerformanceMetricsConfig;", BuildConfig.FLAVOR, "<init>", "()V", "bufferSize", BuildConfig.FLAVOR, "getBufferSize", "()I", "setBufferSize", "(I)V", "slidingWindow", "Lcom/ss/android/lark/featuregatingv2impl/settings/SettingsPerformanceMetricsConfig$SlidingWindow;", "getSlidingWindow", "()Lcom/ss/android/lark/featuregatingv2impl/settings/SettingsPerformanceMetricsConfig$SlidingWindow;", "setSlidingWindow", "(Lcom/ss/android/lark/featuregatingv2impl/settings/SettingsPerformanceMetricsConfig$SlidingWindow;)V", "cacheSize", "getCacheSize", "setCacheSize", "reportCapacity", "getReportCapacity", "setReportCapacity", "filterFragment", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "getFilterFragment", "()Ljava/util/ArrayList;", "setFilterFragment", "(Ljava/util/ArrayList;)V", "toString", "SlidingWindow", "featuregating-v2-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("bufferSize")
    private int bufferSize;

    @SerializedName("cacheSize")
    private int cacheSize;

    @SerializedName("filterFragment")
    public ArrayList<String> filterFragment;

    @SerializedName("reportCapacity")
    private int reportCapacity;

    @SerializedName("slidingWindow")
    public C0258a slidingWindow;

    /* JADX INFO: renamed from: mdb.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/featuregatingv2impl/settings/SettingsPerformanceMetricsConfig$SlidingWindow;", BuildConfig.FLAVOR, "<init>", "()V", "windowSize", BuildConfig.FLAVOR, "getWindowSize", "()I", "setWindowSize", "(I)V", "qpsThreshold", "getQpsThreshold", "setQpsThreshold", "featuregating-v2-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0258a {

        @SerializedName("qpsThreshold")
        private int qpsThreshold;

        @SerializedName("windowSize")
        private int windowSize;

        public C0258a() {
            this.windowSize = 1000;
            this.qpsThreshold = 200;
        }

        public final int a() {
            return this.qpsThreshold;
        }

        public final int b() {
            return this.windowSize;
        }
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public a() {
        this.bufferSize = 1000;
        this.cacheSize = ChameleonWebViewClient.DEFAULT_SAFE_TIME;
        this.reportCapacity = 100;
    }

    public final int a() {
        return this.bufferSize;
    }

    public final int b() {
        return this.cacheSize;
    }

    public final int c() {
        return this.reportCapacity;
    }
}
