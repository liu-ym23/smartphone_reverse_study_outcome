package com.obric.memorydata.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"executeShortcutAdd", "", "operations", "Lcom/obric/memorydata/memory/utils/ShortcutAddOperations;", "executeEnablePinnedShortcut", "Lcom/obric/memorydata/memory/utils/PinnedShortcutState;", "currentState", "Lcom/obric/memorydata/memory/utils/EnablePinnedShortcutOperations;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class s {
    public static final PinnedShortcutState a(PinnedShortcutState r2, b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "currentState");
        Intrinsics.checkNotNullParameter(r4, "operations");
        if (r2 != PinnedShortcutState.ACTIVE) goto L5;
    L16:
    L12:
        th = move-exception;
        r4.a(th);
    L15:
        return r4.b();
    L8:
        if (r2 != PinnedShortcutState.DISABLED) goto L10;
        r4.a();     // Catch: Throwable -> L12
    L10:
        r4.update();     // Catch: Throwable -> L12
        goto L15
    L5:
        if (r2 == PinnedShortcutState.DISABLED) goto L16;
        return r2;
    }

    public static final boolean a(r r2) {
        r r3 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "operations");
        if (r3.a() == false) goto L7;
        r3.b();
        r3.c();
        return true;
    L7:
        return r3.d();
    }
}
