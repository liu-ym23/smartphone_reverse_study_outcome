package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0003*\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"FAIL_ID", "", "TAG", "", "normalizeAndDistinct", "", "Lcom/obric/memorydata/database/entity/MemoryKeyInfoEntity;", "escapeSql", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MemoryKeyInfoEntityDaoKt {
    private static final long FAIL_ID = -1;
    private static final String TAG = "MemoryKeyInfoDao";

    public static final /* synthetic */ String access$escapeSql(String r0) {
        return escapeSql(r0);
    }

    public static final /* synthetic */ List access$normalizeAndDistinct(List r2) {
        return normalizeAndDistinct((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    private static final String escapeSql(String r6) {
        return StringsKt.replace$default(r6, "'", "''", false, 4, null);
    }

    private static final List<MemoryKeyInfoEntity> normalizeAndDistinct(List<MemoryKeyInfoEntity> r11) {
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r2 = r13.next();
        if (((MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r2, MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin")).isValid() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        MemoryKeyInfoEntity r3 = (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r15.next(), MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
        r1.add(MemoryKeyInfoEntity.copy$default(r3, 0, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3.getSourceEntityId(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), null, null, 13, null));
        goto L10
    L12:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r4 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r17 = r16.iterator();
    L14:
        if (r17.hasNext() == false) goto L19;
        Object r6 = r17.next();
        MemoryKeyInfoEntity r7 = (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r6, MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
        if (r4.add(TuplesKt.to(r7.getSourceEntityId(), r7.getKey())) == false) goto L14;
        r5.add(r6);
        goto L14
    L19:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    }
}
