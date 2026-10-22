package com.bytedance.android.live.effect.gift;

import com.bytedance.android.live.core.resources.AssetsModel;
import com.bytedance.android.live.core.resources.h;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.dz;
import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements e {
    public c() {
    }

    @Override // com.bytedance.android.live.effect.gift.e
    public final DownloadableModelSupport b() {
        if (DownloadableModelSupport.isInitialized() == true) goto L9;
        if (Intrinsics.areEqual(dz.a.getValue(), Boolean.TRUE) == false) goto L7;
        k.n(IMiddleWareHostContext.class).initDownloadableModelSupportSafely();
        goto L9
    L7:
        k.n(IHostContext.class).initDownloadableModelSupport();
    L9:
        if (DownloadableModelSupport.isInitialized() == true) goto L14;
        List<String> r0 = LiveEffectContext.h;
        DownloadableModelConfig r1 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.GIFT).e().b();
        if (r1 == null) goto L14;
        DownloadableModelSupport.initialize(r1);
    L14:
        if (DownloadableModelSupport.isInitialized() == true) goto L18;
        return null;
    L18:
        return DownloadableModelSupport.getInstance();
    }

    @Override // com.bytedance.android.live.effect.gift.e
    public final boolean c(AssetsModel r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        String r1 = null;
        Effect r0 = new Effect(null, 1, null);
        h r2 = r4.getLokiExtraModel();
        if (r2 == null) goto L6;
        List<String> r3 = r2.o8();
        if (r3 == null) goto L6;
    L7:
        r0.setRequirements(r3);
        h r5 = r4.getLokiExtraModel();
        if (r5 == null) goto L10;
        r1 = r5.l3();
    L10:
        r0.setModelNames(r1);
        DownloadableModelSupport r6 = b();
        if (r6 == null) goto L14;
        List<String> r7 = LiveEffectContext.h;
        EffectManager r8 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.GIFT).d();
        r8.markEffectUsed(r0);
        return r6.areRequirementsReady(r8, r0);
    L14:
        return false;
    L6:
        r3 = new ArrayList();
        goto L7
    }

    @Override // com.bytedance.android.live.effect.gift.e
    public final void a(List r4, Map r5, com.bytedance.android.livesdk.revenue.service.effect.k.a r6) {
        if (r4 != null) goto L5;
        if (r5 != null) goto L5;
        return;
    L5:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = r4;
        if (r4 != null) goto L8;
        r0.element = CollectionsKt.emptyList();
    L8:
        DownloadableModelSupport r7 = b();
        if (r7 != null) goto L11;
        r6.onFailure(new Exception("downloadable model support not ready."));
        return;
    L11:
        if (r5 == null) goto L17;
        Object[] r1 = ((List) r0.element).toArray(new String[0]);
        if (r1 == null) goto L16;
        r7.fetchResourcesByRequirementsAndModelNames((String[]) r1, r5, new a(r5, r6));
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L17:
        Object[] r2 = ((List) r0.element).toArray(new String[0]);
        if (r2 == null) goto L21;
        r7.fetchResourcesNeededByRequirements((String[]) r2, new b(r5, r6));
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
