package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.component.list.pipeline.direct_add.UserActiveDeleteTipHelper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public n() {
    }

    public static com.larus.bmhome.view.screenmenu.l0 a() {
        int r0 = UserActiveDeleteTipHelper.a;
        int r1 = ra9.a.a;
        boolean r2 = Intrinsics.areEqual(ga9.a.e("delete_msg_tip_display", "0"), "2");
        if (r2 == false) goto L5;
        int r3 = 2131908926;
    L7:
        if (r2 == false) goto L9;
        int r14 = v19.c.b(2130971723, null, 2131241355);
    L10:
        Integer r15 = Integer.valueOf(r14);
        if (r2 == false) goto L13;
        AppHost.Companion r4 = AppHost.a;
        Integer r18 = Integer.valueOf(v19.c.c(2130970996, r4.a().getCurrentActivity(), ContextCompat.getColor(r4.getApplication(), 2131102650)));
    L15:
        return new com.larus.bmhome.view.screenmenu.l0(2131907182, r3, null, null, null, 2131102650, null, null, null, false, false, null, r15, null, false, false, r18, null, "delete", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -659496, 127);
    L13:
        r18 = null;
        goto L15
    L9:
        r14 = 2131241933;
        goto L10
    L5:
        r3 = 2131907182;
        goto L7
    }

    public static List b(n r5, Context r6, BotModel r7, boolean r8, int r9) {
        if ((r9 & 2) == 0) goto L5;
        r7 = null;
    L5:
        boolean r1 = true;
        if ((r9 & 4) == 0) goto L8;
        boolean r10 = true;
    L10:
        if ((r9 & 8) == 0) goto L12;
        r8 = false;
    L12:
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r8 == true) goto L29;
        if (r7 == null) goto L25;
        List r11 = r7.getMenuActions();
        if (r11 == null) goto L25;
        Iterator r12 = r11.iterator();
    L19:
        if (r12.hasNext() == false) goto L23;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((AnswerAction) r13).getKey(), "delete") == false) goto L19;
    L24:
        AnswerAction r14 = (AnswerAction) r13;
    L26:
        if (r14 != null) goto L29;
        r1 = false;
        goto L29
    L23:
        r13 = null;
    L25:
        r14 = null;
    L29:
        if (r1 == false) goto L39;
        ArrayList r15 = new ArrayList();
        if (r10 == false) goto L34;
        Intrinsics.checkNotNullParameter(r6, "context");
        r15.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r6, v19.c.b(2130972086, null, 2131103159))));
    L34:
        r15.add(a());
        return r15;
    L39:
        return new ArrayList();
    L8:
        r10 = false;
        goto L10
    }
}
