package xmb;

import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import nza.b;
import yya.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class a implements b {

    /* JADX INFO: renamed from: xmb.a$a, reason: collision with other inner class name */
    public static final class C0345a {
    }

    static {
    }

    @Inject
    public a() {
    }

    public final void a(y6b.a<?> r3, m<y6b.a<?>> r4, List<k> r5) {
        Intrinsics.checkNotNullParameter(r3, "messageVO");
        Intrinsics.checkNotNullParameter(r4, "cell");
        Intrinsics.checkNotNullParameter(r5, "messageActionList");
        y5b.a r0 = r4.c().c.a(y5b.a.class);
        if (r0 != null) goto L6;
        Log.w("OfficeMessageMenuServic", "message menu env not found.");
        return;
    L6:
        r0.e(r3, r4, r5);
    }
}
