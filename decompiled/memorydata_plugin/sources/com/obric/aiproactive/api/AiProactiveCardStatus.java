package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "DISMISSED", "ACKNOWLEDGED", "EXECUTED", "Companion", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AiProactiveCardStatus extends Enum<AiProactiveCardStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AiProactiveCardStatus[] $VALUES = null;
    public static final AiProactiveCardStatus ACKNOWLEDGED = null;
    public static final a Companion = null;
    public static final AiProactiveCardStatus DISMISSED = null;
    public static final AiProactiveCardStatus EXECUTED = null;
    public static final AiProactiveCardStatus PENDING = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveCardStatus$Companion;", "", "<init>", "()V", "fromRaw", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "raw", "", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AiProactiveCardStatus a(String r4) {
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(AiProactiveCardStatus.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r0 = r3.next();
            if (Intrinsics.areEqual(((AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(r0, AiProactiveCardStatus.class, "com.obric.memorydata.plugin")).name(), r4) == false) goto L4;
        L9:
            AiProactiveCardStatus r5 = (AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(r0, AiProactiveCardStatus.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L12;
            return r5;
        L12:
            return AiProactiveCardStatus.PENDING;
        L8:
            r0 = null;
            goto L9
        }
    }

    private static final /* synthetic */ AiProactiveCardStatus[] $values() {
        return new AiProactiveCardStatus[]{PENDING, DISMISSED, ACKNOWLEDGED, EXECUTED};
    }

    static {
        PENDING = new AiProactiveCardStatus("PENDING", 0);
        DISMISSED = new AiProactiveCardStatus("DISMISSED", 1);
        ACKNOWLEDGED = new AiProactiveCardStatus("ACKNOWLEDGED", 2);
        EXECUTED = new AiProactiveCardStatus("EXECUTED", 3);
        AiProactiveCardStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private AiProactiveCardStatus(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AiProactiveCardStatus> getEntries() {
        return $ENTRIES;
    }

    public static AiProactiveCardStatus valueOf(String r2) {
        return (AiProactiveCardStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(AiProactiveCardStatus.class, r2), AiProactiveCardStatus.class, "com.obric.memorydata.plugin");
    }

    public static AiProactiveCardStatus[] values() {
        return (AiProactiveCardStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AiProactiveCardStatus[].class, "com.obric.memorydata.plugin");
    }
}
