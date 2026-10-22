package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 {
    public static com.larus.bmhome.view.screenmenu.l0 a(Message r43, com.larus.bmhome.chat.api.q0 r44, com.larus.bmhome.chat.api.q0.a r45) {
        Intrinsics.checkNotNullParameter(r43, "data");
        if (r44 == null) goto L5;
        String r2 = r44.W();
    L7:
        if (com.larus.bmhome.chat.adapter.h0.a(r43, r2) == true) goto L9;
        return null;
    L9:
        if (com.larus.bmhome.chat.bean.d.P0(r43) == true) goto L31;
        if (r45 == null) goto L16;
        u7 r3 = r45.u3();
        if (r3 == null) goto L16;
        boolean r4 = true;
        if (r3.W1() != true) goto L16;
    L17:
        if (r4 == false) goto L19;
        return null;
    L19:
        if (com.larus.bmhome.chat.adapter.h0.c(r43) == false) goto L33;
        Map r5 = r43.getExt();
        if (r5 == null) goto L23;
        String r6 = (String) r5.get("action_bar_key");
    L25:
        if (Intrinsics.areEqual(r6, "coco_record") == false) goto L27;
        return null;
    L27:
        if (com.larus.bmhome.chat.adapter.h0.e(r43) == false) goto L29;
        return null;
    L29:
        return new com.larus.bmhome.view.screenmenu.l0(2131907404, 2131907404, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971821, null, 2131241952)), null, false, false, null, null, "edit", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127);
    L23:
        r6 = null;
        goto L25
    L33:
        return null;
    L16:
        r4 = false;
        goto L17
    L31:
        return null;
    L5:
        r2 = null;
        goto L7
    }
}
