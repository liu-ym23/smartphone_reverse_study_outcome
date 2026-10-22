package v7;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b extends u7.a {
    public abstract void e(String r1);

    public b(Context r10, ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "parent");
        super(r10, r11);
    }
}
