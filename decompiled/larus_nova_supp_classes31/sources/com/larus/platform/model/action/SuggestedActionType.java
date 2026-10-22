package com.larus.platform.model.action;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Redirection", "MessageWithPromptReplacement", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum SuggestedActionType extends Enum<SuggestedActionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SuggestedActionType[] $VALUES = null;
    public static final SuggestedActionType MessageWithPromptReplacement = null;
    public static final SuggestedActionType Redirection = null;
    public static final SuggestedActionType Unknown = null;
    private final int value;

    private static final /* synthetic */ SuggestedActionType[] $values() {
        return new SuggestedActionType[]{Unknown, Redirection, MessageWithPromptReplacement};
    }

    public static EnumEntries<SuggestedActionType> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new SuggestedActionType("Unknown", 0, 0);
        Redirection = new SuggestedActionType("Redirection", 1, 1);
        MessageWithPromptReplacement = new SuggestedActionType("MessageWithPromptReplacement", 2, 2);
        SuggestedActionType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SuggestedActionType[] values() {
        return (SuggestedActionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SuggestedActionType valueOf(String r1) {
        return (SuggestedActionType) r27.a.a(SuggestedActionType.class, r1);
    }

    private SuggestedActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
