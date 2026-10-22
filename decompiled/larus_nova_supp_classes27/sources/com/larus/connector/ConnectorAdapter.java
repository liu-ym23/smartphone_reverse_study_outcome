package com.larus.connector;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0018\u0019\u001a\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/connector/ConnectorAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/connector/ConnectorListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "clickListener", "Lcom/larus/connector/ConnectorItemClickListener;", "<init>", "(Lcom/larus/connector/ConnectorItemClickListener;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "onViewAttachedToWindow", "onViewRecycled", "bindIcon", "Lcom/larus/connector/ConnectorAdapter$ConnectorViewHolder;", "iconUrl", "", "ConnectorViewHolder", "LoadingViewHolder", "ConnectorDiffCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConnectorAdapter extends ListAdapter<o, RecyclerView.ViewHolder> {
    public static final /* synthetic */ int b = 0;
    public final m a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/connector/ConnectorAdapter$ConnectorDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/connector/ConnectorListItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectorDiffCallback extends DiffUtil.ItemCallback<o> {
        public ConnectorDiffCallback() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            o r4 = (o) r2;
            o r5 = (o) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            o r4 = (o) r2;
            o r5 = (o) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            if ((r4 instanceof o.a) == false) goto L8;
            if ((r5 instanceof o.a) == false) goto L8;
            return Intrinsics.areEqual(((o.a) r4).a.a, ((o.a) r5).a.a);
        L8:
            if (r4.getClass() != r5.getClass()) goto L10;
            return true;
        L10:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/larus/connector/ConnectorAdapter$ConnectorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIvIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "iconBorders", "", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "switch", "Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "getSwitch", "()Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "connectAction", "getConnectAction", "()Landroid/view/View;", "vDivider", "getVDivider", "boundIconUrl", "", "getBoundIconUrl", "()Ljava/lang/String;", "setBoundIconUrl", "(Ljava/lang/String;)V", "setIconBordersVisible", "", "visible", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectorViewHolder extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;
        public final List<View> b;
        public final TextView c;
        public final CustomSwitchCompat d;
        public final View e;
        public final View f;
        public String g;

        public ConnectorViewHolder(View r4) {
            Intrinsics.checkNotNullParameter(r4, "view");
            super(r4);
            this.a = r4.findViewById(2131375790);
            this.b = CollectionsKt.listOf(new View[]{r4.findViewById(2131375793), r4.findViewById(2131375791)});
            this.c = (TextView) r4.findViewById(2131375802);
            this.d = r4.findViewById(2131375716);
            this.e = r4.findViewById(2131375714);
            this.f = r4.findViewById(2131375736);
        }

        public final void T3(boolean r3) {
            if (r3 == false) goto L4;
            int r4 = 0;
        L5:
            Iterator<T> r0 = this.b.iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            ((View) r0.next()).setVisibility(r4);
            goto L7
        L9:
            return;
        L4:
            r4 = 8;
            goto L5
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/connector/ConnectorAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public ConnectorAdapter(ConnectorFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
        super(new ConnectorDiffCallback());
        this.a = r2;
    }

    public final int getItemViewType(int r2) {
        o r3 = (o) getItem(r2);
        if ((r3 instanceof o.a) == false) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(r3, o.b.a) == false) goto L10;
        return 1;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewAttachedToWindow(r2);
        int r3 = r2.getAdapterPosition();
        if (r3 != (-1)) goto L5;
        return;
    L5:
        Object r4 = getItem(r3);
        if ((r4 instanceof o.a) == false) goto L8;
        o.a r5 = (o.a) r4;
    L9:
        if (r5 != null) goto L11;
        return;
    L11:
        this.a.b(r5.a);
        return;
    L8:
        r5 = null;
        goto L9
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof ConnectorViewHolder) == false) goto L5;
        ConnectorViewHolder r0 = (ConnectorViewHolder) r3;
        r0.g = null;
        r0.T3(false);
    L5:
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r3);
    }

    public final void onBindViewHolder(final RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        final o r12 = (o) getItem(r11);
        if ((r10 instanceof LoadingViewHolder) == false) goto L5;
    L21:
        r10.itemView.setOnClickListener(null);
        return;
    L5:
        if ((r12 instanceof o.a) == false) goto L21;
        ConnectorViewHolder r0 = (ConnectorViewHolder) r10;
        o.a r2 = (o.a) r12;
        final n r3 = r2.a;
        r0.d.setOnCheckedChangeListener(null);
        r0.d.setOnClickListener(null);
        r10.itemView.setOnClickListener(null);
        final ConnectorViewHolder r1 = (ConnectorViewHolder) r10;
        r1.c.setText(r3.b);
        final String r4 = r3.d;
        r1.g = r4;
        r1.T3(false);
        ImageLoaderKt.y(r1.a, r4, "task_connector_icon", new d(r1, r4), 4);
        if (r3.e == 1) goto L10;
    L12:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L16;
        r1.d.setVisibility(0);
        r1.e.setVisibility(8);
        r1.d.setChecked(r3.g);
        r1.d.setEnabled(!r2.b);
        r1.d.setClickable(!r2.b);
        r1.d.setFocusable(!r2.b);
        r1.d.setOnCheckedChangeListener(new com.larus.connector.a(this, r3));
        e1.d(r10.itemView, new b(r12, r10));
    L17:
        r1.f.setVisibility(0);
        if (r10.itemView.isAttachedToWindow() == false) goto L23;
        this.a.b(r3);
        return;
    L23:
        return;
    L16:
        r1.d.setVisibility(8);
        r1.e.setVisibility(0);
        e1.d(r10.itemView, new c(this, r3));
        goto L17
    L10:
        if (r3.f != 1) goto L12;
        r5 = true;
        goto L14
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 != 1) goto L6;
        return new LoadingViewHolder(r0.inflate(2131562686, r4, false));
    L6:
        return new ConnectorViewHolder(r0.inflate(2131562520, r4, false));
    }
}
