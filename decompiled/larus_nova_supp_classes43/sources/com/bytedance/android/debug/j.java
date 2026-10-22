package com.bytedance.android.debug;

import android.view.View;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.c0;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ DebugLocalResourceListAdapter.AssetHolder a;
    public final /* synthetic */ DebugLocalResourceListAdapter.a b;

    public j(DebugLocalResourceListAdapter.AssetHolder r1, DebugLocalResourceListAdapter.a r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        PolarisFileWrapper r11 = new PolarisFileWrapper(this.a.b.getContext().getDir("assets", 0).getAbsolutePath() + "/" + this.b.d + "/");
        if (r11.exists() == true) goto L5;
        return;
    L5:
        if (c0.b(r11) == false) goto L9;
        int r12 = ToastUtil.a;
        ToastUtil.b("删除资源" + this.b.a + "成功，请点击刷新更新列表", 0);
        return;
    }
}
