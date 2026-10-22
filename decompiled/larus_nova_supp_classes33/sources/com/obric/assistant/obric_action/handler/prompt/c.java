package com.obric.assistant.obric_action.handler.prompt;

import com.larus.common_ui.dialog.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements u {
    public final /* synthetic */ Function1<j, Unit> a;

    public final void cancel() {
        this.a.invoke(new j("dismissed", 14));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super j, Unit> r1) {
        this.a = r1;
    }
}
