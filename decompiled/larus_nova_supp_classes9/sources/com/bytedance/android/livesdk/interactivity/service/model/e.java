package com.bytedance.android.livesdk.interactivity.service.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/model/e;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "publicScreenMessage", "Z", "hotMsgTray", "messageBackground", "memberText", "chatAuthTip", "controlMessage", "roomNoticeMessage", "audiencePSHeightSetting", "firstMessageShowOpt", "anchorColdMsgShowOpt", "<init>", "()V", "a", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {
    public static final /* synthetic */ int a = 0;

    @SerializedName("anchor_cold_msg_show_opt")
    public boolean anchorColdMsgShowOpt;

    @SerializedName("audience_ps_height_setting")
    public boolean audiencePSHeightSetting;

    @SerializedName("chat_auth_tip")
    public boolean chatAuthTip;

    @SerializedName("control_message")
    public boolean controlMessage;

    @SerializedName("first_message_show_opt")
    public boolean firstMessageShowOpt;

    @SerializedName("hot_msg_tray")
    public boolean hotMsgTray;

    @SerializedName("member_text")
    public boolean memberText;

    @SerializedName("message_background")
    public boolean messageBackground;

    @SerializedName("public_screen_message")
    public boolean publicScreenMessage;

    @SerializedName("room_notice_message")
    public boolean roomNoticeMessage;

    public static final class a {
        @JvmStatic
        public static e a() {
            return (e) com.bytedance.android.livesdk.interactivity.service.settings.c.a.getValue();
        }
    }

    static {
    }

    public e() {
        this.publicScreenMessage = true;
        this.hotMsgTray = true;
        this.messageBackground = true;
        this.memberText = true;
        this.chatAuthTip = true;
        this.controlMessage = true;
        this.roomNoticeMessage = true;
        this.audiencePSHeightSetting = true;
        this.firstMessageShowOpt = true;
        this.anchorColdMsgShowOpt = true;
    }
}
