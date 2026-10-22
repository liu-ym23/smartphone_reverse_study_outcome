package com.bytedance.android.annie.container.fragment;

import com.bytedance.android.annie.view.FullscreenVideoFrame;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements FullscreenVideoFrame.a {
    public final /* synthetic */ AnnieFragment a;

    public b(AnnieFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.annie.view.FullscreenVideoFrame.a
    public final void onHideFullscreenVideoFrame() {
        AnnieFragment.U90(this.a);
    }
}
