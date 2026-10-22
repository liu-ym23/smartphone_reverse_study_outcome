package com.ss.android.lark.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import v7b.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LinkReferenceDefinitionParser {
    public State a;
    public final List<w7b.f> b;
    public final List<v7b.o> c;
    public final List<x> d;
    public StringBuilder e;
    public String f;
    public char g;
    public StringBuilder h;
    public boolean i;

    public static final enum State extends Enum<State> {
        public static final State DESTINATION = null;
        public static final State LABEL = null;
        public static final State PARAGRAPH = null;
        public static final State START_DEFINITION = null;
        public static final State START_TITLE = null;
        public static final State TITLE = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r0 = new State("START_DEFINITION", 0);
            START_DEFINITION = r0;
            State r1 = new State("LABEL", 1);
            LABEL = r1;
            State r3 = new State("DESTINATION", 2);
            DESTINATION = r3;
            State r5 = new State("START_TITLE", 3);
            START_TITLE = r5;
            State r7 = new State("TITLE", 4);
            TITLE = r7;
            State r9 = new State("PARAGRAPH", 5);
            PARAGRAPH = r9;
            a = new State[]{r0, r1, r3, r5, r7, r9};
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[State.values().length];
            a = r0;
            r0[State.START_DEFINITION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[State.LABEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[State.DESTINATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[State.START_TITLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[State.TITLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final void a() {
        if (this.i == true) goto L5;
        return;
    L5:
        String r0 = u7b.a.b(this.f);
        StringBuilder r1 = this.h;
        if (r1 == null) goto L8;
        String r2 = u7b.a.b(r1.toString());
    L9:
        v7b.o r3 = new v7b.o(this.e.toString(), r0, r2);
        r3.n(this.d);
        ((ArrayList) this.d).clear();
        ((ArrayList) this.c).add(r3);
        this.e = null;
        this.i = false;
        this.f = null;
        this.h = null;
        return;
    L8:
        r2 = null;
        goto L9
    }

    public LinkReferenceDefinitionParser() {
        this.a = State.START_DEFINITION;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.i = false;
    }
}
