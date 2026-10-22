package qz7;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final int a(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return r1.getResources().getDimensionPixelSize(r2);
    }
}
