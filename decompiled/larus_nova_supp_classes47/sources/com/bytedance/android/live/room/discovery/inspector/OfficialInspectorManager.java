package com.bytedance.android.live.room.discovery.inspector;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.gc1;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class OfficialInspectorManager {
    public static final Companion b = null;
    public DataCenter a;

    public static final class Companion {
        public Companion() {
        }

        public static boolean b() {
            return Intrinsics.areEqual(gc1.a.getValue(), Boolean.TRUE);
        }

        public static void a(Context r4, d90.a r5, kj r6) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "liveLayerContext");
            if (r6 != null) goto L6;
            return;
        L6:
            if (jr1.b.a(r5) == true) goto L8;
        L10:
            boolean r0 = false;
        L12:
            if (r0 == true) goto L20;
            StringBuilder r7 = new StringBuilder("show official inspector dialog failed: isAnchor is ");
            r7.append(jr1.b.a(r5));
            r7.append(". LiveMode is ");
            LiveMode r8 = d90.c.o(r5);
            if (r8 == null) goto L16;
            String r9 = r8.toString();
        L17:
            r7.append(r9);
            ALogger.e("OfficialInspectorManager", r7.toString());
            return;
        L16:
            r9 = null;
            goto L17
        L20:
            if (b() == true) goto L23;
            ALogger.e("OfficialInspectorManager", "show official inspector dialog failed: setting enable is " + b());
            return;
        L23:
            lm3.c r10 = new lm3.c();
            r10.b = s1.B(2131911615);
            ArrayList r1 = new ArrayList();
            r1.add(r10);
            lm3.d.a r12 = new lm3.d.a(r4);
            r12.a = sb2.a.h(r6.noticeTitle, "", false).toString();
            r12.b = sb2.a.h(r6.E(), "", false).toString();
            r12.c = r6.iconUrl;
            OfficialInspectorManager$Companion$handleOfficialInspectorRemindMsg$1 r13 = OfficialInspectorManager$Companion$handleOfficialInspectorRemindMsg$1.INSTANCE;
            Intrinsics.checkNotNullParameter(r13, "imageLoader");
            r12.m = r13;
            r12.i = true;
            r12.e = r1;
            r12.a().setCanceledOnTouchOutside(false);
            return;
        L8:
            if (d90.c.o(r5) != LiveMode.VIDEO) goto L10;
            r0 = true;
            goto L12
        }
    }

    static {
        b = new Companion();
    }

    public OfficialInspectorManager() {
    }
}
