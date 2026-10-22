package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ KVRepo c;
    public final /* synthetic */ int d;

    public m(int r1, Ref.IntRef r2, KVRepo r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= this.a) goto L11;
        com.ss.android.lark.storage.kv.repo.a r3 = y.a;
        Pair r4 = y.a(this.b.element);
        if (r4 == null) goto L10;
        this.c.remove("index_" + this.b.element);
        if (r4.getSecond() == null) goto L10;
        r0.put(r4.getFirst(), r4.getSecond());
        this.c.remove((String) r4.getFirst());
    L10:
        Ref.IntRef r5 = this.b;
        r5.element = (r5.element + 1) % this.a;
        r2 = r2 + 1;
        goto L4
    L11:
        Set r6 = r0.entrySet();
        KVRepo r7 = this.c;
        int r8 = this.d;
        Iterator r9 = r6.iterator();
        int r10 = 0;
    L13:
        if (r9.hasNext() == false) goto L20;
        Map.Entry r11 = (Map.Entry) r9.next();
        String r12 = "index_" + r1;
        if (r7.a(r12, String.class) == false) goto L19;
        String r13 = r7.getString(r12, null);
        if (r13 == null) goto L19;
        r7.remove(r13);
    L19:
        r7.putJSONObject((String) r11.getKey(), r11.getValue());
        r7.putString(r12, (String) r11.getKey());
        r1 = (r1 + 1) % r8;
        r10 = Math.min(r10 + 1, r8);
        goto L13
    L20:
        y.d = r1;
        y.f = r10;
        y.e = this.d;
        this.c.putInt("IM_FILE_READ_HEAD", y.d);
        this.c.putInt("IM_FILE_READ_COUNT", y.f);
        this.c.putInt("IM_FILE_READ_MAX_CAPACITY", y.e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
