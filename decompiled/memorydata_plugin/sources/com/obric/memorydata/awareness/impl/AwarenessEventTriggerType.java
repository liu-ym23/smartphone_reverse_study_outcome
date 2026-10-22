package com.obric.memorydata.awareness.impl;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rj\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessEventTriggerType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FEATURE_CHANGED", "FEATURE_EVENT", "CONTEXT_EVENT", "isFeatureTrigger", "", "()Z", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AwarenessEventTriggerType extends Enum<AwarenessEventTriggerType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AwarenessEventTriggerType[] $VALUES = null;
    public static final AwarenessEventTriggerType CONTEXT_EVENT = null;
    public static final a Companion = null;
    public static final AwarenessEventTriggerType FEATURE_CHANGED = null;
    public static final AwarenessEventTriggerType FEATURE_EVENT = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessEventTriggerType$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/awareness/impl/AwarenessEventTriggerType;", EventBody.KEY_VALUE, "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AwarenessEventTriggerType a(String r7) {
            AwarenessEventTriggerType[] r6 = AwarenessEventTriggerType.values();
            int r0 = r6.length;
            int r1 = 0;
        L3:
            String r2 = null;
            if (r1 >= r0) goto L15;
            AwarenessEventTriggerType r3 = r6[r1];
            String r4 = r3.getValue();
            if (r7 == null) goto L9;
            r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        L9:
            if (Intrinsics.areEqual(r4, r2) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r3;
        L15:
            return null;
        }
    }

    private static final /* synthetic */ AwarenessEventTriggerType[] $values() {
        return new AwarenessEventTriggerType[]{FEATURE_CHANGED, FEATURE_EVENT, CONTEXT_EVENT};
    }

    static {
        FEATURE_CHANGED = new AwarenessEventTriggerType("FEATURE_CHANGED", 0, "feature_changed");
        FEATURE_EVENT = new AwarenessEventTriggerType("FEATURE_EVENT", 1, "feature_event");
        CONTEXT_EVENT = new AwarenessEventTriggerType("CONTEXT_EVENT", 2, "context_event");
        AwarenessEventTriggerType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private AwarenessEventTriggerType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<AwarenessEventTriggerType> getEntries() {
        return $ENTRIES;
    }

    public static AwarenessEventTriggerType valueOf(String r2) {
        return (AwarenessEventTriggerType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AwarenessEventTriggerType.class, r2), AwarenessEventTriggerType.class, "com.obric.memorydata.plugin");
    }

    public static AwarenessEventTriggerType[] values() {
        return (AwarenessEventTriggerType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AwarenessEventTriggerType[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean isFeatureTrigger() {
        if (this != FEATURE_CHANGED) goto L5;
    L8:
        return true;
    L5:
        if (this == FEATURE_EVENT) goto L8;
        return false;
    }
}
