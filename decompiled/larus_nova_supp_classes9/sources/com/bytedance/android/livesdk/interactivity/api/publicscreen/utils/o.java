package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(DataCenter r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (b(r1) != true) goto L6;
        return true;
    }

    public static boolean b(DataCenter r3) {
        if (r3 == null) goto L17;
        IRoom r1 = a0.a;
        Intrinsics.checkNotNullParameter(r3, "$this$isMiddlewareAudienceMediaOrVsRoom");
        if (a0.d(r3, false) == false) goto L7;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L14;
        return false;
    L14:
        if (a0.d(r3, false) == true) goto L19;
        return true;
    L19:
        return false;
    L7:
        if (a0.k(r3) == false) goto L9;
    L10:
        r2 = true;
        goto L12
    L9:
        if (a0.j(r3) == false) goto L11;
    L17:
        return false;
    }
}
