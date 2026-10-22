package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = null;
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private com.bumptech.glide.load.c key;

    private static final class a implements Appendable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f708b;

        a(Appendable r3) {
            Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
            this.f708b = true;
            this.f707a = r4;
        }

        private CharSequence a(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L6;
            return "";
        L6:
            return r1;
        }

        @Override // java.lang.Appendable
        public Appendable append(char r4) {
            boolean r1 = false;
            if (this.f708b == false) goto L6;
            this.f708b = false;
            this.f707a.append("  ");
        L6:
            if (r4 != '\n') goto L8;
            r1 = true;
        L8:
            this.f708b = r1;
            this.f707a.append(r4);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence r3) {
            CharSequence r4 = a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            return append(r4, 0, r4.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence r4, int r5, int r6) {
            CharSequence r7 = a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"));
            boolean r1 = false;
            if (this.f708b == false) goto L6;
            this.f708b = false;
            this.f707a.append("  ");
        L6:
            if (r7.length() > 0) goto L8;
        L10:
            this.f708b = r1;
            this.f707a.append(r7, r5, r6);
            return this;
        L8:
            if (r7.charAt(r6 - 1) != '\n') goto L10;
            r1 = true;
            goto L10
        }
    }

    static {
        EMPTY_ELEMENTS = new StackTraceElement[0];
    }

    public GlideException(String r2) {
        this(r2, Collections.emptyList());
    }

    public GlideException(String r1, Throwable r2) {
        this(r1, Collections.singletonList(r2));
    }

    public GlideException(String r3, List<Throwable> r4) {
        List<Throwable> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.detailMessage = r3;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = r5;
    }

    private void addRootCauses(Throwable r4, List<Throwable> r5) {
        List<Throwable> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, GlideException.class) == false) goto L8;
        Iterator<Throwable> r7 = ((GlideException) ZeusTransformUtils.preCheckCast(r4, GlideException.class, "com.obric.memorydata.plugin")).getCauses().iterator();
    L6:
        if (r7.hasNext() == false) goto L11;
        addRootCauses((Throwable) ZeusTransformUtils.preCheckCast(r7.next(), Throwable.class, "com.obric.memorydata.plugin"), r6);
        goto L6
    L11:
        return;
    L8:
        r6.add(r4);
    }

    private static void appendCauses(List<Throwable> r2, Appendable r3) {
        appendCausesWrapped((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static void appendCausesWrapped(List<Throwable> r7, Appendable r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Appendable r10 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r8, Appendable.class, "com.obric.memorydata.plugin");
        int r1 = r9.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int r5 = r3 + 1;
        r10.append("Cause (").append(String.valueOf(r5)).append(" of ").append(String.valueOf(r1)).append("): ");
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(r9.get(r3), Throwable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, GlideException.class) == false) goto L7;
        ((GlideException) ZeusTransformUtils.preCheckCast(r4, GlideException.class, "com.obric.memorydata.plugin")).printStackTrace(r10);
    L8:
        r3 = r5;
        goto L3
    L7:
        appendExceptionMessage(r4, r10);
        goto L8
    }

    private static void appendExceptionMessage(Throwable r2, Appendable r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        r4.append(r2.getClass().toString()).append(": ").append(r2.getMessage()).append('\n');     // Catch: IOException -> L5
        return;
    L6:
        throw new RuntimeException(r2);
    }

    private void printStackTrace(Appendable r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        appendExceptionMessage(this, r4);
        appendCauses(getCauses(), new a(r4));
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r0 = new StringBuilder(71).append(this.detailMessage);
        String r3 = "";
        if (this.dataClass == null) goto L5;
        String r1 = ", " + this.dataClass;
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.dataSource == null) goto L9;
        String r4 = ", " + this.dataSource;
    L10:
        StringBuilder r5 = r2.append(r4);
        if (this.key == null) goto L13;
        r3 = ", " + this.key;
    L13:
        StringBuilder r6 = r5.append(r3);
        List<Throwable> r7 = getRootCauses();
        if (r7.isEmpty() == false) goto L18;
        return r6.toString();
    L18:
        if (r7.size() != 1) goto L20;
        r6.append("\nThere was 1 root cause:");
    L21:
        Iterator<Throwable> r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L25;
        Throwable r9 = (Throwable) ZeusTransformUtils.preCheckCast(r8.next(), Throwable.class, "com.obric.memorydata.plugin");
        r6.append('\n').append(r9.getClass().getName()).append('(').append(r9.getMessage()).append(')');
        goto L23
    L25:
        r6.append("\n call GlideException#logRootCauses(String) for more detail");
        return r6.toString();
    L20:
        r6.append("\nThere were ").append(r7.size()).append(" root causes:");
        goto L21
    L9:
        r4 = "";
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList r0 = new ArrayList();
        addRootCauses(this, r0);
        return r0;
    }

    public void logRootCauses(String r7) {
        List<Throwable> r6 = getRootCauses();
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = r1 + 1;
        Log.i(r7, "Root cause (" + r3 + " of " + r0 + ")", (Throwable) ZeusTransformUtils.preCheckCast(r6.get(r1), Throwable.class, "com.obric.memorydata.plugin"));
        r1 = r3;
        goto L3
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r1) {
        printStackTrace(r1);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r1) {
        printStackTrace(r1);
    }

    void setLoggingDetails(com.bumptech.glide.load.c r3, DataSource r4) {
        setLoggingDetails((com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin"), r4, null);
    }

    void setLoggingDetails(com.bumptech.glide.load.c r3, DataSource r4, Class<?> r5) {
        this.key = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        this.dataSource = r4;
        this.dataClass = r5;
    }

    public void setOrigin(Exception r1) {
        this.exception = r1;
    }
}
