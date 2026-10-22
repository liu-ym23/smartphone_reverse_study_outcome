package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.RevenueCurrentPanelEffectsResultModel;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.IMiddlewareEffectServiceDelegate;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.md;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x extends wy0.b<md, RevenueCurrentPanelEffectsResultModel> {
    public final Type a;

    public x() {
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(md.class));
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    @Override // wy0.b
    public final void l(vh7.j r6, CallContext r7) {
        Intrinsics.checkNotNullParameter((md) r6, "param");
        Intrinsics.checkNotNullParameter(r7, "callContext");
        ILiveEffectComposerManager r8 = jc1.k.n(IMiddlewareEffectServiceDelegate.class).composerManager(LiveEffectContextFactoryDelegate.Type.DEFAULT);     // Catch: Exception -> L12
        if (r8 == null) goto L11;
        List r9 = r8.o(com.bytedance.android.live.effect.api.d0.c);     // Catch: Exception -> L12
        RevenueCurrentPanelEffectsResultModel r10 = new RevenueCurrentPanelEffectsResultModel();     // Catch: Exception -> L12
        r10.a(RevenueCurrentPanelEffectsResultModel.Code.Success);     // Catch: Exception -> L12
        RevenueCurrentPanelEffectsResultModel.a r0 = new RevenueCurrentPanelEffectsResultModel.a();     // Catch: Exception -> L12
        List r12 = r9;     // Catch: Exception -> L12
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Exception -> L12
        Iterator r13 = r12.iterator();     // Catch: Exception -> L12
    L7:
        if (r13.hasNext() == false) goto L9;
        Sticker r2 = (Sticker) r13.next();     // Catch: Exception -> L12
        RevenueCurrentPanelEffectsResultModel.b r3 = new RevenueCurrentPanelEffectsResultModel.b();     // Catch: Exception -> L12
        r3.a(r2.getEffectId());     // Catch: Exception -> L12
        r3.b(Boolean.valueOf(r2.getNoCameraRender()));     // Catch: Exception -> L12
        r1.add(r3);     // Catch: Exception -> L12
        goto L7
    L9:
        r0.a(r1);     // Catch: Exception -> L12
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L12
        r10.b(r0);     // Catch: Exception -> L12
        j(r10);     // Catch: Exception -> L12
        return;
    L11:
        throw new IllegalArgumentException("effectManager is null".toString());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        finishWithFailure(e);
    }
}
