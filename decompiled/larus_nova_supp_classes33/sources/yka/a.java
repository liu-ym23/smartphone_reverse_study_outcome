package yka;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.obric.miniapp.aibridge.b;
import com.obric.miniapp.aibridge.d;
import com.obric.miniapp.aibridge.f;
import com.obric.miniapp.alarm.w;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zka.g;
import zka.q;
import zka.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements r {
    public static final a b = null;
    public static final q c = null;

    public a() {
    }

    static {
        b = new a();
        c = new q(AppHost.a.getApplication());
    }

    public final boolean e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return c.e.c(r2);
    }

    public final void d(Context r3, f r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "onResult");
        q r0 = c;
        if (r0.a() != null) goto L6;
        r4.invoke(CollectionsKt.emptyList());
        return;
    L6:
        g r1 = r0.a();
        if (r1 == null) goto L10;
        r1.d(r3, r4);
        return;
    }

    public final void b(Context r3, String r4, b r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "onResult");
        q r0 = c;
        if (r0.a() != null) goto L6;
        r5.invoke(Boolean.FALSE);
        return;
    L6:
        g r1 = r0.a();
        if (r1 == null) goto L10;
        r1.b(r3, r4, r5);
        return;
    }

    public final void c(Context r3, String r4, d r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "onResult");
        q r0 = c;
        if (r0.a() != null) goto L6;
        r5.invoke(null);
        return;
    L6:
        g r1 = r0.a();
        if (r1 == null) goto L10;
        r1.c(r3, r4, r5);
        return;
    }

    public final void a(Context r9, String r10, String r11, String r12, w r13, Map r14, Function1 r15) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, "content");
        Intrinsics.checkNotNullParameter(r13, "triggerTime");
        Intrinsics.checkNotNullParameter(r14, "extraInfo");
        Intrinsics.checkNotNullParameter(r15, "onResult");
        q r0 = c;
        if (r0.a() != null) goto L6;
        r15.invoke(Boolean.FALSE);
        return;
    L6:
        g r1 = r0.a();
        if (r1 == null) goto L10;
        r1.a(r9, r10, r11, r12, r13, r14, r15);
        return;
    }
}
