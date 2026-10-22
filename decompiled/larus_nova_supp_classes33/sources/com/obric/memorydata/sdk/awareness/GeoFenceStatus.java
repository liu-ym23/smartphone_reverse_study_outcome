package com.obric.memorydata.sdk.awareness;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/GeoFenceStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "INSIDE", "OUTSIDE", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum GeoFenceStatus extends Enum<GeoFenceStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ GeoFenceStatus[] $VALUES = null;
    public static final a Companion = null;
    public static final GeoFenceStatus INSIDE = null;
    public static final GeoFenceStatus OUTSIDE = null;
    public static final GeoFenceStatus UNKNOWN = null;
    private final int value;

    private static final /* synthetic */ GeoFenceStatus[] $values() {
        return new GeoFenceStatus[]{UNKNOWN, INSIDE, OUTSIDE};
    }

    public static EnumEntries<GeoFenceStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.memorydata.sdk.awareness.GeoFenceStatus$a] */
    static {
        UNKNOWN = new GeoFenceStatus("UNKNOWN", 0, -1);
        INSIDE = new GeoFenceStatus("INSIDE", 1, 1);
        OUTSIDE = new GeoFenceStatus("OUTSIDE", 2, 0);
        GeoFenceStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new a();
    }

    public static GeoFenceStatus[] values() {
        return (GeoFenceStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GeoFenceStatus valueOf(String r1) {
        return (GeoFenceStatus) r27.a.a(GeoFenceStatus.class, r1);
    }

    private GeoFenceStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
