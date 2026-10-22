package com.obric.capabilitykit.entity.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "VERIFICATION_CODE", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum MessageTypeEnum extends Enum<MessageTypeEnum> {
    private static final /* synthetic */ MessageTypeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final MessageTypeEnum VERIFICATION_CODE = null;

    private static final /* synthetic */ MessageTypeEnum[] $values() {
        return new MessageTypeEnum[]{VERIFICATION_CODE};
    }

    static {
        VERIFICATION_CODE = new MessageTypeEnum("VERIFICATION_CODE", 0);
        $VALUES = $values();
        Companion = new a();
    }

    private MessageTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static MessageTypeEnum valueOf(String r1) {
        return (MessageTypeEnum) a.a(MessageTypeEnum.class, r1);
    }

    public static MessageTypeEnum[] values() {
        return (MessageTypeEnum[]) $VALUES.clone();
    }
}
