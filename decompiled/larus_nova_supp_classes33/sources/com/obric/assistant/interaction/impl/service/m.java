package com.obric.assistant.interaction.impl.service;

import com.obric.assistant.interaction.base.interact.CustomBarAction;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ Collection a;

    public /* synthetic */ m(Collection r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return Boolean.valueOf(InteractionStateServiceImpl.l(this.a, (CustomBarAction) r2));
    }
}
