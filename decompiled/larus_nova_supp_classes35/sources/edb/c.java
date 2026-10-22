package edb;

import android.content.Context;
import com.ss.android.lark.chameleon.error.DocErrorCode;
import com.ss.android.lark.export.entity.WidthMode;
import idb.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WidthMode.values().length];
            r0[WidthMode.SPACIOUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[WidthMode.FILL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static int a(WidthMode r2) {
        if (f.a().isEnable("universalcard.renderrouter.widthmode.enable") == true) goto L5;
        return DocErrorCode.ERRCODE_NOT_RENDER;
    L5:
        if (r2 != null) goto L7;
        int r3 = -1;
    L9:
        if (r3 != 1) goto L11;
        return 600;
    L11:
        if (r3 != 2) goto L17;
        return Integer.MAX_VALUE;
    L17:
        return DocErrorCode.ERRCODE_NOT_RENDER;
    L7:
        r3 = a.a[r2.ordinal()];
        goto L9
    }

    public static int b(Context r1, WidthMode r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r3 = a(r2);
        Intrinsics.checkNotNullParameter(r1, "context");
        return MathKt.roundToInt(h18.d.b(r1, r3));
    }
}
