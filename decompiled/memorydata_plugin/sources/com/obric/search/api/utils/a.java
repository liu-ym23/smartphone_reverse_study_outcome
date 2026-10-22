package com.obric.search.api.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.OptionalInt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getFirstUnicodeFromString", "", TypedValues.Custom.S_STRING, "", "sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class a {
    public static final int a(String r1) {
        Intrinsics.checkNotNullParameter(r1, TypedValues.Custom.S_STRING);
        OptionalInt r2 = r1.codePoints().findFirst();
        if (r2.isPresent() == true) goto L7;
        return 0;
    L7:
        return r2.getAsInt();
    }
}
