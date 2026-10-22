package com.bytedance.android.live.profit.format.voicechat.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.ugm.api.webcast_profit_ai_biz.CloseVoiceChatResp.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/IVoiceChatCloseDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/format/voicechat/model/b;", "Lcom/bytedance/android/live/profit/format/voicechat/model/IVoiceChatStartButtonFlexImpl;", "startButton$delegate", "Ljava/lang/Object;", "getStartButton", "()Lcom/bytedance/android/live/profit/format/voicechat/model/IVoiceChatStartButtonFlexImpl;", "startButton", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IVoiceChatCloseDataFlexImpl extends FlexModelBase<b> implements b, h {

    @SerializedName("start_button")
    protected IVoiceChatStartButtonFlexImpl _$$startButton;

    public IVoiceChatCloseDataFlexImpl() {
        super(b.class);
        this._$$startButton = $defaultValue_startButton$();
    }

    public IVoiceChatCloseDataFlexImpl(g r6) {
        super(b.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$startButton = new IVoiceChatStartButtonFlexImpl(r6);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$startButton != null) goto L19;
        this._$$startButton = $defaultValue_startButton$();
        return;
    }

    public final IVoiceChatStartButtonFlexImpl $defaultValue_startButton$() {
        return (IVoiceChatStartButtonFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IVoiceChatStartButtonFlexImpl.class);
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.b
    public /* bridge */ /* synthetic */ c getStartButton() {
        return getStartButton();
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.b
    public final IVoiceChatStartButtonFlexImpl getStartButton() {
        return this._$$startButton;
    }
}
