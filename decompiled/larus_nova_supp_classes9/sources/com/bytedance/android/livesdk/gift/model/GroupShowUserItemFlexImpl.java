package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GroupShowUserItem")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bI\u0010JR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R+\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010!\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR+\u0010%\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR+\u0010,\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020&8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R/\u00103\u001a\u0004\u0018\u00010-2\b\u0010\u0004\u001a\u0004\u0018\u00010-8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u00100\"\u0004\b1\u00102R/\u00107\u001a\u0004\u0018\u00010-2\b\u0010\u0004\u001a\u0004\u0018\u00010-8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0006\u001a\u0004\b5\u00100\"\u0004\b6\u00102R/\u0010>\u001a\u0004\u0018\u0001082\b\u0010\u0004\u001a\u0004\u0018\u0001088V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0006\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R+\u0010A\u001a\u00020?2\u0006\u0010\u0004\u001a\u00020?8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\u0006\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR+\u0010H\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020&8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0006\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GroupShowUserItemFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/y0;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "<set-?>", "groupShowUser$delegate", "Ljava/lang/Object;", "getGroupShowUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setGroupShowUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "groupShowUser", BuildConfig.FLAVOR, "description$delegate", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "description", "sendButtonText$delegate", "getSendButtonText", "setSendButtonText", "sendButtonText", BuildConfig.FLAVOR, "fanTicketCount$delegate", "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "fanTicketCount", "curRoundFanTicketCount$delegate", "getCurRoundFanTicketCount", "setCurRoundFanTicketCount", "curRoundFanTicketCount", "showEndTime$delegate", "getShowEndTime", "setShowEndTime", "showEndTime", BuildConfig.FLAVOR, "anchorType$delegate", "getAnchorType", "()I", "setAnchorType", "(I)V", "anchorType", "Lpy/k;", "avatarBorder$delegate", "getAvatarBorder", "()Lpy/k;", "setAvatarBorder", "(Lpy/k;)V", "avatarBorder", "bestShowerBgImage$delegate", "getBestShowerBgImage", "setBestShowerBgImage", "bestShowerBgImage", "Lcom/bytedance/android/livesdk/gift/model/p3;", "showStatusLabel$delegate", "getShowStatusLabel", "()Lcom/bytedance/android/livesdk/gift/model/p3;", "setShowStatusLabel", "(Lcom/bytedance/android/livesdk/gift/model/p3;)V", "showStatusLabel", BuildConfig.FLAVOR, "isBestUser$delegate", "isBestUser", "()Z", "setBestUser", "(Z)V", "showStatus$delegate", "getShowStatus", "setShowStatus", "showStatus", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupShowUserItemFlexImpl extends FlexModelBase<y0> implements y0, vh7.h {

    @SerializedName("identity_label")
    protected int _$$anchorType;

    @SerializedName("live_avatar_frame_image")
    protected py.k _$$avatarBorder;

    @SerializedName("bg_image")
    protected py.k _$$bestShowerBgImage;

    @SerializedName("group_show_cur_round_fan_ticket_count")
    protected long _$$curRoundFanTicketCount;

    @SerializedName("description")
    protected String _$$description;

    @SerializedName("group_show_fan_ticket_count")
    protected long _$$fanTicketCount;

    @SerializedName("group_show_user")
    protected IBaseUser _$$groupShowUser;

    @SerializedName("is_best_shower")
    protected boolean _$$isBestUser;

    @SerializedName("send_button_text")
    protected String _$$sendButtonText;

    @SerializedName("show_end_time")
    protected long _$$showEndTime;

    @SerializedName("show_status")
    protected int _$$showStatus;

    @SerializedName("show_status_label")
    protected p3 _$$showStatusLabel;

    public GroupShowUserItemFlexImpl() {
        super(y0.class);
        this._$$groupShowUser = $defaultValue_groupShowUser$();
        this._$$isBestUser = false;
    }

    public final IBaseUser $defaultValue_groupShowUser$() {
        return (IBaseUser) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IBaseUser.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final int getAnchorType() {
        return this._$$anchorType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final py.k getAvatarBorder() {
        return this._$$avatarBorder;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final py.k getBestShowerBgImage() {
        return this._$$bestShowerBgImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final long getCurRoundFanTicketCount() {
        return this._$$curRoundFanTicketCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final String getDescription() {
        return this._$$description;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final long getFanTicketCount() {
        return this._$$fanTicketCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final IBaseUser getGroupShowUser() {
        return this._$$groupShowUser;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final String getSendButtonText() {
        return this._$$sendButtonText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final long getShowEndTime() {
        return this._$$showEndTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final int getShowStatus() {
        return this._$$showStatus;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final p3 getShowStatusLabel() {
        return this._$$showStatusLabel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final boolean isBestUser() {
        return this._$$isBestUser;
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.bytedance.android.livesdk.gift.model.p3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public GroupShowUserItemFlexImpl(am3.g r7) {
        super(y0.class);
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L20;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        this._$$showStatus = r7.i();
        r3 = r3 | 32;
        goto L3
    L9:
        this._$$isBestUser = am3.h.a(r7);
        r3 = r3 | 16;
        goto L3
    L10:
        this._$$showStatusLabel = vh7.f.a(r7, p3.class);
        goto L3
    L11:
        this._$$bestShowerBgImage = vh7.f.a(r7, py.k.class);
        goto L3
    L12:
        this._$$avatarBorder = vh7.f.a(r7, py.k.class);
        goto L3
    L13:
        this._$$anchorType = r7.i();
        r3 = r3 | 8;
        goto L3
    L14:
        this._$$showEndTime = r7.j();
        r3 = r3 | 4;
        goto L3
    L15:
        this._$$curRoundFanTicketCount = r7.j();
        r3 = r3 | 2;
        goto L3
    L16:
        this._$$fanTicketCount = r7.j();
        r3 = r3 | 1;
        goto L3
    L17:
        this._$$sendButtonText = am3.h.c(r7);
        goto L3
    L18:
        this._$$description = am3.h.c(r7);
        goto L3
    L19:
        this._$$groupShowUser = vh7.f.a(r7, IBaseUser.class);
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L20:
        r7.d(r1);
        setThreadSafe(true);
        if (this._$$groupShowUser != null) goto L24;
        this._$$groupShowUser = $defaultValue_groupShowUser$();
    L24:
        if ((r3 & 16) != 0) goto L55;
        this._$$isBestUser = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setAnchorType(int r1) {
        this._$$anchorType = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setAvatarBorder(py.k r1) {
        this._$$avatarBorder = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setBestShowerBgImage(py.k r1) {
        this._$$bestShowerBgImage = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setBestUser(boolean r1) {
        this._$$isBestUser = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setCurRoundFanTicketCount(long r1) {
        this._$$curRoundFanTicketCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setDescription(String r1) {
        this._$$description = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setFanTicketCount(long r1) {
        this._$$fanTicketCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setGroupShowUser(IBaseUser r1) {
        this._$$groupShowUser = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setSendButtonText(String r1) {
        this._$$sendButtonText = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setShowEndTime(long r1) {
        this._$$showEndTime = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setShowStatus(int r1) {
        this._$$showStatus = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y0
    public final void setShowStatusLabel(p3 r1) {
        this._$$showStatusLabel = r1;
    }
}
