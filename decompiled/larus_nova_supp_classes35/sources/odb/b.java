package odb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/featuregatingv2impl/statistics/metrics/FeatureGatingMetricsSetBean;", BuildConfig.FLAVOR, "<init>", "()V", "key", BuildConfig.FLAVOR, "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "costList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getCostList", "()Ljava/util/List;", "setCostList", "(Ljava/util/List;)V", "errorType", BuildConfig.FLAVOR, "getErrorType", "setErrorType", "isMainThread", BuildConfig.FLAVOR, "()Z", "setMainThread", "(Z)V", "pageName", "getPageName", "setPageName", "featuregating-v2-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("costs")
    private List<Double> costList;

    @SerializedName(ChameleonOpenTracker.ParamKey.ERROR_TYPE)
    private List<Integer> errorType;

    @SerializedName("is_main_thread")
    private boolean isMainThread;

    @SerializedName("fg_key")
    private String key;

    @SerializedName("page_name")
    private String pageName;

    public b() {
        this.key = BuildConfig.FLAVOR;
        this.costList = new ArrayList();
        this.errorType = new ArrayList();
        this.pageName = BuildConfig.FLAVOR;
    }

    public final List<Double> a() {
        return this.costList;
    }

    public final List<Integer> b() {
        return this.errorType;
    }

    public final String c() {
        return this.key;
    }

    public final String d() {
        return this.pageName;
    }

    public final boolean e() {
        return this.isMainThread;
    }

    public final void f(List<Double> r1) {
        this.costList = r1;
    }

    public final void g(List<Integer> r1) {
        this.errorType = r1;
    }

    public final void h(String r1) {
        this.key = r1;
    }

    public final void i(boolean r1) {
        this.isMainThread = r1;
    }

    public final void j(String r1) {
        this.pageName = r1;
    }
}
