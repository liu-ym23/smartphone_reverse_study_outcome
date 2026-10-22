package com.bytedance.android.live.liveinteract.pre;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import java.util.List;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class VerticalNitaInflate {
    public static final SparseArray<List<zo2.a>> a = null;
    public static final SparseArray<List<zo2.a>> b = null;

    public static final enum Tag extends Enum<Tag> {
        public static final Tag AudioRoomFeedView_container = null;
        public static final Tag BaseEqualTalkRoomAdapter_holder_empty = null;
        public static final Tag BaseEqualTalkRoomAdapter_holder_guest = null;
        public static final Tag BattleVideoEqualGuestMicSeatLayer = null;
        public static final Tag BattleVideoGuestMicSeatLayer = null;
        public static final Tag CEqualTalkRoomAdapter_holder_empty = null;
        public static final Tag CEqualTalkRoomAdapter_holder_guest = null;
        public static final Tag CEqualTalkRoomAdapter_holder_guest_large = null;
        public static final Tag CVideoEqualGuestMicSeatBasicLayer = null;
        public static final Tag CVideoEqualGuestMicSeatBasicLayer_large = null;
        public static final Tag CVideoTalkRoomFeedView_container = null;
        public static final Tag CameraTalkRoomNewFeedView_container = null;
        public static final Tag CommonMultiLinkFeedView_container = null;
        public static final Tag EqualTalkRoomFeedView_container = null;
        public static final Tag GuestBattleQuickInteractView = null;
        public static final Tag LinkInRoomAudioGuestAdapter_holder_empty_1v8 = null;
        public static final Tag LinkInRoomAudioGuestAdapter_holder_empty_3x3 = null;
        public static final Tag LinkInRoomAudioGuestAdapter_holder_guest_1v8 = null;
        public static final Tag LinkInRoomAudioGuestAdapter_holder_guest_3x3 = null;
        public static final Tag LinkRoomFightAdapter_holder_empty = null;
        public static final Tag LinkRoomFightAdapter_holder_guest = null;
        public static final Tag LinkRoomFightBasicLayer = null;
        public static final Tag LinkRoomFightBusinessLayer = null;
        public static final Tag LinkRoomFightEmptyLayer = null;
        public static final Tag LinkRoomFightFeedView_container = null;
        public static final Tag MultiLinkAudioCommonCPositionAnimLayer = null;
        public static final Tag MultiLinkAudioCommonCPositionEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonCPositionGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonCPositionGuestMicSeatStatusLayer = null;
        public static final Tag MultiLinkAudioCommonEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonEnlargeStageAnimLayer = null;
        public static final Tag MultiLinkAudioCommonEnlargeStageEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonEnlargeStageGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonFirstUserEnlargeStageCustomizeMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonFirstUserEnlargeStageMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonFirstUserGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonFirstUserV2GuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonGuestAnimLayer = null;
        public static final Tag MultiLinkAudioCommonGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonGuestStatusLayer = null;
        public static final Tag MultiLinkAudioCommonHamletAnimLayer = null;
        public static final Tag MultiLinkAudioCommonHamletAvatarGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonHamletEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonLargeEmptyBasicLayer = null;
        public static final Tag MultiLinkAudioCommonLargeGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioCommonLargeGuestMicSeatStatusLayer = null;
        public static final Tag MultiLinkAudioCommonLargePreOnlineLayer = null;
        public static final Tag MultiLinkAudioCommonPreOnlineLayer = null;
        public static final Tag MultiLinkAudioCommonThemedCompetitionBusinessLayer = null;
        public static final Tag MultiLinkAudioCommonVirtualAvatarAnimLayer = null;
        public static final Tag MultiLinkAudioFirstUserVirtualAvatarMicSeatBasicLayer = null;
        public static final Tag MultiLinkAudioHamletEmptyLargeLayer = null;
        public static final Tag MultiLinkAvatarTalkoverPlaceHolderLayer = null;
        public static final Tag MultiLinkCommonEmptyMicSeatBasicLayer = null;
        public static final Tag MultiLinkCommonGuestMicSeatBasicLayer = null;
        public static final Tag MultiLinkCommonGuestStatusLayer = null;
        public static final Tag MultiLinkCommonSpecialMicSeatBasicLayer = null;
        public static final Tag MultiLinkDummyLayer = null;
        public static final Tag MultiLinkDynamicFloatWindowEmptyLayer = null;
        public static final Tag MultiLinkDynamicFloatWindowEmptyLayerOld = null;
        public static final Tag MultiLinkDynamicFloatWindowFirstUserBasicLayer = null;
        public static final Tag MultiLinkDynamicFloatWindowFirstUserStatusLayer = null;
        public static final Tag MultiLinkDynamicTeamFightView = null;
        public static final Tag MultiLinkFixedFloatWindowFirstUserBasicLayer = null;
        public static final Tag MultiLinkFixedFloatWindowFirstUserStatusLayer = null;
        public static final Tag MultiLinkFloatWindow1v8SmallGuestBasicLayer = null;
        public static final Tag MultiLinkFloatWindow1v8SmallGuestStatusLayer = null;
        public static final Tag MultiLinkGameFunctionLayer = null;
        public static final Tag MultiLinkHamletAvatarRevealUserInfoLayer = null;
        public static final Tag MultiLinkHamletAvatarUserInfoLayer = null;
        public static final Tag MultiLinkHamletMainUserAnimLayer = null;
        public static final Tag MultiLinkMicSeatAnimLayer = null;
        public static final Tag MultiLinkMicSelfDisciplineLayer = null;
        public static final Tag MultiLinkPCLandscapeMicSeatBasicLayer = null;
        public static final Tag MultiLinkRadioMainSeatLayer = null;
        public static final Tag MultiLinkRadioWidgetView = null;
        public static final Tag MultiLinkRequestSongAvatarMicSeatLayer = null;
        public static final Tag MultiLinkVideoCommonThemedCompetitionBusinessLayer = null;
        public static final Tag MultiLinkVideoCommonWindowView = null;
        public static final Tag MultiLinkVideoGuestWidgetViewV2 = null;
        public static final Tag MultiLinkVoiceCommonWindowView = null;
        public static final Tag MultiLinkVoiceGuestWidgetView = null;
        public static final Tag SeatAnimationView = null;
        public static final Tag SelfDisciplineMicSeatLayer = null;
        public static final Tag VideoCameraRoomWindowAdapterV2_holder_empty = null;
        public static final Tag VideoCameraRoomWindowAdapterV2_holder_guest = null;
        public static final Tag VideoDynamicTalkRoomFeedView_container = null;
        public static final Tag VideoEmptyMicSeatBasicLayer = null;
        public static final Tag VideoEqualEmptyMicSeatBasicLayer = null;
        public static final Tag VideoEqualGuestMicSeatBasicLayer = null;
        public static final Tag VideoGuestMicSeatBasicLayer = null;
        public static final Tag VideoMicSeatStatusLayer = null;
        public static final Tag VideoTeamFightAdapter_holder_anchor = null;
        public static final Tag VideoTeamFightAdapter_holder_empty = null;
        public static final Tag VideoTeamFightAdapter_holder_guest = null;
        public static final Tag VideoTeamFightFeedView_container = null;
        public static final /* synthetic */ Tag[] a = null;

        static {
            Tag r0 = new Tag("GuestBattleQuickInteractView", 0);
            GuestBattleQuickInteractView = r0;
            Tag r1 = new Tag("SeatAnimationView", 1);
            SeatAnimationView = r1;
            Tag r3 = new Tag("VideoEqualEmptyMicSeatBasicLayer", 2);
            VideoEqualEmptyMicSeatBasicLayer = r3;
            Tag r5 = new Tag("VideoEqualGuestMicSeatBasicLayer", 3);
            VideoEqualGuestMicSeatBasicLayer = r5;
            Tag r7 = new Tag("VideoMicSeatStatusLayer", 4);
            VideoMicSeatStatusLayer = r7;
            Tag r9 = new Tag("BattleVideoGuestMicSeatLayer", 5);
            BattleVideoGuestMicSeatLayer = r9;
            Tag r11 = new Tag("BattleVideoEqualGuestMicSeatLayer", 6);
            BattleVideoEqualGuestMicSeatLayer = r11;
            Tag r13 = new Tag("SelfDisciplineMicSeatLayer", 7);
            SelfDisciplineMicSeatLayer = r13;
            Tag r15 = new Tag("CVideoEqualGuestMicSeatBasicLayer_large", 8);
            CVideoEqualGuestMicSeatBasicLayer_large = r15;
            Tag r14 = new Tag("CVideoEqualGuestMicSeatBasicLayer", 9);
            CVideoEqualGuestMicSeatBasicLayer = r14;
            Tag r12 = new Tag("VideoEmptyMicSeatBasicLayer", 10);
            VideoEmptyMicSeatBasicLayer = r12;
            Tag r10 = new Tag("VideoGuestMicSeatBasicLayer", 11);
            VideoGuestMicSeatBasicLayer = r10;
            Tag r8 = new Tag("EqualTalkRoomFeedView_container", 12);
            EqualTalkRoomFeedView_container = r8;
            Tag r6 = new Tag("BaseEqualTalkRoomAdapter_holder_empty", 13);
            BaseEqualTalkRoomAdapter_holder_empty = r6;
            Tag r4 = new Tag("BaseEqualTalkRoomAdapter_holder_guest", 14);
            BaseEqualTalkRoomAdapter_holder_guest = r4;
            Tag r2 = new Tag("CEqualTalkRoomAdapter_holder_empty", 15);
            CEqualTalkRoomAdapter_holder_empty = r2;
            Tag r16 = new Tag("CEqualTalkRoomAdapter_holder_guest", 16);
            CEqualTalkRoomAdapter_holder_guest = r16;
            Tag r17 = new Tag("CEqualTalkRoomAdapter_holder_guest_large", 17);
            CEqualTalkRoomAdapter_holder_guest_large = r17;
            Tag r18 = new Tag("CommonMultiLinkFeedView_container", 18);
            CommonMultiLinkFeedView_container = r18;
            Tag r19 = new Tag("CVideoTalkRoomFeedView_container", 19);
            CVideoTalkRoomFeedView_container = r19;
            Tag r20 = new Tag("CameraTalkRoomNewFeedView_container", 20);
            CameraTalkRoomNewFeedView_container = r20;
            Tag r21 = new Tag("VideoDynamicTalkRoomFeedView_container", 21);
            VideoDynamicTalkRoomFeedView_container = r21;
            Tag r22 = new Tag("VideoCameraRoomWindowAdapterV2_holder_empty", 22);
            VideoCameraRoomWindowAdapterV2_holder_empty = r22;
            Tag r23 = new Tag("VideoCameraRoomWindowAdapterV2_holder_guest", 23);
            VideoCameraRoomWindowAdapterV2_holder_guest = r23;
            Tag r24 = new Tag("VideoTeamFightFeedView_container", 24);
            VideoTeamFightFeedView_container = r24;
            Tag r25 = new Tag("VideoTeamFightAdapter_holder_anchor", 25);
            VideoTeamFightAdapter_holder_anchor = r25;
            Tag r26 = new Tag("VideoTeamFightAdapter_holder_guest", 26);
            VideoTeamFightAdapter_holder_guest = r26;
            Tag r27 = new Tag("VideoTeamFightAdapter_holder_empty", 27);
            VideoTeamFightAdapter_holder_empty = r27;
            Tag r28 = new Tag("LinkRoomFightFeedView_container", 28);
            LinkRoomFightFeedView_container = r28;
            Tag r29 = new Tag("LinkRoomFightAdapter_holder_guest", 29);
            LinkRoomFightAdapter_holder_guest = r29;
            Tag r30 = new Tag("LinkRoomFightAdapter_holder_empty", 30);
            LinkRoomFightAdapter_holder_empty = r30;
            Tag r31 = new Tag("LinkRoomFightBasicLayer", 31);
            LinkRoomFightBasicLayer = r31;
            Tag r32 = new Tag("LinkRoomFightBusinessLayer", 32);
            LinkRoomFightBusinessLayer = r32;
            Tag r33 = new Tag("LinkRoomFightEmptyLayer", 33);
            LinkRoomFightEmptyLayer = r33;
            Tag r34 = new Tag("AudioRoomFeedView_container", 34);
            AudioRoomFeedView_container = r34;
            Tag r35 = new Tag("LinkInRoomAudioGuestAdapter_holder_empty_3x3", 35);
            LinkInRoomAudioGuestAdapter_holder_empty_3x3 = r35;
            Tag r36 = new Tag("LinkInRoomAudioGuestAdapter_holder_empty_1v8", 36);
            LinkInRoomAudioGuestAdapter_holder_empty_1v8 = r36;
            Tag r37 = new Tag("LinkInRoomAudioGuestAdapter_holder_guest_3x3", 37);
            LinkInRoomAudioGuestAdapter_holder_guest_3x3 = r37;
            Tag r38 = new Tag("LinkInRoomAudioGuestAdapter_holder_guest_1v8", 38);
            LinkInRoomAudioGuestAdapter_holder_guest_1v8 = r38;
            Tag r39 = new Tag("MultiLinkVideoCommonWindowView", 39);
            MultiLinkVideoCommonWindowView = r39;
            Tag r40 = new Tag("MultiLinkVideoGuestWidgetViewV2", 40);
            MultiLinkVideoGuestWidgetViewV2 = r40;
            Tag r41 = new Tag("MultiLinkVoiceCommonWindowView", 41);
            MultiLinkVoiceCommonWindowView = r41;
            Tag r42 = new Tag("MultiLinkRadioWidgetView", 42);
            MultiLinkRadioWidgetView = r42;
            Tag r43 = new Tag("MultiLinkVoiceGuestWidgetView", 43);
            MultiLinkVoiceGuestWidgetView = r43;
            Tag r44 = new Tag("MultiLinkDynamicTeamFightView", 44);
            MultiLinkDynamicTeamFightView = r44;
            Tag r45 = new Tag("MultiLinkCommonGuestMicSeatBasicLayer", 45);
            MultiLinkCommonGuestMicSeatBasicLayer = r45;
            Tag r46 = new Tag("MultiLinkCommonEmptyMicSeatBasicLayer", 46);
            MultiLinkCommonEmptyMicSeatBasicLayer = r46;
            Tag r47 = new Tag("MultiLinkCommonSpecialMicSeatBasicLayer", 47);
            MultiLinkCommonSpecialMicSeatBasicLayer = r47;
            Tag r48 = new Tag("MultiLinkCommonGuestStatusLayer", 48);
            MultiLinkCommonGuestStatusLayer = r48;
            Tag r49 = new Tag("MultiLinkMicSelfDisciplineLayer", 49);
            MultiLinkMicSelfDisciplineLayer = r49;
            Tag r50 = new Tag("MultiLinkMicSeatAnimLayer", 50);
            MultiLinkMicSeatAnimLayer = r50;
            Tag r51 = new Tag("MultiLinkVideoCommonThemedCompetitionBusinessLayer", 51);
            MultiLinkVideoCommonThemedCompetitionBusinessLayer = r51;
            Tag r52 = new Tag("MultiLinkDummyLayer", 52);
            MultiLinkDummyLayer = r52;
            Tag r53 = new Tag("MultiLinkFixedFloatWindowFirstUserBasicLayer", 53);
            MultiLinkFixedFloatWindowFirstUserBasicLayer = r53;
            Tag r54 = new Tag("MultiLinkDynamicFloatWindowFirstUserBasicLayer", 54);
            MultiLinkDynamicFloatWindowFirstUserBasicLayer = r54;
            Tag r55 = new Tag("MultiLinkFloatWindow1v8SmallGuestBasicLayer", 55);
            MultiLinkFloatWindow1v8SmallGuestBasicLayer = r55;
            Tag r56 = new Tag("MultiLinkDynamicFloatWindowEmptyLayer", 56);
            MultiLinkDynamicFloatWindowEmptyLayer = r56;
            Tag r57 = new Tag("MultiLinkDynamicFloatWindowEmptyLayerOld", 57);
            MultiLinkDynamicFloatWindowEmptyLayerOld = r57;
            Tag r58 = new Tag("MultiLinkDynamicFloatWindowFirstUserStatusLayer", 58);
            MultiLinkDynamicFloatWindowFirstUserStatusLayer = r58;
            Tag r59 = new Tag("MultiLinkFixedFloatWindowFirstUserStatusLayer", 59);
            MultiLinkFixedFloatWindowFirstUserStatusLayer = r59;
            Tag r60 = new Tag("MultiLinkFloatWindow1v8SmallGuestStatusLayer", 60);
            MultiLinkFloatWindow1v8SmallGuestStatusLayer = r60;
            Tag r61 = new Tag("MultiLinkGameFunctionLayer", 61);
            MultiLinkGameFunctionLayer = r61;
            Tag r62 = new Tag("MultiLinkPCLandscapeMicSeatBasicLayer", 62);
            MultiLinkPCLandscapeMicSeatBasicLayer = r62;
            Tag r63 = new Tag("MultiLinkAudioCommonGuestMicSeatBasicLayer", 63);
            MultiLinkAudioCommonGuestMicSeatBasicLayer = r63;
            Tag r65 = new Tag("MultiLinkAudioCommonLargeGuestMicSeatBasicLayer", 64);
            MultiLinkAudioCommonLargeGuestMicSeatBasicLayer = r65;
            Tag r66 = new Tag("MultiLinkAudioCommonCPositionGuestMicSeatBasicLayer", 65);
            MultiLinkAudioCommonCPositionGuestMicSeatBasicLayer = r66;
            Tag r67 = new Tag("MultiLinkAudioCommonFirstUserGuestMicSeatBasicLayer", 66);
            MultiLinkAudioCommonFirstUserGuestMicSeatBasicLayer = r67;
            Tag r68 = new Tag("MultiLinkAudioCommonFirstUserV2GuestMicSeatBasicLayer", 67);
            MultiLinkAudioCommonFirstUserV2GuestMicSeatBasicLayer = r68;
            Tag r69 = new Tag("MultiLinkAudioFirstUserVirtualAvatarMicSeatBasicLayer", 68);
            MultiLinkAudioFirstUserVirtualAvatarMicSeatBasicLayer = r69;
            Tag r70 = new Tag("MultiLinkAudioCommonFirstUserEnlargeStageMicSeatBasicLayer", 69);
            MultiLinkAudioCommonFirstUserEnlargeStageMicSeatBasicLayer = r70;
            Tag r71 = new Tag("MultiLinkAudioCommonFirstUserEnlargeStageCustomizeMicSeatBasicLayer", 70);
            MultiLinkAudioCommonFirstUserEnlargeStageCustomizeMicSeatBasicLayer = r71;
            Tag r72 = new Tag("MultiLinkAudioCommonGuestStatusLayer", 71);
            MultiLinkAudioCommonGuestStatusLayer = r72;
            Tag r73 = new Tag("MultiLinkAudioCommonLargeGuestMicSeatStatusLayer", 72);
            MultiLinkAudioCommonLargeGuestMicSeatStatusLayer = r73;
            Tag r74 = new Tag("MultiLinkAudioCommonCPositionGuestMicSeatStatusLayer", 73);
            MultiLinkAudioCommonCPositionGuestMicSeatStatusLayer = r74;
            Tag r75 = new Tag("MultiLinkAudioCommonThemedCompetitionBusinessLayer", 74);
            MultiLinkAudioCommonThemedCompetitionBusinessLayer = r75;
            Tag r76 = new Tag("MultiLinkAudioCommonGuestAnimLayer", 75);
            MultiLinkAudioCommonGuestAnimLayer = r76;
            Tag r77 = new Tag("MultiLinkAudioCommonCPositionAnimLayer", 76);
            MultiLinkAudioCommonCPositionAnimLayer = r77;
            Tag r78 = new Tag("MultiLinkAudioCommonVirtualAvatarAnimLayer", 77);
            MultiLinkAudioCommonVirtualAvatarAnimLayer = r78;
            Tag r79 = new Tag("MultiLinkAudioCommonEmptyBasicLayer", 78);
            MultiLinkAudioCommonEmptyBasicLayer = r79;
            Tag r80 = new Tag("MultiLinkAudioCommonLargeEmptyBasicLayer", 79);
            MultiLinkAudioCommonLargeEmptyBasicLayer = r80;
            Tag r81 = new Tag("MultiLinkAudioCommonCPositionEmptyBasicLayer", 80);
            MultiLinkAudioCommonCPositionEmptyBasicLayer = r81;
            Tag r82 = new Tag("MultiLinkAudioCommonPreOnlineLayer", 81);
            MultiLinkAudioCommonPreOnlineLayer = r82;
            Tag r83 = new Tag("MultiLinkAudioCommonLargePreOnlineLayer", 82);
            MultiLinkAudioCommonLargePreOnlineLayer = r83;
            Tag r84 = new Tag("MultiLinkRadioMainSeatLayer", 83);
            MultiLinkRadioMainSeatLayer = r84;
            Tag r85 = new Tag("MultiLinkAudioCommonEnlargeStageGuestMicSeatBasicLayer", 84);
            MultiLinkAudioCommonEnlargeStageGuestMicSeatBasicLayer = r85;
            Tag r86 = new Tag("MultiLinkAudioCommonEnlargeStageAnimLayer", 85);
            MultiLinkAudioCommonEnlargeStageAnimLayer = r86;
            Tag r87 = new Tag("MultiLinkAudioCommonHamletAvatarGuestMicSeatBasicLayer", 86);
            MultiLinkAudioCommonHamletAvatarGuestMicSeatBasicLayer = r87;
            Tag r88 = new Tag("MultiLinkAudioCommonHamletAnimLayer", 87);
            MultiLinkAudioCommonHamletAnimLayer = r88;
            Tag r89 = new Tag("MultiLinkAudioCommonHamletEmptyBasicLayer", 88);
            MultiLinkAudioCommonHamletEmptyBasicLayer = r89;
            Tag r90 = new Tag("MultiLinkAudioCommonEnlargeStageEmptyBasicLayer", 89);
            MultiLinkAudioCommonEnlargeStageEmptyBasicLayer = r90;
            Tag r91 = new Tag("MultiLinkAudioHamletEmptyLargeLayer", 90);
            MultiLinkAudioHamletEmptyLargeLayer = r91;
            Tag r92 = new Tag("MultiLinkHamletAvatarRevealUserInfoLayer", 91);
            MultiLinkHamletAvatarRevealUserInfoLayer = r92;
            Tag r93 = new Tag("MultiLinkHamletAvatarUserInfoLayer", 92);
            MultiLinkHamletAvatarUserInfoLayer = r93;
            Tag r94 = new Tag("MultiLinkAvatarTalkoverPlaceHolderLayer", 93);
            MultiLinkAvatarTalkoverPlaceHolderLayer = r94;
            Tag r95 = new Tag("MultiLinkRequestSongAvatarMicSeatLayer", 94);
            MultiLinkRequestSongAvatarMicSeatLayer = r95;
            Tag r96 = new Tag("MultiLinkHamletMainUserAnimLayer", 95);
            MultiLinkHamletMainUserAnimLayer = r96;
            a = new Tag[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96};
        }

        public static Tag[] values() {
            return (Tag[]) a.clone();
        }

        public static Tag valueOf(String r1) {
            return (Tag) r27.a.a(Tag.class, r1);
        }

        public Tag(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class a implements zo2.a {
        public final int a;
        public final String b;
        public final int c;

        public int getType() {
            return 0;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return ((((r0 + r2) * 31) + this.c) * 31) + 0;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "Item{resId=" + this.a + ", tag='" + this.b + "', count=" + this.c + ", scene=0}";
        }

        public final int getCount() {
            return this.c;
        }

        public final int getResId() {
            return this.a;
        }

        public final String getTag() {
            return this.b;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L20:
            return false;
        L8:
            if (a.class != r5.getClass()) goto L20;
            a r6 = (a) r5;
            if (this.a == r6.a) goto L13;
            return false;
        L13:
            String r2 = this.b;
            String r7 = r6.b;
            if (r2 != null) goto L21;
            if (r7 == null) goto L22;
            return false;
        L22:
            return true;
        L21:
            return r2.equals(r7);
        }

        public a(Tag r1, int r2) {
            this.a = r2;
            this.b = r1.name();
            this.c = 1;
        }
    }

    static {
        a = new SparseArray();
        b = new SparseArray();
    }

    public static View a(String r12, int r13, Context r14, ViewGroup r15, boolean r16) {
        IMiddlewareHostBusiness r2 = k.f(IMiddlewareHostBusiness.class);
        System.nanoTime();
        boolean r4 = false;
        if (r12.isEmpty() == false) goto L5;
    L4:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L12;
    L17:
        View r5 = LayoutInflater.from(r14).inflate(r13, r15, r16);
        com.bytedance.android.live.liveinteract.pre.a.c.a.b(r12, false);
        ALogger.i("VerticalNitaInflate", "[layoutLoad] load " + r12 + " by inflater");
        int r6 = t0.a;
        StringBuilder r7 = new StringBuilder("[Nita][layoutLoad] load ");
        r7.append(r12);
        r7.append(" by inflater,extra: hasCachedView=");
        if (r12.isEmpty() == true) goto L24;
        IMiddlewareHostBusiness r8 = k.f(IMiddlewareHostBusiness.class);
        if (r8 == null) goto L24;
        r4 = r8.hasCachedView(r12, r13);
    L24:
        r7.append(r4);
        r7.append(", context=");
        r7.append(r14);
        r7.append(", hostBusiness=");
        r7.append(r2);
        r7.append(", nitaTag=");
        r7.append(r12);
        t0.a("VerticalNitaInflate", r7.toString());
        return r5;
    L12:
        if ((r14 instanceof Activity) == false) goto L17;
        if (r2 == null) goto L17;
        if (TextUtils.isEmpty(r12) == true) goto L17;
        View r0 = r2.tryGetPreLoadLiveLayouts(r13, r12, (Activity) r14, r15, Boolean.valueOf(r16), Boolean.FALSE, null);
        com.bytedance.android.live.liveinteract.pre.a.c.a.b(r12, true);
        ALogger.i("VerticalNitaInflate", "[layoutLoad] load " + r12 + " by nita");
        int r1 = t0.a;
        t0.a("VerticalNitaInflate", "[Nita][layoutLoad] load " + r12 + " by nita");
        return r0;
    L5:
        IMiddlewareHostBusiness r9 = k.f(IMiddlewareHostBusiness.class);
        if (r9 == null) goto L4;
        r3 = r9.hasCachedView(r12, r13);
        goto L10
    }
}
