package com.obric.memorydata.middleware.api.env;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/middleware/api/env/NetEnv;", "", "<init>", "(Ljava/lang/String;I)V", "ONLINE", "PPE", "BOE", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum NetEnv extends Enum<NetEnv> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NetEnv[] $VALUES = null;
    public static final NetEnv BOE = null;
    public static final NetEnv ONLINE = null;
    public static final NetEnv PPE = null;

    private static final /* synthetic */ NetEnv[] $values() {
        return new NetEnv[]{ONLINE, PPE, BOE};
    }

    static {
        ONLINE = new NetEnv("ONLINE", 0);
        PPE = new NetEnv("PPE", 1);
        BOE = new NetEnv("BOE", 2);
        NetEnv[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private NetEnv(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<NetEnv> getEntries() {
        return $ENTRIES;
    }

    public static NetEnv valueOf(String r2) {
        return (NetEnv) ZeusTransformUtils.preCheckCast(Enum.valueOf(NetEnv.class, r2), NetEnv.class, "com.obric.memorydata.plugin");
    }

    public static NetEnv[] values() {
        return (NetEnv[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NetEnv[].class, "com.obric.memorydata.plugin");
    }
}
