package com.bytedance.android.live.revenue.platform.container.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r0<T, R> implements Function {
    public final /* synthetic */ s0 a;

    public r0(s0 r1) {
        this.a = r1;
    }

    public final Object apply(Object r8) {
        String r9 = (String) r8;
        Intrinsics.checkNotNullParameter(r9, "it");
        jy0.b.c("lifengji", "already redirect, scheme is: " + r9, null, 4);
        vy0.b r0 = (vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        s0 r1 = this.a;
        Context r2 = r1.b;
        RpcMethodImpl r3 = r1.a;
        Uri r10 = UriProtector.parse(r9);
        s0 r4 = this.a;
        Object r5 = RpcMethodImpl.c(r4.c, r4.a.b).a;
        if ((r5 instanceof JsonObject) == false) goto L5;
        JsonObject r6 = (JsonObject) r5;
    L6:
        r3.getClass();
        com.bytedance.android.live.revenue.common.x0 r7 = new com.bytedance.android.live.revenue.common.x0(r10);
        Iterator<T> r12 = r6.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L22;
        Map.Entry r13 = (Map.Entry) r12.next();
        JsonPrimitive r14 = (JsonElement) r13.getValue();
        if ((r14 instanceof JsonPrimitive) == false) goto L12;
        String r15 = r14.getAsString();
    L14:
        if (r15.length() <= 0) goto L16;
        boolean r16 = true;
    L17:
        if (r16 == true) goto L20;
        r15 = null;
    L20:
        if (r15 == null) goto L8;
        r7.b((String) r13.getKey(), r15);
        r7.d("url").b((String) r13.getKey(), r15);
        goto L8
    L16:
        r16 = false;
        goto L17
    L12:
        r15 = r14.toString();
        goto L14
    L22:
        HybridDialogImpl r17 = r0.U0(r2, r7.c(), null);
        if (r17 == null) goto L26;
        return r17;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.hybrid.api.ui.ICommonHybridComponentContainer");
    L5:
        r6 = GsonProtectorUtils.toJsonTree(GsonHelper.get(), r5).getAsJsonObject();
        goto L6
    }
}
