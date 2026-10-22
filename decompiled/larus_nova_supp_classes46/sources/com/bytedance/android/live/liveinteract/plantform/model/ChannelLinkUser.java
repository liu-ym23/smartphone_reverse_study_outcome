package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.ChannelListUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0007CDEFGHIB\u0007¢\u0006\u0004\bA\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R(\u0010\u0016\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0004\b\u0016\u0010\f\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010\u001b\u001a\u00020\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0004\b!\u0010\f\u0012\u0004\b$\u0010\u0012\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R(\u0010%\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0004\b%\u0010\f\u0012\u0004\b(\u0010\u0012\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R(\u0010)\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0004\b)\u0010\f\u0012\u0004\b,\u0010\u0012\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\"\u0010-\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R\"\u00101\u001a\u0002008\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R(\u0010@\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006J"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ChannelLinkUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser;", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "getUser", "()Lcom/bytedance/android/live/base/model/user/User;", "setUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "", "linkStatus", "I", "getLinkStatus", "()I", "setLinkStatus", "(I)V", "getLinkStatus$annotations", "()V", "linkType", "getLinkType", "setLinkType", "silenceStatus", "getSilenceStatus", "setSilenceStatus", "getSilenceStatus$annotations", "", "modifyTime", "J", "getModifyTime", "()J", "setModifyTime", "(J)V", "roleType", "getRoleType", "setRoleType", "getRoleType$annotations", "applyType", "getApplyType", "setApplyType", "getApplyType$annotations", "inviteType", "getInviteType", "setInviteType", "getInviteType$annotations", "linkerReportor", "getLinkerReportor", "setLinkerReportor", "", "rtcUserId", "Ljava/lang/String;", "getRtcUserId", "()Ljava/lang/String;", "setRtcUserId", "(Ljava/lang/String;)V", "extra", "getExtra", "setExtra", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "value", "getUserFlex", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUserFlex", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "userFlex", "<init>", "Companion", "ApplyType", "a", "InviteType", "LinkStatus", "RoleType", "SilenceSource", "SilenceStatus", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelLinkUser extends FlexModelBase<IChannelLinkUser> implements IChannelLinkUser, vh7.h {
    public static final a Companion = null;
    public static final int LINK_TYPE_AUDIO = 2;

    @SerializedName("apply_type")
    protected int applyType;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("invite_type")
    protected int inviteType;

    @SerializedName("link_status")
    protected int linkStatus;

    @SerializedName("link_type")
    protected int linkType;

    @SerializedName("linker_reportor")
    protected int linkerReportor;

    @SerializedName("modify_time")
    protected long modifyTime;

    @SerializedName("role_type")
    protected int roleType;

    @SerializedName("rtc_user_id")
    protected String rtcUserId;

    @SerializedName("silence_status")
    protected int silenceStatus;

    @SerializedName("user")
    protected User user;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ChannelLinkUser$ApplyType;", "", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ChannelLinkUser$InviteType;", "", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ChannelLinkUser$LinkStatus;", "", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ChannelLinkUser$RoleType;", "", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ChannelLinkUser$SilenceSource;", "", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ChannelLinkUser$SilenceStatus;", "", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
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
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void getApplyType$annotations() {
    }

    public static /* synthetic */ void getInviteType$annotations() {
    }

    public static /* synthetic */ void getLinkStatus$annotations() {
    }

    public static /* synthetic */ void getRoleType$annotations() {
    }

    public static /* synthetic */ void getSilenceStatus$annotations() {
    }

    public ChannelLinkUser() {
        super(IChannelLinkUser.class);
        this.rtcUserId = "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public /* bridge */ /* synthetic */ IBaseUser getUser() {
        return m253getUser();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public IBaseUser getUserFlex() {
        return m253getUser();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public int getApplyType() {
        return this.applyType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public int getInviteType() {
        return this.inviteType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public int getLinkStatus() {
        return this.linkStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public int getLinkType() {
        return this.linkType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public int getLinkerReportor() {
        return this.linkerReportor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public long getModifyTime() {
        return this.modifyTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public int getRoleType() {
        return this.roleType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public String getRtcUserId() {
        return this.rtcUserId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public int getSilenceStatus() {
        return this.silenceStatus;
    }

    /* JADX INFO: renamed from: getUser, reason: collision with other method in class */
    public User m253getUser() {
        return this.user;
    }

    public ChannelLinkUser(am3.g r6) {
        super(IChannelLinkUser.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L30;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.user = new User(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.linkStatus = r6.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.linkType = r6.i();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.silenceStatus = r6.i();
        goto L3
    L14:
        if (r2 != 5) goto L16;
        this.modifyTime = r6.j();
        goto L3
    L16:
        if (r2 != 200) goto L17;
        this.extra = am3.h.c(r6);
        goto L3
    L17:
        switch(r2) {
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            default: goto L18;
        };
    L19:
        this.rtcUserId = am3.h.c(r6);
        goto L3
    L20:
        this.linkerReportor = (int) r6.j();
        goto L3
    L21:
        this.inviteType = r6.i();
        goto L3
    L22:
        this.applyType = r6.i();
        goto L3
    L23:
        this.roleType = r6.i();
        goto L3
    L18:
        am3.h.d(r3, r6);
        goto L3
    L30:
        r6.d(r0);
        setThreadSafe(true);
        if (this.rtcUserId != null) goto L66;
        this.rtcUserId = "";
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setApplyType(int r1) {
        this.applyType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setExtra(String r1) {
        this.extra = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setInviteType(int r1) {
        this.inviteType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setLinkStatus(int r1) {
        this.linkStatus = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setLinkType(int r1) {
        this.linkType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setLinkerReportor(int r1) {
        this.linkerReportor = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setModifyTime(long r1) {
        this.modifyTime = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setRoleType(int r1) {
        this.roleType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setRtcUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rtcUserId = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setSilenceStatus(int r1) {
        this.silenceStatus = r1;
    }

    public void setUser(User r1) {
        this.user = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser
    public void setUserFlex(IBaseUser r2) {
        if ((r2 instanceof User) == true) goto L5;
        r2 = null;
    L5:
        setUser((User) r2);
    }
}
