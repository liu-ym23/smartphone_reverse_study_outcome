package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.livesdk.link.model.c6;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.LinkmicJoinChannelData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bb\u0010cR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR+\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010!\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR;\u0010)\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0006\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R+\u00100\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020*8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0006\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R+\u00104\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR/\u0010;\u001a\u0004\u0018\u0001052\b\u0010\u0004\u001a\u0004\u0018\u0001058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0006\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R/\u0010B\u001a\u0004\u0018\u00010<2\b\u0010\u0004\u001a\u0004\u0018\u00010<8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0006\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR/\u0010I\u001a\u0004\u0018\u00010C2\b\u0010\u0004\u001a\u0004\u0018\u00010C8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010\u0006\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR/\u0010L\u001a\u0004\u0018\u00010J2\b\u0010\u0004\u001a\u0004\u0018\u00010J8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u0006\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR/\u0010S\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010\u0006\u001a\u0004\bQ\u0010\b\"\u0004\bR\u0010\nR/\u0010Z\u001a\u0004\u0018\u00010T2\b\u0010\u0004\u001a\u0004\u0018\u00010T8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bU\u0010\u0006\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR/\u0010a\u001a\u0004\u0018\u00010[2\b\u0010\u0004\u001a\u0004\u0018\u00010[8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u0006\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/JoinChannelDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "", "<set-?>", "prompt$delegate", "Ljava/lang/Object;", "getPrompt", "()Ljava/lang/String;", "setPrompt", "(Ljava/lang/String;)V", "prompt", "Lcom/bytedance/android/live/liveinteract/plantform/model/d;", "delegateSetting$delegate", "getDelegateSetting", "()Lcom/bytedance/android/live/liveinteract/plantform/model/d;", "setDelegateSetting", "(Lcom/bytedance/android/live/liveinteract/plantform/model/d;)V", "delegateSetting", "token$delegate", "getToken", "setToken", "token", "", "payCount$delegate", "getPayCount", "()J", "setPayCount", "(J)V", "payCount", "liveCoreSettings$delegate", "getLiveCoreSettings", "setLiveCoreSettings", "liveCoreSettings", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "linkedUsers$delegate", "getLinkedUsers", "()Ljava/util/List;", "setLinkedUsers", "(Ljava/util/List;)V", "linkedUsers", "", "applyType$delegate", "getApplyType", "()I", "setApplyType", "(I)V", "applyType", "version$delegate", "getVersion", "setVersion", "version", "Lcom/bytedance/android/live/liveinteract/plantform/model/t0;", "matchEffect$delegate", "getMatchEffect", "()Lcom/bytedance/android/live/liveinteract/plantform/model/t0;", "setMatchEffect", "(Lcom/bytedance/android/live/liveinteract/plantform/model/t0;)V", "matchEffect", "Lcom/bytedance/android/live/liveinteract/plantform/model/c;", "cityEffect$delegate", "getCityEffect", "()Lcom/bytedance/android/live/liveinteract/plantform/model/c;", "setCityEffect", "(Lcom/bytedance/android/live/liveinteract/plantform/model/c;)V", "cityEffect", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "msgBoardItem$delegate", "getMsgBoardItem", "()Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "setMsgBoardItem", "(Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;)V", "msgBoardItem", "", "isPaidLinkMic$delegate", "isPaidLinkMic", "()Ljava/lang/Boolean;", "setPaidLinkMic", "(Ljava/lang/Boolean;)V", "promptWithEarphone$delegate", "getPromptWithEarphone", "setPromptWithEarphone", "promptWithEarphone", "Lcom/bytedance/android/livesdk/link/model/c6;", "linkGameInfo$delegate", "getLinkGameInfo", "()Lcom/bytedance/android/livesdk/link/model/c6;", "setLinkGameInfo", "(Lcom/bytedance/android/livesdk/link/model/c6;)V", "linkGameInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "clientUiInfo$delegate", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUiInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "clientUiInfo", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class JoinChannelDataFlexImpl extends FlexModelBase<q0> implements q0, vh7.h {

    @SerializedName("apply_type")
    protected int _$$applyType;

    @SerializedName("city_effect")
    protected c _$$cityEffect;

    @SerializedName("client_ui_info")
    protected ClientUIInfo _$$clientUiInfo;

    @SerializedName("delegate_setting")
    protected d _$$delegateSetting;

    @SerializedName("is_paid_linkmic")
    protected Boolean _$$isPaidLinkMic;

    @SerializedName("link_game_info")
    protected c6 _$$linkGameInfo;

    @SerializedName("linked_users")
    protected List<? extends com.bytedance.android.livesdk.link.model.bridge.k> _$$linkedUsers;

    @SerializedName("live_core_settings")
    protected String _$$liveCoreSettings;

    @SerializedName("match_effect")
    protected t0 _$$matchEffect;

    @SerializedName("msg_board_item")
    protected IMessageBoardInfo _$$msgBoardItem;

    @SerializedName("pay_count")
    protected long _$$payCount;

    @SerializedName("prompt")
    protected String _$$prompt;

    @SerializedName("prompt_with_earphone")
    protected String _$$promptWithEarphone;

    @SerializedName("token")
    protected String _$$token;

    @SerializedName("version")
    protected long _$$version;

    public JoinChannelDataFlexImpl() {
        super(q0.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final int getApplyType() {
        return this._$$applyType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final c getCityEffect() {
        return this._$$cityEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final ClientUIInfo getClientUiInfo() {
        return this._$$clientUiInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final d getDelegateSetting() {
        return this._$$delegateSetting;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final c6 getLinkGameInfo() {
        return this._$$linkGameInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUsers() {
        return this._$$linkedUsers;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final String getLiveCoreSettings() {
        return this._$$liveCoreSettings;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final t0 getMatchEffect() {
        return this._$$matchEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final IMessageBoardInfo getMsgBoardItem() {
        return this._$$msgBoardItem;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final long getPayCount() {
        return this._$$payCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final String getPrompt() {
        return this._$$prompt;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final String getPromptWithEarphone() {
        return this._$$promptWithEarphone;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final String getToken() {
        return this._$$token;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final long getVersion() {
        return this._$$version;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final Boolean isPaidLinkMic() {
        return this._$$isPaidLinkMic;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.live.liveinteract.plantform.model.t0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.live.liveinteract.plantform.model.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20, types: [com.bytedance.android.livesdk.link.model.c6, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.bytedance.android.livesdkapi.depend.message.ClientUIInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.liveinteract.plantform.model.d, java.lang.Object] */
    public JoinChannelDataFlexImpl(am3.g r5) {
        super(q0.class);
        this._$$linkedUsers = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L23;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L7;
            case 15: goto L9;
            case 16: goto L7;
            case 17: goto L8;
            default: goto L7;
        };
    L8:
        this._$$clientUiInfo = vh7.f.a(r5, ClientUIInfo.class);
        goto L3
    L9:
        this._$$linkGameInfo = vh7.f.a(r5, c6.class);
        goto L3
    L10:
        this._$$promptWithEarphone = am3.h.c(r5);
        goto L3
    L11:
        this._$$isPaidLinkMic = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L12:
        this._$$msgBoardItem = vh7.f.a(r5, IMessageBoardInfo.class);
        goto L3
    L13:
        this._$$cityEffect = vh7.f.a(r5, c.class);
        goto L3
    L14:
        this._$$matchEffect = vh7.f.a(r5, t0.class);
        goto L3
    L15:
        this._$$applyType = r5.i();
        goto L3
    L16:
        this._$$version = r5.j();
        goto L3
    L17:
        this._$$linkedUsers.add(vh7.f.a(r5, com.bytedance.android.livesdk.link.model.bridge.k.class));
        goto L3
    L18:
        this._$$payCount = r5.j();
        goto L3
    L19:
        this._$$liveCoreSettings = am3.h.c(r5);
        goto L3
    L20:
        this._$$token = am3.h.c(r5);
        goto L3
    L21:
        this._$$delegateSetting = vh7.f.a(r5, d.class);
        goto L3
    L22:
        this._$$prompt = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L23:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setApplyType(int r1) {
        this._$$applyType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setCityEffect(c r1) {
        this._$$cityEffect = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setClientUiInfo(ClientUIInfo r1) {
        this._$$clientUiInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setDelegateSetting(d r1) {
        this._$$delegateSetting = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setLinkGameInfo(c6 r1) {
        this._$$linkGameInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setLinkedUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1) {
        this._$$linkedUsers = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setLiveCoreSettings(String r1) {
        this._$$liveCoreSettings = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setMatchEffect(t0 r1) {
        this._$$matchEffect = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setMsgBoardItem(IMessageBoardInfo r1) {
        this._$$msgBoardItem = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setPaidLinkMic(Boolean r1) {
        this._$$isPaidLinkMic = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setPayCount(long r1) {
        this._$$payCount = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setPrompt(String r1) {
        this._$$prompt = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setPromptWithEarphone(String r1) {
        this._$$promptWithEarphone = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setToken(String r1) {
        this._$$token = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.q0
    public final void setVersion(long r1) {
        this._$$version = r1;
    }
}
