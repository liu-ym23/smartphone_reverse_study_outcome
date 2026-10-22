package io.reactivex.exceptions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    static final class CompositeExceptionCausalChain extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        CompositeExceptionCausalChain() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return MESSAGE;
        }
    }

    static abstract class a {
        a() {
        }

        abstract void a(Object r1);
    }

    static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrintStream f16711a;

        b(PrintStream r1) {
            this.f16711a = r1;
        }

        @Override // io.reactivex.exceptions.CompositeException.a
        void a(Object r1) {
            this.f16711a.println(r1);
        }
    }

    static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrintWriter f16712a;

        c(PrintWriter r1) {
            this.f16712a = r1;
        }

        @Override // io.reactivex.exceptions.CompositeException.a
        void a(Object r1) {
            this.f16712a.println(r1);
        }
    }

    public CompositeException(Iterable<? extends Throwable> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r7, Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashSet r1 = new LinkedHashSet();
        ArrayList r3 = new ArrayList();
        if (r8 == null) goto L14;
        Iterator r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L16;
        Object r4 = (Throwable) ZeusTransformUtils.preCheckCast(r9.next(), Throwable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, CompositeException.class) == true) goto L9;
        if (r4 != null) goto L13;
        r4 = new NullPointerException("Throwable was null!");
    L13:
        r1.add(r4);
        goto L6
    L9:
        r1.addAll(((CompositeException) ZeusTransformUtils.preCheckCast(r4, CompositeException.class, "com.obric.memorydata.plugin")).getExceptions());
    L16:
        if (r1.isEmpty() == true) goto L20;
        r3.addAll(r1);
        List<Throwable> r10 = Collections.unmodifiableList(r3);
        this.exceptions = r10;
        this.message = r10.size() + " exceptions occurred. ";
        return;
    L20:
        throw new IllegalArgumentException("errors is empty");
    L14:
        r1.add(new NullPointerException("errors was null"));
        goto L16
    }

    public CompositeException(Throwable... r2) {
        if (r2 != null) goto L4;
        List r3 = Collections.singletonList(new NullPointerException("exceptions was null"));
    L5:
        this(r3);
        return;
    L4:
        r3 = Arrays.asList(r2);
        goto L5
    }

    private void appendStackTrace(StringBuilder r6, Throwable r7, String r8) {
        r6.append(r8).append(r7).append('\n');
        StackTraceElement[] r9 = r7.getStackTrace();
        int r1 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        StackTraceElement r3 = r9[r2];
        r6.append("\t\tat ").append(r3).append('\n');
        r2 = r2 + 1;
        goto L3
    L6:
        if (r7.getCause() == null) goto L10;
        r6.append("\tCaused by: ");
        appendStackTrace(r6, r7.getCause(), "");
        return;
    }

    private List<Throwable> getListOfCauses(Throwable r2) {
        ArrayList r1 = new ArrayList();
        Throwable r0 = r2.getCause();
        if (r0 == null) goto L11;
        if (r0 == r2) goto L11;
    L6:
        r1.add(r0);
        Throwable r3 = r0.getCause();
        if (r3 == null) goto L11;
        if (r3 == r0) goto L11;
        r0 = r3;
    L11:
        return r1;
    }

    private void printStackTrace(a r8) {
        StringBuilder r0 = new StringBuilder(128);
        r0.append(this).append('\n');
        StackTraceElement[] r1 = getStackTrace();
        int r3 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        r0.append("\tat ").append(r1[r4]).append('\n');
        r4 = r4 + 1;
        goto L3
    L5:
        Iterator<Throwable> r2 = this.exceptions.iterator();
        int r5 = 1;
    L7:
        if (r2.hasNext() == false) goto L9;
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(r2.next(), Throwable.class, "com.obric.memorydata.plugin");
        r0.append("  ComposedException ").append(r5).append(" :\n");
        appendStackTrace(r0, r6, "\t");
        r5 = r5 + 1;
        goto L7
    L9:
        r8.a(r0.toString());
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.cause != null) goto L22;
        CompositeExceptionCausalChain r0 = new CompositeExceptionCausalChain();     // Catch: Throwable -> L25
        HashSet r1 = new HashSet();     // Catch: Throwable -> L25
        Iterator<Throwable> r2 = this.exceptions.iterator();     // Catch: Throwable -> L25
        Throwable r3 = r0;
    L7:
        if (r2.hasNext() == false) goto L21;
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(r2.next(), Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r1.contains(r4) == true) goto L7;
        r1.add(r4);     // Catch: Throwable -> L25
        Iterator<Throwable> r5 = getListOfCauses(r4).iterator();     // Catch: Throwable -> L25
    L13:
        if (r5.hasNext() == false) goto L31;
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(r5.next(), Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r1.contains(r6) == true) goto L16;
        r1.add(r6);     // Catch: Throwable -> L25
        goto L13
    L16:
        r4 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");     // Catch: Throwable -> L25
        goto L13
    L31:
        r3.initCause(r4);     // Catch: Throwable -> L28
    L20:
        r3 = getRootCause(r3);     // Catch: Throwable -> L25
        goto L7
    L21:
        this.cause = r0;     // Catch: Throwable -> L25
    L22:
        Throwable r7 = this.cause;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r7;
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    Throwable getRootCause(Throwable r1) {
        Throwable r0 = r1.getCause();
        if (r0 == null) goto L12;
        if (r1 == r0) goto L12;
    L6:
        Throwable r2 = r0.getCause();
        if (r2 == null) goto L11;
        if (r2 == r0) goto L11;
        r0 = r2;
    L11:
        return r0;
    L12:
        return r1;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r2) {
        printStackTrace(new b(r2));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r2) {
        printStackTrace(new c(r2));
    }

    public int size() {
        return this.exceptions.size();
    }
}
