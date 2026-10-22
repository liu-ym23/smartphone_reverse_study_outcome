package com.ss.android.lark.compose.chatsetting.common.platform;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingTrackEvent;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "GROUP_MEMBER", "GROUP_MEMBER_AVATAR", "GROUP_MEMBER_ADD", "GROUP_MEMBER_DELETE", "EDIT_GROUP_INFO", "GROUP_QR_CODE", "GROUP_MANAGE", "MUTE_TOGGLE", "PIN_TOGGLE", "SEARCH", "CLEAR_HISTORY_ENTRY", "CLEAR_HISTORY_CONFIRM", "DISMISS_GROUP_ENTRY", "DISMISS_GROUP_CONFIRM", "QUIT_GROUP_ENTRY", "QUIT_GROUP_CONFIRM", "REPORT", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatSettingTrackEvent extends Enum<ChatSettingTrackEvent> {
    public static final ChatSettingTrackEvent CLEAR_HISTORY_CONFIRM = null;
    public static final ChatSettingTrackEvent CLEAR_HISTORY_ENTRY = null;
    public static final ChatSettingTrackEvent DISMISS_GROUP_CONFIRM = null;
    public static final ChatSettingTrackEvent DISMISS_GROUP_ENTRY = null;
    public static final ChatSettingTrackEvent EDIT_GROUP_INFO = null;
    public static final ChatSettingTrackEvent GROUP_MANAGE = null;
    public static final ChatSettingTrackEvent GROUP_MEMBER = null;
    public static final ChatSettingTrackEvent GROUP_MEMBER_ADD = null;
    public static final ChatSettingTrackEvent GROUP_MEMBER_AVATAR = null;
    public static final ChatSettingTrackEvent GROUP_MEMBER_DELETE = null;
    public static final ChatSettingTrackEvent GROUP_QR_CODE = null;
    public static final ChatSettingTrackEvent MUTE_TOGGLE = null;
    public static final ChatSettingTrackEvent PIN_TOGGLE = null;
    public static final ChatSettingTrackEvent QUIT_GROUP_CONFIRM = null;
    public static final ChatSettingTrackEvent QUIT_GROUP_ENTRY = null;
    public static final ChatSettingTrackEvent REPORT = null;
    public static final ChatSettingTrackEvent SEARCH = null;
    public static final /* synthetic */ ChatSettingTrackEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatSettingTrackEvent> getEntries() {
        return b;
    }

    static {
        ChatSettingTrackEvent r0 = new ChatSettingTrackEvent("GROUP_MEMBER", 0);
        GROUP_MEMBER = r0;
        ChatSettingTrackEvent r1 = new ChatSettingTrackEvent("GROUP_MEMBER_AVATAR", 1);
        GROUP_MEMBER_AVATAR = r1;
        ChatSettingTrackEvent r3 = new ChatSettingTrackEvent("GROUP_MEMBER_ADD", 2);
        GROUP_MEMBER_ADD = r3;
        ChatSettingTrackEvent r5 = new ChatSettingTrackEvent("GROUP_MEMBER_DELETE", 3);
        GROUP_MEMBER_DELETE = r5;
        ChatSettingTrackEvent r7 = new ChatSettingTrackEvent("EDIT_GROUP_INFO", 4);
        EDIT_GROUP_INFO = r7;
        ChatSettingTrackEvent r9 = new ChatSettingTrackEvent("GROUP_QR_CODE", 5);
        GROUP_QR_CODE = r9;
        ChatSettingTrackEvent r11 = new ChatSettingTrackEvent("GROUP_MANAGE", 6);
        GROUP_MANAGE = r11;
        ChatSettingTrackEvent r13 = new ChatSettingTrackEvent("MUTE_TOGGLE", 7);
        MUTE_TOGGLE = r13;
        ChatSettingTrackEvent r15 = new ChatSettingTrackEvent("PIN_TOGGLE", 8);
        PIN_TOGGLE = r15;
        ChatSettingTrackEvent r14 = new ChatSettingTrackEvent("SEARCH", 9);
        SEARCH = r14;
        ChatSettingTrackEvent r12 = new ChatSettingTrackEvent("CLEAR_HISTORY_ENTRY", 10);
        CLEAR_HISTORY_ENTRY = r12;
        ChatSettingTrackEvent r10 = new ChatSettingTrackEvent("CLEAR_HISTORY_CONFIRM", 11);
        CLEAR_HISTORY_CONFIRM = r10;
        ChatSettingTrackEvent r8 = new ChatSettingTrackEvent("DISMISS_GROUP_ENTRY", 12);
        DISMISS_GROUP_ENTRY = r8;
        ChatSettingTrackEvent r6 = new ChatSettingTrackEvent("DISMISS_GROUP_CONFIRM", 13);
        DISMISS_GROUP_CONFIRM = r6;
        ChatSettingTrackEvent r4 = new ChatSettingTrackEvent("QUIT_GROUP_ENTRY", 14);
        QUIT_GROUP_ENTRY = r4;
        ChatSettingTrackEvent r2 = new ChatSettingTrackEvent("QUIT_GROUP_CONFIRM", 15);
        QUIT_GROUP_CONFIRM = r2;
        ChatSettingTrackEvent r16 = new ChatSettingTrackEvent("REPORT", 16);
        REPORT = r16;
        ChatSettingTrackEvent[] r17 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
    }

    public static ChatSettingTrackEvent[] values() {
        return (ChatSettingTrackEvent[]) a.clone();
    }

    public static ChatSettingTrackEvent valueOf(String r1) {
        return (ChatSettingTrackEvent) r27.a.a(ChatSettingTrackEvent.class, r1);
    }

    public ChatSettingTrackEvent(String r1, int r2) {
        super(r1, r2);
    }
}
