package com.bytedance.sdk.xbridge.cn.auth;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f7350a;

    public j() {
        i r5 = new i();
        r5.f7349c = false;
        this.f7350a = r5;
    }

    public static li.c a(bj.a r14, IDLXBridgeMethod r15) {
        if (r14.c() != PlatformType.f7288b) goto L118;
        String r5 = r14.d();
        String r10 = Uri.parse(r5).getHost();
        String r11 = r14.d;
        boolean r12 = false;
        if (r10 == null) goto L7;
        ib.d r13 = qi.a.f21515a;
        Intrinsics.checkNotNullParameter(r11, "namespace");
        ni.a r16 = qi.a.a(r11);
        if (r16 != null) goto L14;
        r16 = qi.a.a("");
    L14:
        if (r16 == null) goto L16;
        boolean r17 = Intrinsics.areEqual(r11, "webcast");
        LruCache r18 = r16.f20264b;
        if (r17 == false) goto L62;
        Intrinsics.checkNotNullParameter(r5, "rawUrl");
        Uri r19 = Uri.parse(r5);
        String r20 = r19.getScheme();
        String r21 = r19.getAuthority();
        String r22 = new Uri.Builder().scheme(r20).authority(r21).path(r19.getPath()).toString();
        if (r21 != null) goto L28;
    L61:
        ni.b r23 = new ni.b();
    L97:
        IDLXBridgeMethod.Access r24 = r15.getAccess();
        IDLXBridgeMethod.Access r25 = IDLXBridgeMethod.Access.e;
        LinkedHashSet r26 = r23.f20266b;
        String r27 = r14.f932a;
        if (r24 != r25) goto L104;
        if (r26.contains(r27) == true) goto L104;
        return new li.c(false, "method is secure,and not in include method,fail", null, null, 58);
    L104:
        if (r23.f20267c.contains(r27) == false) goto L108;
        return new li.c(false, "method in exclude methods", null, null, 58);
    L108:
        if (r26.contains(r27) == false) goto L112;
        return new li.c(true, null, null, null, 60);
    L112:
        if (r23.f20265a.compareTo(r15.getAccess()) < 0) goto L116;
        return new li.c(true, null, null, null, 62);
    L116:
        return new li.c(false, "rule.access:" + r23.f20265a + ", method.access:" + r15.getAccess() + ", rule < method", null, null, 58);
    L28:
        if (r21.length() == 0) goto L61;
        if (r18 == null) goto L34;
        r23 = (ni.b) r18.get(r22);
        if (r23 != null) goto L97;
    L34:
        ni.b r28 = new ni.b();
        Uri r29 = Uri.parse(r22);
        String r30 = r29.getScheme();
        String r31 = r29.getAuthority();
        String r32 = ni.a.a(r31);
        if (TextUtils.isEmpty(r30) == false) goto L37;
    L59:
        if (r18 != null) goto L60;
    L58:
        r23 = r28;
        goto L97
    L60:
        ni.b r33 = (ni.b) r18.put(r22, r28);
        goto L58
    L37:
        if (TextUtils.isEmpty(r31) == true) goto L59;
        if (r32 == null) goto L59;
        Iterator r34 = r16.f20263a.entrySet().iterator();
    L42:
        if (r34.hasNext() == false) goto L56;
        Iterator r35 = ((List) ((Map.Entry) r34.next()).getValue()).iterator();
    L45:
        if (r35.hasNext() == false) goto L42;
        li.b r36 = (li.b) r35.next();
        String r37 = r36.f19637a;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L49
        boolean r38 = Pattern.compile(r37).matcher(r22).find();     // Catch: Throwable -> L49
    L51:
        if (r38 == false) goto L45;
        IDLXBridgeMethod.Access r39 = f.a(r36.f19638b.f7303a);
        if (r39.compareTo(r28.f20265a) < 0) goto L55;
        Intrinsics.checkNotNullParameter(r39, "<set-?>");
        r28.f20265a = r39;
    L55:
        r28.f20266b.addAll(r36.f19639c);
        r28.f20267c.addAll(r36.d);
    L49:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        r38 = false;
        goto L51
    L56:
        if (r18 == null) goto L58;
        ni.b r40 = (ni.b) r18.put(r22, r28);
        goto L58
    L62:
        Intrinsics.checkNotNullParameter(r5, "rawUrl");
        Uri r41 = Uri.parse(r5);
        String r42 = r41.getScheme();
        String r43 = r41.getAuthority();
        String r44 = new Uri.Builder().scheme(r42).authority(r43).path(r41.getPath()).toString();
        if (r43 != null) goto L65;
    L96:
        r23 = new ni.b();
        goto L97
    L65:
        if (r43.length() == 0) goto L96;
        if (r18 == null) goto L71;
        r23 = (ni.b) r18.get(r44);
        if (r23 != null) goto L97;
    L71:
        r28 = new ni.b();
        Uri r45 = Uri.parse(r44);
        String r46 = r45.getScheme();
        String r47 = r45.getAuthority();
        String r48 = ni.a.a(r47);
        if (TextUtils.isEmpty(r46) == false) goto L74;
    L94:
        if (r18 == null) goto L58;
        ni.b r49 = (ni.b) r18.put(r44, r28);
        goto L58
    L74:
        if (TextUtils.isEmpty(r47) == true) goto L94;
        if (r48 == null) goto L94;
        List r50 = (List) r16.f20263a.get(r48);
        if (r50 == null) goto L92;
        Iterator r51 = r50.iterator();
    L81:
        if (r51.hasNext() == false) goto L92;
        li.b r52 = (li.b) r51.next();
        String r53 = r52.f19637a;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L85
        boolean r55 = Pattern.compile(r53).matcher(r44).find();     // Catch: Throwable -> L85
    L87:
        if (r55 == false) goto L81;
        IDLXBridgeMethod.Access r56 = f.a(r52.f19638b.f7303a);
        if (r56.compareTo(r28.f20265a) < 0) goto L91;
        Intrinsics.checkNotNullParameter(r56, "<set-?>");
        r28.f20265a = r56;
    L91:
        r28.f20266b.addAll(r52.f19639c);
        r28.f20267c.addAll(r52.d);
    L85:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        r55 = false;
    L92:
        if (r18 == null) goto L58;
        ni.b r58 = (ni.b) r18.put(r44, r28);
        goto L58
    L16:
        if (b.f7300a == false) goto L22;
        if (qi.a.f21516b.isEmpty() == false) goto L22;
        ki.a.a("JSB Authenticate: all permission config not found, pass auth");
        return new li.c(true, "all permission config not found", null, null, 58);
    L22:
        return new li.c(false, "permission Config not found", null, null, 58);
    L7:
        if (r15.getAccess() != IDLXBridgeMethod.Access.f7464b) goto L9;
        r12 = true;
    L9:
        ki.a.a("JSB Authenticate: Empty host :" + r5);
        return new li.c(r12, td.d.b("JSB Authenticate: Empty host :", r5), null, null, 58);
    L118:
        return new li.c(true, null, null, null, 62);
    }
}
