package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Application;
import com.bytedance.common.utility.NetworkUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.param.Params;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements lj5.a {
    public o() {
    }

    public final void a() {
        if (NetworkUtils.isNetworkAvailable(LarkContext.getApplication()) == false) goto L5;
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        Application r1 = LarkContext.getApplication();
        Params.ReferType r3 = Params.ReferType.LarkMine;
        r0.launchCustomerService(r1, new Params(), null);
        return;
    L5:
        LKUIToast.show(LarkContext.getApplication(), UIUtils.getString(LarkContext.getApplication(), 2131892011));
    }
}
