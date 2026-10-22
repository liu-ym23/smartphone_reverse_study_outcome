package com.larksuite.component.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.ui.dialog.b;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class b<T extends b> extends d<T> {
    public DialogInterface.OnClickListener f;
    public final UDActionPanelBuilder g;

    public class a extends g {
        public final /* synthetic */ b h;

        public a(b r1, Context r2) {
            this.h = r1;
            super(r2);
        }

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController, com.larksuite.component.universe_design.dialog.UDDialogController
        public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r1, final UDDialog r2) {
            super.apply(r1, r2);
            if (this.h.f == null) goto L6;
            this.a = new com.larksuite.component.ui.dialog.a(this, r2);
            return;
        }
    }

    public b(Context r2) {
        super(r2);
        UDActionPanelBuilder r0 = new UDActionPanelBuilder(r2);
        this.g = r0;
        this.c = r0;
        this.d = new a(this, r2);
    }

    public final void l(List r5) {
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        h r1 = (h) r6.next();
        r0.add(new UDBaseListDialogBuilder.ListItemBuilder(r1.a).textColorRes(r1.b).build());
        goto L4
    L6:
        this.g.itemList(r0);
    }

    public final void m(int r4) {
        this.g.itemLayout(r4);
        if (r4 == (-1)) goto L6;
        this.g.adapter(new UDBaseListDialogAdapterWrapper(this.a, r4));
        return;
    }

    public final void n(CharSequence... r7) {
        if (r7 != null) goto L4;
        ArrayList r8 = null;
    L8:
        l(r8);
        return;
    L4:
        ArrayList r0 = new ArrayList(r7.length);
        int r1 = r7.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        CharSequence r3 = r7[r2];
        h r4 = new h();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r4.a = r3;
        r0.add(r4);
        r2 = r2 + 1;
        goto L5
    L7:
        r8 = r0;
        goto L8
    }
}
