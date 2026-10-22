package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ForMain
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\"\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!R\"\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/i;", "", "", "orderPermissionType", "I", "d", "()I", "setOrderPermissionType", "(I)V", "joinPermissionType", "b", "setJoinPermissionType", "leadChorusSwitch", "c", "setLeadChorusSwitch", "", "assignUserOrderThreshold", "J", "getAssignUserOrderThreshold", "()J", "setAssignUserOrderThreshold", "(J)V", "assignUserJoinThreshold", "getAssignUserJoinThreshold", "setAssignUserJoinThreshold", "assignUserLeadThreshold", "getAssignUserLeadThreshold", "setAssignUserLeadThreshold", "", "isMassChorus", "Z", "()Z", "setMassChorus", "(Z)V", "isSupportChorusGuest", "setSupportChorusGuest", "isJoinChorusGiftInvalid", "e", "setJoinChorusGiftInvalid", "isOrderSongGiftInvalid", "f", "setOrderSongGiftInvalid", "Lcom/bytedance/android/livesdk/chatroom/model/w;", "chorusMixStreamInfo", "Lcom/bytedance/android/livesdk/chatroom/model/w;", "a", "()Lcom/bytedance/android/livesdk/chatroom/model/w;", "setChorusMixStreamInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/w;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i implements vh7.h {

    @SerializedName("assign_user_join_threshold")
    protected long assignUserJoinThreshold;

    @SerializedName("assign_user_lead_threshold")
    protected long assignUserLeadThreshold;

    @SerializedName("assign_user_order_threshold")
    protected long assignUserOrderThreshold;

    @SerializedName("mix_stream_info")
    protected com.bytedance.android.livesdk.chatroom.model.w chorusMixStreamInfo;

    @SerializedName("is_join_chorus_gift_invalid")
    protected boolean isJoinChorusGiftInvalid;

    @SerializedName("is_mass_chorus")
    protected boolean isMassChorus;

    @SerializedName("is_order_song_gift_invalid")
    protected boolean isOrderSongGiftInvalid;

    @SerializedName("is_support_chorus_guest")
    protected boolean isSupportChorusGuest;

    @SerializedName("join_permission_type")
    protected int joinPermissionType;

    @SerializedName("lead_chorus_switch")
    protected int leadChorusSwitch;

    @SerializedName("order_permission_type")
    protected int orderPermissionType;

    public i() {
        this.leadChorusSwitch = 1;
    }

    public final com.bytedance.android.livesdk.chatroom.model.w a() {
        return this.chorusMixStreamInfo;
    }

    public final int b() {
        return this.joinPermissionType;
    }

    public final int c() {
        return this.leadChorusSwitch;
    }

    public final int d() {
        return this.orderPermissionType;
    }

    public final boolean e() {
        return this.isJoinChorusGiftInvalid;
    }

    public final boolean f() {
        return this.isOrderSongGiftInvalid;
    }

    public i(am3.g r6) {
        long r0 = r6.c();
        boolean r2 = false;
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L18;
        switch(r3) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L6;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        this.chorusMixStreamInfo = new com.bytedance.android.livesdk.chatroom.model.w(r6);
        goto L3
    L8:
        this.isOrderSongGiftInvalid = am3.h.a(r6);
        goto L3
    L9:
        this.isJoinChorusGiftInvalid = am3.h.a(r6);
        goto L3
    L10:
        this.isSupportChorusGuest = am3.h.a(r6);
        goto L3
    L11:
        this.isMassChorus = am3.h.a(r6);
        goto L3
    L12:
        this.assignUserLeadThreshold = r6.j();
        goto L3
    L13:
        this.assignUserJoinThreshold = r6.j();
        goto L3
    L14:
        this.assignUserOrderThreshold = r6.j();
        goto L3
    L15:
        this.leadChorusSwitch = r6.i();
        r2 = r2 | true;
        goto L3
    L16:
        this.joinPermissionType = r6.i();
        goto L3
    L17:
        this.orderPermissionType = r6.i();
        goto L3
    L6:
        am3.h.e(r6);
        goto L3
    L18:
        r6.d(r0);
        if ((r2 & true) == true) goto L48;
        this.leadChorusSwitch = 1;
        return;
    }
}
