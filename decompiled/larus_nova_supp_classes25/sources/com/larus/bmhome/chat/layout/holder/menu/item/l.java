package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public static com.larus.bmhome.view.screenmenu.l0 a() {
        if (AppHost.a.isTestChannel() == true) goto L13;
        if (AuthModelDelegate.b.s() == true) goto L13;
        if (com.larus.platform.service.s.a.h() == true) goto L13;
        if (com.larus.platform.service.g0.a.m() == true) goto L13;
        return null;
    L13:
        return new com.larus.bmhome.view.screenmenu.l0(2131907402, 2131907402, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971822, null, 2131241955)), null, false, false, null, null, "debug", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127);
    }
}
