package com.ss.android.lark.location_ui.picklocation;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.google.android.material.appbar.AppBarLayout;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.service.IPickLocationMap;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.location_ui.widget.LoadingView;
import com.ss.android.lark.location_ui.widget.SearchBar;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LocationView extends com.ss.android.lark.location_ui.picklocation.a implements com.ss.android.lark.location_ui.picklocation.c {
    public static final String[] y = null;
    public static final Token z = null;
    public final Activity b;
    public boolean c;
    public final Token d;
    public final Scene e;
    public boolean f;
    public final POIConfig g;
    public final boolean h;
    public final boolean i;
    public String j;
    public com.ss.android.lark.location_ui.picklocation.c.a k;
    public iqb.a l;
    public iqb.a m;

    @BindView(7370)
    AppBarLayout mAppBarLayout;

    @BindView(7700)
    LinearLayout mContainerLayout;

    @BindView(7537)
    RelativeLayout mContentLayout;

    @BindView(7676)
    ImageView mIvLocatePosition;

    @BindView(7603)
    ImageView mIvLocationIcon;

    @BindView(7674)
    FrameLayout mMapContainerLayout;

    @BindView(7691)
    ListView mNearByListView;

    @BindView(7680)
    LoadingView mNearbyLoading;

    @BindView(7678)
    LinearLayout mRecommendEmptyView;

    @BindView(7675)
    FrameLayout mRecommendLayout;

    @BindView(7677)
    View mRecommendLineView;

    @BindView(7692)
    ListView mRecommendListView;

    @BindView(7682)
    LoadingView mRecommendLoading;

    @BindView(7874)
    NestedScrollView mScrollNear;

    @BindView(7877)
    SearchBar mSearchBar;

    @BindView(7683)
    CommonTitleBar mTitleBar;

    @BindView(8015)
    TextView mTvRequestPermission;
    public IPickLocationMap n;
    public final ArrayList<POIInfo> o;
    public int p;
    public boolean q;
    public Double r;
    public Double s;
    public final a t;
    public final b u;
    public final c v;
    public final d w;
    public ValueAnimator x;

    public class a implements f {
        public final /* synthetic */ LocationView a;

        public a(LocationView r1) {
            this.a = r1;
        }
    }

    public class b implements IPickLocationMap.b {
        public final /* synthetic */ LocationView a;

        public final void a() {
            this.a.mNearbyLoading.a();
            this.a.T();
        }

        public b(LocationView r1) {
            this.a = r1;
        }
    }

    public class c implements TextWatcher {
        public final /* synthetic */ LocationView a;

        public class a implements h {
            public final /* synthetic */ Editable a;
            public final /* synthetic */ c b;

            @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
            public final void a(com.ss.android.lark.location.service.k r14) {
                this.b.a.mRecommendListView.setVisibility(0);
                this.b.a.mRecommendLoading.setVisibility(8);
                LocationView r0 = this.b.a;
                List<POIInfo> r1 = r0.k.v5(!r0.g.isSelfDefine());
                if (TextUtils.isEmpty(this.a) == false) goto L5;
            L7:
                if (r1 != null) goto L9;
            L11:
                iqb.b.a(this.b.a.b, r14);
                return;
            L9:
                if (r1.size() < 0) goto L11;
                this.b.a.m.b(r1);
                goto L11
            L5:
                if (this.b.a.g.isSelfDefine() == false) goto L7;
                ListProtector.add(r1, 0, new POIInfo(this.a.toString(), this.b.a.b.getString(2131890381), 360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT, false, true));
                goto L7
            }

            @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
            public final void b(List<POIInfo> r14) {
                this.b.a.mRecommendListView.setVisibility(0);
                this.b.a.mRecommendLoading.setVisibility(8);
                if (r14 == null) goto L11;
                if (r14.size() <= 0) goto L11;
                if (this.b.a.g.isSelfDefine() == false) goto L9;
                ListProtector.add(r14, 0, new POIInfo(this.a.toString(), this.b.a.b.getString(2131890381), 360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT, false, true));
            L9:
                this.b.a.m.b(r14);
                return;
            L11:
                if (this.b.a.g.isSelfDefine() == false) goto L13;
                ArrayList r15 = new ArrayList();
                ListProtector.add(r15, 0, new POIInfo(this.a.toString(), this.b.a.b.getString(2131890381), 360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT, false, true));
                this.b.a.m.b(r15);
                return;
            L13:
                this.b.a.m.b(Collections.emptyList());
            }

            public a(c r1, Editable r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(LocationView r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r15) {
            this.a.mRecommendLayout.setVisibility(0);
            this.a.mRecommendLineView.setVisibility(0);
            this.a.mContentLayout.setVisibility(8);
            if (TextUtils.isEmpty(r15) == false) goto L7;
            LocationView r16 = this.a;
            this.a.m.b(r16.k.v5(!r16.g.isSelfDefine()));
            return;
        L7:
            if (this.a.g.isSelfDefine() == false) goto L16;
            iqb.a r0 = this.a.m;
            String r4 = r15.toString();
            if (r0.b != null) goto L11;
            r0.b = new ArrayList();
        L11:
            POIInfo r13 = new POIInfo(r4, r0.a.getString(2131890381), 360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT, false, true);
            if (r0.b.size() <= 0) goto L14;
            ListProtector.set(r0.b, 0, r13);
        L15:
            r0.notifyDataSetChanged();
            goto L16
        L14:
            r0.b.add(r13);
        L16:
            this.a.mRecommendListView.setVisibility(8);
            this.a.mRecommendLoading.b();
            LocationView r1 = this.a;
            r1.k.i6(r1.b, r15.toString(), this.a.e, new a(this, r15));
        }
    }

    public class d implements g {
        public final /* synthetic */ LocationView a;

        public d(LocationView r1) {
            this.a = r1;
        }
    }

    public class e extends i {
        public final /* synthetic */ LocationView a;

        public e(LocationView r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.location_ui.picklocation.LocationView.i, com.ss.android.lark.location_ui.picklocation.LocationView.h
        public final void a(com.ss.android.lark.location.service.k r3) {
            Log.i("LocationView", "queryLocation onSearchResultError called. errorCode:" + r3);
            this.a.mNearbyLoading.a();
            LocationView r0 = this.a;
            r0.q = true;
            r0.T();
            LocationView.o(this.a);
            if (this.a.k.isAdminGpsEnabled() == false) goto L8;
            LocationView r1 = this.a;
            if (r1.s(r1.b) == false) goto L9;
            iqb.b.a(this.a.b, r3);
            return;
        L9:
            return;
        }

        @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
        public final void b(List<POIInfo> r4) {
            Log.i("LocationView", "queryLocation onSearchResultSuccess called.");
            kqb.e.b(LocationHitPoint$ResultType.DEFAULT);
            if (r4 != null) goto L5;
        L7:
            this.a.mNearbyLoading.a();
            Activity r5 = this.a.b;
            int r0 = iqb.b.a;
            Intrinsics.checkNotNullParameter(r5, "context");
            UDToast.show(r5, 2131890586, 2131256189);
        L8:
            LocationView.o(this.a);
            return;
        L5:
            if (((ArrayList) r4).size() <= 0) goto L7;
            this.a.mNearByListView.setVisibility(0);
            this.a.mNearbyLoading.setVisibility(8);
            this.a.o.clear();
            this.a.o.addAll(r4);
            POIInfo r6 = (POIInfo) ListProtector.get(r4, 0);
            LocationView.k(this.a, r6, false);
            LocationView r7 = this.a;
            r7.l.b(r7.o);
            kqb.c.a(this.a.mNearByListView);
            this.a.mNearByListView.setSelection(0);
            this.a.T();
            this.a.p = 2;
            goto L8
        }
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
        void a(com.ss.android.lark.location.service.k r1);

        void b(List<POIInfo> r1);
    }

    public static abstract class i implements h {
        public i() {
        }

        @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
        public abstract void a(com.ss.android.lark.location.service.k r1);
    }

    public interface j {
    }

    static {
        y = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        z = new Token("LARK-PSDA-message_location_view_check_location_permission");
    }

    public final void C() {
        if (this.r != null) goto L5;
        return;
    L5:
        if (this.s == null) goto L9;
        this.mIvLocatePosition.setImageDrawable(AppCompatResources.getDrawable(this.b, 2131243869));
        this.n.a(this.r.doubleValue(), this.s.doubleValue());
        D(this.r.doubleValue(), this.s.doubleValue());
        this.mTitleBar.setRightVisible(true);
        this.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        return;
    }

    public final void T() {
        List<POIInfo> r0 = this.l.b;
        if (r0 != null) goto L5;
    L4:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L14;
        this.mTitleBar.setRightText(0, this.j, ContextCompat.getColor(this.b, 2131105548));
        this.mTitleBar.getRightText().setClickable(true);
        return;
    L14:
        this.mTitleBar.setRightText(0, this.j, ContextCompat.getColor(this.b, 2131103554));
        this.mTitleBar.getRightText().setClickable(false);
        return;
    L5:
        Iterator<POIInfo> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        if (r2.next().getIsCurrent() == false) goto L7;
        r1 = true;
        goto L11
    }

    public final void destroy() {
        IPickLocationMap r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onDestroy();
    }

    @Override // com.ss.android.lark.location_ui.picklocation.c
    public final boolean i5() {
        if (this.b != null) goto L7;
        return false;
    L7:
        return w();
    }

    @Override // com.ss.android.lark.location_ui.picklocation.c
    public final boolean onBackPressed() {
        if (this.b != null) goto L7;
        return false;
    L7:
        if (w() == false) goto L9;
        return true;
    L9:
        LocationFragment r0 = ((LocationFragment.a) this.a).a;
        int r2 = LocationFragment.k;
        Bundle r1 = r0.getArguments();
        if (r1 == null) goto L15;
        gqb.a r3 = hqb.a.a(r1.getString("location_unique_key")).a;
        if (r3 == null) goto L15;
        r3.b();
    L15:
        if (this.h == false) goto L19;
        Activity r4 = this.b;
        if (r4 == null) goto L24;
        r4.onBackPressed();
    L24:
        return true;
    L19:
        Activity r5 = this.b;
        if (r5 == null) goto L24;
        if (r5.isFinishing() == true) goto L24;
        this.b.finish();
        goto L24
    }

    public final boolean w() {
        KeyboardUtils.hideKeyboard(this.b);
        if (this.f == false) goto L6;
        this.mSearchBar.clearFocus();
        this.mTitleBar.setRightVisible(true);
        this.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        this.mRecommendListView.setVisibility(8);
        this.mContentLayout.setVisibility(0);
        this.f = false;
        return true;
    L6:
        return false;
    }

    public final void L() {
        T();
        this.mNearByListView.setVisibility(8);
        this.mNearbyLoading.b();
        iqb.a r0 = this.l;
        if (CollectionUtils.isEmpty(r0.b) == true) goto L6;
        r0.b.clear();
        r0.notifyDataSetChanged();
    L6:
        this.k.E2(this.n.e(), this.n.p());
        this.q = false;
        this.k.w6(this.b, this.e, new e(this), 0);
    }

    public final void create() {
        IPickLocationMap r0 = com.ss.android.lark.location.service.f.a().getPickLocationMap();
        this.n = r0;
        if (r0 == null) goto L5;
        ButterKnife.bind(this, ((LocationFragment.a) this.a).a.d);
        String r1 = this.g.getActionText();
        this.j = r1;
        if (TextUtils.isEmpty(r1) == false) goto L18;
        this.j = this.b.getString(2131892196);
    L18:
        this.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        this.mTitleBar.addAction(new p(this, this.j));
        int r2 = 0;
        this.mTitleBar.getRightText().setClickable(false);
        this.mTitleBar.setDividerVisible(false);
        this.mTitleBar.setLeftClickListener(new iqb.m(this));
        this.mTitleBar.setImmersive(true);
        this.mSearchBar.setStyle(2131952482);
        this.mSearchBar.setHint(2131890382);
        this.mSearchBar.setEditTextImeOptions(6);
        this.mSearchBar.setEditTextEnabled(false);
        ImageView r3 = this.mIvLocationIcon;
        if (kqb.d.a() == true) goto L22;
        r2 = 8;
    L22:
        r3.setVisibility(r2);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -1);
        this.n.j(IPickLocationMap.DarkMode.AUTO);
        View r5 = this.n.h(this.b);
        if (r5 == null) goto L25;
        this.mContainerLayout.addView(r5, r4);
    L25:
        SearchBar r6 = this.mSearchBar;
        c r7 = this.v;
        r6.b.addTextChangedListener(r7);
        this.mSearchBar.setOnFocusChangeListener(new s(this));
        this.mNearByListView.setOnItemClickListener(new t(this));
        this.mRecommendListView.setOnItemClickListener(new k(this));
        this.mIvLocatePosition.setOnClickListener(new iqb.e(this));
        this.mTvRequestPermission.setOnClickListener(new com.ss.android.lark.location_ui.picklocation.j(this));
        this.n.b();
        this.n.o(new l(this));
        this.n.m(new m(this));
        if (kqb.d.a() == false) goto L28;
        CoordinatorLayout.LayoutParams r8 = this.mAppBarLayout.getLayoutParams();
        AppBarLayout.Behavior r9 = new AppBarLayout.Behavior();
        r9.setDragCallback(new iqb.l());
        r8.setBehavior(r9);
    L28:
        View r10 = this.b.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L33;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r11 = ThreadMethodProxy.currentThread();
        if (r11 == com.larus.home.impl.utils.c.a) goto L33;
        com.larus.home.impl.utils.c.a(r11, "getDecorView");
    L33:
        r10.post(new iqb.c(this));
        iqb.a r12 = new iqb.a(this.b, new ArrayList());
        this.l = r12;
        this.mNearByListView.setAdapter(r12);
        this.m = new iqb.a(this.b, new ArrayList());
        this.mRecommendListView.setEmptyView(this.mRecommendEmptyView);
        this.mRecommendListView.setAdapter(this.m);
        this.mScrollNear.setOnScrollChangeListener(new iqb.o(this));
        return;
    L5:
        if (this.h == false) goto L9;
        Activity r13 = this.b;
        if (r13 == null) goto L35;
        r13.onBackPressed();
        return;
    L35:
        return;
    L9:
        Activity r14 = this.b;
        if (r14 != null) goto L12;
        return;
    L12:
        if (r14.isFinishing() == true) goto L38;
        this.b.finish();
        return;
    }

    public static void o(LocationView r9) {
        if (39.908823d == r9.n.e()) goto L5;
    L7:
        r9.T();
        r9.mNearByListView.setVisibility(8);
        r9.mNearbyLoading.b();
        r9.k.s5(r9.b, r9.n.e(), r9.n.p(), r9.e, r9.t);
        return;
    L5:
        if (116.39747d != r9.n.p()) goto L7;
        Log.i("LocationView", "getFromLocation called. default latLng.");
        r9.mSearchBar.setEditTextEnabled(true);
    }

    public final void P(String r3) {
        SearchBar r0 = this.mSearchBar;
        c r1 = this.v;
        r0.b.removeTextChangedListener(r1);
        this.mSearchBar.setText(r3);
        this.mSearchBar.setSelection(r3.length());
        SearchBar r4 = this.mSearchBar;
        c r2 = this.v;
        r4.b.addTextChangedListener(r2);
    }

    public final void p(final ValueCallback<Boolean> r11) {
        if (s(this.b) == false) goto L7;
        r11.onReceiveValue(Boolean.TRUE);
        return;
    L7:
        if (this.i == false) goto L10;
        com.ss.android.lark.utils.h.e(this.b, new iqb.g(r11), com.ss.android.lark.utils.m.a(2131890397, 2131890395), z, true, 2, 0, new com.ss.android.lark.utils.e(), new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        return;
    L10:
        new o0c.c(this.b).e(z, y).any(new iqb.h()).subscribe(new iqb.i(this, r11));
    }

    public final boolean s(Context r2) {
        if (ContextCompat.checkSelfPermission(r2, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
    L8:
        return true;
    L5:
        if (ContextCompat.checkSelfPermission(r2, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L8;
        return false;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.k = (com.ss.android.lark.location_ui.picklocation.c.a) r1;
    }

    public static void h(LocationView r3, int r4) {
        Iterator<POIInfo> r0 = r3.l.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setIsCurrent(false);
        goto L4
    L6:
        r3.l.a(r4).setIsCurrent(true);
        r3.mNearByListView.setSelection(r4);
        r3.l.notifyDataSetChanged();
        kqb.c.a(r3.mNearByListView);
        r3.T();
    }

    public final void D(double r8, double r10) {
        this.k.E2(r8, r10);
        this.n.f(r8, r10, this.u);
    }

    public static void k(LocationView r7, POIInfo r8, boolean r9) {
        r7.k.E2(r8.getLatitude(), r8.getLongitude());
        r7.c = false;
        if (r9 == false) goto L5;
        r7.n.f(r8.getLatitude(), r8.getLongitude(), null);
    L5:
        r7.k.U4(r7.b, r8, !r7.g.isSelfDefine());
        r7.mSearchBar.clearFocus();
    }

    public LocationView(FragmentActivity r2, LocationFragment.a r3, POIConfig r4, boolean r5, Token r6, Scene r7, boolean r8) {
        this.c = false;
        this.f = false;
        this.o = new ArrayList();
        this.p = 2;
        this.q = true;
        this.r = null;
        this.s = null;
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this);
        this.w = new d(this);
        this.b = r2;
        this.a = r3;
        this.g = r4;
        this.h = r5;
        this.d = r6;
        this.e = r7;
        this.i = r8;
    }
}
