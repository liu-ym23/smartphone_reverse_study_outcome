package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h3 {
    public static final Set<String> a = null;

    static {
        a = (Set) com.bytedance.android.livesdk.sharedpref.b.p0.getValue();
    }

    @JvmStatic
    public static final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, LiveEndPageData.TAG_NAME);
        return a.contains(r1);
    }

    @JvmStatic
    public static final void b(DataCenter r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Set<String> r0 = a;
        r0.add(r2);
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.p0;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r0);
        y3.m(r1).b(ToolbarButton.INTERACT_GAME, new pp1.e());
    }
}
