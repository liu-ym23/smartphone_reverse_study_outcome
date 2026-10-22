package com.obric.capabilitykit.sync;

import android.net.Uri;
import android.os.Bundle;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.p;
import com.obric.capabilitykit.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bH\u0002¢\u0006\u0002\u0010\u001cJp\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\"\b\u0002\u0010%\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e\u0018\u00010&2\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0006\u0012\u0004\u0018\u00010*0(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/sync/EntitySyncUtil;", "", "()V", "MAX_SIZE_ONE_GROUP", "", "METHOD_SYNC_DATA_CHECK_COUNT_DIFF", "", "METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF", "PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA", "PARAMS_SYNC_COUNT_TIME_SLOT_DATA", "PARAMS_SYNC_DATA_ENTITY_TYPE", "PARAMS_SYNC_DATA_LAZY_DELETE", "RESULT_DATA_CHECK_DIFF", "RESULT_DATA_LAZY_DELETE", "buildTimeSlotEntityTree", "tree", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "Lkotlin/collections/ArrayList;", "leftIndex", "rightIndex", "startTime", "", "endTime", "sumArray", "", "timeArray", "", "(Ljava/util/ArrayList;IIJJ[I[Ljava/lang/Long;)I", "syncData", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "indexedEntityTypes", "", "deleteCall", "Lkotlin/Function2;", "innerCall", "Lkotlin/Function3;", "Landroid/net/Uri;", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntitySyncUtil {
    public static final EntitySyncUtil INSTANCE = null;
    private static final int MAX_SIZE_ONE_GROUP = 50;
    private static final String METHOD_SYNC_DATA_CHECK_COUNT_DIFF = "syncDataCheckCountDiff";
    private static final String METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF = "syncDataCheckHashCodeDiff";
    private static final String PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA = "syncHashCodeSlotDataList";
    private static final String PARAMS_SYNC_COUNT_TIME_SLOT_DATA = "syncCountTimeSlotDataList";
    private static final String PARAMS_SYNC_DATA_ENTITY_TYPE = "syncDataEntityType";
    private static final String PARAMS_SYNC_DATA_LAZY_DELETE = "syncDataLazyDelete";
    private static final String RESULT_DATA_CHECK_DIFF = "checkDiffResult";
    private static final String RESULT_DATA_LAZY_DELETE = "dataLazyDelete";

    static {
        INSTANCE = new EntitySyncUtil();
    }

    private EntitySyncUtil() {
    }

    private final int buildTimeSlotEntityTree(ArrayList<EntityCountTimeSlotData> r16, int r17, int r18, long r19, long r21, int[] r23, Long[] r24) {
        if (r17 <= r18) goto L6;
        return -1;
    L6:
        int r0 = r23[r18];
        if (r17 >= 1) goto L9;
        int r1 = 0;
    L10:
        int r9 = r0 - r1;
        int r11 = r16.size();
        EntityCountTimeSlotData r12 = new EntityCountTimeSlotData(r19, r21, r9, r17, r18);
        r16.add(r12);
        if (r9 <= 50) goto L14;
        if (r17 >= r18) goto L14;
        int r14 = (r17 + r18) / 2;
        r12.setLeftIndex(buildTimeSlotEntityTree(r16, r17, r14, r19, r24[r14].longValue(), r23, r24));
        r12.setRightIndex(buildTimeSlotEntityTree(r16, r14 + 1, r18, r24[r14].longValue() + 1, r21, r23, r24));
    L14:
        return r11;
    L9:
        r1 = r23[r17 - 1];
        goto L10
    }

    public static /* synthetic */ void syncData$default(EntitySyncUtil r2, EntitySyncDataSupplier r3, EntitySupplier r4, List r5, Function2 r6, Function3 r7, int r8, Object r9) {
        EntitySyncDataSupplier r10 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r3, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
        EntitySupplier r11 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r4, EntitySupplier.class, "com.obric.memorydata.plugin");
        List<Integer> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Function2<? super List<String>, ? super Integer, Unit> r12 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Function3<? super Uri, ? super String, ? super Bundle, Bundle> r0 = (Function3) ZeusTransformUtils.wrapperContextForParams(r7, Function3.class, "com.obric.memorydata.plugin");
        if ((r8 & 8) == 0) goto L5;
        r12 = null;
    L5:
        r2.syncData(r10, r11, r1, r12, r0);
    }

    public final void syncData(EntitySyncDataSupplier r28, EntitySupplier r29, List<Integer> r30, Function2<? super List<String>, ? super Integer, Unit> r31, Function3<? super Uri, ? super String, ? super Bundle, Bundle> r32) {
        EntitySyncDataSupplier r0 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r28, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
        EntitySupplier r2 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r29, EntitySupplier.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r31, Function2.class, "com.obric.memorydata.plugin");
        Function3 r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r32, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "indexedEntityTypes");
        Intrinsics.checkNotNullParameter(r5, "innerCall");
        p.f7600a.b();
        if (r0 != null) goto L5;
        r0 = new y(r2);
    L5:
        List<EntityIdData> r6 = r0.provideSampleEntities();
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<T> r8 = r6.iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        Object r9 = r8.next();
        Integer r10 = Integer.valueOf(((EntityIdData) ZeusTransformUtils.preCheckCast(r9, EntityIdData.class, "com.obric.memorydata.plugin")).getType());
        Object r11 = r7.get(r10);
        if (r11 != null) goto L11;
        r11 = new ArrayList();
        r7.put(r10, r11);
    L11:
        ((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin")).add(r9);
        goto L7
    L12:
        Map r12 = MapsKt.toMutableMap(r7);
        Iterator r13 = r3.iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r12.containsKey(Integer.valueOf(r14)) == true) goto L14;
        r12.put(Integer.valueOf(r14), CollectionsKt.emptyList());
        goto L14
    L18:
        Iterator r15 = r12.entrySet().iterator();
    L20:
        if (r15.hasNext() == false) goto L111;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r17 = ((Number) ZeusTransformUtils.preCheckCast(r16.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        List r18 = (List) ZeusTransformUtils.preCheckCast(r16.getValue(), List.class, "com.obric.memorydata.plugin");
        Logger.INSTANCE.d(EntityProvider.TAG, "start sync entity for type " + r17 + " , total " + r18.size());
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = r18.iterator();
    L23:
        if (r20.hasNext() == false) goto L28;
        Object r110 = r20.next();
        Long r111 = Long.valueOf(((EntityIdData) ZeusTransformUtils.preCheckCast(r110, EntityIdData.class, "com.obric.memorydata.plugin")).getLastModifyTime());
        Object r112 = r19.get(r111);
        if (r112 != null) goto L27;
        r112 = new ArrayList();
        r19.put(r111, r112);
    L27:
        ((List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.memorydata.plugin")).add(r110);
        goto L23
    L28:
        Object[] r21 = CollectionsKt.sorted(r19.keySet()).toArray(new Long[0]);
        Objects.requireNonNull(r21, "null cannot be cast to non-null type kotlin.Array<T>");
        Long[] r22 = (Long[]) ZeusTransformUtils.preCheckCast(r21, Long[].class, "com.obric.memorydata.plugin");
        int[] r113 = new int[r22.length];
        int r114 = r22.length;
        int r115 = 0;
    L29:
        if (r115 >= r114) goto L38;
        List r116 = (List) ZeusTransformUtils.preCheckCast(r19.get(r22[r115]), List.class, "com.obric.memorydata.plugin");
        if (r116 == null) goto L33;
        int r117 = r116.size();
    L34:
        if (r115 == 0) goto L37;
        r117 = r117 + r113[r115 - 1];
    L37:
        r113[r115] = r117;
        r115 = r115 + 1;
        goto L29
    L33:
        r117 = 0;
        goto L34
    L38:
        ArrayList<EntityCountTimeSlotData> r118 = new ArrayList();
        INSTANCE.buildTimeSlotEntityTree(r118, 0, r22.length - 1, Long.MIN_VALUE, Long.MAX_VALUE, r113, r22);
        if (r118.size() != 0) goto L41;
        r118.add(new EntityCountTimeSlotData(Long.MIN_VALUE, Long.MAX_VALUE, 0, -1, -1));
    L41:
        Logger.INSTANCE.d(EntityProvider.TAG, "syncdata buildTimeSlotEntityTree: " + r118.size());
        Uri r23 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        Intrinsics.checkNotNullExpressionValue(r23, "ENTITY_URI");
        Bundle r119 = new Bundle();
        r119.putParcelableArrayList(PARAMS_SYNC_COUNT_TIME_SLOT_DATA, r118);
        r119.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r17);
        Bundle r24 = (Bundle) ZeusTransformUtils.preCheckCast(r5.invoke(r23, METHOD_SYNC_DATA_CHECK_COUNT_DIFF, r119), Bundle.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L20;
        r24.setClassLoader(EntityCountTimeSlotData.class.getClassLoader());
        ArrayList r25 = r24.getParcelableArrayList(RESULT_DATA_CHECK_DIFF);
        if (r25 == null) goto L46;
        ArrayList r120 = new ArrayList();
        LinkedHashSet r121 = new LinkedHashSet();
        LinkedHashMap r122 = new LinkedHashMap();
        Iterator r26 = r25.iterator();
    L49:
        if (r26.hasNext() == false) goto L89;
        r15 = r15;
        r26 = r26;
        EntityCountTimeSlotData r27 = (EntityCountTimeSlotData) ZeusTransformUtils.preCheckCast(r26.next(), EntityCountTimeSlotData.class, "com.obric.memorydata.plugin");
        ArrayList r33 = new ArrayList();
        if (r27.getLeftTimeArrayIndex() < 0) goto L76;
        r4 = r4;
        List r34 = r18;
        if (r27.getLeftTimeArrayIndex() >= r22.length) goto L77;
        if (r27.getRightTimeArrayIndex() < 0) goto L77;
        if (r27.getRightTimeArrayIndex() >= r22.length) goto L77;
        int r35 = r27.getLeftTimeArrayIndex();
        int r36 = r27.getRightTimeArrayIndex();
        if (r35 > r36) goto L77;
    L61:
        r19 = r19;
        List r37 = (List) ZeusTransformUtils.preCheckCast(r19.get(r22[r35]), List.class, "com.obric.memorydata.plugin");
        if (r37 != null) goto L64;
        r0 = r0;
    L73:
        if (r35 == r36) goto L78;
        r35 = r35 + 1;
        r19 = r19;
        r22 = r22;
        r120 = r120;
        r0 = r0;
    L78:
        Uri r1 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        Intrinsics.checkNotNullExpressionValue(r1, "ENTITY_URI");
        Bundle r38 = new Bundle();
        r38.putParcelable(PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA, new EntityCheckHashCodeSlotData(r27.getStartTime(), r27.getEndTimeLong(), r33));
        r38.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r17);
        r38.putBoolean(PARAMS_SYNC_DATA_LAZY_DELETE, true);
        Bundle r39 = (Bundle) ZeusTransformUtils.preCheckCast(r5.invoke(r1, METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF, r38), Bundle.class, "com.obric.memorydata.plugin");
        if (r39 == null) goto L80;
        ArrayList<String> r40 = r39.getStringArrayList(RESULT_DATA_CHECK_DIFF);
        ArrayList<String> r41 = r39.getStringArrayList(RESULT_DATA_LAZY_DELETE);
        r120 = r120;
        if (r40 == null) goto L85;
        r120.addAll(r40);
    L85:
        if (r41 == null) goto L87;
        LinkedHashSet r42 = r121;
        r42.addAll(r41);
        r121 = r42;
    L88:
        r18 = r34;
        goto L49
    L87:
        r121 = r121;
        goto L88
    L80:
        r15 = r15;
        r4 = r4;
    L81:
        r0 = r0;
        goto L20
    L64:
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r37, 10));
        Iterator r43 = r37.iterator();
    L66:
        if (r43.hasNext() == false) goto L68;
        r123.add(((EntityIdData) ZeusTransformUtils.preCheckCast(r43.next(), EntityIdData.class, "com.obric.memorydata.plugin")).getId());
        goto L66
    L68:
        List<AppEntity> r44 = r0.getWholeEntities(r123, r17);
        ArrayList r45 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r44, 10));
        Iterator<T> r46 = r44.iterator();
    L70:
        if (r46.hasNext() == false) goto L72;
        AppEntity r124 = (AppEntity) ZeusTransformUtils.preCheckCast(r46.next(), AppEntity.class, "com.obric.memorydata.plugin");
        r122.put(r124.getId(), r124);
        r45.add(new EntityHashData(r124.getId(), r124.hashCode()));
        r0 = r0;
        goto L70
    L72:
        r0 = r0;
        r33.addAll(r45);
    L77:
        r19 = r19;
        r22 = r22;
        r120 = r120;
        goto L78
    L76:
        r34 = r18;
        r4 = r4;
        goto L77
    L89:
        r0 = r0;
        Iterator r210 = r15;
        List r310 = r18;
        Function2 r211 = r4;
        ArrayList r47 = r120;
        LinkedHashSet r48 = r121;
        ArrayList r49 = new ArrayList(r47.size());
        Iterator r50 = r47.iterator();
    L91:
        if (r50.hasNext() == false) goto L96;
        AppEntity r51 = (AppEntity) ZeusTransformUtils.preCheckCast(r122.get((String) ZeusTransformUtils.preCheckCast(r50.next(), String.class, "com.obric.memorydata.plugin")), AppEntity.class, "com.obric.memorydata.plugin");
        if (r51 == null) goto L91;
        r49.add(r51);
        goto L91
    L96:
        if ((!r48.isEmpty()) == false) goto L102;
        Iterator r52 = r310.iterator();
    L99:
        if (r52.hasNext() == false) goto L102;
        r48.remove(((EntityIdData) ZeusTransformUtils.preCheckCast(r52.next(), EntityIdData.class, "com.obric.memorydata.plugin")).getId());
    L102:
        if ((!r48.isEmpty()) == false) goto L106;
        if (r211 == null) goto L105;
        Function2 r53 = r211;
        r53.invoke(CollectionsKt.toList(r48), Integer.valueOf(r17));
    L108:
        if ((!r49.isEmpty()) == false) goto L110;
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r49, null, 2, null);
    L110:
        r15 = r210;
        r4 = r53;
        goto L81
    L105:
        r53 = r211;
        EntityProvider.INSTANCE.bulkDelete(CollectionsKt.toList(r48), r17);
        goto L108
    L106:
        r53 = r211;
        goto L108
    L46:
        return;
    }
}
