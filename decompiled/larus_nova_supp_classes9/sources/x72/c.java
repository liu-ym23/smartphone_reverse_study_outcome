package x72;

import android.text.TextUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.va;
import ec2.b1;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements b {
    public static final long e = 0;
    public final List<k32.a> a;
    public int b;
    public final CompositeDisposable c;
    public final u72.a d;

    public static final class a {
    }

    static {
        Long r0 = (Long) b1.a.getValue();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        e = r1;
        return;
    L5:
        r1 = 3000;
        goto L6
    }

    public c(u72.a r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.d = r2;
        this.a = new ArrayList();
        this.c = new CompositeDisposable();
    }

    @Override // x72.b
    public final boolean a(x72.a r7, k32.a r8) {
        Intrinsics.checkNotNullParameter(r7, "chain");
        if (r8 == null) goto L32;
        boolean r1 = false;
        k32.a r3 = null;
        if (this.b != 1) goto L26;
        va.a r0 = r8.k;
        if (r0 != null) goto L9;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L26;
        String r4 = r8.a;
        IMiddlewareUserService r5 = k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L22;
        com.bytedance.android.livesdk.user.e r6 = r5.user();
        if (r6 == null) goto L22;
        String r9 = r6.n();
    L24:
        if (TextUtils.equals(r4, r9) == true) goto L26;
        r1 = true;
    L22:
        r9 = null;
        goto L24
    L9:
        if (r0.getType() != 8) goto L11;
    L14:
        r2 = true;
        goto L16
    L11:
        if (r0.getType() == 9) goto L14;
        if (r0.getType() != 3) goto L15;
    L26:
        if (r1 == false) goto L28;
        r3 = r8;
    L28:
        if (r3 == null) goto L32;
        ((ArrayList) this.a).add(r8);
        return true;
    L32:
        return r7.a(r8);
    }
}
