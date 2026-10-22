package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatShareInfo$ShareStatus;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATE", "ACTIVE", "EXPIRED", "DEACTIVATED", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatShareInfo$ShareStatus extends Enum<ChatShareInfo$ShareStatus> {
    public static final ChatShareInfo$ShareStatus ACTIVE = null;
    public static final a Companion = null;
    public static final ChatShareInfo$ShareStatus DEACTIVATED = null;
    public static final ChatShareInfo$ShareStatus EXPIRED = null;
    public static final ChatShareInfo$ShareStatus UNKNOWN_STATE = null;
    public static final /* synthetic */ ChatShareInfo$ShareStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ChatShareInfo$ShareStatus> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.entity.chat.ChatShareInfo$ShareStatus$a] */
    static {
        ChatShareInfo$ShareStatus r0 = new ChatShareInfo$ShareStatus("UNKNOWN_STATE", 0, 0);
        UNKNOWN_STATE = r0;
        ChatShareInfo$ShareStatus r1 = new ChatShareInfo$ShareStatus("ACTIVE", 1, 1);
        ACTIVE = r1;
        ChatShareInfo$ShareStatus r3 = new ChatShareInfo$ShareStatus("EXPIRED", 2, 2);
        EXPIRED = r3;
        ChatShareInfo$ShareStatus r5 = new ChatShareInfo$ShareStatus("DEACTIVATED", 3, 3);
        DEACTIVATED = r5;
        ChatShareInfo$ShareStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static ChatShareInfo$ShareStatus[] values() {
        return (ChatShareInfo$ShareStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatShareInfo$ShareStatus valueOf(String r1) {
        return (ChatShareInfo$ShareStatus) r27.a.a(ChatShareInfo$ShareStatus.class, r1);
    }

    public ChatShareInfo$ShareStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
