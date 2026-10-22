package a8;

import android.content.Context;
import android.widget.Toast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "text");
        Toast.makeText(r1, r10, 0).show();
    }
}
