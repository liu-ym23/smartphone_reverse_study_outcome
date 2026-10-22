package com.ss.android.lark.im.base.browser;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.log.Log;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements IImBrowserService {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final IImBrowserService.b createSecLinkHelper(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "title");
        Log.i("DefaultImBrowserService", "createSecLinkHelper ignored");
        return null;
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        Log.i("DefaultImBrowserService", "openUrl ignored");
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void sendLinkClickEvent(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "location");
        Log.i("DefaultImBrowserService", "sendLinkClickEvent ignored");
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r1, String r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "url");
        Log.i("DefaultImBrowserService", "openUrl ignored");
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r1, String r2, int r3, Bundle r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r5, "docsArgs");
        Log.i("DefaultImBrowserService", "openUrl ignored");
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r1, String r2, int r3, Bundle r4, Map<String, String> r5, Map<String, String> r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r5, "docsArgs");
        Log.i("DefaultImBrowserService", "openUrl ignore");
    }
}
