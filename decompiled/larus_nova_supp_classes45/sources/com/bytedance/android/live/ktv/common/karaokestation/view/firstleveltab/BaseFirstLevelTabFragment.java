package com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.KtvCommonPagerAdapter;
import com.bytedance.android.live.ktv.common.karaokestation.view.ScrollControlViewPager;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.CommonDefaultSecondLevelTabFragment;
import com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.SecondLevelTabView;
import com.bytedance.android.live.ktv.common.model.KtvMode;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab.AudienceSingFirstLevelTabFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/BaseFirstLevelTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/BaseTabFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/a;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseFirstLevelTabFragment extends BaseTabFragment implements com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a {
    public static final /* synthetic */ int r = 0;
    public final long e;
    public final boolean f;
    public FrameLayout g;
    public ScrollControlViewPager h;
    public SecondLevelTabView i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public View m;
    public View n;
    public View o;
    public final String p;
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b q;

    public static final class a<T> implements Observer {
        public final /* synthetic */ BaseFirstLevelTabFragment a;

        public a(BaseFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Pair r4 = (Pair) r3;
            int r0 = ((Number) r4.component1()).intValue();
            if (((UpdateTabType) r4.component2()) == UpdateTabType.DIRECT_CLICK) goto L5;
            return;
        L5:
            if (r0 != this.a.VL().getValue()) goto L11;
            y r5 = this.a.q.getSelectedSecondLevelTabData(r0);
            if (r5 == null) goto L12;
            int r6 = r5.n;
            this.a.ba0(r6, new BaseFirstLevelTabFragment$initData$1$1(this));
            return;
        L12:
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseFirstLevelTabFragment a;

        public b(BaseFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Pair r4 = (Pair) r3;
            if (r4 == null) goto L10;
            com.bytedance.android.live.ktv.common.karaokestation.model.d r0 = (com.bytedance.android.live.ktv.common.karaokestation.model.d) r4.component1();
            List<y> r5 = (List) r4.component2();
            if (this.a.VL().getValue() != r0.d) goto L9;
            BaseFirstLevelTabFragment r1 = this.a;
            int r2 = BaseFirstLevelTabFragment.r;
            r1.fa0(r5);
            return;
        L9:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BaseFirstLevelTabFragment a;

        public c(BaseFirstLevelTabFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseFirstLevelTabFragment r0 = this.a;     // Catch: Throwable -> L4
            int r1 = BaseFirstLevelTabFragment.r;     // Catch: Throwable -> L4
            r0.Z90();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ BaseFirstLevelTabFragment a;

        public d(BaseFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            List<y> r4 = (List) r3;
            List<y> r0 = r4;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            return;
        L12:
            if (this.a.VL().getValue() != ((y) ListProtector.get(r4, 0)).k) goto L17;
            SecondLevelTabView r2 = this.a.i;
            if (r2 == null) goto L18;
            r2.setDataAndNotify(r4);
            return;
        L18:
            return;
        L17:
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ BaseFirstLevelTabFragment a;

        public e(BaseFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            y r5 = (y) r4;
            if (r5 != null) goto L6;
            return;
        L6:
            if (this.a.VL().getValue() != r5.k) goto L17;
            int r0 = this.a.Y90().size();
            int r1 = r5.n;
            if (r1 < 0) goto L20;
            if (r0 <= r1) goto L18;
            BaseFirstLevelTabFragment r2 = this.a;
            com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c r3 = r2.Y90().get(r5.n);
            if (r3.yf() == false) goto L14;
            r3.ok(r5, r3.ms(null));
        L15:
            r2.da0(r5);
            return;
        L14:
            r3.W30(new BaseFirstLevelTabFragment$updateSecondLevelTabSongList$1(r3, r5));
            goto L15
        L18:
            return;
        L20:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BaseFirstLevelTabFragment a;

        public f(BaseFirstLevelTabFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.ktv.common.karaokestation.model.c r4 = (com.bytedance.android.live.ktv.common.karaokestation.model.c) r3;
            Map<Integer, com.bytedance.android.live.ktv.common.karaokestation.model.b> r0 = r4.a;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L23;
            Map<Integer, com.bytedance.android.live.ktv.common.karaokestation.model.b> r5 = r4.a;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = this.a.q;
            if (r2 == null) goto L14;
            Integer r6 = Integer.valueOf(r2.getCurTabMode());
        L15:
            com.bytedance.android.live.ktv.common.karaokestation.model.b r7 = r5.get(r6);
            if (r7 != null) goto L18;
            return;
        L18:
            if (r7.b != this.a.VL().getValue()) goto L22;
            BaseFirstLevelTabFragment r8 = this.a;
            r8.Tq(r8.X90(r7.c), SecondLevelTabViewSelectedType.Default);
            return;
        L22:
            return;
        L14:
            r6 = null;
            goto L15
        L23:
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public void U50(boolean r1) {
    }

    public boolean U90() {
        return !(this instanceof AudienceSingFirstLevelTabFragment);
    }

    public void V90() {
    }

    public final CopyOnWriteArrayList<com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c> Y90() {
        return (CopyOnWriteArrayList) this.j.getValue();
    }

    public void ca0(y r1) {
    }

    public void da0(y r2) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public int getLayoutId() {
        return 2131566450;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void onDestroy() {
        this.m = null;
        this.n = null;
        this.o = null;
        super.onDestroy();
    }

    public final void Z90() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.q;
        if (r0 == null) goto L18;
        List<y> r1 = r0.getSecondLevelTabDataList(VL().getValue());
        if (r1 == null) goto L18;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L18;
        y r3 = (y) r2.next();
        int r4 = Y90().size();
        int r5 = r3.n;
        if (r5 < 0) goto L8;
        if (r4 <= r5) goto L8;
        com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c r6 = Y90().get(r3.n);
        if (r6.yf() == false) goto L16;
        r6.ok(r3, r6.ms(null));
    L17:
        da0(r3);
        goto L8
    L16:
        r6.W30(new BaseFirstLevelTabFragment$updateSecondLevelTabSongList$1(r6, r3));
    L18:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r7 = this.q;
        if (r7 == null) goto L29;
        r7.observeSongListDataChange(this, new e(this));
        return;
    }

    public final void aa0() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.q;
        y r1 = null;
        Object r2 = null;
        r1 = null;
        if (r0 == null) goto L18;
        List<y> r3 = r0.getSecondLevelTabDataList(VL().getValue());
        if (r3 == null) goto L18;
        Iterator<T> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        int r6 = ((y) r5).n;
        ScrollControlViewPager r7 = this.h;
        if (r7 != null) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == false) goto L8;
        r2 = r5;
        goto L17
    L12:
        if (r6 != r7.getCurrentItem()) goto L14;
        r8 = true;
    L17:
        r1 = (y) r2;
    L18:
        Tq(r1, SecondLevelTabViewSelectedType.SLIDE);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void initData() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.q;
        if (r0 == null) goto L5;
        r0.observeSelectedFirstLevelTabValueChange(this, new a(this));
    L5:
        V90();
        SecondLevelTabView r1 = this.i;
        if (r1 == null) goto L8;
        r1.setTabSelectedAction(new BaseFirstLevelTabFragment$initData$$inlined$apply$lambda$1(this));
        r1.setCreateCustomViewTabAction(W90());
        r1.r();
    L8:
        ScrollControlViewPager r2 = this.h;
        if (r2 == null) goto L11;
        r2.a = U90();
        r2.addOnPageChangeListener((BaseFirstLevelTabFragment$tabPageChangeListener$2.AnonymousClass1) this.l.getValue());
        r2.setOffscreenPageLimit(3);
        r2.setAdapter((KtvCommonPagerAdapter) this.k.getValue());
    L11:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = this.q;
        if (r3 == null) goto L16;
        List<y> r4 = r3.getSecondLevelTabDataList(VL().getValue());
        if (r4 == null) goto L16;
        fa0(r4);
    L16:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r5 = this.q;
        if (r5 == null) goto L20;
        r5.observeTabListDataChange(this, new b(this));
    L20:
        if (this.f == false) goto L22;
        i0.c().postDelayed(new c(this), this.e);
    L23:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r6 = this.q;
        if (r6 == null) goto L27;
        r6.observeTabListStateChange(this, new d(this));
        return;
    L27:
        return;
    L22:
        Z90();
        goto L23
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final void O0() {
        Iterator<T> r0 = Y90().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c) r0.next()).O0();
        goto L4
    }

    public Function1<Context, CustomViewTab> W90() {
        return BaseFirstLevelTabFragment$getCreateCustomViewTabAction$1.INSTANCE;
    }

    public com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c T90(y r3) {
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        int r1 = CommonDefaultSecondLevelTabFragment.n;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = this.q;
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        return new CommonDefaultSecondLevelTabFragment(r3, r2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment$getDefaultSecondLevelTabData$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment$getDefaultSecondLevelTabData$2] */
    public y X90(String r4) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.q;
        if (r0 == null) goto L5;
        final List<y> r1 = r0.getSecondLevelTabDataList(VL().getValue());
    L6:
        List<y> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return null;
    L15:
        ?? r5 = new BaseFirstLevelTabFragment$getDefaultSecondLevelTabData$1(r1);
        ?? r6 = new BaseFirstLevelTabFragment$getDefaultSecondLevelTabData$2(r1);
        y r7 = r5.invoke(this.p);
        if (r7 != null) goto L18;
        r7 = r5.invoke(r4);
    L18:
        if (r7 == null) goto L20;
        return r7;
    L20:
        return r6.invoke();
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final boolean ea0(y r5) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.q;
        if (r0 == null) goto L9;
        Pair<Integer, UpdateTabType> r1 = r0.getSelectedFirstLevelTabValue();
        if (r1 == null) goto L9;
        if (((Number) r1.getFirst()).intValue() != VL().getValue()) goto L9;
        boolean r2 = true;
    L10:
        if (r5 != null) goto L12;
    L16:
        return true;
    L12:
        if (r5.k != VL().getValue()) goto L16;
        if (r2 == false) goto L16;
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public final void fa0(List<y> r4) {
        if ((!Y90().isEmpty()) == false) goto L5;
        return;
    L5:
        Y90().clear();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.q;
        if (r0 == null) goto L13;
        List<y> r1 = r0.getSecondLevelTabDataList(VL().getValue());
        if (r1 == null) goto L13;
        Iterator<T> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        Y90().add(T90((y) r2.next()));
    L13:
        KtvCommonPagerAdapter r3 = (KtvCommonPagerAdapter) this.k.getValue();
        if (r3 == null) goto L16;
        ArrayList r5 = new ArrayList();
        r5.addAll(Y90());
        Unit r6 = Unit.INSTANCE;
        r3.f(r5);
    L16:
        Tq(X90(null), SecondLevelTabViewSelectedType.Default);
        Disposable r7 = xs2.b.a().b(com.bytedance.android.live.ktv.common.karaokestation.model.c.class).subscribe(new f(this));
        if (r7 == null) goto L19;
        S90(r7);
    L19:
        SecondLevelTabView r8 = this.i;
        if (r8 == null) goto L24;
        r8.setDataAndNotify(r4);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void initView(View r3) {
        ScrollControlViewPager r0 = null;
        if (r3 == null) goto L5;
        SecondLevelTabView r1 = (SecondLevelTabView) r3.findViewById(2131385682);
    L6:
        this.i = r1;
        if (r3 == null) goto L9;
        FrameLayout r2 = (FrameLayout) r3.findViewById(2131367812);
    L10:
        this.g = r2;
        if (r3 == null) goto L13;
        r0 = (ScrollControlViewPager) r3.findViewById(2131385681);
    L13:
        this.h = r0;
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public BaseFirstLevelTabFragment(String r2, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3) {
        this.p = r2;
        this.q = r3;
        this.e = ((Number) h.y1.getValue(null, h.a[127(0x7f, float:1.78E-43)])).longValue();
        if (bb0.b.a() != KtvMode.SOLO_KTV) goto L5;
        boolean r4 = true;
    L6:
        this.f = !r4;
        this.j = LazyKt.lazy(BaseFirstLevelTabFragment$secondLevelTabFragmentList$2.INSTANCE);
        this.k = LazyKt.lazy(new BaseFirstLevelTabFragment$secondLevelTabPagerAdapter$2(this));
        this.l = LazyKt.lazy(new BaseFirstLevelTabFragment$tabPageChangeListener$2(this));
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final void Tq(y r5, SecondLevelTabViewSelectedType r6) {
        Intrinsics.checkNotNullParameter(r6, "secondLevelTabViewSelectedType");
        if (r5 != null) goto L6;
        return;
    L6:
        if (r6 != SecondLevelTabViewSelectedType.CLICK) goto L12;
        int r0 = r5.n;
        ScrollControlViewPager r2 = this.h;
        if (r2 != null) goto L10;
    L17:
        boolean r1 = true;
    L19:
        if (VL().getValue() != r5.k) goto L36;
        if (r1 == false) goto L37;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = this.q;
        if (r3 == null) goto L24;
        r3.updateSecondLevelTabListState(r5, true);
    L24:
        ScrollControlViewPager r4 = this.h;
        if (r4 == null) goto L27;
        r4.h(r5.n, new BaseFirstLevelTabFragment$onSecondLevelTabViewSelected$1(this));
    L27:
        ca0(r5);
        int r7 = Y90().size();
        int r8 = r5.n;
        if (r8 < 0) goto L39;
        if (r7 <= r8) goto L38;
        SecondLevelTabView r9 = this.i;
        if (r9 == null) goto L34;
        r9.scrollToPosition(r8);
    L34:
        Y90().get(r5.n).rs(r6, r5);
        return;
    L38:
        return;
    L39:
        return;
    L37:
        return;
    L36:
        return;
    L10:
        if (r0 != r2.getCurrentItem()) goto L17;
    L12:
        if (r6 == SecondLevelTabViewSelectedType.Default) goto L17;
        if (r6 == SecondLevelTabViewSelectedType.SLIDE) goto L17;
        r1 = false;
        goto L19
    }

    public final void ba0(int r3, Function1<? super Boolean, Unit> r4) {
        ScrollControlViewPager r0 = this.h;
        if (r0 != null) goto L5;
    L19:
        ScrollControlViewPager r1 = this.h;
        if (r1 == null) goto L22;
        r1.h(r3, new BaseFirstLevelTabFragment$onSecondLevelTabPageSelected$1(this));
    L22:
        SecondLevelTabView r2 = this.i;
        if (r2 == null) goto L25;
        r2.scrollToPosition(r3);
    L25:
        aa0();
        if (r4 == null) goto L33;
        Unit r5 = (Unit) r4.invoke(Boolean.TRUE);
        return;
    L33:
        return;
    L5:
        if (r3 != r0.getCurrentItem()) goto L19;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r6 = this.q;
        if (r6 == null) goto L16;
        y r7 = r6.getSelectedSecondLevelTabData(VL().getValue());
        if (r7 == null) goto L16;
        if (r7.n != r3) goto L16;
        if (r4 == null) goto L29;
        Unit r8 = (Unit) r4.invoke(Boolean.FALSE);
        return;
    L29:
        return;
    L16:
        aa0();
        if (r4 == null) goto L31;
        Unit r9 = (Unit) r4.invoke(Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a
    public final void y40(View r2, View r3, View r4) {
        if ((r2 instanceof ViewGroup) == true) goto L5;
        r2 = null;
    L5:
        this.m = (ViewGroup) r2;
        this.n = r3;
        this.o = r4;
    }
}
