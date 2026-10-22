package v7;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: v7.a$a, reason: collision with other inner class name */
    public interface InterfaceC0180a<A, B> {
        boolean equals(A r8, B r10);
    }

    public static void a(ConcurrentLinkedQueue r8, Object r10, InterfaceC0180a r11) {
        Iterator r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        if (r11.equals(r12.next(), r10) == false) goto L4;
        r12.remove();
        goto L4
    }
}
