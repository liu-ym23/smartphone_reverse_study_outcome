package com.obric.assistant.settings.experience;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import n38.a;
import n38.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricUserExperiencePlanManager$c implements j {
    public ObricUserExperiencePlanManager$c() {
    }

    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        StateFlowImpl r3 = ObricUserExperiencePlanManager.d;
        ObricUserExperiencePlanManager r0 = ObricUserExperiencePlanManager.a;
        r3.setValue(ObricUserExperiencePlanManager.e());
    }

    public final void b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ObricUserExperiencePlanManager r3 = ObricUserExperiencePlanManager.a;
        ObricUserExperiencePlanManager.g();
    }
}
