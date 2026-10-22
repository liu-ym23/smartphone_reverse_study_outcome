package ix1;

import com.bytedance.android.livesdk.feedback.service.FeedbackHideCode;
import com.bytedance.android.livesdk.feedback.service.d;
import com.bytedance.android.livesdk.feedback.service.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements a {
    public final List<d> a;

    @Override // ix1.a
    public final void b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).d(FeedbackHideCode.REMOVE_DATA);
        goto L4
    }

    @Override // ix1.a
    public final void c() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        e r1 = ((d) r0.next()).a();
        if (r1 == null) goto L4;
        r1.reset();
        goto L4
    }

    @Override // ix1.a
    public final void d() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).c();
        goto L4
    }

    @Override // ix1.a
    public final void f() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).onLeaveRoom();
        goto L4
    L6:
        ((ArrayList) this.a).clear();
    }

    public b() {
        this.a = new ArrayList();
    }

    @Override // ix1.a
    public final List<d> a() {
        return this.a;
    }

    @Override // ix1.a
    public final void e(List<? extends d> r2) {
        Intrinsics.checkNotNullParameter(r2, "configs");
        ArrayList r0 = (ArrayList) this.a;
        r0.clear();
        r0.addAll(r2);
    }
}
