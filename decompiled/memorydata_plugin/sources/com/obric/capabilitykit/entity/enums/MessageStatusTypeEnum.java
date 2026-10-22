package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "", "(Ljava/lang/String;I)V", "INBOX", "OUTBOX", "DRAFT", "SENDING", "SEND_FAILED", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum MessageStatusTypeEnum extends Enum<MessageStatusTypeEnum> {
    private static final /* synthetic */ MessageStatusTypeEnum[] $VALUES = null;
    public static final Companion Companion = null;
    public static final MessageStatusTypeEnum DRAFT = null;
    public static final MessageStatusTypeEnum INBOX = null;
    public static final MessageStatusTypeEnum OUTBOX = null;
    public static final MessageStatusTypeEnum SENDING = null;
    public static final MessageStatusTypeEnum SEND_FAILED = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum$Companion;", "", "()V", "from", "Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", ActivityLifecycle.NAME, "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final MessageStatusTypeEnum from(String r3) {
            MessageStatusTypeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = MessageStatusTypeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            Log.w("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + Reflection.getOrCreateKotlinClass(MessageStatusTypeEnum.class).getSimpleName() + ' ');
        L9:
            return (MessageStatusTypeEnum) ZeusTransformUtils.preCheckCast(r2, MessageStatusTypeEnum.class, "com.obric.memorydata.plugin");
        }
    }

    private static final /* synthetic */ MessageStatusTypeEnum[] $values() {
        return new MessageStatusTypeEnum[]{INBOX, OUTBOX, DRAFT, SENDING, SEND_FAILED};
    }

    static {
        INBOX = new MessageStatusTypeEnum("INBOX", 0);
        OUTBOX = new MessageStatusTypeEnum("OUTBOX", 1);
        DRAFT = new MessageStatusTypeEnum("DRAFT", 2);
        SENDING = new MessageStatusTypeEnum("SENDING", 3);
        SEND_FAILED = new MessageStatusTypeEnum("SEND_FAILED", 4);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private MessageStatusTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static MessageStatusTypeEnum valueOf(String r2) {
        return (MessageStatusTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(MessageStatusTypeEnum.class, r2), MessageStatusTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static MessageStatusTypeEnum[] values() {
        return (MessageStatusTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageStatusTypeEnum[].class, "com.obric.memorydata.plugin");
    }
}
