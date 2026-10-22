package com.bytedance.android.live.revlink.impl.pk.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkInviteLogDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.n;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.b9;
import com.bytedance.android.livesdk.link.model.bridge.k2;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface IPKLinkBizDataService {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService$OpenBattleSource;", "", "", "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "JoinChannel", "SEIAck", "RTSAck", "SwitchFromAnchor", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum OpenBattleSource extends Enum<OpenBattleSource> {
        public static final OpenBattleSource JoinChannel = null;
        public static final OpenBattleSource RTSAck = null;
        public static final OpenBattleSource SEIAck = null;
        public static final OpenBattleSource SwitchFromAnchor = null;
        public static final /* synthetic */ OpenBattleSource[] a = null;
        private final String source;

        static {
            OpenBattleSource r1 = new OpenBattleSource("JoinChannel", 0, "join_channel");
            JoinChannel = r1;
            OpenBattleSource r2 = new OpenBattleSource("SEIAck", 1, "sei_ack");
            SEIAck = r2;
            OpenBattleSource r3 = new OpenBattleSource("RTSAck", 2, "rts_ack");
            RTSAck = r3;
            OpenBattleSource r4 = new OpenBattleSource("SwitchFromAnchor", 3, "switch_from_anchor");
            SwitchFromAnchor = r4;
            a = new OpenBattleSource[]{r1, r2, r3, r4};
        }

        public static OpenBattleSource valueOf(String r1) {
            return (OpenBattleSource) r27.a.a(OpenBattleSource.class, r1);
        }

        public static OpenBattleSource[] values() {
            return (OpenBattleSource[]) a.clone();
        }

        public final String getSource() {
            return this.source;
        }

        public OpenBattleSource(String r1, int r2, String r3) {
            super(r1, r2);
            this.source = r3;
        }
    }

    public static final class a {
        public final boolean a;
        public final String b;

        public a() {
            this(false, "");
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = r1 * 31;
            String r3 = this.b;
            if (r3 == null) goto L8;
            int r4 = r3.hashCode();
        L10:
            return r2 + r4;
        L8:
            r4 = 0;
            goto L10
        }

        public final String toString() {
            return "ActivityPkParams(isActivityPk=" + this.a + ", activityName=" + this.b + ")";
        }

        public a(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "activityName");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public static String a(IPKLinkBizDataService r3, String r4) {
            cy0.e.a.getClass();
            cy0.j r1 = cy0.e.a.a;
            m.e.getClass();
            Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
            Intrinsics.checkNotNull(r0);
            IBaseUser r2 = ((com.bytedance.live.kmp.core.c) r0).b();
            if (r2 == null) goto L5;
            String r5 = r2.getIdString();
        L7:
            return r3.getTransformReason(r4, r5);
        L5:
            r5 = null;
            goto L7
        }

        public static /* synthetic */ void b(IPKLinkBizDataService r10, IRoom r12, long r13, String r14, String r15, int r16, int r17, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f r18) {
            r10.invite(r12, r13, r14, r15, r16, r17, r18, null);
        }
    }

    public static final class c {
        public final long a;
        public final String b;
        public final IBaseUser c;
        public final IRoom d;
        public final String e;
        public final k2 f;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof c) == false) goto L18;
            c r7 = (c) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            IBaseUser r6 = this.c;
            if (r6 == null) goto L9;
            int r7 = r6.hashCode();
        L10:
            int r8 = (r5 + r7) * 31;
            IRoom r9 = this.d;
            if (r9 == null) goto L13;
            int r10 = r9.hashCode();
        L14:
            int r12 = (r8 + r10) * 31;
            String r13 = this.e;
            if (r13 == null) goto L17;
            int r14 = r13.hashCode();
        L18:
            int r15 = (r12 + r14) * 31;
            k2 r16 = this.f;
            if (r16 == null) goto L22;
            r3 = r16.hashCode();
        L22:
            return r15 + r3;
        L17:
            r14 = 0;
            goto L18
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
            return "GuestInfo(guestRoomId=" + this.a + ", guestUserId=" + this.b + ", guestUser=" + this.c + ", guestRoom=" + this.d + ", inviteeID=" + this.e + ", guestVersionInfo=" + this.f + ")";
        }

        public c() {
            this(0, null, null, null, null, null);
        }

        public c(long r1, String r3, IBaseUser r4, IRoom r5, String r6, k2 r7) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class d {
        public final int a;
        public final int b;
        public final int c;
        public final String d;
        public final String e;

        public d() {
            this(0, 0, 0, "", "");
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L16;
            d r4 = (d) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
            String r1 = this.d;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.e;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "LinkTypeParams(matchType=" + this.a + ", inviteType=" + this.b + ", duration=" + this.c + ", theme=" + this.d + ", connectionTypeFromLink=" + this.e + ")";
        }

        public d(int r2, int r3, int r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, FileUtils.PICTURE_THEME);
            Intrinsics.checkNotNullParameter(r6, "connectionTypeFromLink");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class e {
        public final Map<Long, b9> a;
        public final boolean b;
        public final boolean c;

        public e() {
            this(null, false, false);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof e) == false) goto L12;
            e r4 = (e) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            Map<Long, b9> r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = 1;
            ?? r5 = r3;
            if (r3 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r2 + r5) * 31;
            boolean r7 = this.c;
            if (r7 == true) goto L14;
            r4 = r7;
        L14:
            return r6 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "PkInteractAudienceParams(linkerContentMap=" + this.a + ", inviterWithAudience=" + this.b + ", inviteeWithAudience=" + this.c + ")";
        }

        public e(Map<Long, ? extends b9> r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    void cancelCurrentInvite(String r1);

    IBattleConfigSetting getBattleConfigSetting();

    int getBattleInviteType();

    w2 getBattleShellConfig();

    String getFlexActivityId();

    Map<String, String> getFollowExtraParams(String r1);

    c getGuestInfo();

    IRoom getGuestRoom();

    boolean getIsBreakThrough();

    boolean getIsInviteVote();

    boolean getIsRandomReMatch();

    boolean getIsRealOrganizer();

    boolean getIsStarter();

    boolean getIsSwitchFromLink();

    String getIsSwitchGameFromLink();

    boolean getLinkFromMultiInvite();

    long getLinkStartTime();

    d getLinkTypeParams();

    int getPeakSwitchPlayMode();

    aa getPeakVoteSetting();

    ArrayList<IBattleRivalTag> getPkBattleRivalTagsInfo();

    n getPkConnectContext();

    e getPkInteactAudienceParams();

    PkInviteLogDataContext getPkInviteLogContext();

    String getPkLinkConnectionType();

    /* JADX INFO: renamed from: getPkLinkState */
    q11.c mo747getPkLinkState();

    boolean getSelfHasAudienceBeforePk();

    h9 getSpecifyGiftConfig();

    String getTransformReason(String r1, String r2);

    PkDoubleAnchorDataContext.d getVoteSetting();

    Disposable invite(IRoom r1, long r2, String r4, String r5, int r6, int r7, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f r8, Map<String, String> r9, Function1<? super com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f, Unit> r10, Function1<? super com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f, Unit> r12);

    void invite(IRoom r1, long r2, String r4, String r5, int r6, int r7, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f r8, Map<String, String> r9);

    void recordBroadcastCapInfo();

    void refuseCurrentInvite(int r1);

    void resetBroadcastCapInfo();

    void resetPeakData();

    void setFollowPromotedUID(String r1);

    void setIsRandomReMatch(boolean r1);

    void switchFromLink();

    void switchFromLink(com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r1);
}
