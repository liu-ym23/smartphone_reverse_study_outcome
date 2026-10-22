package yd8;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements td8.c {
    public final td8.d a;

    public static final class a {
    }

    static {
    }

    public c(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        if (this.a.d() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r6, xc8.b r7, xc8.b r8, List<xc8.b> r9) {
        Intrinsics.checkNotNullParameter(r8, "current");
        Intrinsics.checkNotNullParameter(r9, "input");
        int r10 = this.a.d();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r9.iterator();
    L4:
        if (r12.hasNext() == false) goto L26;
        Object r0 = r12.next();
        Message r1 = ((xc8.b) r0).getMessage();
        boolean r3 = false;
        if (com.larus.bmhome.chat.bean.d.O0(r1) == true) goto L9;
    L24:
        if (r3 == true) goto L4;
        r11.add(r0);
        goto L4
    L9:
        if (r10 == 0) goto L23;
        if (r10 != 1) goto L12;
        r3 = com.larus.bmhome.chat.bean.d.k0(r1);
        goto L24
    L12:
        if (r10 != 2) goto L14;
        r3 = com.larus.bmhome.chat.bean.d.W0(r1);
        goto L24
    L14:
        if (r10 != 3) goto L24;
        if (com.larus.bmhome.chat.bean.d.k0(r1) == true) goto L23;
        if (com.larus.bmhome.chat.bean.d.W0(r1) == false) goto L24;
    L23:
        r3 = true;
        goto L24
    L26:
        List<xc8.b> r13 = CollectionsKt.toMutableList(r11);
        FLogger.a.i("PromptFilterTask", "filter prompt, type=" + r10 + ", before=" + r9.size() + ", after=" + r13.size());
        return r13;
    }
}
