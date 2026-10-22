package com.bytedance.android.live.browser.webview.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.container.HybridContainerManager;
import com.bytedance.android.live.browser.utils.LiveImmersedStatusBarUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.base.ILiveBrowserActivity;
import com.bytedance.android.livesdkapi.base.ILiveWebCommonApi;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class AbsHybridFragment extends BaseFragment implements v40.c, ILiveWebCommonApi, com.bytedance.android.live.browser.jsbridge.f {
    public static final /* synthetic */ int w = 0;
    public boolean d;
    public boolean e;
    public g f;
    public int g;
    public String h;
    public String i;
    public BaseHybridParamVo j;
    public View k;
    public View l;
    public View m;
    public View n;
    public View o;
    public TextView p;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public final String v;

    public void U90() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.f
    public <T> void sendJsEvent(String r1, T r2) {
    }

    public final void close() {
        BaseHybridParamVo r0 = this.j;
        if (r0.i == false) goto L8;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L23;
        r1.finish();
        return;
    L23:
        return;
    L8:
        if (r0.g == true) goto L10;
        return;
    L10:
        if (getParentFragment() != null) goto L12;
        return;
    L12:
        if ((getParentFragment() instanceof DialogFragment) == true) goto L21;
        return;
    L21:
        getParentFragment().dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L28;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public AbsHybridFragment() {
        this.d = false;
        this.e = false;
        this.g = 0;
        Lazy r0 = HybridContainerManager.a;
        this.v = UUID.randomUUID().toString();
    }

    public final Activity getCurrentActivity() {
        return getActivity();
    }

    public final boolean isFullScreen() {
        if ((getActivity() instanceof ILiveBrowserActivity) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.j.g == false) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        int r0 = t20.a.a;
        xm0.a r2 = new xm0.a(this.h, this.v);
        ALogger.i("HybridEvent", r2.toString());
        xs2.b.a().post(r2);
        xs2.b.a().post(new h1(48));
        Lazy r1 = HybridContainerManager.a;
        String r3 = this.v;
        Intrinsics.checkNotNullParameter(r3, "containerId");
        ((HashMap) HybridContainerManager.a.getValue()).remove(r3);
        ((ArrayList) p20.e.b).clear();
        ((ArrayList) p20.e.c).clear();
        p20.e.a = "";
        ALogger.i("DebugHybridTools", "finishRecord");
        this.d = false;
        View r4 = this.u;
        if (r4 == null) goto L8;
        g r5 = this.f;
        if (r5 == null) goto L9;
        r4.removeOnLayoutChangeListener(r5);
        return;
    L9:
        return;
    }

    public final String getContainerId() {
        return this.v;
    }

    public void T90(Bundle r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        BaseHybridParamVo r7 = r6.getParcelable("hybrid_pop_vo");
        this.j = r7;
        if (r7 != null) goto L7;
        return;
    L7:
        this.i = r7.o;
        String r8 = r7.z();
        this.h = r8;
        Uri r9 = UriProtector.parse(r8);
        UriProtector.parse(this.i);
        String r0 = this.j.D();
        int r1 = this.j.l;
        int r2 = ColorProtector.parseColor("#00FFFFFF");
        if (r1 != (-1)) goto L11;
        r1 = r2;
    L11:
        if (r9 != null) goto L29;
    L26:
        r2 = r1;
    L27:
        this.g = r2;
        return;
    L29:
    L24:
        e = move-exception;
        ALogger.e("AbsHybridParamHelper", e);
        goto L27
    L13:
        if (TextUtils.isEmpty(r0) == true) goto L26;
        if (r0 != null) goto L16;
    L22:
        r2 = Color.parseColor(r0);     // Catch: Exception -> L24
        goto L27
    L16:
        if (r0.startsWith("#") == true) goto L22;
        if ("white".equals(r0) == true) goto L22;
        if ("black".equals(r0) == true) goto L22;
        r0 = "#".concat(r0);     // Catch: Exception -> L24
        goto L22
    }

    public final void onActivityCreated(Bundle r7) {
        super.onActivityCreated(r7);
        View r8 = getView();
        if (r8 == null) goto L72;
        this.k = r8.findViewById(2131389362);
        this.m = r8.findViewById(2131389443);
        this.n = r8.findViewById(2131389444);
        this.o = r8.findViewById(2131389445);
        this.l = r8.findViewById(2131388807);
        this.q = r8.findViewById(2131363762);
        this.p = (TextView) r8.findViewById(2131388772);
        this.r = r8.findViewById(2131364832);
        this.t = r8.findViewById(2131383440);
        this.s = r8.findViewById(2131383441);
        if (this.p == null) goto L10;
        TextView r9 = (TextView) this.l.findViewById(2131388772);
        this.p = r9;
        r9.setText(null);
        String r11 = this.j.s();
        TextView r0 = this.p;
        if (r0 == null) goto L10;
        r0.setText(r11);
    L10:
        View r12 = this.m;
        if (r12 == null) goto L15;
        UIUtils.setViewVisibility(r12, 8);
        this.m.setOnClickListener(new a(this));
        if (isFullScreen() == false) goto L15;
        UIUtils.updateLayoutMargin(this.m, -3, (int) UIUtils.dip2Px(getContext(), 30.0f), -3, -3);
    L15:
        View r13 = this.q;
        if (r13 == null) goto L18;
        r13.setOnClickListener(new b(this));
    L18:
        View r14 = this.n;
        if (r14 != null) goto L21;
    L25:
        View r15 = this.o;
        if (r15 != null) goto L28;
    L34:
        View r16 = this.r;
        if (r16 == null) goto L38;
        r16.setOnClickListener(new d(this));
    L38:
        if (this.t == null) goto L55;
        if (this.s == null) goto L55;
        if (this.j.i() == false) goto L45;
    L53:
        this.s.setVisibility(8);
        goto L55
    L45:
        if (this.j.h() == false) goto L53;
        this.s.setVisibility(0);
        if ("white".equals(this.j.g()) == false) goto L50;
        this.t.setBackgroundResource(2131249779);
        goto L55
    L50:
        if ("dark".equals(this.j.g()) == false) goto L52;
        this.t.setBackgroundResource(2131249778);
        goto L55
    L52:
        this.t.setBackgroundResource(2131249779);
    L55:
        if (this.l != null) goto L57;
    L61:
        View r17 = this.k;
        if (r17 == null) goto L64;
        r17.setVisibility(8);
    L64:
        isFullScreen();
        if (h.a(this.h) == false) goto L72;
        if (fm3.d.b() == false) goto L72;
        this.l.setBackgroundResource(2131250013);
        this.p.setTextColor(-16777216);
        View r18 = this.q;
        if ((r18 instanceof TextView) == false) goto L71;
        ((TextView) this.q).setCompoundDrawables(getContext().getResources().getDrawable(2131248915), null, null, null);
        goto L72
    L71:
        r18.setBackgroundResource(2131248915);
        goto L72
    L57:
        if (this.p == null) goto L61;
        if (this.j.d() == false) goto L61;
        this.l.setVisibility(8);
        this.p.setVisibility(8);
        goto L61
    L28:
        if (this.j.a() == false) goto L30;
        int r5 = 0;
    L31:
        UIUtils.setViewVisibility(r15, r5);
        this.o.setOnClickListener(new c(this));
        if (isFullScreen() == false) goto L34;
        UIUtils.updateLayoutMargin(this.o, -3, (int) UIUtils.dip2Px(getContext(), 30.0f), -3, -3);
        goto L34
    L30:
        r5 = 8;
        goto L31
    L21:
        if (this.j.k() == false) goto L23;
        int r6 = 0;
    L24:
        UIUtils.setViewVisibility(r14, r6);
        this.n.setOnClickListener(new e(this));
        goto L25
    L23:
        r6 = 8;
    L72:
        setCloseByGesture(!this.j.b());
        this.d = true;
        View r19 = getView();
        this.u = r19;
        if (r19 == null) goto L80;
        this.f = new g(this);
        if ((r19.getParent() instanceof ViewGroup) == false) goto L79;
        ((ViewGroup) this.u.getParent()).addOnLayoutChangeListener(this.f);
        return;
    L79:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public void onCreate(Bundle r11) {
        super.onCreate(r11);
        T90(getArguments());
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L67;
        String r4 = "#FFFFFFFF";
        if (this.j.r() == false) goto L26;
        boolean r0 = fm3.d.b();
        BaseHybridParamVo r5 = this.j;
        if (r0 == false) goto L9;
        String r6 = "black";
    L10:
        r5.R(r6);
        BaseHybridParamVo r7 = this.j;
        if (r0 == false) goto L13;
        String r8 = "white";
    L14:
        r7.O(r8);
        if (r0 == true) goto L18;
        r4 = "#00000000";
    L18:
        this.g = ColorProtector.parseColor(r4);
        if ("white".equals(this.j.q()) == false) goto L22;
        LiveImmersedStatusBarUtils.f(r12);
    L24:
        LiveImmersedStatusBarUtils.c(r12);
        h.b(r12, this.j.o());
    L44:
        BaseHybridParamVo r1 = this.j;
        if (r1.i == true) goto L47;
    L57:
        BaseHybridParamVo r2 = this.j;
        if (r2.i == false) goto L67;
        if (r2.t() == false) goto L67;
        String r3 = this.j.q();
        IESStatusBarUtil.transparencyBar(r12);
        if ("white".equals(r3) == false) goto L65;
        LiveImmersedStatusBarUtils.f(r12);
        goto L67
    L65:
        if ("black".equals(r3) == false) goto L67;
        LiveImmersedStatusBarUtils.g(r12);
        goto L67
    L47:
        if (r1.e() == false) goto L57;
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getActivity(), false, false) == false) goto L56;
        String r9 = this.j.q();
        IESStatusBarUtil.transparencyBar(r12);
        if ("white".equals(r9) == false) goto L54;
        LiveImmersedStatusBarUtils.f(r12);
        goto L67
    L54:
        if ("black".equals(r9) == false) goto L67;
        LiveImmersedStatusBarUtils.g(r12);
        goto L67
    L56:
        StatusBarUtil.hideStatusBar(getActivity());
        goto L67
    L22:
        if ("black".equals(this.j.q()) == false) goto L24;
        LiveImmersedStatusBarUtils.g(r12);
        goto L24
    L13:
        r8 = "black";
        goto L14
    L9:
        r6 = "white";
        goto L10
    L26:
        if (h.a(this.h) == true) goto L28;
    L30:
        boolean r13 = false;
    L31:
        String r14 = this.j.q();
        String r15 = this.j.o();
        boolean r16 = this.j.e();
        boolean r17 = this.j.t();
        if (r13 == false) goto L35;
        LiveImmersedStatusBarUtils.g(r12);
        LiveImmersedStatusBarUtils.c(r12);
        h.b(r12, "#FFFFFFFF");
        goto L44
    L35:
        if ("white".equals(r14) == false) goto L38;
        LiveImmersedStatusBarUtils.f(r12);
        LiveImmersedStatusBarUtils.c(r12);
    L43:
        h.b(r12, r15);
        goto L44
    L38:
        if ("black".equals(r14) == false) goto L43;
        LiveImmersedStatusBarUtils.g(r12);
        if (r16 == true) goto L43;
        if (r17 == true) goto L43;
        LiveImmersedStatusBarUtils.c(r12);
        goto L43
    L28:
        if (fm3.d.b() == false) goto L30;
        r13 = true;
    L67:
        Lazy r18 = HybridContainerManager.a;
        String r19 = this.v;
        Intrinsics.checkNotNullParameter(r19, "containerId");
        Intrinsics.checkNotNullParameter(this, KtvSubElement.CONTAINER);
        Lazy r21 = HybridContainerManager.a;
        if (((HashMap) r21.getValue()).containsKey(r19) == true) goto L71;
        ((HashMap) r21.getValue()).put(r19, new WeakReference(this));
        return;
    }

    @Override // v40.a
    public final void setCloseByGesture(final boolean r3) {
        View r0 = getView();
        if (r0 == null) goto L6;
        r0.setFocusableInTouchMode(true);
        r0.requestFocus();
        r0.setOnKeyListener(new f(r3));
        return;
    }

    public final void setHybridTitle(String r2) {
        TextView r0 = this.p;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public static void S90(AbsHybridFragment r2, boolean r3) {
        r2.getClass();
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L5
        r0.put("visible", r3);     // Catch: JSONException -> L5
        r2.sendJsEvent("H5_keyboardStatusChange", r0);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        b0 r4 = b0.o();
        StringBuilder r1 = new StringBuilder("sendKeyboardJsEvent error: ");
        if (TextUtils.isEmpty(e.getMessage()) == true) goto L9;
        String r5 = e.getMessage();
    L10:
        r1.append(r5);
        String r6 = r1.toString();
        r4.getClass();
        com.bytedance.android.live.core.log.g.a("AbsHybridFragment", r6);
        return;
    L9:
        r5 = "";
        goto L10
    }
}
