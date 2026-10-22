package com.bytedance.sdk.xbridge.cn.platform.lynx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cj.f f7370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Class f7371c;
    public final /* synthetic */ cj.g d;
    public final /* synthetic */ Object e;

    public /* synthetic */ f(Object r5, cj.f r10, Class r11, cj.g r12, int r13) {
        this.f7369a = r13;
        this.e = r5;
        this.f7370b = r10;
        this.f7371c = r11;
        this.d = r12;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r5, Method r10, Object[] r11) {
        switch(this.f7369a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        boolean r12 = Intrinsics.areEqual(r10.getName(), "toJSON");
        JSONObject r13 = (JSONObject) this.e;
        cj.f r14 = this.f7370b;
        if (r12 == true) goto L22;
        cj.i r15 = (cj.i) this.d.f1197a.get(r10);
        if (r15 == null) goto L10;
        String r16 = r15.f1203b;
    L12:
        return com.bytedance.sdk.xbridge.cn.platform.web.i.c(r13.opt(r16), r15, r14);
    L10:
        r16 = null;
        goto L12
    L22:
        return com.bytedance.sdk.xbridge.cn.platform.web.i.e(r13, (cj.g) r14.e.get(this.f7371c), r14);
    L13:
        boolean r17 = Intrinsics.areEqual(r10.getName(), "toJSON");
        HashMap r18 = (HashMap) this.e;
        cj.f r19 = this.f7370b;
        if (r17 == true) goto L23;
        cj.i r20 = (cj.i) this.d.f1197a.get(r10);
        if (r20 == null) goto L19;
        String r21 = r20.f1203b;
    L21:
        return com.lynx.tasm.behavior.ui.utils.e.f(r18.get(r21), r20, r19);
    L19:
        r21 = null;
        goto L21
    L23:
        return new JSONObject(com.lynx.tasm.behavior.ui.utils.e.g(r18, (cj.g) r19.e.get(this.f7371c), r19));
    }
}
