package xa2;

import ak6.e;
import ak6.g;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import h52.c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements e {
    public final /* synthetic */ k.a a;
    public final /* synthetic */ c b;
    public final /* synthetic */ Ref.ObjectRef c;

    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    public final void b(g r5) {
        Intrinsics.checkNotNullParameter(r5, "rendResult");
        k.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(this.b, new j(r5.a, ((d) this.c.element).b));
        return;
    }

    public b(k.a r1, c r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
