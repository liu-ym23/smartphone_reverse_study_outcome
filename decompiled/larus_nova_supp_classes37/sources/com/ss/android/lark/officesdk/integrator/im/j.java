package com.ss.android.lark.officesdk.integrator.im;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j extends com.ss.android.lark.appcontext.applifecycle.a {
    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
    }

    public j() {
    }

    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        UrlPreviewApi r3 = (UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class);
        if (r3 == null) goto L6;
        r3.clearAllUrlCache();
        return;
    }
}
