package com.obric.memorydata.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"prettyJsonString", "", "", "includeParent", "", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class v {
    public static final String a(Object r1, boolean r2) {
        return GsonUtil.INSTANCE.toPrettyJson(r1, r2);
    }

    public static /* synthetic */ String a(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return a(r0, r1);
    }
}
