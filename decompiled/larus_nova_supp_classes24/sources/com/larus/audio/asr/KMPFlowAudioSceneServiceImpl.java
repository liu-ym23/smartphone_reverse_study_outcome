package com.larus.audio.asr;

import c68.b;
import com.bytedance.flow_audio.api.service.common.IKMPFlowAudioSceneService;
import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneBroadcastEventType;
import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneErrorCode;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.media.MediaResourceManager;
import com.larus.platform.service.z2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\t¨\u0006&"}, d2 = {"Lcom/larus/audio/asr/KMPFlowAudioSceneServiceImpl;", "Lcom/bytedance/flow_audio/api/service/common/IKMPFlowAudioSceneService;", "<init>", "()V", "recordApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "playApplicant", "isOtherAudioPlaying", "", "()Z", "activate", "Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneActivationResult;", "scene", "", "options", "", "listener", "Lcom/bytedance/flow_audio/api/service/common/IKMPFlowAudioSceneListener;", "activateAsync", "", "completion", "Lcom/bytedance/flow_audio/api/service/common/IKMPFlowAudioSceneActivationCallback;", "update", "type", "deactivate", "addBroadcastListener", "Lcom/bytedance/flow_audio/api/service/common/IKMPFlowAudioSceneBroadcastListener;", "removeBroadcastListener", "broadcast", "event", "Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneBroadcastEvent;", "getResource", "Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneResource;", "activeScenes", "", "validActiveScenes", "activeExternalScenes", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class KMPFlowAudioSceneServiceImpl implements IKMPFlowAudioSceneService {
    public static final /* synthetic */ int d = 0;
    public final com.larus.media.model.a b;
    public final com.larus.media.model.a c;

    public static final class a {
    }

    static {
    }

    public void update(String r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "type");
    }

    public KMPFlowAudioSceneServiceImpl() {
        this.b = new com.larus.media.model.a(null, "asr", false, 0, 1, false, 0, false, false, 0, false, j.f, 2029);
        if (z2.a.asrUseGainTransientFocusType() == false) goto L5;
        int r5 = 2;
    L6:
        this.c = new com.larus.media.model.a(null, "asr", false, r5, 2, false, 0, false, false, 0, false, j.g, 2021);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public final xw5.f m0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        return new xw5.f(false, new xw5.h(KMPFlowAudioSceneErrorCode.UNKNOWN, "not implemented activate use activateAsync instead", 4), 2);
    }

    public final void s(xw5.g r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Lazy r0 = MediaResourceManager.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        MediaResourceManager.a r1 = new MediaResourceManager.a();
        r1.b = r3.d;
        KMPFlowAudioSceneBroadcastEventType r4 = r3.getType();
        int r5 = p0.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        MediaResourceManager.FlowAudioBroadcastEvent r6 = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyBegin;
    L9:
        r1.c = r6;
        MediaResourceManager.d(r1);
        return;
    L5:
        if (r5 == 2) goto L7;
        r6 = null;
        goto L9
    L7:
        r6 = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        goto L9
    }

    public final void L2(final String r4, int r5, final com.bytedance.flow_audio.impl.business.asr.viewModel.g r6) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r6, "completion");
        int r0 = b.a;
        b.d("KMPFlowAudioSceneServiceImpl", "activate requestMedia scene=" + r4 + " options=" + r5 + " playFocusType=" + this.c.d + " recordFocusType=" + this.b.d);
        Lazy r7 = MediaResourceManager.a;
        MediaResourceManager.l(this.c, this.b, new n0(r4, r6), new o0(r4, r6), 48);
    }
}
