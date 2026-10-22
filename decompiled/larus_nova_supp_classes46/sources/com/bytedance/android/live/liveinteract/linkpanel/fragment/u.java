package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ AudioTalkSettingFragment a;

    public u(AudioTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        AudioTalkSettingFragment r6 = this.a;
        int r0 = AudioTalkSettingFragment.w;
        r6.getClass();
        AudioTalkSettingFragment.ma0("radio");
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_ktv_open", null, new Object[]{IRoom.class, am2.x.class});
        if (jc1.k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L5;
        r6.d.dismiss();
        return;
    L5:
        r6.sa0(9, 5);
    }
}
