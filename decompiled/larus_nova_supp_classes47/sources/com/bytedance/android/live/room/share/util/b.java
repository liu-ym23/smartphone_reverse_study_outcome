package com.bytedance.android.live.room.share.util;

import com.bytedance.android.live.room.api.share.model.LiveShareType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveShareType.values().length];
        a = r0;
        r0[LiveShareType.SHARE_IM.ordinal()] = 1;
        r0[LiveShareType.SHARE_THIRD.ordinal()] = 2;
        r0[LiveShareType.SHARE_DIRECT.ordinal()] = 3;
        r0[LiveShareType.SHARE_DIALOG.ordinal()] = 4;
        r0[LiveShareType.SHARE_ACTIVITY.ordinal()] = 5;
        r0[LiveShareType.SHARE_VIDEO2FANSGROUP.ordinal()] = 6;
        r0[LiveShareType.SHARE_TEXT2FANSGROUP.ordinal()] = 7;
        r0[LiveShareType.REPORT_DIALOG.ordinal()] = 8;
    }
}
