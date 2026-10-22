package com.bytedance.android.live.lynx.components;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.browser.jsbridge.upload.q;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.browser.webview.fragment.AbsHybridFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.monitor.LiveTraceSchemaMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.LynxHybridParamVo;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.base.ILiveBrowserActivity;
import com.bytedance.android.livesdkapi.base.ILiveWebCommonApi;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/lynx/components/LiveLynxFragment;", "Lcom/bytedance/android/live/browser/webview/fragment/AbsHybridFragment;", "Lcom/bytedance/android/live/browser/jsbridge/f;", "Ly6/d;", "", "<init>", "()V", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLynxFragment extends AbsHybridFragment implements y6.d {
    public static final /* synthetic */ int N = 0;
    public LynxThreadStrategy A;
    public y6.e B;
    public q C;
    public vl0.b D;
    public View E;
    public FrameLayout F;
    public RelativeLayout G;
    public int H;
    public boolean I;
    public boolean J;
    public long K;
    public d0 L;
    public final Lazy<LiveLynxFragment$mGlobalLayoutListener$1.a> M;
    public com.bytedance.android.live.lynx.api.c x;
    public LynxHybridParamVo y;
    public String z;

    public static final class a {
    }

    public static final class b extends d0 {
        public final /* synthetic */ LiveLynxFragment a;

        public final void a() {
            LiveLynxFragment r0 = this.a;
            int r1 = LiveLynxFragment.N;
            r0.W90();
            View r2 = this.a.E;
            if (r2 == null) goto L6;
            r2.setVisibility(8);
            return;
        }

        public b(LiveLynxFragment r1) {
            this.a = r1;
        }

        public final void b(LynxView r5) {
            Intrinsics.checkNotNullParameter(r5, "lynxView");
            d0 r0 = this.a.L;
            if (r0 == null) goto L5;
            r0.b(r5);
        L5:
            BaseHybridParamVo r1 = ((AbsHybridFragment) this.a).j;
            if (r1 != null) goto L8;
            return;
        L8:
            if (r1.h() != true) goto L20;
            final LiveLynxFragment r2 = this.a;
            r2.getClass();
            final ViewPager r6 = r2.V90(r5, LiveLynxFragment$handleNestedScrollWithVp$vp$1.INSTANCE);
            boolean r3 = r6 instanceof ViewPager;
            if (r3 == false) goto L21;
            final ArrayList r4 = new ArrayList();
            if (r3 == true) goto L14;
            ViewPager r7 = null;
        L15:
            ViewPager r8 = r7;
            if (r8 == null) goto L22;
            r8.addOnPageChangeListener(new LiveLynxFragment$handleNestedScrollWithVp$1(r2, r4, r6));
            return;
        L22:
            return;
        L14:
            r7 = r6;
            goto L15
        L21:
            return;
        }

        public final void d(View r9) {
            Intrinsics.checkNotNullParameter(r9, "lynxView");
            BaseMonitor.MonitorEventModule r1 = BaseMonitor.MonitorEventModule.HYBRID;
            LiveTraceSchemaMonitor.Status r2 = LiveTraceSchemaMonitor.Status.SUCCESS;
            LiveLynxFragment r0 = this.a;
            int r4 = LiveLynxFragment.N;
            String r5 = ((AbsHybridFragment) r0).h;
            JSONObject r6 = new JSONObject();
            r6.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.LYNX);
            Unit r3 = Unit.INSTANCE;
            LiveTraceSchemaMonitor.l(r1, r2, "Lynx页面加载成功", r5, "LiveLynxFragment", r6);
            d0 r7 = this.a.L;
            if (r7 == null) goto L5;
            r7.d(r9);
        L5:
            View r10 = this.a.E;
            int r8 = 8;
            if (r10 == null) goto L8;
            r10.setVisibility(8);
        L8:
            LiveLynxFragment r11 = this.a;
            if (((AbsHybridFragment) r11).j.g == false) goto L11;
        L17:
            UIUtils.setViewVisibility(((AbsHybridFragment) r11).m, 8);
        L18:
            LiveLynxFragment r12 = this.a;
            if (((AbsHybridFragment) r12).l != null) goto L21;
        L23:
            int r13 = p20.d.a;
            if (v.a() == false) goto L28;
            String r14 = p20.e.a;
            v.a();
            return;
        L28:
            return;
        L21:
            if (((AbsHybridFragment) r12).j.d() == true) goto L23;
            ((AbsHybridFragment) r12).l.setVisibility(0);
            goto L23
        L11:
            if ((r11.getActivity() instanceof ILiveBrowserActivity) == false) goto L17;
            View r15 = ((AbsHybridFragment) r11).m;
            if (((AbsHybridFragment) r11).j.j() == false) goto L16;
            r8 = 0;
        L16:
            UIUtils.setViewVisibility(r15, r8);
            goto L18
        }

        public final void g(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            d0 r0 = this.a.L;
            if (r0 == null) goto L5;
            r0.g(r2);
        L5:
            this.a.X90(true);
        }

        public final void c(LynxView r19, String r20) {
            Intrinsics.checkNotNullParameter(r19, "lynxView");
            d0 r3 = this.a.L;
            if (r3 == null) goto L5;
            r3.c(r19, r20);
        L5:
            View r1 = this.a.E;
            if (r1 == null) goto L9;
            r1.setVisibility(8);
        L9:
            if (r20 != null) goto L11;
            String r9 = "";
        L12:
            y50.i.m("lynx", null, ((AbsHybridFragment) this.a).h, "LiveLynxFragment#onLoadFailed()", 1, r9, null, 66);
            String r15 = ((AbsHybridFragment) this.a).h;
            JSONObject r2 = new JSONObject();
            r2.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.LYNX);
            Unit r4 = Unit.INSTANCE;
            LiveTraceSchemaMonitor.l(BaseMonitor.MonitorEventModule.HYBRID, LiveTraceSchemaMonitor.Status.HYBRID_LYNX_LOAD_FAIL, "Lynx页面加载失败：" + r20, r15, "LiveLynxFragment", r2);
            return;
        L11:
            r9 = r20;
            goto L12
        }

        public final void e(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            d0 r0 = this.a.L;
            if (r0 == null) goto L5;
            r0.e(r2, r3);
        L5:
            int r4 = p20.d.a;
            if (v.a() == false) goto L10;
            String r5 = p20.e.a;
            v.a();
            return;
        }

        public final void f(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            d0 r0 = this.a.L;
            if (r0 == null) goto L5;
            r0.f(r2, r3);
        L5:
            View r4 = this.a.E;
            if (r4 == null) goto L8;
            r4.setVisibility(8);
        L8:
            int r5 = p20.d.a;
            if (v.a() == false) goto L16;
            String r6 = p20.e.a;
            if (v.a() == true) goto L15;
            return;
        L15:
            return;
        }
    }

    static {
    }

    public final void U90() {
    }

    public final void W90() {
        boolean r0 = true;
        this.J = true;
        y50.i.m("lynx", null, ((AbsHybridFragment) this).h, "LiveLynxFragment#handleFallback()", 1, "Lynx fallback with no fallback_url!!", null, 66);
        BaseMonitor.MonitorEventModule r9 = BaseMonitor.MonitorEventModule.HYBRID;
        LiveTraceSchemaMonitor.Status r10 = LiveTraceSchemaMonitor.Status.HYBRID_LYNX_LOAD_FAIL;
        String r12 = ((AbsHybridFragment) this).h;
        JSONObject r14 = new JSONObject();
        r14.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.LYNX);
        Unit r1 = Unit.INSTANCE;
        LiveTraceSchemaMonitor.l(r9, r10, "Lynx页面加载失败:handleFallback", r12, "LiveLynxFragment", r14);
        if (this.L == null) goto L11;
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L7;
        r2.finish();
    L7:
        d0 r3 = this.L;
        if (r3 == null) goto L31;
        r3.a();
        return;
    L31:
        return;
    L11:
        Bundle r4 = getArguments();
        if (r4 == null) goto L28;
        String r5 = r4.getString("bundle_fallback_url");
        if (r5 == null) goto L28;
        if (r5.length() > 0) goto L19;
        r0 = false;
    L19:
        if (r0 == true) goto L22;
        r5 = null;
    L22:
        if (r5 == null) goto L28;
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L26;
        r6.finish();
    L26:
        jc1.k.n(IRoomService.class).actionHandler().handle(getActivity(), r5);
        return;
    L28:
        if (v.a() == false) goto L33;
        f2.c("Lynx fallback with no fallback_url!!", 0);
        return;
    }

    public final void fZ() {
    }

    public final void setOnPageLoadListener(ILiveWebCommonApi.OnPageLoadListener r1) {
    }

    public LiveLynxFragment() {
        this.A = LynxThreadStrategy.ALL_ON_UI;
        this.M = LazyKt.lazy(new LiveLynxFragment$mGlobalLayoutListener$1(this));
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.lynx.api.c r0 = this.x;
        if (r0 == null) goto L6;
        r0.release();
    L6:
        if (this.I == true) goto L14;
        if (this.J == true) goto L14;
        HashMap r1 = new HashMap();
        r1.put("type", "lynx");
        String r2 = this.z;
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        r1.put("path", r2);
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_profile_dismiss_while_loading", 0, SystemClock.uptimeMillis() - this.K, r1);
    L14:
        if (this.M.isInitialized() == false) goto L21;
        View r3 = getView();
        if (r3 == null) goto L22;
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        if (r4 == null) goto L23;
        r4.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) this.M.getValue());
        return;
    L23:
        return;
    L22:
        return;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.ui.BaseFragment*/.onPause();
        X90(false);
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.ui.BaseFragment*/.onResume();
        X90(true);
    }

    public final y6.e w1() {
        return this.B;
    }

    public final void DY(y6.e r1) {
        this.B = r1;
    }

    public final void T90(Bundle r7) {
        int r0 = com.bytedance.android.live.schema.helper.a.a;
        Integer r2 = null;
        if (r7 == null) goto L13;
        Object r4 = r7.get("hybrid_pop_vo");
        Object r5 = r7.get("hybrid_lynx_vo");
        if (r4 != null) goto L13;
        if (r5 != null) goto L13;
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", "HybridParamHelper->checkLynxFullVo: lynxHybridParamVo or commonVo is null");
        LynxHybridParamVo r6 = com.bytedance.android.live.schema.helper.a.c(r7.getString("url"), null, r7, null, false);
        r7.putParcelable("hybrid_lynx_vo", r6);
        if (r6 == null) goto L11;
        BaseHybridParamVo r8 = r6.b;
    L12:
        r7.putParcelable("hybrid_pop_vo", r8);
        goto L13
    L11:
        r8 = null;
    L13:
        super.T90(r7);
        if (r7 == null) goto L16;
        LynxHybridParamVo r1 = (LynxHybridParamVo) r7.getParcelable("hybrid_lynx_vo");
    L17:
        this.y = r1;
        StringBuilder r3 = new StringBuilder("LiveLynxFragment->initArgs: ");
        LynxHybridParamVo r9 = this.y;
        if (r9 == null) goto L20;
        String r10 = r9.toString();
    L21:
        r3.append(r10);
        ALogger.i("tag_hybrid_parse", r3.toString());
        this.z = UriProtector.parse(((AbsHybridFragment) this).h).getPath();
        if (r7 == null) goto L26;
        String r11 = r7.getString("arg_extra_data");
        if (r11 == null) goto L26;
        new JSONObject(r11);
    L26:
        LynxHybridParamVo r12 = this.y;
        if (r12 == null) goto L29;
        r2 = Integer.valueOf(r12.c());
    L29:
        if (r2 != null) goto L32;
    L34:
        if (r2 != null) goto L37;
    L39:
        if (r2 != null) goto L42;
    L44:
        if (r2 != null) goto L47;
        return;
    L47:
        if (r2.intValue() != 3) goto L53;
        this.A = LynxThreadStrategy.MULTI_THREADS;
        return;
    L53:
        return;
    L42:
        if (r2.intValue() != 2) goto L44;
        this.A = LynxThreadStrategy.PART_ON_LAYOUT;
        return;
    L37:
        if (r2.intValue() != 1) goto L39;
        this.A = LynxThreadStrategy.MOST_ON_TASM;
        return;
    L32:
        if (r2.intValue() != 0) goto L34;
        this.A = LynxThreadStrategy.ALL_ON_UI;
        return;
    L20:
        r10 = null;
        goto L21
    L16:
        r1 = null;
        goto L17
    }

    public final void X90(boolean r3) {
        JSONObject r0 = new JSONObject();
        r0.put("visible", r3);
        com.bytedance.android.live.lynx.api.c r4 = this.x;
        if (r4 == null) goto L6;
        r4.sendJsEvent("H5_visibilityChange", r0);
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.K = SystemClock.uptimeMillis();
    }

    public final View V90(View r5, Function1<? super View, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r6, "predicate");
        if (((Boolean) r6.invoke(r5)).booleanValue() == false) goto L6;
        return r5;
    L6:
        if ((r5 instanceof ViewGroup) == true) goto L8;
        return null;
    L8:
        ViewGroup r7 = (ViewGroup) r5;
        int r0 = r7.getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L14;
        View r3 = V90(r7.getChildAt(r2), r6);
        if (r3 != null) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return r3;
    L14:
        return null;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*com.bytedance.android.live.core.ui.BaseFragment*/.onViewCreated(r2, r3);
    }

    public final <T> void sendJsEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        com.bytedance.android.live.lynx.api.c r0 = this.x;
        if (r0 == null) goto L6;
        r0.sendJsEvent(r2, r3);
        return;
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        q r0 = this.C;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.onActivityResult(r2, r3, r4);
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        super/*androidx.fragment.app.Fragment*/.onCreateView(r10, r11, r12);
        View r13 = r10.inflate(2131566877, r11, false);
        if (r13 == null) goto L71;
        RelativeLayout r14 = (RelativeLayout) r13;
        this.G = r14;
        this.F = (FrameLayout) r14.findViewById(2131379282);
        RelativeLayout r15 = this.G;
        if (r15 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L7:
        ViewTreeObserver r16 = r15.getViewTreeObserver();
        if (r16 == null) goto L10;
        r16.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) this.M.getValue());
    L10:
        Integer r17 = null;
        if (((AbsHybridFragment) this).j.c() == true) goto L22;
        RelativeLayout r18 = this.G;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L15:
        View r19 = ((ViewStub) r18.findViewById(2131392592)).inflate();
        if (r19 == null) goto L18;
        View r110 = r19.findViewById(2131370123);
    L19:
        this.E = r110;
        if (r110 == null) goto L22;
        r110.setVisibility(0);
        goto L22
    L18:
        r110 = null;
    L22:
        vl0.b r111 = this.D;
        if (r111 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
    L25:
        w r2 = r111.a;
        if (r2 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L28:
        String r4 = ((AbsHybridFragment) this).h;
        LynxHybridParamVo r112 = this.y;
        if (r112 == null) goto L31;
        r17 = Integer.valueOf(r112.a);
    L31:
        com.bytedance.android.live.lynx.api.c r113 = r2.createAndLoad(this, r4, r17, this.A, ((AbsHybridFragment) this).i, new b(this));
        if (r113 == null) goto L66;
        FrameLayout r114 = this.F;
        if (r114 == null) goto L36;
        LynxView r1 = r113.getLynxView();
        r1.setScrollBarStyle(0);
        r1.setBackgroundColor(((AbsHybridFragment) this).g);
        Unit r3 = Unit.INSTANCE;
        r114.addView(r1, new FrameLayout.LayoutParams(-1, -1));
    L36:
        FrameLayout r115 = this.F;
        if (r115 == null) goto L39;
        r113.registerMethod("clipScreen", new h(r115, this, r113));
    L39:
        r113.registerMethod("shareInfo", new i(this));
        r113.registerMethod("sharePanel", new j(this));
        r113.registerMethod("upload", new k(this));
        Unit r116 = Unit.INSTANCE;
        this.x = r113;
        LynxHybridParamVo r117 = this.y;
        if (r117 != null) goto L42;
    L47:
        FrameLayout r118 = this.F;
        if (v.a() == true) goto L51;
    L58:
        String r119 = ((AbsHybridFragment) this).h;
        String r120 = p20.e.a;
        if (v.a() == false) goto L62;
        p20.e.a = r119;
    L62:
        RelativeLayout r121 = this.G;
        if (r121 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L65:
        return r121;
    L51:
        if (r118 == null) goto L53;
        TextView r5 = new TextView(getContext());
        r5.setText("Lynx");
        r5.setTextSize(1, 14.0f);
        r5.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r5.setBackgroundColor(ColorProtector.parseColor("#88008800"));
        r5.setOnClickListener(new g(this));
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 8388661;
        r118.addView(r5, r6);
    L53:
        if (r118 == null) goto L58;
        int r7 = p20.c.a;
        Context r8 = getContext();
        String r9 = ((AbsHybridFragment) this).h;
        String r20 = ((AbsHybridFragment) this).j.o;
        Intrinsics.checkNotNullParameter(r118, "viewGroup");
        Intrinsics.checkNotNullParameter(r9, "url");
        if (v.a() == false) goto L58;
        TextView r21 = new TextView(r8);
        r21.setText("Debug Tool-Live");
        r21.setBackgroundColor(ColorProtector.parseColor("#88008800"));
        r21.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        r21.setTextSize(1, 15.0f);
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(-2, -2);
        r122.topMargin = 300;
        r122.gravity = 8388659;
        r118.addView(r21, r122);
        r21.setOnClickListener(new p20.a(r9, r20));
        r21.setOnLongClickListener(new p20.b(r118));
        goto L58
    L42:
        if (r117.d() != true) goto L47;
        RelativeLayout r123 = this.G;
        if (r123 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L46:
        GradientDrawable r22 = new GradientDrawable();
        float r23 = t6.a(getContext(), 8.0f);
        r22.setCornerRadii(new float[]{r23, r23, r23, r23, 0.0f, 0.0f, 0.0f, 0.0f});
        r22.setGradientType(0);
        Context r0 = getContext();
        Intrinsics.checkNotNull(r0);
        r22.setColor(r0.getResources().getColor(2131109391));
        r123.setBackground(r22);
        goto L47
    L66:
        W90();
        RelativeLayout r124 = this.G;
        if (r124 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L69:
        return r124;
    L71:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }
}
