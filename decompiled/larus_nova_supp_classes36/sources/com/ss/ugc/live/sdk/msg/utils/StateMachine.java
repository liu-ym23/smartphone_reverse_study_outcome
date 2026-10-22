package com.ss.ugc.live.sdk.msg.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class StateMachine<STATE, EVENT, SIDE_EFFECT> {
    public static final a c = null;
    public final AtomicReference<STATE> a;
    public final b<STATE, EVENT, SIDE_EFFECT> b;

    public static final class GraphBuilder<STATE, EVENT, SIDE_EFFECT> {
        public STATE a;
        public final LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> b;
        public final ArrayList<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> c;

        public final class StateDefinitionBuilder<S extends STATE> {
            public final b.a<STATE, EVENT, SIDE_EFFECT> a;

            public StateDefinitionBuilder() {
                this.a = new b.a();
            }

            public final <E extends EVENT> void a(Matcher<EVENT, ? extends E> r3, final Function2<? super S, ? super E, ? extends b.a.C0232a<? extends STATE, ? extends SIDE_EFFECT>> r4) {
                Intrinsics.checkNotNullParameter(r3, "eventMatcher");
                Intrinsics.checkNotNullParameter(r4, "createTransitionTo");
                this.a.c.put((Matcher<EVENT, EVENT>) r3, (Function2<STATE, EVENT, b.a.C0232a<STATE, SIDE_EFFECT>>) new StateMachine$GraphBuilder$StateDefinitionBuilder$on$1(r4));
            }

            public static b.a.C0232a b(Object r1, Object r2, Object r3) {
                Intrinsics.checkNotNullParameter(r1, "$this$transitionTo");
                Intrinsics.checkNotNullParameter(r2, "state");
                return new b.a.C0232a(r2, r3);
            }
        }

        public GraphBuilder() {
            this(null);
        }

        public GraphBuilder(b<STATE, EVENT, SIDE_EFFECT> r3) {
            if (r3 == null) goto L5;
            STATE r0 = r3.a;
        L6:
            this.a = r0;
            if (r3 == null) goto L11;
            Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r1 = r3.b;
            if (r1 == null) goto L11;
        L12:
            this.b = new LinkedHashMap(r1);
            if (r3 == null) goto L17;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r4 = r3.c;
            if (r4 == null) goto L17;
        L18:
            this.c = new ArrayList(r4);
            return;
        L17:
            r4 = CollectionsKt.emptyList();
        L11:
            r1 = MapsKt.emptyMap();
            goto L12
        L5:
            r0 = null;
            goto L6
        }

        public final void a(STATE r2) {
            Intrinsics.checkNotNullParameter(r2, "initialState");
            this.a = r2;
        }

        public final void b(Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.c.add(r2);
        }

        public final <S extends STATE> void c(Matcher<STATE, ? extends S> r3, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "stateMatcher");
            Intrinsics.checkNotNullParameter(r4, "init");
            LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r0 = this.b;
            StateDefinitionBuilder r1 = new StateDefinitionBuilder();
            r4.invoke(r1);
            r0.put(r3, r1.a);
        }
    }

    public static final class Matcher<T, R extends T> {
        public static final /* synthetic */ int c = 0;
        public final List<Function1<T, Boolean>> a;
        public final Class<R> b;

        public static final class a {
            public static Matcher a(Class r1) {
                Intrinsics.checkNotNullParameter(r1, "clazz");
                return new Matcher(r1);
            }
        }

        static {
        }

        public Matcher() {
            throw null;
        }

        public Matcher(Class r3) {
            this.b = r3;
            this.a = CollectionsKt.mutableListOf(new Function1[]{new StateMachine$Matcher$predicates$1(this)});
        }

        public final boolean a(T r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            List<Function1<T, Boolean>> r0 = this.a;
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L18;
            if (((Boolean) ((Function1) r1.next()).invoke(r4)).booleanValue() == true) goto L9;
            return false;
        L18:
            return true;
        L5:
            if (r0.isEmpty() == false) goto L7;
            return true;
        }
    }

    public static final class a {
        public a() {
        }

        public static StateMachine a(Function1 r4) {
            Intrinsics.checkNotNullParameter(r4, "init");
            GraphBuilder r1 = new GraphBuilder(null);
            r4.invoke(r1);
            STATE r2 = r1.a;
            if (r2 == null) goto L7;
            return new StateMachine(new b(r2, MapsKt.toMap(r1.b), CollectionsKt.toList(r1.c)));
        L7:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final class b<STATE, EVENT, SIDE_EFFECT> {
        public final STATE a;
        public final Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> b;
        public final List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> c;

        public static final class a<STATE, EVENT, SIDE_EFFECT> {
            public final List<Function2<STATE, EVENT, Unit>> a;
            public final List<Function2<STATE, EVENT, Unit>> b;
            public final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, C0232a<STATE, SIDE_EFFECT>>> c;

            /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.utils.StateMachine$b$a$a, reason: collision with other inner class name */
            public static final class C0232a<STATE, SIDE_EFFECT> {
                public final STATE a;
                public final SIDE_EFFECT b;

                public final boolean equals(Object r3) {
                    if (this != r3) goto L4;
                    return true;
                L4:
                    if ((r3 instanceof C0232a) == false) goto L10;
                    C0232a r4 = (C0232a) r3;
                    if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                    return false;
                L8:
                    if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
                    return false;
                L16:
                    return true;
                L10:
                    return false;
                }

                public final int hashCode() {
                    STATE r0 = this.a;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = r0.hashCode();
                L6:
                    int r3 = r2 * 31;
                    SIDE_EFFECT r4 = this.b;
                    if (r4 == null) goto L10;
                    r1 = r4.hashCode();
                L10:
                    return r3 + r1;
                L5:
                    r2 = 0;
                    goto L6
                }

                public final String toString() {
                    return "TransitionTo(toState=" + this.a + ", sideEffect=" + this.b + ")";
                }

                public C0232a(STATE r2, SIDE_EFFECT r3) {
                    Intrinsics.checkNotNullParameter(r2, "toState");
                    this.a = r2;
                    this.b = r3;
                }
            }

            public a() {
                this.a = new ArrayList();
                this.b = new ArrayList();
                this.c = new LinkedHashMap();
            }
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L12;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
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
            STATE r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Graph(initialState=" + this.a + ", stateDefinitions=" + this.b + ", onTransitionListeners=" + this.c + ")";
        }

        public b(STATE r2, Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> r3, List<? extends Function1<? super c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r4) {
            Intrinsics.checkNotNullParameter(r2, "initialState");
            Intrinsics.checkNotNullParameter(r3, "stateDefinitions");
            Intrinsics.checkNotNullParameter(r4, "onTransitionListeners");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static abstract class c<STATE, EVENT, SIDE_EFFECT> {

        public static final class a<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {
            public final STATE a;
            public final EVENT b;

            public final int hashCode() {
                STATE r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                EVENT r4 = this.b;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "Invalid(fromState=" + this.a + ", event=" + this.b + ")";
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof a) == false) goto L10;
                a r4 = (a) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public a(STATE r2, EVENT r3) {
                Intrinsics.checkNotNullParameter(r2, "fromState");
                Intrinsics.checkNotNullParameter(r3, "event");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class b<STATE, EVENT, SIDE_EFFECT> extends c<STATE, EVENT, SIDE_EFFECT> {
            public final STATE a;
            public final EVENT b;
            public final STATE c;
            public final SIDE_EFFECT d;

            public final int hashCode() {
                STATE r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                EVENT r4 = this.b;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                STATE r7 = this.c;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                SIDE_EFFECT r10 = this.d;
                if (r10 == null) goto L18;
                r1 = r10.hashCode();
            L18:
                return r9 + r1;
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "Valid(fromState=" + this.a + ", event=" + this.b + ", toState=" + this.c + ", sideEffect=" + this.d + ")";
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof b) == false) goto L14;
                b r4 = (b) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public b(STATE r2, EVENT r3, STATE r4, SIDE_EFFECT r5) {
                Intrinsics.checkNotNullParameter(r2, "fromState");
                Intrinsics.checkNotNullParameter(r3, "event");
                Intrinsics.checkNotNullParameter(r4, "toState");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
            }
        }

        public c() {
        }
    }

    static {
        c = new a();
    }

    public final STATE b() {
        return this.a.get();
    }

    public StateMachine(b r2) {
        this.b = r2;
        this.a = new AtomicReference(r2.a);
    }

    public final b.a<STATE, EVENT, SIDE_EFFECT> a(STATE r5) {
        Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r0 = this.b.b;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r3 = r2.next();
        if (r3.getKey().a(r5) == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        ArrayList r4 = new ArrayList(r1.size());
        Iterator r6 = r1.entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r4.add((b.a) ((Map.Entry) r6.next()).getValue());
        goto L10
    L12:
        b.a<STATE, EVENT, SIDE_EFFECT> r7 = (b.a) CollectionsKt.firstOrNull(r4);
        if (r7 == null) goto L16;
        return r7;
    L16:
        throw new IllegalStateException(("Missing definition for state " + r5.getClass().getSimpleName() + '!').toString());
    }

    public final void d(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        monitor-enter(this);
        c<STATE, EVENT, SIDE_EFFECT> r0 = c(this.a.get(), r5);     // Catch: Throwable -> L23
        if ((r0 instanceof c.b) == false) goto L7;
        this.a.set(((c.b) r0).c);     // Catch: Throwable -> L23
    L7:
        monitor-exit(this);
        Iterator<T> r1 = this.b.c.iterator();
    L10:
        if (r1.hasNext() == false) goto L13;
        ((Function1) r1.next()).invoke(r0);
        goto L10
    L13:
        if ((r0 instanceof c.b) == false) goto L22;
        c.b r2 = (c.b) r0;
        STATE r3 = r2.a;
        Iterator r4 = ((ArrayList) a(r3).b).iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        ((Function2) r4.next()).invoke(r3, r5);
        goto L16
    L18:
        STATE r6 = r2.c;
        Iterator r7 = ((ArrayList) a(r6).a).iterator();
    L20:
        if (r7.hasNext() == false) goto L31;
        ((Function2) r7.next()).invoke(r6, r5);
        goto L20
    L31:
        return;
    L22:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final c<STATE, EVENT, SIDE_EFFECT> c(STATE r4, EVENT r5) {
        Iterator<Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C0232a<STATE, SIDE_EFFECT>>>> r0 = a(r4).c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C0232a<STATE, SIDE_EFFECT>>> r1 = r0.next();
        Matcher<EVENT, EVENT> r2 = r1.getKey();
        Function2<STATE, EVENT, b.a.C0232a<STATE, SIDE_EFFECT>> r3 = r1.getValue();
        if (r2.a(r5) == false) goto L4;
        b.a.C0232a r6 = (b.a.C0232a) r3.invoke(r4, r5);
        return new c.b(r4, r5, r6.a, r6.b);
    L10:
        return new c.a(r4, r5);
    }
}
