package com.obric.memorydata.utils;

import com.bytedance.rpc.model.locationConstants;
import com.obric.aiagent.product.platform.api.rom.IRomInfoKt;
import com.obric.memorydata.middleware.api.bridge.CoreBridgeAPI;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/utils/RegionUtil;", "", "<init>", "()V", "TAG", "", "REGION_HK", "getRegion", "Lcom/obric/memorydata/utils/RegionUtil$Region;", "isHK", "", "isCN", "getRomReleaseRegion", locationConstants.LocateMethod_Region, "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RegionUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RegionUtil f13145a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/utils/RegionUtil$Region;", "", "<init>", "(Ljava/lang/String;I)V", "HK", "CN", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Region extends Enum<Region> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Region[] $VALUES = null;
        public static final Region CN = null;
        public static final Region HK = null;

        private static final /* synthetic */ Region[] $values() {
            return new Region[]{HK, CN};
        }

        static {
            HK = new Region("HK", 0);
            CN = new Region("CN", 1);
            Region[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Region(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Region> getEntries() {
            return $ENTRIES;
        }

        public static Region valueOf(String r2) {
            return (Region) ZeusTransformUtils.preCheckCast(Enum.valueOf(Region.class, r2), Region.class, "com.obric.memorydata.plugin");
        }

        public static Region[] values() {
            return (Region[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Region[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f13145a = new RegionUtil();
    }

    private RegionUtil() {
    }

    private final String b() {
        return CoreBridgeAPI.INSTANCE.getRomReleaseRegion();
    L4:
        e = move-exception;
        RunLog.INSTANCE.error("RegionUtil", "getRomReleaseRegion failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    }

    public final Region a() {
        if (StringsKt.equals(b(), IRomInfoKt.REGION_HK, true) == false) goto L6;
        return Region.HK;
    L6:
        return Region.CN;
    }
}
