package com.bytedance.android.livesdk.floatview.inner;

import android.view.View;
import android.widget.RadioButton;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ RadioButton a;

    public g(RadioButton r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        RadioButton r5 = this.a;
        r5.setChecked(!r5.isChecked());
        if (this.a.isChecked() == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.O2;
        Boolean r2 = Boolean.TRUE;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r2);
        com.bytedance.android.livesdk.floatview.mob.a.a(true);
        ALogger.d("PartSceneFloatWindow", "check radioButton");
        return;
    L5:
        com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.b.O2;
        Boolean r1 = Boolean.FALSE;
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r1);
        com.bytedance.android.livesdk.floatview.mob.a.a(false);
        ALogger.d("PartSceneFloatWindow", "uncheck radioButton");
    }
}
