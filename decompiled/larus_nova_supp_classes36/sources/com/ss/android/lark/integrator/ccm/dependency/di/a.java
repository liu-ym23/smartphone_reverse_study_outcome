package com.ss.android.lark.integrator.ccm.dependency.di;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.bytedance.ee.bear.lark.dependency.c {
    public a() {
    }

    public final void a(FragmentActivity r2, String r3, IGetDataCallback r4) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).showAnnouncementEventWindow(r2, r3, r4);
    }
}
