package com.larus.bmhome.taskskill;

import com.larus.dispatcher.api.GetAllDevicesRepo;
import ic8.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class m0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ m0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r3, "it");
        GetAllDevicesRepo r4 = GetAllDevicesRepo.a;
        Integer r5 = GetAllDevicesRepo.c(r0.w5());
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.toString();
    }
}
