package com.larus.business.multitask_management.impl.sheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.business.multitask_management.impl.component.SectionCardStyle;
import com.larus.business.multitask_management.impl.databinding.LarusMtmItemServiceBinding;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.w0;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002?@B»\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012:\b\u0002\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010\u0012:\b\u0002\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\rH\u0016J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\rH\u0016J\b\u0010)\u001a\u00020\rH\u0016J\u0015\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b,J$\u0010-\u001a\u00020\u00152\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u000bJ\u0010\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\rJ\b\u00100\u001a\u00020\rH\u0002J$\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J,\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002JT\u00102\u001a\u00020\u00152\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\rH\u0002J(\u0010;\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u000bH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MtmServiceSectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "tag", "", "items", "", "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "renderConfig", "Lcom/larus/business/multitask_management/impl/component/SectionRenderConfig;", "enableFold", "", "foldThreshold", "", "enableCardShadow", "onItemClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bindingAdapterPosition", "clickFrom", "", "onItemLongClick", "Landroid/view/View;", "anchorView", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/larus/business/multitask_management/impl/component/SectionRenderConfig;ZIZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getTag", "()Ljava/lang/String;", "getRenderConfig$impl_mainlandRelease", "()Lcom/larus/business/multitask_management/impl/component/SectionRenderConfig;", "isFolded", "hasUserExpanded", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "getSpanSize", "spanCount", "getSpanSize$impl_mainlandRelease", "updateItems", "hasMore", "getItemAt", "visibleItemCount", "displayItems", "updateDataInternal", "oldDisplayItems", "newDisplayItems", "oldFullItemCount", "newFullItemCount", "oldIsFolded", "newIsFolded", "oldFoldThreshold", "newFoldThreshold", "isFoldTriggerCardAt", "fullItemCount", "folded", "updateFoldStateAfterItemsChanged", "LargeServiceViewHolder", "SmallServiceViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MtmServiceSectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final String a;
    public List<ll9.t> b;
    public final com.larus.business.multitask_management.impl.component.j c;
    public final boolean d;
    public int e;
    public final boolean f;
    public final Function2<Integer, String, Unit> g;
    public final Function2<Integer, View, Unit> h;
    public boolean i;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u008e\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2:\b\u0002\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MtmServiceSectionAdapter$LargeServiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemServiceBinding;", "<init>", "(Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemServiceBinding;)V", "longPressActive", "", "bind", "", "item", "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "isFoldTriggerCard", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "bindingAdapterPosition", "", "clickFrom", "onItemLongClick", "Landroid/view/View;", "anchorView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LargeServiceViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final LarusMtmItemServiceBinding a;
        public boolean b;

        public LargeServiceViewHolder(LarusMtmItemServiceBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u008e\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072:\b\u0002\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102:\b\u0002\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MtmServiceSectionAdapter$SmallServiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemServiceBinding;", "<init>", "(Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemServiceBinding;)V", "value", "", "isFoldTriggerCard", "()Z", "longPressActive", "bind", "", "item", "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "bindingAdapterPosition", "", "clickFrom", "onItemLongClick", "Landroid/view/View;", "anchorView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SmallServiceViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public final LarusMtmItemServiceBinding a;
        public boolean b;
        public boolean c;

        public SmallServiceViewHolder(LarusMtmItemServiceBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SectionCardStyle.values().length];
            r0[SectionCardStyle.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SectionCardStyle.LARGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final int getItemCount() {
        if (this.d == false) goto L8;
        if (this.i == false) goto L8;
        return RangesKt.coerceIn(this.e, 0, this.b.size());
    L8:
        return this.b.size();
    }

    public final int getItemViewType(int r1) {
        return this.c.d.ordinal();
    }

    public final ll9.t y2(int r2) {
        return (ll9.t) CollectionsKt.getOrNull(this.b, r2);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        final boolean r0 = z2(r11, this.b.size(), this.i, this.e);
        int r2 = 8;
        if ((r10 instanceof SmallServiceViewHolder) == false) goto L10;
        final SmallServiceViewHolder r12 = (SmallServiceViewHolder) r10;
        ll9.t r13 = (ll9.t) ListProtector.get(this.b, r11);
        final Function2<Integer, String, Unit> r1 = this.g;
        final Function2<Integer, View, Unit> r5 = this.h;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "item");
        r12.b = r0;
        r12.c = false;
        if (r0 == false) goto L7;
        SimpleDraweeView r14 = r12.a.c;
        NodeType r3 = NodeType.UNKNOWN;
        h.b(r14, r3);
        h.a(r12.a.c, r3);
        TextView r15 = r12.a.e;
        int r4 = j0.a;
        r15.setText(j0.d(2131899751));
        com.larus.business.multitask_management.impl.view.f.c(((RecyclerView.ViewHolder) r12).itemView.getContext(), r12.a.c, "res:///2131243073", null, null);
    L8:
        r12.a.b.setVisibility(8);
        r12.a.d.setVisibility(8);
        r12.a.a.setOnTouchListener(new e(r12));
        e1.d(r12.a.a, new f(r1, r12, r0));
        r12.a.a.setOnLongClickListener(new g(r0, r12, r5));
        return;
    L7:
        h.b(r12.a.c, r13.a);
        h.a(r12.a.c, r13.a);
        r12.a.e.setText(r13.c);
        com.larus.business.multitask_management.impl.view.f.c(((RecyclerView.ViewHolder) r12).itemView.getContext(), r12.a.c, r13.d, r13.f, Integer.valueOf(com.larus.business.multitask_management.impl.view.f.b(r13)));
        goto L8
    L10:
        if ((r10 instanceof LargeServiceViewHolder) == false) goto L17;
        final LargeServiceViewHolder r16 = (LargeServiceViewHolder) r10;
        ll9.t r17 = (ll9.t) ListProtector.get(this.b, r11);
        final Function2<Integer, String, Unit> r6 = this.g;
        final Function2<Integer, View, Unit> r7 = this.h;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "item");
        r16.b = false;
        r16.a.e.setText(r17.c);
        h.b(r16.a.c, r17.a);
        h.a(r16.a.c, r17.a);
        com.larus.business.multitask_management.impl.view.f.c(((RecyclerView.ViewHolder) r16).itemView.getContext(), r16.a.c, r17.d, r17.f, Integer.valueOf(com.larus.business.multitask_management.impl.view.f.b(r17)));
        r16.a.b.setVisibility(0);
        e1.d(r16.a.b, new com.larus.business.multitask_management.impl.sheet.a(r6, r16));
        View r18 = r16.a.d;
        if (r0 == false) goto L14;
        r2 = 0;
    L14:
        r18.setVisibility(r2);
        r16.a.a.setOnTouchListener(new b(r16));
        e1.d(r16.a.a, new c(r6, r16, r0));
        r16.a.a.setOnLongClickListener(new d(r16, r7));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        SectionCardStyle r5 = this.c.d;
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        LarusMtmItemServiceBinding r7 = LarusMtmItemServiceBinding.a(LayoutInflater.from(r3.getContext()), r3);
        w0.e(r7.c, c7.b(8));
        if (this.f == false) goto L16;
        com.larus.business.multitask_management.impl.view.f.a(r7.a);
    L16:
        return new SmallServiceViewHolder(r7);
    L5:
        if (r6 != 2) goto L11;
        LarusMtmItemServiceBinding r8 = LarusMtmItemServiceBinding.a(LayoutInflater.from(r3.getContext()), r3);
        w0.e(r8.c, c7.b(8));
        if (this.f == false) goto L17;
        com.larus.business.multitask_management.impl.view.f.a(r8.a);
    L17:
        return new LargeServiceViewHolder(r8);
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void A2(List<ll9.t> r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "items");
        final boolean r6 = this.i;
        final int r7 = this.e;
        final int r5 = this.b.size();
        List<ll9.t> r0 = this.b;
        if (this.d == false) goto L6;
        if (r6 == false) goto L6;
        r0 = CollectionsKt.take(r0, RangesKt.coerceIn(r7, 0, r0.size()));
    L6:
        if (r13 <= 0) goto L8;
        this.e = r13;
    L8:
        this.b = r12;
        if (this.d == true) goto L12;
        this.i = false;
    L15:
        final boolean r9 = this.i;
        final int r10 = this.e;
        final int r8 = this.b.size();
        List<ll9.t> r15 = this.b;
        if (this.d == false) goto L19;
        if (r9 == false) goto L19;
        r15 = CollectionsKt.take(r15, RangesKt.coerceIn(r10, 0, r15.size()));
    L19:
        final List<ll9.t> r3 = r15;
        final List<ll9.t> r2 = r0;
        DiffUtil.calculateDiff(new MtmServiceSectionAdapter$updateDataInternal$diffResult$1(r2, r3, this, r5, r6, r7, r8, r9, r10)).dispatchUpdatesTo(this);
        return;
    L12:
        if (r12.size() > this.e) goto L14;
        this.i = r14;
        goto L15
    L14:
        this.i = true;
        goto L15
    }

    public final boolean z2(int r3, int r4, boolean r5, int r6) {
        if (this.d == false) goto L9;
        if (r5 == true) goto L6;
        return false;
    L6:
        if (r3 != (RangesKt.coerceIn(r6, 0, r4) - 1)) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MtmServiceSectionAdapter(String r2, List<ll9.t> r3, com.larus.business.multitask_management.impl.component.j r4, boolean r5, int r6, boolean r7, Function2<? super Integer, ? super String, Unit> r8, Function2<? super Integer, ? super View, Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "items");
        Intrinsics.checkNotNullParameter(r4, "renderConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
