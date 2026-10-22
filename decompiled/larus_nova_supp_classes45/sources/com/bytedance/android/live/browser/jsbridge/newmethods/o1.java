package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CanLoadFromLokiResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "canLoadFromLoki")
public final class o1 extends w20.l<w20.t7, CanLoadFromLokiResultModel> {

    public static final class a {
    }

    static {
    }

    public o1() {
    }

    public static final void j(o1 r4, Effect r5) {
        r4.getClass();
        if (r5 != null) goto L5;
        CanLoadFromLokiResultModel r6 = new CanLoadFromLokiResultModel();
        r6.a(CanLoadFromLokiResultModel.Code.Success);
        r6.b(Boolean.FALSE);
    L20:
        r4.finishWithResult(r6);
        ALogger.i("CanLoadFromLokiMethod", "result=" + JsonUtil.toJSONString(r6));
        return;
    L5:
        CanLoadFromLokiResultModel r0 = new CanLoadFromLokiResultModel();
        r0.b(Boolean.TRUE);
        r0.d(r5.getUnzipPath());
        final String r7 = r5.getUnzipPath();
        File r1 = new PolarisFileWrapper(r7);
        if (r1.exists() == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L18;
        FileTreeWalk r2 = FilesKt.walk$default(r1, null, 1, null);
        if (r2 == null) goto L18;
        Sequence r3 = SequencesKt.filter(r2, CanLoadFromLokiMethod$getAllFiles$2.INSTANCE);
        if (r3 == null) goto L18;
        Sequence r8 = SequencesKt.map(r3, new CanLoadFromLokiMethod$getAllFiles$3(r7));
        if (r8 == null) goto L18;
        List<String> r9 = SequencesKt.toList(r8);
        if (r9 == null) goto L18;
    L19:
        r0.c(r9);
        r6 = r0;
    L18:
        r9 = CollectionsKt.emptyList();
        goto L19
    }

    public final void invoke(Object r9, CallContext r11) {
        w20.t7 r12 = (w20.t7) r9;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        ALogger.i("CanLoadFromLokiMethod", "params=" + JsonUtil.toJSONString(r12));
        List<String> r13 = LiveEffectContext.h;
        EffectManager r0 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d();
        r0.fetchCategoryEffect(r12.b(), r12.a(), 0, 0, 0, "0", new p1(this, r12, r0));
    }
}
