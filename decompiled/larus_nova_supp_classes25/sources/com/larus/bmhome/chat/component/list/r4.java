package com.larus.bmhome.chat.component.list;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r4 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ r4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        BotModel r2 = r0.j0();
        if (r2 == null) goto L7;
        BotIconImage r3 = r2.getIconImage();
        if (r3 == null) goto L7;
        String r4 = r3.getOriginUrl();
    L8:
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L16;
        return r4;
    L16:
        return "res://" + AppHost.a.getApplication().getPackageName() + "/2131240119";
    L10:
        if (r4.length() == 0) goto L13;
        r5 = false;
    L7:
        r4 = null;
        goto L8
    }
}
