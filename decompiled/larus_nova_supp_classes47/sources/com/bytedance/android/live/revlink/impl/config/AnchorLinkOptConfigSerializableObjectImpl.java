package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r11.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\"\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/AnchorLinkOptConfigSerializableObjectImpl;", "Lr11/b;", "", "pkInviteFailedOpt", "Z", "k0", "()Z", "linkReplyFailedOpt", "getLinkReplyFailedOpt", "joinFailedOpt", "getJoinFailedOpt", "autoMatchReplyFix", "getAutoMatchReplyFix", "checkListVersion", "W1", "channelIdOpt", "getChannelIdOpt", "multiMatchOpt", "T2", "pkResetOpt", "getPkResetOpt", "linkResetOpt", "y3", "coupleBeInvitedOpt", "t3", "listRetryEnable", "C6", "listInvalidRetryEnable", "j3", "battleStatsRetryEnable", "h0", "invitePanelShowOpt", "o1", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkOptConfigSerializableObjectImpl implements b {

    @SerializedName("auto_match_reply_fix")
    private final boolean autoMatchReplyFix;

    @SerializedName("battle_stats_retry_enable")
    private final boolean battleStatsRetryEnable;

    @SerializedName("channel_id_opt")
    private final boolean channelIdOpt;

    @SerializedName("check_list_version")
    private final boolean checkListVersion;

    @SerializedName("couple_be_invited_opt")
    private final boolean coupleBeInvitedOpt;

    @SerializedName("invite_panel_show_opt")
    private final boolean invitePanelShowOpt;

    @SerializedName("join_failed_opt")
    private final boolean joinFailedOpt;

    @SerializedName("link_reply_failed_opt")
    private final boolean linkReplyFailedOpt;

    @SerializedName("link_reset_opt")
    private final boolean linkResetOpt;

    @SerializedName("list_invalid_retry_enable")
    private final boolean listInvalidRetryEnable;

    @SerializedName("list_retry_enable")
    private final boolean listRetryEnable;

    @SerializedName("multi_match_opt")
    private final boolean multiMatchOpt;

    @SerializedName("pk_invite_failed_opt")
    private final boolean pkInviteFailedOpt;

    @SerializedName("pk_reset_opt")
    private final boolean pkResetOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/AnchorLinkOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AnchorLinkOptConfigSerializableObjectImpl.class);
        }
    }

    public AnchorLinkOptConfigSerializableObjectImpl() {
        this.pkInviteFailedOpt = true;
        this.linkReplyFailedOpt = true;
        this.joinFailedOpt = true;
        this.autoMatchReplyFix = true;
        this.checkListVersion = true;
        this.channelIdOpt = true;
        this.multiMatchOpt = true;
        this.pkResetOpt = true;
        this.linkResetOpt = true;
        this.coupleBeInvitedOpt = true;
        this.listRetryEnable = true;
        this.listInvalidRetryEnable = true;
        this.battleStatsRetryEnable = true;
        this.invitePanelShowOpt = true;
    }

    @Override // r11.b
    public final boolean C6() {
        return this.listRetryEnable;
    }

    @Override // r11.b
    public final boolean T2() {
        return this.multiMatchOpt;
    }

    @Override // r11.b
    public final boolean W1() {
        return this.checkListVersion;
    }

    @Override // r11.b
    public final boolean h0() {
        return this.battleStatsRetryEnable;
    }

    @Override // r11.b
    public final boolean j3() {
        return this.listInvalidRetryEnable;
    }

    @Override // r11.b
    public final boolean k0() {
        return this.pkInviteFailedOpt;
    }

    @Override // r11.b
    public final boolean o1() {
        return this.invitePanelShowOpt;
    }

    @Override // r11.b
    public final boolean t3() {
        return this.coupleBeInvitedOpt;
    }

    @Override // r11.b
    public final boolean y3() {
        return this.linkResetOpt;
    }
}
