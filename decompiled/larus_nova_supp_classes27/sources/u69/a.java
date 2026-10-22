package u69;

import androidx.fragment.app.FragmentActivity;
import com.larus.utils.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final void a(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L6:
        u.f(r3, !r0);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
