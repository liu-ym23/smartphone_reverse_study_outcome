package c62;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements vlc.h {
    public final long a;
    public final vlc.h b;

    public c(long r2, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.a = r2;
        this.b = r4;
    }

    public final void onFirstMessage(List<tlc.d> r9, boolean r10) {
        if (r9 == null) goto L12;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r9.iterator();
    L5:
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        if (o.b((tlc.d) r2) != this.a) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L5;
        r0.add(r2);
        goto L5
    L9:
        r3 = false;
    L13:
        if (r9 == null) goto L21;
        this.b.onFirstMessage(r0, r10);
        return;
    L21:
        return;
    L12:
        r0 = null;
        goto L13
    }
}
