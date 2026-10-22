package com.obric.oui.scrollbar;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "", "positionStart", "itemCount", "onItemRangeInserted", "onItemRangeRemoved", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ Ref.IntRef $maxContentHeight;
    final /* synthetic */ float $maxScreens;
    final /* synthetic */ RecyclerView $this_adjustScrollBarVisibilityDynamic;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 f7218c;

        a(RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r10) {
            this.f7218c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r10 = this.f7218c;
            r10.$maxContentHeight.element = 0;
            com.obric.oui.scrollbar.a r11 = com.obric.oui.scrollbar.a.f7221a;
            RecyclerView r12 = r10.$this_adjustScrollBarVisibilityDynamic;
            com.obric.oui.scrollbar.a.b(r11, r12, r10.$maxScreens, r12.computeVerticalScrollRange());
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 f7219c;

        b(RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r10) {
            this.f7219c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r10 = this.f7219c.$this_adjustScrollBarVisibilityDynamic.computeVerticalScrollRange();
            RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r11 = this.f7219c;
            Ref.IntRef r12 = r11.$maxContentHeight;
            if (r10 <= r12.element) goto L5;
            r12.element = r10;
        L5:
            com.obric.oui.scrollbar.a.b(com.obric.oui.scrollbar.a.f7221a, r11.$this_adjustScrollBarVisibilityDynamic, r11.$maxScreens, r12.element);
        }
    }

    static final class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 f7220c;

        c(RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r10) {
            this.f7220c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3 r10 = this.f7220c;
            r10.$maxContentHeight.element = 0;
            com.obric.oui.scrollbar.a r11 = com.obric.oui.scrollbar.a.f7221a;
            RecyclerView r12 = r10.$this_adjustScrollBarVisibilityDynamic;
            com.obric.oui.scrollbar.a.b(r11, r12, r10.$maxScreens, r12.computeVerticalScrollRange());
        }
    }

    RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3(RecyclerView r10, Ref.IntRef r11, float r12) {
        this.$this_adjustScrollBarVisibilityDynamic = r10;
        this.$maxContentHeight = r11;
        this.$maxScreens = r12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        this.$this_adjustScrollBarVisibilityDynamic.post(new a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int r10, int r11) {
        this.$this_adjustScrollBarVisibilityDynamic.post(new b(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int r10, int r11) {
        this.$this_adjustScrollBarVisibilityDynamic.post(new c(this));
    }
}
