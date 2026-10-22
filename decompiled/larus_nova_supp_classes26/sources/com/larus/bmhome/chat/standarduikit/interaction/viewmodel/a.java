package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a e = null;
    public final int a;
    public final LinkedHashSet<b> b;
    public final Map<b, Integer> c;
    public final Map<b, Function0<Unit>> d;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0008a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "Key(accountId=" + this.a + ", conversationId=" + this.b + ", messageId=" + this.c + ", blockId=" + this.d + ')';
        }

        public b(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "accountId");
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r4, "messageId");
            Intrinsics.checkNotNullParameter(r5, "blockId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        e = new a();
    }

    public a() {
        this.a = 512;
        this.b = new LinkedHashSet();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    public final synchronized boolean a(b r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "key");     // Catch: Throwable -> L16
        if (this.b.add(r2) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        this.d.remove(r2);     // Catch: Throwable -> L16
    L10:
        if (this.b.size() <= this.a) goto L13;
        Iterator<b> r3 = this.b.iterator();     // Catch: Throwable -> L16
        r3.next();     // Catch: Throwable -> L16
        r3.remove();     // Catch: Throwable -> L16
        goto L10
    L13:
        monitor-exit(this);
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    public final void b(b r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        monitor-enter(this);
        Integer r0 = (Integer) ((LinkedHashMap) this.c).get(r3);     // Catch: Throwable -> L21
        if (r0 == null) goto L19;
        int r1 = r0.intValue() - 1;     // Catch: Throwable -> L21
        if (r1 <= 0) goto L9;
        this.c.put(r3, Integer.valueOf(r1));     // Catch: Throwable -> L21
    L14:
        Function0<Unit> r2 = null;
    L15:
        monitor-exit(this);
        if (r2 == null) goto L25;
        r2.invoke();
        return;
    L25:
        return;
    L9:
        this.c.remove(r3);     // Catch: Throwable -> L21
        r2 = this.d.remove(r3);     // Catch: Throwable -> L21
        if (r2 == null) goto L14;
        if (this.b.contains(r3) == true) goto L14;
    L19:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
