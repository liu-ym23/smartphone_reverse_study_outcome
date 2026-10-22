package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import com.bytedance.android.livehostapi.business.depend.share.IVSPosterClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements IVSPosterClickListener {
    public final /* synthetic */ LiveLinkShareToThirdDialogFragment a;

    public final void onDownloadButtonClick() {
        LiveLinkShareToThirdDialogFragment.T90(this.a, "save");
    }

    public h(LiveLinkShareToThirdDialogFragment r1) {
        this.a = r1;
    }
}
