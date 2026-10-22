package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b1\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/InteractID;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "Unknown", "Comment", "Lottery", "DrawSth", "KTV", "Blinked", "GiftVote", "EffectGame", "WGameX", "WMiniGame", "CloudGame", "DynamicItem", "LinkMicEmojiItem", "Predictor", "InteractiveSong", "VProject", "KtvRoomSelect", "PkOperationalPlayBo3", "GuestBattle", "DigitAvatar", "KTVChallenge", "TeamFight", "PlayTogether", "VideoKtv", "PaidLink", "LinkRoomFight", "SelfDiscipline", "InteractiveSong2", "ThemedCompetition", "Adventure", "StarWish", "InteractActing", "RevenueGameEffect", "RevenueGameEffectDynamic", "OpenGame", "Zhufen", "OpenMicroApp", "SonicMiniGame", "InteractLoki", "InteractGamePlus", "InteractMiniApp", "OpenMicroGame", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractID extends Enum<InteractID> {
    public static final InteractID Adventure = null;
    public static final InteractID Blinked = null;
    public static final InteractID CloudGame = null;
    public static final InteractID Comment = null;
    public static final a Companion = null;
    public static final InteractID DigitAvatar = null;
    public static final InteractID DrawSth = null;
    public static final InteractID DynamicItem = null;
    public static final InteractID EffectGame = null;
    public static final InteractID GiftVote = null;
    public static final InteractID GuestBattle = null;
    public static final InteractID InteractActing = null;
    public static final InteractID InteractGamePlus = null;
    public static final InteractID InteractLoki = null;
    public static final InteractID InteractMiniApp = null;
    public static final InteractID InteractiveSong = null;
    public static final InteractID InteractiveSong2 = null;
    public static final InteractID KTV = null;
    public static final InteractID KTVChallenge = null;
    public static final InteractID KtvRoomSelect = null;
    public static final InteractID LinkMicEmojiItem = null;
    public static final InteractID LinkRoomFight = null;
    public static final InteractID Lottery = null;
    public static final InteractID OpenGame = null;
    public static final InteractID OpenMicroApp = null;
    public static final InteractID OpenMicroGame = null;
    public static final InteractID PaidLink = null;
    public static final InteractID PkOperationalPlayBo3 = null;
    public static final InteractID PlayTogether = null;
    public static final InteractID Predictor = null;
    public static final InteractID RevenueGameEffect = null;
    public static final InteractID RevenueGameEffectDynamic = null;
    public static final InteractID SelfDiscipline = null;
    public static final InteractID SonicMiniGame = null;
    public static final InteractID StarWish = null;
    public static final InteractID TeamFight = null;
    public static final InteractID ThemedCompetition = null;
    public static final InteractID Unknown = null;
    public static final InteractID VProject = null;
    public static final InteractID VideoKtv = null;
    public static final InteractID WGameX = null;
    public static final InteractID WMiniGame = null;
    public static final InteractID Zhufen = null;
    public static final /* synthetic */ InteractID[] a = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static boolean a(InteractID r1) {
            Intrinsics.checkNotNullParameter(r1, "$this$isGamePlay");
            if (LiveOpenFeatureChooseConfig.useV3() == true) goto L5;
        L9:
            return false;
        L5:
            if (r1 != InteractID.SonicMiniGame) goto L7;
        L8:
            return true;
        L7:
            if (r1 != InteractID.OpenMicroGame) goto L9;
            goto L8
        }

        public static InteractID b(int r6) {
            InteractID[] r0 = InteractID.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            InteractID r4 = r0[r3];
            if (r6 != r4.getValue()) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return InteractID.Unknown;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    public static InteractID valueOf(String r1) {
        return (InteractID) r27.a.a(InteractID.class, r1);
    }

    public static InteractID[] values() {
        return (InteractID[]) a.clone();
    }

    static {
        InteractID r2 = new InteractID("Unknown", 0, 0);
        Unknown = r2;
        InteractID r3 = new InteractID("Comment", 1, 1);
        Comment = r3;
        InteractID r4 = new InteractID("Lottery", 2, 2);
        Lottery = r4;
        InteractID r5 = new InteractID("DrawSth", 3, 3);
        DrawSth = r5;
        InteractID r6 = new InteractID("KTV", 4, 4);
        KTV = r6;
        InteractID r7 = new InteractID("Blinked", 5, 5);
        Blinked = r7;
        InteractID r8 = new InteractID("GiftVote", 6, 6);
        GiftVote = r8;
        InteractID r9 = new InteractID("EffectGame", 7, 7);
        EffectGame = r9;
        InteractID r11 = new InteractID("WGameX", 8, 8);
        WGameX = r11;
        InteractID r12 = new InteractID("WMiniGame", 9, 9);
        WMiniGame = r12;
        InteractID r13 = new InteractID("CloudGame", 10, 10);
        CloudGame = r13;
        InteractID r14 = new InteractID("DynamicItem", 11, 11);
        DynamicItem = r14;
        InteractID r15 = new InteractID("LinkMicEmojiItem", 12, 12);
        LinkMicEmojiItem = r15;
        InteractID r16 = new InteractID("Predictor", 13, 13);
        Predictor = r16;
        InteractID r17 = new InteractID("InteractiveSong", 14, 14);
        InteractiveSong = r17;
        InteractID r18 = new InteractID("VProject", 15, 15);
        VProject = r18;
        InteractID r19 = new InteractID("KtvRoomSelect", 16, 16);
        KtvRoomSelect = r19;
        InteractID r21 = new InteractID("PkOperationalPlayBo3", 17, 17);
        PkOperationalPlayBo3 = r21;
        InteractID r22 = new InteractID("GuestBattle", 18, 18);
        GuestBattle = r22;
        InteractID r23 = new InteractID("DigitAvatar", 19, 19);
        DigitAvatar = r23;
        InteractID r24 = new InteractID("KTVChallenge", 20, 20);
        KTVChallenge = r24;
        InteractID r25 = new InteractID("TeamFight", 21, 21);
        TeamFight = r25;
        InteractID r26 = new InteractID("PlayTogether", 22, 22);
        PlayTogether = r26;
        InteractID r27 = new InteractID("VideoKtv", 23, 23);
        VideoKtv = r27;
        InteractID r28 = new InteractID("PaidLink", 24, 25);
        PaidLink = r28;
        InteractID r29 = new InteractID("LinkRoomFight", 25, 26);
        LinkRoomFight = r29;
        InteractID r31 = new InteractID("SelfDiscipline", 26, 27);
        SelfDiscipline = r31;
        InteractID r32 = new InteractID("InteractiveSong2", 27, 29);
        InteractiveSong2 = r32;
        InteractID r33 = new InteractID("ThemedCompetition", 28, 30);
        ThemedCompetition = r33;
        InteractID r34 = new InteractID("Adventure", 29, 31);
        Adventure = r34;
        InteractID r35 = new InteractID("StarWish", 30, 34);
        StarWish = r35;
        InteractID r36 = new InteractID("InteractActing", 31, 42);
        InteractActing = r36;
        InteractID r0 = new InteractID("RevenueGameEffect", 32, 69);
        RevenueGameEffect = r0;
        InteractID r1 = new InteractID("RevenueGameEffectDynamic", 33, 70);
        RevenueGameEffectDynamic = r1;
        InteractID r37 = new InteractID("OpenGame", 34, 100);
        OpenGame = r37;
        InteractID r38 = new InteractID("Zhufen", 35, 101);
        Zhufen = r38;
        InteractID r39 = new InteractID("OpenMicroApp", 36, 103);
        OpenMicroApp = r39;
        InteractID r41 = new InteractID("SonicMiniGame", 37, 104);
        SonicMiniGame = r41;
        InteractID r42 = new InteractID("InteractLoki", 38, 105);
        InteractLoki = r42;
        InteractID r43 = new InteractID("InteractGamePlus", 39, 106);
        InteractGamePlus = r43;
        InteractID r44 = new InteractID("InteractMiniApp", 40, 107);
        InteractMiniApp = r44;
        InteractID r45 = new InteractID("OpenMicroGame", 41, 108);
        OpenMicroGame = r45;
        a = new InteractID[]{r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36, r0, r1, r37, r38, r39, r41, r42, r43, r44, r45};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public InteractID(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
