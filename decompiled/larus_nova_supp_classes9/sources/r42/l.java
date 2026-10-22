package r42;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements vlc.i {
    public final /* synthetic */ m a;
    public final /* synthetic */ h.a b;
    public final /* synthetic */ vlc.d c;

    public final void a(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        h.a r3 = this.b;
        aa2.e r4 = (aa2.e) r3;
        r4.a(new ArrayList());
        this.a.b = false;
        ALogger.e("HISTORY_COMMENT_TAG", "fetch history comment error");
    }

    public final void b(List<? extends tlc.d> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "messages");
        if (r5.isEmpty() == false) goto L5;
        ((aa2.e) this.b).a(new ArrayList());
    L18:
        this.a.b = r6;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L11;
        Object r1 = r7.next();
        int r3 = a.a;
        if ((!a.a((tlc.d) r1, this.c)) == false) goto L7;
        r0.add(r1);
        goto L7
    L11:
        List r8 = CollectionsKt.reversed(r0);
        ArrayList r2 = new ArrayList();
        Iterator r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L17;
        Object r4 = r9.next();
        if ((r4 instanceof t) == false) goto L13;
        r2.add(r4);
        goto L13
    L17:
        ((aa2.e) this.b).a(r2);
        ALogger.i("HISTORY_COMMENT_TAG", "fetch history comment " + r2.size() + ", hasMore:" + r6);
        goto L18
    }

    public l(m r1, aa2.e r2, vlc.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
