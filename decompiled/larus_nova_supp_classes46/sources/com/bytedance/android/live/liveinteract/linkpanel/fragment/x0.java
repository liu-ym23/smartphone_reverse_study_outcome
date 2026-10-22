package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x0 implements View.OnTouchListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public x0(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        return VideoTalkSettingFragment.da0(this.a, r3, r4, true);
    }
}
