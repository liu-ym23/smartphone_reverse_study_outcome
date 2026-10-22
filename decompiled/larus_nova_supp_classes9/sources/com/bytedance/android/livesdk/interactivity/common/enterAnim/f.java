package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import com.bytedance.android.live.base.model.message.g4;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.livesdk.message.model.pg;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Long a(k32.d r1) {
        Intrinsics.checkNotNullParameter(r1, "userInfo");
        h3 r2 = r1.t;
        if (r2 == null) goto L9;
        com.bytedance.android.live.base.model.message.d r3 = r2.I0();
        if (r3 == null) goto L9;
        com.bytedance.android.live.base.model.message.e r4 = r3.a();
        if (r4 == null) goto L9;
        return r4.b();
    L9:
        return null;
    }

    public static boolean b(k32.a r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        if ((r1 instanceof k32.d) == false) goto L13;
        g4.e0.getClass();
        List r0 = g4.a.d;
        h3 r2 = ((k32.d) r1).t;
        if (r2 == null) goto L9;
        pg.c r3 = r2.M();
        if (r3 == null) goto L9;
        String r4 = r3.getScene();
    L11:
        if (CollectionsKt.contains(r0, r4) == false) goto L13;
        return true;
    L9:
        r4 = null;
    L13:
        return false;
    }
}
