package com.bytedance.android.live.core.paging.adapter;

import android.database.Observable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.base.model.s;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModel;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModelV2;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.r3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class PagingAdapter<T> extends PagedListAdapter<T, RecyclerView.ViewHolder> {
    public static final int TYPE_EMPTY = -1091641683;
    private static final int TYPE_FOOTER = -559038737;
    private static final int TYPE_HEADER = -559038738;
    protected static final int TYPE_LOADING = -1091576148;
    protected static final int TYPE_LOAD_ERROR = -1091576149;
    private final Observer<Boolean> emptyObserver;
    private boolean hasFooter;
    private boolean hasHeader;
    private final Observer<Boolean> hasMoreObserver;
    private boolean isEmpty;
    private boolean isLoadingShowing;
    private final Observer<Integer> itemChangeObserver;
    private final Observer<PagedList<T>> liveDataObserver;
    private NetworkStat.Status loadStatus;
    private final PagingAdapter<T>.f mObservable;
    private final Observer<NetworkStat> networkObserver;
    private final PagingAdapter<T>.g observable;
    private RecyclerView recyclerView;
    private final Observer<NetworkStat> refreshObserver;
    private NetworkStat.Status refreshStatus;
    private boolean supportEmptyView;
    private boolean supportFooter;
    private boolean supportStatusView;
    private PagingViewModel<T> viewModel;
    private PagingViewModelV2 viewModelV2;

    public static class EndViewHolder extends RecyclerView.ViewHolder {
        public EndViewHolder(View r1) {
            super(r1);
        }
    }

    public class a implements Observer<NetworkStat> {
        public final /* synthetic */ PagingAdapter a;

        public a(PagingAdapter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            NetworkStat r3 = (NetworkStat) r2;
            if (r3 == null) goto L7;
            PagingAdapter.access$002(this.a, r3.mStatus);
            PagingAdapter r4 = this.a;
            r4.setLoadingStatus(PagingAdapter.access$100(r4));
            return;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ PagingAdapter a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.notifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(PagingAdapter r1) {
            this.a = r1;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ PagingAdapter b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.notifyItemChanged(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(PagingAdapter r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ PagingAdapter b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.notifyItemInserted(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(PagingAdapter r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ PagingAdapter b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.notifyItemRemoved(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(PagingAdapter r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class f extends Observable<RecyclerView.AdapterDataObserver> {
        public final /* synthetic */ PagingAdapter a;

        public class a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ f b;

            @Override // java.lang.Runnable
            public final void run() {
                ((RecyclerView.AdapterDataObserver) ListProtector.get(f.a(this.b), this.a)).onChanged();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(f r1, int r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ f c;

            @Override // java.lang.Runnable
            public final void run() {
                this.c.j(this.a, this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(f r1, int r2, int r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ f d;

            @Override // java.lang.Runnable
            public final void run() {
                ((RecyclerView.AdapterDataObserver) ListProtector.get(f.c(this.d), this.a)).onItemRangeInserted(this.b, this.c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(f r1, int r2, int r3, int r4) {
                this.d = r1;
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ f d;

            @Override // java.lang.Runnable
            public final void run() {
                ((RecyclerView.AdapterDataObserver) ListProtector.get(f.d(this.d), this.a)).onItemRangeRemoved(this.b, this.c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public d(f r1, int r2, int r3, int r4) {
                this.d = r1;
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public class e implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ f d;

            @Override // java.lang.Runnable
            public final void run() {
                ((RecyclerView.AdapterDataObserver) ListProtector.get(f.e(this.d), this.a)).onItemRangeMoved(this.b, this.c, 1);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public e(f r1, int r2, int r3, int r4) {
                this.d = r1;
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public final void g() {
            int r0 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L13;
            if (PagingAdapter.access$200(this.a) != null) goto L7;
        L11:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r0)).onChanged();
        L12:
            r0 = r0 - 1;
            goto L3
        L7:
            if (PagingAdapter.access$200(this.a).isComputingLayout() == false) goto L9;
        L10:
            PagingAdapter.access$200(this.a).post(new a(this, r0));
            goto L12
        L9:
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L11;
        }

        public f(PagingAdapter r1) {
            this.a = r1;
        }

        public static /* synthetic */ ArrayList a(f r0) {
            return ((Observable) r0).mObservers;
        }

        public static /* synthetic */ ArrayList b(f r0) {
            return ((Observable) r0).mObservers;
        }

        public static /* synthetic */ ArrayList c(f r0) {
            return ((Observable) r0).mObservers;
        }

        public static /* synthetic */ ArrayList d(f r0) {
            return ((Observable) r0).mObservers;
        }

        public static /* synthetic */ ArrayList e(f r0) {
            return ((Observable) r0).mObservers;
        }

        public final int f(int r2) {
            if (this.a.hasHeader() == true) goto L5;
            return r2;
        L5:
            return r2 + 1;
        }

        public final void h(int r5, int r6) {
            int r7 = f(r5);
            int r8 = f(r6);
            int r0 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L13;
            if (PagingAdapter.access$200(this.a) != null) goto L7;
        L11:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r0)).onItemRangeMoved(r7, r8, 1);
        L12:
            r0 = r0 - 1;
            goto L3
        L7:
            if (PagingAdapter.access$200(this.a).isComputingLayout() == false) goto L9;
        L10:
            PagingAdapter.access$200(this.a).post(new e(this, r0, r7, r8));
            goto L12
        L9:
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L11;
        }

        public final void i(int r3, int r4) {
            if (PagingAdapter.access$200(this.a) != null) goto L5;
        L9:
            j(r3, r4);
            return;
        L5:
            if (PagingAdapter.access$200(this.a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.a).post(new b(this, r3, r4));
            return;
        L7:
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L9;
            goto L8
        }

        public final void j(int r4, int r5) {
            int r6 = f(r4);
            int r0 = ((Observable) this).mObservers.size();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L13;
            if (PagingAdapter.access$200(this.a) == null) goto L12;
            if (PagingAdapter.access$200(this.a).isComputingLayout() == true) goto L11;
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L12;
        L11:
            PagingAdapter.access$200(this.a).post(new com.bytedance.android.live.core.paging.adapter.f(this, r0, r6, r5));
        L12:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r0)).onItemRangeChanged(r6, r5, null);
            goto L3
        }

        public final void k(int r4, int r5) {
            int r6 = f(r4);
            int r0 = ((Observable) this).mObservers.size();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L13;
            if (PagingAdapter.access$200(this.a) == null) goto L12;
            if (PagingAdapter.access$200(this.a).isComputingLayout() == true) goto L11;
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L12;
        L11:
            PagingAdapter.access$200(this.a).post(new c(this, r0, r6, r5));
        L12:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r0)).onItemRangeInserted(r6, r5);
            goto L3
        }

        public final void l(int r4, int r5) {
            int r6 = f(r4);
            int r0 = ((Observable) this).mObservers.size();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L13;
            if (PagingAdapter.access$200(this.a) == null) goto L12;
            if (PagingAdapter.access$200(this.a).isComputingLayout() == true) goto L11;
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L12;
        L11:
            PagingAdapter.access$200(this.a).post(new d(this, r0, r6, r5));
        L12:
            ((RecyclerView.AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r0)).onItemRangeRemoved(r6, r5);
            goto L3
        }
    }

    public class g extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ PagingAdapter a;

        public class a implements Runnable {
            public final /* synthetic */ g a;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.a.a).g();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(g r1) {
                this.a = r1;
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ g c;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.c.a).i(this.a, this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(g r1, int r2, int r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ g c;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.c.a).k(this.a, this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(g r1, int r2, int r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ g c;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.c.a).l(this.a, this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public d(g r1, int r2, int r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public class e implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ g c;

            @Override // java.lang.Runnable
            public final void run() {
                PagingAdapter.access$300(this.c.a).h(this.a, this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public e(g r1, int r2, int r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public final void onChanged() {
            if (PagingAdapter.access$200(this.a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.a).g();
            return;
        L5:
            if (PagingAdapter.access$200(this.a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.a).post(new a(this));
            return;
        L7:
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L9;
            goto L8
        }

        public g(PagingAdapter r1) {
            this.a = r1;
        }

        public final void onItemRangeChanged(int r3, int r4) {
            if (PagingAdapter.access$200(this.a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.a).i(r3, r4);
            return;
        L5:
            if (PagingAdapter.access$200(this.a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.a).post(new b(this, r3, r4));
            return;
        L7:
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L9;
            goto L8
        }

        public final void onItemRangeInserted(int r3, int r4) {
            if (PagingAdapter.access$200(this.a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.a).k(r3, r4);
            return;
        L5:
            if (PagingAdapter.access$200(this.a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.a).post(new c(this, r3, r4));
            return;
        L7:
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L9;
            goto L8
        }

        public final void onItemRangeRemoved(int r3, int r4) {
            if (PagingAdapter.access$200(this.a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.a).l(r3, r4);
            return;
        L5:
            if (PagingAdapter.access$200(this.a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.a).post(new d(this, r3, r4));
            return;
        L7:
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L9;
            goto L8
        }

        public final void onItemRangeMoved(int r2, int r3, int r4) {
            if (PagingAdapter.access$200(this.a) != null) goto L5;
        L9:
            PagingAdapter.access$300(this.a).h(r2, r3);
            return;
        L5:
            if (PagingAdapter.access$200(this.a).isComputingLayout() == false) goto L7;
        L8:
            PagingAdapter.access$200(this.a).post(new e(this, r2, r3));
            return;
        L7:
            if (PagingAdapter.access$200(this.a).getScrollState() == 0) goto L9;
            goto L8
        }
    }

    public static class h extends j {
        public final ViewGroup a;
        public final DouyinLoadingLayout b;

        public class a implements Observer<NetworkStat> {
            public final /* synthetic */ h a;

            public a(h r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                NetworkStat r3 = (NetworkStat) r2;
                if (r3 != null) goto L6;
                return;
            L6:
                if (r3.isLoading() == false) goto L8;
                this.a.b.setVisibility(0);
                return;
            L8:
                this.a.b.setVisibility(8);
            }
        }

        @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter.j
        public final void unbind() {
        }

        public h(View r3) {
            super(r3);
            ViewGroup r0 = (ViewGroup) r3.findViewById(2131379011);
            this.a = r0;
            DouyinLoadingLayout r1 = new DouyinLoadingLayout(r3.getContext());
            this.b = r1;
            r0.addView(r1);
        }

        @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter.j
        public final void T3(LiveData<NetworkStat> r2) {
            r2.observeForever(new a(this));
        }
    }

    public static class i extends RecyclerView.ViewHolder {
        public final PagingViewModel a;
        public final View b;
        public final TextView c;

        public i(View r1, PagingViewModel r2) {
            super(r1);
            this.a = r2;
            this.b = r1.findViewById(2131371757);
            this.c = (TextView) r1.findViewById(2131371775);
        }
    }

    public static class j extends RecyclerView.ViewHolder {
        public void T3(LiveData<NetworkStat> r1) {
        }

        public void unbind() {
        }

        public j(View r1) {
            super(r1);
        }
    }

    public static /* synthetic */ void A2(PagingAdapter r0, Integer r1) {
        r0.lambda$new$3(r1);
    }

    public static /* synthetic */ void B2(PagingAdapter r0, NetworkStat r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void C2(PagingAdapter r0, PagedList r1) {
        r0.onListChanged(r1);
    }

    public static /* synthetic */ void y2(PagingAdapter r0, Boolean r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ void z2(PagingAdapter r0, Boolean r1) {
        r0.lambda$new$1(r1);
    }

    public int getEmptyResId() {
        return 2131565333;
    }

    public abstract int getNormalViewType(int r1, T r2);

    public int invalidateType() {
        return -8888;
    }

    public abstract RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup r1, int r2);

    public void setRecyclerView(RecyclerView r1) {
    }

    private LiveData<NetworkStat> networkDataAdapter() {
        PagingViewModelV2 r0 = this.viewModelV2;
        if (r0 == null) goto L7;
        return r0.getNetworkState();
    L7:
        return this.viewModel.networkStat();
    }

    private LiveData<NetworkStat> refreshDataAdapter() {
        PagingViewModelV2 r0 = this.viewModelV2;
        if (r0 == null) goto L7;
        return r0.getRefreshState();
    L7:
        return this.viewModel.networkStat();
    }

    private MutableLiveData<Boolean> retryDataAdapter() {
        PagingViewModelV2 r0 = this.viewModelV2;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getRetry();
    }

    public boolean isError() {
        if (this.loadStatus != NetworkStat.Status.FAILED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLoading() {
        if (this.loadStatus != NetworkStat.Status.RUNNING) goto L5;
        return true;
    L5:
        return false;
    }

    public final void safeNotifyDataSetChanged() {
        RecyclerView r0 = this.recyclerView;
        if (r0 != null) goto L5;
    L9:
        notifyDataSetChanged();
        return;
    L5:
        if (r0.isComputingLayout() == false) goto L7;
    L8:
        this.recyclerView.post(new b(this));
        return;
    L7:
        if (this.recyclerView.getScrollState() == 0) goto L9;
        goto L8
    }

    public void unbindViewModel() {
        PagingViewModel<T> r0 = this.viewModel;
        if (r0 == null) goto L6;
        r0.liveData().removeObserver(this.liveDataObserver);
        this.viewModel.networkStat().removeObserver(this.networkObserver);
        this.viewModel.refreshStat().removeObserver(this.refreshObserver);
        this.viewModel.hasMore().removeObserver(this.hasMoreObserver);
        this.viewModel.isDataEmpty().removeObserver(this.emptyObserver);
        this.viewModel.updateAdapterItem().removeObserver(this.itemChangeObserver);
        return;
    }

    public void unbindViewModelV2() {
        PagingViewModelV2 r0 = this.viewModelV2;
        if (r0 == null) goto L5;
        r0.getNetworkState().removeObserver(this.networkObserver);
        this.viewModelV2.getRefreshState().removeObserver(this.refreshObserver);
        this.viewModelV2.getHasMore().removeObserver(this.hasMoreObserver);
        this.viewModelV2.getEmpty().removeObserver(this.emptyObserver);
    L5:
        this.viewModelV2 = null;
    }

    private boolean hasEmpty() {
        if (isEmpty() == true) goto L5;
    L9:
        return false;
    L5:
        if (supportEmptyView() == false) goto L9;
        if (hasHeader() == true) goto L9;
        return true;
    }

    public int getDataItemCount() {
        return super.getItemCount();
    }

    public final int getItemCount() {
        boolean r0 = hasHeader();
        boolean r1 = hasFooter();
        boolean r2 = hasEmpty();
        boolean r3 = hasLoadingStatus();
        int r4 = getDataItemCount();
        return ((((r0 ? 1 : 0) + r4) + (r1 ? 1 : 0)) + (r3 ? 1 : 0)) + (r2 ? 1 : 0);
    }

    public boolean hasFooter() {
        if (isEmpty() == false) goto L5;
    L11:
        return false;
    L5:
        if (getDataItemCount() == 0) goto L11;
        if (this.hasFooter == false) goto L11;
        if (supportFooter() == false) goto L11;
        return true;
    }

    public boolean hasLoadingStatus() {
        if (hasFooter() == false) goto L5;
    L22:
        return false;
    L5:
        if (supportStatusView() == false) goto L22;
        NetworkStat.Status r0 = this.refreshStatus;
        if (r0 != null) goto L11;
        return false;
    L11:
        if (r0 != NetworkStat.Status.SUCCESS) goto L19;
        if (isLoading() == false) goto L15;
    L16:
        return true;
    L15:
        if (isError() == true) goto L16;
        return false;
    L19:
        if (r0 != NetworkStat.Status.FAILED) goto L22;
        return isError();
    }

    public PagingViewModel<T> getViewModel() {
        return this.viewModel;
    }

    public boolean hasHeader() {
        return this.hasHeader;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public boolean supportEmptyView() {
        return this.supportEmptyView;
    }

    public boolean supportFooter() {
        return this.supportFooter;
    }

    public boolean supportStatusView() {
        return this.supportStatusView;
    }

    public PagingAdapter(DiffUtil.ItemCallback<T> r2) {
        super(r2);
        this.liveDataObserver = new com.bytedance.android.live.core.paging.adapter.a(this);
        this.networkObserver = new com.bytedance.android.live.core.paging.adapter.b(this);
        this.refreshObserver = new a(this);
        this.hasMoreObserver = new com.bytedance.android.live.core.paging.adapter.c(this);
        this.emptyObserver = new com.bytedance.android.live.core.paging.adapter.d(this);
        this.itemChangeObserver = new com.bytedance.android.live.core.paging.adapter.e(this);
        this.loadStatus = null;
        this.refreshStatus = null;
        this.isLoadingShowing = false;
        this.supportEmptyView = true;
        this.supportStatusView = true;
        this.supportFooter = true;
        PagingAdapter<T>.g r3 = new g(this);
        this.observable = r3;
        this.mObservable = new f(this);
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.registerAdapterDataObserver(r3);
    }

    public static /* synthetic */ NetworkStat.Status access$100(PagingAdapter r0) {
        return r0.loadStatus;
    }

    public static /* synthetic */ RecyclerView access$200(PagingAdapter r0) {
        return r0.recyclerView;
    }

    public static /* synthetic */ f access$300(PagingAdapter r0) {
        return r0.mObservable;
    }

    private /* synthetic */ void lambda$new$0(NetworkStat r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        setLoadingStatus(r1.mStatus);
    }

    private /* synthetic */ void lambda$new$1(Boolean r1) {
        if (r1 != null) goto L4;
    L6:
        boolean r2 = false;
    L7:
        setHasFooter(r2);
        return;
    L4:
        if (r1.booleanValue() == true) goto L6;
        r2 = true;
        goto L7
    }

    private /* synthetic */ void lambda$new$2(Boolean r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        setIsEmpty(r1.booleanValue());
    }

    private /* synthetic */ void lambda$new$3(Integer r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.intValue() >= 0) goto L6;
        return;
    L6:
        if (r3.intValue() >= getItemCount()) goto L12;
        safeNotifyItemChanged(r3.intValue());
        return;
    }

    private void onListChanged(PagedList<T> r1) {
        submitList(r1);
    }

    public RecyclerView.ViewHolder createCustomErrorViewHolder(ViewGroup r4) {
        return new i(LayoutInflater.from(r4.getContext()).inflate(2131565336, r4, false), this.viewModel);
    }

    public T getData(int r3) {
        if (r3 >= 0) goto L4;
    L8:
        LocalTestManager.a(new Class[]{wy.a.class});
        return null;
    L4:
        if (r3 >= getDataItemCount()) goto L8;
        return (T) super.getItem(r3);
    }

    public T getItem(int r4) {
        int r0 = getDataItemCount() + (hasHeader() ? 1 : 0);
        if (hasHeader() == false) goto L7;
        if (r4 != 0) goto L7;
        return null;
    L7:
        if (hasLoadingStatus() == false) goto L11;
        if (r4 != r0) goto L11;
        return null;
    L11:
        if (hasFooter() == false) goto L15;
        if (r4 != r0) goto L15;
        return null;
    L15:
        if (hasEmpty() == false) goto L19;
        if (r4 != r0) goto L19;
        return null;
    L19:
        return getData(mappingAdapterPos2DataPos(r4));
    }

    public final int getItemViewType(int r3) {
        int r0 = getItemCount() - 1;
        if (hasEmpty() == false) goto L8;
        if (r3 != 0) goto L8;
        return TYPE_EMPTY;
    L8:
        if (hasHeader() == false) goto L13;
        if (r3 != 0) goto L13;
        return TYPE_HEADER;
    L13:
        if (hasLoadingStatus() == false) goto L21;
        if (r3 != r0) goto L21;
        if (isError() == false) goto L18;
        return TYPE_LOAD_ERROR;
    L18:
        return TYPE_LOADING;
    L21:
        if (hasFooter() == false) goto L25;
        if (r3 != r0) goto L25;
        return TYPE_FOOTER;
    L25:
        int r4 = mappingAdapterPos2DataPos(r3);
        if (r4 < getDataItemCount()) goto L30;
        return invalidateType();
    L30:
        return getNormalViewType(r4, getData(r4));
    }

    public int mappingAdapterPos2DataPos(int r2) {
        return r2 - (hasHeader() ? 1 : 0);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewAttachedToWindow(r2);
        if ((r2 instanceof BaseViewHolder) == false) goto L6;
        ((BaseViewHolder) r2).onViewAttachedToWindow();
        return;
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewDetachedFromWindow(r2);
        if ((r2 instanceof BaseViewHolder) == false) goto L6;
        ((BaseViewHolder) r2).onViewDetachedFromWindow();
        return;
    }

    public void onViewRecycled(RecyclerView.ViewHolder r2) {
        if ((r2 instanceof BaseViewHolder) == false) goto L6;
        ((BaseViewHolder) r2).unbind();
        return;
    L6:
        if ((r2 instanceof j) == false) goto L9;
        ((j) r2).unbind();
        return;
    L9:
        if ((r2 instanceof i) == false) goto L14;
        ((i) r2).getClass();
        return;
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver r2) {
        this.mObservable.registerObserver(r2);
    }

    public final void safeNotifyItemChanged(int r3) {
        RecyclerView r0 = this.recyclerView;
        if (r0 != null) goto L5;
    L9:
        notifyItemChanged(r3);
        return;
    L5:
        if (r0.isComputingLayout() == false) goto L7;
    L8:
        this.recyclerView.post(new c(this, r3));
        return;
    L7:
        if (this.recyclerView.getScrollState() == 0) goto L9;
        goto L8
    }

    public final void safeNotifyItemInserted(int r3) {
        RecyclerView r0 = this.recyclerView;
        if (r0 != null) goto L5;
    L9:
        notifyItemInserted(r3);
        return;
    L5:
        if (r0.isComputingLayout() == false) goto L7;
    L8:
        this.recyclerView.post(new d(this, r3));
        return;
    L7:
        if (this.recyclerView.getScrollState() == 0) goto L9;
        goto L8
    }

    public final void safeNotifyItemRemoved(int r3) {
        RecyclerView r0 = this.recyclerView;
        if (r0 != null) goto L5;
    L9:
        notifyItemRemoved(r3);
        return;
    L5:
        if (r0.isComputingLayout() == false) goto L7;
    L8:
        this.recyclerView.post(new e(this, r3));
        return;
    L7:
        if (this.recyclerView.getScrollState() == 0) goto L9;
        goto L8
    }

    public void setFullSpan(RecyclerView.ViewHolder r2) {
        StaggeredGridLayoutManager.LayoutParams r3 = (RecyclerView.LayoutParams) r2.itemView.getLayoutParams();
        if ((r3 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L6;
        r3.setFullSpan(true);
        return;
    }

    public void setHasFooter(boolean r2) {
        if (this.hasFooter != r2) goto L5;
    L9:
        this.hasFooter = r2;
        return;
    L5:
        if (isEmpty() == true) goto L9;
        this.hasFooter = r2;
        safeNotifyDataSetChanged();
    }

    public void setHasHeader(boolean r1) {
        this.hasHeader = r1;
        safeNotifyDataSetChanged();
    }

    public void setHasHeaderWithoutNotify(boolean r1) {
        this.hasHeader = r1;
    }

    public void setIsEmpty(boolean r2) {
        if (this.isEmpty != r2) goto L5;
        return;
    L5:
        this.isEmpty = r2;
        safeNotifyDataSetChanged();
    }

    public void setLoadingStatus(NetworkStat.Status r3) {
        boolean r0 = this.isLoadingShowing;
        this.loadStatus = r3;
        boolean r4 = hasLoadingStatus();
        int r1 = getDataItemCount();
        if (r0 == true) goto L6;
        if (r4 == false) goto L6;
        safeNotifyItemInserted(r1);
    L12:
        this.isLoadingShowing = r4;
        return;
    L6:
        if (r0 == false) goto L9;
        if (r4 == true) goto L9;
        safeNotifyItemRemoved(getItemCount());
    L9:
        if (r0 == false) goto L12;
        if (r4 == false) goto L12;
        safeNotifyItemRemoved(r1);
        safeNotifyItemInserted(r1);
        goto L12
    }

    public final void setSupportEmptyView(boolean r1) {
        this.supportEmptyView = r1;
        notifyDataSetChanged();
    }

    public final void setSupportFooter(boolean r1) {
        this.supportFooter = r1;
        notifyDataSetChanged();
    }

    public final void setSupportStatusView(boolean r1) {
        this.supportStatusView = r1;
        notifyDataSetChanged();
    }

    public void setViewModel(PagingViewModel<T> r3) {
        PagingViewModel<T> r0 = this.viewModel;
        if (r0 == null) goto L5;
        r0.liveData().removeObserver(this.liveDataObserver);
        this.viewModel.networkStat().removeObserver(this.networkObserver);
        this.viewModel.refreshStat().removeObserver(this.refreshObserver);
        this.viewModel.hasMore().removeObserver(this.hasMoreObserver);
        this.viewModel.isDataEmpty().removeObserver(this.emptyObserver);
        this.viewModel.updateAdapterItem().removeObserver(this.itemChangeObserver);
    L5:
        this.viewModel = r3;
        if (r3 != null) goto L8;
        return;
    L8:
        r3.liveData().observeForever(this.liveDataObserver);
        r3.networkStat().observeForever(this.networkObserver);
        r3.refreshStat().observeForever(this.refreshObserver);
        r3.hasMore().observeForever(this.hasMoreObserver);
        r3.isDataEmpty().observeForever(this.emptyObserver);
        r3.updateAdapterItem().observeForever(this.itemChangeObserver);
    }

    public void setViewModelV2(PagingViewModelV2 r3) {
        PagingViewModelV2 r0 = this.viewModelV2;
        if (r0 == null) goto L5;
        r0.getNetworkState().removeObserver(this.networkObserver);
        this.viewModelV2.getRefreshState().removeObserver(this.refreshObserver);
        this.viewModelV2.getHasMore().removeObserver(this.hasMoreObserver);
        this.viewModelV2.getEmpty().removeObserver(this.emptyObserver);
    L5:
        this.viewModelV2 = r3;
        if (r3 != null) goto L8;
        return;
    L8:
        r3.getNetworkState().observeForever(this.networkObserver);
        r3.getRefreshState().observeForever(this.refreshObserver);
        r3.getHasMore().observeForever(this.hasMoreObserver);
        r3.getEmpty().observeForever(this.emptyObserver);
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r2) {
        this.mObservable.unregisterObserver(r2);
    }

    public static /* synthetic */ NetworkStat.Status access$002(PagingAdapter r0, NetworkStat.Status r1) {
        r0.refreshStatus = r1;
        return r1;
    }

    public RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r3, int r4) {
        return new EndViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565334, r3, false));
    }

    public RecyclerView.ViewHolder createHeaderViewHolder(ViewGroup r1, int r2) {
        throw new RuntimeException("create your header view holder");
    }

    public RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup r3, int r4) {
        if (r4 != TYPE_LOADING) goto L11;
        if (tb1.c.a == false) goto L9;
        return new h(LayoutInflater.from(r3.getContext()).inflate(2131565811, r3, false));
    L9:
        return new j(LayoutInflater.from(r3.getContext()).inflate(2131565337, r3, false));
    L11:
        if (r4 != TYPE_LOAD_ERROR) goto L15;
        return new i(LayoutInflater.from(r3.getContext()).inflate(2131565335, r3, false), this.viewModel);
    L15:
        throw new RuntimeException("unknown footer type");
    }

    public RecyclerView.ViewHolder createPpxErrorViewHolder(ViewGroup r3, int r4) {
        return new i(LayoutInflater.from(r3.getContext()).inflate(r4, r3, false), this.viewModel);
    }

    public void onBindEmptyViewHolder(RecyclerView.ViewHolder r1, int r2) {
        setFullSpan(r1);
    }

    public void onBindFooterViewHolder(RecyclerView.ViewHolder r1, int r2) {
        setFullSpan(r1);
    }

    public void onBindHeaderViewHolder(RecyclerView.ViewHolder r1, int r2) {
        setFullSpan(r1);
    }

    public void onBindLoadingViewHolder(RecyclerView.ViewHolder r8, int r9) {
        setFullSpan(r8);
        if ((r8 instanceof j) == false) goto L6;
        ((j) r8).T3(refreshDataAdapter());
        return;
    L6:
        if ((r8 instanceof i) == false) goto L24;
        final i r11 = (i) r8;
        if (isEmpty() == false) goto L10;
    L13:
        boolean r12 = true;
    L14:
        LiveData<NetworkStat> r2 = networkDataAdapter();
        final MutableLiveData<Boolean> r3 = retryDataAdapter();
        r11.getClass();
        NetworkStat r4 = (NetworkStat) r2.getValue();
        View r5 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131387295);
        r3.c(((RecyclerView.ViewHolder) r11).itemView, "网络异常，点击重试", true);
        ViewGroup.LayoutParams r1 = r5.getLayoutParams();
        if (r4 != null) goto L17;
    L20:
        r1.height = -2;
        r11.b.setVisibility(8);
        TextView r13 = r11.c;
        r13.setTextColor(r13.getResources().getColor(2131107221));
        r11.c.setText(2131915977);
    L21:
        r5.setLayoutParams(r1);
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new com.bytedance.android.live.core.paging.adapter.g(r11, r3));
        return;
    L17:
        if (r4.isFailed() == false) goto L20;
        if (r12 == false) goto L20;
        r1.height = -1;
        r11.b.setVisibility(0);
        TextView r14 = r11.c;
        r14.setTextColor(r14.getResources().getColor(2131107224));
        r11.c.setText(2131915984);
        goto L21
    L10:
        if (getDataItemCount() == 0) goto L13;
        r12 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBindNormalViewHolder(RecyclerView.ViewHolder r3, int r4) {
        if ((r3 instanceof BaseViewHolder) == false) goto L12;
        T r0 = getItem(r4);
        if ((r0 instanceof s) == false) goto L7;
        ((s) r0).getClass();
        BaseViewHolder r1 = (BaseViewHolder) r3;
        r1.bind(r1.getData(null), r4);
    L9:
        if (((BaseViewHolder) r3).fullSpan() == false) goto L13;
        setFullSpan(r3);
        return;
    L13:
        return;
    L7:
        ((BaseViewHolder) r3).bind(r0, r4);
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        int r0 = getItemViewType(r4);
        if (r0 != TYPE_HEADER) goto L6;
        onBindHeaderViewHolder(r3, r4);
        return;
    L6:
        if (r0 != TYPE_FOOTER) goto L9;
        onBindFooterViewHolder(r3, r4);
        return;
    L9:
        if (r0 != TYPE_LOADING) goto L11;
    L17:
        onBindLoadingViewHolder(r3, r4);
        return;
    L11:
        if (r0 == TYPE_LOAD_ERROR) goto L17;
        if (r0 != (-1091641683)) goto L16;
        onBindEmptyViewHolder(r3, r4);
        return;
    L16:
        onBindNormalViewHolder(r3, r4);
    }

    public RecyclerView.ViewHolder onCreateEmptyViewHolder(ViewGroup r3, int r4) {
        return new EndViewHolder(LayoutInflater.from(r3.getContext()).inflate(getEmptyResId(), r3, false));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        if (r3 != TYPE_HEADER) goto L7;
        return createHeaderViewHolder(r2, r3);
    L7:
        if (r3 != TYPE_FOOTER) goto L11;
        return createFooterViewHolder(r2, r3);
    L11:
        if (r3 == TYPE_LOADING) goto L22;
        if (r3 == TYPE_LOAD_ERROR) goto L22;
        if (r3 != (-1091641683)) goto L20;
        return onCreateEmptyViewHolder(r2, r3);
    L20:
        return onCreateNormalViewHolder(r2, r3);
    L22:
        return createLoadingViewHolder(r2, r3);
    }
}
