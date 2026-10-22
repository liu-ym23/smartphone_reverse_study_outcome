package com.bytedance.android.livesdk.gift.platform.format.panel.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.z3;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.config.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.format.panel.adapter.FormatGiftDialogAdapter;
import com.bytedance.android.livesdk.gift.platform.format.panel.adapter.FormatGiftDialogViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftListViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftPanelDialogViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftTabViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.viewholder.FormatGiftDialogViewHolder;
import com.bytedance.android.livesdk.gift.platform.format.panel.viewmodel.FormatGiftDialogViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import pz1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/format/panel/view/FormatGiftListWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftListWidget extends LiveRecyclableWidget {
    public final CompositeDisposable a;
    public ViewPager b;
    public final FormatGiftDialogViewPagerAdapter c;
    public AbsPanel<?> d;
    public int e;
    public ImageView f;
    public int g;
    public Disposable h;
    public final FormatGiftListWidget$pageChangeListener$1 i;
    public final GiftViewModelManager j;
    public final FormatGiftDialogViewModel k;

    public static final class a<T> implements Observer {
        public final /* synthetic */ FormatGiftListWidget a;

        public a(FormatGiftListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            z3 r7 = (z3) r6;
            FormatGiftListWidget r0 = this.a;
            AbsPanel<?> r1 = r0.d;
            if (r1 == null) goto L24;
            FormatGiftDialogAdapter r2 = r0.Aq();
            if (r2 == null) goto L25;
            AbsPanel<?> r3 = r2.z2(r1.c());
            if (r3 == null) goto L28;
            FormatGiftDialogAdapter r4 = r0.Aq();
            if (r4 == null) goto L26;
            Intrinsics.checkNotNullParameter(r3, "panel");
            int r5 = ((ArrayList) r4.a).indexOf(r3);
            RecyclerView r8 = r0.zq();
            String r9 = null;
            if (r8 == null) goto L14;
            RecyclerView.ViewHolder r10 = r8.findViewHolderForAdapterPosition(r5);
        L16:
            if ((r10 instanceof FormatGiftDialogViewHolder) == true) goto L18;
            r10 = null;
        L18:
            FormatGiftDialogViewHolder r11 = (FormatGiftDialogViewHolder) r10;
            if (r11 == null) goto L27;
            if (r7 == null) goto L22;
            r9 = r7.a();
        L22:
            r11.d4().g(r9);
            return;
        L27:
            return;
        L14:
            r10 = null;
            goto L16
        L26:
            return;
        L28:
            return;
        L25:
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ FormatGiftListWidget a;

        public b(FormatGiftListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            FormatGiftListWidget r0 = this.a;
            FormatGiftListWidget.xq(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ FormatGiftListWidget a;

        public c(FormatGiftListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            FormatGiftListWidget r0 = this.a;
            FormatGiftListWidget.xq(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ FormatGiftListWidget a;

        public d(FormatGiftListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            FormatGiftListWidget r0 = this.a;
            FormatGiftListWidget.xq(r0, (GiftStateMachineConfig.g) r2);
        }
    }

    public final FormatGiftDialogAdapter Aq() {
        Map<Integer, FormatGiftDialogAdapter> r0 = this.c.d;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        return (FormatGiftDialogAdapter) r1.get(Integer.valueOf(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c()));
    }

    public final void onPause() {
        this.c.g(zq());
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public final RecyclerView zq() {
        ViewPager r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewWithTag(Integer.valueOf(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c()));
    }

    public final int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L5;
    L8:
        return 2131567970;
    L5:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L8;
        return 2131567967;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        this.c.h(zq());
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.gift.util.b.e(this);
        this.a.clear();
        Disposable r0 = this.h;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final int yq() {
        if (PadConfigUtils.c() == true) goto L9;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L9;
        return s1.getResources().getDimensionPixelSize(2131169286);
    L9:
        return s1.getResources().getDimensionPixelSize(2131169288);
    }

    public final void Bq(int r6) {
        ViewPager r0 = this.b;
        if (r0 == null) goto L19;
        Iterator r1 = ((ArrayList) this.c.b).iterator();
        int r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L14;
        if (((w1) r1.next()).getPageType() != r6) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L15;
        r3 = r3 + 1;
    L15:
        r0.setCurrentItem(r3);
        return;
    L10:
        r4 = false;
        goto L11
    L14:
        r3 = -1;
        goto L15
    }

    public final void Fq(List<? extends w1> r9) {
        if (r9 == null) goto L36;
        FormatGiftDialogViewPagerAdapter r1 = this.c;
        Context r2 = ((Widget) this).context;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r9, "pages");
        ArrayList r3 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L15;
        Object r4 = r10.next();
        w1 r5 = (w1) r4;
        if (r5.getDisplay() == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L6;
        r3.add(r4);
        goto L6
    L10:
        if (r5.getPageType() != 1) goto L12;
        r6 = true;
        goto L13
    L15:
        ((ArrayList) r1.b).clear();
        ((ArrayList) r1.b).addAll(r3);
        Iterator r11 = ((LinkedHashMap) r1.d).entrySet().iterator();
    L17:
        if (r11.hasNext() == false) goto L25;
        Map.Entry r7 = (Map.Entry) r11.next();
        List<w1> r8 = r1.b;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r14 = ((ArrayList) r8).iterator();
    L20:
        if (r14.hasNext() == false) goto L23;
        r13.add(Integer.valueOf(((w1) r14.next()).getPageType()));
        goto L20
    L23:
        if (r13.contains(r7.getKey()) == true) goto L17;
        r11.remove();
        goto L17
    L25:
        r1.notifyDataSetChanged();
        Iterator r15 = r3.iterator();
    L27:
        if (r15.hasNext() == false) goto L34;
        w1 r16 = (w1) r15.next();
        if (r1.d.containsKey(Integer.valueOf(r16.getPageType())) == true) goto L31;
        r1.d.put(Integer.valueOf(r16.getPageType()), new FormatGiftDialogAdapter(r2, r1.n));
    L31:
        FormatGiftDialogAdapter r17 = (FormatGiftDialogAdapter) ((LinkedHashMap) r1.d).get(Integer.valueOf(r16.getPageType()));
        if (r17 == null) goto L27;
        r17.y2(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.l(r16.getPageType()));
        goto L27
    L34:
        r1.notifyDataSetChanged();
        this.c.f(((Widget) this).context, com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c());
    L36:
        if ((!com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.l(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c()).isEmpty()) == false) goto L57;
        ImageView r18 = this.f;
        if (r18 == null) goto L58;
        r18.setVisibility(8);
        return;
    L58:
        return;
    }

    public final void onInit(Object[] r1) {
        this.b = findViewById(2131392567);
        this.f = (ImageView) findViewById(2131380923);
    }

    public final void onLoad(Object[] r5) {
        ViewPager r6 = this.b;
        if (r6 == null) goto L5;
        r6.setAdapter(this.c);
    L5:
        ViewPager r7 = this.b;
        if (r7 == null) goto L8;
        r7.addOnPageChangeListener(this.i);
    L8:
        int r8 = ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_LIST_EMPTY_ICON, 2131250536)).intValue();
        ImageView r0 = this.f;
        if (r0 == null) goto L11;
        r0.setImageResource(r8);
    L11:
        FormatGiftDialogViewModel r9 = this.k;
        if (r9 == null) goto L16;
        MutableLiveData<z3> r10 = r9.getInfo();
        if (r10 == null) goto L16;
        r10.observe(this, new a(this));
    L16:
        b r11 = new b(this);
        q12.a r1 = q12.b.a;
        GiftStateMachineConfig.g r2 = null;
        if (r1 == null) goto L19;
        Object r3 = m.e.d(r1, FormatGiftListViewModel.class);
    L20:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r4 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r3;
        if (r4 == null) goto L23;
        GiftStateMachineConfig.g r13 = r4.c(this, r11);
    L24:
        if (r13 == null) goto L26;
        r11.onChanged(r13);
    L26:
        c r14 = new c(this);
        q12.a r15 = q12.b.a;
        if (r15 == null) goto L29;
        Object r16 = m.e.d(r15, FormatGiftTabViewModel.class);
    L30:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r17 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r16;
        if (r17 == null) goto L33;
        GiftStateMachineConfig.g r18 = r17.c(this, r14);
    L34:
        if (r18 == null) goto L36;
        r14.onChanged(r18);
    L36:
        d r19 = new d(this);
        q12.a r20 = q12.b.a;
        if (r20 == null) goto L39;
        Object r21 = m.e.d(r20, FormatGiftPanelDialogViewModel.class);
    L40:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r23 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r21;
        if (r23 == null) goto L43;
        r2 = r23.c(this, r19);
    L43:
        if (r2 == null) goto L45;
        r19.onChanged(r2);
    L45:
        View r24 = findViewById(2131379672);
        if (r24 == null) goto L48;
        r24.setVisibility(8);
    L48:
        View r25 = findViewById(2131379673);
        if (r25 == null) goto L51;
        r25.setVisibility(8);
    L51:
        int r26 = s1.f(5.0f);
        View r27 = ((Widget) this).contentView;
        r27.setPadding(r27.getPaddingLeft(), r26, ((Widget) this).contentView.getPaddingRight(), ((Widget) this).contentView.getPaddingBottom());
        return;
    L39:
        r21 = null;
        goto L40
    L33:
        r18 = null;
        goto L34
    L29:
        r16 = null;
        goto L30
    L23:
        r13 = null;
        goto L24
    L19:
        r3 = null;
        goto L20
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.livesdk.gift.platform.format.panel.view.FormatGiftListWidget$pageChangeListener$1] */
    public FormatGiftListWidget(GiftViewModelManager r2, FormatGiftDialogViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "mViewModel");
        this.j = r2;
        this.k = r3;
        this.a = new CompositeDisposable();
        this.c = new FormatGiftDialogViewPagerAdapter(r2, r3);
        this.i = new FormatGiftListWidget$pageChangeListener$1(this);
    }

    public static final HashMap wq(FormatGiftListWidget r8, int r9) {
        ViewPager r0 = r8.b;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.findViewWithTag(Integer.valueOf(r9));
        if (r1 == null) goto L7;
        RecyclerView.LayoutManager r2 = r1.getLayoutManager();
    L8:
        List<AbsPanel<?>> r3 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.l(r9);
        HashMap r4 = new HashMap();
        if ((r2 instanceof LinearLayoutManager) == false) goto L57;
        LinearLayoutManager r5 = (LinearLayoutManager) r2;
        int r6 = r5.findFirstCompletelyVisibleItemPosition();
        int r7 = r5.findLastCompletelyVisibleItemPosition();
        if (r6 > r7) goto L37;
    L12:
        if (r6 >= 0) goto L14;
    L34:
        if (r6 == r7) goto L37;
        r6 = r6 + 1;
        goto L12
    L14:
        if (r6 >= r3.size()) goto L34;
        AbsPanel r10 = (AbsPanel) ListProtector.get(r3, r6);
        if ((r10 instanceof com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) == false) goto L26;
        T r11 = ((com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) r10).h;
        if ((r11 instanceof h1) == false) goto L26;
        h1 r13 = (h1) r11;
        if (r13 == null) goto L24;
        r4.put(Long.valueOf(r13.getId()), Long.valueOf(r6));
        goto L34
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L26:
        if ((r10 instanceof e) == false) goto L34;
        T r14 = ((e) r10).h;
        if ((r14 instanceof l2) == false) goto L34;
        l2 r15 = (l2) r14;
        if (r15 == null) goto L33;
        r4.put(Long.valueOf(r15.getId()), Long.valueOf(r6));
        goto L34
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L37:
        if (r4.isEmpty() == false) goto L57;
        IntRange r16 = (IntRange) ((LinkedHashMap) r8.c.h).get(Integer.valueOf(r9));
        if (r16 == null) goto L57;
        int r17 = r16.getFirst();
        int r18 = r16.getLast();
        if (r17 > r18) goto L57;
    L42:
        if (r17 >= 0) goto L44;
    L55:
        if (r17 == r18) goto L57;
        r17 = r17 + 1;
        goto L42
    L44:
        if (r17 >= r3.size()) goto L55;
        AbsPanel r19 = (AbsPanel) ListProtector.get(r3, r17);
        if ((r19 instanceof com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) == false) goto L55;
        T r20 = ((com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) r19).h;
        if ((r20 instanceof h1) == false) goto L55;
        h1 r21 = (h1) r20;
        if (r21 == null) goto L54;
        r4.put(Long.valueOf(r21.getId()), Long.valueOf(r17));
        goto L55
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L57:
        return r4;
    L7:
        r2 = null;
        goto L8
    }

    public static final void xq(FormatGiftListWidget r7, GiftStateMachineConfig.g r8) {
        r7.getClass();
        if (r8 == null) goto L101;
        boolean r2 = false;
        Long r3 = null;
        if ((r8 instanceof GiftStateMachineConfig.e.b) == false) goto L45;
        GiftStateMachineConfig.e.b r0 = (GiftStateMachineConfig.e.b) r8;
        GiftStateMachineConfig.c r4 = r0.a;
        if (r4 == null) goto L12;
        if (r4.f == true) goto L45;
    L12:
        if (r0.b == false) goto L23;
        List<w1> r1 = r0.a();
        if (r1 == null) goto L21;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r1.iterator();
    L17:
        if (r6.hasNext() == false) goto L22;
        Object r9 = r6.next();
        if (((w1) r9).getDisplay() == false) goto L17;
        r5.add(r9);
    L22:
        r7.Fq(r5);
        goto L23
    L21:
        r5 = null;
    L23:
        ViewPager r10 = r7.b;
        if (r10 == null) goto L35;
        Integer r11 = Integer.valueOf(r10.getCurrentItem());
        if (r11.intValue() != (-1)) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == true) goto L32;
        r11 = null;
    L32:
        if (r11 == null) goto L35;
        r11.intValue();
        r7.Bq(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c());
        goto L35
    L28:
        r13 = false;
    L35:
        if (r7.zq() == null) goto L38;
        r7.Eq(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c(), false);
    L38:
        if (r7.zq() != null) goto L45;
        Disposable r14 = r7.h;
        if (r14 != null) goto L42;
    L43:
        j.a r15 = j.a;
        r7.h = j.c(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new s12.d(r7));
        goto L45
    L42:
        if (r14.isDisposed() == true) goto L43;
    L45:
        if ((r8 instanceof GiftStateMachineConfig.e.c) == false) goto L59;
        GiftStateMachineConfig.e.c r16 = (GiftStateMachineConfig.e.c) r8;
        if (r16.b == true) goto L59;
        List<w1> r17 = r16.a();
        if (r17 == null) goto L56;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L52:
        if (r19.hasNext() == false) goto L57;
        Object r20 = r19.next();
        if (((w1) r20).getDisplay() == false) goto L52;
        r18.add(r20);
    L57:
        r7.Fq(r18);
        com.bytedance.android.livesdk.gift.util.d.c();
        goto L59
    L56:
        r18 = null;
    L59:
        if ((r8 instanceof GiftStateMachineConfig.h.a) == false) goto L62;
        r7.Bq(((GiftStateMachineConfig.h.a) r8).a);
    L62:
        if ((r8 instanceof GiftStateMachineConfig.a.h) == false) goto L65;
        r7.Cq(AbsPanel.GiftPanelSelectType.IDLE, false);
    L65:
        if ((r8 instanceof GiftStateMachineConfig.a.e) == false) goto L67;
    L68:
        GiftStateMachineConfig.a r21 = (GiftStateMachineConfig.a) r8;
        AbsPanel<?> r23 = r21.a();
        if ((r21 instanceof GiftStateMachineConfig.a.e) == false) goto L72;
        r2 = ((GiftStateMachineConfig.a.e) r21).b;
    L72:
        if (r7.d == null) goto L82;
        if (r23 == null) goto L75;
        Long r24 = Long.valueOf(r23.c());
    L76:
        AbsPanel<?> r25 = r7.d;
        if (r25 == null) goto L80;
        r3 = Long.valueOf(r25.c());
    L80:
        if ((!Intrinsics.areEqual(r24, r3)) == false) goto L82;
        r7.Cq(AbsPanel.GiftPanelSelectType.IDLE, r2);
        goto L82
    L75:
        r24 = null;
    L82:
        r7.d = r23;
        if (r23 == null) goto L99;
        AbsPanel.GiftPanelSelectType r26 = r23.d;
        if (r26 == null) goto L100;
        r7.Cq(r26, r2);
        return;
    L100:
        return;
    L99:
        return;
    L67:
        if ((r8 instanceof GiftStateMachineConfig.a.g) == true) goto L68;
        return;
    }

    public final void Cq(AbsPanel.GiftPanelSelectType r6, boolean r7) {
        AbsPanel<?> r0 = this.d;
        if (r0 == null) goto L113;
        FormatGiftDialogAdapter r1 = Aq();
        if (r1 == null) goto L114;
        AbsPanel<?> r2 = r1.z2(r0.c());
        if (r2 == null) goto L117;
        r2.d = r6;
        FormatGiftDialogAdapter r3 = Aq();
        if (r3 == null) goto L115;
        Intrinsics.checkNotNullParameter(r2, "panel");
        int r4 = ((ArrayList) r3.a).indexOf(r2);
        if (r7 == true) goto L109;
        Integer r5 = null;
        if (r6 != AbsPanel.GiftPanelSelectType.NORMAL_SELECTED) goto L79;
        RecyclerView r8 = zq();
        if (r8 == null) goto L18;
        RecyclerView.LayoutManager r9 = r8.getLayoutManager();
    L20:
        if ((r9 instanceof LinearLayoutManager) == false) goto L75;
        View r10 = r9.findViewByPosition(r4);
        if (r10 == null) goto L109;
        if (r4 >= ((LinearLayoutManager) r9).findFirstCompletelyVisibleItemPosition()) goto L43;
        if (this.j.getIsVertical() == false) goto L29;
    L34:
        boolean r11 = true;
    L35:
        if (r11 == false) goto L39;
        RecyclerView r13 = zq();
        if (r13 == null) goto L109;
        r13.smoothScrollBy(0, (r10.getBottom() - r10.getHeight()) - i.b(1));
        goto L109
    L39:
        RecyclerView r14 = zq();
        if (r14 == null) goto L109;
        r14.smoothScrollBy(0, (r10.getBottom() - r10.getHeight()) - i.b(2));
        goto L109
    L29:
        if (PadConfigUtils.c() == true) goto L34;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L34;
        r11 = false;
        goto L35
    L43:
        if (this.j.getIsVertical() == false) goto L45;
    L50:
        boolean r15 = true;
    L51:
        if (r15 == true) goto L58;
        if (r10.getBottom() <= yq()) goto L109;
        RecyclerView r16 = zq();
        if (r16 == null) goto L109;
        r16.smoothScrollBy(0, (r10.getBottom() - yq()) + i.b(38));
        goto L109
    L58:
        if (((Boolean) y12.b.b.getValue(null, y12.b.a[0])).booleanValue() == false) goto L71;
        ViewPager r17 = this.b;
        if (r17 == null) goto L64;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L64;
        r5 = Integer.valueOf(r18.height);
    L64:
        if (r5 == null) goto L109;
        if (r10.getBottom() <= r5.intValue()) goto L109;
        RecyclerView r19 = zq();
        if (r19 == null) goto L109;
        r19.smoothScrollBy(0, r10.getBottom() - r5.intValue());
        goto L109
    L71:
        if (r10.getBottom() <= yq()) goto L109;
        RecyclerView r20 = zq();
        if (r20 == null) goto L109;
        r20.smoothScrollBy(0, r10.getBottom() - yq());
        goto L109
    L45:
        if (PadConfigUtils.c() == true) goto L50;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L50;
        r15 = false;
        goto L51
    L75:
        RecyclerView r21 = zq();
        if (r21 == null) goto L109;
        r21.scrollToPosition(r4);
        goto L109
    L18:
        r9 = null;
        goto L20
    L79:
        if (r6 != AbsPanel.GiftPanelSelectType.IDLE) goto L81;
        this.d = null;
        goto L109
    L81:
        if (zq() != null) goto L83;
        this.c.c.put(Integer.valueOf(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c()), Integer.valueOf(r4));
        goto L109
    L83:
        RecyclerView r23 = zq();
        if (r23 == null) goto L87;
        r5 = r23.getLayoutManager();
    L87:
        if ((r5 instanceof LinearLayoutManager) == false) goto L105;
        LinearLayoutManager r24 = (LinearLayoutManager) r5;
        int r25 = r24.findFirstCompletelyVisibleItemPosition();
        int r26 = r24.findLastCompletelyVisibleItemPosition();
        if (r25 > r4) goto L92;
        if (r26 >= r4) goto L105;
    L92:
        if (((n) com.bytedance.android.livesdk.gift.util.b.a().d(n.class)).e() != 1) goto L94;
        boolean r27 = true;
    L95:
        if (r27 == true) goto L97;
    L103:
        r24.scrollToPositionWithOffset(r4, i.b(2));
    L104:
        Eq(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c(), false);
        goto L109
    L97:
        if (this.j.getIsVertical() == false) goto L99;
    L102:
        r24.scrollToPositionWithOffset(r4, i.b(1));
        goto L104
    L99:
        if (PadConfigUtils.c() == true) goto L102;
        if (com.bytedance.android.livesdk.gift.util.a.a() == false) goto L103;
    L94:
        r27 = false;
    L105:
        RecyclerView r28 = zq();
        if (r28 == null) goto L109;
        r28.scrollToPosition(r4);
    L109:
        FormatGiftDialogAdapter r29 = Aq();
        if (r29 == null) goto L116;
        r29.notifyItemRangeChanged(r4, 1);
        return;
    L116:
        return;
    L115:
        return;
    L117:
        return;
    L114:
        return;
    }

    public final void Eq(int r4, boolean r5) {
        ViewPager r0 = this.b;
        if (r0 == null) goto L5;
        RecyclerView r1 = (RecyclerView) r0.findViewWithTag(Integer.valueOf(r4));
    L6:
        if (r1 == null) goto L9;
        this.c.l(r1, r4, r5, false);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
