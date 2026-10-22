package com.bytedance.android.live.revlink.impl.pk.randompkcheck;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(HashMap<String, String> r4) {
        k r0 = (k) f.d(j.C0.a(), k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        String r2 = DataType.FALSE;
        if (r1 == null) goto L11;
        String r3 = r1.getAnchorId();
        if (r3 == null) goto L11;
    L12:
        r4.put("anchor_id", r3);
        if (r1 == null) goto L18;
        String r5 = r1.getIdStr();
        if (r5 == null) goto L18;
        r2 = r5;
    L18:
        r4.put("room_id", r2);
        return;
    L11:
        r3 = DataType.FALSE;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final String b(RandomMatchCheckSource r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L8;
        return "random_pk";
    L8:
        if (r3 != 2) goto L14;
        return "random_npk";
    L14:
        return "";
    }

    @JvmStatic
    public static final String c(RandomMatchCheckSource r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        int r3 = a.b[r2.ordinal()];
        if (r3 != 1) goto L8;
        return "setting";
    L8:
        if (r3 != 2) goto L10;
    L12:
        return "matching";
    L10:
        if (r3 == 3) goto L12;
        return "";
    }

    @JvmStatic
    public static final void d(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "isSucceed");
        HashMap r1 = new HashMap();
        r1.put("choice", "off");
        r1.put("source", r4);
        r1.put("is_succeed", r5);
        a(r1);
        n r6 = new n();
        Map<String, String> r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r7.putAll(r1);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        m.e.getClass();
        Object r9 = m.b(r8).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r9);
        ((i) ((f80.a) r9)).w3("livesdk_randommatch_announcements_setting", r6.a, r6.b);
    }
}
