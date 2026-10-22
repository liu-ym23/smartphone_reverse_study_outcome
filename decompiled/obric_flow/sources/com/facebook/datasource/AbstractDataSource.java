package com.facebook.datasource;

import android.util.Pair;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractDataSource<T> implements DataSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f7703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataSourceStatus f7704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7705c;
    public Object d;
    public Throwable e;
    public float f;
    public final ConcurrentLinkedQueue g;

    /* JADX INFO: renamed from: com.facebook.datasource.AbstractDataSource$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataSubscriber f7707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f7708c;
        public final /* synthetic */ AbstractDataSource d;

        public AnonymousClass1(AbstractDataSource r5, boolean r10, DataSubscriber r11, boolean r12) {
            this.d = r5;
            this.f7706a = r10;
            this.f7707b = r11;
            this.f7708c = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f7706a == false) goto L7;
            this.f7707b.b(this.d);
            return;
        L7:
            if (this.f7708c == false) goto L10;
            this.f7707b.a();
            return;
        L10:
            this.f7707b.a(this.d);
        }
    }

    public static final enum DataSourceStatus extends Enum<DataSourceStatus> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DataSourceStatus f7711a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DataSourceStatus f7712b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final DataSourceStatus f7713c = null;
        public static final /* synthetic */ DataSourceStatus[] d = null;

        static {
            DataSourceStatus r5 = new DataSourceStatus("IN_PROGRESS", 0);
            f7711a = r5;
            DataSourceStatus r10 = new DataSourceStatus("SUCCESS", 1);
            f7712b = r10;
            DataSourceStatus r11 = new DataSourceStatus("FAILURE", 2);
            f7713c = r11;
            d = new DataSourceStatus[]{r5, r10, r11};
        }

        public DataSourceStatus(String r5, int r10) {
            super(r5, r10);
        }

        public static DataSourceStatus valueOf(String r5) {
            return (DataSourceStatus) Enum.valueOf(DataSourceStatus.class, r5);
        }

        public static DataSourceStatus[] values() {
            return (DataSourceStatus[]) d.clone();
        }
    }

    public AbstractDataSource() {
        this.d = null;
        this.e = null;
        this.f = 0.0f;
        this.f7705c = false;
        this.f7704b = DataSourceStatus.f7711a;
        this.g = new ConcurrentLinkedQueue();
    }

    public void a(Object r5) {
    }

    public final synchronized Throwable b() {
        monitor-enter(this);
        Throwable r5 = this.e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized float c() {
        monitor-enter(this);
        float r5 = this.f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f7705c == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        this.f7705c = true;     // Catch: Throwable -> L8
        Object r5 = this.d;     // Catch: Throwable -> L8
        this.d = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r5 == null) goto L15;
        a(r5);
    L15:
        if (f() == true) goto L17;
        g();
    L17:
        monitor-enter(this);
        this.g.clear();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return true;
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean d() {
        monitor-enter(this);
        DataSourceStatus r5 = this.f7704b;     // Catch: Throwable -> L10
        DataSourceStatus r10 = DataSourceStatus.f7713c;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r5 != r10) goto L8;
        return true;
    L8:
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean e() {
        monitor-enter(this);
        boolean r5 = this.f7705c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean f() {
        monitor-enter(this);
        DataSourceStatus r5 = this.f7704b;     // Catch: Throwable -> L10
        DataSourceStatus r10 = DataSourceStatus.f7711a;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r5 == r10) goto L8;
        return true;
    L8:
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void g() {
        boolean r5 = d();
        boolean r10 = h();
        Iterator r11 = this.g.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Pair r12 = (Pair) r11.next();
        DataSubscriber r13 = (DataSubscriber) r12.first;
        ((Executor) r12.second).execute(new AnonymousClass1(this, r5, r13, r10));
        goto L4
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized Object getResult() {
        monitor-enter(this);
        Object r5 = this.d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean h() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (e() == false) goto L12;
        if (f() == true) goto L12;
        monitor-exit(this);
        return true;
    L12:
        monitor-exit(this);
        return false;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean a() {
        monitor-enter(this);
        Object r5 = this.d;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r5 == null) goto L8;
        return true;
    L8:
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x001b -> B:34:0x003e). Please report as a decompilation issue!!! */
    public final boolean a(Object r5, boolean r10, HashMap r11) {
        this.f7703a = r11;
        Object r12 = null;
        monitor-enter(this);     // Catch: Throwable -> L36
    L11:
        th = th;
    L34:
        monitor-exit(this);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L36
    L46:
        if (this.f7705c == false) goto L7;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L24
        boolean r13 = false;
        if (r5 == null) goto L30;
    L29:
        a(r5);
    L30:
        if (r13 == false) goto L32;
        g();
    L32:
        return r13;
    L7:
        if (this.f7704b != DataSourceStatus.f7711a) goto L26;
        if (r10 == false) goto L13;
        this.f7704b = DataSourceStatus.f7712b;     // Catch: Throwable -> L11
        this.f = 1.0f;     // Catch: Throwable -> L11
    L13:
        Object r14 = this.d;     // Catch: Throwable -> L11
        if (r14 != r5) goto L42;
        r5 = null;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L24
        r13 = true;
        if (r5 == null) goto L30;
    L42:
        this.d = r5;     // Catch: Throwable -> L17
        r5 = r14;
    L17:
        th = th;
        r12 = r14;
    L24:
        th = move-exception;
        r12 = r5;
        th = th;
    L36:
        th = move-exception;
        if (r12 == null) goto L39;
        a(r12);
    L39:
        throw th;
    }

    public final void a(DataSubscriber r5, Executor r10) {
        r10.getClass();
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f7705c == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.f7704b != DataSourceStatus.f7711a) goto L14;
        this.g.add(Pair.create(r5, r10));     // Catch: Throwable -> L8
    L14:
        if (a() == false) goto L16;
    L21:
        boolean r11 = true;
    L22:
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r11 == false) goto L29;
        r10.execute(new AnonymousClass1(this, d(), r5, h()));
        return;
    L29:
        return;
    L16:
        if (f() == true) goto L21;
        if (h() == true) goto L21;
        r11 = false;
        goto L22
    }

    public final boolean a(Throwable r5, HashMap r10) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f7705c == false) goto L6;
    L13:
        monitor-exit(this);
        boolean r11 = false;
    L15:
        if (r11 == false) goto L17;
        g();
    L17:
        return r11;
    L6:
        if (this.f7704b != DataSourceStatus.f7711a) goto L13;
        this.f7704b = DataSourceStatus.f7713c;     // Catch: Throwable -> L11
        this.e = r5;     // Catch: Throwable -> L11
        this.f7703a = r10;     // Catch: Throwable -> L11
        monitor-exit(this);
        r11 = true;
        goto L15
    }

    public final boolean a(float r5) {
        monitor-enter(this);
        boolean r10 = false;
        if (this.f7705c == false) goto L6;
    L18:
        monitor-exit(this);
    L19:
        if (r10 == false) goto L24;
        Iterator r11 = this.g.iterator();
    L22:
        if (r11.hasNext() == false) goto L24;
        Pair r12 = (Pair) r11.next();
        final DataSubscriber r13 = (DataSubscriber) r12.first;
        ((Executor) r12.second).execute(new AnonymousClass2(this, r13));
    L24:
        return r10;
    L6:
        if (this.f7704b != DataSourceStatus.f7711a) goto L18;
        if (r5 >= this.f) goto L13;
        monitor-exit(this);
        goto L19
    L13:
        this.f = r5;     // Catch: Throwable -> L16
        monitor-exit(this);
        r10 = true;
    L16:
        th = move-exception;
        throw th;
    }
}
