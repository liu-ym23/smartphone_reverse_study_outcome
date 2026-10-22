package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.DialogInterface;
import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c0 extends OnSingleClickListener {
    public final /* synthetic */ z a;
    public final /* synthetic */ y6b.a<?> b;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ z a;
        public final /* synthetic */ y6b.a<?> b;

        public a(z r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.h.A(this.b.getId());
        }
    }

    public final void onSingleClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        if (this.a.h == null) goto L6;
        com.larksuite.component.ui.dialog.d r5 = new com.larksuite.component.ui.dialog.d(this.a.getContext());
        r5.j(2131892391);
        r5.a(2131378550, 2131892389, null);
        r5.a(2131378551, 2131892390, new a(this.a, this.b));
        r5.i();
        return;
    }

    public c0(z r1, y6b.a<?> r2) {
        this.a = r1;
        this.b = r2;
        super(300);
    }
}
