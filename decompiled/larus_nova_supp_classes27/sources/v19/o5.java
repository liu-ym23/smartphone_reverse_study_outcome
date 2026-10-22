package v19;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o5 {
    public static final void a(Fragment r1, String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "requestKey");
        Intrinsics.checkNotNullParameter(r3, "result");
        if (r1.getFragmentManager() != null) goto L5;
        return;
    L5:
        r1.getParentFragmentManager().setFragmentResult(r2, r3);
    }

    public static final void b(Fragment r2, String r3, final Function2<? super String, ? super Bundle, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "requestKey");
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (r2.getFragmentManager() != null) goto L5;
        return;
    L5:
        r2.getParentFragmentManager().setFragmentResultListener(r3, r2, new n5(r4));
    }
}
