package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements am3.c<ListUserLinkmicAudienceContent> {
    public l() {
    }

    public final Object decode(am3.g r7) throws Exception {
        ListUserLinkmicAudienceContent r0 = new ListUserLinkmicAudienceContent();
        r0.setThreadSafe(false);
        r0.rankUserOpenIds = new ArrayList();
        r0.rankUserIds = new ArrayList();
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L44;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r7);
        if (r3 != 21) goto L8;
        r0.selfDisciplineStartTime = r7.j();
        goto L3
    L8:
        if (r3 != 23) goto L10;
        r0.selfDisciplineTargetDuration = r7.j();
        goto L3
    L10:
        if (r3 != 31) goto L12;
        r0.isMicHidden = am3.h.a(r7);
        goto L3
    L12:
        if (r3 != 5000) goto L13;
        r0.rankUserOpenIds.add(am3.h.c(r7));
        goto L3
    L13:
        switch(r3) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L20;
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L17;
            case 19: goto L16;
            default: goto L14;
        };
    L16:
        r0.mIsAnonymous = am3.h.a(r7);
        goto L3
    L17:
        r0.mSelfDisciplineDurationTime = r7.j();
        goto L3
    L18:
        r0.mIsEnlarged = am3.h.a(r7);
        goto L3
    L19:
        r0.mPaidCount = r7.j();
        goto L3
    L20:
        r0.micDress = (MicDress) vh7.f.a(r7, MicDress.class);
        goto L3
    L21:
        r0.rankUserIds.add(Long.valueOf(r7.j()));
        goto L3
    L22:
        r0.mFanTicketRealStr = am3.h.c(r7);
        goto L3
    L23:
        r0.mListUserRole = r7.i();
        goto L3
    L24:
        r0.mFanTicketFuzzyStr = am3.h.c(r7);
        goto L3
    L25:
        r0.mCurrentTime = r7.j();
        goto L3
    L26:
        r0.extra = am3.h.c(r7);
        goto L3
    L27:
        r0.isInWaitingList = am3.h.a(r7);
        goto L3
    L28:
        r0.mExpectLeaveTime = r7.j();
        goto L3
    L29:
        r0.mJoinChannelTime = r7.j();
        goto L3
    L30:
        r0.mDevicePlatform = am3.h.c(r7);
        goto L3
    L31:
        r0.mClientVersion = r7.j();
        goto L3
    L32:
        r0.mAppId = r7.j();
        goto L3
    L33:
        r0.mIsHost = am3.h.a(r7);
        goto L3
    L34:
        r0.mFanTicket = r7.j();
        goto L3
    L14:
        switch(r3) {
            case 25: goto L39;
            case 26: goto L38;
            case 27: goto L37;
            case 28: goto L36;
            case 29: goto L35;
            default: goto L15;
        };
    L35:
        r0.aiGuestType = r7.i();
        goto L3
    L36:
        r0.originLinkType = r7.j();
        goto L3
    L37:
        r0.chorusGuestStatus = r7.j();
        goto L3
    L38:
        r0.linkmic2DAvatar = (Linkmic2DAvatar) vh7.f.a(r7, Linkmic2DAvatar.class);
        goto L3
    L39:
        r0.themedCompetitionRole = r7.i();
        goto L3
    L15:
        am3.h.d(r4, r7);
        goto L3
    L44:
        r7.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
