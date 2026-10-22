package com.obric.memorydata.memory.ui.list;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003JD\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0006HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u001c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u001e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010R\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\u0010¨\u00064"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "Landroid/os/Parcelable;", "sourcePackageName", "", "sourceAppName", "sourceProductType", "", CommonConsts.COUNT_TYPE, "isAll", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getSourcePackageName", "()Ljava/lang/String;", "getSourceAppName", "getSourceProductType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCount", "()I", "()Z", "stableKey", "getStableKey", "displayName", "getDisplayName", "showCount", "getShowCount", "displayTitle", "getDisplayTitle", "displayCount", "getDisplayCount", "writeToParcel", "", "dest", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZ)Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "equals", "other", "", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemorySourceFilter implements Parcelable {
    public static final Parcelable.Creator<MemorySourceFilter> CREATOR = null;
    public static final a Companion = null;
    public static final String KEY_ALL = "__all__";
    private static final int MAX_DISPLAY_COUNT = 9999;
    private final int count;
    private final boolean isAll;
    private final String sourceAppName;
    private final String sourcePackageName;
    private final Integer sourceProductType;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\u0006\u0010\u001d\u001a\u00020\u001aJ(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter$Companion;", "", "<init>", "()V", "KEY_ALL", "", "MAX_DISPLAY_COUNT", "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, CommonConsts.COUNT_TYPE, "fromStat", "stat", "Lcom/obric/memorydata/database/entity/CollectMemorySourceStat;", "formatCount", "displaySourceAppName", "productType", "sourceAppName", "normalizeProductType", "orderStats", "", "stats", "visibleStats", "keepGlasses", "", "prepareInitialFilters", "filters", "targetWearable", "retainSourceOrder", "current", "latest", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySourceFilter$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class C0575a<T> implements Comparator {
            public C0575a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.memorydata.database.entity.al) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.entity.al.class, "com.obric.memorydata.plugin")).d()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.memorydata.database.entity.al) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.entity.al.class, "com.obric.memorydata.plugin")).d()), Comparable.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class b<T> implements Comparator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Comparator f11070a;

            public b(Comparator r3) {
                this.f11070a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                int r1 = this.f11070a.compare(r2, r3);
                if (r1 == 0) goto L6;
                return r1;
            L6:
                return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((com.obric.memorydata.database.entity.al) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.entity.al.class, "com.obric.memorydata.plugin")).b(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((com.obric.memorydata.database.entity.al) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.entity.al.class, "com.obric.memorydata.plugin")).b(), Comparable.class, "com.obric.memorydata.plugin"));
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ MemorySourceFilter a(a r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            return r0.a(r1);
        }

        public final MemorySourceFilter a(int r7) {
            return new MemorySourceFilter(null, com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_source_all, TypedValues.Custom.S_STRING, "memory_source_all")), null, r7, true);
        }

        public final MemorySourceFilter a(com.obric.memorydata.database.entity.al r8) {
            Intrinsics.checkNotNullParameter(r8, "stat");
            String r2 = r8.a();
            if (c(r8.c()) != 0) goto L5;
            String r7 = com.obric.memorydata.utils.c.f13193a.a(r8.a(), r8.b());
        L7:
            return new MemorySourceFilter(r2, r7, Integer.valueOf(r8.c()), r8.d(), false);
        L5:
            r7 = r8.b();
            goto L7
        }

        public final String a(int r1, String r2) {
            if (r1 == 20) goto L5;
            return r2;
        L5:
            return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_source_wearable, TypedValues.Custom.S_STRING, "memory_source_wearable"));
        }

        public final List<com.obric.memorydata.database.entity.al> a(List<com.obric.memorydata.database.entity.al> r3) {
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "stats");
            return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b((Comparator) ZeusTransformUtils.preCheckCast(new C0575a(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"));
        }

        public final List<MemorySourceFilter> a(List<MemorySourceFilter> r6, List<MemorySourceFilter> r7) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "current");
            Intrinsics.checkNotNullParameter(r8, "latest");
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
            Iterator r10 = r9.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            Object r2 = r10.next();
            r1.put(((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r2, MemorySourceFilter.class, "com.obric.memorydata.plugin")).getStableKey(), r2);
            goto L4
        L6:
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
            Iterator r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r3.add(((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r12.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin")).getStableKey());
            goto L8
        L10:
            Set r13 = (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin");
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r15 = r14.iterator();
        L12:
            if (r15.hasNext() == false) goto L16;
            MemorySourceFilter r16 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r1.get(((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r15.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin")).getStableKey()), MemorySourceFilter.class, "com.obric.memorydata.plugin");
            if (r16 == null) goto L12;
            r4.add(r16);
            goto L12
        L16:
            Collection r17 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
            Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r20 = r18.iterator();
        L18:
            if (r20.hasNext() == false) goto L23;
            Object r21 = r20.next();
            if (r13.contains(((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r21, MemorySourceFilter.class, "com.obric.memorydata.plugin")).getStableKey()) == true) goto L18;
            r19.add(r21);
            goto L18
        L23:
            return CollectionsKt.plus(r17, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        }

        public final List<com.obric.memorydata.database.entity.al> a(List<com.obric.memorydata.database.entity.al> r7, boolean r8) {
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "stats");
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r10.iterator();
        L3:
            boolean r3 = true;
            if (r11.hasNext() == false) goto L11;
            Object r2 = r11.next();
            if (((com.obric.memorydata.database.entity.al) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.entity.al.class, "com.obric.memorydata.plugin")).d() > 0) goto L9;
            r3 = false;
        L9:
            if (r3 == false) goto L3;
            r0.add(r2);
            goto L3
        L11:
            List<com.obric.memorydata.database.entity.al> r12 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
            if (r8 == false) goto L30;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L16;
        L18:
            Iterator r14 = r13.iterator();
        L20:
            if (r14.hasNext() == false) goto L27;
            if (((com.obric.memorydata.database.entity.al) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.memorydata.database.entity.al.class, "com.obric.memorydata.plugin")).c() != 20) goto L24;
            boolean r1 = true;
        L25:
            if (r1 == false) goto L20;
            r3 = false;
            goto L27
        L24:
            r1 = false;
        L27:
            if (r3 == false) goto L30;
            r12.add(new com.obric.memorydata.database.entity.al("com.larus.nova", "", 20, 0));
            goto L30
        L16:
            if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L18;
        L30:
            return a(r12);
        }

        public final String b(int r1) {
            if (r1 < 10000) goto L6;
            return "9999+";
        L6:
            return String.valueOf(r1);
        }

        public final List<MemorySourceFilter> b(List<MemorySourceFilter> r13, boolean r14) {
            List<MemorySourceFilter> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "filters");
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
            boolean r2 = true;
            if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L5;
        L7:
            Iterator r16 = r15.iterator();
        L9:
            if (r16.hasNext() == false) goto L6;
            Integer r1 = ((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r16.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin")).getSourceProductType();
            if (r1 != null) goto L14;
        L16:
            boolean r3 = false;
        L17:
            if (r3 == false) goto L9;
        L18:
            if (r14 == false) goto L28;
            if (r2 == false) goto L22;
            return r12;
        L22:
            return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"), new MemorySourceFilter("com.larus.nova", "", 20, 0, false, 16, null));
        L28:
            return r12;
        L14:
            if (r1.intValue() != 20) goto L16;
            r3 = true;
        L6:
            r2 = false;
            goto L18
        L5:
            if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
            goto L6
        }

        public final int c(int r1) {
            if (r1 != 20) goto L5;
            return r1;
        L5:
            if (r1 == 21) goto L9;
            return 0;
        L9:
            return r1;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/memorydata/memory/ui/list/MemorySourceFilter$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<MemorySourceFilter> {
        b() {
        }

        public MemorySourceFilter a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new MemorySourceFilter(r1);
        }

        public MemorySourceFilter[] a(int r1) {
            return new MemorySourceFilter[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ MemorySourceFilter createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ MemorySourceFilter[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new b(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public MemorySourceFilter(Parcel r8) {
        Intrinsics.checkNotNullParameter(r8, "parcel");
        String r2 = r8.readString();
        String r0 = r8.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r3 = r0;
        Object r1 = r8.readValue(Integer.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L8;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.memorydata.plugin");
    L9:
        Integer r5 = r4;
        int r6 = r8.readInt();
        if (r8.readByte() == 0) goto L12;
        boolean r9 = true;
    L13:
        this(r2, r3, r5, r6, r9);
        return;
    L12:
        r9 = false;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public MemorySourceFilter(String r2, String r3, Integer r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "sourceAppName");
        this.sourcePackageName = r2;
        this.sourceAppName = r3;
        this.sourceProductType = r4;
        this.count = r5;
        this.isAll = r6;
    }

    public /* synthetic */ MemorySourceFilter(String r7, String r8, Integer r9, int r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = false;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ MemorySourceFilter copy$default(MemorySourceFilter r3, String r4, String r5, Integer r6, int r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.sourcePackageName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.sourceAppName;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.sourceProductType;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.count;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isAll;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.sourcePackageName;
    }

    public final String component2() {
        return this.sourceAppName;
    }

    public final Integer component3() {
        return this.sourceProductType;
    }

    public final int component4() {
        return this.count;
    }

    public final boolean component5() {
        return this.isAll;
    }

    public final MemorySourceFilter copy(String r7, String r8, Integer r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "sourceAppName");
        return new MemorySourceFilter(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MemorySourceFilter.class) == true) goto L8;
        return false;
    L8:
        MemorySourceFilter r6 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r5, MemorySourceFilter.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.sourcePackageName, r6.sourcePackageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceAppName, r6.sourceAppName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceProductType, r6.sourceProductType) == true) goto L18;
        return false;
    L18:
        if (this.count == r6.count) goto L21;
        return false;
    L21:
        if (this.isAll == r6.isAll) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getDisplayCount() {
        return Companion.b(this.count);
    }

    public final String getDisplayName() {
        Integer r0 = this.sourceProductType;
        if (r0 == null) goto L9;
        if (r0.intValue() != 20) goto L9;
        return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_source_wearable, TypedValues.Custom.S_STRING, "memory_source_wearable"));
    L9:
        return this.sourceAppName;
    }

    public final String getDisplayTitle() {
        if (getShowCount() == false) goto L6;
        return getDisplayName() + ' ' + getDisplayCount();
    L6:
        return getDisplayName();
    }

    public final boolean getShowCount() {
        if (this.isAll == true) goto L12;
        Integer r0 = this.sourceProductType;
        if (r0 != null) goto L8;
    L11:
        return true;
    L8:
        if (r0.intValue() != 20) goto L11;
        if (this.count != 0) goto L11;
    L12:
        return false;
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final Integer getSourceProductType() {
        return this.sourceProductType;
    }

    public final String getStableKey() {
        String r0 = this.sourcePackageName;
        if (r0 == null) goto L10;
        StringBuilder r1 = new StringBuilder().append(r0).append(':');
        Integer r2 = this.sourceProductType;
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        String r4 = r1.append(r3).toString();
        if (r4 == null) goto L10;
        return r4;
    L7:
        r3 = 0;
    L10:
        return KEY_ALL;
    }

    public int hashCode() {
        String r0 = this.sourcePackageName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.sourceAppName.hashCode()) * 31;
        Integer r4 = this.sourceProductType;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + Integer.hashCode(this.count)) * 31) + Boolean.hashCode(this.isAll);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final boolean isAll() {
        return this.isAll;
    }

    public String toString() {
        return "MemorySourceFilter(sourcePackageName=" + this.sourcePackageName + ", sourceAppName=" + this.sourceAppName + ", sourceProductType=" + this.sourceProductType + ", count=" + this.count + ", isAll=" + this.isAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.sourcePackageName);
        r1.writeString(this.sourceAppName);
        r1.writeValue(this.sourceProductType);
        r1.writeInt(this.count);
        r1.writeByte(this.isAll ? 1 : 0);
    }
}
