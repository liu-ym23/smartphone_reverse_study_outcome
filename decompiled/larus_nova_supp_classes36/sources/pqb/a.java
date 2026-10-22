package pqb;

import com.ss.android.agilelogger.utils.FormatUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements nra.a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void b() {
    }

    public final Queue<nra.d> a() {
        Queue r0 = com.suite.component.logger.f.a.a();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        com.suite.component.logger.c r3 = (com.suite.component.logger.c) r2.next();
        nra.d r4 = new nra.d();
        r4.a = r3.a.getValue();
        r4.b = r3.b;
        r4.c = r3.c;
        String.valueOf(r3.i);
        r4.d = FormatUtils.TYPE.MSG;
        r1.add(r4);
        goto L4
    L7:
        return new LinkedList(r1);
    }
}
