package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "REPLY_NORMAL", "REPLY_PARTIAL", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyType extends Enum<ReplyType> {
    public static final a Companion = null;
    public static final ReplyType REPLY_NORMAL = null;
    public static final ReplyType REPLY_PARTIAL = null;
    public static final /* synthetic */ ReplyType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ReplyType> getEntries() {
        return b;
    }

    static {
        ReplyType r0 = new ReplyType("REPLY_NORMAL", 0, 0);
        REPLY_NORMAL = r0;
        ReplyType r1 = new ReplyType("REPLY_PARTIAL", 1, 1);
        REPLY_PARTIAL = r1;
        ReplyType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static ReplyType[] values() {
        return (ReplyType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ReplyType valueOf(String r1) {
        return (ReplyType) r27.a.a(ReplyType.class, r1);
    }

    public ReplyType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
