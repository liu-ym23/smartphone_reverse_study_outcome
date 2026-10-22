package com.obric.memorydata.intelligence.datalearning.profile.algorithm.dbscan;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.model.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001+BQ\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eJ\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0016H\u0002J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J-\u0010%\u001a\u00020\u001c2\u0006\u0010#\u001a\u00028\u00002\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00028\u00000&j\b\u0012\u0004\u0012\u00028\u0000`'H\u0002¢\u0006\u0002\u0010(J%\u0010)\u001a\u0012\u0012\u0004\u0012\u00028\u00000&j\b\u0012\u0004\u0012\u00028\u0000`'2\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\b\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0005`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a0\u0015j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a`\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/algorithm/dbscan/Dbscan;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/model/GpsPoint;", "", "radius", "", "minPoints", "", "measure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "a", "b", "<init>", "(DILkotlin/jvm/functions/Function2;)V", "getMeasure", "()Lkotlin/jvm/functions/Function2;", "geoHash", "Lcom/obric/memorydata/intelligence/datalearning/profile/algorithm/dbscan/GEOHash;", "geoHashCodeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "distanceCacheMap", "visitedMap", "Lcom/obric/memorydata/intelligence/datalearning/profile/algorithm/dbscan/Dbscan$PointStatus;", "initGeoHashMap", "", "data", "", "cluster", "generateDistanceKey", "getNeighbors", "", "point", "(Lcom/obric/memorydata/database/model/GpsPoint;)Ljava/util/Set;", "expandCluster", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "(Lcom/obric/memorydata/database/model/GpsPoint;Ljava/util/HashSet;)V", "generateCluster", "(Lcom/obric/memorydata/database/model/GpsPoint;)Ljava/util/HashSet;", "PointStatus", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Dbscan<T extends d> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/algorithm/dbscan/Dbscan$PointStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOISE", "PENDING", "PART_OF_CLUSTER", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum PointStatus extends Enum<PointStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PointStatus[] $VALUES = null;
        public static final PointStatus NOISE = null;
        public static final PointStatus PART_OF_CLUSTER = null;
        public static final PointStatus PENDING = null;

        private static final /* synthetic */ PointStatus[] $values() {
            return new PointStatus[]{NOISE, PENDING, PART_OF_CLUSTER};
        }

        static {
            NOISE = new PointStatus("NOISE", 0);
            PENDING = new PointStatus("PENDING", 1);
            PART_OF_CLUSTER = new PointStatus("PART_OF_CLUSTER", 2);
            PointStatus[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private PointStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<PointStatus> getEntries() {
            return $ENTRIES;
        }

        public static PointStatus valueOf(String r2) {
            return (PointStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(PointStatus.class, r2), PointStatus.class, "com.obric.memorydata.plugin");
        }

        public static PointStatus[] values() {
            return (PointStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PointStatus[].class, "com.obric.memorydata.plugin");
        }
    }
}
