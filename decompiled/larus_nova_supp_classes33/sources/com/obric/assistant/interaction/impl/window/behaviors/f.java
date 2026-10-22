package com.obric.assistant.interaction.impl.window.behaviors;

import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ ActivityStartBehavior$PendingInternalActivityRecord a;

    public /* synthetic */ f(ActivityStartBehavior$PendingInternalActivityRecord r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return Boolean.valueOf(ActivityStartBehavior.activityLifecycleCallback.1.a(this.a, (Map.Entry) r2));
    }
}
