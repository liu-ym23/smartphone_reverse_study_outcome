package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class MorePanelButtonLogNameHelper {
    public static final Lazy a = null;
    public static final MorePanelButtonLogNameHelper b = null;

    public MorePanelButtonLogNameHelper() {
    }

    static {
        b = new MorePanelButtonLogNameHelper();
        a = LazyKt.lazy(MorePanelButtonLogNameHelper$map$2.INSTANCE);
    }

    public static String a(DataCenter r2, ExtendedToolbarButton r3) {
        if ((r3 instanceof ExtendedToolbarButton.b) == false) goto L9;
        String r4 = (String) ((Map) a.getValue()).get(((ExtendedToolbarButton.b) r3).i);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return r3.f();
    L9:
        if ((r3 instanceof ExtendedToolbarButton.c) == true) goto L11;
        r3 = null;
    L11:
        ExtendedToolbarButton.c r5 = (ExtendedToolbarButton.c) r3;
        if (r5 == null) goto L30;
        if (r2 == null) goto L30;
        MorePanelDynamicControllerViewModel.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c r6 = MorePanelDynamicControllerViewModel.Companion.a(r2);
        if (r6 == null) goto L30;
        Integer r7 = StringsKt.toIntOrNull(r5.s);
        if (r7 == null) goto L19;
        int r8 = r7.intValue();
    L20:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.f r9 = r6.getServerConfigStyleInfo(r8);
        if (r9 == null) goto L30;
        String r10 = r9.c;
        if (r10 == null) goto L30;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r10) == true) goto L28;
        r10 = null;
    L28:
        if (r10 == null) goto L30;
        return r10;
    L19:
        r8 = -1;
    L30:
        return null;
    }
}
