package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.livesdk.link.model.c6;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R\"\u0010\u001b\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u0006R6\u0010(\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010/\u001a\u00020)8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\b\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u00104\u001a\u00060\u0015j\u0002`08&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\b\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R$\u0010;\u001a\u0004\u0018\u0001058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b:\u0010\b\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010B\u001a\u0004\u0018\u00010<8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bA\u0010\b\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010I\u001a\u0004\u0018\u00010C8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bH\u0010\b\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010K\u001a\u0004\u0018\u00010J8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bO\u0010\b\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010S\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\bR\u0010\b\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u0010\u0006R$\u0010Z\u001a\u0004\u0018\u00010T8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bY\u0010\b\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010a\u001a\u0004\u0018\u00010[8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b`\u0010\b\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "Lvh7/c;", "", "getPrompt", "()Ljava/lang/String;", "setPrompt", "(Ljava/lang/String;)V", "getPrompt$annotations", "()V", "prompt", "Lcom/bytedance/android/live/liveinteract/plantform/model/d;", "getDelegateSetting", "()Lcom/bytedance/android/live/liveinteract/plantform/model/d;", "setDelegateSetting", "(Lcom/bytedance/android/live/liveinteract/plantform/model/d;)V", "getDelegateSetting$annotations", "delegateSetting", "getToken", "setToken", "getToken$annotations", "token", "", "getPayCount", "()J", "setPayCount", "(J)V", "getPayCount$annotations", "payCount", "getLiveCoreSettings", "setLiveCoreSettings", "getLiveCoreSettings$annotations", "liveCoreSettings", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkedUsers", "()Ljava/util/List;", "setLinkedUsers", "(Ljava/util/List;)V", "getLinkedUsers$annotations", "linkedUsers", "", "getApplyType", "()I", "setApplyType", "(I)V", "getApplyType$annotations", "applyType", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getVersion", "setVersion", "getVersion$annotations", "version", "Lcom/bytedance/android/live/liveinteract/plantform/model/t0;", "getMatchEffect", "()Lcom/bytedance/android/live/liveinteract/plantform/model/t0;", "setMatchEffect", "(Lcom/bytedance/android/live/liveinteract/plantform/model/t0;)V", "getMatchEffect$annotations", "matchEffect", "Lcom/bytedance/android/live/liveinteract/plantform/model/c;", "getCityEffect", "()Lcom/bytedance/android/live/liveinteract/plantform/model/c;", "setCityEffect", "(Lcom/bytedance/android/live/liveinteract/plantform/model/c;)V", "getCityEffect$annotations", "cityEffect", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "getMsgBoardItem", "()Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "setMsgBoardItem", "(Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;)V", "getMsgBoardItem$annotations", "msgBoardItem", "", "isPaidLinkMic", "()Ljava/lang/Boolean;", "setPaidLinkMic", "(Ljava/lang/Boolean;)V", "isPaidLinkMic$annotations", "getPromptWithEarphone", "setPromptWithEarphone", "getPromptWithEarphone$annotations", "promptWithEarphone", "Lcom/bytedance/android/livesdk/link/model/c6;", "getLinkGameInfo", "()Lcom/bytedance/android/livesdk/link/model/c6;", "setLinkGameInfo", "(Lcom/bytedance/android/livesdk/link/model/c6;)V", "getLinkGameInfo$annotations", "linkGameInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUiInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "getClientUiInfo$annotations", "clientUiInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q0 extends vh7.c<q0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "apply_type")
    int getApplyType();

    @FieldName(name = "city_effect")
    c getCityEffect();

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUiInfo();

    @FieldName(name = "delegate_setting")
    d getDelegateSetting();

    @FieldName(name = "link_game_info")
    c6 getLinkGameInfo();

    @FieldName(name = "linked_users")
    List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUsers();

    @FieldName(name = "live_core_settings")
    String getLiveCoreSettings();

    @FieldName(name = "match_effect")
    t0 getMatchEffect();

    @FieldName(name = "msg_board_item")
    IMessageBoardInfo getMsgBoardItem();

    @FieldName(name = "pay_count")
    long getPayCount();

    @FieldName(name = "prompt")
    String getPrompt();

    @FieldName(name = "prompt_with_earphone")
    String getPromptWithEarphone();

    @FieldName(name = "token")
    String getToken();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "is_paid_linkmic")
    Boolean isPaidLinkMic();

    @FieldName(name = "apply_type#setter")
    void setApplyType(int r1);

    @FieldName(name = "city_effect#setter")
    void setCityEffect(c r1);

    @FieldName(name = "client_ui_info#setter")
    void setClientUiInfo(ClientUIInfo r1);

    @FieldName(name = "delegate_setting#setter")
    void setDelegateSetting(d r1);

    @FieldName(name = "link_game_info#setter")
    void setLinkGameInfo(c6 r1);

    @FieldName(name = "linked_users#setter")
    void setLinkedUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r1);

    @FieldName(name = "live_core_settings#setter")
    void setLiveCoreSettings(String r1);

    @FieldName(name = "match_effect#setter")
    void setMatchEffect(t0 r1);

    @FieldName(name = "msg_board_item#setter")
    void setMsgBoardItem(IMessageBoardInfo r1);

    @FieldName(name = "is_paid_linkmic#setter")
    void setPaidLinkMic(Boolean r1);

    @FieldName(name = "pay_count#setter")
    void setPayCount(long r1);

    @FieldName(name = "prompt#setter")
    void setPrompt(String r1);

    @FieldName(name = "prompt_with_earphone#setter")
    void setPromptWithEarphone(String r1);

    @FieldName(name = "token#setter")
    void setToken(String r1);

    @FieldName(name = "version#setter")
    void setVersion(long r1);
}
