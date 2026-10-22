package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w0 {

    public static final class a {
    }

    static {
    }

    public static com.larus.bmhome.view.screenmenu.l0 b() {
        if (AppHost.a.isPlugin() == false) goto L5;
        return null;
    L5:
        return new com.larus.bmhome.view.screenmenu.l0(MenuActionType.SHARE_IMAGE.getType(), 2131906512, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971829, null, 2131241973)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127);
    }

    public static com.larus.bmhome.view.screenmenu.l0 c() {
        if (AppHost.a.isPlugin() == false) goto L5;
        return null;
    L5:
        return new com.larus.bmhome.view.screenmenu.l0(MenuActionType.SHARE_VIDEO.getType(), 2131906512, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971829, null, 2131241973)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127);
    }

    public static com.larus.bmhome.view.screenmenu.l0 a(Message r84, com.larus.bmhome.chat.api.q0.a r85) {
        Intrinsics.checkNotNullParameter(r84, "data");
        z2 r1 = z2.a;
        boolean r3 = false;
        if (r1.getShareConfig().h() == false) goto L27;
        if (r85 == null) goto L12;
        IChatMessageShareAbility r4 = r85.J9();
        if (r4 == null) goto L12;
        if (r4.yk(r84) != true) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L27;
        com.larus.bmhome.chat.component.cvs.y r2 = r85.u0();
        if (r2 == null) goto L22;
        BotModel r5 = r2.j0();
        if (r5 == null) goto L22;
        ShareInfo r6 = r5.getShareInfo();
        if (r6 == null) goto L22;
        boolean r7 = Intrinsics.areEqual(r6.isShowMessageShare(), Boolean.TRUE);
    L23:
        if (r7 == false) goto L27;
        r3 = true;
    L22:
        r7 = false;
    L12:
        r0 = false;
    L27:
        if (r3 == true) goto L30;
        return null;
    L30:
        if (ShareServiceDelegate.b.m() == true) goto L33;
        return null;
    L33:
        if (r1.longPressShowMultiSelect() == false) goto L37;
        return new com.larus.bmhome.view.screenmenu.l0(2131907411, 2131907411, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971823, null, 2131241958)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127);
    L37:
        return new com.larus.bmhome.view.screenmenu.l0(2131900868, 2131900868, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971829, null, 2131241973)), null, false, false, null, null, "share", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127);
    }
}
