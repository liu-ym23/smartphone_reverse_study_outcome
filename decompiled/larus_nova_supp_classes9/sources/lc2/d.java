package lc2;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements o {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.o
    public final void a(f<?> r5, e52.a r6) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r6, "config");
        i r1 = null;
        if ((r5 instanceof z) == true) goto L5;
        f<?> r0 = null;
    L6:
        z r2 = (z) r0;
        if (r2 == null) goto L9;
        r1 = r2.H;
    L9:
        if (r1 == null) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
    L18:
        if (r3 == true) goto L23;
        k<f<?>> r7 = r6.g();
        if (r7 == null) goto L24;
        r7.d(r5);
        return;
    L24:
        return;
    L23:
        return;
    L14:
        if ((r1 instanceof s) == false) goto L18;
        s r4 = (s) r1;
        r4.k().a.b = l.c(r6, r4);
        k<s> r8 = r6.e();
        if (r8 == 0) goto L18;
        r8.d(r1);
        goto L18
    L11:
        r3 = false;
        goto L12
    L5:
        r0 = r5;
        goto L6
    }
}
