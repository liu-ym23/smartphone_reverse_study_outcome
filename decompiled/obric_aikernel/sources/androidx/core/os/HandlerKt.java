package androidx.core.os;

import android.os.Handler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerKt {
    public static final Runnable postAtTime(Handler r10, long r11, Object r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "action");
        HandlerKt$postAtTime$runnable$1 r14 = new HandlerKt$postAtTime$runnable$1(r13);
        r10.postAtTime(r14, r12, r11);
        return r14;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler r10, long r11, Object r12, Function0 r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r12 = null;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "action");
        HandlerKt$postAtTime$runnable$1 r16 = new HandlerKt$postAtTime$runnable$1(r13);
        r10.postAtTime(r16, r12, r11);
        return r16;
    }

    public static final Runnable postDelayed(Handler r10, long r11, Object r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "action");
        HandlerKt$postDelayed$runnable$1 r14 = new HandlerKt$postDelayed$runnable$1(r13);
        if (r12 != null) goto L5;
        r10.postDelayed(r14, r11);
    L6:
        return r14;
    L5:
        HandlerCompat.postDelayed(r10, r14, r12, r11);
        goto L6
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler r10, long r11, Object r12, Function0 r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r12 = null;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "action");
        HandlerKt$postDelayed$runnable$1 r16 = new HandlerKt$postDelayed$runnable$1(r13);
        if (r12 != null) goto L8;
        r10.postDelayed(r16, r11);
    L9:
        return r16;
    L8:
        HandlerCompat.postDelayed(r10, r16, r12, r11);
        goto L9
    }
}
