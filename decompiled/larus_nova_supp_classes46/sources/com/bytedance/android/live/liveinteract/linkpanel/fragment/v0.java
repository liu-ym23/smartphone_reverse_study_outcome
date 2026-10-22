package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v0 implements View.OnClickListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public v0(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (VideoTalkSettingFragment.ba0(this.a) == true) goto L5;
        return;
    L5:
        DataCenter r4 = this.a.n;
        if (r4 == null) goto L8;
        r4.put("data_room_video_talk_log_open_success_for_enter_from", "link_panel");
    L8:
        DataCenter r5 = this.a.n;
        if (r5 == null) goto L11;
        r5.put("data_room_video_talk_log_over_for_over_path", "switch_link_type");
    L11:
        ((ImageView) this.a.ja0().findViewById(2131376483)).setSelected(true);
        ((ImageView) this.a.ja0().findViewById(2131376485)).setSelected(false);
        VideoTalkSettingFragment.ea0(this.a, 8);
    }
}
