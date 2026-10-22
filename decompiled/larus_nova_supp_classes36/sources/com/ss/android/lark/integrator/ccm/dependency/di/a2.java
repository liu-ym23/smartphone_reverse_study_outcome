package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import android.view.View;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a2 implements com.bytedance.ee.bear.lark.dependency.j0 {
    public a2() {
    }

    public final View a(wb5.b r9) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Activity r2 = r9.getActivity();
        if (r2 != null) goto L7;
        return null;
    L7:
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).getIMAddDocToChatTabView(r2, r9.b, r9.c, r9.d, r9.e, r9.f);
    }
}
