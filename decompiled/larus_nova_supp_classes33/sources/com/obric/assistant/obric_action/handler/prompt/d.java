package com.obric.assistant.obric_action.handler.prompt;

import com.larus.common_ui.dialog.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements p0 {
    public final /* synthetic */ Function1<j, Unit> a;

    public final void confirm() {
        this.a.invoke(new j("confirmed", 14));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super j, Unit> r1) {
        this.a = r1;
    }
}
