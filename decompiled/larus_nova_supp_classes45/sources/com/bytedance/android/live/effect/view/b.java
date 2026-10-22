package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.sticker.d;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.InsertEffectType;
import com.bytedance.android.livesdkapi.depend.model.InsertStickerInfo;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements IFetchEffectListener {
    public final /* synthetic */ EffectLivePreviewActivityProxy a;

    public final void onStart(Effect r1) {
    }

    public final void onSuccess(Object r13) {
        Effect r3 = (Effect) r13;
        if (r3 != null) goto L6;
        PthreadHandlerThreadV2 r14 = LiveEffectMonitor.a;
        LiveEffectMonitor.l(ColumnElement.typeLocalSimpleDivider, "");
        return;
    L6:
        this.a.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("startLiveParamsListener");
        new InsertStickerInfo(InsertEffectType.Recommend, d.b(r3), r3, s1.B(2131916348), true, false, false, null, false, 448, null);
        throw null;
    }

    public b(EffectLivePreviewActivityProxy r1, long r2) {
        this.a = r1;
    }

    public final void onFail(Effect r1, ExceptionResult r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        PthreadHandlerThreadV2 r3 = LiveEffectMonitor.a;
        LiveEffectMonitor.l(r2.getErrorCode(), "");
    }
}
