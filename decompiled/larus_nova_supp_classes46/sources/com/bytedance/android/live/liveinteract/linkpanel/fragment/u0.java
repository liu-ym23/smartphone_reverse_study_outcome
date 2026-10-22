package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u0<T> implements Consumer {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public u0(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Boolean r4 = (Boolean) r3;
        StringBuilder r5 = new StringBuilder("updateGuestLinkSwitch: ");
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.z1;
        r5.append((Boolean) r0.getValue());
        ALogger.i("VideoTalkSettingFragment", r5.toString());
        TextView r6 = (TextView) this.a.aa0(2131390728);
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L5;
        String r1 = com.bytedance.android.live.core.utils.s1.B(2131917651);
    L6:
        r6.setText(r1);
        return;
    L5:
        r1 = com.bytedance.android.live.core.utils.s1.B(2131917650);
        goto L6
    }
}
