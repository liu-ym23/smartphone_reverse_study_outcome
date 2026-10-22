package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatShareInfo$ShareType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "CARD_MESSAGE", "QRCODE", "CARD_DOC", "LINK", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatShareInfo$ShareType extends Enum<ChatShareInfo$ShareType> {
    public static final ChatShareInfo$ShareType CARD_DOC = null;
    public static final ChatShareInfo$ShareType CARD_MESSAGE = null;
    public static final a Companion = null;
    public static final ChatShareInfo$ShareType LINK = null;
    public static final ChatShareInfo$ShareType QRCODE = null;
    public static final ChatShareInfo$ShareType UNKNOWN_TYPE = null;
    public static final /* synthetic */ ChatShareInfo$ShareType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ChatShareInfo$ShareType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.entity.chat.ChatShareInfo$ShareType$a] */
    static {
        ChatShareInfo$ShareType r0 = new ChatShareInfo$ShareType("UNKNOWN_TYPE", 0, 0);
        UNKNOWN_TYPE = r0;
        ChatShareInfo$ShareType r1 = new ChatShareInfo$ShareType("CARD_MESSAGE", 1, 1);
        CARD_MESSAGE = r1;
        ChatShareInfo$ShareType r3 = new ChatShareInfo$ShareType("QRCODE", 2, 2);
        QRCODE = r3;
        ChatShareInfo$ShareType r5 = new ChatShareInfo$ShareType("CARD_DOC", 3, 3);
        CARD_DOC = r5;
        ChatShareInfo$ShareType r7 = new ChatShareInfo$ShareType("LINK", 4, 4);
        LINK = r7;
        ChatShareInfo$ShareType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static ChatShareInfo$ShareType[] values() {
        return (ChatShareInfo$ShareType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatShareInfo$ShareType valueOf(String r1) {
        return (ChatShareInfo$ShareType) r27.a.a(ChatShareInfo$ShareType.class, r1);
    }

    public ChatShareInfo$ShareType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
