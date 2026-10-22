package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatShareInfo$ShareTargetType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TARGET_TYPE", "TARGET_CHAT", "TARGET_CHATTER", "TARGET_QRCODE", "TARGET_DOC", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatShareInfo$ShareTargetType extends Enum<ChatShareInfo$ShareTargetType> {
    public static final a Companion = null;
    public static final ChatShareInfo$ShareTargetType TARGET_CHAT = null;
    public static final ChatShareInfo$ShareTargetType TARGET_CHATTER = null;
    public static final ChatShareInfo$ShareTargetType TARGET_DOC = null;
    public static final ChatShareInfo$ShareTargetType TARGET_QRCODE = null;
    public static final ChatShareInfo$ShareTargetType UNKNOWN_TARGET_TYPE = null;
    public static final /* synthetic */ ChatShareInfo$ShareTargetType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ChatShareInfo$ShareTargetType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.entity.chat.ChatShareInfo$ShareTargetType$a] */
    static {
        ChatShareInfo$ShareTargetType r0 = new ChatShareInfo$ShareTargetType("UNKNOWN_TARGET_TYPE", 0, 0);
        UNKNOWN_TARGET_TYPE = r0;
        ChatShareInfo$ShareTargetType r1 = new ChatShareInfo$ShareTargetType("TARGET_CHAT", 1, 1);
        TARGET_CHAT = r1;
        ChatShareInfo$ShareTargetType r3 = new ChatShareInfo$ShareTargetType("TARGET_CHATTER", 2, 2);
        TARGET_CHATTER = r3;
        ChatShareInfo$ShareTargetType r5 = new ChatShareInfo$ShareTargetType("TARGET_QRCODE", 3, 3);
        TARGET_QRCODE = r5;
        ChatShareInfo$ShareTargetType r7 = new ChatShareInfo$ShareTargetType("TARGET_DOC", 4, 4);
        TARGET_DOC = r7;
        ChatShareInfo$ShareTargetType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static ChatShareInfo$ShareTargetType[] values() {
        return (ChatShareInfo$ShareTargetType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatShareInfo$ShareTargetType valueOf(String r1) {
        return (ChatShareInfo$ShareTargetType) r27.a.a(ChatShareInfo$ShareTargetType.class, r1);
    }

    public ChatShareInfo$ShareTargetType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
