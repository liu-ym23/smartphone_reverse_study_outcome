package com.larksuite.component.card.plugin.select;

import android.content.Context;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.color.UDColorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends com.larksuite.component.ui.dialog.d.a<LKUIDialog> {
    public final /* synthetic */ Context a;

    public c(Context r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.ui.dialog.d.a
    public final void a(LKUIDialog r3) {
        r3.getContext();
        j08.a r0 = new j08.a(r3.getWindow());
        r0.b = UDColorUtils.getColor(this.a, 2131100548);
        r0.a();
    }
}
