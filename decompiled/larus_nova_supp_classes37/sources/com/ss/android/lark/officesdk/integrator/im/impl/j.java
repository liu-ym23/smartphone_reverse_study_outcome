package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class j implements IImBrowserService {
    @Inject
    public j() {
    }

    public static void a(Context r2, String r3) {
        Log.i("OfficeSdkImBrowserService", "openUrlByRouter url=" + r3);
        com.ss.android.lark.router.c.b(r2, r3);
    }

    public final IImBrowserService.b createSecLinkHelper(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "title");
        Log.i("OfficeSdkImBrowserService", "createSecLinkHelper ignored, url=" + r3 + ", title=" + r4);
        return null;
    }

    public final void openUrl(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        Log.i("OfficeSdkImBrowserService", "openUrl url=" + r4);
        a(r3, r4);
    }

    public final void sendLinkClickEvent(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, AppbrandHostConstants.Schema_BDP_LOG.FIELD_LOCATION);
        Log.e("OfficeSdkImBrowserService", "sendLinkClickEvent ignored, scene=" + r3 + ", location=" + r4);
    }

    public final void openUrl(Context r3, String r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        Log.i("OfficeSdkImBrowserService", "openUrl url=" + r4 + ", source=" + r5 + ", extraParams=" + r6);
        a(r3, r4);
    }

    public final void openUrl(Context r3, String r4, int r5, Bundle r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r7, "docsArgs");
        Log.i("OfficeSdkImBrowserService", "openUrl url=" + r4 + ", source=" + r5 + ", extraParams=" + r6 + ", docsArgs=" + r7);
        a(r3, r4);
    }

    public final void openUrl(Context r3, String r4, int r5, Bundle r6, Map<String, String> r7, Map<String, String> r8, Fragment r9) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r7, "docsArgs");
        Log.i("OfficeSdkImBrowserService", "openUrl url=" + r4 + ", source=" + r5 + ", extraParams=" + r6 + ", docsArgs=" + r7 + ", extra=" + r8 + ", sourceFragment=" + r9);
        a(r3, r4);
    }
}
