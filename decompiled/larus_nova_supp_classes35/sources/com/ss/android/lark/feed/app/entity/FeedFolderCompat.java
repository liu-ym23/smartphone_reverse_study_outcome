package com.ss.android.lark.feed.app.entity;

import com.bytedance.lark.pb.feed.v1.FlagSortingRule;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050BJ\u000e\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020EJ\u000e\u0010F\u001a\u00020\u00052\u0006\u0010D\u001a\u00020EJ\u0010\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020IH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u0011\u0010#\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0007R\u0011\u0010%\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0007R\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0007R\u0011\u0010)\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007R\u0011\u0010+\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0007R\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007R\u0011\u0010/\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R\u0011\u00101\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u0011\u00103\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007R\u0011\u00105\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u0011\u00107\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u0011\u00109\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0007R\u0011\u0010;\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0007R\u0011\u0010=\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0007R\u0011\u0010?\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0007¨\u0006J"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/FeedFolderCompat;", BuildConfig.FLAVOR, "<init>", "()V", "UNKNOWN", "Lcom/ss/android/lark/feed/app/entity/FeedFolder;", "getUNKNOWN", "()Lcom/ss/android/lark/feed/app/entity/FeedFolder;", "INBOX", "getINBOX", "AT_ME", "getAT_ME", "UNREAD", "getUNREAD", "DELAYED", "getDELAYED$annotations", "getDELAYED", "DOC", "getDOC", "P2P_CHAT", "getP2P_CHAT", "GROUP_CHAT", "getGROUP_CHAT", "BOT", "getBOT", "HELP_DESK", "getHELP_DESK", "TOPIC_GROUP", "getTOPIC_GROUP", "DONE", "getDONE", "CRYPTO_CHAT", "getCRYPTO_CHAT", "MESSAGE", "getMESSAGE", "MUTE", "getMUTE", "GROUP", "getGROUP", "TEAM", "getTEAM", "TAG", "getTAG", "FLAG", "getFLAG", "THREAD", "getTHREAD", "SHORTCUTS", "getSHORTCUTS", "BOX", "getBOX", "UNREAD_OVER_DAYS", "getUNREAD_OVER_DAYS", "CALENDAR_GROUP", "getCALENDAR_GROUP", "INSTANT_MEETING_GROUP", "getINSTANT_MEETING_GROUP", "COLLAPSED", "getCOLLAPSED", "EXPIRED_FOLD", "getEXPIRED_FOLD", "MARK_AS_DELETED", "getMARK_AS_DELETED", "MESSAGE_WITHOUT_DOUBAO", "getMESSAGE_WITHOUT_DOUBAO", "values", BuildConfig.FLAVOR, "valueOf", "value", BuildConfig.FLAVOR, "forNumber", "createCompatFeedFolder", "feedFilter", "Lcom/ss/android/lark/feed/app/entity/FeedFilter;", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedFolderCompat {
    private static final FeedFolder AT_ME = null;
    private static final FeedFolder BOT = null;
    private static final FeedFolder BOX = null;
    private static final FeedFolder CALENDAR_GROUP = null;
    private static final FeedFolder COLLAPSED = null;
    private static final FeedFolder CRYPTO_CHAT = null;
    private static final FeedFolder DELAYED = null;
    private static final FeedFolder DOC = null;
    private static final FeedFolder DONE = null;
    private static final FeedFolder EXPIRED_FOLD = null;
    private static final FeedFolder FLAG = null;
    private static final FeedFolder GROUP = null;
    private static final FeedFolder GROUP_CHAT = null;
    private static final FeedFolder HELP_DESK = null;
    private static final FeedFolder INBOX = null;
    public static final FeedFolderCompat INSTANCE = null;
    private static final FeedFolder INSTANT_MEETING_GROUP = null;
    private static final FeedFolder MARK_AS_DELETED = null;
    private static final FeedFolder MESSAGE = null;
    private static final FeedFolder MESSAGE_WITHOUT_DOUBAO = null;
    private static final FeedFolder MUTE = null;
    private static final FeedFolder P2P_CHAT = null;
    private static final FeedFolder SHORTCUTS = null;
    private static final FeedFolder TAG = null;
    private static final FeedFolder TEAM = null;
    private static final FeedFolder THREAD = null;
    private static final FeedFolder TOPIC_GROUP = null;
    private static final FeedFolder UNKNOWN = null;
    private static final FeedFolder UNREAD = null;
    private static final FeedFolder UNREAD_OVER_DAYS = null;

    private FeedFolderCompat() {
    }

    @Deprecated(message = "deleted")
    public static /* synthetic */ void getDELAYED$annotations() {
    }

    static {
        FeedFolderCompat r0 = new FeedFolderCompat();
        INSTANCE = r0;
        UNKNOWN = r0.createCompatFeedFolder(FeedFilter.UNKNOWN);
        INBOX = r0.createCompatFeedFolder(FeedFilter.INBOX);
        AT_ME = r0.createCompatFeedFolder(FeedFilter.AT_ME);
        UNREAD = r0.createCompatFeedFolder(FeedFilter.UNREAD);
        DELAYED = r0.createCompatFeedFolder(FeedFilter.DELAYED);
        DOC = r0.createCompatFeedFolder(FeedFilter.DOC);
        P2P_CHAT = r0.createCompatFeedFolder(FeedFilter.P2P_CHAT);
        GROUP_CHAT = r0.createCompatFeedFolder(FeedFilter.GROUP_CHAT);
        BOT = r0.createCompatFeedFolder(FeedFilter.BOT);
        HELP_DESK = r0.createCompatFeedFolder(FeedFilter.HELP_DESK);
        TOPIC_GROUP = r0.createCompatFeedFolder(FeedFilter.TOPIC_GROUP);
        DONE = r0.createCompatFeedFolder(FeedFilter.DONE);
        CRYPTO_CHAT = r0.createCompatFeedFolder(FeedFilter.CRYPTO_CHAT);
        MESSAGE = r0.createCompatFeedFolder(FeedFilter.MESSAGE);
        MUTE = r0.createCompatFeedFolder(FeedFilter.MUTE);
        GROUP = r0.createCompatFeedFolder(FeedFilter.GROUP);
        TEAM = r0.createCompatFeedFolder(FeedFilter.TEAM);
        TAG = r0.createCompatFeedFolder(FeedFilter.TAG);
        FLAG = r0.createCompatFeedFolder(FeedFilter.FLAG);
        THREAD = r0.createCompatFeedFolder(FeedFilter.THREAD);
        SHORTCUTS = r0.createCompatFeedFolder(FeedFilter.SHORTCUTS);
        BOX = r0.createCompatFeedFolder(FeedFilter.BOX);
        UNREAD_OVER_DAYS = r0.createCompatFeedFolder(FeedFilter.UNREAD_OVER_DAYS);
        CALENDAR_GROUP = r0.createCompatFeedFolder(FeedFilter.CALENDAR_GROUP);
        INSTANT_MEETING_GROUP = r0.createCompatFeedFolder(FeedFilter.INSTANT_MEETING_GROUP);
        COLLAPSED = r0.createCompatFeedFolder(FeedFilter.COLLAPSED);
        EXPIRED_FOLD = r0.createCompatFeedFolder(FeedFilter.EXPIRED_FOLD);
        MARK_AS_DELETED = r0.createCompatFeedFolder(FeedFilter.MARK_AS_DELETED);
        MESSAGE_WITHOUT_DOUBAO = r0.createCompatFeedFolder(FeedFilter.MESSAGE_WITHOUT_DOUBAO);
    }

    public final List<FeedFolder> values() {
        return CollectionsKt.listOf(new FeedFolder[]{UNKNOWN, INBOX, AT_ME, UNREAD, DELAYED, DOC, P2P_CHAT, GROUP_CHAT, BOT, HELP_DESK, TOPIC_GROUP, DONE, CRYPTO_CHAT, MESSAGE, MUTE, GROUP, TEAM, TAG, FLAG, THREAD, SHORTCUTS, BOX, UNREAD_OVER_DAYS, CALENDAR_GROUP, INSTANT_MEETING_GROUP, COLLAPSED, EXPIRED_FOLD, MARK_AS_DELETED, MESSAGE_WITHOUT_DOUBAO});
    }

    public final FeedFolder getAT_ME() {
        return AT_ME;
    }

    public final FeedFolder getBOT() {
        return BOT;
    }

    public final FeedFolder getBOX() {
        return BOX;
    }

    public final FeedFolder getCALENDAR_GROUP() {
        return CALENDAR_GROUP;
    }

    public final FeedFolder getCOLLAPSED() {
        return COLLAPSED;
    }

    public final FeedFolder getCRYPTO_CHAT() {
        return CRYPTO_CHAT;
    }

    public final FeedFolder getDELAYED() {
        return DELAYED;
    }

    public final FeedFolder getDOC() {
        return DOC;
    }

    public final FeedFolder getDONE() {
        return DONE;
    }

    public final FeedFolder getEXPIRED_FOLD() {
        return EXPIRED_FOLD;
    }

    public final FeedFolder getFLAG() {
        return FLAG;
    }

    public final FeedFolder getGROUP() {
        return GROUP;
    }

    public final FeedFolder getGROUP_CHAT() {
        return GROUP_CHAT;
    }

    public final FeedFolder getHELP_DESK() {
        return HELP_DESK;
    }

    public final FeedFolder getINBOX() {
        return INBOX;
    }

    public final FeedFolder getINSTANT_MEETING_GROUP() {
        return INSTANT_MEETING_GROUP;
    }

    public final FeedFolder getMARK_AS_DELETED() {
        return MARK_AS_DELETED;
    }

    public final FeedFolder getMESSAGE() {
        return MESSAGE;
    }

    public final FeedFolder getMESSAGE_WITHOUT_DOUBAO() {
        return MESSAGE_WITHOUT_DOUBAO;
    }

    public final FeedFolder getMUTE() {
        return MUTE;
    }

    public final FeedFolder getP2P_CHAT() {
        return P2P_CHAT;
    }

    public final FeedFolder getSHORTCUTS() {
        return SHORTCUTS;
    }

    public final FeedFolder getTAG() {
        return TAG;
    }

    public final FeedFolder getTEAM() {
        return TEAM;
    }

    public final FeedFolder getTHREAD() {
        return THREAD;
    }

    public final FeedFolder getTOPIC_GROUP() {
        return TOPIC_GROUP;
    }

    public final FeedFolder getUNKNOWN() {
        return UNKNOWN;
    }

    public final FeedFolder getUNREAD() {
        return UNREAD;
    }

    public final FeedFolder getUNREAD_OVER_DAYS() {
        return UNREAD_OVER_DAYS;
    }

    private final FeedFolder createCompatFeedFolder(FeedFilter r12) {
        return new FeedFolder(r12.getValue(), MapsKt.emptyMap(), CollectionsKt.emptyList(), r12, new FeedFolderSpecialSetting(FlagSortingRule.DEFAULT), 0, true);
    }

    public final FeedFolder forNumber(int r2) {
        if (r2 == 100) goto L39;
        if (r2 == 101) goto L68;
        switch(r2) {
            case 0: goto L67;
            case 1: goto L66;
            case 2: goto L65;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            case 12: goto L55;
            case 13: goto L54;
            case 14: goto L53;
            case 15: goto L52;
            case 16: goto L51;
            default: goto L7;
        };
    L7:
        switch(r2) {
            case 18: goto L50;
            case 19: goto L49;
            case 20: goto L48;
            case 21: goto L47;
            case 22: goto L46;
            case 23: goto L45;
            case 24: goto L44;
            default: goto L8;
        };
    L8:
        switch(r2) {
            case 26: goto L43;
            case 27: goto L42;
            case 28: goto L41;
            default: goto L40;
        };
    L40:
        return UNKNOWN;
    L41:
        return MESSAGE_WITHOUT_DOUBAO;
    L42:
        return MARK_AS_DELETED;
    L43:
        return EXPIRED_FOLD;
    L44:
        return COLLAPSED;
    L45:
        return INSTANT_MEETING_GROUP;
    L46:
        return CALENDAR_GROUP;
    L47:
        return UNREAD_OVER_DAYS;
    L48:
        return THREAD;
    L49:
        return FLAG;
    L50:
        return TAG;
    L51:
        return TEAM;
    L52:
        return GROUP;
    L53:
        return MUTE;
    L54:
        return MESSAGE;
    L55:
        return CRYPTO_CHAT;
    L56:
        return DONE;
    L57:
        return TOPIC_GROUP;
    L58:
        return HELP_DESK;
    L59:
        return BOT;
    L60:
        return GROUP_CHAT;
    L61:
        return P2P_CHAT;
    L62:
        return DOC;
    L63:
        return DELAYED;
    L64:
        return UNREAD;
    L65:
        return AT_ME;
    L66:
        return INBOX;
    L67:
        return UNKNOWN;
    L68:
        return BOX;
    L39:
        return SHORTCUTS;
    }

    public final FeedFolder valueOf(int r1) {
        return forNumber(r1);
    }
}
