package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements com.ss.android.lark.contact.base.contact_list.view.d {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ o b;

    @Override // com.ss.android.lark.contact.base.contact_list.view.d
    public final void b() {
        o r0 = this.b;
        RecyclerView r1 = this.a;
        r0.getClass();
        int r2 = o.b(r1);
        o r3 = this.b;
        RecyclerView r4 = this.a;
        r3.getClass();
        Map<Integer, String> r5 = OfficeFloatingBarItemDecoration.i(o.a(r4).b, r2);
        OfficeFloatingBarItemDecoration r6 = this.b.a;
        r6.getClass();
        if (r5 != null) goto L5;
        r5 = Collections.emptyMap();
    L5:
        r6.j = new LinkedList(new LinkedHashSet(r5.values()));
        r6.i = r5;
    }

    public n(o r1, CommonRecyclerView r2) {
        this.b = r1;
        this.a = r2;
    }
}
