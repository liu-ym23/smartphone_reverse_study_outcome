package com.bytedance.android.live.platformplayer.layout;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[Lifecycle.Event.values().length];
        a = r0;
        r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
        r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
        int[] r1 = new int[LiveMode.values().length];
        b = r1;
        r1[LiveMode.SCREEN_RECORD.ordinal()] = 1;
        r1[LiveMode.THIRD_PARTY.ordinal()] = 2;
    }
}
