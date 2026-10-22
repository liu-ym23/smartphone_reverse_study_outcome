package com.ss.android.lark.chat.preview.actions;

import android.content.DialogInterface;
import com.ss.android.lark.chat.entity.preview.ShowDialogAction;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ ShowDialogAction.a a;
    public final /* synthetic */ b b;
    public final /* synthetic */ int c;

    public c(ShowDialogAction.a r1, b r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        String r6 = this.a.c;
        if (r6 == null) goto L10;
        b r7 = this.b;
        int r0 = this.c;
        Map<String, UrlPreviewAction> r1 = r7.e;
        if (r1 == null) goto L7;
        UrlPreviewAction r2 = r1.get(r6);
    L8:
        a.a(r2, r6, null, r7.d, null).a(r0 + 1);
        return;
    L7:
        r2 = null;
        goto L8
    }
}
