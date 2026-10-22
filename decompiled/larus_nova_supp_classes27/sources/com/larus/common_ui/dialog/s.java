package com.larus.common_ui.dialog;

import com.larus.common_ui.widget.UrlSpanTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements UrlSpanTextView.a {
    public final /* synthetic */ BasicModeDialog a;

    public s(BasicModeDialog r1) {
        this.a = r1;
    }

    @Override // com.larus.common_ui.widget.UrlSpanTextView.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        if (Intrinsics.areEqual(r2, "tos") == false) goto L8;
        k1 r3 = this.a.e;
        if (r3 == null) goto L13;
        r3.a();
        return;
    L13:
        return;
    L8:
        if (Intrinsics.areEqual(r2, "pp") == false) goto L15;
        k1 r4 = this.a.e;
        if (r4 == null) goto L16;
        r4.b();
        return;
    L16:
        return;
    }
}
