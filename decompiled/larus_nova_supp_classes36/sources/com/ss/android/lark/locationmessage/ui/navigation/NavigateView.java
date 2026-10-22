package com.ss.android.lark.locationmessage.ui.navigation;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.IView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.im.api.LocationInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class NavigateView implements IView {
    public static final String[] p = null;
    public static final Token q = null;
    public final ViewGroup a;
    public final Activity b;
    public final b c;
    public c d;
    public final Token e;
    public final Scene f;
    public final String g;
    public Message h;
    public final LocationInfo i;
    public String j;
    public Double k;
    public Double l;
    public final boolean m;

    @BindView(9432)
    View mBottomLayout;

    @BindView(9430)
    LinearLayout mContainerLayout;

    @BindView(9492)
    ImageView mIvBack;

    @BindView(9426)
    ImageView mIvGoToNavigate;

    @BindView(9427)
    ImageView mIvLocatePosition;

    @BindView(9493)
    ImageView mIvMore;

    @BindView(9439)
    TextView mTvNavigateDesc;

    @BindView(9440)
    TextView mTvNavigateTitle;

    @BindView(9992)
    TextView mTvRequestPermission;

    @BindView(9494)
    View mViewTitleBar;
    public final String[] n;
    public com.ss.android.lark.location.service.d o;

    public interface a {
    }

    public interface b {
    }

    static {
        p = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        q = new Token("LARK-PSDA-message_location_navigate_view_check_location");
    }

    public final void create() {
        if (this.c != null) goto L10;
        Activity r0 = this.b;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isFinishing() == true) goto L58;
        this.b.finish();
        return;
    L58:
        return;
    L10:
        LocationInfo r1 = this.i;
        if (r1 != null) goto L13;
        boolean r3 = false;
    L21:
        if (r3 == true) goto L28;
        Activity r2 = this.b;
        if (r2 != null) goto L25;
        return;
    L25:
        if (r2.isFinishing() == true) goto L60;
        this.b.finish();
        return;
    L60:
        return;
    L28:
        com.ss.android.lark.location.service.d r4 = com.ss.android.lark.location.service.f.a().getLocationMessageMap();
        this.o = r4;
        if (r4 != null) goto L36;
        Activity r5 = this.b;
        if (r5 != null) goto L33;
        return;
    L33:
        if (r5.isFinishing() == true) goto L62;
        this.b.finish();
        return;
    L62:
        return;
    L36:
        ButterKnife.bind(this, ((NavigateFragment.a) this.c).a.d);
        this.mIvGoToNavigate.setVisibility(0);
        Context r6 = lqb.b.a.getContext();
        POIInfo r8 = new POIInfo(oqb.c.a(this.i.getLatitude()), oqb.c.a(this.i.getLongitude()), this.i.getCoordinateSystem());
        r8.setLocationName(this.i.getName());
        r8.setLocationAddress(this.i.getDesc());
        r8.setZoomLevel(this.i.getZoomLevel());
        View r7 = this.o.q(r6, null, r8);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-1, -1);
        this.mContainerLayout.addView(r7, r9);
        if (TextUtils.isEmpty(this.i.getName()) == false) goto L39;
        String r10 = "";
    L40:
        this.mTvNavigateTitle.setText(r10);
        String r11 = this.i.getDesc();
        if (TextUtils.isEmpty(r11) == false) goto L43;
        this.mTvNavigateDesc.setVisibility(8);
    L44:
        this.mIvBack.setOnClickListener(new p(this));
        if (this.i.isHideTitleBar() == false) goto L47;
    L49:
        this.mIvMore.setVisibility(8);
    L50:
        this.mIvLocatePosition.setOnClickListener(new s(this));
        this.mTvRequestPermission.setOnClickListener(new k(this));
        this.mIvGoToNavigate.setOnClickListener(new t(this));
        this.o.b();
        View r12 = this.b.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L55;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r13 = ThreadMethodProxy.currentThread();
        if (r13 == com.larus.home.impl.utils.c.a) goto L55;
        com.larus.home.impl.utils.c.a(r13, "getDecorView");
    L55:
        r12.post(new i(this));
        return;
    L47:
        if (this.i.isSecretChat() == true) goto L49;
        this.mIvMore.setVisibility(0);
        this.mIvMore.setOnClickListener(new q(this));
        goto L50
    L43:
        this.mTvNavigateDesc.setVisibility(0);
        this.mTvNavigateDesc.setText(r11);
        goto L44
    L39:
        r10 = this.i.getName();
        goto L40
    L13:
        this.h = r1.getMessage();
        this.j = ((NavigateFragment.a) this.c).a.g;
        this.n[0] = this.b.getString(2131891775);
        r3 = true;
        if (this.m == false) goto L20;
        String[] r14 = this.n;
        if (this.j != null) goto L18;
        String r15 = this.b.getString(2131892148);
    L19:
        r14[1] = r15;
        this.n[2] = this.b.getString(2131891541);
        goto L21
    L18:
        r15 = this.b.getString(2131892127);
        goto L19
    L20:
        this.n[1] = this.b.getString(2131891541);
        goto L21
    }

    public final void destroy() {
        com.ss.android.lark.location.service.d r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onDestroy();
    }

    public final void h(final ValueCallback<Boolean> r4) {
        Activity r0 = this.b;
        if (ContextCompat.checkSelfPermission(r0, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r4.onReceiveValue(Boolean.TRUE);
        return;
    L12:
        new o0c.c(this.b).e(q, p).any(new l()).subscribe(new m(this, r4));
        return;
    L5:
        if (ContextCompat.checkSelfPermission(r0, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.d = (c) r1;
    }

    public NavigateView(FragmentActivity r1, View r2, Token r3, Scene r4, NavigateFragment.a r5, LocationInfo r6, String r7) {
        this.b = r1;
        this.a = (ViewGroup) r2;
        this.c = r5;
        this.i = r6;
        this.e = r3;
        this.f = r4;
        this.g = r7;
        boolean r8 = !LarkAppContext.inst().buildConfig().isOfficeSDK();
        this.m = r8;
        if (r8 == false) goto L5;
        int r9 = 3;
    L6:
        this.n = new String[r9];
        return;
    L5:
        r9 = 2;
        goto L6
    }
}
