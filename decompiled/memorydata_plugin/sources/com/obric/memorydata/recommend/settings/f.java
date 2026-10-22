package com.obric.memorydata.recommend.settings;

import com.obric.memorydata.database.entity.BlockMemoryContentEntity;
import com.obric.memorydata.recommend.BlockMemoryRuleSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/settings/BlockMemoryRuleSnapshotAssembler;", "", "<init>", "()V", "assemble", "", "Lcom/obric/memorydata/recommend/BlockMemoryRuleSnapshot;", "defaultContents", "", "customEntities", "Lcom/obric/memorydata/database/entity/BlockMemoryContentEntity;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12601a = null;

    static {
        f12601a = new f();
    }

    private f() {
    }

    public final List<com.obric.memorydata.recommend.a> a(List<String> r6, List<BlockMemoryContentEntity> r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "defaultContents");
        Intrinsics.checkNotNullParameter(r8, "customEntities");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(new com.obric.memorydata.recommend.a((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), BlockMemoryRuleSource.DEFAULT));
        goto L4
    L6:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{BlockMemoryRuleSnapshotAssembler$assemble$customSnapshots$1.INSTANCE, BlockMemoryRuleSnapshotAssembler$assemble$customSnapshots$2.INSTANCE})), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L11;
        r14.add(new com.obric.memorydata.recommend.a(((BlockMemoryContentEntity) ZeusTransformUtils.preCheckCast(r15.next(), BlockMemoryContentEntity.class, "com.obric.memorydata.plugin")).getContent(), BlockMemoryRuleSource.CUSTOM));
        goto L8
    L11:
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }
}
