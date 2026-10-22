package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/list/ChatListComponent$KeepScreenOnReplyTrigger;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RESUME", "PAUSE", "STOP", "VIEW_DESTROYED", "DESTROY", "LIST_UPDATED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ChatListComponent$KeepScreenOnReplyTrigger extends Enum<ChatListComponent$KeepScreenOnReplyTrigger> {
    public static final ChatListComponent$KeepScreenOnReplyTrigger DESTROY = null;
    public static final ChatListComponent$KeepScreenOnReplyTrigger LIST_UPDATED = null;
    public static final ChatListComponent$KeepScreenOnReplyTrigger PAUSE = null;
    public static final ChatListComponent$KeepScreenOnReplyTrigger RESUME = null;
    public static final ChatListComponent$KeepScreenOnReplyTrigger STOP = null;
    public static final ChatListComponent$KeepScreenOnReplyTrigger VIEW_DESTROYED = null;
    public static final /* synthetic */ ChatListComponent$KeepScreenOnReplyTrigger[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ChatListComponent$KeepScreenOnReplyTrigger> getEntries() {
        return b;
    }

    static {
        ChatListComponent$KeepScreenOnReplyTrigger r0 = new ChatListComponent$KeepScreenOnReplyTrigger("RESUME", 0, "resume");
        RESUME = r0;
        ChatListComponent$KeepScreenOnReplyTrigger r1 = new ChatListComponent$KeepScreenOnReplyTrigger("PAUSE", 1, "pause");
        PAUSE = r1;
        ChatListComponent$KeepScreenOnReplyTrigger r2 = new ChatListComponent$KeepScreenOnReplyTrigger("STOP", 2, "stop");
        STOP = r2;
        ChatListComponent$KeepScreenOnReplyTrigger r4 = new ChatListComponent$KeepScreenOnReplyTrigger("VIEW_DESTROYED", 3, "viewDestroyed");
        VIEW_DESTROYED = r4;
        ChatListComponent$KeepScreenOnReplyTrigger r6 = new ChatListComponent$KeepScreenOnReplyTrigger("DESTROY", 4, "destroy");
        DESTROY = r6;
        ChatListComponent$KeepScreenOnReplyTrigger r8 = new ChatListComponent$KeepScreenOnReplyTrigger("LIST_UPDATED", 5, "listUpdated");
        LIST_UPDATED = r8;
        ChatListComponent$KeepScreenOnReplyTrigger[] r10 = {r0, r1, r2, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static ChatListComponent$KeepScreenOnReplyTrigger[] values() {
        return (ChatListComponent$KeepScreenOnReplyTrigger[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ChatListComponent$KeepScreenOnReplyTrigger valueOf(String r1) {
        return (ChatListComponent$KeepScreenOnReplyTrigger) a.a(ChatListComponent$KeepScreenOnReplyTrigger.class, r1);
    }

    public ChatListComponent$KeepScreenOnReplyTrigger(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
