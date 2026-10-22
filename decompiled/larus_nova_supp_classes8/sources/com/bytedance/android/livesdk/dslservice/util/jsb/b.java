package com.bytedance.android.livesdk.dslservice.util.jsb;

import android.view.View;
import com.bytedance.android.annie.xbridge.mix.StateMethodFinder;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.XBridge3MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yt1.h;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements h {
    public b() {
    }

    @Override // yt1.h
    public final String a() {
        return null;
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.JSBInvoke;
    }

    public static List c(JSONArray r5) throws JSONException {
        Intrinsics.checkNotNullParameter(r5, "$this$toList");
        ArrayList r0 = new ArrayList();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        Object r3 = r5.get(r2);
        if ((r3 instanceof JSONArray) == false) goto L8;
        r3 = c((JSONArray) r3);
    L10:
        r0.add(r3);
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r3 instanceof JSONObject) == false) goto L10;
        r3 = d((JSONObject) r3);
        goto L10
    L11:
        return r0;
    }

    public static Map d(JSONObject r5) throws JSONException {
        Intrinsics.checkNotNullParameter(r5, "$this$toMap");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        Object r3 = r5.get(r2);
        if ((r3 instanceof JSONArray) == false) goto L9;
        r3 = c((JSONArray) r3);
    L11:
        r0.put(r2, r3);
        goto L4
    L9:
        if ((r3 instanceof JSONObject) == false) goto L11;
        r3 = d((JSONObject) r3);
        goto L11
    L12:
        return r0;
    }

    @Override // yt1.h
    public final void b(final Map r18, final j r19) {
        View r0 = null;
        if (r18 == null) goto L5;
        Object r1 = r18.get("live_dsl_ns");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r8 = (String) r1;
        if (r18 == null) goto L12;
        Object r2 = r18.get("live_dsl_success_callback");
    L14:
        if ((r2 instanceof String) == true) goto L16;
        r2 = null;
    L16:
        final String r9 = (String) r2;
        if (r18 == null) goto L19;
        Object r3 = r18.get("live_dsl_error_callback");
    L21:
        if ((r3 instanceof String) == true) goto L23;
        r3 = null;
    L23:
        final String r10 = (String) r3;
        if (r18 == null) goto L26;
        Object r4 = r18.get("live_dsl_method");
    L28:
        if ((r4 instanceof String) == true) goto L30;
        r4 = null;
    L30:
        final String r11 = (String) r4;
        if (r11 != null) goto L33;
        return;
    L33:
        JavaOnlyMap r12 = JavaOnlyMap.from(r18);
        if (r19 == null) goto L36;
        r0 = r19.getTargetView();
    L36:
        if (r0 != null) goto L38;
        m16.b r5 = new m16.b();
    L39:
        Iterator r13 = CollectionsKt.listOf(new MethodFinder[]{new StateMethodFinder(r5), new XBridge3MethodFinder()}).iterator();
    L41:
        if (r13.hasNext() == false) goto L51;
        MethodFinder r6 = (MethodFinder) r13.next();
        c r14 = new c(new e(r11, r12));
        if (r8 != null) goto L45;
        String r7 = "webcast";
    L46:
        IDLXBridgeMethod r15 = r6.d(r7, r11);
        if (r15 == null) goto L50;
        r15.realHandle(r14, r18, new CommonJsbInvokeAction$handleMap$$inlined$forEach$lambda$1(this, r11, r18, r9, r10, r19));
    L50:
        r8 = r8;
        goto L41
    L45:
        r7 = r8;
        goto L46
    L51:
        return;
    L38:
        m16.b r16 = new m16.b();
        r16.d(ue7.c.class, new a(r0));
        r5 = r16;
        goto L39
    L26:
        r4 = null;
        goto L28
    L19:
        r3 = null;
        goto L21
    L12:
        r2 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }
}
