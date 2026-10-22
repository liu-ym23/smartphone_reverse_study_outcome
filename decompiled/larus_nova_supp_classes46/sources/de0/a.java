package de0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.fifa.core.IChannelLinkService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int i = 0;
    public final IBaseUser a;
    public final String b;
    public final IChannelLinkService.ICurrentUserLinkStatus.RtcUserRole c;
    public final IChannelLinkService.ICurrentUserLinkStatus.AudioCaptureState d;
    public final IChannelLinkService.ICurrentUserLinkStatus.AudioPublishState e;
    public final int f;
    public final int g;
    public final IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel h;

    /* JADX INFO: renamed from: de0.a$a, reason: collision with other inner class name */
    public static final class C0195a {
    }

    static {
    }

    public final int hashCode() {
        return (((((((((((((this.a.getIdString().hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f) * 31) + this.g) * 31) + this.h.hashCode();
    }

    public final String toString() {
        return "ChannelCurrentUserLinkStatus(user=" + this.a + ", rtcUserId=" + this.b + ", rtcUserRole=" + this.c + ", localAudioCaptureState=" + this.d + ", localAudioPublishState=" + this.e + ", linkStatus=" + this.f + ", silenceStatus=" + this.g + ", volumeLevel=" + this.h + ")";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L39;
        a r6 = (a) r5;
        if ((!Intrinsics.areEqual(this.a.getIdString(), r6.a.getIdString())) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.b, r6.b)) == false) goto L20;
        return false;
    L20:
        if (this.c == r6.c) goto L23;
        return false;
    L23:
        if (this.d == r6.d) goto L26;
        return false;
    L26:
        if (this.e == r6.e) goto L29;
        return false;
    L29:
        if (this.f == r6.f) goto L32;
        return false;
    L32:
        if (this.g == r6.g) goto L35;
        return false;
    L35:
        if (this.h == r6.h) goto L37;
        return false;
    L37:
        return true;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.channel.model.ChannelCurrentUserLinkStatus");
    L8:
        r2 = null;
        goto L10
    }

    public a(IBaseUser r3, IChannelLinkService.ICurrentUserLinkStatus.RtcUserRole r4, IChannelLinkService.ICurrentUserLinkStatus.AudioCaptureState r5, IChannelLinkService.ICurrentUserLinkStatus.AudioPublishState r6, IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r7) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter("", "rtcUserId");
        Intrinsics.checkNotNullParameter(r4, "rtcUserRole");
        Intrinsics.checkNotNullParameter(r5, "localAudioCaptureState");
        Intrinsics.checkNotNullParameter(r6, "localAudioPublishState");
        Intrinsics.checkNotNullParameter(r7, "volumeLevel");
        this.a = r3;
        this.b = "";
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = 0;
        this.g = -1;
        this.h = r7;
    }
}
