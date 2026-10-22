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
@ProtoMessage("webcast.ugm.api.webcast_profit_ai_biz.VoiceChatStartButton")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/IVoiceChatStartButtonFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/format/voicechat/model/c;", "", "text$delegate", "Ljava/lang/Object;", "getText", "()Ljava/lang/String;", "text", "desc$delegate", "getDesc", "desc", "", "privilegeSource$delegate", "getPrivilegeSource", "()J", "privilegeSource", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IVoiceChatStartButtonFlexImpl extends FlexModelBase<c> implements c, h {

    @SerializedName("desc")
    protected String _$$desc;

    @SerializedName("privilege_source")
    protected long _$$privilegeSource;

    @SerializedName("text")
    protected String _$$text;

    public IVoiceChatStartButtonFlexImpl() {
        super(c.class);
        this._$$text = "";
        this._$$desc = "";
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.c
    public final String getDesc() {
        return this._$$desc;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.c
    public final long getPrivilegeSource() {
        return this._$$privilegeSource;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.c
    public final String getText() {
        return this._$$text;
    }

    public IVoiceChatStartButtonFlexImpl(g r6) {
        super(c.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$text = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$desc = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$privilegeSource = r6.j();
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$text != null) goto L19;
        this._$$text = "";
    L19:
        if (this._$$desc != null) goto L34;
        this._$$desc = "";
        return;
    }
}
