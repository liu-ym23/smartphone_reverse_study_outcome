package io.reactivex.exceptions;

import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public static final class CompositeExceptionCausalChain extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        public CompositeExceptionCausalChain() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return MESSAGE;
        }
    }

    public CompositeException(Throwable... r5) {
        if (r5 != null) goto L4;
        List r10 = Collections.singletonList(new NullPointerException("exceptions was null"));
    L5:
        this(r10);
        return;
    L4:
        r10 = Arrays.asList(r5);
        goto L5
    }

    public static void a(StringBuilder r5, Throwable r10, String r11) {
        r5.append(r11);
        r5.append(r10);
        r5.append('\n');
        StackTraceElement[] r12 = r10.getStackTrace();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L6;
        StackTraceElement r15 = r12[r14];
        r5.append("\t\tat ");
        r5.append(r15);
        r5.append('\n');
        r14 = r14 + 1;
        goto L3
    L6:
        if (r10.getCause() == null) goto L10;
        r5.append("\tCaused by: ");
        a(r5, r10.getCause(), "");
        return;
    }

    public final void b(a r10) {
        StringBuilder r5 = new StringBuilder(128);
        r5.append(this);
        r5.append('\n');
        StackTraceElement[] r11 = getStackTrace();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        StackTraceElement r14 = r11[r13];
        r5.append("\tat ");
        r5.append(r14);
        r5.append('\n');
        r13 = r13 + 1;
        goto L3
    L5:
        Iterator<Throwable> r15 = this.exceptions.iterator();
        int r16 = 1;
    L7:
        if (r15.hasNext() == false) goto L9;
        Throwable r17 = r15.next();
        r5.append("  ComposedException ");
        r5.append(r16);
        r5.append(" :\n");
        a(r5, r17, Profiler.DATA_SEP);
        r16 = r16 + 1;
        goto L7
    L9:
        String r18 = r5.toString();
        switch(r10.f17608a) {
            case 0: goto L12;
            default: goto L11;
        };
    L11:
        ((PrintWriter) r10.f17609b).println(r18);
        return;
    L12:
        ((PrintStream) r10.f17609b).println(r18);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (this.cause != null) goto L33;
        CompositeExceptionCausalChain r5 = new CompositeExceptionCausalChain();     // Catch: Throwable -> L26
        HashSet r10 = new HashSet();     // Catch: Throwable -> L26
        Iterator<Throwable> r11 = this.exceptions.iterator();     // Catch: Throwable -> L26
        Throwable r12 = r5;
    L7:
        if (r11.hasNext() == false) goto L32;
        Throwable r13 = r11.next();     // Catch: Throwable -> L26
        if (r10.contains(r13) == true) goto L7;
        r10.add(r13);     // Catch: Throwable -> L26
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L26
        Throwable r15 = r13.getCause();     // Catch: Throwable -> L26
        if (r15 == null) goto L20;
        if (r15 == r13) goto L20;
    L15:
        r14.add(r15);     // Catch: Throwable -> L26
        Throwable r16 = r15.getCause();     // Catch: Throwable -> L26
        if (r16 == null) goto L20;
        if (r16 == r15) goto L20;
        r15 = r16;
    L20:
        Iterator r17 = r14.iterator();     // Catch: Throwable -> L26
    L22:
        if (r17.hasNext() == false) goto L41;
        Throwable r18 = (Throwable) r17.next();     // Catch: Throwable -> L26
        if (r10.contains(r18) == true) goto L25;
        r10.add(r18);     // Catch: Throwable -> L26
        goto L22
    L25:
        r13 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");     // Catch: Throwable -> L26
        goto L22
    L41:
        r12.initCause(r13);     // Catch: Throwable -> L38
    L31:
        r12 = getRootCause(r12);     // Catch: Throwable -> L26
        goto L7
    L32:
        this.cause = r5;     // Catch: Throwable -> L26
    L33:
        Throwable r19 = this.cause;     // Catch: Throwable -> L26
        monitor-exit(this);
        return r19;
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public Throwable getRootCause(Throwable r5) {
        Throwable r10 = r5.getCause();
        if (r10 == null) goto L12;
        if (r5 == r10) goto L12;
    L6:
        Throwable r11 = r10.getCause();
        if (r11 == null) goto L11;
        if (r11 == r10) goto L11;
        r10 = r11;
    L11:
        return r10;
    L12:
        return r5;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public int size() {
        return this.exceptions.size();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r5) {
        b(new a(r5, 0));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r5) {
        b(new a(r5, 1));
    }

    public CompositeException(Iterable<? extends Throwable> r5) {
        LinkedHashSet r10 = new LinkedHashSet();
        ArrayList r11 = new ArrayList();
        if (r5 == null) goto L13;
        Iterator<? extends Throwable> r12 = r5.iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        Throwable r13 = r12.next();
        if ((r13 instanceof CompositeException) == true) goto L9;
        if (r13 != null) goto L11;
        r10.add(new NullPointerException("Throwable was null!"));
        goto L6
    L11:
        r10.add(r13);
        goto L6
    L9:
        r10.addAll(((CompositeException) r13).getExceptions());
    L15:
        if (r10.isEmpty() == true) goto L19;
        r11.addAll(r10);
        List<Throwable> r14 = Collections.unmodifiableList(r11);
        this.exceptions = r14;
        this.message = r14.size() + " exceptions occurred. ";
        return;
    L19:
        throw new IllegalArgumentException("errors is empty");
    L13:
        r10.add(new NullPointerException("errors was null"));
        goto L15
    }
}
