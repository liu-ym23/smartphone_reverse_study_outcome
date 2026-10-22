package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.multitask.LiveInnerIndependentManager;
import com.bytedance.android.livesdk.floatview.p;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import np1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class IndependentTaskItem {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static np1.b a(final np1.c r4) {
        Intrinsics.checkNotNullParameter(r4, "panelContext");
        Intrinsics.checkNotNullParameter(r4, "panelContext");
        boolean r0 = LiveInnerIndependentManager.a;
        boolean r1 = false;
        if (LiveInnerIndependentManager.b() == false) goto L16;
        int r2 = SmallWindowItem.a;
        DataCenter r3 = r4.getDataCenter();
        if (r3 != null) goto L7;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == true) goto L16;
        r1 = true;
        goto L16
    L7:
        if (z.e(r3, false) == true) goto L13;
        if (z.m(r3, true) == false) goto L13;
        if (p.c() == false) goto L13;
        r5 = true;
    L16:
        if (r1 == true) goto L19;
        return null;
    L19:
        np1.b.a r6 = np1.b.a;
        Function0<g> r7 = new IndependentTaskItem$provide$1(r4);
        IndependentTaskItem$provide$2 r8 = IndependentTaskItem$provide$2.INSTANCE;
        r6.getClass();
        return np1.b.a.a(r7, r8);
    }
}
