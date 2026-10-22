package qq1;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vr1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final e a;
    public List<qq1.a> b;

    public static final class a {
    }

    static {
    }

    public b(ViewGroup r2) {
        e r3 = r.a().f(r2);
        if (r3 != null) goto L5;
        r3 = new d();
    L5:
        this.a = r3;
    }

    public final void a(qq1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.b != null) goto L5;
        this.b = new ArrayList();
    L5:
        List<qq1.a> r0 = this.b;
        if (r0 == null) goto L9;
        r0.add(r2);
        return;
    }

    public final void b(qq1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        List<qq1.a> r0 = this.b;
        if (r0 == null) goto L6;
        ((ArrayList) r0).remove(r2);
        return;
    }

    public final void c(boolean r5, int r6) {
        List<qq1.a> r0 = this.b;
        if (r0 == null) goto L8;
        Iterator r1 = ((ArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        qq1.a r2 = (qq1.a) r1.next();
        ALogger.i("ReplayKeyboardObservable", "visiable:" + r5 + "keyboardHeight:" + r6);
        r2.X6(r5, r6);
        goto L6
    L10:
        return;
    }
}
