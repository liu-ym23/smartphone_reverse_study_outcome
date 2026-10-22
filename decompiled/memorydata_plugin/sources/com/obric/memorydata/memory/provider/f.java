package com.obric.memorydata.memory.provider;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.recommend.RecorderSettingsContract;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\t¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/provider/RecorderSettingsQueryExecutor;", "", "<init>", "()V", "execute", "Lcom/obric/memorydata/memory/provider/RecorderSettingsQueryResult;", "uri", "", "isPermissionRefused", "Lkotlin/Function0;", "", "cellularEnabled", "blockRules", "", "Lcom/obric/memorydata/recommend/BlockMemoryRuleSnapshot;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10364a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10365a = null;

        static {
            int[] r0 = new int[RecorderSettingsContract.Query.values().length];
            r0[RecorderSettingsContract.Query.CELLULAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RecorderSettingsContract.Query.BLOCK_RULES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10365a = r0;
        }
    }

    static {
        f10364a = new f();
    }

    private f() {
    }

    public final g a(String r6, Function0<Boolean> r7, Function0<Boolean> r8, Function0<? extends List<com.obric.memorydata.recommend.a>> r9) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "uri");
        Intrinsics.checkNotNullParameter(r5, "isPermissionRefused");
        Intrinsics.checkNotNullParameter(r10, "cellularEnabled");
        Intrinsics.checkNotNullParameter(r11, "blockRules");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L18;
        int r12 = a.f10365a[RecorderSettingsContract.f12492a.a(r6).ordinal()];
        if (r12 == 1) goto L16;
        if (r12 != 2) goto L14;
        List r13 = CollectionsKt.listOf(new String[]{Params.CONTENT, AILabCheckPermissionTask.KEY_SOURCE});
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r11.invoke(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L20;
        com.obric.memorydata.recommend.a r1 = (com.obric.memorydata.recommend.a) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.memorydata.recommend.a.class, "com.obric.memorydata.plugin");
        r15.add(CollectionsKt.listOf(new String[]{r1.a(), r1.b().getWireValue()}));
        goto L10
    L20:
        return new g(r13, (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), "content://com.obric.memorydata.memory.ailabprovider/recorder_settings/block_rules");
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        return new g(CollectionsKt.listOf("enabled"), CollectionsKt.listOf(CollectionsKt.listOf(Integer.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(r10.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() ? 1 : 0))), "content://com.obric.memorydata.memory.ailabprovider/recorder_settings/cellular");
    L18:
        throw new SecurityException("Permission denied: com.obric.memorydata.memory.READ_AI_LAB_SETTINGS");
    }
}
