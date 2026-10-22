package e92;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkReplyResult;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public final long a;
    public final int b;
    public final String c;
    public final int d;
    public final String e;
    public final MultiChannelInfo f;
    public final String g;

    public static final class a {
        public long a;
        public int b;
        public String c;
        public MultiChannelInfo d;
        public int e;
        public String f;
        public String g;
        public String h;

        public a() {
            this.c = "0";
            this.f = BuildConfig.FLAVOR;
            this.g = BuildConfig.FLAVOR;
        }

        public final void b(String r3) {
            Intrinsics.checkNotNullParameter(r3, "source");
            this.a = 0;
            this.b = 0;
            this.c = "0";
            this.d = null;
            c(0);
            this.f = BuildConfig.FLAVOR;
            this.g = BuildConfig.FLAVOR;
            this.h = null;
            ALogger.e("MediaLinkTracer", "MultiLinkLaunchParameters.Record reset from " + r3);
        }

        public final void c(int r2) {
            this.e = r2;
            if (r2 != 1) goto L5;
        L12:
            String r3 = "mutual_follow";
        L13:
            this.f = r3;
            return;
        L5:
            if (r2 != 2) goto L7;
        L11:
            r3 = "recommend";
            goto L13
        L7:
            if (r2 == 101) goto L12;
            if (r2 == 102) goto L11;
            r3 = UserListInviteType.a(r2, null);
            goto L13
        }

        public final void a(LinkReplyResult r6, fy.a r7) {
            Intrinsics.checkNotNullParameter(r6, "replyResult");
            Intrinsics.checkNotNullParameter(r7, "replyParams");
            String r0 = r6.getLinkMicIdStr();
            boolean r1 = true;
            if (r0 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            String r3 = String.valueOf(r6.getLinkMicId().longValue());
        L12:
            this.g = r3;
            this.h = r6.getRtcExtInfo();
            s1 r4 = r6.getMultiChannelInfo();
            if (r4 != null) goto L15;
            return;
        L15:
            if (r4.getUseMultiChannel() == false) goto L25;
            Map r5 = r4.getChannelMap();
            if (r5 != null) goto L19;
        L22:
            if (r1 == true) goto L25;
            this.d = r6.getMMultiChannelInfo();
            goto L25
        L19:
            if (r5.isEmpty() == true) goto L22;
            r1 = false;
        L25:
            if (Intrinsics.areEqual(r7.k, this.c) == false) goto L29;
            this.c = "0";
            return;
        L29:
            return;
        L11:
            r3 = String.valueOf(r6.getLinkMicIdStr());
            goto L12
        L5:
            if (r0.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof l) == false) goto L20;
        l r7 = (l) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (((r1 + r4) * 31) + this.d) * 31;
        String r6 = this.e;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        MultiChannelInfo r9 = this.f;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        String r13 = this.g;
        if (r13 == null) goto L18;
        r3 = r13.hashCode();
    L18:
        return r11 + r3;
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "MediaMultiLinkLaunchParameters(channelID=" + this.a + ", matchType=" + this.b + ", linkerID=" + this.c + ", inviteType=" + this.d + ", inviteeList=" + this.e + ", multiChannelInfo=" + this.f + ", rtcInfo=" + this.g + ")";
    }

    public l(a r9) {
        long r0 = r9.a;
        int r2 = r9.b;
        String r3 = r9.g;
        int r4 = r9.e;
        String r5 = r9.f;
        MultiChannelInfo r6 = r9.d;
        String r10 = r9.h;
        Intrinsics.checkNotNullParameter(r3, "linkerID");
        Intrinsics.checkNotNullParameter(r5, "inviteeList");
        this.a = r0;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r10;
    }
}
