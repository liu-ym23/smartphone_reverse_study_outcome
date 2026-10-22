package com.obric.assistant.obric_action.handler.prompt;

import com.larus.common_ui.dialog.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o implements p0 {
    public final /* synthetic */ Function1<j, Unit> a;
    public final /* synthetic */ PromptOptionsDialogActionHandler b;
    public final /* synthetic */ PromptOptionsDialogActionHandler.b c;

    public final void confirm() {
        this.a.invoke(PromptOptionsDialogActionHandler.e(this.b, this.c));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function1<? super j, Unit> r1, PromptOptionsDialogActionHandler r2, PromptOptionsDialogActionHandler.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
