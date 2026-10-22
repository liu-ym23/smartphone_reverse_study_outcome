package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ AsrInputVoiceView a;

    public i(AsrInputVoiceView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        if (((Boolean) r5).booleanValue() == false) goto L6;
        int r6 = com.ss.android.lark.c.a(this.a.e) + UIUtils.dp2px(this.a.d, 30.0f);
        UDToast.a r0 = UDToast.build(this.a.d);
        r0.g(AsrInputVoiceView.k6(this.a));
        r0.b.c(80, 0, r6);
        r0.b.d = 2000;
        r0.a().show();
        return;
    }
}
