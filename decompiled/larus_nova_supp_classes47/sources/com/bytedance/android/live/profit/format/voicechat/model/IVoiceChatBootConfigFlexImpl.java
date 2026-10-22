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
@ProtoMessage("webcast.ugm.api.webcast_profit_ai_biz.VoiceChatBootConfigResp.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0018\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/IVoiceChatBootConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/format/voicechat/model/a;", "", "giftId$delegate", "Ljava/lang/Object;", "getGiftId", "()J", "giftId", "effectId$delegate", "getEffectId", "effectId", "", "authorName$delegate", "getAuthorName", "()Ljava/lang/String;", "authorName", "authorAvatarUrl$delegate", "getAuthorAvatarUrl", "authorAvatarUrl", "Lcom/bytedance/android/live/profit/format/voicechat/model/IVoiceChatStartButtonFlexImpl;", "startButton$delegate", "getStartButton", "()Lcom/bytedance/android/live/profit/format/voicechat/model/IVoiceChatStartButtonFlexImpl;", "startButton", "giftDiamond$delegate", "getGiftDiamond", "giftDiamond", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IVoiceChatBootConfigFlexImpl extends FlexModelBase<a> implements a, h {

    @SerializedName("author_avatar")
    protected String _$$authorAvatarUrl;

    @SerializedName("author_name")
    protected String _$$authorName;

    @SerializedName("effect_id")
    protected long _$$effectId;

    @SerializedName("gift_diamond_count")
    protected long _$$giftDiamond;

    @SerializedName("gift_id")
    protected long _$$giftId;

    @SerializedName("start_button")
    protected IVoiceChatStartButtonFlexImpl _$$startButton;

    public IVoiceChatBootConfigFlexImpl() {
        super(a.class);
        this._$$authorName = "";
        this._$$authorAvatarUrl = "";
        this._$$startButton = $defaultValue_startButton$();
    }

    public final IVoiceChatStartButtonFlexImpl $defaultValue_startButton$() {
        return (IVoiceChatStartButtonFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IVoiceChatStartButtonFlexImpl.class);
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.a
    public /* bridge */ /* synthetic */ c getStartButton() {
        return getStartButton();
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.a
    public final String getAuthorAvatarUrl() {
        return this._$$authorAvatarUrl;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.a
    public final String getAuthorName() {
        return this._$$authorName;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.a
    public final long getEffectId() {
        return this._$$effectId;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.a
    public final long getGiftDiamond() {
        return this._$$giftDiamond;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.a
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.a
    public final IVoiceChatStartButtonFlexImpl getStartButton() {
        return this._$$startButton;
    }

    public IVoiceChatBootConfigFlexImpl(g r5) {
        super(a.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$giftDiamond = r5.j();
        goto L3
    L9:
        this._$$startButton = new IVoiceChatStartButtonFlexImpl(r5);
        goto L3
    L10:
        this._$$authorAvatarUrl = am3.h.c(r5);
        goto L3
    L11:
        this._$$authorName = am3.h.c(r5);
        goto L3
    L12:
        this._$$effectId = r5.j();
        goto L3
    L13:
        this._$$giftId = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$authorName != null) goto L18;
        this._$$authorName = "";
    L18:
        if (this._$$authorAvatarUrl != null) goto L21;
        this._$$authorAvatarUrl = "";
    L21:
        if (this._$$startButton != null) goto L40;
        this._$$startButton = $defaultValue_startButton$();
        return;
    }
}
