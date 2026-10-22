package s0b;

import android.os.SystemClock;
import android.util.Pair;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends GeckoUpdateListener {
    public long a;
    public final /* synthetic */ ChameleonConfig b;

    public static final class a<T> implements Consumer {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            j.e("CML_TAG_GeckoResManager", "applyGeckoResource success");
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            j.c("CML_TAG_GeckoResManager", "applyGeckoResource failed", (Throwable) r3);
        }
    }

    @Deprecated(message = BuildConfig.FLAVOR)
    public final void onUpdateFinish() {
        j.e("CML_TAG_GeckoResManager", "onUpdateFinish");
    }

    public d(ChameleonConfig r1) {
        this.b = r1;
    }

    public final void onActivateSuccess(UpdatePackage r3) {
        StringBuilder r0 = new StringBuilder("onActivateSuccess, channel: ");
        if (r3 == null) goto L5;
        String r4 = r3.getChannel();
    L6:
        r0.append(r4);
        j.e("CML_TAG_GeckoResManager", r0.toString());
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Deprecated(message = BuildConfig.FLAVOR)
    public final void onClean(String r3) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        j.e("CML_TAG_GeckoResManager", "onClean, channel: " + r3);
    }

    public final void onDownloadSuccess(UpdatePackage r3) {
        StringBuilder r0 = new StringBuilder("onDownloadSuccess, channel: ");
        if (r3 == null) goto L5;
        String r4 = r3.getChannel();
    L6:
        r0.append(r4);
        j.e("CML_TAG_GeckoResManager", r0.toString());
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onLocalNewestVersion(LocalPackageModel r3) {
        j.e("CML_TAG_GeckoResManager", "onLocalNewestVersion, localPackage: " + r3);
    }

    public final void onUpdateStart(UpdatePackage r3) {
        StringBuilder r0 = new StringBuilder("onUpdateStart, channel: ");
        if (r3 == null) goto L5;
        String r4 = r3.getChannel();
    L6:
        r0.append(r4);
        j.e("CML_TAG_GeckoResManager", r0.toString());
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onUpdating(String r3) {
        j.e("CML_TAG_GeckoResManager", "onUpdating, channel: " + r3);
    }

    public final void onActivateFail(UpdatePackage r3, Throwable r4) {
        StringBuilder r0 = new StringBuilder("onActivateFail, channel: ");
        if (r3 == null) goto L5;
        String r5 = r3.getChannel();
    L6:
        r0.append(r5);
        r0.append(", e: ");
        r0.append(r4);
        j.e("CML_TAG_GeckoResManager", r0.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onCheckServerVersionFail(Map<String, ? extends List<? extends Pair<String, Long>>> r3, Throwable r4) {
        j.b("CML_TAG_GeckoResManager", "onCheckServerVersionFail, requestMap: " + r3 + ", e: " + r4);
    }

    public final void onCheckServerVersionSuccess(Map<String, ? extends List<? extends Pair<String, Long>>> r3, Map<String, ? extends List<? extends UpdatePackage>> r4) {
        j.e("CML_TAG_GeckoResManager", "onCheckServerVersionSuccess, requestMap: " + r3 + ", responseMap: " + r4);
    }

    public final void onDownloadFail(UpdatePackage r3, Throwable r4) {
        StringBuilder r0 = new StringBuilder("onDownloadFail, channel: ");
        if (r3 == null) goto L5;
        String r5 = r3.getChannel();
    L6:
        r0.append(r5);
        r0.append(", e: ");
        r0.append(r4);
        j.e("CML_TAG_GeckoResManager", r0.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onUpdateFailed(String r7, Throwable r8) {
        j.e("CML_TAG_GeckoResManager", "onUpdateFailed， channel：" + r7 + ", e:" + r8);
        if (r8 == null) goto L5;
        String r9 = r8.getMessage();
    L6:
        String r5 = r9;
        long r0 = SystemClock.uptimeMillis();
        boolean r10 = u1b.b.a;
        u1b.b.a(BuildConfig.FLAVOR, r7, r0 - this.a, false, r5);
        return;
    L5:
        r9 = null;
        goto L6
    }

    public final void onUpdateSuccess(UpdatePackage r10, long r11) {
        super.onUpdateSuccess(r10, r11);
        StringBuilder r0 = new StringBuilder("onUpdateSuccess，channel：");
        String r1 = null;
        if (r10 == null) goto L5;
        String r2 = r10.getChannel();
    L6:
        r0.append(r2);
        r0.append(", version: ");
        r0.append(r11);
        j.e("CML_TAG_GeckoResManager", r0.toString());
        if (r10 == null) goto L13;
        ChameleonConfig r3 = this.b;
        AtomicBoolean r4 = g.a;
        Flowable.just(Boolean.TRUE).observeOn(LarkRxSchedulers.io()).map(new s0b.b(r10, r11, r3)).doOnError(new c(r10)).subscribe(a.a, b.a);
        String r5 = r10.getChannel();
        long r12 = SystemClock.uptimeMillis();
        boolean r13 = u1b.b.a;
        if (r3 == null) goto L11;
        r1 = r3.getBizName();
    L11:
        u1b.b.a(r1, r5, r12 - this.a, true, BuildConfig.FLAVOR);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onUpdateFailed(UpdatePackage r3, Throwable r4) {
        StringBuilder r0 = new StringBuilder("onUpdateFailed, channel: ");
        if (r3 == null) goto L5;
        String r5 = r3.getChannel();
    L6:
        r0.append(r5);
        r0.append(", e: ");
        r0.append(r4);
        j.e("CML_TAG_GeckoResManager", r0.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onCheckRequestIntercept(int r3, Map<String, ? extends List<? extends Pair<String, Long>>> r4, Throwable r5) {
        j.e("CML_TAG_GeckoResManager", "onCheckRequestIntercept, code: " + r3 + ", requestMap: " + r4 + ", e: " + r5);
    }

    public final void onDownloadProgress(UpdatePackage r3, long r4, long r6) {
        StringBuilder r0 = new StringBuilder("onDownloadProgress, channel: ");
        if (r3 == null) goto L5;
        String r5 = r3.getChannel();
    L6:
        r0.append(r5);
        r0.append(", totalSize: ");
        r0.append(r4);
        r0.append(", currentSize: ");
        r0.append(r6);
        j.e("CML_TAG_GeckoResManager", r0.toString());
        return;
    L5:
        r5 = null;
        goto L6
    }
}
