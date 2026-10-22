package com.bytedance.android.livesdk.chatroom.vs.video;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ MultiVideoFragment a;

    public c(MultiVideoFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        int r4 = d.a;
        d.a(this.a.q);
        d.b(this.a.q, "livesdk_vs_right_video_back_icon_click", null);
        FragmentActivity r5 = this.a.getActivity();
        if (r5 == null) goto L6;
        r5.finish();
        return;
    }
}
