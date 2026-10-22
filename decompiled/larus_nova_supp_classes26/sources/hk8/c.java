package hk8;

import android.view.View;
import com.larus.bmhome.bigimg.l;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.nova.NovaApplication;
import gd9.i;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import uo8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements b {
    public final Function0<Unit> a;

    @Override // hk8.b
    public final void a() {
        this.a.invoke();
    }

    public c(fk8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "onRebind");
        this.a = r2;
    }

    @Override // hk8.b
    public final void b(String r22, String r23, View r24) {
        Intrinsics.checkNotNullParameter(r22, "uri");
        Intrinsics.checkNotNullParameter(r23, ShareType.URL);
        Intrinsics.checkNotNullParameter(r24, "view");
        i r1 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r1);
        NovaApplication r2 = r1.a().e();
        if (r2 != null) goto L5;
        i r3 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r3);
        r2 = r3.getApplication();
    L5:
        List r0 = CollectionsKt.listOf(new Pair(0, r24));
        List r4 = CollectionsKt.listOf(new l(null, r23, r22, r23, null, null, null, null, null, null, 2033));
        k r6 = new k(MapsKt.emptyMap(), null);
        com.larus.bmhome.bigimg.k.c(r2, r0, r4, 0, r6, true, null, null, false, null, null, null, null, 16320);
    }
}
