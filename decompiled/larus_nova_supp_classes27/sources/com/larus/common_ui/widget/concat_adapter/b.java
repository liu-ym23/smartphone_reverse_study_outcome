package com.larus.common_ui.widget.concat_adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final a29.a.C0000a a;
    public final c.d b;
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> c;
    public final InterfaceC0016b d;
    public int e;
    public final a f;

    public class a extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ b a;

        public final void onChanged() {
            b r0 = this.a;
            r0.e = r0.c.getItemCount();
            com.larus.common_ui.widget.concat_adapter.a r1 = (com.larus.common_ui.widget.concat_adapter.a) this.a.d;
            RecyclerView r2 = r1.d();
            if (r2 != null) goto L5;
        L8:
            FLogger.a.e("ConcatAdapterController", "onChanged return, recyclerView is null or is computing layout");
            return;
        L5:
            if (r2.isComputingLayout() == true) goto L8;
            r1.a.notifyDataSetChanged();
        }

        public a(b r1) {
            this.a = r1;
        }

        public final void onItemRangeChanged(int r4, int r5) {
            b r0 = this.a;
            ((com.larus.common_ui.widget.concat_adapter.a) r0.d).g(r0, r4, r5, null);
        }

        public final void onItemRangeInserted(int r4, int r5) {
            b r0 = this.a;
            r0.e += r5;
            com.larus.common_ui.widget.concat_adapter.a r1 = (com.larus.common_ui.widget.concat_adapter.a) r0.d;
            RecyclerView r2 = r1.d();
            if (r2 != null) goto L5;
        L8:
            FLogger.a.e("ConcatAdapterController", "onItemRangeInserted return, recyclerView is null or is computing layout");
            return;
        L5:
            if (r2.isComputingLayout() == true) goto L8;
            r1.a.notifyItemRangeInserted(r4 + r1.b(r0), r5);
        }

        public final void onItemRangeRemoved(int r4, int r5) {
            b r0 = this.a;
            r0.e -= r5;
            com.larus.common_ui.widget.concat_adapter.a r1 = (com.larus.common_ui.widget.concat_adapter.a) r0.d;
            RecyclerView r2 = r1.d();
            if (r2 != null) goto L5;
        L8:
            FLogger.a.e("ConcatAdapterController", "onItemRangeRemoved return, recyclerView is null or is computing layout");
            return;
        L5:
            if (r2.isComputingLayout() == true) goto L8;
            r1.a.notifyItemRangeRemoved(r4 + r1.b(r0), r5);
        }

        public final void onItemRangeChanged(int r3, int r4, Object r5) {
            b r0 = this.a;
            ((com.larus.common_ui.widget.concat_adapter.a) r0.d).g(r0, r3, r4, r5);
        }

        public final void onItemRangeMoved(int r3, int r4, int r5) {
            b r6 = this.a;
            com.larus.common_ui.widget.concat_adapter.a r0 = (com.larus.common_ui.widget.concat_adapter.a) r6.d;
            int r7 = r0.b(r6);
            RecyclerView r1 = r0.d();
            if (r1 != null) goto L5;
        L8:
            FLogger.a.e("ConcatAdapterController", "onItemRangeMoved return, recyclerView is null or is computing layout");
            return;
        L5:
            if (r1.isComputingLayout() == true) goto L8;
            r0.a.notifyItemMoved(r3 + r7, r4 + r7);
        }
    }

    /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.b$b, reason: collision with other inner class name */
    public interface InterfaceC0016b {
    }

    public b(RecyclerView.Adapter r2, InterfaceC0016b r3, a29.a r4, c.d r5) {
        a r0 = new a(this);
        this.f = r0;
        this.c = r2;
        this.d = r3;
        r4.getClass();
        this.a = new a29.a.C0000a(r4, this);
        this.b = r5;
        this.e = r2.getItemCount();
        r2.registerAdapterDataObserver(r0);
    }
}
