package com.bytedance.android.livesdk.gecko;

import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class f extends GeckoUpdateListener {
    public final GeckoUpdateListener a;

    public final void onUpdateFinish() {
        super.onUpdateFinish();
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onUpdateFinish();
        return;
    }

    public f(GeckoUpdateListener r1) {
        this.a = r1;
    }

    public final void onActivateSuccess(UpdatePackage r2) {
        super.onActivateSuccess(r2);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onActivateSuccess(r2);
        return;
    }

    public final void onClean(String r2) {
        super.onClean(r2);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onClean(r2);
        return;
    }

    public final void onDownloadSuccess(UpdatePackage r2) {
        super.onDownloadSuccess(r2);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onDownloadSuccess(r2);
        return;
    }

    public final void onUpdateStart(UpdatePackage r4) {
        super.onUpdateStart(r4);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onUpdateStart(r4);
    L5:
        if (r4 == null) goto L8;
        ALogger.i("GeckoUpdateProxyListener", "accessKey= " + r4 + '.' + r4.getAccessKey() + ", channel = " + r4 + '.' + r4.getChannel() + ", version = " + r4 + '.' + r4.getVersion());
        return;
    }

    public final void onUpdating(String r2) {
        super.onUpdating(r2);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onUpdating(r2);
        return;
    }

    public final void onActivateFail(UpdatePackage r2, Throwable r3) {
        super.onActivateFail(r2, r3);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onActivateFail(r2, r3);
        return;
    }

    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r2, Throwable r3) {
        super.onCheckServerVersionFail(r2, r3);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onCheckServerVersionFail(r2, r3);
        return;
    }

    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r2, Map<String, List<UpdatePackage>> r3) {
        super.onCheckServerVersionSuccess(r2, r3);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onCheckServerVersionSuccess(r2, r3);
        return;
    }

    public final void onDownloadFail(UpdatePackage r3, Throwable r4) {
        super.onDownloadFail(r3, r4);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onDownloadFail(r3, r4);
    L5:
        if (r3 == null) goto L8;
        ALogger.i("GeckoUpdateProxyListener", "accessKey= " + r3 + '.' + r3.getAccessKey() + ", channel = " + r3 + '.' + r3.getChannel() + ", version = " + r3 + '.' + r3.getVersion());
        return;
    }

    @Deprecated(message = "")
    public final void onUpdateFailed(String r2, Throwable r3) {
        super.onUpdateFailed(r2, r3);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onUpdateFailed(r2, r3);
        return;
    }

    @Deprecated(message = "")
    public final void onUpdateSuccess(String r2, long r3) {
        super.onUpdateSuccess(r2, r3);
        GeckoUpdateListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onUpdateSuccess(r2, r3);
        return;
    }
}
