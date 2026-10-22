package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/AddChatChatterApply$Ways;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_WAY", "VIA_SHARE", "VIA_INVITATION", "VIA_QR_CODE", "VIA_SEARCH", "VIA_DEPARTMENT_STRUCTURE", "VIA_LINK", "VIA_TEAM_OPEN_CHAT", "VIA_CALENDER", "VIA_TEAM_PRIVATE_DISCOVERABLE", "VIA_CHAT_LINKED_PAGE", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AddChatChatterApply$Ways extends Enum<AddChatChatterApply$Ways> {
    public static final a Companion = null;
    public static final AddChatChatterApply$Ways UNKNOWN_WAY = null;
    public static final AddChatChatterApply$Ways VIA_CALENDER = null;
    public static final AddChatChatterApply$Ways VIA_CHAT_LINKED_PAGE = null;
    public static final AddChatChatterApply$Ways VIA_DEPARTMENT_STRUCTURE = null;
    public static final AddChatChatterApply$Ways VIA_INVITATION = null;
    public static final AddChatChatterApply$Ways VIA_LINK = null;
    public static final AddChatChatterApply$Ways VIA_QR_CODE = null;
    public static final AddChatChatterApply$Ways VIA_SEARCH = null;
    public static final AddChatChatterApply$Ways VIA_SHARE = null;
    public static final AddChatChatterApply$Ways VIA_TEAM_OPEN_CHAT = null;
    public static final AddChatChatterApply$Ways VIA_TEAM_PRIVATE_DISCOVERABLE = null;
    public static final /* synthetic */ AddChatChatterApply$Ways[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<AddChatChatterApply$Ways> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.ss.android.lark.chat.entity.chat.AddChatChatterApply$Ways$a] */
    static {
        AddChatChatterApply$Ways r0 = new AddChatChatterApply$Ways("UNKNOWN_WAY", 0, 0);
        UNKNOWN_WAY = r0;
        AddChatChatterApply$Ways r1 = new AddChatChatterApply$Ways("VIA_SHARE", 1, 1);
        VIA_SHARE = r1;
        AddChatChatterApply$Ways r3 = new AddChatChatterApply$Ways("VIA_INVITATION", 2, 2);
        VIA_INVITATION = r3;
        AddChatChatterApply$Ways r5 = new AddChatChatterApply$Ways("VIA_QR_CODE", 3, 3);
        VIA_QR_CODE = r5;
        AddChatChatterApply$Ways r7 = new AddChatChatterApply$Ways("VIA_SEARCH", 4, 4);
        VIA_SEARCH = r7;
        AddChatChatterApply$Ways r9 = new AddChatChatterApply$Ways("VIA_DEPARTMENT_STRUCTURE", 5, 5);
        VIA_DEPARTMENT_STRUCTURE = r9;
        AddChatChatterApply$Ways r11 = new AddChatChatterApply$Ways("VIA_LINK", 6, 6);
        VIA_LINK = r11;
        AddChatChatterApply$Ways r13 = new AddChatChatterApply$Ways("VIA_TEAM_OPEN_CHAT", 7, 7);
        VIA_TEAM_OPEN_CHAT = r13;
        AddChatChatterApply$Ways r15 = new AddChatChatterApply$Ways("VIA_CALENDER", 8, 8);
        VIA_CALENDER = r15;
        AddChatChatterApply$Ways r14 = new AddChatChatterApply$Ways("VIA_TEAM_PRIVATE_DISCOVERABLE", 9, 9);
        VIA_TEAM_PRIVATE_DISCOVERABLE = r14;
        AddChatChatterApply$Ways r12 = new AddChatChatterApply$Ways("VIA_CHAT_LINKED_PAGE", 10, 10);
        VIA_CHAT_LINKED_PAGE = r12;
        AddChatChatterApply$Ways[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public static AddChatChatterApply$Ways[] values() {
        return (AddChatChatterApply$Ways[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AddChatChatterApply$Ways valueOf(String r1) {
        return (AddChatChatterApply$Ways) r27.a.a(AddChatChatterApply$Ways.class, r1);
    }

    public AddChatChatterApply$Ways(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
