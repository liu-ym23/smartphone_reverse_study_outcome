package com.obric.capabilitykit.sync;

import android.net.Uri;
import android.os.Bundle;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.p;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import wia.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bH\u0002¢\u0006\u0002\u0010\u001cJp\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\"\b\u0002\u0010%\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e\u0018\u00010&2\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0006\u0012\u0004\u0018\u00010*0(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/sync/EntitySyncUtil;", "", "()V", "MAX_SIZE_ONE_GROUP", "", "METHOD_SYNC_DATA_CHECK_COUNT_DIFF", "", "METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF", "PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA", "PARAMS_SYNC_COUNT_TIME_SLOT_DATA", "PARAMS_SYNC_DATA_ENTITY_TYPE", "PARAMS_SYNC_DATA_LAZY_DELETE", "RESULT_DATA_CHECK_DIFF", "RESULT_DATA_LAZY_DELETE", "buildTimeSlotEntityTree", "tree", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "Lkotlin/collections/ArrayList;", "leftIndex", "rightIndex", "startTime", "", "endTime", "sumArray", "", "timeArray", "", "(Ljava/util/ArrayList;IIJJ[I[Ljava/lang/Long;)I", "syncData", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "indexedEntityTypes", "", "deleteCall", "Lkotlin/Function2;", "innerCall", "Lkotlin/Function3;", "Landroid/net/Uri;", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void syncData$default(EntitySyncUtil r6, EntitySyncDataSupplier r7, EntitySupplier r8, List r9, Function2 r10, Function3 r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        r6.syncData(r7, r8, r9, r10, r11);
    }

    public final void syncData(EntitySyncDataSupplier r24, EntitySupplier r25, List<Integer> r26, Function2<? super List<String>, ? super Integer, Unit> r27, Function3<? super Uri, ? super String, ? super Bundle, Bundle> r28) {
        Intrinsics.checkNotNullParameter(r26, "indexedEntityTypes");
        Intrinsics.checkNotNullParameter(r28, "innerCall");
        p.a.b();
        if (r24 != null) goto L5;
        EntitySyncDataSupplier r2 = new a0(r25);
    L6:
        List<EntityIdData> r4 = r2.provideSampleEntities();
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<T> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();
        Integer r8 = Integer.valueOf(((EntityIdData) r7).getType());
        Object r9 = r5.get(r8);
        if (r9 != null) goto L12;
        r9 = new ArrayList();
        r5.put(r8, r9);
    L12:
        ((List) r9).add(r7);
        goto L8
    L13:
        Map r10 = MapsKt.toMutableMap(r5);
        Iterator<T> r3 = r26.iterator();
    L15:
        if (r3.hasNext() == false) goto L19;
        int r11 = ((Number) r3.next()).intValue();
        if (r10.containsKey(Integer.valueOf(r11)) == true) goto L15;
        r10.put(Integer.valueOf(r11), CollectionsKt.emptyList());
        goto L15
    L19:
        Iterator r12 = r10.entrySet().iterator();
    L21:
        if (r12.hasNext() == false) goto L112;
        Map.Entry r13 = (Map.Entry) r12.next();
        int r14 = ((Number) r13.getKey()).intValue();
        List r15 = (List) r13.getValue();
        Logger.INSTANCE.d("EntityProvider", "start sync entity for type " + r14 + " , total " + r15.size());
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r17 = r15.iterator();
    L24:
        if (r17.hasNext() == false) goto L29;
        Object r18 = r17.next();
        Long r19 = Long.valueOf(((EntityIdData) r18).getLastModifyTime());
        Object r110 = r16.get(r19);
        if (r110 != null) goto L28;
        r110 = new ArrayList();
        r16.put(r19, r110);
    L28:
        ((List) r110).add(r18);
        goto L24
    L29:
        Object[] r20 = CollectionsKt.sorted(r16.keySet()).toArray(new Long[0]);
        if (r20 == null) goto L111;
        Long[] r21 = (Long[]) r20;
        int[] r111 = new int[r21.length];
        int r112 = r21.length;
        int r113 = 0;
    L32:
        if (r113 >= r112) goto L41;
        List r114 = (List) r16.get(r21[r113]);
        if (r114 == null) goto L36;
        int r115 = r114.size();
    L37:
        if (r113 == 0) goto L40;
        r115 = r115 + r111[r113 - 1];
    L40:
        r111[r113] = r115;
        r113 = r113 + 1;
        goto L32
    L36:
        r115 = 0;
        goto L37
    L41:
        ArrayList<EntityCountTimeSlotData> r22 = new ArrayList();
        INSTANCE.buildTimeSlotEntityTree(r22, 0, r21.length - 1, Long.MIN_VALUE, Long.MAX_VALUE, r111, r21);
        if (r22.size() != 0) goto L44;
        r22.add(new EntityCountTimeSlotData(Long.MIN_VALUE, Long.MAX_VALUE, 0, -1, -1));
    L44:
        Logger.INSTANCE.d("EntityProvider", "syncdata buildTimeSlotEntityTree: " + r22.size());
        Uri r23 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        Bundle r116 = new Bundle();
        r116.putParcelableArrayList(PARAMS_SYNC_COUNT_TIME_SLOT_DATA, r22);
        r116.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r14);
        Bundle r29 = (Bundle) r28.invoke(r23, METHOD_SYNC_DATA_CHECK_COUNT_DIFF, r116);
        if (r29 == null) goto L21;
        r29.setClassLoader(EntityCountTimeSlotData.class.getClassLoader());
        ArrayList r30 = r29.getParcelableArrayList(RESULT_DATA_CHECK_DIFF);
        if (r30 == null) goto L49;
        ArrayList r117 = new ArrayList();
        LinkedHashSet r118 = new LinkedHashSet();
        LinkedHashMap r119 = new LinkedHashMap();
        Iterator r31 = r30.iterator();
    L52:
        if (r31.hasNext() == false) goto L87;
        EntityCountTimeSlotData r120 = (EntityCountTimeSlotData) r31.next();
        ArrayList r121 = new ArrayList();
        Iterator r210 = r12;
        int r32 = r120.d;
        if (r32 < 0) goto L77;
        Iterator r211 = r31;
        if (r32 >= r21.length) goto L76;
        int r33 = r120.e;
        if (r33 < 0) goto L76;
        if (r33 >= r21.length) goto L76;
        if (r32 > r33) goto L76;
    L62:
        List r0 = (List) r16.get(r21[r32]);
        if (r0 == null) goto L74;
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L67:
        if (r1.hasNext() == false) goto L69;
        r34.add(((EntityIdData) r1.next()).getId());
        goto L67
    L69:
        List<AppEntity> r35 = r2.getWholeEntities(r34, r14);
        ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator r37 = r35.iterator();
    L71:
        if (r37.hasNext() == false) goto L73;
        AppEntity r38 = (AppEntity) r37.next();
        r119.put(r38.getId(), r38);
        r36.add(new EntityHashData(r38.getId(), r38.hashCode()));
        r37 = r37;
        goto L71
    L73:
        r121.addAll(r36);
    L74:
        if (r32 == r33) goto L78;
        r32 = r32 + 1;
        r16 = r16;
        r21 = r21;
        r15 = r15;
    L78:
        Uri r39 = EntityProvider.INSTANCE.getENTITY_URI$capabilitykit_release();
        Bundle r40 = new Bundle();
        LinkedHashMap r41 = r119;
        r40.putParcelable(PARAMS_SYNC_COUNT_HASH_CODE_SLOT_DATA, new EntityCheckHashCodeSlotData(r120.a, r120.b, r121));
        r40.putInt(PARAMS_SYNC_DATA_ENTITY_TYPE, r14);
        r40.putBoolean(PARAMS_SYNC_DATA_LAZY_DELETE, true);
        Bundle r42 = (Bundle) r28.invoke(r39, METHOD_SYNC_DATA_CHECK_HASH_CODE_DIFF, r40);
        if (r42 == null) goto L80;
        ArrayList<String> r43 = r42.getStringArrayList(RESULT_DATA_CHECK_DIFF);
        ArrayList<String> r44 = r42.getStringArrayList(RESULT_DATA_LAZY_DELETE);
        if (r43 == null) goto L84;
        r117.addAll(r43);
    L84:
        if (r44 == null) goto L86;
        r118.addAll(r44);
    L86:
        r12 = r210;
        r16 = r16;
        r119 = r41;
        r21 = r21;
        r15 = r15;
        r31 = r211;
        goto L52
    L80:
        r12 = r210;
    L76:
        r15 = r15;
        r16 = r16;
        r21 = r21;
        goto L78
    L77:
        r15 = r15;
        r16 = r16;
        r21 = r21;
        r211 = r31;
        goto L78
    L87:
        Iterator r212 = r12;
        List r213 = r15;
        LinkedHashMap r45 = r119;
        ArrayList r46 = new ArrayList(r117.size());
        Iterator r47 = r117.iterator();
    L89:
        if (r47.hasNext() == false) goto L94;
        AppEntity r48 = (AppEntity) r45.get((String) r47.next());
        if (r48 == null) goto L89;
        r46.add(r48);
        goto L89
    L94:
        if ((!r118.isEmpty()) == false) goto L100;
        Iterator r49 = r213.iterator();
    L97:
        if (r49.hasNext() == false) goto L100;
        r118.remove(((EntityIdData) r49.next()).getId());
    L100:
        if ((!r118.isEmpty()) == false) goto L105;
        Function2<? super List<String>, ? super Integer, Unit> r50 = r27;
        if (r50 == null) goto L104;
        r50.invoke(CollectionsKt.toList(r118), Integer.valueOf(r14));
    L107:
        if ((!r46.isEmpty()) == false) goto L109;
        EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r46, null, 2, null);
    L109:
        r12 = r212;
        goto L21
    L104:
        EntityProvider.INSTANCE.bulkDelete(CollectionsKt.toList(r118), r14);
        goto L107
    L105:
        r50 = r27;
        goto L107
    L49:
        return;
    L111:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L112:
        return;
    L5:
        r2 = r24;
        goto L6
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
        r12.f = buildTimeSlotEntityTree(r16, r17, r14, r19, r24[r14].longValue(), r23, r24);
        r12.g = buildTimeSlotEntityTree(r16, r14 + 1, r18, r24[r14].longValue() + 1, r21, r23, r24);
    L14:
        return r11;
    L9:
        r1 = r23[r17 - 1];
        goto L10
    }
}
