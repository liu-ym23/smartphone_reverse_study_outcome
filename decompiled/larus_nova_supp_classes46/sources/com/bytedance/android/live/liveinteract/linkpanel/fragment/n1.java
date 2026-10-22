package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n1 implements View.OnClickListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public n1(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        VideoTalkSettingFragment r5 = this.a;
        yf0.g r0 = r5.d;
        if (r0 == null) goto L6;
        int r1 = VideoTalkAVPermissionFragment.l;
        IRoom r6 = r5.getRoom();
        Intrinsics.checkNotNullParameter(r0, "dialog");
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        VideoTalkAVPermissionFragment r2 = new VideoTalkAVPermissionFragment();
        r2.d = r0;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r2.i = r6;
        r0.Rh(r2);
        return;
    }
}
