package t0b;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.ChameleonResProvider;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import u0b.b;
import u0b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final List<? extends u0b.a> a = null;

    static {
        a = CollectionsKt.listOf(new u0b.a[]{new d(), new b()});
    }

    public static com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d a(Context r3, ChameleonConfig r4, boolean r5, String r6) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        u0b.a r1 = (u0b.a) r0.next();
        if (r1.d(r3, r4) == false) goto L4;
        return r1.b(r3, r4, r5, r6);
    L9:
        j.b(ChameleonResProvider.TAG, "getResource, no interceptor match");
        return new com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d(null, null);
    }
}
