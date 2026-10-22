package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final int a(ReceiverType r4) {
        IRoomBase r0 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r0 != null) goto L5;
    L7:
        if (r4 != null) goto L16;
        i12.d r5 = i12.m.e2.a();
        if (r5 == null) goto L11;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r6 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(f.class));
    L12:
        f r7 = (f) r6;
        if (r7 == null) goto L15;
        r4 = r7.b;
        goto L16
    L15:
        r4 = null;
        goto L16
    L11:
        r6 = null;
    L16:
        if (r4 != null) goto L19;
        r4 = ReceiverType.Anchor;
    L19:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.d() == false) goto L22;
        return 16;
    L22:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.c() == false) goto L25;
        return 32;
    L25:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.b() == false) goto L28;
        return 64;
    L28:
        if (r4 != ReceiverType.AllMic) goto L31;
        return 512;
    L31:
        if (r4 != ReceiverType.Audience) goto L34;
        return 1024;
    L34:
        if (r4 != ReceiverType.OtherAnchor) goto L37;
        return 4;
    L37:
        if (r4 == ReceiverType.GroupLive) goto L47;
        return 1;
    L47:
        return 128;
    L5:
        if (x12.a.b(r0) != true) goto L7;
        return 128;
    }
}
