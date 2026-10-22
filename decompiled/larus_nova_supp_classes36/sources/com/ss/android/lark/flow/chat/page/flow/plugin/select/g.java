package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import android.view.View;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.chat.entity.chat.ChatTnsSystemBannedInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ ChatTnsSystemBannedInfo a;
    public final /* synthetic */ FlowMessageSelectPlugin b;

    public g(ChatTnsSystemBannedInfo r1, FlowMessageSelectPlugin r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        OpenConfig r15 = new OpenConfig(null, false, false, false, false, 0, false, false, false, null, null, 2047, null);
        r15.setShowLoading(true);
        ChameleonConfig r1 = new ChameleonConfig.Builder().bizName(ChameleonBizType.BIZ_CHAT.getType()).loadUrl(this.a.getAppealUrl()).openConfig(r15).build();
        Chameleon r2 = Chameleon.a;
        FlowMessageSelectPlugin r3 = this.b;
        int r4 = FlowMessageSelectPlugin.f0;
        Chameleon.b(r3.getContext(), r1, null);
    }
}
