package com.larus.bmhome.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.list.ListAdapter;
import com.ixigua.lib.list.simple.ListViewHolder;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LoadMoreManager {
    public final ListAdapter a;
    public final ConcatAdapter b;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/utils/LoadMoreManager$FooterViewHolder;", "Lcom/ixigua/lib/list/simple/ListViewHolder;", "Lcom/larus/bmhome/utils/LoadMoreManager$Footer;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FooterViewHolder extends ListViewHolder<a> {
        public FooterViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/utils/LoadMoreManager$LoadMoreState;", "", "<init>", "(Ljava/lang/String;I)V", "Init", "Loading", "LoadMore", "Error", "End", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadMoreState extends Enum<LoadMoreState> {
        public static final LoadMoreState End = null;
        public static final LoadMoreState Error = null;
        public static final LoadMoreState Init = null;
        public static final LoadMoreState LoadMore = null;
        public static final LoadMoreState Loading = null;
        public static final /* synthetic */ LoadMoreState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LoadMoreState> getEntries() {
            return b;
        }

        static {
            LoadMoreState r0 = new LoadMoreState("Init", 0);
            Init = r0;
            LoadMoreState r1 = new LoadMoreState("Loading", 1);
            Loading = r1;
            LoadMoreState r3 = new LoadMoreState("LoadMore", 2);
            LoadMore = r3;
            LoadMoreState r5 = new LoadMoreState("Error", 3);
            Error = r5;
            LoadMoreState r7 = new LoadMoreState("End", 4);
            End = r7;
            LoadMoreState[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static LoadMoreState[] values() {
            return (LoadMoreState[]) a.clone();
        }

        public static LoadMoreState valueOf(String r1) {
            return (LoadMoreState) r27.a.a(LoadMoreState.class, r1);
        }

        public LoadMoreState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final LoadMoreState a;

        public a(LoadMoreState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            this.a = r2;
        }
    }

    public interface b {
        View a(FrameLayout r1);

        View b(FrameLayout r1);

        View c(FrameLayout r1);
    }

    public static final class c extends ay7.a<a, FooterViewHolder> {
        public final Context a;
        public final Function0<Unit> b;
        public final b c;
        public FrameLayout d;
        public LoadMoreState e;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[LoadMoreState.values().length];
                r0[LoadMoreState.LoadMore.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[LoadMoreState.Error.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[LoadMoreState.End.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final boolean accept(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            return r2 instanceof a;
        }

        public final RecyclerView.ViewHolder a(LayoutInflater r3, ViewGroup r4) {
            Intrinsics.checkNotNullParameter(r3, "inflater");
            Intrinsics.checkNotNullParameter(r4, "parent");
            FrameLayout r5 = new FrameLayout(this.a);
            r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.d = r5;
            FrameLayout r6 = this.d;
            Intrinsics.checkNotNull(r6);
            return new FooterViewHolder(r6);
        }

        public final void i(ListViewHolder r6, Object r7) {
            FooterViewHolder r8 = (FooterViewHolder) r6;
            a r9 = (a) r7;
            Intrinsics.checkNotNullParameter(r8, "holder");
            Intrinsics.checkNotNullParameter(r9, "data");
            View r0 = ((RecyclerView.ViewHolder) r8).itemView;
            if ((r0 instanceof FrameLayout) == false) goto L5;
            final FrameLayout r1 = (FrameLayout) r0;
        L6:
            if (r1 == null) goto L46;
            LoadMoreState r2 = this.e;
            LoadMoreState r3 = LoadMoreState.Loading;
            if (r2 == r3) goto L11;
        L13:
            this.e = r9.a;
            if (r1.getChildCount() <= 0) goto L16;
            r1.removeAllViews();
        L16:
            LoadMoreState r10 = r9.a;
            int r11 = a.a[r10.ordinal()];
            if (r11 != 1) goto L19;
            b r12 = this.c;
            if (r12 == null) goto L39;
            View r13 = r12.a(r1);
            if (r13 == null) goto L39;
        L40:
            r1.addView(r13);
            this.e = r3;
            com.larus.utils.t0.a.post(new n2(this));
        L42:
            if ((((RecyclerView.ViewHolder) r8).itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L45;
            ViewGroup.LayoutParams r14 = ((RecyclerView.ViewHolder) r8).itemView.getLayoutParams();
            Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            ViewGroup.LayoutParams r15 = (StaggeredGridLayoutManager.LayoutParams) r14;
            r15.setFullSpan(true);
            ((RecyclerView.ViewHolder) r8).itemView.setLayoutParams(r15);
            return;
        L45:
            return;
        L39:
            r13 = LayoutInflater.from(this.a).inflate(2131561886, r1, false);
            goto L40
        L19:
            if (r11 != 2) goto L21;
            b r16 = this.c;
            if (r16 == null) goto L33;
            View r17 = r16.b(r1);
            if (r17 == null) goto L33;
        L34:
            r1.addView(r17);
            r17.setOnClickListener(new o2(this, r1));
        L33:
            r17 = LayoutInflater.from(this.a).inflate(2131561885, r1, false);
            goto L34
        L21:
            if (r11 != 3) goto L42;
            b r18 = this.c;
            if (r18 == null) goto L27;
            View r19 = r18.c(r1);
            if (r19 == null) goto L27;
        L28:
            r1.addView(r19);
        L27:
            r19 = LayoutInflater.from(this.a).inflate(2131562580, r1, false);
            goto L28
        L11:
            if (r9.a != r3) goto L13;
            return;
        L46:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public c(Context r8, Function0<Unit> r9, b r10) {
            Intrinsics.checkNotNullParameter(r8, "context");
            this.a = r8;
            this.b = r9;
            this.c = r10;
            this.e = LoadMoreState.Init;
            RotateAnimation r11 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            r11.setDuration(2000);
            r11.setRepeatCount(-1);
        }
    }

    public final void a() {
        a r0 = new a(LoadMoreState.End);
        this.a.b.b(CollectionsKt.arrayListOf(new a[]{r0}));
    }

    public final void b() {
        a r0 = new a(LoadMoreState.Error);
        this.a.b.b(CollectionsKt.arrayListOf(new a[]{r0}));
    }

    public final void c() {
        a r0 = new a(LoadMoreState.LoadMore);
        this.a.b.b(CollectionsKt.arrayListOf(new a[]{r0}));
    }

    public final ConcatAdapter d(RecyclerView r5, RecyclerView.Adapter r6) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Intrinsics.checkNotNullParameter(r6, "adapter");
        if (this.b.getAdapters().size() != 1) goto L5;
        this.a.b.c(new a(LoadMoreState.Init));
        this.b.addAdapter(0, r6);
    L6:
        r5.setAdapter(this.b);
        return this.b;
    L5:
        RecyclerView.Adapter r0 = (RecyclerView.Adapter) ListProtector.get(this.b.getAdapters(), 0);
        this.b.removeAdapter(r0);
        this.b.addAdapter(0, r6);
        goto L6
    }

    public LoadMoreManager(Context r4, Function0<Unit> r5, b r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        RecyclerView.Adapter r0 = new ListAdapter(new ay7.b(r4), CollectionsKt.listOf(new c(r4, r5, r6)));
        this.a = r0;
        this.b = new ConcatAdapter(new RecyclerView.Adapter[]{r0});
    }
}
