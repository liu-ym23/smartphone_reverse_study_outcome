package com.larus.platform.model.chat;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/chat/MessageModifyStyle;", "", "styleValue", "", "<init>", "(Ljava/lang/String;II)V", "getStyleValue", "()I", "SMALL_BOX", "FULL_BOX", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum MessageModifyStyle extends Enum<MessageModifyStyle> {
    public static final a Companion = null;
    public static final MessageModifyStyle FULL_BOX = null;
    public static final MessageModifyStyle SMALL_BOX = null;
    public static final /* synthetic */ MessageModifyStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int styleValue;

    public static EnumEntries<MessageModifyStyle> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.platform.model.chat.MessageModifyStyle$a] */
    static {
        MessageModifyStyle r0 = new MessageModifyStyle("SMALL_BOX", 0, 0);
        SMALL_BOX = r0;
        MessageModifyStyle r1 = new MessageModifyStyle("FULL_BOX", 1, 1);
        FULL_BOX = r1;
        MessageModifyStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static MessageModifyStyle[] values() {
        return (MessageModifyStyle[]) a.clone();
    }

    public final int getStyleValue() {
        return this.styleValue;
    }

    public static MessageModifyStyle valueOf(String r1) {
        return (MessageModifyStyle) r27.a.a(MessageModifyStyle.class, r1);
    }

    public MessageModifyStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.styleValue = r3;
    }
}
