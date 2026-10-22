package com.larksuite.component.ui.dialog;

import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j implements UDBaseDialogBuilder.c {
    public final d.a<LKUIDialog> a;

    public j(d.a<LKUIDialog> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
    public final void a(UDDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        this.a.b((LKUIDialog) r2);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
    public final void beforeCreate(UDDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        this.a.a((LKUIDialog) r2);
    }
}
