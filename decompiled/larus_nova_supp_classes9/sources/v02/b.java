package v02;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static void a(long r3, boolean r5, Function0 r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r7 & 4) == 0) goto L8;
        r5 = false;
    L8:
        Intrinsics.checkNotNullParameter(r6, "action");
        Handler r8 = new Handler(Looper.getMainLooper());
        if (r3 <= 0) goto L11;
        r8.postDelayed(new a(r6), r3);
        return;
    L11:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L14;
        if (r5 == true) goto L14;
        r6.invoke();
        return;
    L14:
        r8.post(new a(r6));
    }
}
