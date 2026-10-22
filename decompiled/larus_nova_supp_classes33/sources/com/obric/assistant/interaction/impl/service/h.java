package com.obric.assistant.interaction.impl.service;

import com.obric.assistant.interaction.base.interact.CustomBarAction;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ CustomBarAction a;

    public /* synthetic */ h(CustomBarAction r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return Boolean.valueOf(InteractionStateServiceImpl.g(this.a, (CustomBarAction) r2));
    }
}
