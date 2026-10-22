package com.larus.audio.ttsV2;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/larus/audio/ttsV2/TtsClientDelegate;", "Lcom/larus/audio/ttsV2/ITtsClientService;", "<init>", "()V", "cancel", "", "reason", "", "isFromManual", "", "isTtsStopped", "setCurrentConversationId", "cvsId", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TtsClientDelegate implements ITtsClientService {
    public static final TtsClientDelegate b = null;
    public final /* synthetic */ ITtsClientService a;

    static {
        b = new TtsClientDelegate();
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final void a() {
        this.a.a();
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final void cancel(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.a.cancel(r2, r3);
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final boolean isTtsStopped() {
        return this.a.isTtsStopped();
    }

    private TtsClientDelegate() {
        ITtsClientService r0 = (ITtsClientService) ServiceManager.get().getService(ITtsClientService.class);
        if (r0 != null) goto L5;
        r0 = new TtsClientServiceNoop();
    L5:
        this.a = r0;
    }
}
