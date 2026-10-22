package com.larus.dora.o.impl.memory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB5\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/o/impl/memory/OMemoryEventAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onEventClick", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/memory/OMemoryEvent;", "", "onEventLongPress", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "items", "", "Lcom/larus/dora/o/impl/memory/OMemoryListItem;", "submitList", "newItems", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "Companion", "GroupHolder", "EventHolder", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OMemoryEventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Function1<n, Unit> a;
    public final Function2<n, View, Unit> b;
    public final List<b0> c;

    public static final class a {
    }

    public final class b extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final TextView c;
        public final /* synthetic */ OMemoryEventAdapter d;

        public b(OMemoryEventAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.d = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131379872);
            this.b = (TextView) r3.findViewById(2131379871);
            this.c = (TextView) r3.findViewById(2131379864);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final OSectionTitleBar a;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2.findViewById(2131379866);
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public final int getItemViewType(int r2) {
        return !(ListProtector.get(this.c, r2) instanceof z) ? 1 : 0;
    }

    public OMemoryEventAdapter(s r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "onEventClick");
        Intrinsics.checkNotNullParameter(r3, "onEventLongPress");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        b0 r9 = (b0) ListProtector.get(this.c, r8);
        String r1 = "";
        if ((r9 instanceof z) == false) goto L10;
        c r10 = (c) r7;
        z r11 = (z) r9;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "item");
        OSectionTitleBar r0 = r10.a;
        String r12 = r11.a;
        if (r12 == null) goto L8;
        r1 = r12;
    L8:
        r0.setTitleText(r1);
        r10.a.setTitleTextSize(12.0f);
        return;
    L10:
        if ((r9 instanceof n) == false) goto L43;
        final b r13 = (b) r7;
        final n r14 = (n) r9;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "item");
        TextView r2 = r13.b;
        String r3 = r14.e();
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        r2.setText(r3);
        TextView r4 = r13.c;
        String r5 = r14.a();
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        r4.setText(r5);
        TextView r6 = r13.c;
        String r15 = r14.a();
        boolean r16 = true;
        int r17 = 0;
        if (r15 != null) goto L20;
    L23:
        boolean r18 = true;
    L25:
        if (r18 == false) goto L27;
        int r20 = 8;
    L28:
        r6.setVisibility(r20);
        TextView r21 = r13.a;
        String r22 = r14.getType();
        if (r22 == null) goto L32;
        r1 = r22;
    L32:
        r21.setText(r1);
        TextView r23 = r13.a;
        String r24 = r14.getType();
        if (r24 != null) goto L35;
    L38:
        if (r16 == false) goto L40;
        r17 = 8;
    L40:
        r23.setVisibility(r17);
        View r25 = ((RecyclerView.ViewHolder) r13).itemView;
        final OMemoryEventAdapter r26 = r13.d;
        r25.setOnClickListener(new o(r26, r14));
        View r27 = ((RecyclerView.ViewHolder) r13).itemView;
        final OMemoryEventAdapter r28 = r13.d;
        r27.setOnLongClickListener(new p(r28, r14, r13));
        return;
    L35:
        if (r24.length() == 0) goto L38;
        r16 = false;
        goto L38
    L27:
        r20 = 0;
        goto L28
    L20:
        if (r15.length() == 0) goto L23;
        r18 = false;
        goto L25
    L43:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 != 0) goto L6;
        return new c(r0.inflate(2131560155, r4, false));
    L6:
        return new b(this, r0.inflate(2131560154, r4, false));
    }
}
