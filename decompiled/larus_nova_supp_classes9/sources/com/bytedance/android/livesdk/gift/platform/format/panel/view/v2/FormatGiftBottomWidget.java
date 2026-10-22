package com.bytedance.android.livesdk.gift.platform.format.panel.view.v2;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.j0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.GiftTabTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftListViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftPanelDialogViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftTabViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.scope.m;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/format/panel/view/v2/FormatGiftBottomWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroid/view/View$OnClickListener;", "a", "b", "c", "d", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftBottomWidget extends LiveRecyclableWidget implements View.OnClickListener {
    public static final /* synthetic */ int o = 0;
    public RecyclerView a;
    public c b;
    public TextView c;
    public HSImageView d;
    public View e;
    public View f;
    public View g;
    public View h;
    public TextView i;
    public TextView j;
    public final List<b> k;
    public final CompositeDisposable l;
    public zv0.b m;
    public final GiftViewModelManager n;

    public static final class a {
    }

    public static final class b {
        public String a;
        public int b;
        public boolean c;

        public b() {
        }
    }

    public final class c extends RecyclerView.Adapter<d> {
        public final /* synthetic */ FormatGiftBottomWidget a;

        public final int getItemCount() {
            return ((ArrayList) this.a.k).size();
        }

        public c(FormatGiftBottomWidget r1) {
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
            b r9 = (b) ListProtector.get(this.a.k, r7);
            if (r9 != null) goto L5;
            r8.getClass();
            return;
        L5:
            r8.a.setGravity(48);
            r8.a.setText(r9.a);
            Pair r0 = (Pair) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_TAB_TEXT_COLOR, new Pair(2131107552, 2131100641));
            GiftTabTextView r1 = r8.a;
            Resources r2 = ((Widget) r8.b).context.getResources();
            if (r9.c == false) goto L8;
            Object r3 = r0.getFirst();
        L9:
            r1.setTextColor(r2.getColor(((Number) r3).intValue()));
            View r4 = r8.a.c;
            if (r4 == null) goto L12;
            r4.setVisibility(8);
        L12:
            r8.a.setTextSize(14.0f);
            GiftTabTextView r5 = r8.a;
            Map<Integer, Integer> r10 = tz1.a.a;
            r5.setIsNeedSort(Boolean.valueOf(tz1.a.d(r9.b)));
            GiftTabTextView r11 = r8.a;
            if (r9.c == false) goto L15;
            int r13 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.k(r9.b);
        L16:
            r11.setStatus(r13);
            ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.a(r8, r9));
            return;
        L15:
            r13 = 0;
            goto L16
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
            GiftViewModelManager r8 = this.a.n;
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
            FormatGiftBottomWidget r15 = this.a;
            int r1 = FormatGiftBottomWidget.o;
            r15.getClass();
            r13.setVisibility(0);
            return new d(this.a, r13);
        L5:
            r2 = null;
            goto L7
        }

        public final void y2(ConstraintLayout.LayoutParams r3, int r4, int r5) {
            GiftViewModelManager r0 = this.a.n;
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
        public final /* synthetic */ FormatGiftBottomWidget b;

        public d(FormatGiftBottomWidget r2, View r3) {
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

    public static final class f<T> implements Observer {
        public final /* synthetic */ FormatGiftBottomWidget a;

        public f(FormatGiftBottomWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            FormatGiftBottomWidget r0 = this.a;
            FormatGiftBottomWidget.wq(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ FormatGiftBottomWidget a;

        public g(FormatGiftBottomWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            FormatGiftBottomWidget r0 = this.a;
            FormatGiftBottomWidget.wq(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ FormatGiftBottomWidget a;

        public h(FormatGiftBottomWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            FormatGiftBottomWidget r0 = this.a;
            FormatGiftBottomWidget.wq(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    public static final class i implements View.OnClickListener {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566017;
    }

    public final void zq() {
        IRechargeService r0 = k.f(IRechargeService.class);
        if (r0 == null) goto L7;
        zv0.f r1 = r0.rechargeCenter();
        if (r1 == null) goto L7;
        long r3 = r1.getAvailableDiamonds();
    L8:
        boolean r2 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin();
        View r5 = this.f;
        if (r5 == null) goto L11;
        r5.setVisibility(8);
    L11:
        HSImageView r6 = this.d;
        if (r6 == null) goto L14;
        r6.setVisibility(0);
    L14:
        a1.m(this.d, 2131250634);
        if (r3 <= 0) goto L27;
        if (r2 == false) goto L27;
        TextView r4 = this.c;
        if (r4 == null) goto L21;
        r4.setText(j0.a(r3));
    L21:
        TextView r7 = this.c;
        if (r7 == null) goto L24;
        r7.setTextColor(((Widget) this).context.getResources().getColor(2131107496));
    L24:
        TextView r8 = this.c;
        if (r8 == null) goto L37;
        r8.setTextSize(1, 16.0f);
        return;
    L37:
        return;
    L27:
        TextView r9 = this.c;
        if (r9 == null) goto L30;
        r9.setText(e4.a());
    L30:
        TextView r10 = this.c;
        if (r10 == null) goto L33;
        r10.setTextColor(((Widget) this).context.getResources().getColor(2131107496));
    L33:
        TextView r11 = this.c;
        if (r11 == null) goto L39;
        r11.setTextSize(1, 14.0f);
        return;
    L39:
        return;
    L7:
        r3 = 0;
        goto L8
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        k.n(IRechargeService.class).rechargeCenter().sync(com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL);
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.gift.util.b.e(this);
        zv0.b r0 = this.m;
        if (r0 == null) goto L5;
        r0.onUnload();
    L5:
        this.l.clear();
    }

    public final void yq() {
        FormatGiftListViewModel r0 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.h();
        if (r0 == null) goto L5;
        List<w1> r1 = r0.h();
    L6:
        w1 r2 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.d();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        if (((w1) r5).getDisplay() == false) goto L8;
        r3.add(r5);
        goto L8
    L12:
        r3.size();
        if (PadConfigUtils.c() == false) goto L15;
    L18:
        boolean r6 = true;
    L20:
        if (e5.n() == false) goto L22;
    L25:
        boolean r7 = true;
    L26:
        GiftViewModelManager r8 = this.n;
        if (r8 != null) goto L29;
    L30:
        if (r6 == false) goto L61;
    L31:
        ViewGroup.LayoutParams r9 = null;
        if (r6 == false) goto L46;
        if (r7 == false) goto L35;
        int r10 = s1.f(7.0f);
    L36:
        ConstraintLayout r11 = ((Widget) this).contentView.findViewById(2131367751);
        if (r11 == null) goto L39;
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
    L41:
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L43;
        r13 = null;
    L43:
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        if (r14 == null) goto L46;
        r14.topMargin = r10;
        goto L46
    L39:
        r13 = null;
        goto L41
    L35:
        r10 = s1.f(5.0f);
    L46:
        if (r6 == true) goto L49;
        if (r7 == true) goto L49;
        int r15 = s1.f(10.0f);
    L50:
        RecyclerView r16 = this.a;
        if (r16 == null) goto L53;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
    L55:
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L58;
        r9 = r17;
    L58:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r9;
        if (r18 == null) goto L61;
        r18.bottomMargin = r15;
        goto L61
    L53:
        r17 = null;
    L49:
        r15 = s1.f(6.0f);
    L61:
        ((ArrayList) this.k).clear();
        if (Lists.isEmpty(r1) == false) goto L64;
        b r19 = new b();
        r19.b = 0;
        r19.c = true;
        r19.a = ((Widget) this).context.getString(2131919136);
        ((ArrayList) this.k).add(r19);
    L77:
        c r20 = this.b;
        if (r20 == null) goto L80;
        r20.notifyDataSetChanged();
    L80:
        zq();
        View r21 = this.g;
        if (r21 == null) goto L94;
        r21.setVisibility(8);
        return;
    L94:
        return;
    L64:
        if (r2 != null) goto L66;
        r2 = (w1) ListProtector.get(r1, 0);
    L66:
        r2.getPageType();
        Iterator<w1> r23 = r1.iterator();
    L68:
        if (r23.hasNext() == false) goto L77;
        w1 r24 = r23.next();
        if (r24.getDisplay() == false) goto L68;
        b r25 = new b();
        r25.a = r24.getPageName();
        if (r24.getPageType() != r2.getPageType()) goto L75;
        boolean r26 = true;
    L76:
        r25.c = r26;
        r25.b = r24.getPageType();
        ((ArrayList) this.k).add(r25);
        goto L68
    L75:
        r26 = false;
        goto L76
    L29:
        if (r8.getIsVertical() == true) goto L31;
    L22:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L25;
        r7 = false;
        goto L26
    L15:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L18;
        r6 = false;
        goto L20
    L5:
        r1 = new ArrayList();
        goto L6
    }

    public FormatGiftBottomWidget(GiftViewModelManager r1) {
        this.n = r1;
        this.k = new ArrayList();
        this.l = new CompositeDisposable();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        if (r3.getId() != 2131365496) goto L6;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.m(null, true));
        com.bytedance.android.livesdk.gift.platform.core.utils.h.X();
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
        this.h = findViewById(2131366988);
        TextView r9 = (TextView) findViewById(2131375210);
        this.i = r9;
        if (r9 == null) goto L17;
        r9.setText(s1.C(2131917145, new Object[]{r3.c()}));
    L17:
        this.j = (TextView) findViewById(2131375211);
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
        RecyclerView r11 = this.a;
        if (r11 == null) goto L16;
        ViewUtilsKt.e(r11);
    L16:
        zq();
        f r13 = new f(this);
        q12.a r2 = q12.b.a;
        if (r2 == null) goto L19;
        Object r3 = m.e.d(r2, FormatGiftListViewModel.class);
    L20:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r4 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r3;
        if (r4 == null) goto L23;
        GiftStateMachineConfig.g r5 = r4.c(this, r13);
    L24:
        if (r5 == null) goto L26;
        r13.onChanged(r5);
    L26:
        g r14 = new g(this);
        q12.a r6 = q12.b.a;
        if (r6 == null) goto L29;
        Object r15 = m.e.d(r6, FormatGiftTabViewModel.class);
    L30:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r16 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r15;
        if (r16 == null) goto L33;
        GiftStateMachineConfig.g r17 = r16.c(this, r14);
    L34:
        if (r17 == null) goto L36;
        r14.onChanged(r17);
    L36:
        h r18 = new h(this);
        q12.a r19 = q12.b.a;
        if (r19 == null) goto L39;
        Object r20 = m.e.d(r19, FormatGiftPanelDialogViewModel.class);
    L40:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r21 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r20;
        if (r21 == null) goto L43;
        GiftStateMachineConfig.g r23 = r21.c(this, r18);
    L44:
        if (r23 == null) goto L46;
        r18.onChanged(r23);
    L46:
        this.l.add(k.n(IRechargeService.class).rechargeCenter().observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.d(this), com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.e.a));
        View r24 = this.e;
        if (r24 == null) goto L49;
        r24.setOnClickListener(this);
    L49:
        View r25 = this.h;
        if (r25 == null) goto L52;
        r25.setOnClickListener(i.a);
    L52:
        boolean r26 = isScreenPortrait();
        int r27 = com.bytedance.android.livesdk.utils.landscape.d.a;
        boolean r28 = !r26;
        View r29 = this.g;
        if (r29 == null) goto L56;
        r29.setVisibility(8);
    L56:
        if (this.i != null) goto L58;
        return;
    L58:
        if (this.j == null) goto L71;
        GiftViewModelManager r30 = this.n;
        if (r30 == null) goto L65;
        if (r30.getIsVertical() != true) goto L65;
        r0 = true;
    L65:
        if (u.k(r0) == 2) goto L67;
        return;
    L67:
        if (xq(null) == false) goto L73;
        this.l.add(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).pl().subscribe(new com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.b(this), com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.c.a));
        return;
    L73:
        return;
    L71:
        return;
    L43:
        r23 = null;
        goto L44
    L39:
        r20 = null;
        goto L40
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L23:
        r5 = null;
        goto L24
    L19:
        r3 = null;
        goto L20
    }

    public final boolean xq(ds2.d r13) {
        View r0 = this.e;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L7:
        if ((r1 instanceof ConstraintLayout.LayoutParams) == true) goto L9;
        r1 = null;
    L9:
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        GiftViewModelManager r3 = this.n;
        boolean r4 = false;
        if (r3 != null) goto L12;
    L14:
        boolean r5 = false;
    L16:
        if (u.l(r5, r13) == false) goto L26;
        ArrayList r7 = new ArrayList();
        r7.add(this.i);
        r7.add(this.j);
        zv0.b r14 = k.n(IRechargeService.class).getCashExchangeDelegate(this.i, r7, this.j, new FormatGiftBottomWidget$adjustContainerHeight$1(this), 2, ((Widget) this).context);
        this.m = r14;
        if (r14 == null) goto L20;
        r14.setDataCenter(((Widget) this).dataCenter);
    L20:
        TextView r15 = this.i;
        if (r15 == null) goto L23;
        r15.setVisibility(0);
    L23:
        if (r2 == null) goto L25;
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = s1.f(12.0f);
    L25:
        boolean r16 = false;
    L35:
        View r6 = this.e;
        if (r6 == null) goto L38;
        r6.setLayoutParams(r2);
    L38:
        TextView r8 = this.c;
        if (r8 == null) goto L41;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L43:
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r9 = null;
    L45:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        GiftViewModelManager r11 = this.n;
        if (r11 == null) goto L51;
        if (r11.getIsVertical() != true) goto L51;
        r4 = true;
    L51:
        if (u.l(r4, null) == false) goto L53;
        float r17 = 8.0f;
    L54:
        int r18 = s1.f(r17);
        View r19 = this.f;
        if (r19 == null) goto L57;
        r19.setVisibility(8);
    L57:
        if (r10 == null) goto L59;
        r10.rightMargin = r18;
    L59:
        TextView r20 = this.c;
        if (r20 == null) goto L62;
        r20.setLayoutParams(r10);
    L62:
        return r16;
    L53:
        r17 = 20.0f;
        goto L54
    L41:
        r9 = null;
        goto L43
    L26:
        TextView r110 = this.i;
        if (r110 == null) goto L29;
        r110.setVisibility(8);
    L29:
        TextView r111 = this.j;
        if (r111 == null) goto L32;
        r111.setVisibility(8);
    L32:
        if (r2 == null) goto L34;
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = s1.f(16.0f);
    L34:
        r16 = true;
        goto L35
    L12:
        if (r3.getIsVertical() != true) goto L14;
        r5 = true;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public static final void wq(FormatGiftBottomWidget r1, GiftStateMachineConfig.g r2) {
        r1.getClass();
        if (r2 != null) goto L6;
        return;
    L6:
        if ((r2 instanceof GiftStateMachineConfig.e.b) == false) goto L8;
    L9:
        r1.yq();
    L11:
        if ((r2 instanceof GiftStateMachineConfig.h.a) == false) goto L14;
        r1.yq();
    L14:
        if ((r2 instanceof GiftStateMachineConfig.a) == false) goto L17;
        r1.zq();
        return;
    L17:
        return;
    L8:
        if ((r2 instanceof GiftStateMachineConfig.e.c) == false) goto L11;
        goto L9
    }
}
