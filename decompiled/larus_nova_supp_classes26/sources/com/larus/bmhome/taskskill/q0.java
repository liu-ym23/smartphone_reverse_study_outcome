package com.larus.bmhome.taskskill;

import com.larus.platform.service.o;
import ic8.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class q0 implements Function1 {
    public /* synthetic */ q0() {
    }

    public final Object invoke(Object r2) {
        Regex r0 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r2, "it");
        String r3 = o.a.getDeviceId();
        if (r3.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L10;
        return null;
    L10:
        return r3;
    L5:
        r1 = false;
        goto L6
    }
}
