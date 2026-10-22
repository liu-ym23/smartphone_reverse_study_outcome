package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements LiveSwitchButton.e {
    public final /* synthetic */ CommentSettingDialog a;

    public e(CommentSettingDialog r1) {
        this.a = r1;
    }

    public final void d0(LiveSwitchButton r2, boolean r3) {
        if (r3 == false) goto L7;
        ((LinearLayout) this.a.S90(2131367434)).setVisibility(0);
        CommentSettingDialog r4 = this.a;
        r4.q = 9;
        Integer r5 = r4.o.get(9);
        if (r5 == null) goto L9;
        int r6 = r5.intValue();
        ((RadioGroup) this.a.S90(2131373959)).check(r6);
        return;
    L9:
        return;
    L7:
        ((LinearLayout) this.a.S90(2131367434)).setVisibility(8);
        this.a.q = 1;
    }
}
