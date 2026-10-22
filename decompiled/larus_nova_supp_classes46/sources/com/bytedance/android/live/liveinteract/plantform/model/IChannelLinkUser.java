package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0013\bg\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0007>?@ABCDR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u0004R\"\u0010\u0012\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u001a\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010!\u001a\u00020\u001b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\n\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\n\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\"\u0010)\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\n\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\"\u0010-\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\n\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\"\u00101\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\n\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R\"\u00108\u001a\u0002028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b7\u0010\n\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010<\u001a\u0004\u0018\u0001028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010\n\u001a\u0004\b9\u00104\"\u0004\b:\u00106¨\u0006E"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUserFlex", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUserFlex", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "userFlex", "getUser", "getUser$annotations", "()V", "user", "", "getLinkStatus", "()I", "setLinkStatus", "(I)V", "getLinkStatus$annotations", "linkStatus", "getLinkType", "setLinkType", "getLinkType$annotations", "linkType", "getSilenceStatus", "setSilenceStatus", "getSilenceStatus$annotations", "silenceStatus", "", "getModifyTime", "()J", "setModifyTime", "(J)V", "getModifyTime$annotations", "modifyTime", "getRoleType", "setRoleType", "getRoleType$annotations", "roleType", "getApplyType", "setApplyType", "getApplyType$annotations", "applyType", "getInviteType", "setInviteType", "getInviteType$annotations", "inviteType", "getLinkerReportor", "setLinkerReportor", "getLinkerReportor$annotations", "linkerReportor", "", "getRtcUserId", "()Ljava/lang/String;", "setRtcUserId", "(Ljava/lang/String;)V", "getRtcUserId$annotations", "rtcUserId", "getExtra", "setExtra", "getExtra$annotations", "extra", "Companion", "ApplyType", "a", "InviteType", "LinkStatus", "RoleType", "SilenceSource", "SilenceStatus", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IChannelLinkUser extends vh7.c<IChannelLinkUser> {
    public static final a Companion = null;
    public static final int LINK_TYPE_AUDIO = 2;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser$ApplyType;", "", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ApplyType {
        public static final int ChannelUserApplyTypeNormal = 1;
        public static final int ChannelUserApplyTypeUnknown = 0;
        public static final a Companion = null;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser$InviteType;", "", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface InviteType {
        public static final int ChannelUserInviteTypeByOwner = 1;
        public static final int ChannelUserInviteTypeUnknown = 0;
        public static final a Companion = null;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser$LinkStatus;", "", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LinkStatus {
        public static final a Companion = null;
        public static final int STATUS_FINISHED = 3;
        public static final int STATUS_LINKED = 2;
        public static final int STATUS_UNKNOWN = 0;
        public static final int STATUS_WAITING = 1;
        public static final int STATUS_WAITING_OR_LINKED = 4;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser$RoleType;", "", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RoleType {
        public static final a Companion = null;
        public static final int TYPE_ROLE_TYPE_APPLIER = 4;
        public static final int TYPE_ROLE_TYPE_INVITEE = 3;
        public static final int TYPE_ROLE_TYPE_LEADER = 1;
        public static final int TYPE_ROLE_TYPE_PLAYER = 2;
        public static final int TYPE_ROLE_TYPE_UNKNOWN = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser$SilenceSource;", "", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SilenceSource {
        public static final int CHECK_SILENCE_STATUS = 2;
        public static final a Companion = null;
        public static final int NORMAL = 1;
        public static final int UNKNOWN = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser$SilenceStatus;", "", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SilenceStatus {
        public static final a Companion = null;
        public static final int STATUS_SILENCE_BY_OWNER = 2;
        public static final int STATUS_SILENCE_BY_SELF = 1;
        public static final int STATUS_SILENCE_PASSIVE = 3;
        public static final int STATUS_UNKNOWN = -1;
        public static final int STATUS_UNSILENCE = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "apply_type")
    int getApplyType();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "invite_type")
    int getInviteType();

    @FieldName(name = "link_status")
    int getLinkStatus();

    @FieldName(name = "link_type")
    int getLinkType();

    @FieldName(name = "linker_reportor")
    int getLinkerReportor();

    @FieldName(name = "modify_time")
    long getModifyTime();

    @FieldName(name = "role_type")
    int getRoleType();

    @FieldName(name = "rtc_user_id")
    String getRtcUserId();

    @FieldName(name = "silence_status")
    int getSilenceStatus();

    @FieldName(name = "user")
    IBaseUser getUser();

    IBaseUser getUserFlex();

    @FieldName(name = "apply_type#setter")
    void setApplyType(int r1);

    @FieldName(name = "extra#setter")
    void setExtra(String r1);

    @FieldName(name = "invite_type#setter")
    void setInviteType(int r1);

    @FieldName(name = "link_status#setter")
    void setLinkStatus(int r1);

    @FieldName(name = "link_type#setter")
    void setLinkType(int r1);

    @FieldName(name = "linker_reportor#setter")
    void setLinkerReportor(int r1);

    @FieldName(name = "modify_time#setter")
    void setModifyTime(long r1);

    @FieldName(name = "role_type#setter")
    void setRoleType(int r1);

    @FieldName(name = "rtc_user_id#setter")
    void setRtcUserId(String r1);

    @FieldName(name = "silence_status#setter")
    void setSilenceStatus(int r1);

    void setUserFlex(IBaseUser r1);
}
