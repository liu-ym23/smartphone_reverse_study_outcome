package com.obric.assistant.special_input.util;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ AssistantInteractionListenerIDLWrapper b;

    public /* synthetic */ f(String r1, AssistantInteractionListenerIDLWrapper r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        return AssistantInteractionListenerIDLWrapper.a(this.a, this.b);
    }
}
