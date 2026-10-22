package com.bytedance.android.livesdk.chatroom.ui;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d9 {
    public Disposable a;
    public final List<c> b;
    public boolean c;
    public final long d;
    public final long e;

    public static final class a {
    }

    public interface b {
        boolean a(long r1, long r3, int r5);

        String getTag();
    }

    public static final class c {
        public final String a;
        public int b;
        public b c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L12;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((r2 * 31) + this.b) * 31;
            b r4 = this.c;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ListenerInfo(tag=" + this.a + ", successInvokeTimes=" + this.b + ", listener=" + this.c + ")";
        }

        public c(String r2, b r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.a = r2;
            this.b = 0;
            this.c = r3;
        }
    }

    static {
    }

    public final void b() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
        ((ArrayList) this.b).clear();
        this.c = true;
    }

    public final void a(b r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        if (this.c == false) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.b).iterator();
    L6:
        c r2 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((c) r1).a, r6.getTag()) == false) goto L6;
    L12:
        c r3 = (c) r1;
        if (r3 != null) goto L15;
        r2 = new c(r6.getTag(), r6);
    L16:
        if (r2 == null) goto L19;
        ((ArrayList) this.b).add(r2);
    L19:
        if (this.c == false) goto L21;
        return;
    L21:
        if (this.a != null) goto L29;
        com.bytedance.android.live.core.utils.rxutils.j.a r7 = com.bytedance.android.live.core.utils.rxutils.j.a;
        com.bytedance.android.live.core.utils.rxutils.j.a(0, this.e, TimeUnit.MILLISECONDS).take(this.d).observeOn(AndroidSchedulers.mainThread()).subscribe(new e9(this));
        return;
    L29:
        return;
    L15:
        r3.c = r6;
        goto L16
    L11:
        r1 = null;
        goto L12
    }

    public final void c(b r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        if (this.c == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.b.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((c) r1).a, r6.getTag()) == false) goto L7;
    L12:
        c r2 = (c) r1;
        if (r2 == null) goto L19;
        r2.c = null;
        return;
    L19:
        return;
    L11:
        r1 = null;
        goto L12
    }

    public d9(long r1, long r3) {
        this.d = r1;
        this.e = r3;
        this.b = new ArrayList();
    }
}
