package com.obric.memorydata.realtimecontext.session;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/realtimecontext/session/RealTimeContextLink;", "", "<init>", "(Ljava/lang/String;I)V", "CLIENT", "CLOUD", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RealTimeContextLink extends Enum<RealTimeContextLink> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RealTimeContextLink[] $VALUES = null;
    public static final RealTimeContextLink CLIENT = null;
    public static final RealTimeContextLink CLOUD = null;

    private static final /* synthetic */ RealTimeContextLink[] $values() {
        return new RealTimeContextLink[]{CLIENT, CLOUD};
    }

    static {
        CLIENT = new RealTimeContextLink("CLIENT", 0);
        CLOUD = new RealTimeContextLink("CLOUD", 1);
        RealTimeContextLink[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private RealTimeContextLink(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<RealTimeContextLink> getEntries() {
        return $ENTRIES;
    }

    public static RealTimeContextLink valueOf(String r2) {
        return (RealTimeContextLink) ZeusTransformUtils.preCheckCast(Enum.valueOf(RealTimeContextLink.class, r2), RealTimeContextLink.class, "com.obric.memorydata.plugin");
    }

    public static RealTimeContextLink[] values() {
        return (RealTimeContextLink[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RealTimeContextLink[].class, "com.obric.memorydata.plugin");
    }
}
