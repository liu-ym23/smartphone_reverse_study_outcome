package com.bytedance.badger.t;

import com.bytedance.badger.NativeBridge;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final o a;
    public final int b;

    public c(int r1) {
        this.b = r1;
        this.a = new o();
    }

    public final void b(int r2) {
        this.a.a(r2);
    }

    public final void c(String r3) {
        if (r3.getBytes(Charsets.UTF_8).length <= 65535) goto L6;
        this.a.c("");
        com.bytedance.badger.e.e("NativeRequestBuilder", "String length exceeds 65535 characters");
        return;
    L6:
        this.a.c(r3);
    }

    public final d a(Object r10) {
        int r0 = this.b;
        byte[] r1 = this.a.a.toByteArray();
        ByteBuffer r2 = ByteBuffer.allocate(r1.length + 10);
        ByteOrder r3 = ByteOrder.BIG_ENDIAN;
        ByteBuffer r4 = r2.order(r3);
        r4.put((byte) 1);
        r4.put((byte) 0);
        r4.putInt(r0);
        r4.putInt(r1.length);
        r4.put(r1);
        byte[] r5 = r4.array();
        int r6 = a.a;
        byte[] r12 = NativeBridge.a.a(r5, r10);     // Catch: Throwable -> L14
        if (r12 != null) goto L22;
        com.bytedance.badger.e.e("NativeBridge", "native method returned null");
        return new d(0, CollectionsKt.listOf(new l[]{new g(-1), new k("Native returned null")}), new byte[0]);
    L22:
        ByteBuffer r7 = ByteBuffer.wrap(r12).order(r3);     // Catch: Throwable -> L12
        r7.get();     // Catch: Throwable -> L12
        r7.get();     // Catch: Throwable -> L12
        int r8 = r7.getInt();     // Catch: Throwable -> L12
        byte[] r9 = new byte[r7.getInt()];     // Catch: Throwable -> L12
        r7.get(r9);     // Catch: Throwable -> L12
        m r13 = new m(r9);     // Catch: Throwable -> L12
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L12
    L8:
        if (r13.a.hasRemaining() == false) goto L10;
        r14.add(r13.b());     // Catch: Throwable -> L12
        goto L8
    L10:
        d r15 = new d(r8, r14, r12);     // Catch: Throwable -> L12
    L21:
        return r15;
    L12:
        th = move-exception;
        com.bytedance.badger.e.c("NativeBridge", "parse result payload error", th);
        return new d(0, CollectionsKt.listOf(new l[]{new g(-1), new k("Parse result error: " + th.getMessage())}), r12);
    L14:
        th = move-exception;
        com.bytedance.badger.e.c("NativeBridge", "call native method error", th);
        l[] r16 = new l[2];
        r16[0] = new g(-1);
        String r17 = th.getMessage();
        if (r17 != null) goto L19;
        r17 = "Unknown error";
    L19:
        r16[1] = new k(r17);
        r15 = new d(0, CollectionsKt.listOf(r16), new byte[0]);
        goto L21
    }

    public final void d(List r5) {
        this.a.a.write(32);
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L34;
        Object r0 = r6.next();
        if ((r0 instanceof Integer) == true) goto L7;
        if ((r0 instanceof Long) == true) goto L10;
        if ((r0 instanceof Boolean) == true) goto L13;
        if ((r0 instanceof String) == true) goto L16;
        if ((r0 instanceof byte[]) == true) goto L19;
        if ((r0 instanceof List) == true) goto L22;
        if ((r0 instanceof n) == false) goto L33;
        this.a.a.write(16);
        ((n) r0).a(this.a);
        this.a.a.write(17);
        goto L4
    L33:
        throw new IllegalArgumentException("Unsupported type in list: ".concat(r0.getClass().getSimpleName()));
    L22:
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((Iterable) r0).iterator();
    L24:
        if (r2.hasNext() == false) goto L28;
        Object r3 = r2.next();
        if ((r3 instanceof Object) == false) goto L24;
        r1.add(r3);
        goto L24
    L28:
        d(r1);
        goto L4
    L19:
        o r4 = this.a;
        r4.d((byte[]) r0);
        goto L4
    L16:
        c((String) r0);
        goto L4
    L13:
        boolean r7 = ((Boolean) r0).booleanValue();
        o r8 = this.a;
        r8.a.write(5);
        r8.a.write(r7 ? 1 : 0);
        goto L4
    L10:
        long r9 = ((Number) r0).longValue();
        this.a.b(r9);
        goto L4
    L7:
        int r10 = ((Number) r0).intValue();
        this.a.a(r10);
        goto L4
    L34:
        this.a.a.write(33);
    }
}
