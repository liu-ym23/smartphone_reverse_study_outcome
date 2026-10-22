package com.bytedance.android.anya;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anya/MVIRecyclerViewAdapter;", "Lcom/bytedance/android/anya/MVIState;", "STATE", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/anya/MVIViewHolderImpl;", "runtime_release"}, k = 1, mv = {1, 4, 0})
public class MVIRecyclerViewAdapter<STATE extends MVIState<?>> extends RecyclerView.Adapter<MVIViewHolderImpl<?, ?>> {
    public List<? extends STATE> a;
    public RecyclerView b;
    public final BaseMVIView<?, ?> c;
    public final Function2<ViewGroup, Integer, BaseMVIListItem<STATE, ?>> d;

    public static final class a implements Runnable {
        public final /* synthetic */ MVIRecyclerViewAdapter a;
        public final /* synthetic */ Function0 b;

        public a(MVIRecyclerViewAdapter r1, Function0 r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.z2(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r10) {
        MVIViewHolderImpl r11 = (MVIViewHolderImpl) r10;
        r11.b = true;
        r11.a.unbind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object y2(r0 r1) {
        return ((com.bytedance.android.anya.internal.c) r1).c();
    }

    public final void z2(Function0<Unit> r10) {
        RecyclerView r0 = this.b;
        if (r0 != null) goto L5;
    L10:
        r10.invoke();
        return;
    L5:
        if (r0.isComputingLayout() != true) goto L10;
        RecyclerView r1 = this.b;
        if (r1 == null) goto L12;
        r1.post(new a(this, r10));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MVIRecyclerViewAdapter(BaseMVIView<?, ?> r1, Function2<? super ViewGroup, ? super Integer, ? extends BaseMVIListItem<STATE, ?>> r10) {
        this.c = r1;
        this.d = r10;
        this.a = CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        ((MVIViewHolderImpl) r10).T3((MVIState) ListProtector.get(this.a, r11));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return new MVIViewHolderImpl(this.c, (BaseMVIListItem) this.d.invoke(r10, Integer.valueOf(r11)));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void A2(MVIViewHolderImpl<?, ?> r10, int r11, List<Object> r12) {
        if (r12.isEmpty() == false) goto L6;
        r10.T3((MVIState) ListProtector.get(this.a, r11));
        return;
    L6:
        Object r13 = CollectionsKt.last(r12);
        if (r13 == null) goto L14;
        k<STATE> r14 = (k) ((Map) r13).get(Integer.valueOf(r11));
        if (r14 == null) goto L11;
        r10.c.c(r14);
        return;
    L11:
        r10.T3((MVIState) ListProtector.get(this.a, r11));
        return;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Int, com.bytedance.android.anya.Diff<STATE>>");
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r10, List r11) {
        A2((MVIViewHolderImpl) r1, r10, r11);
    }
}
