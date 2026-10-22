package com.bytedance.android.annie.container.dialog;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.card.web.WebComponent;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements IHybridComponent.b {
    public final /* synthetic */ BaseDialogFragment a;

    public b(BaseDialogFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent.b
    public final void a(WebComponent r1, int r10, int r11, int r12, int r13) {
        BaseDialogFragment r14 = this.a;
        if (r12 > r11) goto L7;
        boolean r15 = true;
        if (r11 >= 1) goto L7;
    L8:
        r14.l = r15;
        Iterator r16 = ((ArrayList) r14.m).iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        ((HybridDialog.a) r16.next()).onScroll(r11 - r13);
        goto L10
    L12:
        return;
    L7:
        r15 = false;
        goto L8
    }
}
