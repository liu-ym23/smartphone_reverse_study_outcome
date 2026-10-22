package com.obric.memorydata.memory.utils;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002¨\u0006\b"}, d2 = {"px2dp", "", "", "dp2px", "", "dp2pxFloat", "sp2px", "sp2pxFloat", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class x {
    public static final int a(Number r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (int) ((r1.floatValue() * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
