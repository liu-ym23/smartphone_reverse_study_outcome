package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdk.utils.s2;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.EffectPanelModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/live/effect/view/EffectLivePreviewActivityProxy$stickerPreloadByTabListener$2$a", "invoke", "()Lcom/bytedance/android/live/effect/view/EffectLivePreviewActivityProxy$stickerPreloadByTabListener$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class EffectLivePreviewActivityProxy$stickerPreloadByTabListener$2 extends Lambda implements Function0<a> {
    final /* synthetic */ EffectLivePreviewActivityProxy this$0;

    public static final class a implements k.d {
        public final /* synthetic */ EffectLivePreviewActivityProxy$stickerPreloadByTabListener$2 a;

        @Override // com.bytedance.android.live.effect.api.k.d
        public final void onFetchFailed() {
            PthreadHandlerThreadV2 r0 = LiveEffectMonitor.a;
            LiveEffectMonitor.l(ColumnElement.typeLocalSimpleDivider, "");
        }

        public a(EffectLivePreviewActivityProxy$stickerPreloadByTabListener$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.k.d
        public final void a(PanelInfoModel r6, EffectDataFetchCacheType r7) {
            Intrinsics.checkNotNullParameter(r6, "panelInfo");
            Intrinsics.checkNotNullParameter(r7, "cacheType");
            EffectPanelModel r8 = r6.getEffect_panel();
            if (r8 == null) goto L7;
            String r9 = r8.getExtra();
            if (r9 == null) goto L7;
            JSONObject r11 = s2.a(r9);
        L8:
            EffectLivePreviewActivityProxy r12 = this.a.this$0;
            int r0 = EffectLivePreviewActivityProxy.b;
            r12.getClass();
            if (r11 != null) goto L24;
        L13:
            long r2 = 0;
        L15:
            if (r2 != 0) goto L22;
            PthreadHandlerThreadV2 r13 = LiveEffectMonitor.a;
            if (r11 == null) goto L20;
            String r14 = r11.toString();
            if (r14 == null) goto L20;
        L21:
            LiveEffectMonitor.l(1000, r14);
            return;
        L20:
            r14 = "";
            goto L21
        L22:
            List<String> r15 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffect(String.valueOf(r2), new b(r12, r2));
            return;
        L24:
            r2 = JSONObjectProtectorUtils.getLong(r11, "guide_recommend_id");     // Catch: JSONException -> L12
        L7:
            r11 = null;
            goto L8
        }
    }

    public EffectLivePreviewActivityProxy$stickerPreloadByTabListener$2(EffectLivePreviewActivityProxy r1) {
        this.this$0 = r1;
        super(0);
    }

    public final a invoke() {
        return new a(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m853invoke() {
        return invoke();
    }
}
