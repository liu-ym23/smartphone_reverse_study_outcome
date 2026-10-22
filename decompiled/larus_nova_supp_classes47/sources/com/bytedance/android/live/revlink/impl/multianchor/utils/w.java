package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w {
    public final ld.a a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public final i11.b a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = r0.R8();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getLinkUserCenter();
    L5:
        r1 = null;
        goto L6
    }

    public final UILayout b() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.ui.h r1 = r0.Cg();
    L6:
        if (r1 == null) goto L10;
        UILayout r2 = r1.getUILayout();
        if (r2 == null) goto L10;
        return r2;
    L10:
        return UILayout.Normal;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = r0.Do();
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.k0(64) != true) goto L10;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = r0.Do();
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.k0(4) != true) goto L10;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final int i() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.service.b r1 = r0.d6();
    L6:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.getWindowCount();
    L5:
        r1 = null;
        goto L6
    }

    public final boolean c() {
        if (d() == false) goto L5;
    L8:
        return true;
    L5:
        if (e() == true) goto L8;
        return false;
    }

    public final boolean g() {
        if (e() == false) goto L20;
        ld.a r0 = this.a;
        Boolean r1 = null;
        if (r0 == null) goto L9;
        NextLiveData r2 = r0.Fc();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
    L10:
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r4) == true) goto L19;
        ld.a r5 = this.a;
        if (r5 == null) goto L18;
        NextLiveData r6 = r5.z9();
        if (r6 == null) goto L18;
        r1 = (Boolean) r6.getValue();
    L18:
        if (Intrinsics.areEqual(r1, r4) == false) goto L20;
    L19:
        return true;
    L9:
        r3 = null;
    L20:
        return false;
    }

    public final int h() {
        i11.b r0 = a();
        if (r0 == null) goto L7;
        List<com.bytedance.android.livesdk.link.model.p> r1 = r0.getOnlineUserList();
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    public static boolean f(w r2) {
        com.bytedance.android.live.revlink.impl.global.c r0 = r2.b;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.utils.s r3 = r0.getRevLinkCommonUtil();
    L6:
        if (r3 == null) goto L8;
        String r4 = r3.e();
    L9:
        com.bytedance.android.live.revlink.impl.global.c r5 = r2.b;
        if (r5 == null) goto L12;
        r1 = r5.u5();
    L12:
        if (r1 != null) goto L16;
        return false;
    L16:
        return r1.N(r4);
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public w(ld.a r1, LinkFakeGlobalService r2) {
        this.a = r1;
        this.b = r2;
    }
}
