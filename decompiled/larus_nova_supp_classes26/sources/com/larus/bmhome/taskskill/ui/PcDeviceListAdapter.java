package com.larus.bmhome.taskskill.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.model.PcDeviceUiState;
import com.larus.ui.CommonTaskItemViewHolder;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0012\u0013\u0014B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/PcDeviceListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/taskskill/ui/PcDevicePanelItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "LoadingViewHolder", "PcDeviceViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcDeviceListAdapter extends ListAdapter<i, RecyclerView.ViewHolder> {
    public static final PcDeviceListAdapter$Companion$DIFF_CALLBACK$1 b = null;
    public final Function1<i, Unit> a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/PcDeviceListAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J(\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J(\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000bH\u0002¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/PcDeviceListAdapter$PcDeviceViewHolder;", "Lcom/larus/ui/CommonTaskItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/taskskill/ui/PcDeviceListAdapter;Landroid/view/View;)V", "bind", "", "item", "Lcom/larus/bmhome/taskskill/ui/PcDevicePanelItem;", "showDivider", "", "resetViews", "bindDevice", "Lcom/larus/bmhome/taskskill/ui/PcDevicePanelItem$Device;", "bindCloudComputer", "Lcom/larus/bmhome/taskskill/ui/PcDevicePanelItem$DoNotUseComputer;", "bindSelectedIcon", "visible", "bindStatusBadge", ShareType.TEXT, "", "backgroundRes", "", "dotRes", "textColorRes", "bindAction", "title", "desc", "iconRes", "enabled", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PcDeviceViewHolder extends CommonTaskItemViewHolder {
        public static final /* synthetic */ int l = 0;
        public final /* synthetic */ PcDeviceListAdapter k;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[PcDeviceUiState.values().length];
                r0[PcDeviceUiState.NEED_UPGRADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[PcDeviceUiState.CONTROL_DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public final void U3(boolean r8) {
            ((CommonTaskItemViewHolder) this).i.setImageResource(2131241706);
            ImageView r0 = ((CommonTaskItemViewHolder) this).i;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if (r1 == null) goto L11;
            r1.width = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
            r1.height = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
            r0.setLayoutParams(r1);
            ImageView r2 = ((CommonTaskItemViewHolder) this).i;
            if (r8 == false) goto L7;
            int r9 = 0;
        L8:
            r2.setVisibility(r9);
            return;
        L7:
            r9 = 8;
            goto L8
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }

        public PcDeviceViewHolder(PcDeviceListAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.k = r2;
            super(r3);
        }

        public final void T3(String r4, String r5, int r6) {
            ((CommonTaskItemViewHolder) this).a.setImageResource(r6);
            ((CommonTaskItemViewHolder) this).b.setText(r4);
            ((CommonTaskItemViewHolder) this).c.setText(r5);
            int r0 = 0;
            ((CommonTaskItemViewHolder) this).c.setTextSize(0, ((RecyclerView.ViewHolder) this).itemView.getResources().getDimension(v19.c.b(2130971186, null, 2131166742)));
            TextView r7 = ((CommonTaskItemViewHolder) this).c;
            if ((!StringsKt.isBlank(r5)) == true) goto L6;
            r0 = 8;
        L6:
            r7.setVisibility(r0);
            ((RecyclerView.ViewHolder) this).itemView.setEnabled(true);
            ((RecyclerView.ViewHolder) this).itemView.setAlpha(1.0f);
        }

        public final void V3(String r4, int r5, int r6, int r7) {
            ((CommonTaskItemViewHolder) this).e.setVisibility(0);
            ((CommonTaskItemViewHolder) this).e.setBackgroundResource(r5);
            View r8 = ((CommonTaskItemViewHolder) this).e;
            ViewGroup.LayoutParams r0 = r8.getLayoutParams();
            if (r0 == null) goto L11;
            r0.height = c7.b(22);
            r8.setLayoutParams(r0);
            ImageView r9 = ((CommonTaskItemViewHolder) this).f;
            ViewGroup.LayoutParams r1 = r9.getLayoutParams();
            if (r1 == null) goto L9;
            r1.width = c7.b(6);
            r1.height = c7.b(6);
            r9.setLayoutParams(r1);
            ((CommonTaskItemViewHolder) this).f.setImageResource(r6);
            ((CommonTaskItemViewHolder) this).g.setText(r4);
            ((CommonTaskItemViewHolder) this).g.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), r7));
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.taskskill.ui.PcDeviceListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        b = new PcDeviceListAdapter$Companion$DIFF_CALLBACK$1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PcDeviceListAdapter(Function1<? super i, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        super(b);
        this.a = r2;
    }

    public final int getItemViewType(int r2) {
        return Intrinsics.areEqual((i) getItem(r2), i.d.a) ? 1 : 0;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r26, int r27) {
        Intrinsics.checkNotNullParameter(r26, "holder");
        if ((r26 instanceof LoadingViewHolder) == false) goto L6;
        r26.itemView.setOnClickListener(null);
        return;
    L6:
        PcDeviceViewHolder r0 = (PcDeviceViewHolder) r26;
        final i r4 = (i) getItem(r27);
        boolean r6 = true;
        if (getItemCount() > 1) goto L9;
    L11:
        boolean r1 = false;
    L12:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "item");
        ((RecyclerView.ViewHolder) r0).itemView.setAlpha(1.0f);
        ((RecyclerView.ViewHolder) r0).itemView.setEnabled(true);
        ((CommonTaskItemViewHolder) r0).a.setImageTintList(ContextCompat.getColorStateList(((RecyclerView.ViewHolder) r0).itemView.getContext(), 2131103136));
        View r5 = ((CommonTaskItemViewHolder) r0).d;
        if (r1 == false) goto L15;
        int r2 = 0;
    L16:
        r5.setVisibility(r2);
        ((CommonTaskItemViewHolder) r0).e.setVisibility(8);
        ((CommonTaskItemViewHolder) r0).h.setVisibility(8);
        ((CommonTaskItemViewHolder) r0).i.setVisibility(8);
        ((CommonTaskItemViewHolder) r0).j.setVisibility(8);
        ((RecyclerView.ViewHolder) r0).itemView.setBackgroundResource(2131239803);
        if ((r4 instanceof i.b) == false) goto L85;
        i.b r3 = (i.b) r4;
        Context r12 = ((RecyclerView.ViewHolder) r0).itemView.getContext();
        PcDevice r13 = r3.a;
        String r14 = r13.d();
        if (r14 != null) goto L21;
    L25:
        r14 = r13.getDeviceId();
        if (r14 != null) goto L28;
        r14 = "";
    L28:
        AppCompatImageView r15 = ((CommonTaskItemViewHolder) r0).a;
        PcDeviceUiState r8 = bs8.g.b(r13);
        PcDeviceUiState r7 = PcDeviceUiState.OFFLINE;
        if (r8 != r7) goto L31;
    L33:
        r15.setImageResource(2131241516);
        ((CommonTaskItemViewHolder) r0).b.setText(r14);
        TextView r9 = ((CommonTaskItemViewHolder) r0).c;
        int r10 = PcDeviceViewHolder.a.a[bs8.g.b(r13).ordinal()];
        if (r10 != 1) goto L36;
        String r11 = r12.getString(2131901749);
    L52:
        r9.setText(r11);
        ((CommonTaskItemViewHolder) r0).c.setTextSize(0, ((RecyclerView.ViewHolder) r0).itemView.getResources().getDimension(v19.c.b(2130971163, null, 2131166696)));
        TextView r16 = ((CommonTaskItemViewHolder) r0).c;
        CharSequence r17 = r16.getText();
        if (r17 != null) goto L55;
    L58:
        boolean r18 = true;
    L60:
        if ((!r18) == false) goto L62;
        int r19 = 0;
    L63:
        r16.setVisibility(r19);
        if (bs8.g.b(r13) != r7) goto L67;
        r0.V3(r12.getString(2131901731), 2131243308, 2131243309, 2131103143);
    L71:
        View r20 = ((CommonTaskItemViewHolder) r0).j;
        if (r13.a == false) goto L74;
        int r21 = 0;
    L75:
        r20.setVisibility(r21);
        if (r13.a == false) goto L78;
    L82:
        r6 = false;
    L83:
        r0.U3(r6);
    L92:
        View r22 = ((RecyclerView.ViewHolder) r0).itemView;
        final PcDeviceListAdapter r23 = r0.k;
        r22.setOnClickListener(new e(r23, r4));
        return;
    L78:
        if (r3.b == false) goto L82;
        if (bs8.g.b(r13) != PcDeviceUiState.AUTHORIZED_AVAILABLE) goto L82;
    L74:
        r21 = 8;
        goto L75
    L67:
        if (bs8.g.b(r13) != PcDeviceUiState.AUTHORIZED_AVAILABLE) goto L69;
    L70:
        r0.V3(r12.getString(2131901732), 2131243310, 2131243311, 2131106552);
        goto L71
    L69:
        if (bs8.g.b(r13) != PcDeviceUiState.UNAUTHORIZED_AVAILABLE) goto L71;
    L62:
        r19 = 8;
        goto L63
    L55:
        if (StringsKt.isBlank(r17) == true) goto L58;
        r18 = false;
        goto L60
    L36:
        if (r10 == 2) goto L50;
        String[] r24 = new String[2];
        String r110 = r13.j();
        if (r110 != null) goto L40;
    L42:
        r110 = null;
    L43:
        r24[0] = r110;
        String r111 = r13.k();
        if (r111 != null) goto L46;
    L48:
        r111 = null;
    L49:
        r24[1] = r111;
        r11 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r24), " ", null, null, 0, null, null, 62, null);
        goto L52
    L46:
        if ((!StringsKt.isBlank(r111)) == false) goto L48;
    L40:
        if ((!StringsKt.isBlank(r110)) == false) goto L42;
    L50:
        r11 = r12.getString(2131901697);
        goto L52
    L31:
        if (bs8.g.b(r13) == PcDeviceUiState.NEED_UPGRADE) goto L33;
        bs8.g.b(r13);
        goto L33
    L21:
        if ((!StringsKt.isBlank(r14)) == true) goto L24;
        r14 = null;
    L24:
        if (r14 != null) goto L28;
    L85:
        if (Intrinsics.areEqual(r4, i.a.a) == false) goto L88;
        r0.T3(((RecyclerView.ViewHolder) r0).itemView.getContext().getString(2131901684), ((RecyclerView.ViewHolder) r0).itemView.getContext().getString(2131901685), 2131241517);
        goto L92
    L88:
        if ((r4 instanceof i.c) == false) goto L91;
        Context r25 = ((RecyclerView.ViewHolder) r0).itemView.getContext();
        r0.T3(r25.getString(2131901706), r25.getString(2131901748), 2131241269);
        r0.V3(r25.getString(2131901732), 2131243310, 2131243311, 2131106552);
        r0.U3(((i.c) r4).a);
        goto L92
    L91:
        if (Intrinsics.areEqual(r4, i.d.a) == true) goto L92;
        throw new NoWhenBranchMatchedException();
    L15:
        r2 = 8;
        goto L16
    L9:
        if (r27 == (getItemCount() - 1)) goto L11;
        r1 = true;
        goto L12
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 != 1) goto L6;
        return new LoadingViewHolder(r0.inflate(2131562570, r4, false));
    L6:
        return new PcDeviceViewHolder(this, r0.inflate(2131562684, r4, false));
    }
}
