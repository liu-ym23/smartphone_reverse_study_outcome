package com.larus.dora.impl.wlan.wifi;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.dora.impl.databinding.LarusDoraWifiListItemBinding;
import com.larus.dora.impl.databinding.LarusDoraWifiListItemHeaderBinding;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import com.larus.utils.j0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0006\u0010\u001d\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "headerText", "", "opt", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiOpt;", "onOptBtnClicked", "Lkotlin/Function1;", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;", "", "<init>", "(Ljava/lang/String;Lcom/larus/dora/impl/wlan/wifi/DoraWifiOpt;Lkotlin/jvm/functions/Function1;)V", "hasHeader", "", "list", "", "submitList", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "getDataSize", "Companion", "HeaderViewHolder", "ItemViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWifiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final String a;
    public final DoraWifiOpt b;
    public final Function1<DoraWifiEntity, Unit> c;
    public final boolean d;
    public final List<DoraWifiEntity> e;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraWifiListItemHeaderBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraWifiListItemHeaderBinding;)V", "bind", "", "headerText", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        public final LarusDoraWifiListItemHeaderBinding a;

        public HeaderViewHolder(LarusDoraWifiListItemHeaderBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraWifiListItemBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraWifiListItemBinding;)V", "bind", "", "wifiEntity", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;", "onDeleteClicked", "Lkotlin/Function1;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int b = 0;
        public final LarusDoraWifiListItemBinding a;

        public ItemViewHolder(LarusDoraWifiListItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraWifiOpt.values().length];
            r0[DoraWifiOpt.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DoraWifiOpt.DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final int getItemCount() {
        if (((ArrayList) this.e).isEmpty() == false) goto L6;
        return 0;
    L6:
        return ((ArrayList) this.e).size() + (this.d ? 1 : 0);
    }

    public final int getItemViewType(int r3) {
        if (this.d == false) goto L7;
        if (r3 != 0) goto L8;
        return 0;
    L8:
        return 1;
    L7:
        return 1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        if ((r7 instanceof HeaderViewHolder) == false) goto L6;
        HeaderViewHolder r9 = (HeaderViewHolder) r7;
        String r10 = this.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "headerText");
        r9.a.b.setText(r10);
        return;
    L6:
        if ((r7 instanceof ItemViewHolder) == false) goto L28;
        final DoraWifiEntity r0 = (DoraWifiEntity) CollectionsKt.getOrNull(this.e, r8 - (this.d ? 1 : 0));
        if (r0 != null) goto L10;
        return;
    L10:
        final ItemViewHolder r1 = (ItemViewHolder) r7;
        final Function1<DoraWifiEntity, Unit> r2 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "wifiEntity");
        Intrinsics.checkNotNullParameter(r2, "onDeleteClicked");
        final LarusDoraWifiListItemBinding r3 = r1.a;
        r3.d.setText(r0.c());
        e1.d(r3.b, new com.larus.dora.impl.wlan.wifi.a(r2, r0));
        r3.b.post(new com.larus.dora.impl.wlan.wifi.b(r1, r3));
        if (r0.a == false) goto L13;
        e1.x(r3.c);
        e1.o(r3.b);
    L14:
        g49.d.d("TAG--", "onBindViewHolder: " + r0 + ", position = " + r8 + ", " + getItemCount());
        if (getItemCount() != 2) goto L18;
        r7.itemView.setBackgroundResource(2131240672);
        return;
    L18:
        if (getItemCount() > 2) goto L20;
        return;
    L20:
        if (r8 != 1) goto L23;
        r7.itemView.setBackgroundResource(2131240669);
        return;
    L23:
        if (r8 != (getItemCount() - 1)) goto L25;
        r7.itemView.setBackgroundResource(2131240670);
        return;
    L25:
        r7.itemView.setBackgroundResource(2131240671);
        return;
    L13:
        e1.o(r3.c);
        e1.x(r3.b);
        goto L14
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != 0) goto L10;
        ConstraintLayout r7 = LayoutInflater.from(r5.getContext()).inflate(2131562315, r5, false);
        ItemGroupTitle r1 = ViewBindings.findChildViewById(r7, 2131370058);
        if (r1 == null) goto L9;
        return new HeaderViewHolder(new LarusDoraWifiListItemHeaderBinding(r7, r1));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(2131370058)));
    L10:
        ConstraintLayout r8 = LayoutInflater.from(r5.getContext()).inflate(2131562314, r5, false);
        int r9 = 2131370057;
        if (ViewBindings.findChildViewById(r8, 2131370057) == null) goto L29;
        r9 = 2131370063;
        ?? r2 = (DoraTextView) ViewBindings.findChildViewById(r8, 2131370063);
        if (r2 == 0) goto L29;
        r9 = 2131370064;
        ProgressBar r3 = (ProgressBar) ViewBindings.findChildViewById(r8, 2131370064);
        if (r3 == null) goto L29;
        r9 = 2131370070;
        DoraTextView r4 = (DoraTextView) ViewBindings.findChildViewById(r8, 2131370070);
        if (r4 == null) goto L29;
        LarusDoraWifiListItemBinding r10 = new LarusDoraWifiListItemBinding(r8, r2, r3, r4);
        DoraWifiOpt r11 = this.b;
        int r12 = b.a[r11.ordinal()];
        if (r12 != 1) goto L21;
        r2.setTextColor(ContextCompat.getColor(r2.getContext(), v19.c.b(2130972123, r2.getContext(), 2131103203)));
        int r13 = j0.a;
        r2.setText(j0.d(2131902336));
    L27:
        return new ItemViewHolder(r10);
    L21:
        if (r12 != 2) goto L24;
        int r14 = j0.a;
        r2.setTextColor(j0.a(2131102650));
        r2.setText(j0.d(2131902339));
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraWifiAdapter(String r2, DoraWifiOpt r3, Function1<? super DoraWifiEntity, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "headerText");
        Intrinsics.checkNotNullParameter(r3, "opt");
        Intrinsics.checkNotNullParameter(r4, "onOptBtnClicked");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        if (r2.length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        this.d = r5;
        this.e = new ArrayList();
        return;
    L5:
        r5 = false;
        goto L6
    }
}
