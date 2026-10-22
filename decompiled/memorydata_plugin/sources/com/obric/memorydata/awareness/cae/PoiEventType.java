package com.obric.memorydata.awareness.cae;

import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/awareness/cae/PoiEventType;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "ARRIVE", "LEAVE", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PoiEventType extends Enum<PoiEventType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PoiEventType[] $VALUES = null;
    public static final PoiEventType ARRIVE = null;
    public static final a Companion = null;
    public static final PoiEventType LEAVE = null;
    private final String eventName;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/awareness/cae/PoiEventType$Companion;", "", "<init>", "()V", "fromIsEnter", "Lcom/obric/memorydata/awareness/cae/PoiEventType;", "isEnter", "", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/awareness/cae/PoiEventType;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final PoiEventType a(Boolean r1) {
            if (Intrinsics.areEqual(r1, false) == false) goto L6;
            return PoiEventType.LEAVE;
        L6:
            return PoiEventType.ARRIVE;
        }
    }

    private static final /* synthetic */ PoiEventType[] $values() {
        return new PoiEventType[]{ARRIVE, LEAVE};
    }

    static {
        ARRIVE = new PoiEventType("ARRIVE", 0, EventNames.ARRIVE_POI);
        LEAVE = new PoiEventType("LEAVE", 1, EventNames.LEAVE_POI);
        PoiEventType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private PoiEventType(String r1, int r2, String r3) {
        super(r1, r2);
        this.eventName = r3;
    }

    public static EnumEntries<PoiEventType> getEntries() {
        return $ENTRIES;
    }

    public static PoiEventType valueOf(String r2) {
        return (PoiEventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PoiEventType.class, r2), PoiEventType.class, "com.obric.memorydata.plugin");
    }

    public static PoiEventType[] values() {
        return (PoiEventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PoiEventType[].class, "com.obric.memorydata.plugin");
    }

    public final String getEventName() {
        return this.eventName;
    }
}
