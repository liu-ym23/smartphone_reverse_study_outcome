package com.larus.slides.impl.actionbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.slides.biz.impl.databinding.LarusSlidesItemPptTemplateLoadMoreBinding;
import com.larus.slides.biz.impl.databinding.LarusSlidesItemPptTemplateSelectorBinding;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003*+,B)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J&\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u000eJ\u000e\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0010J\u001c\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0018\u0010(\u001a\u00020\n2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/slides/impl/actionbar/PPTTemplateAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/slides/impl/actionbar/PPTTemplateAdapter$Item;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "callback", "Lcom/larus/slides/impl/actionbar/PPTTemplateCallback;", "onLoadMoreRequest", "Lkotlin/Function0;", "", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/larus/slides/impl/actionbar/PPTTemplateCallback;Lkotlin/jvm/functions/Function0;)V", "lastSelectedPosition", "", "currentLoadMoreState", "Lcom/larus/slides/impl/actionbar/PPTTemplateAdapter$LoadMoreState;", "spanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "getSpanSizeLookup", "spanCount", "setLoadMoreState", "state", "updateTemplates", "templates", "Lcom/larus/slides/impl/actionbar/model/PPTTemplate;", "hasMore", "", "onTemplateSelected", "submitInternal", "items", "Companion", "Item", "LoadMoreState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PPTTemplateAdapter extends ListAdapter<b, RecyclerView.ViewHolder> {
    public static final PPTTemplateAdapter$Companion$DIFF_CALLBACK$1 d = null;
    public final l a;
    public final Function0<Unit> b;
    public int c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/slides/impl/actionbar/PPTTemplateAdapter$LoadMoreState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "ERROR", "END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum LoadMoreState extends Enum<LoadMoreState> {
        public static final LoadMoreState END = null;
        public static final LoadMoreState ERROR = null;
        public static final LoadMoreState LOADING = null;
        public static final /* synthetic */ LoadMoreState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LoadMoreState> getEntries() {
            return b;
        }

        static {
            LoadMoreState r0 = new LoadMoreState("LOADING", 0);
            LOADING = r0;
            LoadMoreState r1 = new LoadMoreState("ERROR", 1);
            ERROR = r1;
            LoadMoreState r3 = new LoadMoreState("END", 2);
            END = r3;
            LoadMoreState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
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
    }

    public static abstract class b {

        public static final class a extends b {
            public final LoadMoreState a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (this.a == ((a) r4).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "LoadMore(state=" + this.a + ')';
            }

            public a(LoadMoreState r2) {
                Intrinsics.checkNotNullParameter(r2, "state");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.larus.slides.impl.actionbar.PPTTemplateAdapter$b$b, reason: collision with other inner class name */
        public static final class C0034b extends b {
            public final com.larus.slides.impl.actionbar.model.c a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0034b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0034b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Template(template=" + this.a + ')';
            }

            public C0034b(com.larus.slides.impl.actionbar.model.c r2) {
                Intrinsics.checkNotNullParameter(r2, "template");
                this.a = r2;
            }
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.actionbar.PPTTemplateAdapter$onCreateViewHolder$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass1(Object r8) {
            super(1, r8, PPTTemplateAdapter.class, "onTemplateSelected", "onTemplateSelected(I)V", 0);
        }

        public final void invoke(int r6) {
            PPTTemplateAdapter r0 = (PPTTemplateAdapter) ((CallableReference) this).receiver;
            PPTTemplateAdapter$Companion$DIFF_CALLBACK$1 r1 = PPTTemplateAdapter.d;
            List r2 = CollectionsKt.toMutableList(r0.getCurrentList());
            int r3 = r0.c;
            if (r3 >= 0) goto L5;
        L9:
            if (r6 >= 0) goto L11;
        L15:
            r0.submitList(r2);
            return;
        L11:
            if (r6 >= r2.size()) goto L15;
            if ((((b) ListProtector.get(r2, r6)) instanceof b.C0034b) == false) goto L15;
            Object r4 = ListProtector.get(r2, r6);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.larus.slides.impl.actionbar.PPTTemplateAdapter.Item.Template");
            ((b.C0034b) r4).a.e(true);
            r0.c = r6;
            goto L15
        L5:
            if (r3 >= r2.size()) goto L9;
            if ((((b) ListProtector.get(r2, r0.c)) instanceof b.C0034b) == false) goto L9;
            Object r5 = ListProtector.get(r2, r0.c);
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.slides.impl.actionbar.PPTTemplateAdapter.Item.Template");
            ((b.C0034b) r5).a.e(false);
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.slides.impl.actionbar.PPTTemplateAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        d = new PPTTemplateAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final int getItemViewType(int r2) {
        b r3 = (b) getItem(r2);
        if ((r3 instanceof b.C0034b) == false) goto L6;
        return 0;
    L6:
        if ((r3 instanceof b.a) == false) goto L10;
        return 1;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public PPTTemplateAdapter(l r2, c r3) {
        Intrinsics.checkNotNullParameter(r3, "onLoadMoreRequest");
        super(d);
        this.a = r2;
        this.b = r3;
        this.c = -1;
        LoadMoreState r4 = LoadMoreState.LOADING;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        b r0 = (b) getItem(r9);
        int r2 = 8;
        boolean r3 = true;
        if ((r0 instanceof b.C0034b) == false) goto L33;
        final PPTTemplateViewHolder r10 = (PPTTemplateViewHolder) r8;
        com.larus.slides.impl.actionbar.model.c r1 = ((b.C0034b) r0).a;
        if (r9 != this.c) goto L7;
        boolean r11 = true;
    L8:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r1, "template");
        r10.d = r1;
        r10.e = r10.getBindingAdapterPosition();
        com.larus.slides.impl.actionbar.model.a r4 = r1.a();
        if (r4 == null) goto L12;
        String r5 = r4.c();
        if (r5 == null) goto L12;
    L13:
        ImageLoaderKt.u(r10.a.d, r5, "ppt_template_preview");
        String r6 = r1.c();
        AppCompatTextView r7 = r10.a.e;
        if (r6 != null) goto L16;
    L19:
        if (r3 == false) goto L21;
        Intrinsics.checkNotNull(r7);
        r7.setVisibility(8);
    L22:
        com.larus.slides.impl.actionbar.model.c r12 = r10.d;
        if (r12 == null) goto L31;
        r12.e(r11);
        LarusSlidesItemPptTemplateSelectorBinding r13 = r10.a;
        AppCompatImageView r14 = r13.c;
        if (r11 == false) goto L27;
        r2 = 0;
    L27:
        r14.setVisibility(r2);
        if (r11 == false) goto L30;
        r13.e.setTextColor(v19.c.a(2130972123, ((RecyclerView.ViewHolder) r10).itemView.getContext(), 2131103203));
        goto L31
    L30:
        r13.e.setTextColor(v19.c.a(2130972079, ((RecyclerView.ViewHolder) r10).itemView.getContext(), 2131103136));
    L31:
        r10.a.b.setOnClickListener(new o(r10));
        return;
    L21:
        Intrinsics.checkNotNull(r7);
        r7.setVisibility(0);
        r7.setText(r6);
        goto L22
    L16:
        if (r6.length() == 0) goto L19;
        r3 = false;
    L12:
        r5 = "";
        goto L13
    L7:
        r11 = false;
        goto L8
    L33:
        if ((r0 instanceof b.a) == false) goto L47;
        PPTTemplateLoadMoreViewHolder r15 = (PPTTemplateLoadMoreViewHolder) r8;
        LoadMoreState r16 = ((b.a) r0).a;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "state");
        int r17 = PPTTemplateLoadMoreViewHolder.a.a[r16.ordinal()];
        if (r17 != 1) goto L37;
        LarusSlidesItemPptTemplateLoadMoreBinding r18 = r15.a;
        r18.c.setVisibility(0);
        r18.b.setVisibility(8);
        r18.d.setVisibility(8);
        return;
    L37:
        if (r17 != 2) goto L39;
        LarusSlidesItemPptTemplateLoadMoreBinding r19 = r15.a;
        r19.c.setVisibility(8);
        r19.b.setVisibility(0);
        r19.d.setVisibility(8);
        return;
    L39:
        if (r17 != 3) goto L42;
        LarusSlidesItemPptTemplateLoadMoreBinding r20 = r15.a;
        r20.c.setVisibility(8);
        r20.b.setVisibility(8);
        r20.d.setVisibility(0);
        return;
    L42:
        throw new NoWhenBranchMatchedException();
    L47:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        if (r10 != 0) goto L5;
        View r11 = LayoutInflater.from(r9.getContext()).inflate(2131563138, r9, false);
        int r12 = 2131365216;
        CardView r4 = ViewBindings.findChildViewById(r11, 2131365216);
        if (r4 == null) goto L28;
        r12 = 2131365309;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r11, 2131365309);
        if (r5 == null) goto L28;
        r12 = 2131376660;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r11, 2131376660);
        if (r6 == null) goto L28;
        r12 = 2131391568;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r11, 2131391568);
        if (r7 == null) goto L28;
        return new PPTTemplateViewHolder(new LarusSlidesItemPptTemplateSelectorBinding((LinearLayout) r11, r4, r5, r6, r7), this.a, new AnonymousClass1(this));
    L28:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    L5:
        if (r10 != 1) goto L16;
        ConstraintLayout r13 = LayoutInflater.from(r9.getContext()).inflate(2131563137, r9, false);
        int r14 = 2131377489;
        LinearLayoutCompat r1 = ViewBindings.findChildViewById(r13, 2131377489);
        if (r1 == null) goto L14;
        r14 = 2131383297;
        ProgressBar r2 = (ProgressBar) ViewBindings.findChildViewById(r13, 2131383297);
        if (r2 == null) goto L14;
        r14 = 2131390565;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r13, 2131390565);
        if (r3 == null) goto L14;
        return new PPTTemplateLoadMoreViewHolder(new LarusSlidesItemPptTemplateLoadMoreBinding(r13, r1, r2, r3), this.b);
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    L16:
        throw new IllegalArgumentException("Unknown view type: " + r10);
    }

    public final void y2(List<com.larus.slides.impl.actionbar.model.c> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "templates");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r0.add(new b.C0034b((com.larus.slides.impl.actionbar.model.c) r8.next()));
        goto L4
    L6:
        List r9 = CollectionsKt.toMutableList(r0);
        Iterator r1 = r9.iterator();
        int r2 = 0;
    L8:
        if (r1.hasNext() == false) goto L23;
        b r3 = (b) r1.next();
        if ((r3 instanceof b.C0034b) == false) goto L12;
        b.C0034b r4 = (b.C0034b) r3;
    L13:
        if (r4 == null) goto L19;
        com.larus.slides.impl.actionbar.model.c r5 = r4.a;
        if (r5 == null) goto L19;
        boolean r10 = true;
        if (r5.d() != true) goto L19;
    L20:
        if (r10 == true) goto L24;
        r2 = r2 + 1;
    L24:
        this.c = r2;
        LoadMoreState r11 = LoadMoreState.LOADING;
        if (r7 == false) goto L27;
        r9.add(new b.a(LoadMoreState.LOADING));
    L27:
        submitList(r9);
        return;
    L19:
        r10 = false;
        goto L20
    L12:
        r4 = null;
        goto L13
    L23:
        r2 = -1;
        goto L24
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6, List<? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r7, "payloads");
        if (r7.isEmpty() == false) goto L6;
        onBindViewHolder(r5, r6);
        return;
    L6:
        b r0 = (b) getItem(r6);
        if ((r0 instanceof b.C0034b) == false) goto L29;
        PPTTemplateViewHolder r8 = (PPTTemplateViewHolder) r5;
        Iterator<T> r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L42;
        if (Intrinsics.areEqual(r9.next(), "SELECTION_CHANGED") == false) goto L10;
        int r1 = 0;
        if (r6 != this.c) goto L16;
        boolean r2 = true;
    L17:
        com.larus.slides.impl.actionbar.model.c r3 = r8.d;
        if (r3 == null) goto L20;
        r3.e(r2);
    L20:
        LarusSlidesItemPptTemplateSelectorBinding r4 = r8.a;
        AppCompatImageView r10 = r4.c;
        if (r2 == true) goto L24;
        r1 = 8;
    L24:
        r10.setVisibility(r1);
        if (r2 == true) goto L26;
        r4.e.setTextColor(v19.c.a(2130972079, ((RecyclerView.ViewHolder) r8).itemView.getContext(), 2131103136));
        goto L10
    L26:
        r4.e.setTextColor(v19.c.a(2130972123, ((RecyclerView.ViewHolder) r8).itemView.getContext(), 2131103203));
        goto L10
    L16:
        r2 = false;
        goto L17
    L42:
        return;
    L29:
        if ((r0 instanceof b.a) == false) goto L33;
        onBindViewHolder(r5, r6);
        return;
    L33:
        throw new NoWhenBranchMatchedException();
    }
}
