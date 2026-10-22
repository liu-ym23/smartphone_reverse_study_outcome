package msc;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Image;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p extends o {
    public static final lsc.q<String> d = null;

    public static final class a {
    }

    @Override // msc.o, lsc.a, lsc.j
    public final void a(TextView r1, uvc.b r2, lsc.p r3) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r3, "visitor");
    }

    @Override // msc.o, lsc.a, lsc.j
    public final void d(CharSequence r1, uvc.b r2, lsc.p r3) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r3, "visitor");
    }

    static {
        d = new lsc.q("link-title");
    }

    public p() {
    }

    @Override // msc.o, lsc.a, lsc.j
    public final void c(lsc.p$a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        super.c(r3);
        r3.a(Link.class, q.a);
        r3.a(Image.class, new r(this));
    }
}
