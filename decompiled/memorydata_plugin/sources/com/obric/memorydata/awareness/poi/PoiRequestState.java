package com.obric.memorydata.awareness.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/poi/PoiRequestState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Requesting", "Success", "Error", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PoiRequestState extends Enum<PoiRequestState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PoiRequestState[] $VALUES = null;
    public static final PoiRequestState Error = null;
    public static final PoiRequestState None = null;
    public static final PoiRequestState Requesting = null;
    public static final PoiRequestState Success = null;

    private static final /* synthetic */ PoiRequestState[] $values() {
        return new PoiRequestState[]{None, Requesting, Success, Error};
    }

    static {
        None = new PoiRequestState("None", 0);
        Requesting = new PoiRequestState("Requesting", 1);
        Success = new PoiRequestState("Success", 2);
        Error = new PoiRequestState("Error", 3);
        PoiRequestState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PoiRequestState(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PoiRequestState> getEntries() {
        return $ENTRIES;
    }

    public static PoiRequestState valueOf(String r2) {
        return (PoiRequestState) ZeusTransformUtils.preCheckCast(Enum.valueOf(PoiRequestState.class, r2), PoiRequestState.class, "com.obric.memorydata.plugin");
    }

    public static PoiRequestState[] values() {
        return (PoiRequestState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PoiRequestState[].class, "com.obric.memorydata.plugin");
    }
}
