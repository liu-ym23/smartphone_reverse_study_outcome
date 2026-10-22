package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.share.VsLiveShareType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class v {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[VsLiveShareType.values().length];
        a = r0;
        r0[VsLiveShareType.SHARE_IM.ordinal()] = 1;
        r0[VsLiveShareType.SHARE_THIRD.ordinal()] = 2;
        r0[VsLiveShareType.SHARE_DIALOG.ordinal()] = 3;
        r0[VsLiveShareType.SHARE_ACTIVITY.ordinal()] = 4;
        r0[VsLiveShareType.SHARE_VIDEO2FANSGROUP.ordinal()] = 5;
        r0[VsLiveShareType.SHARE_TEXT2FANSGROUP.ordinal()] = 6;
        r0[VsLiveShareType.REPORT_DIALOG.ordinal()] = 7;
    }
}
