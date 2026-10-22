package com.ss.android.common.applog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.tool.BtmDebugTool;
import com.bytedance.common.utility.NetClientChecker;
import jta.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class g0 {
    public static void a(h0 r3) {
        if (NetClientChecker.isNetworkClientSet() == false) goto L59;
        eta.b r0 = r3.d;
        AppLog.g0.b(r0);
        j0 r1 = r3.e;
        r3.getContext();
        if (r1 != null) goto L7;
    L15:
        String r2 = r3.f;
        if (TextUtils.isEmpty(r2) == true) goto L20;
        g.j.w(r2);
        if (g.f() == false) goto L20;
        g.i.getClass();
        kta.u.f = r2;
    L20:
        Bundle r4 = r3.g;
        if (r4 == null) goto L23;
        AppLog.g0.d(r4);
    L23:
        AppLog$f r5 = r3.h;
        if (r5 == null) goto L26;
        AppLog.g0.u(r5);
    L26:
        String r6 = r3.d.getChannel();
        if (TextUtils.isEmpty(r6) == true) goto L57;
        if (AppLog.E0 == true) goto L55;
        g.j.setChannel(r6);
        if (g.f() == false) goto L34;
        g.i.getClass();
        kta.u.a = r6;
    L34:
        if (TextUtils.isEmpty(r3.getContext().getPackageName()) == true) goto L53;
        if (TextUtils.isEmpty(r3.d.getVersion()) == true) goto L51;
        boolean r7 = r3.i;
        g.j.n(r7);
        a0.a r8 = r3.j;
        if (r8 == null) goto L40;
        AppLog.g0.l(r8);
    L40:
        AppLog.g0.A();
        boolean r9 = r3.n;
        AppLog.g0.setAnonymous(r9);
        AppLog.Q = r3.b;
        k0.d();
        gta.e.c(r3.getContext());
        if (AppLog.E0 == true) goto L49;
        g.j.e();
        AppLog.g0.k();
        if (AppLog.E0 == true) goto L47;
        g.e = false;
        AppLog.O = 30000;
        g.h = r3.c;
        boolean r10 = r3.a;
        AppLog.g0.c(r10);
        g.j.c(r10);
        AppLog.c0 = true;
        Context r11 = r3.getContext();
        boolean r12 = r3.l;
        m0 r13 = r3.m;
        AppLog.g0.F(r11, r12, r13);
        return;
    L47:
        throw new IllegalStateException("please call before init");
    L49:
        throw new IllegalStateException("please call before init");
    L51:
        throw new IllegalArgumentException("getVersion from appContext can not be empty");
    L53:
        throw new IllegalArgumentException("packageName from context can not be empty");
    L55:
        throw new IllegalStateException("please call before init");
    L57:
        throw new IllegalArgumentException("channel in appContext can not be empty");
    L7:
        if (TextUtils.isEmpty("obric_interactor_legacy_applog_stats") == true) goto L10;
        AppLog.g0.x("obric_interactor_legacy_applog_stats");
    L10:
        if (TextUtils.isEmpty("obric_interactor_legacy_applog.db") == true) goto L13;
        AppLog.g0.v("obric_interactor_legacy_applog.db");
    L13:
        if (TextUtils.isEmpty("obric_interactor_legacy_applog_encrypt") == true) goto L15;
        AppLog.g0.t("obric_interactor_legacy_applog_encrypt");
        goto L15
    L59:
        throw new IllegalArgumentException("net work client is not set");
    }

    public static void b(Context r13, String r14, String r15, String r16, long r17, long r19, boolean r21, JSONObject r22) {
        com.bytedance.android.btm.api.model.j r12 = new com.bytedance.android.btm.api.model.j(r13, r14, r15, r16, r17, r19, r21, r22, true);
        BtmSDK r0 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.model.j r1 = r0.addBtmEventParam(r12);
        com.bytedance.android.btm.api.bst.b r2 = (com.bytedance.android.btm.api.bst.b) yc.b.a(com.bytedance.android.btm.api.bst.b.class);
        if (r2 == null) goto L5;
        r2.hookApplog(r1);
    L5:
        r0.getService().checkEventParam(r1);
        BtmDebugTool.b.onEventIntercepted(r1);
        AppLog.F(r13, r14, r15, r16, r17, r19, r21, r1.h);
    }
}
