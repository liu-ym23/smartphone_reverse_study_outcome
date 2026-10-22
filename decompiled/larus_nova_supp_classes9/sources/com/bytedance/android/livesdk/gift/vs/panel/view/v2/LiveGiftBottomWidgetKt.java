package com.bytedance.android.livesdk.gift.vs.panel.view.v2;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.j0;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.config.j;
import com.bytedance.android.livesdk.gift.platform.business.config.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.GiftTabTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.manager.PropManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftListViewModelNew;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/panel/view/v2/LiveGiftBottomWidgetKt;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroid/view/View$OnClickListener;", "a", "b", "c", "d", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftBottomWidgetKt extends LiveRecyclableWidget implements View.OnClickListener {
    public static final /* synthetic */ int t = 0;
    public RecyclerView a;
    public c b;
    public TextView c;
    public HSImageView d;
    public View e;
    public View f;
    public View g;
    public TextView h;
    public TextView i;
    public final List<b> j;
    public int k;
    public boolean l;
    public boolean m;
    public final CompositeDisposable n;
    public zv0.b o;
    public a22.a p;
    public boolean q;
    public boolean r;
    public final GiftViewModelManager s;

    public static final class a {
    }

    public static final class b {
        public String a;
        public int b;
        public boolean c;
        public boolean d;

        public b() {
        }
    }

    public final class c extends RecyclerView.Adapter<d> {
        public final /* synthetic */ LiveGiftBottomWidgetKt a;

        public final int getItemCount() {
            return ((ArrayList) this.a.j).size();
        }

        public c(LiveGiftBottomWidgetKt r1) {
            this.a = r1;
        }

        public final int getItemViewType(int r3) {
            if (r3 != 0) goto L5;
            return 0;
        L5:
            if (r3 != (getItemCount() - 1)) goto L7;
            return 2;
        L7:
            return 1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
            d r8 = (d) r6;
            Intrinsics.checkNotNullParameter(r8, "liveGiftTabViewHolder");
            b r9 = (b) ListProtector.get(this.a.j, r7);
            if (r9 != null) goto L5;
            r8.getClass();
            return;
        L5:
            r8.a.setGravity(48);
            r8.a.setText(r9.a);
            Pair r0 = (Pair) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_TAB_TEXT_COLOR, new Pair(2131107552, 2131107551));
            GiftTabTextView r1 = r8.a;
            Resources r2 = ((Widget) r8.b).context.getResources();
            if (r9.d == false) goto L8;
            Object r3 = r0.getFirst();
        L9:
            r1.setTextColor(r2.getColor(((Number) r3).intValue()));
            GiftTabTextView r4 = r8.a;
            boolean r5 = r9.c;
            View r10 = r4.c;
            int r11 = 0;
            if (r10 == null) goto L15;
            if (r5 == false) goto L13;
            int r13 = 0;
        L14:
            r10.setVisibility(r13);
            goto L15
        L13:
            r13 = 8;
        L15:
            r8.a.setTextSize(14.0f);
            GiftTabTextView r14 = r8.a;
            Map<Integer, Integer> r15 = tz1.a.a;
            r14.setIsNeedSort(Boolean.valueOf(tz1.a.d(r9.b)));
            GiftTabTextView r16 = r8.a;
            if (r9.d == false) goto L18;
            r11 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.p(r9.b);
        L18:
            r16.setStatus(r11);
            ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new com.bytedance.android.livesdk.gift.vs.panel.view.v2.a(r8, r9));
            if (r9.c == false) goto L21;
            c0 r17 = c0.a;
            c0.f(r9.b);
        L21:
            r3.d(((RecyclerView.ViewHolder) r8).itemView, r9.a, r9.d, true);
            return;
        L8:
            r3 = r0.getSecond();
            goto L9
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "viewGroup");
            View r13 = LayoutInflater.from(((Widget) this.a).context).inflate(2131566118, null);
            View r0 = r13.findViewById(2131373786);
            if (r0 == null) goto L5;
            ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        L7:
            if ((r2 instanceof ConstraintLayout.LayoutParams) == true) goto L9;
            r2 = null;
        L9:
            ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r2;
            int r4 = 0;
            if (r3 == null) goto L30;
            boolean r5 = true;
            if (r11 == 0) goto L19;
            if (r11 != 1) goto L15;
            y2(r3, s1.f(18.0f), s1.f(16.0f));
        L29:
            r0.setLayoutParams(r3);
            goto L30
        L15:
            if (r11 != 2) goto L29;
            y2(r3, s1.f(50.0f), s1.f(25.0f));
            goto L29
        L19:
            int r14 = s1.f(16.0f);
            int r7 = s1.f(12.0f);
            GiftViewModelManager r8 = this.a.s;
            if (r8 != null) goto L22;
        L24:
            r5 = false;
        L26:
            if (u.l(r5, null) == false) goto L28;
            r14 = r7;
        L28:
            ((ViewGroup.MarginLayoutParams) r3).leftMargin = r14;
            r3.setMarginStart(r14);
            y2(r3, s1.f(18.0f), s1.f(16.0f));
            goto L29
        L22:
            if (r8.getIsVertical() != true) goto L24;
        L30:
            LiveGiftBottomWidgetKt r15 = this.a;
            if (r15.q == true) goto L33;
        L35:
            r13.setVisibility(r4);
            return new d(this.a, r13);
        L33:
            if (r15.r == true) goto L35;
            r4 = 8;
            goto L35
        L5:
            r2 = null;
            goto L7
        }

        public final void y2(ConstraintLayout.LayoutParams r3, int r4, int r5) {
            GiftViewModelManager r0 = this.a.s;
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.getIsVertical() != true) goto L7;
        L9:
            if (u.l(r1, null) == false) goto L11;
            r4 = r5;
        L11:
            ((ViewGroup.MarginLayoutParams) r3).rightMargin = r4;
            r3.setMarginEnd(r4);
            return;
        L7:
            r1 = false;
            goto L9
        }
    }

    public final class d extends RecyclerView.ViewHolder {
        public final GiftTabTextView a;
        public final /* synthetic */ LiveGiftBottomWidgetKt b;

        public d(LiveGiftBottomWidgetKt r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.b = r2;
            super(r3);
            this.a = (GiftTabTextView) r3.findViewById(2131373786);
        }
    }

    public static final class e implements View.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    static {
    }

    public final void wq() {
        TextView r0 = this.c;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L7:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r1 = null;
    L9:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        GiftViewModelManager r3 = this.s;
        int r4 = 0;
        if (r3 == null) goto L14;
        boolean r5 = true;
        if (r3.getIsVertical() != true) goto L14;
    L15:
        boolean r6 = u.l(r5, null);
        if (r6 == false) goto L18;
        r4 = 8;
    L18:
        if (r6 == false) goto L20;
        float r7 = 8.0f;
    L21:
        int r8 = s1.f(r7);
        View r9 = this.f;
        if (r9 == null) goto L24;
        r9.setVisibility(r4);
    L24:
        if (r2 == null) goto L26;
        r2.rightMargin = r8;
    L26:
        TextView r10 = this.c;
        if (r10 == null) goto L30;
        r10.setLayoutParams(r2);
        return;
    L30:
        return;
    L20:
        r7 = 20.0f;
    L14:
        r5 = false;
        goto L15
    L5:
        r1 = null;
        goto L7
    }

    public final void zq() {
        IRechargeService r0 = k.f(IRechargeService.class);
        if (r0 == null) goto L7;
        zv0.f r1 = r0.rechargeCenter();
        if (r1 == null) goto L7;
        long r3 = r1.getAvailableDiamonds();
    L8:
        boolean r2 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin();
        if (((Boolean) nz1.a.n.getValue(null, nz1.a.a[12])).booleanValue() == true) goto L11;
    L13:
        boolean r5 = false;
    L15:
        if (r3 <= 0) goto L32;
        if (r2 == false) goto L32;
        if (r5 == true) goto L32;
        TextView r4 = this.c;
        if (r4 == null) goto L22;
        r4.setText(j0.a(r3));
    L22:
        TextView r6 = this.c;
        if (r6 == null) goto L25;
        r6.setTextColor(((Widget) this).context.getResources().getColor(2131107549));
    L25:
        TextView r7 = this.c;
        if (r7 == null) goto L28;
        r7.setTextSize(1, 16.0f);
    L28:
        HSImageView r8 = this.d;
        if (r8 == null) goto L31;
        r8.setVisibility(0);
    L31:
        wq();
        j r9 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r10 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        ImageUtil.loadImage(this.d, ((DiamondConfig) r9.c(r10, DiamondConfig.a.a())).a, 0);
        return;
    L32:
        TextView r11 = this.c;
        if (r11 == null) goto L35;
        r11.setText(e4.a());
    L35:
        int r13 = ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_BOTTOM_RECHARGE_COLOR, 2131107550)).intValue();
        TextView r14 = this.c;
        if (r14 == null) goto L38;
        r14.setTextColor(((Widget) this).context.getResources().getColor(r13));
    L38:
        TextView r15 = this.c;
        if (r15 == null) goto L41;
        r15.setTextSize(1, 14.0f);
    L41:
        HSImageView r16 = this.d;
        if (r16 == null) goto L44;
        r16.setVisibility(8);
    L44:
        wq();
        return;
    L11:
        if (u.p() == true) goto L13;
        r5 = true;
    L7:
        r3 = 0;
        goto L8
    }

    public final int getLayoutId() {
        boolean r1 = false;
        if (((n) com.bytedance.android.livesdk.gift.util.b.a().d(n.class)).f() == 1) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
    L26:
        return 2131565224;
    L10:
        if (((Widget) this).dataCenter != null) goto L12;
    L21:
        if (r1 == true) goto L26;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L26;
        return 2131565223;
    L12:
        if (x.d() == false) goto L21;
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L21;
        m<Boolean> r3 = r2.isVSPadUseVerticalStyle();
        if (r3 == null) goto L21;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L21;
        r1 = true;
        goto L21
    L5:
        if (((n) com.bytedance.android.livesdk.gift.util.b.a().d(n.class)).e() != 1) goto L7;
        r0 = true;
        goto L8
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        k.n(IRechargeService.class).rechargeCenter().sync(com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL);
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.gift.util.b.e(this);
        zv0.b r0 = this.o;
        if (r0 == null) goto L5;
        r0.onUnload();
    L5:
        this.n.clear();
    }

    public final void yq() {
        GiftListViewModelNew r0 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.l();
        if (r0 == null) goto L5;
        List<w1> r1 = r0.g();
    L6:
        w1 r2 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.g();
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = ay1.b.E;
        KProperty[] r4 = ay1.b.a;
        Integer r6 = null;
        boolean r7 = true;
        int r8 = 0;
        if (((Boolean) r3.getValue(null, r4[35])).booleanValue() == true) goto L18;
        GiftViewModelManager r5 = this.s;
        if (r5 == null) goto L18;
        if (r5.getSendToAnchor(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r()) == true) goto L18;
        if (r2 == null) goto L18;
        if (r2.getPageType() != 5) goto L18;
        if ((!com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.c().isEmpty()) == false) goto L18;
        ToastUtil.a(2131919970, 0);
        r3.setValue(null, r4[35], Boolean.TRUE);
    L18:
        List<w1> r9 = r1;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L20:
        if (r11.hasNext() == false) goto L25;
        Object r13 = r11.next();
        if (((w1) r13).getDisplay() == false) goto L20;
        r10.add(r13);
        goto L20
    L25:
        if (r10.size() <= 1) goto L27;
        boolean r14 = true;
    L28:
        this.r = r14;
        if (PadConfigUtils.c() == false) goto L31;
    L34:
        boolean r15 = true;
    L36:
        if (e5.n() == false) goto L38;
    L41:
        boolean r16 = true;
    L42:
        GiftViewModelManager r17 = this.s;
        if (r17 != null) goto L45;
    L46:
        if (r15 == false) goto L75;
    L47:
        if (r15 == false) goto L61;
        if (r16 == false) goto L50;
        int r18 = s1.f(7.0f);
    L51:
        ConstraintLayout r19 = ((Widget) this).contentView.findViewById(2131367751);
        if (r19 == null) goto L54;
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
    L56:
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == true) goto L58;
        r110 = null;
    L58:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r111 == null) goto L61;
        r111.topMargin = r18;
        goto L61
    L54:
        r110 = null;
        goto L56
    L50:
        r18 = s1.f(5.0f);
    L61:
        if (r15 == true) goto L64;
        if (r16 == true) goto L64;
        int r20 = s1.f(10.0f);
    L65:
        RecyclerView r21 = this.a;
        if (r21 == null) goto L68;
        ViewGroup.LayoutParams r23 = r21.getLayoutParams();
    L70:
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == true) goto L72;
        r23 = null;
    L72:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        if (r24 == null) goto L75;
        r24.bottomMargin = r20;
        goto L75
    L68:
        r23 = null;
    L64:
        r20 = s1.f(6.0f);
    L75:
        ((ArrayList) this.j).clear();
        if (Lists.isEmpty(r1) == false) goto L78;
        b r25 = new b();
        r25.b = 0;
        r25.d = true;
        r25.a = ((Widget) this).context.getString(2131919136);
        ((ArrayList) this.j).add(r25);
    L108:
        c r26 = this.b;
        if (r26 == null) goto L111;
        r26.notifyDataSetChanged();
    L111:
        zq();
        boolean r27 = u.i(r2);
        int r28 = 8;
        if (r27 == false) goto L114;
    L121:
        View r29 = this.g;
        if (r29 == null) goto L124;
        r29.setVisibility(8);
    L124:
        a22.a r30 = this.p;
        if (r30 == null) goto L134;
        ArrayList r31 = new ArrayList();
        Iterator<T> r33 = r9.iterator();
    L128:
        if (r33.hasNext() == false) goto L132;
        Object r34 = r33.next();
        if (((w1) r34).getDisplay() == false) goto L128;
        r31.add(r34);
        goto L128
    L132:
        r30.X10(r31);
    L134:
        if (this.q == false) goto L184;
        RecyclerView r35 = this.a;
        if (r35 == null) goto L155;
        Integer r36 = Integer.valueOf(r35.getChildCount());
        if (r36.intValue() > 0) goto L142;
        r7 = false;
    L142:
        if (r7 == false) goto L144;
        r6 = r36;
    L144:
        if (r6 == null) goto L183;
        int r37 = r6.intValue();
        if (this.r == false) goto L148;
        r28 = 0;
    L148:
        if (r8 >= r37) goto L185;
        RecyclerView r38 = this.a;
        if (r38 == null) goto L154;
        View r39 = r38.getChildAt(r8);
        if (r39 == null) goto L154;
        r39.setVisibility(r28);
    L154:
        r8 = r8 + 1;
        goto L148
    L185:
        return;
    L183:
        return;
    L155:
        return;
    L184:
        return;
    L114:
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L121;
        if (u.p() == true) goto L121;
        View r40 = this.g;
        if (r40 == null) goto L124;
        r40.setVisibility(0);
        goto L124
    L78:
        if (r2 != null) goto L80;
        w1 r41 = (w1) ListProtector.get(r1, 0);
    L81:
        this.k = r41.getPageType();
        Iterator<w1> r43 = r1.iterator();
    L83:
        if (r43.hasNext() == false) goto L108;
        w1 r44 = r43.next();
        if (r44.getDisplay() == false) goto L83;
        b r45 = new b();
        r45.a = r44.getPageName();
        if (r44.getPageType() != r41.getPageType()) goto L90;
        boolean r112 = true;
    L91:
        r45.d = r112;
        r45.b = r44.getPageType();
        if (this.l == true) goto L94;
    L107:
        ((ArrayList) this.j).add(r45);
        goto L83
    L94:
        if (this.k != 5) goto L105;
        PropManager r46 = PropManager.b();
        r46.getClass();
        HashSet<Long> r113 = ay1.b.t();
        Iterator r47 = ((ArrayList) r46.a).iterator();
    L97:
        if (r47.hasNext() == false) goto L103;
        l2 r114 = (l2) r47.next();
        if (r114.getReddotTip() == false) goto L97;
        if (r113.contains(Long.valueOf(r114.getId())) == true) goto L97;
        r113.add(Long.valueOf(r114.getId()));
        goto L97
    L103:
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r115 = ay1.b.M;
        KProperty[] r116 = ay1.b.a;
        r115.setValue(null, r116[46], r113);
        ay1.b.C(false);
        String r117 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getCastSecUid();
        HashMap<String, String> r118 = ay1.b.s();
        r118.put(r117, String.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        ay1.b.Y.setValue(null, r116[62], r118);
        this.l = false;
        goto L107
    L105:
        if (r44.getPageType() != 5) goto L107;
        r45.c = true;
        goto L107
    L90:
        r112 = false;
        goto L91
    L80:
        r41 = r2;
        goto L81
    L45:
        if (r17.getIsVertical() == true) goto L47;
    L38:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L41;
        r16 = false;
        goto L42
    L31:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L34;
        r15 = false;
        goto L36
    L27:
        r14 = false;
        goto L28
    L5:
        r1 = new ArrayList();
        goto L6
    }

    public LiveGiftBottomWidgetKt(GiftViewModelManager r1) {
        this.s = r1;
        this.j = new ArrayList();
        this.n = new CompositeDisposable();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        if (r3.getId() != 2131365496) goto L6;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.m(null, true));
        h.X();
        return;
    }

    public final void onInit(Object[] r4) {
        this.a = findViewById(2131388038);
        this.c = (TextView) findViewById(2131383900);
        this.d = findViewById(2131367088);
        this.e = findViewById(2131365496);
        RecyclerView r5 = this.a;
        if (r5 == null) goto L5;
        r5.setHorizontalFadingEdgeEnabled(true);
    L5:
        RecyclerView r6 = this.a;
        if (r6 == null) goto L8;
        r6.setFadingEdgeLength(s1.f(40.0f));
    L8:
        View r7 = findViewById(2131387207);
        if (r7 == null) goto L11;
        r7.setVisibility(8);
    L11:
        View r8 = findViewById(2131371622);
        if (r8 == null) goto L14;
        r8.setVisibility(8);
    L14:
        this.f = findViewById(2131383876);
        this.g = findViewById(2131364417);
        TextView r9 = (TextView) findViewById(2131375210);
        this.h = r9;
        if (r9 == null) goto L17;
        r9.setText(s1.C(2131917145, new Object[]{com.bytedance.android.livesdk.utils.r3.c()}));
    L17:
        this.i = (TextView) findViewById(2131375211);
    }

    public final void onLoad(Object[] r7) {
        this.b = new c(this);
        RecyclerView r8 = this.a;
        boolean r0 = false;
        if (r8 == null) goto L5;
        r8.setItemViewCacheSize(16);
        r8.setAdapter(this.b);
        r8.setLayoutManager(new LinearLayoutManager(((Widget) this).context, 0, false));
    L5:
        View r9 = ((Widget) this).contentView;
        if (r9 == null) goto L9;
        r9.setOnClickListener(e.a);
    L9:
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L13;
        View r10 = this.g;
        if (r10 == null) goto L13;
        r10.setVisibility(8);
    L13:
        zq();
        com.bytedance.android.livesdk.gift.util.b.d("GiftListViewModel", this, new com.bytedance.android.livesdk.gift.vs.panel.view.v2.d(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftTabViewModel", this, new com.bytedance.android.livesdk.gift.vs.panel.view.v2.d(this), true);
        com.bytedance.android.livesdk.gift.util.b.d("GiftDialogViewModel", this, new com.bytedance.android.livesdk.gift.vs.panel.view.v2.d(this), true);
        this.n.add(k.n(IRechargeService.class).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.vs.panel.view.v2.e(this), f.a));
        View r11 = this.e;
        if (r11 == null) goto L16;
        r11.setOnClickListener(this);
    L16:
        isScreenPortrait();
        int r13 = com.bytedance.android.livesdk.utils.landscape.d.a;
        RecyclerView r14 = this.a;
        if (r14 == null) goto L20;
        r14.addOnScrollListener(new AnonymousClass3(this));
    L20:
        if (ay1.b.v() == false) goto L23;
        this.l = true;
    L23:
        if (u.p() == false) goto L28;
        View r15 = this.g;
        if (r15 == null) goto L28;
        r15.setVisibility(8);
    L28:
        if (this.h != null) goto L30;
        return;
    L30:
        if (this.i == null) goto L43;
        GiftViewModelManager r16 = this.s;
        if (r16 == null) goto L37;
        if (r16.getIsVertical() != true) goto L37;
        r0 = true;
    L37:
        if (u.k(r0) == 2) goto L39;
        return;
    L39:
        if (xq(null) == false) goto L45;
        this.n.add(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).pl().subscribe(new com.bytedance.android.livesdk.gift.vs.panel.view.v2.b(this), com.bytedance.android.livesdk.gift.vs.panel.view.v2.c.a));
        return;
    L45:
        return;
    }

    public final boolean xq(ds2.d r13) {
        View r0 = this.e;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L10;
        r1 = r2;
    L10:
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r1;
        GiftViewModelManager r4 = this.s;
        boolean r5 = false;
        if (r4 != null) goto L13;
    L15:
        boolean r6 = false;
    L17:
        if (u.l(r6, r13) == false) goto L26;
        ArrayList r7 = new ArrayList();
        r7.add(this.h);
        r7.add(this.i);
        zv0.b r14 = k.n(IRechargeService.class).getCashExchangeDelegate(this.h, r7, this.i, new LiveGiftBottomWidgetKt$adjustContainerHeight$1(this), 2, ((Widget) this).context);
        this.o = r14;
        if (r14 == null) goto L21;
        r14.setDataCenter(((Widget) this).dataCenter);
    L21:
        TextView r15 = this.h;
        if (r15 == null) goto L24;
        r15.setVisibility(0);
    L24:
        if (r3 == null) goto L35;
        ((ViewGroup.MarginLayoutParams) r3).rightMargin = s1.f(12.0f);
    L35:
        View r16 = this.e;
        if (r16 == null) goto L38;
        r16.setLayoutParams(r3);
    L38:
        wq();
        return r5;
    L26:
        TextView r17 = this.h;
        if (r17 == null) goto L29;
        r17.setVisibility(8);
    L29:
        TextView r18 = this.i;
        if (r18 == null) goto L32;
        r18.setVisibility(8);
    L32:
        if (r3 == null) goto L34;
        ((ViewGroup.MarginLayoutParams) r3).rightMargin = s1.f(16.0f);
    L34:
        r5 = true;
        goto L35
    L13:
        if (r4.getIsVertical() != true) goto L15;
        r6 = true;
        goto L17
    L5:
        r2 = null;
        goto L7
    }
}
