package zz0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.scope.m;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final void a(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        m.e.getClass();
        Object r1 = m.b(r0).a(Reflection.getOrCreateKotlinClass(g.class));
        Intrinsics.checkNotNull(r1);
        ((g) ((f80.a) r1)).Y(r2, r3);
    }

    public static final void b(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uriString");
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        m.e.getClass();
        Object r1 = m.b(r0).a(Reflection.getOrCreateKotlinClass(g.class));
        Intrinsics.checkNotNull(r1);
        ((g) ((f80.a) r1)).S2(r2, r3);
    }
}
