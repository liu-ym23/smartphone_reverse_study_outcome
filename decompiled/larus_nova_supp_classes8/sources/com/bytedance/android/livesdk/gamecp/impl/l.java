package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livesdkapi.view.IVideoFloatManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements IVideoFloatManager.VideoFloatManagerListener {
    public final /* synthetic */ dw.h a;

    public final void onClick() {
        this.a.onClick();
    }

    public final void onReturnClick() {
        this.a.onReturnClick();
    }

    public final void onShow() {
        this.a.onShow();
    }

    public final void onViewReleased() {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onViewReleased(this);
    }

    public l(com.bytedance.android.gamecp.business.gamedetail.m r1) {
        this.a = r1;
    }

    public final void onClose(boolean r2) {
        this.a.onClose(r2);
    }

    public final void onMuteButtonClick(boolean r1) {
        this.a.a();
    }

    public final void onShow(int r1, int r2, int r3, int r4) {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onShow(this, r1, r2, r3, r4);
    }

    public final void onViewPositionChanged(int r1, int r2, int r3, int r4) {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onViewPositionChanged(this, r1, r2, r3, r4);
    }
}
