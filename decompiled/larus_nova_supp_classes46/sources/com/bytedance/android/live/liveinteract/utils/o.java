package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface o {

    public static final class a {
        public static void a(o r11, LinkMonitorData r12, String r13, int r14, Integer r15, String r16, Boolean r17, Map r18, int r19) {
            Map r2 = null;
            if ((r19 & 2) == 0) goto L5;
            String r0 = null;
        L7:
            if ((r19 & 4) == 0) goto L9;
            int r5 = 0;
        L11:
            if ((r19 & 8) == 0) goto L13;
            Integer r3 = null;
        L15:
            if ((r19 & 16) == 0) goto L17;
            String r6 = null;
        L19:
            if ((r19 & 32) == 0) goto L21;
            Boolean r7 = null;
        L23:
            if ((r19 & 64) != 0) goto L26;
            r2 = r18;
        L26:
            Intrinsics.checkNotNullParameter(r12, "linkMonitorData");
            LinkMonitorData r8 = LinkMonitorData.StartXPlayBasic;
            if (r8 != r12) goto L30;
            ff0.g.d = System.currentTimeMillis();
        L30:
            if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L34;
            if (r8 != r12) goto L34;
            ff0.g.c = false;
        L34:
            if (Intrinsics.areEqual(r7, Boolean.FALSE) == false) goto L38;
            if (r8 != r12) goto L38;
            ff0.g.c = true;
        L38:
            if (LinkMonitorData.LoadXplayBasic != r12) goto L42;
            if (r5 != 0) goto L42;
            ff0.g.c = true;
        L42:
            if (LinkMonitorData.XplayShowAndFirstFrameSuccess == r12) goto L44;
        L46:
            if (r7 == null) goto L48;
            r7.booleanValue();
            ff0.g.a = r7.booleanValue();
        L48:
            if (r0 == null) goto L50;
            ff0.g.b = r0;
        L50:
            JSONObject r4 = new JSONObject();
            if (ff0.g.a == false) goto L53;
            String r1 = "first";
        L54:
            r4.put("create_type", r1);
            r4.put("game_id", ff0.g.b);
            if (r3 == null) goto L57;
            r3.intValue();
            r4.put("reason", r3.intValue());
        L57:
            if (r6 == null) goto L59;
            r4.put("failure_reason", r6);
        L59:
            if (r2 == null) goto L64;
            Iterator r9 = r2.entrySet().iterator();
        L62:
            if (r9.hasNext() == false) goto L64;
            Map.Entry r10 = (Map.Entry) r9.next();
            r4.put((String) r10.getKey(), r10.getValue());
        L64:
            r4.put("duration", System.currentTimeMillis() - ff0.g.d);
            nd0.c.p(nd0.c.a, r12, r4, MultiLinkEventModule.INTERACT_XPLAY, r5, null, false, null, 112);
            return;
        L53:
            r1 = "retry";
            goto L54
        L44:
            if (ff0.g.c == true) goto L46;
            return;
        L21:
            r7 = r17;
            goto L23
        L17:
            r6 = r16;
            goto L19
        L13:
            r3 = r15;
            goto L15
        L9:
            r5 = r14;
            goto L11
        L5:
            r0 = r13;
            goto L7
        }
    }
}
