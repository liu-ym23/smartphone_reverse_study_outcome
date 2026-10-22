package p9a;

import android.net.Uri;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final String a(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List<String> r2 = r1.getPathSegments();
        if (r2 == null) goto L5;
        String r3 = (String) CollectionsKt.firstOrNull(r2);
    L6:
        if (r3 != null) goto L9;
        return NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public static final String b(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.getHost();
        if (r2 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r2;
    }
}
