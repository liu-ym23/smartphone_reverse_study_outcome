package com.larus.platform.creation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/creation/CreationMultiReferenceLogEvent;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RULE_PARSED", "ATTACHMENT_CHANGED", "RULE_CHECKED", "SWITCH_CHECKED", "UPLINK_BUILT", "FEED_DECODED", "DO_SAME_RESTORED", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CreationMultiReferenceLogEvent extends Enum<CreationMultiReferenceLogEvent> {
    public static final CreationMultiReferenceLogEvent ATTACHMENT_CHANGED = null;
    public static final CreationMultiReferenceLogEvent DO_SAME_RESTORED = null;
    public static final CreationMultiReferenceLogEvent FEED_DECODED = null;
    public static final CreationMultiReferenceLogEvent RULE_CHECKED = null;
    public static final CreationMultiReferenceLogEvent RULE_PARSED = null;
    public static final CreationMultiReferenceLogEvent SWITCH_CHECKED = null;
    public static final CreationMultiReferenceLogEvent UPLINK_BUILT = null;
    public static final /* synthetic */ CreationMultiReferenceLogEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<CreationMultiReferenceLogEvent> getEntries() {
        return b;
    }

    static {
        CreationMultiReferenceLogEvent r0 = new CreationMultiReferenceLogEvent("RULE_PARSED", 0, "rule_parsed");
        RULE_PARSED = r0;
        CreationMultiReferenceLogEvent r1 = new CreationMultiReferenceLogEvent("ATTACHMENT_CHANGED", 1, "attachment_changed");
        ATTACHMENT_CHANGED = r1;
        CreationMultiReferenceLogEvent r2 = new CreationMultiReferenceLogEvent("RULE_CHECKED", 2, "rule_checked");
        RULE_CHECKED = r2;
        CreationMultiReferenceLogEvent r4 = new CreationMultiReferenceLogEvent("SWITCH_CHECKED", 3, "switch_checked");
        SWITCH_CHECKED = r4;
        CreationMultiReferenceLogEvent r6 = new CreationMultiReferenceLogEvent("UPLINK_BUILT", 4, "uplink_built");
        UPLINK_BUILT = r6;
        CreationMultiReferenceLogEvent r8 = new CreationMultiReferenceLogEvent("FEED_DECODED", 5, "feed_decoded");
        FEED_DECODED = r8;
        CreationMultiReferenceLogEvent r10 = new CreationMultiReferenceLogEvent("DO_SAME_RESTORED", 6, "do_same_restored");
        DO_SAME_RESTORED = r10;
        CreationMultiReferenceLogEvent[] r12 = {r0, r1, r2, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static CreationMultiReferenceLogEvent[] values() {
        return (CreationMultiReferenceLogEvent[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationMultiReferenceLogEvent valueOf(String r1) {
        return (CreationMultiReferenceLogEvent) a.a(CreationMultiReferenceLogEvent.class, r1);
    }

    public CreationMultiReferenceLogEvent(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
