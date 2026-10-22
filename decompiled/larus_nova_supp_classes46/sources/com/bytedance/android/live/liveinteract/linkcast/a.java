package com.bytedance.android.live.liveinteract.linkcast;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rj0.k;
import rj0.l;
import uf2.m1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkcast.a$a, reason: collision with other inner class name */
    public static final class C0037a {
        public static void a(ti6.f r8) {
            Intrinsics.checkNotNullParameter(r8, "region");
            k.m2.getClass();
            k r9 = k.a.a();
            if (r9 != null) goto L5;
            return;
        L5:
            if (r9.isLinkCasting() != true) goto L9;
            k r10 = k.a.a();
            Intrinsics.checkNotNull(r10);
            r10.Jj();
            int r11 = d.a;
            JSONObject r3 = new JSONObject();
            r3.put("is_config_null", String.valueOf(true));
            r3.put("left_margin", String.valueOf(0.0f));
            r3.put("top_margin", String.valueOf(0.0f));
            r3.put("width_ratio", String.valueOf(0.0f));
            r3.put("height_ratio", String.valueOf(0.0f));
            nd0.c.o(nd0.c.a, LinkMonitorData.LinkCastAnchorAdjustRtcMixLayout, r3, 0, null, false, 28);
            return;
        }

        public static void b(m1.b r2, boolean r3, int r4) {
            k.m2.getClass();
            k r0 = k.a.a();
            if (r0 != null) goto L5;
        L6:
            l.n2.getClass();
            l r1 = l.a.a();
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.isLinkCasting() != true) goto L17;
        L10:
            if (r3 == true) goto L12;
            return;
        L12:
            if (r4 == 7) goto L19;
            if (r2 == null) goto L20;
            r2.g();
            return;
        L20:
            return;
        L19:
            return;
        L17:
            return;
        L5:
            if (r0.isLinkCasting() == true) goto L10;
            goto L6
        }
    }

    static {
    }
}
