package com.larus.bmhome.chat.list.cell.text.user;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w implements Function2 {
    public final /* synthetic */ UserTextCell a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ View.OnClickListener c;
    public final /* synthetic */ View.OnLongClickListener d;

    public /* synthetic */ w(UserTextCell r1, TextView r2, View.OnClickListener r3, View.OnLongClickListener r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r9, Object r10) {
        UserTextCell r3 = this.a;
        TextView r6 = this.b;
        View.OnClickListener r1 = this.c;
        View.OnLongClickListener r2 = this.d;
        com.larus.bmhome.chat.markdown.richtext.g r11 = (com.larus.bmhome.chat.markdown.richtext.g) r9;
        boolean r7 = ((Boolean) r10).booleanValue();
        int r12 = UserTextCell.z;
        Intrinsics.checkNotNullParameter(r11, "link");
        String r4 = r11.c;
        if (com.larus.bmhome.chat.markdown.richtext.o.a(r11) == false) goto L5;
        String r13 = "cloud_doc";
    L6:
        r3.getClass();
        return new j0(r1, r2, r3, r4, r13, r6, r7);
    L5:
        r13 = null;
        goto L6
    }
}
