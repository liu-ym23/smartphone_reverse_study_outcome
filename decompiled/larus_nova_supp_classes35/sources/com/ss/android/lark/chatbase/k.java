package com.ss.android.lark.chatbase;

import com.larus.apm.impl.protector.RunnableProtector;
import f5b.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q3b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k<T extends f5b.b> implements l<f5b.b> {
    public final BasePageStore<T, x4b.a<T>> a;
    public final x4b.d b;
    public final List<Function1<f5b.b, Boolean>> c;
    public final HashSet<String> d;

    public static final class a implements hya.a<f5b.b> {
        public final Function1<f5b.b, f5b.b> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super f5b.b, ? extends f5b.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            this.a = r2;
        }

        public final Object a(Object r2) {
            Function1<f5b.b, f5b.b> r0 = this.a;
            return (f5b.b) r0.invoke((f5b.b) r2);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ k<T> a;
        public final /* synthetic */ Function1<f5b.b, f5b.b> b;

        public static final class a implements hya.c<String, f5b.b> {
            public final /* synthetic */ f5b.b a;
            public final /* synthetic */ Function1<f5b.b, f5b.b> b;

            public final hya.a<f5b.b> a() {
                return new a(this.b);
            }

            public final hya.b<String> b() {
                return new o(this.a.getMessage());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(f5b.b r1, Function1<? super f5b.b, ? extends f5b.b> r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(k<T> r1, Function1<? super f5b.b, ? extends f5b.b> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            List<f5b.b> r0 = this.a.b();
            if (r0.isEmpty() == false) goto L7;
            f5b.b r1 = (f5b.b) this.b.invoke(null);
            if (r1 == null) goto L14;
            this.a.a.O(new o(r1.getMessage()), new BasePageStore.a(r1));
            return;
        L14:
            return;
        L7:
            ArrayList r2 = new ArrayList();
            Iterator<f5b.b> r3 = r0.iterator();
        L9:
            if (r3.hasNext() == false) goto L11;
            r2.add(new a(r3.next(), this.b));
            goto L9
        L11:
            this.a.a.l(r2);
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

    public final List<f5b.b> b() {
        if (this.d.isEmpty() == false) goto L5;
        List<T> r0 = this.a.s();
    L7:
        if (r0.isEmpty() == false) goto L10;
        Intrinsics.checkNotNull(r0);
        return r0;
    L10:
        ArrayList r1 = new ArrayList(r0);
        if ((!this.c.isEmpty()) == false) goto L21;
        Iterator r2 = ((ArrayList) this.c).iterator();
    L14:
        if (r2.hasNext() == false) goto L21;
        Function1 r3 = (Function1) r2.next();
        Iterator r4 = r1.iterator();
    L17:
        if (r4.hasNext() == false) goto L14;
        if (((Boolean) r3.invoke((f5b.b) r4.next())).booleanValue() == true) goto L17;
        r4.remove();
    L21:
        return r1;
    L5:
        r0 = this.a.w(this.d);
        goto L7
    }

    @Override // com.ss.android.lark.chatbase.l
    public final List<f5b.b> toList() {
        return b();
    }

    @Override // com.ss.android.lark.chatbase.l
    public final void a(Function1<? super f5b.b, ? extends f5b.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        this.b.execute(new b(this, r3));
    }

    @Override // com.ss.android.lark.chatbase.l
    public final k filter(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "filter");
        ((ArrayList) this.c).add(r2);
        return this;
    }

    @Override // com.ss.android.lark.chatbase.l
    public l<f5b.b> query(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.d.add(r2);
        return this;
    }

    public k(BasePageStore<T, x4b.a<T>> r2, x4b.d r3) {
        Intrinsics.checkNotNullParameter(r2, "dataStore");
        Intrinsics.checkNotNullParameter(r3, "executor");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
        this.d = new LinkedHashSet();
    }
}
