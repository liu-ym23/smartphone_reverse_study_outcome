package com.bytedance.android.livesdk.interactivity.chatchannel.model;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.fifa.core.IChannelLinkService;
import com.bytedance.bdlocation.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChannelLinkUserInfo {
    public final User a;
    public a b;
    public final LinkUserInfo c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/model/ChannelLinkUserInfo$ChannelUserRole;", BuildConfig.FLAVOR, "UNKNOWN", "Manager", "Audience", "Guest", "LinkApplicant", "LinkInvitee", "GuestApplicant", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ChannelUserRole extends Enum<ChannelUserRole> {
        public static final ChannelUserRole Audience = null;
        public static final ChannelUserRole Guest = null;
        public static final ChannelUserRole GuestApplicant = null;
        public static final ChannelUserRole LinkApplicant = null;
        public static final ChannelUserRole LinkInvitee = null;
        public static final ChannelUserRole Manager = null;
        public static final ChannelUserRole UNKNOWN = null;
        public static final /* synthetic */ ChannelUserRole[] a = null;

        static {
            ChannelUserRole r1 = new ChannelUserRole("UNKNOWN", 0);
            UNKNOWN = r1;
            ChannelUserRole r2 = new ChannelUserRole("Manager", 1);
            Manager = r2;
            ChannelUserRole r3 = new ChannelUserRole("Audience", 2);
            Audience = r3;
            ChannelUserRole r4 = new ChannelUserRole("Guest", 3);
            Guest = r4;
            ChannelUserRole r5 = new ChannelUserRole("LinkApplicant", 4);
            LinkApplicant = r5;
            ChannelUserRole r6 = new ChannelUserRole("LinkInvitee", 5);
            LinkInvitee = r6;
            ChannelUserRole r7 = new ChannelUserRole("GuestApplicant", 6);
            GuestApplicant = r7;
            a = new ChannelUserRole[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static ChannelUserRole valueOf(String r1) {
            return (ChannelUserRole) r27.a.a(ChannelUserRole.class, r1);
        }

        public static ChannelUserRole[] values() {
            return (ChannelUserRole[]) a.clone();
        }

        public ChannelUserRole(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/model/ChannelLinkUserInfo$LinkUserInfo;", "Ljava/io/Serializable;", "rtcUserId", BuildConfig.FLAVOR, "linkStatus", BuildConfig.FLAVOR, "silenceStatus", "volumeLevel", "Lcom/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;", "(Ljava/lang/String;IILcom/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;)V", "getLinkStatus", "()I", "getRtcUserId", "()Ljava/lang/String;", "getSilenceStatus", "getVolumeLevel", "()Lcom/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LinkUserInfo implements Serializable {
        private final int linkStatus;
        private final String rtcUserId;
        private final int silenceStatus;
        private final IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel volumeLevel;

        public final int getLinkStatus() {
            return this.linkStatus;
        }

        public final String getRtcUserId() {
            return this.rtcUserId;
        }

        public final int getSilenceStatus() {
            return this.silenceStatus;
        }

        public final IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel getVolumeLevel() {
            return this.volumeLevel;
        }

        public LinkUserInfo(String r2, int r3, int r4, IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r5) {
            Intrinsics.checkNotNullParameter(r2, "rtcUserId");
            Intrinsics.checkNotNullParameter(r5, "volumeLevel");
            this.rtcUserId = r2;
            this.linkStatus = r3;
            this.silenceStatus = r4;
            this.volumeLevel = r5;
        }
    }

    public static final class a {
        public final ChannelUserRole a;
        public final boolean b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            ChannelUserRole r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = r3;
            if (r3 == false) goto L10;
            r4 = 1;
        L10:
            return r2 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "ChannelUserInfo(channelUserRole=" + this.a + ", channelLinkMicSwitch=" + this.b + ")";
        }

        public a(ChannelUserRole r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "channelUserRole");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    static {
    }

    public ChannelLinkUserInfo(User r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "channelUserInfo");
        this.a = r2;
        this.b = r3;
        this.c = null;
    }
}
