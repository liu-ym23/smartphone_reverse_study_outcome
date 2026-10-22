package com.larus.chat.job.impl.page.edit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobEditTextKey;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE", "PROMPT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatJobEditTextKey extends Enum<ChatJobEditTextKey> {
    public static final ChatJobEditTextKey PROMPT = null;
    public static final ChatJobEditTextKey TITLE = null;
    public static final /* synthetic */ ChatJobEditTextKey[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatJobEditTextKey> getEntries() {
        return b;
    }

    static {
        ChatJobEditTextKey r0 = new ChatJobEditTextKey("TITLE", 0);
        TITLE = r0;
        ChatJobEditTextKey r1 = new ChatJobEditTextKey("PROMPT", 1);
        PROMPT = r1;
        ChatJobEditTextKey[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ChatJobEditTextKey[] values() {
        return (ChatJobEditTextKey[]) a.clone();
    }

    public static ChatJobEditTextKey valueOf(String r1) {
        return (ChatJobEditTextKey) r27.a.a(ChatJobEditTextKey.class, r1);
    }

    public ChatJobEditTextKey(String r1, int r2) {
        super(r1, r2);
    }
}
