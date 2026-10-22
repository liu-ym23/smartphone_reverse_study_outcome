package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class f5 {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[LiveMode.values().length];
        a = r0;
        r0[LiveMode.VIDEO.ordinal()] = 1;
        r0[LiveMode.SCREEN_RECORD.ordinal()] = 2;
        r0[LiveMode.THIRD_PARTY.ordinal()] = 3;
        r0[LiveMode.AUDIO.ordinal()] = 4;
        r0[LiveMode.MEDIA.ordinal()] = 5;
        int[] r1 = new int[UserType.values().length];
        b = r1;
        r1[UserType.ANCHOR.ordinal()] = 1;
        r1[UserType.AUDIENCE.ordinal()] = 2;
        r1[UserType.UNKNOWN.ordinal()] = 3;
        r1[UserType.GUEST.ordinal()] = 4;
    }
}
