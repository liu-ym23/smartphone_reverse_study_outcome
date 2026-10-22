package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.JsbAuthInfo;
import com.ss.android.lark.chameleon.jsbauth.AuthErrorCode;
import com.ss.android.lark.chameleon.jsbauth.AuthSuccessCode;
import com.ss.android.lark.chameleon.jsbauth.JsbAuthResult;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonSafeReuseWeb;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonFragmentV2;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;
import tb5.i;
import xwb.e;
import xwb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends e {
    public final ChameleonWebView a;

    public a(ChameleonWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.a = r2;
    }

    public final boolean a(OfficeWebView r14, Message r15) {
        Intrinsics.checkNotNullParameter(r14, "webview");
        Intrinsics.checkNotNullParameter(r15, "msg");
        int r0 = w1b.a.a;
        int r1 = g.a;
        if (g.a.a("chameleon.webview.jsb.auth.enable") == true) goto L7;
        super.a(r14, r15);
        return true;
    L7:
        if (this.a.getJsbAuthManager().a() == true) goto L10;
        super.a(r14, r15);
        return true;
    L10:
        p0b.a r2 = this.a.getJsbAuthManager();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r15, "message");
        Intrinsics.checkNotNullParameter(r14, "webView");
        j.a("CML_TAG_JsbAuthManager", "doAuth message: " + r15 + ", url: " + r2.b.getLoadUrl());
        if (r2.a() == true) goto L13;
        Intrinsics.checkNotNullParameter(AuthSuccessCode.Companion, "<this>");
        JsbAuthResult r16 = new JsbAuthResult(new AuthSuccessCode(4, "disable auth"));
    L110:
        r2.b.post(new p0b.b(r2, r15, r16));
        return r16.getPassed();
    L13:
        String r3 = r15.getApiName();
        String r5 = BuildConfig.FLAVOR;
        if (r3 != null) goto L17;
        r3 = BuildConfig.FLAVOR;
    L17:
        if (r3.length() != 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
        Intrinsics.checkNotNullParameter(AuthSuccessCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthSuccessCode(102, "no api name, biz handle it self"));
        goto L110
    L22:
        ChameleonWebView r7 = r2.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "handlerName");
        ChameleonFragmentV2 r8 = r7.getFragment();
        Object r10 = null;
        if ((r8 instanceof ChameleonFragmentV2) == false) goto L25;
        ChameleonFragmentV2 r9 = r8;
    L26:
        if (r9 == null) goto L30;
        Intrinsics.checkNotNullParameter(r3, "handlerName");
        ChameleonSafeReuseWeb r11 = r9.n;
        if (r11 == null) goto L30;
        i r12 = (i) ((HashMap) r11.m).get(r3);
    L31:
        if (r12 == null) goto L36;
        BridgeAuthType r13 = r12.authType();
        if (r13 == null) goto L36;
        String r17 = r13.getAuthType();
        if (r17 == null) goto L36;
    L42:
        if (r17 != null) goto L44;
        Intrinsics.checkNotNullParameter(AuthSuccessCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthSuccessCode(103, "no handler to solve jsb, biz handle it self"));
        goto L110
    L44:
        com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType.Companion.getClass();
        com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType[] r18 = com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType.values();
        int r19 = r18.length;
        int r20 = 0;
    L45:
        if (r20 >= r19) goto L50;
        com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType r110 = r18[r20];
        if (Intrinsics.areEqual(r110.getAuthType(), r17) == true) goto L51;
        r20 = r20 + 1;
    L51:
        if (r110 != null) goto L54;
        Intrinsics.checkNotNullParameter(AuthSuccessCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthSuccessCode(0, "un set"));
        goto L110
    L54:
        if (r110 != com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType.Public) goto L56;
        Intrinsics.checkNotNullParameter(AuthSuccessCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthSuccessCode(2, "call public method"));
        goto L110
    L56:
        ArrayList<JsbAuthInfo> r111 = r2.a.getJsbAuthInfoList();
        if (r111.isEmpty() == false) goto L112;
        Intrinsics.checkNotNullParameter(AuthSuccessCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthSuccessCode(101, "no jsb auth info config"));
        goto L110
    L112:
        String r21 = r15.getExtra();     // Catch: Exception -> L64
        if (r21 == null) goto L66;
        String r4 = new JSONObject(r21).optString("chameleonJsbAuthToken");     // Catch: Exception -> L64
    L67:
        if (r4 != null) goto L70;
        r4 = BuildConfig.FLAVOR;
    L70:
        if (TextUtils.isEmpty(r4) == false) goto L72;
        Intrinsics.checkNotNullParameter(AuthErrorCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthErrorCode(-6, "token is empty"));
        goto L110
    L72:
        String r22 = r2.c.get(r4);
        if (r22 == null) goto L77;
        r5 = r22;
    L77:
        if (TextUtils.isEmpty(r5) == false) goto L79;
        Intrinsics.checkNotNullParameter(AuthErrorCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthErrorCode(-7, "url is empty"));
        goto L110
    L79:
        Iterator<T> r112 = r111.iterator();
    L81:
        if (r112.hasNext() == false) goto L85;
        Object r23 = r112.next();
        if (new Regex(((JsbAuthInfo) r23).getPattern()).matches(r5) == false) goto L81;
        r10 = r23;
    L85:
        JsbAuthInfo r113 = (JsbAuthInfo) r10;
        if (r113 != null) goto L89;
        Intrinsics.checkNotNullParameter(AuthErrorCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthErrorCode(-2, "not a safe url, because jsb auth info not match"));
        goto L110
    L89:
        if (r113.getExcludedMethods().contains(r3) == false) goto L92;
        Intrinsics.checkNotNullParameter(AuthErrorCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthErrorCode(-3, "method in exclude methods"));
        goto L110
    L92:
        if (r113.getIncludedMethods().contains(r3) == false) goto L94;
        Intrinsics.checkNotNullParameter(AuthSuccessCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthSuccessCode(1, "call include method"));
        goto L110
    L94:
        int r114 = p0b.a.b.b[r110.ordinal()];
        if (r114 != 1) goto L97;
        Intrinsics.checkNotNullParameter(AuthSuccessCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthSuccessCode(2, "call public method"));
        goto L110
    L97:
        if (r114 == 2) goto L102;
        if (r114 != 3) goto L101;
        Intrinsics.checkNotNullParameter(AuthErrorCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthErrorCode(-4, "method is secure, and not in include method"));
        goto L110
    L101:
        throw new NoWhenBranchMatchedException();
    L102:
        int r115 = p0b.a.b.a[r113.getGroup().ordinal()];
        if (r115 == 1) goto L108;
        if (r115 != 2) goto L107;
        Intrinsics.checkNotNullParameter(AuthErrorCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthErrorCode(-5, "method < rule"));
        goto L110
    L107:
        throw new NoWhenBranchMatchedException();
    L108:
        Intrinsics.checkNotNullParameter(AuthSuccessCode.Companion, "<this>");
        r16 = new JsbAuthResult(new AuthSuccessCode(3, "call private domains method"));
    L66:
        r4 = null;
    L64:
        e = move-exception;
        j.d("CML_TAG_JsbAuthManager", e);
        goto L66
    L50:
        r110 = null;
    L36:
        xwb.a r116 = r14.getBridge();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r3, "handlerName");
        f r117 = (f) ((ConcurrentHashMap) r116.b.a).get(r3);
        if (r117 == null) goto L41;
        com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType r118 = r117.authType();
        if (r118 == null) goto L41;
        r17 = r118.getAuthType();
    L41:
        r17 = null;
    L30:
        r12 = null;
        goto L31
    L25:
        r9 = null;
        goto L26
    L19:
        r6 = false;
        goto L20
    }
}
