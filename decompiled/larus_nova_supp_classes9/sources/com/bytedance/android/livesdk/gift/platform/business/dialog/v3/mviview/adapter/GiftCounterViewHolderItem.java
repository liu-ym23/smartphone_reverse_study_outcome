package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickCounterH5Icon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CounterData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollToPositionEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SmoothScrollEffect;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftPanelNitaViewInfo;
import com.bytedance.android.livesdk.gift.util.GiftImageLoader;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftCounterViewHolderItem extends BaseMVIListItem<CounterData, GiftAction> {
    public final RecyclerView l;
    public final HSImageView m;
    public final HSImageView n;
    public final TextView o;
    public final View p;
    public final int q;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GiftCounterViewHolderItem a;

        public a(GiftCounterViewHolderItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            GiftCounterViewHolderItem r4 = this.a;
            r4.o(new ClickCounterH5Icon(r4.p()));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ GiftCounterViewHolderItem a;

        public b(GiftCounterViewHolderItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            GiftCounterViewHolderItem r4 = this.a;
            r4.o(new ClickCounterH5Icon(r4.p()));
        }
    }

    public final void g() {
        this.n.setOnClickListener(new a(this));
        this.o.setOnClickListener(new b(this));
    }

    public final boolean d(com.bytedance.android.anya.a0 r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        if ((r4 instanceof ScrollToPositionEffect) == false) goto L14;
        ScrollToPositionEffect r5 = (ScrollToPositionEffect) r4;
        if (r5.getPagerPosition() == this.q) goto L7;
        return false;
    L7:
        if (r5.getCounterPosition() != p()) goto L28;
        LinearLayoutManager r0 = this.l.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L26;
        r0.scrollToPositionWithOffset(r5.getPosition(), com.bytedance.android.live.revenue.common.i.b(2));
        return true;
    L26:
        return true;
    L28:
        return false;
    L14:
        if ((r4 instanceof SmoothScrollEffect) == false) goto L29;
        SmoothScrollEffect r6 = (SmoothScrollEffect) r4;
        if (r6.getPagerPosition() == this.q) goto L18;
        return false;
    L18:
        if (r6.getCounterPosition() == p()) goto L20;
        return false;
    L20:
        if (r6.getTopicPagerPosition() != (-1)) goto L32;
        RecyclerView.LayoutManager r1 = this.l.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L33;
        r1.smoothScrollToPosition(this.l, new RecyclerView.State(), r6.getPosition());
        return false;
    L33:
        return false;
    L32:
        return false;
    L29:
        return false;
    }

    public final void k(com.bytedance.android.anya.dsl.a<CounterData, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$registerListAdapters");
        com.bytedance.android.anya.dsl.a.b(r4, this, GiftCounterViewHolderItem$registerListAdapters$1.INSTANCE, new GiftCounterViewHolderItem$registerListAdapters$2(this), this.l);
    }

    public GiftCounterViewHolderItem(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (com.bytedance.android.livesdk.gift.platform.core.a0.e().L3() == false) goto L9;
        GiftPanelNitaViewInfo r0 = GiftPanelNitaViewInfo.TTLIVE_BASE_COUNTER_VIEW_ITEM;
        int r2 = r0.getResId();
        String r1 = r0.getTag();
        Context r3 = r5.getContext();
        if (r3 == null) goto L8;
        View r7 = NitaInflateUtil.a(r2, r1, (Activity) r3, r5, false);
    L10:
        super(r7, new CounterData());
        this.q = r6;
        RecyclerView r8 = ((BaseMVIListItem) this).j.findViewById(2131373779);
        r8.setLayoutManager(new SSGridLayoutManager(r8.getContext(), 4, 1));
        r8.setItemAnimator(null);
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        r8.addItemDecoration(new l(com.bytedance.android.live.revenue.common.i.b(0)));
        Unit r9 = Unit.INSTANCE;
        this.l = r8;
        this.m = ((BaseMVIListItem) this).j.findViewById(2131368053);
        this.n = ((BaseMVIListItem) this).j.findViewById(2131374174);
        this.o = (TextView) ((BaseMVIListItem) this).j.findViewById(2131374175);
        this.p = ((BaseMVIListItem) this).j.findViewById(2131368049);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L9:
        r7 = LayoutInflater.from(r5.getContext()).inflate(2131565221, r5, false);
        goto L10
    }

    public final void b(com.bytedance.android.anya.k r10, MVIState r11) {
        CounterData r13 = (CounterData) r11;
        Intrinsics.checkNotNullParameter(r10, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r13, "state");
        r0<CounterData, py.k> r0 = r13.getCounterHeaderImg();
        Object r1 = r10.c.a(r0);
        if (r1 == null) goto L5;
        r10.b.a.invoke(r0);
        q(this.m, (py.k) r1, s1.j(2131168706), s1.j(2131168705));
    L5:
        r0<CounterData, vz1.c> r2 = r13.getH5EntranceModel();
        Object r3 = r10.c.a(r2);
        if (r3 == null) goto L33;
        r10.b.a.invoke(r2);
        vz1.c r4 = (vz1.c) r3;
        String r5 = r4.a;
        if (r5 != null) goto L10;
    L13:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        goto L33
    L17:
        String r7 = r4.b;
        if (r7 != null) goto L20;
    L23:
        boolean r8 = true;
    L24:
        if (r8 == false) goto L26;
        this.o.setVisibility(8);
    L27:
        py.k r9 = r4.c;
        if (r9 != null) goto L30;
    L32:
        this.n.setVisibility(8);
        goto L33
    L30:
        if (r9.isValid() != true) goto L32;
        this.n.setVisibility(0);
        q(this.n, r4.c, s1.j(2131168704), s1.j(2131168703));
        goto L33
    L26:
        this.o.setVisibility(0);
        this.o.setText(r4.b);
        goto L27
    L20:
        if (r7.length() == 0) goto L23;
        r8 = false;
        goto L24
    L10:
        if (r5.length() == 0) goto L13;
        r6 = false;
    L33:
        t0<CounterData, ItemListData> r14 = r13.getItemDataList();
        Object r15 = r10.c.a(r14);
        if (r15 == null) goto L38;
        r10.b.a.invoke(r14);
        if (((s0) r15).isEmpty() == true) goto L38;
        this.l.setVisibility(0);
    L38:
        r0<CounterData, vz1.b> r16 = r13.getBgColorModel();
        Object r17 = r10.c.a(r16);
        if (r17 == null) goto L61;
        r10.b.a.invoke(r16);
        vz1.b r18 = (vz1.b) r17;
        int[] r19 = r18.a;
        if (r19.length < 3) goto L62;
        int[] r110 = r18.b;
        if (r110.length >= 3) goto L45;
        return;
    L45:
        if (r19.length < 4) goto L47;
        boolean r20 = true;
    L49:
        if (r110.length < 4) goto L51;
        boolean r111 = true;
    L53:
        if (r20 == false) goto L55;
        int r112 = Color.argb(r19[3], Color.red(r19[0]), Color.green(r18.a[1]), Color.blue(r18.a[2]));
    L56:
        if (r111 == false) goto L58;
        int[] r113 = r18.b;
        int r114 = Color.argb(r113[3], r113[0], r113[1], r113[2]);
    L59:
        GradientDrawable r21 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r112, r114});
        r21.setGradientType(0);
        r21.setCornerRadius(com.bytedance.android.live.revenue.common.i.a(6));
        this.p.setBackground(r21);
        return;
    L58:
        int[] r115 = r18.b;
        r114 = Color.argb(255, r115[0], r115[1], r115[2]);
        goto L59
    L55:
        r112 = Color.argb(255, r19[0], r19[1], r19[2]);
        goto L56
    L51:
        r111 = false;
        goto L53
    L47:
        r20 = false;
        goto L49
    L62:
        return;
    }

    public static void q(HSImageView r13, py.k r14, int r15, int r16) {
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.l.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[10])).booleanValue() == false) goto L5;
        GiftImageLoader.b(GiftImageLoader.k, r13, r14, 0, r15, r16, null, null, null, null, 8140);
        return;
    L5:
        ImageLoader.bindImage(r13, r14);
    }
}
