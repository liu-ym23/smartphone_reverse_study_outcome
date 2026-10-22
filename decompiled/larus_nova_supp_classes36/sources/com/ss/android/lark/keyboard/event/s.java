package com.ss.android.lark.keyboard.event;

import java.util.LinkedList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class s<T> {
    public final Function0<T> a;
    public final LinkedList<T> b;
    public int c;

    public static final class a {
    }

    public interface b {
        void recycle();
    }

    static {
    }

    public final T a() {
        T r0 = this.b.poll();
        if (r0 != null) goto L7;
        r0 = (T) this.a.invoke();
        int r1 = this.c;
        if (r1 >= 3) goto L7;
        this.c = r1 + 1;
    L7:
        return r0;
    }

    public s(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "constructor");
        this.a = r2;
        this.b = new LinkedList();
    }
}
