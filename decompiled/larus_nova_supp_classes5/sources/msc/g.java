package msc;

import java.util.ArrayList;
import java.util.Iterator;
import lsc.m$c;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g implements m$c<Text> {
    public final /* synthetic */ o a;

    public g(o r1) {
        this.a = r1;
    }

    @Override // lsc.m$c
    public final void a(lsc.m r5, uvc.b r6) {
        Text r7 = (Text) r6;
        String r0 = r7.h;
        r5.builder().c(r0);
        if (((ArrayList) this.a.a).isEmpty() == true) goto L9;
        int r1 = r5.length() - r0.length();
        Iterator r2 = ((ArrayList) this.a.a).iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        ((o.b) r2.next()).a(r5, r0, r1, r7);
    L9:
        if (((ArrayList) this.a.c).isEmpty() == true) goto L14;
        int r3 = r5.length() - r0.length();
        Iterator r4 = ((ArrayList) this.a.c).iterator();
    L12:
        if (r4.hasNext() == false) goto L17;
        ((o.a) r4.next()).a(r5, r7, r3);
        goto L12
    L17:
        return;
    }
}
