package com.bytedance.android.live.core.widget.simple;

import android.view.View;
import android.view.ViewGroup;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.s;
import com.bytedance.android.live.core.cache.f;
import com.bytedance.android.live.core.cache.n;
import com.bytedance.android.live.core.paging.adapter.DelegatePagingAdapter;
import com.bytedance.android.live.core.paging.adapter.InvalidItemViewHolder;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModel;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class SimpleListViewModel<T> extends PagingViewModel<T> implements DelegatePagingAdapter.Delegate<T>, PagingLoadCallback<T> {
    private SimpleListViewModel<T>.b<T> adapter;
    private com.bytedance.android.live.core.cache.a<String, T> cache;
    private List<ViewHolderType<T>> typeInfos;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ RecyclerView.ViewHolder a;
        public final /* synthetic */ SimpleListViewModel b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r5) {
            RecyclerView.ViewHolder r6 = this.a;
            if ((r6 instanceof BaseViewHolder) == false) goto L20;
            int r7 = r6.getAdapterPosition();
            if (r7 >= 0) goto L7;
            return;
        L7:
            Object r0 = SimpleListViewModel.access$100(this.b).getItem(r7);
            ViewHolderType r1 = SimpleListViewModel.access$000(this.b, r0);
            if ((r1 instanceof SimpleViewHolderType) == false) goto L13;
            RecyclerView.ViewHolder r2 = this.a;
            if ((r2 instanceof SimpleViewHolder) == false) goto L13;
            ((SimpleViewHolder) r2).setItem(r0);
            ((SimpleViewHolderType) r1).bind((SimpleViewHolder) this.a, r0, r7);
        L13:
            if ((r0 instanceof s) == false) goto L15;
            ((s) r0).getClass();
            BaseViewHolder r3 = (BaseViewHolder) this.a;
            r3.bind(r3.getData(null), r7);
        L17:
            if (((BaseViewHolder) this.a).fullSpan() == false) goto L21;
            SimpleListViewModel.access$100(this.b).setFullSpan(this.a);
            return;
        L21:
            return;
        L15:
            ((BaseViewHolder) this.a).bind(r0, r7);
            goto L17
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            RecyclerView.ViewHolder r4 = this.a;
            if ((r4 instanceof BaseViewHolder) == false) goto L5;
            ((BaseViewHolder) r4).unbind();
        L5:
            RecyclerView.ViewHolder r5 = this.a;
            if ((r5 instanceof SimpleViewHolder) == false) goto L11;
            Object r6 = ((SimpleViewHolder) r5).getItem();
            ViewHolderType r0 = SimpleListViewModel.access$000(this.b, r6);
            if ((r0 instanceof SimpleViewHolderType) == false) goto L12;
            ((SimpleViewHolderType) r0).unBind((SimpleViewHolder) this.a, r6);
            return;
        L12:
            return;
        }

        public a(SimpleListViewModel r1, RecyclerView.ViewHolder r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b<T> extends DelegatePagingAdapter<T> {
        public b(DelegatePagingAdapter.Delegate r1) {
            super(r1);
        }

        @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
        public final T getItem(int r1) {
            return (T) super.getItem(r1);
        }

        @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
        public final void onViewRecycled(RecyclerView.ViewHolder r2) {
            if ((r2 instanceof BaseViewHolder) == false) goto L5;
            return;
        L5:
            super.onViewRecycled(r2);
        }

        @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
        public final void setFullSpan(RecyclerView.ViewHolder r1) {
            super.setFullSpan(r1);
        }
    }

    @Override // com.bytedance.android.live.core.paging.adapter.DelegatePagingAdapter.Delegate
    public boolean areItemsTheSame(T r1, T r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.bytedance.android.live.core.paging.adapter.DelegatePagingAdapter.Delegate
    public int getEmptyResId() {
        return 0;
    }

    public abstract int getPageSize();

    public Object[] getPayload() {
        return null;
    }

    public abstract int getPrefetchDistance();

    @Override // com.bytedance.android.live.core.paging.adapter.DelegatePagingAdapter.Delegate
    public void onBindViewHolder(RecyclerView.ViewHolder r1, int r2, T r3) {
    }

    @Override // com.bytedance.android.live.core.paging.adapter.DelegatePagingAdapter.Delegate
    public void setPayload(Object... r1) {
    }

    public void load() {
        f60.a r0 = new f60.a();
        r0.r = this;
        r0.q = new PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(getPageSize()).setPrefetchDistance(getPrefetchDistance()).build();
        r0.n = "single.memory.list.cache.default.key";
        com.bytedance.android.live.core.cache.a<String, T> r1 = this.cache;
        f r2 = new f();
        r0.o = r1;
        r0.p = r2;
        register(r0.build());
    }

    public SimpleListViewModel() {
        this.typeInfos = new ArrayList();
        this.cache = new n();
        SimpleListViewModel<T>.b<T> r0 = new b(this);
        this.adapter = r0;
        r0.setViewModel(this);
    }

    public static /* synthetic */ b access$100(SimpleListViewModel r0) {
        return r0.adapter;
    }

    private ViewHolderType<T> getViewHolderType(T r4) {
        Iterator<ViewHolderType<T>> r0 = this.typeInfos.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ViewHolderType<T> r1 = r0.next();
        if (r1.match(r4) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public SimpleListViewModel<T> addViewHolderType(ViewHolderType<T> r2) {
        this.typeInfos.add(r2);
        return this;
    }

    public SimpleListViewModel bind(RecyclerView r2) {
        r2.setAdapter(this.adapter);
        return this;
    }

    public static /* synthetic */ ViewHolderType access$000(SimpleListViewModel r0, Object r1) {
        return r0.getViewHolderType(r1);
    }

    @Override // com.bytedance.android.live.core.paging.adapter.DelegatePagingAdapter.Delegate
    public boolean areContentsTheSame(T r1, T r2) {
        return r1.equals(r2);
    }

    @Override // com.bytedance.android.live.core.paging.adapter.DelegatePagingAdapter.Delegate
    public int getViewType(int r1, T r2) {
        return this.typeInfos.indexOf(getViewHolderType(r2));
    }

    @Override // com.bytedance.android.live.core.paging.adapter.DelegatePagingAdapter.Delegate
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        RecyclerView.ViewHolder r5 = ((ViewHolderType) ListProtector.get(this.typeInfos, r4)).create(r3);     // Catch: Exception -> L4
        r5.itemView.addOnAttachStateChangeListener(new a(this, r5));     // Catch: Exception -> L4
        return r5;
    L5:
        return new InvalidItemViewHolder(r3);
    }
}
