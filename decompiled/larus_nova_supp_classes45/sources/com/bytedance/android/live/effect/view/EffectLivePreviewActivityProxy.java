package com.bytedance.android.live.effect.view;

import android.os.Message;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.livesdk.config.mb;
import com.bytedance.android.livesdk.config.qb;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/view/EffectLivePreviewActivityProxy;", "Lcom/bytedance/android/live/effect/view/LiveEffectActivityProxy;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EffectLivePreviewActivityProxy extends LiveEffectActivityProxy implements WeakHandler.IHandler {
    public static final /* synthetic */ int b = 0;
    public Effect a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.view.EffectLivePreviewActivityProxy$onCreate$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m849invoke() {
            List<String> r0 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().c(d0.c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m849invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.view.EffectLivePreviewActivityProxy$onCreate$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m850invoke() {
            if (LiveEffectSettings.LIVE_ANCHOR_ENABLE_EFFECT_SECONDARY_CLASSIFICATION_FOR_ANCHOR.getValue().booleanValue() == false) goto L5;
            List<String> r0 = LiveEffectContext.h;
            o.a.c(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().d(), d0.c, null, LiveEffectSettings.LIVE_ANCHOR_STICKER_DIALOG_CONFIG.getValue().c(), false, null, true, 118);
            return;
        L5:
            List<String> r1 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().a(d0.c, LiveEffectSettings.LIVE_ANCHOR_STICKER_DIALOG_CONFIG.getValue().c());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m850invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.view.EffectLivePreviewActivityProxy$onCreate$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass4 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m851invoke() {
            List<String> r0 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().k(d0.c, LiveEffectSettings.LIVE_ANCHOR_STICKER_DIALOG_CONFIG.getValue().a());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m851invoke();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void handleMsg(Message r1) {
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onCreate() {
        ALogger.i("ttlive_anchor_merged_stream", "preview effect proxy create");
        if (LiveEffectSettings.LIVE_EFFECT_REPORT_FIRST_FRAME_RENDER_LOG.getValue().booleanValue() == false) goto L7;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r0 = ILiveWrappedEffectSDKService.a.a();
        if (r0 == null) goto L7;
        r0.getMessageCenter();
    L7:
        super.onCreate();
        ALogger.d("ttlive_anchor_effect_EffectLivePreviewActivityProxy", "COMPOSER INIT : initializing config");
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContextFactoryDelegate$Type r2 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        LiveEffectContext.a.a(r2).e().c().a();
        List r3 = CollectionsKt.mutableListOf(new String[]{d0.i, FileUtils.BEAUTY, d0.a, d0.c, d0.k, "livebody"});
        Integer r4 = (Integer) qb.a.getValue();
        if (r4 != null) goto L11;
    L12:
        r3.add("live_adjustment");
    L14:
        if (((Boolean) mb.a.getValue()).booleanValue() == false) goto L17;
        r3.add(d0.b);
    L17:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_INDEPENDENT_CAMERA_MOVEMENT_PANEL.getValue().booleanValue() == false) goto L19;
        r3.add("live_camera_move");
    L19:
        LiveEffectContext.a.a(r2).a();
        CollectionsKt.listOf("effect_gift");
        Intrinsics.throwUninitializedPropertyAccessException("startLiveParamsListener");
        Intrinsics.checkNotNullParameter(null, "startLiveParamsListener");
        Intrinsics.checkNotNullParameter(r2, "type");
        throw null;
    L11:
        if (r4.intValue() == 0) goto L14;
        goto L12
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onDestroy() {
        super.onDestroy();
        ALogger.e("ttlive_anchor_merged_stream", "video audio core onDestroy");
        if (LiveEffectSettings.LIVE_EFFECT_REPORT_FIRST_FRAME_RENDER_LOG.getValue().booleanValue() == false) goto L7;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r0 = ILiveWrappedEffectSDKService.a.a();
        if (r0 == null) goto L7;
        r0.getMessageCenter();
    L7:
        ALogger.i("ttlive_anchor_effect_EffectLivePreviewActivityProxy", "onDestroy release");
        throw null;
    }
}
