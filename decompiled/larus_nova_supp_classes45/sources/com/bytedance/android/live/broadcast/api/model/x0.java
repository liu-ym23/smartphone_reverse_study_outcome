package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.model.component.BottomToolBarComponent;
import com.bytedance.android.live.broadcast.api.model.component.CategoryComponent;
import com.bytedance.android.live.broadcast.api.model.component.ComponentConfig;
import com.bytedance.android.live.broadcast.api.model.component.CreateButtonComponent;
import com.bytedance.android.live.broadcast.api.model.component.CustomerServiceComponent;
import com.bytedance.android.live.broadcast.api.model.component.LiveTopicComponent;
import com.bytedance.android.live.broadcast.api.model.component.TopAreaComponent;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.PreCreateInfoResponse.Data")
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bX\u0010YR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R0\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010A\u001a\u0004\u0018\u00010@8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010H\u001a\u0004\u0018\u00010G8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010O\u001a\u0004\u0018\u00010N8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006Z"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/x0;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "mCover", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "mCoverAuditStatus", "J", "", "mTitle", "Ljava/lang/String;", "", "Lcom/bytedance/android/live/broadcast/api/model/RoomCreateInfo$a;", "recommendAiCovers", "Ljava/util/List;", "avatarWithBackground", "", "mIsFirstBroadcastFlag", "I", "Lcom/bytedance/android/live/broadcast/api/model/b0;", "createPageConfig", "Lcom/bytedance/android/live/broadcast/api/model/b0;", "mNewAnchorFlag", "interceptStrategy", "Lcom/bytedance/android/live/broadcast/api/model/p;", "audienceLinkmicInfo", "Lcom/bytedance/android/live/broadcast/api/model/p;", "lastLiveRoomMode", "", "Lcom/bytedance/android/live/broadcast/api/model/component/ComponentConfig;", "componentConfig", "Ljava/util/Map;", "getComponentConfig", "()Ljava/util/Map;", "setComponentConfig", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/TopAreaComponent;", "topAreaComponentConfig", "Lcom/bytedance/android/live/broadcast/api/model/component/TopAreaComponent;", "getTopAreaComponentConfig", "()Lcom/bytedance/android/live/broadcast/api/model/component/TopAreaComponent;", "setTopAreaComponentConfig", "(Lcom/bytedance/android/live/broadcast/api/model/component/TopAreaComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/CustomerServiceComponent;", "customerServiceComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/CustomerServiceComponent;", "getCustomerServiceComponent", "()Lcom/bytedance/android/live/broadcast/api/model/component/CustomerServiceComponent;", "setCustomerServiceComponent", "(Lcom/bytedance/android/live/broadcast/api/model/component/CustomerServiceComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/CreateButtonComponent;", "createButtonComponentConfig", "Lcom/bytedance/android/live/broadcast/api/model/component/CreateButtonComponent;", "getCreateButtonComponentConfig", "()Lcom/bytedance/android/live/broadcast/api/model/component/CreateButtonComponent;", "setCreateButtonComponentConfig", "(Lcom/bytedance/android/live/broadcast/api/model/component/CreateButtonComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/b;", "createModeComponentConfig", "Lcom/bytedance/android/live/broadcast/api/model/component/b;", "getCreateModeComponentConfig", "()Lcom/bytedance/android/live/broadcast/api/model/component/b;", "setCreateModeComponentConfig", "(Lcom/bytedance/android/live/broadcast/api/model/component/b;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/BottomToolBarComponent;", "bottomToolBarComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/BottomToolBarComponent;", "getBottomToolBarComponent", "()Lcom/bytedance/android/live/broadcast/api/model/component/BottomToolBarComponent;", "setBottomToolBarComponent", "(Lcom/bytedance/android/live/broadcast/api/model/component/BottomToolBarComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/CategoryComponent;", "categoryComponentConfig", "Lcom/bytedance/android/live/broadcast/api/model/component/CategoryComponent;", "getCategoryComponentConfig", "()Lcom/bytedance/android/live/broadcast/api/model/component/CategoryComponent;", "setCategoryComponentConfig", "(Lcom/bytedance/android/live/broadcast/api/model/component/CategoryComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/component/LiveTopicComponent;", "liveTopicComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/LiveTopicComponent;", "getLiveTopicComponent", "()Lcom/bytedance/android/live/broadcast/api/model/component/LiveTopicComponent;", "setLiveTopicComponent", "(Lcom/bytedance/android/live/broadcast/api/model/component/LiveTopicComponent;)V", "Lcom/bytedance/android/live/broadcast/api/model/v;", "configInfoPre", "Lcom/bytedance/android/live/broadcast/api/model/v;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x0 implements vh7.h {

    @SerializedName("audience_linkmic_info")
    public p audienceLinkmicInfo;

    @SerializedName("avatar_with_background")
    public ImageModel avatarWithBackground;

    @SerializedName("bottom_toolbar_component")
    protected BottomToolBarComponent bottomToolBarComponent;

    @SerializedName("category_component")
    protected CategoryComponent categoryComponentConfig;

    @SerializedName("component_config")
    protected Map<Integer, ComponentConfig> componentConfig;

    @SerializedName("config_info_pre")
    public v configInfoPre;

    @SerializedName("create_button_component")
    protected CreateButtonComponent createButtonComponentConfig;

    @SerializedName("create_mode_component")
    protected com.bytedance.android.live.broadcast.api.model.component.b createModeComponentConfig;

    @SerializedName("create_page_config_pre")
    public b0 createPageConfig;

    @SerializedName("customer_service_component")
    protected CustomerServiceComponent customerServiceComponent;

    @SerializedName("live_guide_intercept_strategy")
    public int interceptStrategy;

    @SerializedName("last_live_room_mode")
    public int lastLiveRoomMode;

    @SerializedName("live_topic_component")
    protected LiveTopicComponent liveTopicComponent;

    @SerializedName("cover")
    public ImageModel mCover;

    @SerializedName("cover_audit_status")
    public long mCoverAuditStatus;

    @SerializedName("never_go_live_flag")
    public int mIsFirstBroadcastFlag;

    @SerializedName("new_anchor_flag")
    public int mNewAnchorFlag;

    @SerializedName("title")
    public String mTitle;

    @SerializedName("recommend_ai_covers")
    public List<RoomCreateInfo.a> recommendAiCovers;

    @SerializedName("top_area_component")
    protected TopAreaComponent topAreaComponentConfig;

    public x0() {
    }

    public x0(am3.g r11) {
        this.recommendAiCovers = new ArrayList();
        this.componentConfig = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L54;
        if (r2 != 62) goto L8;
        this.audienceLinkmicInfo = new p(r11);
        goto L3
    L8:
        if (r2 != 209) goto L10;
        this.liveTopicComponent = new LiveTopicComponent(r11);
        goto L3
    L10:
        if (r2 != 200) goto L12;
        long r4 = r11.c();
        Integer r3 = null;
        ComponentConfig r6 = null;
    L35:
        int r7 = r11.f();
        if (r7 == (-1)) goto L44;
        if (r7 != 1) goto L40;
        r3 = Integer.valueOf(r11.i());
        goto L35
    L40:
        if (r7 != 2) goto L41;
        r6 = new ComponentConfig(r11);
        goto L35
    L41:
        am3.h.e(r11);
        goto L35
    L44:
        r11.d(r4);
        Map<Integer, ComponentConfig> r5 = this.componentConfig;
        if (r3 == null) goto L51;
        if (r6 == null) goto L49;
        r5.put(r3, r6);
        goto L3
    L49:
        throw new IllegalStateException("Value must not be null");
    L51:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r2 != 201) goto L13;
        this.topAreaComponentConfig = new TopAreaComponent(r11);
        goto L3
    L13:
        switch(r2) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            default: goto L14;
        };
    L25:
        this.configInfoPre = new v(r11);
        goto L3
    L26:
        this.interceptStrategy = r11.i();
        goto L3
    L27:
        this.mNewAnchorFlag = (int) r11.j();
        goto L3
    L28:
        this.createPageConfig = new b0(r11);
        goto L3
    L29:
        this.mIsFirstBroadcastFlag = (int) r11.j();
        goto L3
    L30:
        this.mTitle = am3.h.c(r11);
        goto L3
    L31:
        this.mCoverAuditStatus = r11.j();
        goto L3
    L32:
        this.mCover = com.bytedance.android.live.base.model.x.a(r11);
        goto L3
    L14:
        switch(r2) {
            case 64: goto L24;
            case 65: goto L23;
            case 66: goto L22;
            default: goto L15;
        };
    L22:
        this.avatarWithBackground = com.bytedance.android.live.base.model.x.a(r11);
        goto L3
    L23:
        this.recommendAiCovers.add(new RoomCreateInfo.a(r11));
        goto L3
    L24:
        this.lastLiveRoomMode = r11.i();
        goto L3
    L15:
        switch(r2) {
            case 203: goto L21;
            case 204: goto L20;
            case 205: goto L19;
            case 206: goto L18;
            case 207: goto L17;
            default: goto L16;
        };
    L17:
        this.customerServiceComponent = new CustomerServiceComponent(r11);
        goto L3
    L18:
        this.categoryComponentConfig = new CategoryComponent(r11);
        goto L3
    L19:
        this.bottomToolBarComponent = new BottomToolBarComponent(r11);
        goto L3
    L20:
        this.createModeComponentConfig = new com.bytedance.android.live.broadcast.api.model.component.b(r11);
        goto L3
    L21:
        this.createButtonComponentConfig = new CreateButtonComponent(r11);
        goto L3
    L16:
        am3.h.e(r11);
        goto L3
    L54:
        r11.d(r0);
    }
}
