package z5;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r1.getResources().getConfiguration().getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
