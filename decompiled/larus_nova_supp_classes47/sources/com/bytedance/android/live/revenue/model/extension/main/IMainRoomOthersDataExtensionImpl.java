package com.bytedance.android.live.revenue.model.extension.main;

import com.bytedance.android.livesdkapi.depend.model.live.IAnchorBottomToolbar;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorTogetherLive;
import com.bytedance.android.livesdkapi.depend.model.live.IAppointmentData;
import com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ICloudCollaborateData;
import com.bytedance.android.livesdkapi.depend.model.live.IDecorationDetail;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMatrixData;
import com.bytedance.android.livesdkapi.depend.model.live.IMorePanelData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010M\u001a\u00020\u0002¢\u0006\u0004\bN\u0010OJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001e\u0010(\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010)8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u00102\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00108\u001a\u0004\u0018\u0001038\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010<\u001a\u0004\u0018\u0001098\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001e\u0010A\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010E\u001a\u0004\u0018\u00010B8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0016\u0010I\u001a\u0004\u0018\u00010F8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001e\u0010L\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bJ\u0010>\"\u0004\bK\u0010@¨\u0006P"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/main/IMainRoomOthersDataExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomOthersData;", "Lcom/bytedance/android/live/revenue/model/extension/main/c;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorBottomToolbar;", "getAnchorBottomToolbar", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGroupLiveData;", "getGroupData", "", "getMV", "()Ljava/lang/Long;", "", "getmRoomChatGuideLocaleCity", Constants.Keys.VERSION, "", "setMV", "(Ljava/lang/Long;)V", "getGroupLiveData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IGroupLiveData;", "groupLiveData", "Lcom/bytedance/android/live/revenue/model/extension/main/b;", "getGiftPanelTopperTray", "()Lcom/bytedance/android/live/revenue/model/extension/main/b;", "giftPanelTopperTray", "Lcom/bytedance/android/live/revenue/model/extension/main/a;", "getEnterGiftAnimation", "()Lcom/bytedance/android/live/revenue/model/extension/main/a;", "enterGiftAnimation", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorTogetherLive;", "getAnchorTogetherLive", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorTogetherLive;", "setAnchorTogetherLive", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorTogetherLive;)V", "anchorTogetherLive", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAppointmentData;", "getAppointmentInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IAppointmentData;", "appointmentInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IChangeRoomInfo;", "getChangeRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IChangeRoomInfo;", "setChangeRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IChangeRoomInfo;)V", "changeRoomInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/ICloudCollaborateData;", "getCloudCollaborateData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ICloudCollaborateData;", "setCloudCollaborateData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ICloudCollaborateData;)V", "cloudCollaborateData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IDecorationDetail;", "getDecoDetail", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IDecorationDetail;", "decoDetail", "getInvitePanelGuideContent", "()Ljava/lang/String;", "setInvitePanelGuideContent", "(Ljava/lang/String;)V", "invitePanelGuideContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMatrixData;", "getLiveMatrixData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMatrixData;", "liveMatrixData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IMorePanelData;", "getMorePanelInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IMorePanelData;", "morePanelInfo", "getParticipantActivity", "setParticipantActivity", "participantActivity", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomOthersData;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainRoomOthersDataExtensionImpl extends ModelExtensionBase<IRoomOthersData, c> implements c, IRoomOthersData {
    private final /* synthetic */ IRoomOthersData $$delegate_0;

    @Override // com.bytedance.android.live.revenue.model.extension.main.c
    public <R extends e<IRoomOthersData>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.c
    public <R extends e<IRoomOthersData>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    public IAnchorBottomToolbar getAnchorBottomToolbar() {
        return this.$$delegate_0.getAnchorBottomToolbar();
    }

    public IAnchorTogetherLive getAnchorTogetherLive() {
        return this.$$delegate_0.getAnchorTogetherLive();
    }

    public IAppointmentData getAppointmentInfo() {
        return this.$$delegate_0.getAppointmentInfo();
    }

    public IChangeRoomInfo getChangeRoomInfo() {
        return this.$$delegate_0.getChangeRoomInfo();
    }

    public ICloudCollaborateData getCloudCollaborateData() {
        return this.$$delegate_0.getCloudCollaborateData();
    }

    public IDecorationDetail getDecoDetail() {
        return this.$$delegate_0.getDecoDetail();
    }

    public IGroupLiveData getGroupData() {
        return this.$$delegate_0.getGroupData();
    }

    public String getInvitePanelGuideContent() {
        return this.$$delegate_0.getInvitePanelGuideContent();
    }

    public ILiveMatrixData getLiveMatrixData() {
        return this.$$delegate_0.getLiveMatrixData();
    }

    public Long getMV() {
        return this.$$delegate_0.getMV();
    }

    public IMorePanelData getMorePanelInfo() {
        return this.$$delegate_0.getMorePanelInfo();
    }

    public String getParticipantActivity() {
        return this.$$delegate_0.getParticipantActivity();
    }

    public String getmRoomChatGuideLocaleCity() {
        return this.$$delegate_0.getmRoomChatGuideLocaleCity();
    }

    public void setAnchorTogetherLive(IAnchorTogetherLive r2) {
        this.$$delegate_0.setAnchorTogetherLive(r2);
    }

    public void setChangeRoomInfo(IChangeRoomInfo r2) {
        this.$$delegate_0.setChangeRoomInfo(r2);
    }

    public void setCloudCollaborateData(ICloudCollaborateData r2) {
        this.$$delegate_0.setCloudCollaborateData(r2);
    }

    public void setInvitePanelGuideContent(String r2) {
        this.$$delegate_0.setInvitePanelGuideContent(r2);
    }

    public void setMV(Long r2) {
        this.$$delegate_0.setMV(r2);
    }

    public void setParticipantActivity(String r2) {
        this.$$delegate_0.setParticipantActivity(r2);
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.c
    public a getEnterGiftAnimation() {
        return (a) get(9, c.class);
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.c
    public b getGiftPanelTopperTray() {
        return (b) get(8, c.class);
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.c
    public IGroupLiveData getGroupLiveData() {
        return (IGroupLiveData) get(11, c.class);
    }

    public IMainRoomOthersDataExtensionImpl(IRoomOthersData r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
