package androidx.work;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return r10.hasKeyWithValueOfType(r11, Object.class);
    }

    public static final Data workDataOf(Pair<String, ? extends Object>... r10) {
        Intrinsics.checkNotNullParameter(r10, "pairs");
        Data.Builder r11 = new Data.Builder();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Pair<String, ? extends Object> r14 = r10[r13];
        r11.put(r14.getFirst(), r14.getSecond());
        r13 = r13 + 1;
        goto L3
    L5:
        Data r15 = r11.build();
        Intrinsics.checkNotNullExpressionValue(r15, "dataBuilder.build()");
        return r15;
    }
}
