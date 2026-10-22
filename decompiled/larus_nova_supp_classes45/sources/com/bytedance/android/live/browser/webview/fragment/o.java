package com.bytedance.android.live.browser.webview.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.di.H5Module_ProvideWebDialogFragmentFactory;
import com.bytedance.android.live.browser.t;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.schema.convert.HybridType;
import com.bytedance.android.live.schema.convert.HybridUiType;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.LynxHybridParamVo;
import com.bytedance.android.live.schema.vo.PopupHybridParamVo;
import com.bytedance.mt.protector.impl.UriProtector;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements n {
    public boolean A;
    public boolean B;
    public final int C;
    public BaseHybridParamVo.HybridType D;
    public final String E;
    public final JSONObject F;
    public final String G;
    public int H;
    public final boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public String M;
    public Provider<BaseWebDialogFragment> N;
    public final String O;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Integer j;
    public String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public t s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public int x;
    public boolean y;
    public String z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final BaseWebDialogFragment build() {
        Provider<BaseWebDialogFragment> r0 = this.N;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogProvider");
    L5:
        BaseWebDialogFragment r2 = (BaseWebDialogFragment) r0.get();
        Bundle r3 = new Bundle();
        String r1 = this.O;
        String r4 = this.M;
        int r5 = com.bytedance.android.live.schema.helper.a.a;
        Parcelable r6 = ka1.b.a(new ia1.b(r1, UriProtector.parse(r4), null, null), new ia1.a(HybridType.COMMON, HybridUiType.FULLSCREEN), false);     // Catch: Exception -> L11
        if ((r6 instanceof BaseHybridParamVo) == true) goto L9;
        r6 = null;
    L9:
        BaseHybridParamVo r7 = (BaseHybridParamVo) r6;     // Catch: Exception -> L11
    L13:
        if (r7 == null) goto L15;
        r7.F();
    L15:
        if (r7 == null) goto L17;
        BaseHybridParamVo.HybridType r8 = this.D;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.a = r8;
    L17:
        if (r7 == null) goto L19;
        r7.b = null;
    L19:
        if (r7 == null) goto L21;
        r7.c = this.k;
    L21:
        if (r7 == null) goto L23;
        r7.J(this.B);
    L23:
        if (r7 == null) goto L25;
        r7.K(this.x);
    L25:
        if (r7 == null) goto L27;
        r7.L(this.w);
    L27:
        if (r7 == null) goto L29;
        r7.I(this.z);
    L29:
        if (r7 == null) goto L31;
        r7.E();
    L31:
        if (r7 == null) goto L33;
        r7.N(this.y);
    L33:
        if (r7 == null) goto L35;
        r7.M(this.A);
    L35:
        if (r7 == null) goto L37;
        r7.d = this.j;
    L37:
        if (r7 == null) goto L43;
        Integer r9 = this.j;
        if (r9 == null) goto L41;
        int r11 = r9.intValue();
    L42:
        r7.l = r11;
        goto L43
    L41:
        r11 = -1;
    L43:
        if (r7 == null) goto L45;
        r7.S(this.O);
    L45:
        if (r7 == null) goto L47;
        r7.o = this.M;
    L47:
        LynxHybridParamVo r44 = new LynxHybridParamVo(this.E, this.H, this.L, this.K, false, null, 104);
        int r12 = this.a;
        int r13 = this.b;
        int r14 = this.c;
        int r15 = this.d;
        int r16 = this.e;
        int r17 = this.f;
        int r18 = this.g;
        int r19 = this.h;
        int r21 = this.i;
        boolean r22 = this.l;
        boolean r110 = this.m;
        boolean r111 = this.n;
        boolean r112 = this.o;
        boolean r113 = this.p;
        boolean r114 = this.q;
        boolean r115 = this.r;
        int r116 = this.t;
        int r117 = this.u;
        int r118 = this.v;
        int r119 = this.C;
        JSONObject r23 = this.F;
        if (r23 == null) goto L50;
        String r35 = r23.toString();
    L51:
        PopupHybridParamVo r120 = new PopupHybridParamVo(r12, r13, 0, 0, 0, 0, r14, r15, 0, r16, r17, r18, r19, r21, r22, r110, r111, r112, r113, r114, r115, r116, r117, r118, false, r119, 0, null, r35, this.G, this.I, this.J, this.K, 0.0f, 0, false, 0, r44, r7, false, null, 403177776, 3072);
        r3.putString("arg_url", this.O);
        r3.putString("arg_original_scheme", this.M);
        r3.putBoolean("abandon_coordinate", this.K);
        r3.putParcelable("hybrid_pop_vo", r120);
        Unit r24 = Unit.INSTANCE;
        r2.setArguments(r3);
        r2.T90(this.s);
        return r2;
    L50:
        r35 = null;
    L11:
        e = move-exception;
        com.bytedance.android.live.schema.api.utils.a.c("HybridParamHelper", e);
        r7 = null;
        goto L13
    }

    public o(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        this.O = r3;
        this.k = "";
        this.p = true;
        this.r = true;
        this.v = -1;
        this.w = true;
        this.C = -1;
        this.D = BaseHybridParamVo.HybridType.H5;
        this.E = "";
        this.G = "";
        this.I = true;
        this.J = true;
        this.M = "";
        BrowserServiceImpl.Companion.getClass();
        H5Module_ProvideWebDialogFragmentFactory r4 = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).l;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.N = r4;
    }

    public final o a(int r1) {
        this.j = Integer.valueOf(r1);
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o c(boolean r1) {
        this.K = r1;
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o d(int r1) {
        this.d = r1;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final BaseWebDialogFragment e(PopupHybridParamVo r4) {
        Provider<BaseWebDialogFragment> r0 = this.N;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogProvider");
    L5:
        BaseWebDialogFragment r1 = (BaseWebDialogFragment) r0.get();
        Bundle r2 = new Bundle();
        r2.putParcelable("hybrid_pop_vo", r4);
        r2.putString("arg_url", this.O);
        r2.putString("arg_original_scheme", this.M);
        r2.putBoolean("abandon_coordinate", this.K);
        Unit r5 = Unit.INSTANCE;
        r1.setArguments(r2);
        return r1;
    }

    public final o f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fromLabel");
        this.k = r2;
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o setHeight(int r1) {
        this.b = r1;
        return this;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o setWidth(int r1) {
        this.a = r1;
        return this;
    }

    public o(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        this(r2);
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this.E = r3;
        this.F = r4;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.n
    public final o b(int r1, int r2, int r3, int r4) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.h = r4;
        return this;
    }
}
