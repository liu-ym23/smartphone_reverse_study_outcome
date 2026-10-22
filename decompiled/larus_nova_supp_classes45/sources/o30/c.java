package o30;

import android.net.Uri;
import com.bytedance.android.live.browser.service.AnnieExternalServiceImpl;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final c b = null;
    public final List<ff1.a> a;

    static {
        b = new c();
    }

    public c() {
        LinkedList r0 = new LinkedList();
        this.a = r0;
        r0.add(new d());
        r0.add(new b());
        r0.add(new a());
    }

    public static String a(String r3) {
        Uri.Builder r0 = UriProtector.parse("liveresource://file").buildUpon();
        r0.scheme("liveresource").appendQueryParameter("path", r3);
        return r0.build().toString();
    }

    public final void b(String r5) {
        Iterator<ff1.a> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ff1.a r1 = r0.next();
        if ((r1 instanceof a) == false) goto L4;
        a r2 = (a) r1;
        r2.getClass();
        r2.a = r5 + File.separator;
        goto L4
    L8:
        String r3 = AnnieExternalServiceImpl.b;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        AnnieExternalServiceImpl.b = r5;
    }
}
