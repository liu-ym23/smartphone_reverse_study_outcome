package com.larus.bot.impl.feature.edit.feature.autofill;

import com.larus.common_ui.dialog.u;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import tx9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements u {
    public final /* synthetic */ BotAutoFillUIBinder a;
    public final /* synthetic */ Ref.ObjectRef<Job> b;

    public final void cancel() {
        this.a.c.dispatchUIAction(new a.b(false));
        BotAutoFillUIBinder r0 = this.a;
        dv8.b r1 = r0.d;
        if (r1 == null) goto L5;
        c0.I(r1.f(), r0.d.d(), r0.d.o(), r0.d.c(), "auto_fill_skip", "auto_fill", r0.d.i(), r0.d.h(), r0.a, 513);
    L5:
        Job r2 = (Job) this.b.element;
        if (r2 == null) goto L9;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        return;
    }

    public g(BotAutoFillUIBinder r1, Ref.ObjectRef<Job> r2) {
        this.a = r1;
        this.b = r2;
    }
}
