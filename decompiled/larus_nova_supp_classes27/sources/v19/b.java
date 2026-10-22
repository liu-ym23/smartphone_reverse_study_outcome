package v19;

import androidx.activity.result.ActivityResultLauncher;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final <T> void a(ActivityResultLauncher<T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.launch(r2);
        Iterator r3 = ((ArrayList) a.a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((q5) r3.next()).gotoToSystemPage();
        goto L4
    }
}
