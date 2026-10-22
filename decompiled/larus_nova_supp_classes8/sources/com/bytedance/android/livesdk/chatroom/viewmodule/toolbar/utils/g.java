package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.bytedance.android.live.base.model.morepanel.AreaPattern;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.config.da0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static final ArrayList<Integer> a = null;

    static {
        a = CollectionsKt.arrayListOf(new Integer[]{1, 2});
    }

    @JvmStatic
    public static final boolean b() {
        Integer r0 = da0.a.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 2) goto L8;
        return true;
    }

    @JvmStatic
    public static final boolean a(DataCenter r4) {
        MorePanelDynamicControllerViewModel.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.d r0 = MorePanelDynamicControllerViewModel.Companion.a(r4);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (z.e(r4, false) == false) goto L7;
        return false;
    L7:
        if (z.m(r4, true) == true) goto L9;
        return false;
    L9:
        if (a.contains(da0.a.getValue()) == false) goto L19;
        if (r0 == null) goto L12;
        AreaPattern r5 = (AreaPattern) r0.getServerPanelPattern();
    L13:
        if (r5 == null) goto L20;
        return true;
    L20:
        return false;
    L12:
        r5 = null;
        goto L13
    L19:
        return false;
    }
}
