package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.commonui.KtvCommonEmptyView;
import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.view.ScrollControlViewPager;
import com.bytedance.android.live.ktv.common.ordersong.view.SongTextSwitcher;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.f;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/BaseSecondTabSubListFragment;", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/BaseSecondLevelTabFragment;", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseSecondTabSubListFragment extends BaseSecondLevelTabFragment {
    public ViewPager n;
    public TabLayout o;
    public SongTextSwitcher p;
    public SecondLevelSubTtabVpAdapter q;
    public final ArrayList<String> r;

    public abstract BaseSecondLevelTabFragment X90(y r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2);

    public void Z90(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sortType");
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public final int getLayoutId() {
        return 2131566455;
    }

    public BaseSecondTabSubListFragment() {
        this(new y(0, 0, 65535), null);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.BaseSecondLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final String Ms() {
        return this.k.c;
    }

    public final ArrayList<BaseSecondLevelTabFragment> Y90() {
        SecondLevelSubTtabVpAdapter r0 = this.q;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.BaseTabFragment
    public void initView(View r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        ViewPager r0 = r11.findViewById(2131388575);
        this.n = r0;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L8:
        if ((r0 instanceof ScrollControlViewPager) == true) goto L10;
        r0 = null;
    L10:
        ScrollControlViewPager r1 = (ScrollControlViewPager) r0;
        if (r1 == null) goto L13;
        r1.a = false;
    L13:
        this.o = r11.findViewById(2131388063);
        SongTextSwitcher r2 = (SongTextSwitcher) r11.findViewById(2131386993);
        r2.setSwitcherTextList(this.r);
        String r4 = (String) CollectionsKt.firstOrNull(this.r);
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r2.y(r4);
        r2.setOnTextSelectedListener(new BaseSecondTabSubListFragment$initView$$inlined$apply$lambda$1(this));
        Unit r5 = Unit.INSTANCE;
        this.p = r2;
        if (getHost() == null) goto L53;
        FragmentManager r3 = getChildFragmentManager();
        this.q = new SecondLevelSubTtabVpAdapter(r3);
        Iterator r6 = r3.getFragments().iterator();
        int r7 = 0;
    L20:
        if (r6.hasNext() == false) goto L53;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        Fragment r12 = (Fragment) r8;
        if ((r12 instanceof BaseSecondLevelTabFragment) == true) goto L27;
        r12 = null;
    L27:
        BaseSecondLevelTabFragment r13 = (BaseSecondLevelTabFragment) r12;
        if (r13 == null) goto L52;
        if (r13.l != null) goto L32;
    L34:
        boolean r14 = false;
    L35:
        if (r14 == true) goto L41;
        ArrayList<y> r15 = this.k.a;
        if (r15 == null) goto L41;
        y r16 = (y) KtvUtilsKt.K(r15, r7);
        if (r16 == null) goto L41;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r17 = this.l;
        Intrinsics.checkNotNullParameter(r16, "secondLevelTabData");
        r13.k = r16;
        r13.l = r17;
    L41:
        y r18 = r13.k.b;
        if (r18 == null) goto L52;
        y r19 = this.k;
        Intrinsics.checkNotNullParameter(r19, "compareData");
        if (Intrinsics.areEqual(r18.c, r19.c) != true) goto L52;
        ArrayList<BaseSecondLevelTabFragment> r21 = Y90();
        if (r21 != null) goto L48;
    L49:
        SecondLevelSubTtabVpAdapter r22 = this.q;
        if (r22 == null) goto L52;
        r22.f(r13);
        goto L52
    L48:
        if (r21.contains(r13) == true) goto L52;
    L32:
        if (TextUtils.isEmpty(r13.k.c) == false) goto L34;
        r14 = true;
    L52:
        r7 = r9;
    L53:
        ViewPager r23 = this.n;
        if (r23 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L56:
        r23.setAdapter(this.q);
        ViewPager r24 = this.n;
        if (r24 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L59:
        r24.addOnPageChangeListener(new AnonymousClass3(this));
        ArrayList<y> r25 = this.k.a;
        if (r25 == null) goto L79;
        Iterator<T> r26 = r25.iterator();
    L63:
        if (r26.hasNext() == false) goto L79;
        y r27 = (y) r26.next();
        ArrayList<BaseSecondLevelTabFragment> r28 = Y90();
        if (r28 == null) goto L74;
        Iterator<T> r29 = r28.iterator();
    L68:
        if (r29.hasNext() == false) goto L72;
        Object r31 = r29.next();
        if (Intrinsics.areEqual(((BaseSecondLevelTabFragment) r31).k.c, r27.c) == false) goto L68;
    L73:
        BaseSecondLevelTabFragment r32 = (BaseSecondLevelTabFragment) r31;
    L75:
        if (r32 != null) goto L63;
        BaseSecondLevelTabFragment r33 = X90(r27, this.l);
        SecondLevelSubTtabVpAdapter r34 = this.q;
        if (r34 == null) goto L63;
        r34.f(r33);
        goto L63
    L72:
        r31 = null;
        goto L73
    L74:
        r32 = null;
    L79:
        TabLayout r35 = this.o;
        if (r35 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L82:
        ViewPager r36 = this.n;
        if (r36 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L85:
        r35.setupWithViewPager(r36, true);
        if (Build.VERSION.SDK_INT < 29) goto L91;
        TabLayout r37 = this.o;
        if (r37 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L90:
        r37.setEdgeEffectColor(0);
    L91:
        TabLayout r38 = this.o;
        if (r38 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L94:
        r38.setTabRippleColor(null);
        SecondLevelSubTtabVpAdapter r39 = this.q;
        if (r39 == null) goto L97;
        r39.notifyDataSetChanged();
    L97:
        KtvCommonEmptyView r110 = (KtvCommonEmptyView) r11.findViewById(2131371607);
        this.h = r110;
        if (r110 == null) goto L100;
        r110.b(this.k.c, false);
    L100:
        ArrayList<y> r111 = this.k.a;
        if (r111 == null) goto L126;
        ViewPager r41 = this.n;
        if (r41 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L105:
        y r112 = (y) KtvUtilsKt.K(r111, r41.getCurrentItem());
        if (r112 == null) goto L127;
        r112.j = true;
        return;
    L127:
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.BaseSecondLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final Function3<List<MusicPanel>, List<Object>, y, Unit> ms(List<? extends Object> r1) {
        return BaseSecondTabSubListFragment$getFillAdapterDataAction$1.INSTANCE;
    }

    public BaseSecondTabSubListFragment(y r2, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
        super(r2, r3);
        ArrayList<String> r4 = new ArrayList();
        r4.add(f.b);
        r4.add(f.a);
        Unit r5 = Unit.INSTANCE;
        this.r = r4;
    }

    public final void aa0(final y r9, final Function3<? super List<MusicPanel>, ? super List<Object>, ? super y, Unit> r11) {
        ArrayList<BaseSecondLevelTabFragment> r0 = Y90();
        BaseSecondLevelTabFragment r1 = null;
        Object r2 = null;
        if (r0 == null) goto L11;
        Iterator<T> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((BaseSecondLevelTabFragment) r4).k.c, r9.c) == false) goto L6;
        r2 = r4;
    L10:
        r1 = (BaseSecondLevelTabFragment) r2;
    L11:
        if (r1 != null) goto L19;
        final BaseSecondLevelTabFragment r5 = X90(r9, this.l);
        SecondLevelSubTtabVpAdapter r6 = this.q;
        if (r6 == null) goto L15;
        r6.f(r5);
    L15:
        SecondLevelSubTtabVpAdapter r7 = this.q;
        if (r7 == null) goto L18;
        r7.notifyDataSetChanged();
    L18:
        UtilityKotlinExtentionsKt.s(0, false, true, new BaseSecondTabSubListFragment$updateSubTab$1(r5, r9, r11), 3);
        return;
    L19:
        r1.ok(r9, r11);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.BaseSecondLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public void ok(y r3, Function3<? super List<MusicPanel>, ? super List<Object>, ? super y, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "subTabData");
        Intrinsics.checkNotNullParameter(r4, "fillAdapterDataAction");
        if (r3.b == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        aa0(r3, r4);
        return;
    L9:
        if (r3.a() == true) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.k.c) == false) goto L14;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.k = r3;
    L14:
        if (Intrinsics.areEqual(r3.c, this.k.c) == false) goto L28;
        ArrayList<y> r5 = r3.a;
        if (r5 == null) goto L21;
        Iterator<T> r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L21;
        aa0((y) r6.next(), r4);
    L21:
        SecondLevelSubTtabVpAdapter r7 = this.q;
        if (r7 == null) goto L29;
        r7.notifyDataSetChanged();
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.BaseSecondLevelTabFragment, com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.c
    public final void rs(SecondLevelTabViewSelectedType r2, y r3) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabViewSelectedType");
        ViewPager r4 = this.n;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
    L5:
        int r5 = r4.getCurrentItem();
        ArrayList<BaseSecondLevelTabFragment> r0 = Y90();
        if (r0 == null) goto L11;
        BaseSecondLevelTabFragment r6 = (BaseSecondLevelTabFragment) KtvUtilsKt.K(r0, r5);
        if (r6 == null) goto L12;
        r6.rs(r2, r6.k);
        return;
    L12:
        return;
    }
}
