package com.bytedance.android.live.broadcast.api;

import android.content.Context;
import android.os.Bundle;
import ld1.b;
import ld1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IBroadcastServiceForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcast.api.IBroadcastServiceForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$createPreviewContainerFragment(IBroadcastServiceForSaas r0, Context r1, Bundle r2, b r3) {
        }

        public static void $default$createStartLiveFragment(IBroadcastServiceForSaas r0, Context r1, c r2) {
        }
    }

    void createPreviewContainerFragment(Context r1, Bundle r2, b r3);

    void createStartLiveFragment(Context r1, c r2);
}
