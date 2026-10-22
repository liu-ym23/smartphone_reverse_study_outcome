package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class StateMachine<STATE, EVENT, SIDE_EFFECT> {
    public static final /* synthetic */ int c = 0;
    public final b<STATE, EVENT, SIDE_EFFECT> a;
    public final AtomicReference<STATE> b;

    public static final class GraphBuilder<STATE, EVENT, SIDE_EFFECT> {
        public STATE a;
        public final LinkedHashMap<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> b;
        public final ArrayList<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> c;

        public final class StateDefinitionBuilder<S extends STATE> {
            public final b.a<STATE, EVENT, SIDE_EFFECT> a;

            public StateDefinitionBuilder() {
                this.a = new b.a();
            }

            public final <E extends EVENT> void a(Matcher<EVENT, ? extends E> r3, final Function2<? super S, ? super E, ? extends b.a.C0035a<? extends STATE, ? extends SIDE_EFFECT>> r4) {
                Intrinsics.checkNotNullParameter(r3, "eventMatcher");
                Intrinsics.checkNotNullParameter(r4, "createTransitionTo");
                this.a.c.put((Matcher<EVENT, EVENT>) r3, (Function2<STATE, EVENT, b.a.C0035a<STATE, SIDE_EFFECT>>) new StateMachine$GraphBuilder$StateDefinitionBuilder$on$1(r4));
            }

            public static b.a.C0035a b(Object r1, Object r2, Object r3) {
                Intrinsics.checkNotNullParameter(r1, "<this>");
                Intrinsics.checkNotNullParameter(r2, "state");
                return new b.a.C0035a(r2, r3);
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
            if (r3 == null) goto L10;
            Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r1 = r3.b;
            if (r1 == null) goto L10;
        L11:
            this.b = new LinkedHashMap(r1);
            if (r3 == null) goto L16;
            List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> r4 = r3.c;
            if (r4 == null) goto L16;
        L17:
            this.c = new ArrayList(r4);
            return;
        L16:
            r4 = CollectionsKt.emptyList();
        L10:
            r1 = MapsKt.emptyMap();
            goto L11
        L5:
            r0 = null;
            goto L6
        }

        public final <S extends STATE> void a(Matcher<STATE, ? extends S> r3, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> r4) {
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
        public final Class<R> a;
        public final List<Function1<T, Boolean>> b;

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
            this.a = r3;
            this.b = CollectionsKt.mutableListOf(new Function1[]{new StateMachine$Matcher$predicates$1(this)});
        }

        public final boolean a(T r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            List<Function1<T, Boolean>> r0 = this.b;
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
    }

    public static final class b<STATE, EVENT, SIDE_EFFECT> {
        public final STATE a;
        public final Map<Matcher<STATE, STATE>, a<STATE, EVENT, SIDE_EFFECT>> b;
        public final List<Function1<c<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> c;

        public static final class a<STATE, EVENT, SIDE_EFFECT> {
            public final List<Function2<STATE, EVENT, Unit>> a;
            public final List<Function2<STATE, EVENT, Unit>> b;
            public final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, C0035a<STATE, SIDE_EFFECT>>> c;

            /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.StateMachine$b$a$a, reason: collision with other inner class name */
            public static final class C0035a<STATE, SIDE_EFFECT> {
                public final STATE a;
                public final SIDE_EFFECT b;

                public final boolean equals(Object r5) {
                    if (this != r5) goto L6;
                    return true;
                L6:
                    if ((r5 instanceof C0035a) == true) goto L8;
                    return false;
                L8:
                    C0035a r6 = (C0035a) r5;
                    if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                    return false;
                L12:
                    if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                    return false;
                L14:
                    return true;
                }

                public final int hashCode() {
                    int r0 = this.a.hashCode() * 31;
                    SIDE_EFFECT r1 = this.b;
                    if (r1 != null) goto L5;
                    int r2 = 0;
                L7:
                    return r0 + r2;
                L5:
                    r2 = r1.hashCode();
                    goto L7
                }

                public final String toString() {
                    return "TransitionTo(toState=" + this.a + ", sideEffect=" + this.b + ')';
                }

                public C0035a(STATE r2, SIDE_EFFECT r3) {
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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Graph(initialState=" + this.a + ", stateDefinitions=" + this.b + ", onTransitionListeners=" + this.c + ')';
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

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
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
                return "Invalid(fromState=" + this.a + ", event=" + this.b + ')';
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
                int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
                SIDE_EFFECT r1 = this.d;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "Valid(fromState=" + this.a + ", event=" + this.b + ", toState=" + this.c + ", sideEffect=" + this.d + ')';
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
    }

    public StateMachine(b r2) {
        this.a = r2;
        this.b = new AtomicReference(r2.a);
    }

    public final b.a<STATE, EVENT, SIDE_EFFECT> a(STATE r5) {
        Map<Matcher<STATE, STATE>, b.a<STATE, EVENT, SIDE_EFFECT>> r0 = this.a.b;
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

    public final c<STATE, EVENT, SIDE_EFFECT> b(STATE r4, EVENT r5) {
        Iterator<Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C0035a<STATE, SIDE_EFFECT>>>> r0 = a(r4).c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, b.a.C0035a<STATE, SIDE_EFFECT>>> r1 = r0.next();
        Matcher<EVENT, EVENT> r2 = r1.getKey();
        Function2<STATE, EVENT, b.a.C0035a<STATE, SIDE_EFFECT>> r3 = r1.getValue();
        if (r2.a(r5) == false) goto L4;
        b.a.C0035a r6 = (b.a.C0035a) r3.invoke(r4, r5);
        return new c.b(r4, r5, r6.a, r6.b);
    L10:
        return new c.a(r4, r5);
    }
}
