package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public static final ILinkPlayerInfoBridge a(ILinkPlayerInfoBridge r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$copy");
        ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        r0.setFanTicket(r3.getFanTicket());
        r0.setFanTicketDisplayStr(r3.getFanTicketDisplayStr());
        String r1 = r3.getMInteractIdStr();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.setInteractId(r1);
        String r4 = r3.getMInteractIdStr();
        if (r4 == null) goto L9;
        r2 = r4;
    L9:
        r0.setLinkMicUniqueIdStr(r2);
        r0.setUser(r3.getUser());
        r0.setModifyTime(r3.getModifyTime());
        r0.setLinkStatus(r3.getLinkStatus());
        r0.setKSongUid(r3.getKSongUid());
        r0.setLinkType(r3.getLinkType());
        r0.setRoleType(r3.getRoleType());
        r0.setListUserRole(r3.getListUserRole());
        r0.setPaidMoney(r3.getPaidMoney());
        r0.setLinkDuration(r3.getLinkDuration());
        r0.setUserPosition(r3.getUserPosition());
        r0.setSilenceStatus(r3.getSilenceStatus());
        r0.setLocation(r3.getLocation());
        r0.setModifyTimeInNano(r3.getModifyTimeInNano());
        r0.setTalkState(r3.getTalkState());
        r0.setOpenSendGift(r3.isOpenSendGift());
        r0.setHasInvited(r3.isHasInvited());
        r0.setHasApplied(r3.isHasApplied());
        r0.setHost(r3.isHost());
        r0.setMediaType(r3.getMediaType());
        r0.setCornerMarkUrl(r3.getCornerMarkUrl());
        r0.setClientVersion(r3.getClientVersion());
        r0.setAppId(r3.getAppId());
        r0.setDevicePlatform(r3.getDevicePlatform());
        r0.setApplyType(r3.getApplyType());
        r0.setApplyTypeNew(r3.getApplyTypeNew());
        r0.setLinkedListUserInfo(r3.getLinkedListUserInfo());
        r0.setBackground(r3.isBackground());
        r0.setSelfBackground(r3.isSelfBackground());
        r0.setMatchEffect(r3.getMatchEffect());
        r0.setCityEffect(r3.mo254getCityEffect());
        r0.setShowCityEffect(r3.getShowCityEffect());
        r0.setMIsJoinUser(r3.getMIsJoinUser());
        r0.setMicDress(r3.getMicDress());
        r0.setEnlarged(r3.isEnlarged());
        r0.setLinkmic2DAvatar(r3.getLinkmic2DAvatar());
        r0.setChorusGuestStatus(r3.getChorusGuestStatus());
        r0.setOriginLinkType(r3.getOriginLinkType());
        r0.setAiGuestType(r3.getAiGuestType());
        r0.setMicHidden(r3.isMicHidden());
        r0.setSelfDisciplineDuration(r3.getSelfDisciplineDuration());
        r0.setSelfDisciplineTargetDuration(r3.getSelfDisciplineTargetDuration());
        r0.setThemedCompetitionRole(r3.getThemedCompetitionRole());
        r0.setWaitingListUserInfo(r3.getWaitingListUserInfo());
        r0.setRank(r3.getRank());
        r0.setPaidCount(r3.getPaidCount());
        r0.setStats(r3.getStats());
        r0.setLinkRoomUser(r3.isLinkRoomUser());
        r0.setLinkRoomId(r3.getLinkRoomId());
        r0.setRoomLinkSilenceStatus(r3.getRoomLinkSilenceStatus());
        r0.setAnonymous(r3.isAnonymous());
        r0.setMicPosTagInfo(r3.getMicPosTagInfo());
        r0.setUserHighScoreSongTag(r3.getUserHighScoreSongTag());
        r0.setPaidUserLeave(r3.isPaidUserLeave());
        r0.setMcStatus(r3.getMcStatus());
        r0.setClientUIPosition(r3.getClientUIPosition());
        return r0;
    }

    public static final long b(ILinkPlayerInfoBridge r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$linkMicPosTagType");
        if (r2.getMicPosTagInfo() != null) goto L5;
        return 0;
    L5:
        g0 r3 = r2.getMicPosTagInfo();
        Intrinsics.checkNotNull(r3);
        return r3.getTagType();
    }

    public static final String c(ILinkPlayerInfoBridge r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$topR");
        if (r5.getRank() != 1) goto L6;
        return "top1";
    L6:
        if (r5.getRank() != 2) goto L9;
        return "top2";
    L9:
        if (r5.getRank() != 3) goto L11;
        return "top3";
    L11:
        return "null";
    }

    public static final IBaseUser d(ILinkPlayerInfoBridge r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$userKt");
        return r1.getUser();
    }

    public static final String e(String r3) {
        if (r3 != null) goto L4;
        return "";
    L4:
        if (r3.length() > 6) goto L9;
        return r3;
    L9:
        return r3.subSequence(0, 5).toString() + "...";
    }

    public static final boolean f(ILinkPlayerInfoBridge r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$hasSpecialRadioEffect");
        if (r1.getMicDress() == null) goto L7;
        kd1.b r2 = r1.getMicDress();
        Intrinsics.checkNotNull(r2);
        if (r2.getVoiceWave() == null) goto L7;
        return true;
    L7:
        return false;
    }

    public static final boolean g(ILinkPlayerInfoBridge r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isKtvHost");
        if (r4.getMcStatus() != ILinkPlayerInfoBridge.McStatus.KTV_HOST.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean h(ILinkPlayerInfoBridge r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isTalking");
        if (r1.getTalkState() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean i(ILinkPlayerInfoBridge r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$isUnSilence");
        if (r3.isLinkRoomUser() == false) goto L12;
        if (r3.getRoomLinkSilenceStatus() == 0) goto L7;
    L9:
        return false;
    L7:
        if (r3.getSilenceStatus() != 0) goto L9;
        return true;
    L12:
        if (r3.getSilenceStatus() == 0) goto L17;
        return false;
    L17:
        return true;
    }
}
