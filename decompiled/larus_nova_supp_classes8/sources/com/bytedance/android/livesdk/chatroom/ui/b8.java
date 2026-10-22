package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b8 implements View.OnClickListener {
    public final /* synthetic */ NewPanelAudienceResolutionPickerDialog.ResolutionItemView a;
    public final /* synthetic */ l5 b;

    public b8(NewPanelAudienceResolutionPickerDialog.ResolutionItemView r1, l5 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        String r5 = this.b.e;
        if (Intrinsics.areEqual(r5, "disable") == false) goto L6;
        String r6 = rm3.c.a;
        rm3.c.g(this.a.getContext(), this.a.getContext().getString(2131915072), 0, false, 28);
        return;
    L6:
        l5 r0 = this.b;
        String r1 = "selected";
        if (Intrinsics.areEqual(r5, "selected") == false) goto L9;
        r1 = "unselected";
    L9:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.e = r1;
        this.a.b.invoke(this.b.b);
    }
}
