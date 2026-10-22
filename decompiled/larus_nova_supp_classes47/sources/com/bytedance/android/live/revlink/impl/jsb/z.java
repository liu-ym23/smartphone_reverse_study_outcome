package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.RevenueDownloadEffectAssetsResultModel;
import com.bytedance.android.live.effect.api.IMiddlewareEffectServiceDelegate;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.nd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z extends wy0.b<nd, RevenueDownloadEffectAssetsResultModel> {
    public final Type a;

    public z() {
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(nd.class));
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    @Override // wy0.b
    public final void l(vh7.j r4, CallContext r5) {
        nd r6 = (nd) r4;
        Intrinsics.checkNotNullParameter(r6, "param");
        Intrinsics.checkNotNullParameter(r5, "callContext");
        jy0.b.d("RevenueDownloadEffectAssetsMethod", "param: " + r6);     // Catch: Exception -> L21
        r6.getPlatform();     // Catch: Exception -> L21
        List r0 = r6.e8();     // Catch: Exception -> L21
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();     // Catch: Exception -> L21
    L6:
        Integer r7 = r6.getPriority();     // Catch: Exception -> L21
        if (r7 == null) goto L10;
        r7.intValue();     // Catch: Exception -> L21
    L10:
        if (r0.isEmpty() == false) goto L12;
        int r8 = RevenueDownloadEffectAssetsResultModel.a;     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter("effectIds is empty", "message");     // Catch: Exception -> L21
        RevenueDownloadEffectAssetsResultModel r9 = new RevenueDownloadEffectAssetsResultModel();     // Catch: Exception -> L21
        r9.a(RevenueDownloadEffectAssetsResultModel.Code.Failed);     // Catch: Exception -> L21
        r9.b("effectIds is empty");     // Catch: Exception -> L21
        j(r9);     // Catch: Exception -> L21
        return;
    L12:
        EffectManager r10 = jc1.k.n(IMiddlewareEffectServiceDelegate.class).baseEffectContext(LiveEffectContextFactoryDelegate.Type.DEFAULT).getEffectManager();     // Catch: Exception -> L21
        if (r10 == null) goto L20;
        Iterator r1 = r0.iterator();     // Catch: Exception -> L21
    L16:
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) r1.next();     // Catch: Exception -> L21
        r10.fetchEffect(r2, new y(r2, r5));     // Catch: Exception -> L21
        goto L16
    L18:
        RevenueDownloadEffectAssetsResultModel r12 = new RevenueDownloadEffectAssetsResultModel();     // Catch: Exception -> L21
        r12.a(RevenueDownloadEffectAssetsResultModel.Code.Success);     // Catch: Exception -> L21
        j(r12);     // Catch: Exception -> L21
        return;
    L20:
        throw new IllegalArgumentException("effectManager is null".toString());     // Catch: Exception -> L21
    L21:
        e = move-exception;
        finishWithFailure(e);
    }
}
