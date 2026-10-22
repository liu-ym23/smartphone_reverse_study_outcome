package com.larus.bmhome.utils;

import com.larus.bmhome.auth.ContinueCallConf;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static lq9.h0 a(b r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (com.larus.platform.service.i3.a.i() == true) goto L5;
        ICoreInputAbility r0 = r4.getAbility(ICoreInputAbility.class);
        boolean r1 = false;
        if (r0 == null) goto L13;
        z8.a r2 = r0.Jd();
        if (r2 == null) goto L13;
        if (r2.a != true) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r5 = r4.getAbility(com.larus.bmhome.chat.component.bottom.attachment.g1.class);
        if (r5 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == true) goto L25;
        com.larus.bmhome.chat.component.bottom.reference.a r7 = r4.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);
        if (r7 != null) goto L29;
    L31:
        if (r1 == true) goto L33;
        LaunchInfo r8 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r8 == null) goto L42;
        ContinueCallConf r9 = r8.E();
        if (r9 == null) goto L42;
        return new lq9.h0(r9.b(), r9.a(), r9.d(), r9.c());
    L42:
        return lq9.h0.e;
    L33:
        return lq9.h0.e;
    L29:
        if (r7.i9() != true) goto L31;
        r1 = true;
        goto L31
    L25:
        return lq9.h0.e;
    L20:
        if (r5.isVisible() != true) goto L22;
        r6 = true;
        goto L23
    L16:
        return lq9.h0.e;
    L13:
        r3 = false;
        goto L14
    L5:
        return lq9.h0.e;
    }
}
