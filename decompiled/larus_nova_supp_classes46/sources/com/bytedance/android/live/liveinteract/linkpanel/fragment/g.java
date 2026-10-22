package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import j40.f4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ AudioTalkSettingFragment a;

    public g(AudioTalkSettingFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        int r4 = AudioTalkSettingFragment.w;
        ALogger.i("AudioTalkSettingFragment", "updateGuestLinkSwitch: " + ((Boolean) f4.C.getValue()));
        TextView r5 = (TextView) this.a.aa0(2131390728);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.z1.getValue()).booleanValue() == false) goto L5;
        String r0 = com.bytedance.android.live.core.utils.s1.B(2131917651);
    L6:
        r5.setText(r0);
        return;
    L5:
        r0 = com.bytedance.android.live.core.utils.s1.B(2131917650);
        goto L6
    }
}
