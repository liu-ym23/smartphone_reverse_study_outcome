package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.configmodel.j1;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OpenBackpackGiftRecord;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollToPositionEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowTopicView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SmoothScrollEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateTopViewSource;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftPanelNitaViewInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class BaseGiftPagerItem<STATE extends MVIState<?>> extends com.bytedance.android.anya.c<STATE, GiftAction> {
    public final TextView A;
    public final View B;
    public long C;
    public final Map<Long, IntRange> D;
    public final int E;
    public final int F;
    public final Function0<Boolean> G;
    public int l;
    public boolean m;
    public IntRange n;
    public IntRange o;
    public final j1 p;
    public final int q;
    public boolean r;
    public final Lazy s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final FirstRowTopPaddingDecoration x;
    public final RecyclerView y;
    public final ImageView z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseGiftPagerItem b;

        public a(View r1, BaseGiftPagerItem r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.b.o(new OpenBackpackGiftRecord(this.a.getContext()));
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean s() {
        return ((Boolean) this.s.getValue()).booleanValue();
    }

    public final boolean r() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.e.getClass();
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.d.a();
    }

    public final void t() {
        this.y.setVisibility(8);
        ImageView r0 = this.z;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0 r1 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.d;
        r1.getClass();
        if (((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.f0) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.b.getValue(r1, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.a[0])).c() == false) goto L10;
        int r2 = ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_LIST_EMPTY_ICON, 2131250536)).intValue();
        ImageView r3 = this.z;
        if (r3 == null) goto L10;
        r3.setImageResource(r2);
    L10:
        TextView r4 = this.A;
        if (r4 == null) goto L13;
        r4.setVisibility(0);
    L13:
        u(this.l);
    }

    public final void v() {
        this.y.setVisibility(0);
        ImageView r0 = this.z;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        View r1 = this.B;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        TextView r2 = this.A;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        this.y.invalidateItemDecorations();
    }

    public final boolean d(com.bytedance.android.anya.a0 r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        int r1 = 3;
        boolean r5 = true;
        if ((r9 instanceof ScrollToPositionEffect) == false) goto L28;
        ScrollToPositionEffect r10 = (ScrollToPositionEffect) r9;
        if (r10.getPagerPosition() == this.E) goto L7;
    L85:
        return false;
    L7:
        if (r10.getCounterPosition() != (-1)) goto L85;
        if (r10.getTopicPagerPosition() != this.F) goto L85;
        LinearLayoutManager r0 = this.y.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L13;
    L26:
        return true;
    L13:
        if (s() == true) goto L15;
    L25:
        r0.scrollToPositionWithOffset(r10.getPosition(), com.bytedance.android.live.revenue.common.i.b(2));
        goto L26
    L15:
        if (this.w == false) goto L17;
        r1 = 0;
    L17:
        int r2 = r10.getPosition();
        if (r2 < 0) goto L21;
        if (r1 >= r2) goto L25;
    L21:
        if (r10.isDefault() == false) goto L23;
    L24:
        r0.scrollToPositionWithOffset(r10.getPosition(), com.bytedance.android.live.revenue.common.i.b(58));
        goto L26
    L23:
        if (r10.isSearchLocate() == false) goto L25;
    L28:
        if ((r9 instanceof SmoothScrollEffect) == false) goto L40;
        SmoothScrollEffect r11 = (SmoothScrollEffect) r9;
        if (r11.getPagerPosition() != this.E) goto L85;
        if (r11.getCounterPosition() != (-1)) goto L85;
        if (r11.getTopicPagerPosition() != this.F) goto L85;
        RecyclerView.LayoutManager r3 = this.y.getLayoutManager();
        if ((r3 instanceof LinearLayoutManager) == false) goto L38;
        r3.smoothScrollToPosition(this.y, new RecyclerView.State(), r11.getPosition());
    L38:
        return true;
    L40:
        if ((r9 instanceof GiftTopVisibleChanged) == false) goto L83;
        if (s() == false) goto L85;
        GiftTopVisibleChanged r13 = (GiftTopVisibleChanged) r9;
        if (r13.getVisible() == false) goto L85;
        if (r13.getSource() == UpdateTopViewSource.SCROLL) goto L85;
        if (r13.getPagerPosition() != this.E) goto L85;
        if (this.w == false) goto L52;
        r1 = 0;
    L52:
        int r4 = r13.getSelectedPosition();
        if (r4 < 0) goto L55;
        if (r1 >= r4) goto L85;
    L55:
        RecyclerView.LayoutManager r6 = this.y.getLayoutManager();
        if ((r6 instanceof LinearLayoutManager) == true) goto L58;
        r6 = null;
    L58:
        LinearLayoutManager r7 = (LinearLayoutManager) r6;
        if (r7 == null) goto L85;
        int r8 = m02.e.a(r7, this.y, 50, s());
        if (r8 == 0) goto L63;
    L65:
        int r14 = r8 + 3;
    L67:
        if (this.w == false) goto L75;
        View r15 = r7.findViewByPosition(r13.getSelectedPosition());
        if (r15 == null) goto L71;
        int r16 = r15.getTop();
    L73:
        if (r16 < com.bytedance.android.live.revenue.common.i.b(58)) goto L75;
        r5 = false;
        goto L75
    L71:
        r16 = 0;
    L75:
        if (r8 > r14) goto L85;
    L77:
        if (r8 != r13.getSelectedPosition()) goto L80;
        if (r5 == false) goto L80;
        r7.scrollToPositionWithOffset(r13.getSelectedPosition(), (int) UtilityKotlinExtentionsKt.h(58));
    L80:
        if (r8 == r14) goto L85;
        r8 = r8 + 1;
        goto L77
    L63:
        if (this.w == false) goto L65;
        r14 = r8 + 4;
        goto L67
    L83:
        if ((r9 instanceof ShowTopicView) == false) goto L85;
        this.r = ((ShowTopicView) r9).getVisible();
        goto L85
    }

    public final void u(int r6) {
        if (r6 != 5) goto L23;
        ImageView r7 = this.z;
        if (r7 == null) goto L23;
        if (r7.getVisibility() != 0) goto L23;
        if (nz1.a.d().length() <= 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L23;
        View r9 = this.B;
        if (r9 == null) goto L16;
        r9.setVisibility(0);
    L16:
        i12.d r10 = i12.m.e2.a();
        if (r10 == null) goto L19;
        Object r11 = com.bytedance.android.scope.m.e.d(r10, u1.class);
    L20:
        u1 r13 = (u1) r11;
        if (r13 == null) goto L27;
        Intrinsics.checkNotNullParameter("panel", "type");
        r13.p1("livesdk_prop_record_entrance_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("entrance_type", "panel")}), true);
        return;
    L27:
        return;
    L19:
        r11 = null;
        goto L20
    L11:
        r8 = false;
    L23:
        View r14 = this.B;
        if (r14 == null) goto L29;
        r14.setVisibility(8);
        return;
    }

    public BaseGiftPagerItem(ViewGroup r6, int r7, int r8, Function0<Boolean> r9) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r9, "animationFun");
        Intrinsics.checkNotNullParameter(r6, "parent");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0 r0 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.d;
        r0.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.a() == false) goto L8;
        GiftPanelViewPreloadService.l.getClass();
        View r1 = GiftPanelViewPreloadService.a.a(2131567032);
        if (r1 == null) goto L8;
    L16:
        super(r1);
        this.E = r7;
        this.F = r8;
        this.G = r9;
        this.n = new IntRange(-1, -1);
        this.o = new IntRange(-1, -1);
        j1 r10 = com.bytedance.android.livesdk.gift.platform.core.a0.e();
        this.p = r10;
        int r11 = r10.C4();
        this.q = r10.y8();
        this.s = LazyKt.lazy(BaseGiftPagerItem$enableScrollAnimationOpt$2.INSTANCE);
        this.u = true;
        this.v = true;
        FirstRowTopPaddingDecoration r13 = new FirstRowTopPaddingDecoration();
        this.x = r13;
        final RecyclerView r14 = ((com.bytedance.android.anya.c) this).k.findViewById(2131384076);
        if (r11 <= 0) goto L19;
        r14.setItemViewCacheSize(r11);
    L19:
        final Ref.BooleanRef r15 = new Ref.BooleanRef();
        r15.element = true;
        GiftGridLayoutManager r16 = new GiftGridLayoutManager(r14.getContext(), new BaseGiftPagerItem$$special$$inlined$apply$lambda$1(r15, this));
        r16.setSpanSizeLookup(new BaseGiftPagerItem$$special$$inlined$also$lambda$1(r14));
        Unit r2 = Unit.INSTANCE;
        r14.setLayoutManager(r16);
        r14.setItemAnimator(null);
        r14.setClipChildren(false);
        r14.setClipToPadding(false);
        if (s() == false) goto L22;
        r14.addItemDecoration(r13, 0);
    L22:
        r14.addItemDecoration(new LastRowBottomPaddingDecoration(new BaseGiftPagerItem$$special$$inlined$apply$lambda$2(this)));
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == false) goto L25;
        r14.addOnItemTouchListener(new RecyclerViewScrollInterceptor(r14.getContext(), new BaseGiftPagerItem$$special$$inlined$apply$lambda$3(this)));
    L25:
        r14.addOnScrollListener(new BaseGiftPagerItem$$special$$inlined$apply$lambda$4(r14, r15, this));
        this.y = r14;
        ImageView r17 = (ImageView) ((com.bytedance.android.anya.c) this).k.findViewById(2131380923);
        if (((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.f0) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.b.getValue(r0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.a[0])).c() == true) goto L28;
        r17.setImageResource(((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_LIST_EMPTY_ICON, 2131250536)).intValue());
    L28:
        this.z = r17;
        this.A = (TextView) ((com.bytedance.android.anya.c) this).k.findViewById(2131380921);
        ((TextView) ((com.bytedance.android.anya.c) this).k.findViewById(2131363826)).setText(((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_BACKPACK_GIFT_LIST_EMPTY_CHECK_RECORD_TEXT, 2131917089)).intValue());
        ((ImageView) ((com.bytedance.android.anya.c) this).k.findViewById(2131363825)).setImageResource(((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_BACKPACK_GIFT_LIST_EMPTY_CHECK_RECORD_ICON, 2131253159)).intValue());
        View r18 = ((com.bytedance.android.anya.c) this).k.findViewById(2131363824);
        r18.setOnClickListener(new a(r18, this));
        this.B = r18;
        this.C = -1;
        this.D = new LinkedHashMap();
        return;
    L8:
        if (com.bytedance.android.livesdk.gift.platform.core.a0.e().L3() == false) goto L14;
        GiftPanelNitaViewInfo r3 = GiftPanelNitaViewInfo.TTLIVE_MVI_VERTICAL_PAGER;
        int r4 = r3.getResId();
        String r5 = r3.getTag();
        Context r19 = r6.getContext();
        if (r19 == null) goto L13;
        View r20 = NitaInflateUtil.a(r4, r5, (Activity) r19, r6, false);
    L15:
        r1 = r20;
        goto L16
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L14:
        r20 = LayoutInflater.from(r6.getContext()).inflate(2131567032, r6, false);
        goto L15
    }
}
