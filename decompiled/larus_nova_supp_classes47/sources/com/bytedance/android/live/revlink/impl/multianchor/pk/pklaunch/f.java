package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.w2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final boolean a(IBattleConfigSetting r6, IBattleConfigSetting r7) {
        if (r6 != null) goto L4;
        r6 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r6.setModType(PkBaseDataContext.PKModType.Default.getType());
    L4:
        if (r7 != null) goto L6;
        r7 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r7.setModType(PkBaseDataContext.PKModType.Default.getType());
    L6:
        Intrinsics.checkNotNullParameter(r6, "$this$isCompatMessage");
        Intrinsics.checkNotNullParameter(r7, "setting");
        if (r6.getModType() != r7.getModType()) goto L32;
        w2 r0 = r6.getShellConfig();
        long r3 = 0;
        if (r0 == null) goto L12;
        long r1 = r0.getType();
    L13:
        w2 r5 = r7.getShellConfig();
        if (r5 == null) goto L17;
        r3 = r5.getType();
    L17:
        if (r1 != r3) goto L33;
        w2 r8 = r6.getShellConfig();
        String r2 = "";
        if (r8 == null) goto L23;
        String r9 = r8.getName();
        if (r9 == null) goto L23;
    L24:
        w2 r10 = r7.getShellConfig();
        if (r10 == null) goto L31;
        String r12 = r10.getName();
        if (r12 == null) goto L31;
        r2 = r12;
    L31:
        return Intrinsics.areEqual(r9, r2);
    L23:
        r9 = "";
        goto L24
    L33:
        return false;
    L12:
        r1 = 0;
        goto L13
    L32:
        return false;
    }
}
