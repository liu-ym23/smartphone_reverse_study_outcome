package com.larksuite.component.card.plugin.select;

import android.view.Window;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements UDBaseDialogBuilder.c {
    public g() {
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
    public final void a(UDDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
    public final void beforeCreate(UDDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Window r3 = r2.getWindow();
        if (r3 == null) goto L6;
        r3.addFlags(512);
        return;
    }
}
