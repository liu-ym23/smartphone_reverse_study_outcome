package wg0;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import kotlin.jvm.internal.Intrinsics;
import sh0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements ne0.a {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "store");
        ClientUIInfo r0 = null;
        if ((r4 instanceof h) == true) goto L5;
        r4 = null;
    L5:
        h r5 = (h) r4;
        e r6 = this.a;
        if (r5 == null) goto L10;
        Integer r1 = r5.a;
        if (r1 == null) goto L10;
        int r2 = r1.intValue();
    L11:
        if (r5 == null) goto L13;
        r0 = r5.b;
    L13:
        r6.g.P0(r2, r0);
        return;
    L10:
        r2 = 0;
        goto L11
    }
}
