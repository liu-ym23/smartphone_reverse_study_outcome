package com.larus.bmhome.taskskill;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ c0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        SkillComponent r0 = this.a;
        Regex r1 = SkillComponent.F2;
        if (Intrinsics.areEqual((Boolean) r7, Boolean.TRUE) == false) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(s1a.a.c(r0).getViewLifecycleOwner()), null, null, new SkillComponent$onViewCreated$3$1(null), 3, null);
    L6:
        return Unit.INSTANCE;
    }
}
