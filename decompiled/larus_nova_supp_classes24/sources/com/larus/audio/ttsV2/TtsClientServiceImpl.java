package com.larus.audio.ttsV2;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/larus/audio/ttsV2/TtsClientServiceImpl;", "Lcom/larus/audio/ttsV2/ITtsClientService;", "<init>", "()V", "cancel", "", "reason", "", "isFromManual", "", "isTtsStopped", "setCurrentConversationId", "cvsId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TtsClientServiceImpl implements ITtsClientService {
    public TtsClientServiceImpl() {
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final void a() {
        TtsClientManager.c = null;
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final boolean isTtsStopped() {
        if (com.larus.audio.tts.e.a.l() != PlayStateEnum.PLAY_STATE_STOPPED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final void cancel(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        TtsClientManager.a.cancel(r2, r3);
    }
}
