package com.ss.android.lark.contact.base.contact_list.mvp;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.contact_list.view.FloatingBarItemDecoration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements com.ss.android.lark.contact.base.contact_list.view.d {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ ExternalContactView2.a b;

    @Override // com.ss.android.lark.contact.base.contact_list.view.d
    public final void b() {
        FloatingBarItemDecoration r0 = this.b.a;
        Map<Integer, String> r1 = this.a.getAdapter().b;
        r0.getClass();
        LinkedHashMap r2 = (LinkedHashMap) r1;
        r0.i = new LinkedList(new LinkedHashSet(r2.values()));
        r0.h = r2;
    }

    public h(ExternalContactView2.a r1, RecyclerView r2) {
        this.b = r1;
        this.a = r2;
    }
}
