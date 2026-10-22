package com.ss.android.lark.contact.customized.mygroup.view;

import android.view.View;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends OnSingleClickListener {
    public final /* synthetic */ OfficeMyGroupAdapter a;
    public final /* synthetic */ Chat b;
    public final /* synthetic */ int c;

    public final void onSingleClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        Function2<? super Chat, ? super Integer, Unit> r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.invoke(this.b, Integer.valueOf(this.c));
        return;
    }

    public a(OfficeMyGroupAdapter r1, Chat r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
