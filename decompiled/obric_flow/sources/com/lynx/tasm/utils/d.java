package com.lynx.tasm.utils;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.method.datamanager.StorageInputParam;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ies.bullet.service.base.x;
import com.google.common.hash.l;
import com.google.common.hash.z;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.t;
import java.io.EOFException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements l {
    public static final t g(n1.c r5, StorageInputParam r10) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        m2.a r11 = j(r5);
        String r12 = "dataManager " + r11;
        Intrinsics.checkNotNullParameter("AbsAIStorageMethod", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L6;
        r13.d("AbsAIStorageMethod", r12);
    L6:
        if (r11 == null) goto L8;
        m3.a r14 = r11.d(r10.getGroupId(), r10.isShared());
    L9:
        String r15 = "viewModel " + r14;
        Intrinsics.checkNotNullParameter("AbsAIStorageMethod", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L12;
        r16.d("AbsAIStorageMethod", r15);
    L12:
        if (r14 != null) goto L14;
        return null;
    L14:
        return r14.a();
    L8:
        r14 = null;
        goto L9
    }

    public static ArrayList h(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonArray");
        ArrayList r10 = new ArrayList();
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        Object r13 = r5.get(r12);
        if ((r13 instanceof JSONObject) == false) goto L8;
        r13 = i((JSONObject) r13);
    L10:
        r10.add(r13);
        r12 = r12 + 1;
        goto L3
    L8:
        if ((r13 instanceof JSONArray) == false) goto L10;
        r13 = h((JSONArray) r13);
        goto L10
    L11:
        return r10;
    }

    public static LinkedHashMap i(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<String> r11 = r5.keys();
    L4:
        if (r11.hasNext() == false) goto L12;
        String r12 = r11.next();
        Object r13 = r5.get(r12);
        if ((r13 instanceof JSONObject) == false) goto L9;
        r13 = i((JSONObject) r13);
    L11:
        r10.put(r12, r13);
        goto L4
    L9:
        if ((r13 instanceof JSONArray) == false) goto L11;
        r13 = h((JSONArray) r13);
        goto L11
    L12:
        return r10;
    }

    public static final m2.a j(n1.c r5) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        n1.a r10 = (n1.a) r5;
        m1.j r11 = (m1.j) r10.b(m1.j.class);
        if (r11 == null) goto L5;
        ContainerType r12 = r11.d();
    L6:
        if (r12 != null) goto L8;
        int r13 = -1;
    L10:
        if (r13 == 1) goto L21;
        if (r13 == 2) goto L19;
        if (r13 == 3) goto L17;
        return null;
    L17:
        return (m2.a) r10.b(w0.f.class);
    L19:
        return (m2.a) r10.b(WidgetContainer.class);
    L21:
        return (m2.a) r10.b(AppletRuntime.class);
    L8:
        r13 = y1.a.f23229a[r12.ordinal()];
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    public static JSONObject k(String r5, String r10) {
        JSONObject r11 = new JSONObject();
        r11.put(r5, r10);
        return r11;
    }

    public static void l(x r5, com.bytedance.ies.bullet.core.k r10) {
        Intrinsics.checkNotNullParameter(r5, "info");
        Intrinsics.checkNotNullParameter(r10, "monitorContext");
        if (((JSONObject) r5.e) != null) goto L5;
        r5.e = new JSONObject();
    L5:
        JSONObject r11 = (JSONObject) r5.e;
        if (r11 == null) goto L9;
        td.b.f(r11, r10.f5324c);
    L9:
        if (((JSONObject) r5.f) != null) goto L11;
        r5.f = new JSONObject();
    L11:
        JSONObject r12 = (JSONObject) r5.f;
        if (r12 == null) goto L15;
        td.b.f(r12, r10.d);
        return;
    }

    public static boolean m(String r5, List r10) {
        Intrinsics.checkNotNullParameter(r10, "safeUrls");
        Intrinsics.checkNotNullParameter(r5, "remoteUrl");
        androidx.constraintlayout.motion.widget.a.B(new StringBuilder("remoteUrl: "), r5, "VerifyUtils");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m124constructorimpl(URLDecoder.decode(r5, Charsets.UTF_8.name()));     // Catch: Throwable -> L5
    L7:
        Object r13 = r5;
        if (Result.m127exceptionOrNullimpl(r12) != null) goto L10;
        r13 = r12;
    L10:
        String r14 = (String) r13;
        if (r10 != null) goto L13;
    L15:
        Iterator r15 = r10.iterator();
    L17:
        if (r15.hasNext() == false) goto L36;
        String r16 = (String) r15.next();
        Log.d("VerifyUtils", "safeUrl: " + r16 + ", remoteUrl: " + r14);
        Intrinsics.checkNotNullParameter(r14, "content");
        Intrinsics.checkNotNullParameter(r16, "pattern");
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L21
        boolean r18 = Pattern.compile(r16).matcher(r14).find();     // Catch: Throwable -> L21
    L23:
        if (r18 == false) goto L17;
        return true;
    L21:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        r18 = false;
        goto L23
    L36:
        return false;
    L13:
        if (r10.isEmpty() == false) goto L15;
        return false;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void n(int r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        o(r10, r5, r5, false);
    }

    public static final void o(final View r10, final int r11, final int r12, final boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getParent() == null) goto L9;
        ViewParent r5 = r10.getParent();
        if (r5 == null) goto L8;
        ViewGroup r14 = (ViewGroup) r5;
    L10:
        if (r14 != null) goto L12;
        return;
    L12:
        final ViewGroup r15 = r14;
        r14.post(new dr.c(r10, r11, r12, r13, r15));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r14 = null;
        goto L10
    }

    public static final void p(final View r10, final int r11, final int r12, final View... r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "views");
        final dr.a r5 = new dr.a(r10);
        r10.post(new dr.b(r13, r10, r5, r11, r12));
    }

    public static final boolean q(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean r(nu.j r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$isProbablyUtf8");
        nu.j r11 = new nu.j();     // Catch: EOFException -> L17
        r10.g(0, r11, RangesKt.coerceAtMost(r10.f20328b, 64));     // Catch: EOFException -> L17
        int r12 = 0;
    L5:
        if (r12 >= 16) goto L25;
        if (r11.y() == true) goto L15;
        int r5 = r11.N();     // Catch: EOFException -> L17
        if (Character.isISOControl(r5) == false) goto L14;
        if (Character.isWhitespace(r5) == true) goto L14;
        return false;
    L14:
        r12 = r12 + 1;
        goto L5
    L15:
        return true;
    L25:
        return true;
    L17:
        return false;
    }

    public static final void s(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.setVisibility(8);
    }

    public static final void t(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.setVisibility(0);
    }

    public static final void w(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getParent() != null) goto L5;
        return;
    L5:
        if ((r5.getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r10 = r5.getParent();
        if (r10 == null) goto L10;
        ((ViewGroup) r10).removeView(r5);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final void x(View r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 == false) goto L5;
        t(r5);
        return;
    L5:
        s(r5);
    }

    public static boolean y(String r10, String r11, ArrayList r12) {
        if (android.text.TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        if (android.text.TextUtils.isEmpty(r11) == false) goto L7;
        return false;
    L7:
        if (android.text.TextUtils.isEmpty("=") == true) goto L42;
        String[] r13 = r10.split(r11);
        if (r13 != null) goto L11;
        return false;
    L11:
        int r14 = 0;
    L13:
        if (r14 >= r13.length) goto L30;
        if (android.text.TextUtils.isEmpty(r13[r14]) == true) goto L28;
        String[] r5 = r13[r14].trim().split("=");
        if (r5 == null) goto L28;
        if (r5.length != 2) goto L28;
        if (android.text.TextUtils.isEmpty(r5[0]) == true) goto L28;
        if (android.text.TextUtils.isEmpty(r5[1]) == true) goto L28;
        r12.add(new Pair(r5[0].trim(), r5[1].trim()));
    L28:
        r14 = r14 + 1;
        goto L13
    L30:
        if (r12.size() != 0) goto L32;
        return false;
    L32:
        return true;
    L42:
        return false;
    }

    @Override // com.google.common.hash.z
    public /* bridge */ /* synthetic */ z a(byte[] r5) {
        return u(r5);
    }

    @Override // com.google.common.hash.z
    public /* bridge */ /* synthetic */ l b(CharSequence r5, Charset r10) {
        return f(r5, r10);
    }

    @Override // com.google.common.hash.l
    public l f(CharSequence r5, Charset r10) {
        return u(r5.toString().getBytes(r10));
    }

    public l u(byte[] r5) {
        return d(r5, 0, r5.length);
    }

    public abstract l v(char r5);
}
