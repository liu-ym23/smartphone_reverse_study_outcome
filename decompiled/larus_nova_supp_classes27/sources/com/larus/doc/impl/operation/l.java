package com.larus.doc.impl.operation;

import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l implements u {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ by7.e f;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        FLogger.a.i("DocListPage", "delete cancel");
        u0.f(this.a, "0", "cancel", "delete", this.b, this.c, Integer.valueOf(this.d), this.e, null, this.f, 256);
    }

    public l(String r1, String r2, String r3, int r4, String r5, by7.e r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
