package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J&\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListFirstFramePolicy;", "", "<init>", "()V", "COLLECTION_TOP_PADDING_DP", "", "DEFAULT_CONTENT_TOP_PADDING_DP", "initialTopPaddingDp", "isCollection", "", "statusBarTopDp", "initialSelectedSourceKey", "", "filters", "", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "restoredSourceKey", "targetWearable", "canShowEmptyImmediately", "hasCompletedLayout", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f11337a = null;

    static {
        f11337a = new w();
    }

    private w() {
    }

    public final String a(List<MemorySourceFilter> r6, String r7, boolean r8) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "filters");
        boolean r9 = true;
        String r2 = null;
        if (r8 == false) goto L21;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r10.hasNext() == false) goto L16;
        Object r11 = r10.next();
        Integer r3 = ((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r11, MemorySourceFilter.class, "com.obric.memorydata.plugin")).getSourceProductType();
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L6;
    L17:
        MemorySourceFilter r12 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r11, MemorySourceFilter.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L20;
        r7 = r12.getStableKey();
        goto L21
    L20:
        r7 = null;
        goto L21
    L11:
        if (r3.intValue() != 20) goto L13;
        r4 = true;
        goto L14
    L16:
        r11 = null;
    L21:
        if (r7 == null) goto L35;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L25;
    L27:
        Iterator r14 = r13.iterator();
    L29:
        if (r14.hasNext() == false) goto L26;
        if (Intrinsics.areEqual(((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r14.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin")).getStableKey(), r7) == false) goto L29;
    L32:
        if (r9 == false) goto L34;
        r2 = r7;
    L34:
        if (r2 == null) goto L35;
        return r2;
    L26:
        r9 = false;
        goto L32
    L25:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L27;
    L35:
        return MemorySourceFilter.KEY_ALL;
    }

    public final boolean a(boolean r1) {
        return r1;
    }
}
