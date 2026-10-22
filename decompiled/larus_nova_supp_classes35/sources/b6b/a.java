package b6b;

import com.ss.android.lark.newemoji.larkemoji.b;
import com.ss.android.lark.newemoji.larkemoji.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(List r6, s5c.a r7) {
        Intrinsics.checkNotNullParameter(r6, "reactionList");
        Intrinsics.checkNotNullParameter(r7, "tab");
        ArrayList r0 = new ArrayList();
        boolean r1 = Intrinsics.areEqual(r7, n3.d);
        ArrayList r2 = new ArrayList();
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        String r3 = (String) r8.next();
        ReentrantLock r4 = c.a;
        Intrinsics.checkNotNullParameter(r3, "id");
        r2.add(new b(r3, c.a(r3)));
        goto L4
    L6:
        ArrayList r9 = new ArrayList();
        Iterator r5 = r2.iterator();
    L7:
        int r10 = 0;
        if (r5.hasNext() == false) goto L12;
        Object r11 = r5.next();
        if (((com.ss.android.lark.newemoji.larkemoji.a) r11).c(false) == false) goto L7;
        r9.add(r11);
        goto L7
    L12:
        Iterator r12 = r9.iterator();
    L14:
        if (r12.hasNext() == false) goto L19;
        Object r13 = r12.next();
        int r14 = r10 + 1;
        if (r10 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        r0.add(new ssb.b.c((com.ss.android.lark.newemoji.larkemoji.a) r13, r1, r7, Integer.valueOf(r14)));
        r10 = r14;
        goto L14
    L19:
        return r0;
    }
}
