package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageSourceDisplayPolicy;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY", "MENU", "INLINE", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageSourceDisplayPolicy extends Enum<MessageSourceDisplayPolicy> {
    public static final MessageSourceDisplayPolicy INLINE = null;
    public static final MessageSourceDisplayPolicy MENU = null;
    public static final MessageSourceDisplayPolicy UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = null;
    public static final /* synthetic */ MessageSourceDisplayPolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MessageSourceDisplayPolicy> getEntries() {
        return b;
    }

    static {
        MessageSourceDisplayPolicy r0 = new MessageSourceDisplayPolicy("UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY", 0);
        UNKNOWN_AGENT_SEND_MESSAGE_SOURCE_DISPLAY_POLICY = r0;
        MessageSourceDisplayPolicy r1 = new MessageSourceDisplayPolicy("MENU", 1);
        MENU = r1;
        MessageSourceDisplayPolicy r3 = new MessageSourceDisplayPolicy("INLINE", 2);
        INLINE = r3;
        MessageSourceDisplayPolicy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MessageSourceDisplayPolicy[] values() {
        return (MessageSourceDisplayPolicy[]) a.clone();
    }

    public static MessageSourceDisplayPolicy valueOf(String r1) {
        return (MessageSourceDisplayPolicy) r27.a.a(MessageSourceDisplayPolicy.class, r1);
    }

    public MessageSourceDisplayPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
