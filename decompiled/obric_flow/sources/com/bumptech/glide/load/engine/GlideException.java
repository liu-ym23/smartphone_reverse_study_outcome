package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GlideException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement[] f1438a = null;
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;

    @Nullable
    private Exception exception;
    private z.c key;

    static {
        f1438a = new StackTraceElement[0];
    }

    public GlideException(String r5) {
        this(r5, Collections.emptyList());
    }

    public static void a(Throwable r5, ArrayList r10) {
        if ((r5 instanceof GlideException) == false) goto L8;
        Iterator<Throwable> r11 = ((GlideException) r5).getCauses().iterator();
    L6:
        if (r11.hasNext() == false) goto L11;
        a(r11.next(), r10);
        goto L6
    L11:
        return;
    L8:
        r10.add(r5);
    }

    public static void b(List r5, z r10) {
        c(r5, r10);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void c(List r5, z r10) {
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        r10.append("Cause (");
        int r13 = r12 + 1;
        r10.append(String.valueOf(r13));
        r10.append(" of ");
        r10.append(String.valueOf(r11));
        r10.append("): ");
        Throwable r14 = (Throwable) r5.get(r12);
        if ((r14 instanceof GlideException) == false) goto L7;
        GlideException r15 = (GlideException) r14;
        r15.getClass();
        d(r15, r10);
        b(r15.getCauses(), new z(r10));
    L8:
        r12 = r13;
        goto L3
    L7:
        d(r14, r10);
        goto L8
    }

    public static void d(Throwable r5, Appendable r10) {
        r10.append(r5.getClass().toString()).append(": ").append(r5.getMessage()).append('\n');     // Catch: IOException -> L4
        return;
    L5:
        throw new RuntimeException(r5);
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
        StringBuilder r5 = new StringBuilder(71);
        r5.append(this.detailMessage);
        String r10 = "";
        if (this.dataClass == null) goto L5;
        String r11 = ", " + this.dataClass;
    L6:
        r5.append(r11);
        if (this.dataSource == null) goto L9;
        String r12 = ", " + this.dataSource;
    L10:
        r5.append(r12);
        if (this.key == null) goto L13;
        r10 = ", " + this.key;
    L13:
        r5.append(r10);
        List<Throwable> r13 = getRootCauses();
        if (r13.isEmpty() == false) goto L18;
        return r5.toString();
    L18:
        if (r13.size() != 1) goto L20;
        r5.append("\nThere was 1 cause:");
    L21:
        Iterator<Throwable> r14 = r13.iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        Throwable r15 = r14.next();
        r5.append('\n');
        r5.append(r15.getClass().getName());
        r5.append('(');
        r5.append(r15.getMessage());
        r5.append(')');
        goto L23
    L25:
        r5.append("\n call GlideException#logRootCauses(String) for more detail");
        return r5.toString();
    L20:
        r5.append("\nThere were ");
        r5.append(r13.size());
        r5.append(" causes:");
        goto L21
    L9:
        r12 = "";
        goto L10
    L5:
        r11 = "";
        goto L6
    }

    @Nullable
    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList r5 = new ArrayList();
        a(this, r5);
        return r5;
    }

    public void logRootCauses(String r10) {
        List<Throwable> r5 = getRootCauses();
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        StringBuilder r13 = new StringBuilder("Root cause (");
        int r14 = r12 + 1;
        r13.append(r14);
        r13.append(" of ");
        r13.append(r11);
        r13.append(")");
        Log.i(r10, r13.toString(), r5.get(r12));
        r12 = r14;
        goto L3
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setLoggingDetails(z.c r5, DataSource r10) {
        setLoggingDetails(r5, r10, null);
    }

    public void setOrigin(@Nullable Exception r5) {
        this.exception = r5;
    }

    public GlideException(String r5, Throwable r10) {
        this(r5, Collections.singletonList(r10));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r5) {
        d(this, r5);
        b(getCauses(), new z(r5));
    }

    public void setLoggingDetails(z.c r5, DataSource r10, Class<?> r11) {
        this.key = r5;
        this.dataSource = r10;
        this.dataClass = r11;
    }

    public GlideException(String r5, List<Throwable> r10) {
        this.detailMessage = r5;
        setStackTrace(f1438a);
        this.causes = r10;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r5) {
        d(this, r5);
        b(getCauses(), new z(r5));
    }
}
