package com.drakeet.multitype;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/drakeet/multitype/MultiTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multitype"}, k = 1, mv = {1, 4, 2})
public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f7569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r6.a f7570b;

    @JvmOverloads
    public MultiTypeAdapter() {
        this(0);
    }

    public final um.a a(RecyclerView.ViewHolder r5) {
        int r10 = r5.getItemViewType();
        um.a r11 = this.f7570b.k(r10).f7572b;
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.drakeet.multitype.ItemViewDelegate<kotlin.Any, androidx.recyclerview.widget.RecyclerView.ViewHolder>");
    }

    public final void b(final Class r5, um.a r10) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r10, "binder");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r10, "delegate");
        r6.a r11 = this.f7570b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Function1<b, Boolean> r12 = new MutableTypes$unregister$1(r5);
        List r13 = (List) r11.f21695a;
        if (CollectionsKt.removeAll(r13, r12) == false) goto L5;
        Log.w("MultiTypeAdapter", "The type " + r5.getSimpleName() + " you originally registered is now overwritten.");
    L5:
        b r14 = new b(r5, r10, new com.bytedance.frameworks.baselib.network.http.cronet.b(8));
        Intrinsics.checkNotNullParameter(r14, "type");
        Intrinsics.checkNotNullParameter(r14, "type");
        r13.add(r14);
        r10.f22372b = this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f7569a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r5) {
        this.f7569a.get(r5);
        int r10 = getItemViewType(r5);
        this.f7570b.k(r10).f7572b.getClass();
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r10) {
        Object r11 = this.f7569a.get(r10);
        Intrinsics.checkNotNullParameter(r11, "item");
        Class<?> r5 = r11.getClass();
        r6.a r12 = this.f7570b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r5, "clazz");
        List r13 = (List) r12.f21695a;
        Iterator r14 = r13.iterator();
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r14.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((b) r14.next()).f7571a, r5) == true) goto L10;
        r16 = r16 + 1;
    L10:
        if (r16 != (-1)) goto L20;
        Iterator r17 = r13.iterator();
    L14:
        if (r17.hasNext() == false) goto L19;
        if (((b) r17.next()).f7571a.isAssignableFrom(r5) == true) goto L17;
        r15 = r15 + 1;
        goto L14
    L17:
        r16 = r15;
        goto L20
    L19:
        r16 = -1;
    L20:
        if (r16 == (-1)) goto L24;
        r12.k(r16).f7573c.getClass();
        return r16;
    L24:
        throw new DelegateNotFoundException(r11.getClass());
    L9:
        r16 = -1;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r10, List r11) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r11, "payloads");
        Object r12 = this.f7569a.get(r10);
        um.a r13 = a(r5);
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r11, "payloads");
        r13.u(r5, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        b r11 = this.f7570b.k(r10);
        Context r12 = r5.getContext();
        um.a r13 = r11.f7572b;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return r13.v(LayoutInflater.from(r12), r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        a(r5);
        Intrinsics.checkNotNullParameter(r5, "holder");
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        a(r5);
        Intrinsics.checkNotNullParameter(r5, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        a(r5);
        Intrinsics.checkNotNullParameter(r5, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        a(r5).x(r5);
    }

    public MultiTypeAdapter(int r5) {
        List r10 = CollectionsKt.emptyList();
        ArrayList r11 = new ArrayList(0);
        Intrinsics.checkNotNullParameter(r11, "types");
        r6.a r12 = new r6.a();
        r12.f21695a = r11;
        Intrinsics.checkNotNullParameter(r10, "items");
        Intrinsics.checkNotNullParameter(r12, "types");
        this.f7569a = r10;
        this.f7570b = r12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        onBindViewHolder(r5, r10, CollectionsKt.emptyList());
    }
}
