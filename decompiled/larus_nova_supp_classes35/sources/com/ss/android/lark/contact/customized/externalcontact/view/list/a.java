package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$initExternalContactView$actionHandler$1;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a<T> {
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> a;
    public IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, T> b;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalcontact.view.list.a$a, reason: collision with other inner class name */
    public interface InterfaceC0173a {
        void a(String r1);

        void b(View r1, long r2);
    }

    public a() {
    }

    public abstract void a(IndexRecyclerViewAdapter r1, OfficeExternalContactFragment$initExternalContactView$actionHandler$1 r2);

    public abstract boolean b(RecyclerView.ViewHolder r1);

    public abstract RecyclerView.Adapter<? extends RecyclerView.ViewHolder> c(l9b.a r1);

    public abstract IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, T> d();

    public abstract int f(CommonRecyclerView r1);

    public abstract void g(List<? extends T> r1);

    public final IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, T> e() {
        IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, T> r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        return null;
    L6:
        return r0;
    }
}
