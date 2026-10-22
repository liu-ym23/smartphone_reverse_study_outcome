package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SkillSearchIndex {
    public final Object a;
    public final LinkedHashMap<c, b> b;
    public String c;
    public long d;

    public static final class a {
    }

    public static final class b {
        public final p1 a;
        public final p1 b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Entry(title=" + this.a + ", description=" + this.b + ')';
        }

        public b(p1 r2, p1 r3) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, "description");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Key(skillId=" + this.a + ", name=" + this.b + ", description=" + this.c + ')';
        }

        public c(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "skillId");
            Intrinsics.checkNotNullParameter(r3, "name");
            Intrinsics.checkNotNullParameter(r4, "description");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public final void a() {
        Object r0 = this.a;
        monitor-enter(r0);
        this.b.clear();     // Catch: Throwable -> L7
        this.c = null;     // Catch: Throwable -> L7
        this.d++;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public SkillSearchIndex() {
        this.a = new Object();
        this.b = new LinkedHashMap(16, 0.75f, true);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x011d -> B:66:0x01ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x016a -> B:53:0x016f). Please report as a decompilation issue!!! */
    public final Object b(String r19, List<be8.b> r20, String r21, Continuation<? super List<t1>> r22) {
        if ((r22 instanceof SkillSearchIndex$search$1) == false) goto L7;
        SkillSearchIndex$search$1 r3 = (SkillSearchIndex$search$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        long r8 = r3.J$0;
        p1 r0 = (p1) r3.L$7;
        c r7 = (c) r3.L$6;
        be8.b r10 = (be8.b) r3.L$5;
        Iterator<be8.b> r11 = (Iterator) r3.L$4;
        List r12 = (List) r3.L$3;
        List r13 = (List) r3.L$2;
        String r14 = (String) r3.L$1;
        CoroutineContext r15 = (CoroutineContext) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r9 = r2;
        SkillSearchIndex r16 = this;
    L53:
        b r17 = new b(r0, (p1) r9);
        Object r18 = r16.a;
        monitor-enter(r18);
        if (r16.d != r8) goto L60;
        r16.b.put(r7, r17);     // Catch: Throwable -> L63
        if (r16.b.size() <= 1000) goto L60;
        Iterator<Map.Entry<c, b>> r1 = r16.b.entrySet().iterator();     // Catch: Throwable -> L63
        r1.next();     // Catch: Throwable -> L63
        r1.remove();     // Catch: Throwable -> L63
    L60:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r18);
        List r24 = r13;
        String r25 = r14;
        be8.b r110 = r10;
        long r26 = r8;
        List r27 = r12;
        SkillSearchIndex r111 = r16;
        CoroutineContext r28 = r15;
        b r112 = r17;
    L66:
        int r29 = u1.a;
        List r30 = u1.c(r112.a, r25);
        List r31 = u1.c(r112.b, r25);
        if ((!r30.isEmpty()) == false) goto L69;
    L70:
        r27.add(new t1(r110, r30, r31));
    L25:
        if (r11.hasNext() == false) goto L76;
        r110 = r11.next();
        JobKt.ensureActive(r28);
        if (r25.length() != 0) goto L29;
        boolean r113 = true;
    L30:
        if (r113 == false) goto L32;
        r27.add(new t1(r110, CollectionsKt.emptyList(), CollectionsKt.emptyList()));
        goto L25
    L32:
        c r32 = new c(r110.a, r110.b, r110.d);
        Object r33 = r111.a;
        monitor-enter(r33);
        b r114 = r111.b.get(r32);     // Catch: Throwable -> L72
        b r115 = r114;     // Catch: Throwable -> L72
        if (r111.d != r26) goto L37;
        boolean r116 = true;
    L39:
        if (r116 == false) goto L41;
        b r117 = r114;
    L42:
        r112 = r117;     // Catch: Throwable -> L72
        monitor-exit(r33);
        if (r112 != null) goto L66;
        int r34 = p1.f;
        String r35 = r110.b;
        r3.L$0 = r28;
        r3.L$1 = r25;
        r3.L$2 = r24;
        r3.L$3 = r27;
        r3.L$4 = r11;
        r3.L$5 = r110;
        r3.L$6 = r32;
        r3.L$7 = null;
        r3.J$0 = r26;
        r3.label = 1;
        p1 r36 = p1.a.a(r35, r3);
        if (r36 != r5) goto L48;
        return r5;
    L48:
        r14 = r25;
        r15 = r28;
        r2 = r36;
        SkillSearchIndex r37 = r111;
        r12 = r27;
        r8 = r26;
        r10 = r110;
        r13 = r24;
        r7 = r32;
    L49:
        p1 r38 = (p1) r2;
        int r39 = p1.f;
        String r40 = r10.d;
        r3.L$0 = r15;
        r3.L$1 = r14;
        r3.L$2 = r13;
        r3.L$3 = r12;
        r3.L$4 = r11;
        r3.L$5 = r10;
        r3.L$6 = r7;
        r3.L$7 = r38;
        r3.J$0 = r8;
        r3.label = 2;
        r9 = p1.a.a(r40, r3);
        if (r9 != r5) goto L52;
        return r5;
    L52:
        r16 = r37;
        r0 = r38;
        goto L53
    L41:
        r117 = null;
        goto L42
    L37:
        r116 = false;
    L72:
        th = move-exception;
        throw th;
    L29:
        r113 = false;
        goto L30
    L76:
        return CollectionsKt.build(r24);
    L69:
        if ((!r31.isEmpty()) == false) goto L25;
    L63:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = r3.J$0;
        c r41 = (c) r3.L$6;
        be8.b r42 = (be8.b) r3.L$5;
        Iterator<be8.b> r118 = (Iterator) r3.L$4;
        List r119 = (List) r3.L$3;
        List r120 = (List) r3.L$2;
        String r121 = (String) r3.L$1;
        CoroutineContext r122 = (CoroutineContext) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r15 = r122;
        r14 = r121;
        r13 = r120;
        r12 = r119;
        r11 = r118;
        r10 = r42;
        r7 = r41;
        r37 = this;
        goto L49
    L16:
        ResultKt.throwOnFailure(r2);
        r28 = r3.getContext();
        JobKt.ensureActive(r28);
        Object r43 = this.a;
        monitor-enter(r43);
    L77:
        th = move-exception;
        throw th;
    L19:
        if (Intrinsics.areEqual(this.c, r19) == true) goto L21;
        this.b.clear();     // Catch: Throwable -> L77
        this.c = r19;     // Catch: Throwable -> L77
        this.d++;     // Catch: Throwable -> L77
    L21:
        long r44 = this.d;     // Catch: Throwable -> L77
        monitor-exit(r43);
        r25 = StringsKt.trim(r21).toString();
        r24 = CollectionsKt.createListBuilder();
        r111 = this;
        r11 = r20.iterator();
        r26 = r44;
        r27 = r24;
    L7:
        r3 = new SkillSearchIndex$search$1(this, r22);
        goto L8
    }
}
