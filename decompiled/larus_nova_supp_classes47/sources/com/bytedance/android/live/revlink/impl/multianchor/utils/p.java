package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class p {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[UILayout.values().length];
        a = r0;
        r0[UILayout.FULL.ordinal()] = 1;
        r0[UILayout.Enlarge.ordinal()] = 2;
        int[] r1 = new int[IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.values().length];
        b = r1;
        r1[IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown.ordinal()] = 1;
        r1[IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeAllStream.ordinal()] = 2;
        int[] r2 = new int[IAnchorUpdateLayoutContent.AnchorLayoutRange.values().length];
        c = r2;
        r2[IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom.ordinal()] = 1;
        r2[IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom.ordinal()] = 2;
    }
}
