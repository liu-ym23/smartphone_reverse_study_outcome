package bz0;

import android.net.Uri;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class g implements yy0.a {
    public Uri a;
    public final k b;
    public final j c;
    public final Map<String, Object> d;

    public g() {
        this.a = Uri.EMPTY;
        this.b = new k();
        this.c = new j();
        this.d = new LinkedHashMap();
    }

    @Override // yy0.a
    public final void a(Function1<? super yy0.h, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        r2.invoke(this.b);
    }

    @Override // yy0.a
    public final void d(Function1<? super yy0.g, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        r2.invoke(this.c);
    }

    @Override // yy0.a
    public final void e(String r4, HybridType r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "hybridType");
        int r7 = f.a[r5.ordinal()];
        if (r7 != 1) goto L5;
        Uri r8 = x6.a.b(r4);
        Intrinsics.checkNotNullParameter(r8, "uri");
        this.a = r8;
        return;
    L5:
        if (r7 != 2) goto L19;
        Uri r9 = x6.a.d(r4);
        if (r6 != null) goto L10;
    L15:
        Intrinsics.checkNotNullParameter(r9, "uri");
        this.a = r9;
        return;
    L10:
        if (r6.length() <= 0) goto L12;
        boolean r10 = true;
    L13:
        if (r10 != true) goto L15;
        r9.buildUpon().appendQueryParameter("fallback_url", r6).build();
        goto L15
    L12:
        r10 = false;
        goto L13
    }
}
