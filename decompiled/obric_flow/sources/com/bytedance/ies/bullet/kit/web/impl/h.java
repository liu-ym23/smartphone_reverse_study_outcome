package com.bytedance.ies.bullet.kit.web.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements ce.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.core.kit.bridge.b f5519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f5520c;

    public h(com.bytedance.ies.bullet.core.kit.bridge.b r5, i r10) {
        this.f5519b = r5;
        this.f5520c = r10;
        this.f5518a = new LinkedHashMap();
    }

    @Override // ce.c
    public final void a(ce.d r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "res");
        JSONObject r5 = r10.d;
        if (r5 != null) goto L32;
        r5 = new JSONObject();
    L32:
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L8
        r12.put("type", r10.f1178a);     // Catch: JSONException -> L8
        r12.put("func", r10.f1180c);     // Catch: JSONException -> L8
        r12.put("callback_id", r10.f1179b);     // Catch: JSONException -> L8
        r12.put("version", r10.e);     // Catch: JSONException -> L8
        r12.put("needCallback", r10.f1183j);     // Catch: JSONException -> L8
        r12.put("permissionGroup", r10.f1182i);     // Catch: JSONException -> L8
        r5.put("jsMsg", r12);     // Catch: JSONException -> L8
        r5.put("res", r11);     // Catch: JSONException -> L8
    L10:
        com.bytedance.ies.bullet.core.kit.bridge.b r13 = this.f5519b;
        boolean r14 = r13 instanceof com.bytedance.ies.bullet.core.kit.bridge.b;
        LinkedHashMap r15 = this.f5518a;
        com.bytedance.ies.bullet.core.kit.bridge.b r16 = null;
        if (r14 == false) goto L19;
        r15.put("bridge_type", "BULLET_BRIDGE");
        if ((r13 instanceof com.bytedance.ies.bullet.core.kit.bridge.b) == false) goto L15;
        r16 = r13;
    L15:
        if (r16 == null) goto L17;
        r16.a(r5, new g(r13, this.f5520c, r10));
    L17:
        r13.getClass();
        r10.f1183j = false;
        return;
    L19:
        r15.put("bridge_type", "IDL_XBRIDGE");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod<org.json.JSONObject, org.json.JSONObject>");
        if (r13 != null) goto L31;
        LinkedHashMap r17 = de.a.f16641a;
        Intrinsics.checkNotNullParameter(JSONObject.class, "inputClass");
        Intrinsics.checkNotNullParameter(Map.class, "outputClass");
        LinkedHashMap r18 = de.a.f16641a;
        Map r19 = (Map) r18.get(JSONObject.class);
        if (r19 == null) goto L24;
        final Function2 r20 = (Function2) r19.get(Map.class);
    L25:
        Intrinsics.checkNotNullParameter(Map.class, "inputClass");
        Intrinsics.checkNotNullParameter(JSONObject.class, "outputClass");
        Map r21 = (Map) r18.get(Map.class);
        if (r21 == null) goto L28;
        Function2 r22 = (Function2) r21.get(JSONObject.class);
    L28:
        new DefaultWebKitDelegate$setJsBridge$6$1$call$3(r20);
        throw null;
    L24:
        r20 = null;
        goto L25
    L31:
        throw new ClassCastException();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
