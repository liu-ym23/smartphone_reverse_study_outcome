package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        public static boolean a() {
            com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r0 == null) goto L11;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L11;
            Map r2 = r1.getAnchorABMap();
            if (r2 == null) goto L11;
            String r3 = (String) r2.get("live_invite_panel_opt");
            if (r3 == null) goto L11;
            Integer r4 = StringsKt.toIntOrNull(r3);
        L12:
            if (r4 != null) goto L15;
        L17:
            return false;
        L15:
            if (r4.intValue() != 2) goto L17;
            return true;
        L11:
            r4 = null;
            goto L12
        }

        public static boolean b() {
            com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r0 == null) goto L11;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L11;
            Map r2 = r1.getAnchorABMap();
            if (r2 == null) goto L11;
            String r3 = (String) r2.get("live_invite_panel_opt");
            if (r3 == null) goto L11;
            Integer r4 = StringsKt.toIntOrNull(r3);
        L12:
            if (r4 != null) goto L15;
        L17:
            return false;
        L15:
            if (r4.intValue() != 3) goto L17;
            return true;
        L11:
            r4 = null;
            goto L12
        }
    }

    static {
        a = new a();
    }
}
