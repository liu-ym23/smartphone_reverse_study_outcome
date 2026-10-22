package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static AbstractDraweeController a(py.k r2) {
        if (UtilityKotlinExtentionsKt.n(r2) == false) goto L7;
        return null;
    L7:
        return Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r2, -1)).setAutoPlayAnimations(true).build();
    }
}
