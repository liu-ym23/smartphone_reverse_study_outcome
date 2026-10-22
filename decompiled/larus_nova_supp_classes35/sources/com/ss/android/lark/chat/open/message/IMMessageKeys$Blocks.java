package com.ss.android.lark.chat.open.message;

import com.ss.android.lark.blueprint.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b:\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chat/open/message/IMMessageKeys$Blocks;", "Lcom/ss/android/lark/blueprint/IBlockKey;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "UNKNOWN_CONTENT", "FLOW_UNKNOWN_CONTENT", "RECALLED_CONTENT", "RECALLED_SYSTEM_CONTENT", "SYSTEM_CONTENT", "TEXT_CONTENT", "MESSAGE_ATTACHMENT_LIST", "IMAGE_CONTENT", "URL_PREVIEW", "URL_PREVIEW_CONTENT", "SHARE_GROUP_CHAT_CONTENT", "STICKER_CONTENT", "FILE_CONTENT", "FOLDER_CONTENT", "POST_CONTENT", "MEDIA_CONTENT", "MERGE_FORWARD_CONTENT", "THREAD_FORWARD_CONTENT", "AUDIO_CONTENT", "FOLD_CONTENT", "SYS_CHAT_GUIDE", "SYS_RED_PACKET", "HIDE_CONTENT", "DOUBAO_CONTENT", "FLOW_PROFILE_CONTENT", "FLOW_THREAD_FORWARD_HEADER", "FLOW_THREAD_FORWARD_EXPOSURE", "FLOW_CALENDAR_CONTENT", "FLOW_VIDEO_CHAT_CONTENT", "FLOW_RED_PACKET_CONTENT", "FLOW_TODO_CONTENT", "AVATAR", "USERNAME", "COT_PROCESS", "REACTION", "REPLY_IN_THREAD_EXPOSURE", "REPLY", "MESSAGE_STATUS", "FLAG", "TIME", "REPLY_COUNT", "PIN_INFO", "DING_DESC", "DING_ICON", "MULTI_SELECT", "DLP", "FILE_DETECT", "EDIT_STATUS", "RESTRICTED", "THREAD_REPLY", "APP_INFO_SOURCE", "AI_SMART_REPLY", "AI_SMART_REPLY_APPLY_ANSWER", "TRANSLATION_ENTRY", "EXCEL_PERMISSION", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMMessageKeys$Blocks extends Enum<IMMessageKeys$Blocks> implements j {
    public static final IMMessageKeys$Blocks AI_SMART_REPLY = null;
    public static final IMMessageKeys$Blocks AI_SMART_REPLY_APPLY_ANSWER = null;
    public static final IMMessageKeys$Blocks APP_INFO_SOURCE = null;
    public static final IMMessageKeys$Blocks AUDIO_CONTENT = null;
    public static final IMMessageKeys$Blocks AVATAR = null;
    public static final IMMessageKeys$Blocks COT_PROCESS = null;
    public static final IMMessageKeys$Blocks DING_DESC = null;
    public static final IMMessageKeys$Blocks DING_ICON = null;
    public static final IMMessageKeys$Blocks DLP = null;
    public static final IMMessageKeys$Blocks DOUBAO_CONTENT = null;
    public static final IMMessageKeys$Blocks EDIT_STATUS = null;
    public static final IMMessageKeys$Blocks EXCEL_PERMISSION = null;
    public static final IMMessageKeys$Blocks FILE_CONTENT = null;
    public static final IMMessageKeys$Blocks FILE_DETECT = null;
    public static final IMMessageKeys$Blocks FLAG = null;
    public static final IMMessageKeys$Blocks FLOW_CALENDAR_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_PROFILE_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_RED_PACKET_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_THREAD_FORWARD_EXPOSURE = null;
    public static final IMMessageKeys$Blocks FLOW_THREAD_FORWARD_HEADER = null;
    public static final IMMessageKeys$Blocks FLOW_TODO_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_UNKNOWN_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_VIDEO_CHAT_CONTENT = null;
    public static final IMMessageKeys$Blocks FOLDER_CONTENT = null;
    public static final IMMessageKeys$Blocks FOLD_CONTENT = null;
    public static final IMMessageKeys$Blocks HIDE_CONTENT = null;
    public static final IMMessageKeys$Blocks IMAGE_CONTENT = null;
    public static final IMMessageKeys$Blocks MEDIA_CONTENT = null;
    public static final IMMessageKeys$Blocks MERGE_FORWARD_CONTENT = null;
    public static final IMMessageKeys$Blocks MESSAGE_ATTACHMENT_LIST = null;
    public static final IMMessageKeys$Blocks MESSAGE_STATUS = null;
    public static final IMMessageKeys$Blocks MULTI_SELECT = null;
    public static final IMMessageKeys$Blocks PIN_INFO = null;
    public static final IMMessageKeys$Blocks POST_CONTENT = null;
    public static final IMMessageKeys$Blocks REACTION = null;
    public static final IMMessageKeys$Blocks RECALLED_CONTENT = null;
    public static final IMMessageKeys$Blocks RECALLED_SYSTEM_CONTENT = null;
    public static final IMMessageKeys$Blocks REPLY = null;
    public static final IMMessageKeys$Blocks REPLY_COUNT = null;
    public static final IMMessageKeys$Blocks REPLY_IN_THREAD_EXPOSURE = null;
    public static final IMMessageKeys$Blocks RESTRICTED = null;
    public static final IMMessageKeys$Blocks SHARE_GROUP_CHAT_CONTENT = null;
    public static final IMMessageKeys$Blocks STICKER_CONTENT = null;
    public static final IMMessageKeys$Blocks SYSTEM_CONTENT = null;
    public static final IMMessageKeys$Blocks SYS_CHAT_GUIDE = null;
    public static final IMMessageKeys$Blocks SYS_RED_PACKET = null;
    public static final IMMessageKeys$Blocks TEXT_CONTENT = null;
    public static final IMMessageKeys$Blocks THREAD_FORWARD_CONTENT = null;
    public static final IMMessageKeys$Blocks THREAD_REPLY = null;
    public static final IMMessageKeys$Blocks TIME = null;
    public static final IMMessageKeys$Blocks TRANSLATION_ENTRY = null;
    public static final IMMessageKeys$Blocks UNKNOWN_CONTENT = null;
    public static final IMMessageKeys$Blocks URL_PREVIEW = null;
    public static final IMMessageKeys$Blocks URL_PREVIEW_CONTENT = null;
    public static final IMMessageKeys$Blocks USERNAME = null;
    public static final /* synthetic */ IMMessageKeys$Blocks[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IMMessageKeys$Blocks> getEntries() {
        return b;
    }

    static {
        IMMessageKeys$Blocks r0 = new IMMessageKeys$Blocks("UNKNOWN_CONTENT", 0);
        UNKNOWN_CONTENT = r0;
        IMMessageKeys$Blocks r1 = new IMMessageKeys$Blocks("FLOW_UNKNOWN_CONTENT", 1);
        FLOW_UNKNOWN_CONTENT = r1;
        IMMessageKeys$Blocks r3 = new IMMessageKeys$Blocks("RECALLED_CONTENT", 2);
        RECALLED_CONTENT = r3;
        IMMessageKeys$Blocks r5 = new IMMessageKeys$Blocks("RECALLED_SYSTEM_CONTENT", 3);
        RECALLED_SYSTEM_CONTENT = r5;
        IMMessageKeys$Blocks r7 = new IMMessageKeys$Blocks("SYSTEM_CONTENT", 4);
        SYSTEM_CONTENT = r7;
        IMMessageKeys$Blocks r9 = new IMMessageKeys$Blocks("TEXT_CONTENT", 5);
        TEXT_CONTENT = r9;
        IMMessageKeys$Blocks r11 = new IMMessageKeys$Blocks("MESSAGE_ATTACHMENT_LIST", 6);
        MESSAGE_ATTACHMENT_LIST = r11;
        IMMessageKeys$Blocks r13 = new IMMessageKeys$Blocks("IMAGE_CONTENT", 7);
        IMAGE_CONTENT = r13;
        IMMessageKeys$Blocks r15 = new IMMessageKeys$Blocks("URL_PREVIEW", 8);
        URL_PREVIEW = r15;
        IMMessageKeys$Blocks r14 = new IMMessageKeys$Blocks("URL_PREVIEW_CONTENT", 9);
        URL_PREVIEW_CONTENT = r14;
        IMMessageKeys$Blocks r12 = new IMMessageKeys$Blocks("SHARE_GROUP_CHAT_CONTENT", 10);
        SHARE_GROUP_CHAT_CONTENT = r12;
        IMMessageKeys$Blocks r10 = new IMMessageKeys$Blocks("STICKER_CONTENT", 11);
        STICKER_CONTENT = r10;
        IMMessageKeys$Blocks r8 = new IMMessageKeys$Blocks("FILE_CONTENT", 12);
        FILE_CONTENT = r8;
        IMMessageKeys$Blocks r6 = new IMMessageKeys$Blocks("FOLDER_CONTENT", 13);
        FOLDER_CONTENT = r6;
        IMMessageKeys$Blocks r4 = new IMMessageKeys$Blocks("POST_CONTENT", 14);
        POST_CONTENT = r4;
        IMMessageKeys$Blocks r2 = new IMMessageKeys$Blocks("MEDIA_CONTENT", 15);
        MEDIA_CONTENT = r2;
        IMMessageKeys$Blocks r16 = new IMMessageKeys$Blocks("MERGE_FORWARD_CONTENT", 16);
        MERGE_FORWARD_CONTENT = r16;
        IMMessageKeys$Blocks r17 = new IMMessageKeys$Blocks("THREAD_FORWARD_CONTENT", 17);
        THREAD_FORWARD_CONTENT = r17;
        IMMessageKeys$Blocks r18 = new IMMessageKeys$Blocks("AUDIO_CONTENT", 18);
        AUDIO_CONTENT = r18;
        IMMessageKeys$Blocks r19 = new IMMessageKeys$Blocks("FOLD_CONTENT", 19);
        FOLD_CONTENT = r19;
        IMMessageKeys$Blocks r20 = new IMMessageKeys$Blocks("SYS_CHAT_GUIDE", 20);
        SYS_CHAT_GUIDE = r20;
        IMMessageKeys$Blocks r21 = new IMMessageKeys$Blocks("SYS_RED_PACKET", 21);
        SYS_RED_PACKET = r21;
        IMMessageKeys$Blocks r22 = new IMMessageKeys$Blocks("HIDE_CONTENT", 22);
        HIDE_CONTENT = r22;
        IMMessageKeys$Blocks r23 = new IMMessageKeys$Blocks("DOUBAO_CONTENT", 23);
        DOUBAO_CONTENT = r23;
        IMMessageKeys$Blocks r24 = new IMMessageKeys$Blocks("FLOW_PROFILE_CONTENT", 24);
        FLOW_PROFILE_CONTENT = r24;
        IMMessageKeys$Blocks r25 = new IMMessageKeys$Blocks("FLOW_THREAD_FORWARD_HEADER", 25);
        FLOW_THREAD_FORWARD_HEADER = r25;
        IMMessageKeys$Blocks r26 = new IMMessageKeys$Blocks("FLOW_THREAD_FORWARD_EXPOSURE", 26);
        FLOW_THREAD_FORWARD_EXPOSURE = r26;
        IMMessageKeys$Blocks r27 = new IMMessageKeys$Blocks("FLOW_CALENDAR_CONTENT", 27);
        FLOW_CALENDAR_CONTENT = r27;
        IMMessageKeys$Blocks r28 = new IMMessageKeys$Blocks("FLOW_VIDEO_CHAT_CONTENT", 28);
        FLOW_VIDEO_CHAT_CONTENT = r28;
        IMMessageKeys$Blocks r29 = new IMMessageKeys$Blocks("FLOW_RED_PACKET_CONTENT", 29);
        FLOW_RED_PACKET_CONTENT = r29;
        IMMessageKeys$Blocks r30 = new IMMessageKeys$Blocks("FLOW_TODO_CONTENT", 30);
        FLOW_TODO_CONTENT = r30;
        IMMessageKeys$Blocks r31 = new IMMessageKeys$Blocks("AVATAR", 31);
        AVATAR = r31;
        IMMessageKeys$Blocks r32 = new IMMessageKeys$Blocks("USERNAME", 32);
        USERNAME = r32;
        IMMessageKeys$Blocks r33 = new IMMessageKeys$Blocks("COT_PROCESS", 33);
        COT_PROCESS = r33;
        IMMessageKeys$Blocks r34 = new IMMessageKeys$Blocks("REACTION", 34);
        REACTION = r34;
        IMMessageKeys$Blocks r35 = new IMMessageKeys$Blocks("REPLY_IN_THREAD_EXPOSURE", 35);
        REPLY_IN_THREAD_EXPOSURE = r35;
        IMMessageKeys$Blocks r36 = new IMMessageKeys$Blocks("REPLY", 36);
        REPLY = r36;
        IMMessageKeys$Blocks r37 = new IMMessageKeys$Blocks("MESSAGE_STATUS", 37);
        MESSAGE_STATUS = r37;
        IMMessageKeys$Blocks r38 = new IMMessageKeys$Blocks("FLAG", 38);
        FLAG = r38;
        IMMessageKeys$Blocks r39 = new IMMessageKeys$Blocks("TIME", 39);
        TIME = r39;
        IMMessageKeys$Blocks r40 = new IMMessageKeys$Blocks("REPLY_COUNT", 40);
        REPLY_COUNT = r40;
        IMMessageKeys$Blocks r41 = new IMMessageKeys$Blocks("PIN_INFO", 41);
        PIN_INFO = r41;
        IMMessageKeys$Blocks r42 = new IMMessageKeys$Blocks("DING_DESC", 42);
        DING_DESC = r42;
        IMMessageKeys$Blocks r43 = new IMMessageKeys$Blocks("DING_ICON", 43);
        DING_ICON = r43;
        IMMessageKeys$Blocks r44 = new IMMessageKeys$Blocks("MULTI_SELECT", 44);
        MULTI_SELECT = r44;
        IMMessageKeys$Blocks r45 = new IMMessageKeys$Blocks("DLP", 45);
        DLP = r45;
        IMMessageKeys$Blocks r46 = new IMMessageKeys$Blocks("FILE_DETECT", 46);
        FILE_DETECT = r46;
        IMMessageKeys$Blocks r47 = new IMMessageKeys$Blocks("EDIT_STATUS", 47);
        EDIT_STATUS = r47;
        IMMessageKeys$Blocks r48 = new IMMessageKeys$Blocks("RESTRICTED", 48);
        RESTRICTED = r48;
        IMMessageKeys$Blocks r49 = new IMMessageKeys$Blocks("THREAD_REPLY", 49);
        THREAD_REPLY = r49;
        IMMessageKeys$Blocks r50 = new IMMessageKeys$Blocks("APP_INFO_SOURCE", 50);
        APP_INFO_SOURCE = r50;
        IMMessageKeys$Blocks r51 = new IMMessageKeys$Blocks("AI_SMART_REPLY", 51);
        AI_SMART_REPLY = r51;
        IMMessageKeys$Blocks r52 = new IMMessageKeys$Blocks("AI_SMART_REPLY_APPLY_ANSWER", 52);
        AI_SMART_REPLY_APPLY_ANSWER = r52;
        IMMessageKeys$Blocks r53 = new IMMessageKeys$Blocks("TRANSLATION_ENTRY", 53);
        TRANSLATION_ENTRY = r53;
        IMMessageKeys$Blocks r54 = new IMMessageKeys$Blocks("EXCEL_PERMISSION", 54);
        EXCEL_PERMISSION = r54;
        IMMessageKeys$Blocks[] r55 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54};
        a = r55;
        b = EnumEntriesKt.enumEntries(r55);
    }

    public static IMMessageKeys$Blocks[] values() {
        return (IMMessageKeys$Blocks[]) a.clone();
    }

    public static IMMessageKeys$Blocks valueOf(String r1) {
        return (IMMessageKeys$Blocks) a.a(IMMessageKeys$Blocks.class, r1);
    }

    public IMMessageKeys$Blocks(String r1, int r2) {
        super(r1, r2);
    }
}
