package ph;

import android.content.Context;
import com.bytedance.android.ec.core.opt.ab.j;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
        j.a().b();
        j.a().a();
    }

    public static void a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r0 = ECSdk.a;
        cj.b r10 = (cj.b) ECSdk.a(cj.b.class);
        if (r10 == null) goto L6;
        r10.e(r1);
        return;
    }
}
