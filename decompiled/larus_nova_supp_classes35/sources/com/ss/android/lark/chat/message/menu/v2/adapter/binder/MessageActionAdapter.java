package com.ss.android.lark.chat.message.menu.v2.adapter.binder;

import a6b.b;
import a6b.c;
import a6b.d;
import a6b.f;
import a6b.g;
import a6b.h;
import a6b.i;
import a6b.j;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.chat.message.menu.v2.j0;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import zya.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MessageActionAdapter extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, e> {
    public final Map<Integer, a6b.e> a;
    public final h b;

    public MessageActionAdapter() {
        HashMap r0 = new HashMap();
        this.a = r0;
        h r1 = new h();
        this.b = r1;
        r0.put(2, new b());
        r0.put(5, new d());
        r0.put(1, new g());
        r0.put(3, r1);
        r0.put(4, new i());
        r0.put(0, new j());
        r0.put(6, new f());
        r0.put(7, new c());
    }

    public final int getItemViewType(int r1) {
        return ((e) getItem(r1)).a();
    }

    public final a6b.e y2(int r3) {
        a6b.e r0 = (a6b.e) ((HashMap) this.a).get(Integer.valueOf(r3));
        if (r0 == null) goto L5;
        return r0;
    L5:
        Log.e("MessageActionAdapter", "getBinder failed, view Type = " + r3);
        return this.b;
    }

    public final void z2(j0 r4) {
        Iterator r0 = ((HashMap) this.a).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        int r1 = ((Integer) r0.next()).intValue();
        Map<Integer, a6b.e> r2 = this.a;
        HashMap r3 = (HashMap) r2;
        a6b.e r5 = (a6b.e) r3.get(Integer.valueOf(r1));
        if (r5 == null) goto L4;
        r5.b(r4);
        goto L4
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        int r0 = getItemViewType(r3);
        e r4 = (e) getItem(r3);
        y2(r0).c(r2, r4);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return y2(r2).a(r1);
    }
}
