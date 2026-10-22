package com.larus.bmhome.block.holder.deepthink;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.obric.assistant.spi.complextask.ComplexTaskFoldStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DeepThinkFoldStatus.values().length];
            r0[DeepThinkFoldStatus.CompleteFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[DeepThinkFoldStatus.HalfFold.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[DeepThinkFoldStatus.CompleteExpand.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[ComplexTaskFoldStatus.values().length];
            r1[ComplexTaskFoldStatus.CompleteFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[ComplexTaskFoldStatus.HalfFold.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[ComplexTaskFoldStatus.CompleteExpand.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    public static final ComplexTaskFoldStatus a(DeepThinkFoldStatus r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L14;
        return ComplexTaskFoldStatus.None;
    L14:
        return ComplexTaskFoldStatus.CompleteExpand;
    L15:
        return ComplexTaskFoldStatus.HalfFold;
    L12:
        return ComplexTaskFoldStatus.CompleteFold;
    }

    public static final DeepThinkFoldStatus b(ComplexTaskFoldStatus r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.b[r1.ordinal()];
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L14;
        return DeepThinkFoldStatus.CompleteFold;
    L14:
        return DeepThinkFoldStatus.CompleteExpand;
    L15:
        return DeepThinkFoldStatus.HalfFold;
    L12:
        return DeepThinkFoldStatus.CompleteFold;
    }
}
