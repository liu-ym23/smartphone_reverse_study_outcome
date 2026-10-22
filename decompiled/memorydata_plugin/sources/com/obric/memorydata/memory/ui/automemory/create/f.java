package com.obric.memorydata.memory.ui.automemory.create;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J/\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightPolicy;", "", "<init>", "()V", "calculateAvailableInputHeight", "Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskAvailableInputHeight;", "rootHeight", "", "inputTopInRoot", "bottomBarPaddingTop", "measuredButtonHeight", "minimumButtonHeight", "bottomBarPaddingBottom", "bottomBarTopMargin", "bottomBarBottomMargin", "predictInputHeight", "record", "Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheRecord;", "currentKey", "Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheKey;", "fullAvailableHeight", "systemBarsBottom", "(Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheRecord;Lcom/obric/memorydata/memory/ui/automemory/create/CreateTaskImeHeightCacheKey;II)Ljava/lang/Integer;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10669a = null;

    static {
        f10669a = new f();
    }

    private f() {
    }

    public final c a(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
        if (r1 <= 0) goto L11;
        if (r2 < 0) goto L12;
        int r9 = Math.max(r4, r5);
        if (r9 > 0) goto L9;
        return null;
    L9:
        int r10 = (((RangesKt.coerceAtLeast(r3, 0) + r9) + RangesKt.coerceAtLeast(r6, 0)) + RangesKt.coerceAtLeast(r7, 0)) + RangesKt.coerceAtLeast(r8, 0);
        return new c(RangesKt.coerceAtLeast((r1 - r2) - r10, 1), r10, r9);
    L12:
        return null;
    L11:
        return null;
    }

    public final Integer a(e r2, d r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "currentKey");
        if (r2 == null) goto L5;
        d r0 = r2.a();
    L7:
        if (Intrinsics.areEqual(r0, r3) == true) goto L9;
        return null;
    L9:
        boolean r6 = false;
        int r7 = r2.b() - RangesKt.coerceAtLeast(r5, 0);
        if (r7 > 0) goto L12;
        return null;
    L12:
        Integer r8 = Integer.valueOf(r4 - r7);
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L15;
        r6 = true;
    L15:
        if (r6 == true) goto L17;
        return null;
    L17:
        return r8;
    L5:
        r0 = null;
        goto L7
    }
}
