package com.bytedance.android.anniex.scene.handler.idle;

import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c<T> implements Comparable<c<T>> {
    public final String a;
    public final TaskType b;
    public final String c;
    public final String d;
    public final int e;
    public final long f;
    public final boolean g;
    public final T h;
    public final Long i;

    public static final class a<T> {
        public String a;
        public String b;
        public int c;
        public long d;
        public long e;
        public boolean f;
        public T g;
        public Function1<? super T, Unit> h;

        public a() {
        }

        public final b a(TaskType r15) {
            Intrinsics.checkNotNullParameter(r15, "taskType");
            return new b(r15, this, UUID.randomUUID().toString(), this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }

    public c() {
        throw null;
    }

    public abstract void a(T r1);

    public final T getContext() {
        return this.h;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r10) {
        c r11 = (c) r10;
        Intrinsics.checkNotNullParameter(r11, "other");
        return Intrinsics.compare(r11.e, this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r1, TaskType r10, String r11, String r12, int r13, long r14, long r15, boolean r16, Object r17) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        if (r14 <= 0) goto L5;
        Long r18 = Long.valueOf(System.currentTimeMillis() + r14);
    L6:
        this.i = r18;
        return;
    L5:
        r18 = null;
        goto L6
    }
}
