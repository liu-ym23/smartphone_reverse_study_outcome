package com.larus.common_ui.widget.concat_adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final com.larus.common_ui.widget.concat_adapter.a a;

    public static final class Config {
        public static final Config b = null;
        public final StableIdMode a;

        public static final enum StableIdMode extends Enum<StableIdMode> {
            public static final StableIdMode ISOLATED_STABLE_IDS = null;
            public static final StableIdMode NO_STABLE_IDS = null;
            public static final StableIdMode SHARED_STABLE_IDS = null;
            public static final /* synthetic */ StableIdMode[] a = null;

            static {
                StableIdMode r0 = new StableIdMode("NO_STABLE_IDS", 0);
                NO_STABLE_IDS = r0;
                StableIdMode r1 = new StableIdMode("ISOLATED_STABLE_IDS", 1);
                ISOLATED_STABLE_IDS = r1;
                StableIdMode r3 = new StableIdMode("SHARED_STABLE_IDS", 2);
                SHARED_STABLE_IDS = r3;
                a = new StableIdMode[]{r0, r1, r3};
            }

            public static StableIdMode[] values() {
                return (StableIdMode[]) a.clone();
            }

            public static StableIdMode valueOf(String r1) {
                return (StableIdMode) r27.a.a(StableIdMode.class, r1);
            }

            public StableIdMode(String r1, int r2) {
                super(r1, r2);
            }
        }

        static {
            b = new Config(StableIdMode.NO_STABLE_IDS);
        }

        public Config(StableIdMode r1) {
            this.a = r1;
        }
    }

    public static final class a {
        public final RecyclerView.Adapter<?> a;
        public final int b;
        public final int c;

        public a(RecyclerView.Adapter r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @SafeVarargs
    public ConcatAdapter() {
        throw null;
    }

    public final List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getAdapters() {
        com.larus.common_ui.widget.concat_adapter.a r0 = this.a;
        if (((ArrayList) r0.e).isEmpty() == false) goto L5;
        List r1 = Collections.emptyList();
    L11:
        return Collections.unmodifiableList(r1);
    L5:
        ArrayList r2 = new ArrayList(((ArrayList) r0.e).size());
        Iterator r3 = ((ArrayList) r0.e).iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(((b) r3.next()).c);
        goto L7
    L9:
        r1 = r2;
        goto L11
    }

    public final int getItemCount() {
        Iterator r0 = ((ArrayList) this.a.e).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + ((b) r0.next()).e;
        goto L4
    L6:
        return r1;
    }

    @SafeVarargs
    public ConcatAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... r4) {
        Config r0 = Config.b;
        List r5 = Arrays.asList(r4);
        this.a = new com.larus.common_ui.widget.concat_adapter.a(this, r0);
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r1 = (RecyclerView.Adapter) r6.next();
        com.larus.common_ui.widget.concat_adapter.a r2 = this.a;
        r2.a(((ArrayList) r2.e).size(), r1);
        goto L4
    L7:
        if (this.a.g == Config.StableIdMode.NO_STABLE_IDS) goto L9;
        boolean r7 = true;
    L10:
        super.setHasStableIds(r7);
        return;
    L9:
        r7 = false;
        goto L10
    }

    public static a y2(RecyclerView.ViewHolder r9) {
        if ((r9.itemView.getParent() instanceof RecyclerView) == true) goto L5;
        return null;
    L5:
        RecyclerView r0 = r9.itemView.getParent();
        RecyclerView.Adapter r2 = r0.getAdapter();
        if (r2 != null) goto L9;
        return null;
    L9:
        if ((r2 instanceof ConcatAdapter) == true) goto L15;
        int r10 = r9.getAdapterPosition();
        if (r10 != (-1)) goto L14;
        return null;
    L14:
        return new a(r2, r10, r10);
    L15:
        ConcatAdapter r3 = (ConcatAdapter) r2;
        b r4 = r3.a.d.get(r9);
        if (r4 != null) goto L18;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r5 = null;
    L19:
        if (r5 != null) goto L21;
        return null;
    L21:
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r6 = r3.getAdapters().iterator();
        boolean r7 = false;
        int r8 = 0;
    L23:
        if (r6.hasNext() == false) goto L28;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r11 = r6.next();
        if (r11 == r5) goto L26;
        r8 = r8 + r11.getItemCount();
        goto L23
    L26:
        r7 = true;
    L28:
        if (r7 == true) goto L30;
        return null;
    L30:
        int r12 = r9.getAdapterPosition();
        if (r12 == (-1)) goto L33;
        int r13 = r8 + r12;
    L37:
        if (r12 >= 0) goto L39;
    L46:
        return null;
    L39:
        if (r12 >= r5.getItemCount()) goto L46;
        if (r13 < 0) goto L46;
        if (r13 >= r3.getItemCount()) goto L46;
        return new a(r5, r12, r13);
    L33:
        int r14 = r0.getChildAdapterPosition(r9.itemView);
        if (r14 != (-1)) goto L36;
        return null;
    L36:
        r12 = r14 - r8;
        r13 = r14;
        goto L37
    L18:
        r5 = r4.c;
        goto L19
    }

    public static int z2(RecyclerView.ViewHolder r0) {
        a r1 = y2(r0);
        if (r1 != null) goto L6;
        return -1;
    L6:
        return r1.b;
    }

    public final long getItemId(int r5) {
        com.larus.common_ui.widget.concat_adapter.a r0 = this.a;
        com.larus.common_ui.widget.concat_adapter.a.C0015a r6 = r0.c(r5);
        b r1 = r6.a;
        int r2 = r6.b;
        long r3 = r1.c.getItemId(r2);
        long r4 = r1.b.localToGlobal(r3);
        r6.c = false;
        r6.a = null;
        r6.b = -1;
        r0.f = r6;
        return r4;
    }

    public final int getItemViewType(int r9) {
        com.larus.common_ui.widget.concat_adapter.a r0 = this.a;
        com.larus.common_ui.widget.concat_adapter.a.C0015a r10 = r0.c(r9);
        b r1 = r10.a;
        int r2 = r10.b;
        a29.a.C0000a r3 = r1.a;
        int r4 = r1.c.getItemViewType(r2);
        int r5 = r3.a.indexOfKey(r4);
        if (r5 <= (-1)) goto L5;
        int r6 = r3.a.valueAt(r5);
    L6:
        r10.c = false;
        r10.a = null;
        r10.b = -1;
        r0.f = r10;
        return r6;
    L5:
        a29.a r7 = r3.d;
        b r8 = r3.c;
        int r11 = r7.b;
        r7.b = r11 + 1;
        r7.a.put(r11, r8);
        r3.a.put(r4, r11);
        r3.b.put(r11, r4);
        r6 = r11;
        goto L6
    }

    public final void onAttachedToRecyclerView(RecyclerView r4) {
        com.larus.common_ui.widget.concat_adapter.a r0 = this.a;
        Iterator r1 = ((ArrayList) r0.c).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (((WeakReference) r1.next()).get() != r4) goto L4;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L15;
        List<WeakReference<RecyclerView>> r3 = r0.c;
        ArrayList r5 = (ArrayList) r3;
        r5.add(new WeakReference(r4));
        Iterator r6 = ((ArrayList) r0.e).iterator();
    L13:
        if (r6.hasNext() == false) goto L20;
        ((b) r6.next()).c.onAttachedToRecyclerView(r4);
        goto L13
    L20:
        return;
    L15:
        return;
    L8:
        r2 = false;
        goto L9
    }

    public final void onDetachedFromRecyclerView(RecyclerView r5) {
        com.larus.common_ui.widget.concat_adapter.a r0 = this.a;
        int r1 = ((ArrayList) r0.c).size();
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L11;
        WeakReference r2 = (WeakReference) ListProtector.get(r0.c, r1);
        if (r2.get() == null) goto L7;
        if (r2.get() != r5) goto L3;
        ListProtector.remove(r0.c, r1);
        goto L11
    L7:
        ListProtector.remove(r0.c, r1);
    L11:
        Iterator r3 = ((ArrayList) r0.e).iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        ((b) r3.next()).c.onDetachedFromRecyclerView(r5);
        goto L13
    }

    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r5) {
        com.larus.common_ui.widget.concat_adapter.a r0 = this.a;
        b r1 = r0.d.get(r5);
        if (r1 == null) goto L7;
        boolean r2 = r1.c.onFailedToRecycleView(r5);
        r0.d.remove(r5);
        return r2;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r5 + ", seems like it is not bound by this adapter: " + r0);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        this.a.e(r2).c.onViewAttachedToWindow(r2);
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        this.a.e(r2).c.onViewDetachedFromWindow(r2);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r5) {
        com.larus.common_ui.widget.concat_adapter.a r0 = this.a;
        b r1 = r0.d.get(r5);
        if (r1 == null) goto L7;
        r1.c.onViewRecycled(r5);
        r0.d.remove(r5);
        return;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r5 + ", seems like it is not bound by this adapter: " + r0);
    }

    public final boolean removeAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r7) {
        com.larus.common_ui.widget.concat_adapter.a r0 = this.a;
        int r1 = r0.f(r7);
        if (r1 != (-1)) goto L5;
        return false;
    L5:
        b r3 = (b) ListProtector.get(r0.e, r1);
        int r4 = r0.b(r3);
        ListProtector.remove(r0.e, r1);
        r0.a.notifyItemRangeRemoved(r4, r3.e);
        Iterator r2 = ((ArrayList) r0.c).iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        RecyclerView r5 = (RecyclerView) ((WeakReference) r2.next()).get();
        if (r5 == null) goto L7;
        r7.onDetachedFromRecyclerView(r5);
        goto L7
    L11:
        r3.c.unregisterAdapterDataObserver(r3.f);
        a29.a.C0000a r8 = r3.a;
        a29.a r6 = r8.d;
        b r9 = r8.c;
        int r10 = r6.a.size();
    L12:
        r10 = r10 - 1;
        if (r10 < 0) goto L17;
        if (r6.a.valueAt(r10) != r9) goto L12;
        r6.a.removeAt(r10);
        goto L12
    L17:
        return true;
    }

    public final void setHasStableIds(boolean r2) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    public final boolean addAdapter(int r2, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r3) {
        return this.a.a(0, r3);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        com.larus.common_ui.widget.concat_adapter.a r0 = this.a;
        com.larus.common_ui.widget.concat_adapter.a.C0015a r6 = r0.c(r5);
        r0.d.put(r4, r6.a);
        b r1 = r6.a;
        int r2 = r6.b;
        r1.c.bindViewHolder(r4, r2);
        r6.c = false;
        r6.a = null;
        r6.b = -1;
        r0.f = r6;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        b r0 = this.a.b.a.get(r5);
        if (r0 == null) goto L11;
        a29.a.C0000a r1 = r0.a;
        int r2 = r1.b.indexOfKey(r5);
        if (r2 < 0) goto L9;
        return r0.c.onCreateViewHolder(r4, r1.b.valueAt(r2));
    L9:
        throw new IllegalStateException("requested global type " + r5 + " does not belong to the adapter:" + r1.c.c);
    L11:
        throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r5);
    }
}
