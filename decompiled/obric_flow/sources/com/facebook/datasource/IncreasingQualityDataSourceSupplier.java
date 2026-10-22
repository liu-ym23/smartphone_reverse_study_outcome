package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7715a;

    public class IncreasingQualityDataSource extends AbstractDataSource<T> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ArrayList f7716h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7717i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7718j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public AtomicInteger f7719k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Throwable f7720l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public HashMap f7721m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ IncreasingQualityDataSourceSupplier f7722n;

        public class InternalDataSubscriber implements DataSubscriber<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f7723a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IncreasingQualityDataSource f7724b;

            public InternalDataSubscriber(IncreasingQualityDataSource r5, int r10) {
                this.f7724b = r5;
                this.f7723a = r10;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void a() {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void b(DataSource r5) {
                IncreasingQualityDataSource.a(this.f7724b, this.f7723a, r5);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void c(DataSource r5) {
                if (this.f7723a != 0) goto L13;
                IncreasingQualityDataSource r10 = this.f7724b;
                AbstractDataSource r11 = (AbstractDataSource) r5;
                monitor-enter(r11);
                float r12 = r11.f;     // Catch: Throwable -> L10
                monitor-exit(r11);     // Catch: Throwable -> L10
                r10.a(r12);
                return;
            L10:
                th = move-exception;
                throw th;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public final void a(DataSource r5) {
                if (r5.a() == false) goto L45;
                IncreasingQualityDataSource r10 = this.f7724b;
                int r11 = this.f7723a;
                AbstractDataSource r12 = (AbstractDataSource) r5;
                boolean r13 = r12.f();
                monitor-enter(r10);
                int r14 = r10.f7717i;     // Catch: Throwable -> L17
                if (r12 == r10.b(r11)) goto L9;
            L27:
                monitor-exit(r10);     // Catch: Throwable -> L17
            L29:
                if (r12 != r10.j()) goto L37;
                if (r11 == 0) goto L32;
            L34:
                boolean r15 = false;
            L35:
                r10.a(null, r15, r12.f7703a);
                goto L37
            L32:
                if (r12.f() == false) goto L34;
                r15 = true;
            L37:
                if (r10.f7719k.incrementAndGet() != r10.f7718j) goto L52;
                Throwable r16 = r10.f7720l;
                if (r16 == null) goto L53;
                r10.a(r16, r10.f7721m);
                return;
            L53:
                return;
            L52:
                return;
            L9:
                if (r11 == r10.f7717i) goto L27;
                if (r10.j() == null) goto L20;
                if (r13 == true) goto L15;
            L19:
                int r17 = r14;
            L21:
                monitor-exit(r10);     // Catch: Throwable -> L17
            L22:
                if (r14 <= r17) goto L29;
                DataSource r18 = r10.a(r14);
                if (r18 == null) goto L26;
                r18.close();
            L26:
                r14 = r14 - 1;
                goto L22
            L15:
                if (r11 >= r10.f7717i) goto L19;
            L20:
                r10.f7717i = r11;     // Catch: Throwable -> L17
                r17 = r11;
            L17:
                th = move-exception;
                throw th;
            L45:
                if (((AbstractDataSource) r5).f() == false) goto L54;
                IncreasingQualityDataSource.a(this.f7724b, this.f7723a, r5);
                return;
            }
        }

        public IncreasingQualityDataSource(IncreasingQualityDataSourceSupplier r5) {
            this.f7722n = r5;
            r5.getClass();
            i();
        }

        public final synchronized DataSource a(int r5) {
            monitor-enter(this);
            ArrayList r10 = this.f7716h;     // Catch: Throwable -> L10
            if (r10 != null) goto L6;
        L12:
            monitor-exit(this);
            return null;
        L6:
            if (r5 >= r10.size()) goto L12;
            DataSource r11 = (DataSource) this.f7716h.set(r5, null);     // Catch: Throwable -> L10
            monitor-exit(this);
            return r11;
        L10:
            th = move-exception;
            throw th;
        }

        public final synchronized DataSource b(int r5) {
            monitor-enter(this);
            ArrayList r10 = this.f7716h;     // Catch: Throwable -> L10
            if (r10 != null) goto L6;
        L12:
            monitor-exit(this);
            return null;
        L6:
            if (r5 >= r10.size()) goto L12;
            DataSource r11 = (DataSource) this.f7716h.get(r5);     // Catch: Throwable -> L10
            monitor-exit(this);
            return r11;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final boolean close() {
            this.f7722n.getClass();
            monitor-enter(this);
            int r5 = 0;
            if (super.close() == true) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L8
            return false;
        L10:
            ArrayList r10 = this.f7716h;     // Catch: Throwable -> L8
            this.f7716h = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            if (r10 != null) goto L14;
            return true;
        L14:
            if (r5 >= r10.size()) goto L27;
            DataSource r11 = (DataSource) r10.get(r5);
            if (r11 == null) goto L18;
            r11.close();
        L18:
            r5 = r5 + 1;
            goto L14
        L27:
            return true;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final synchronized Object getResult() {
            monitor-enter(this);
            this.f7722n.getClass();     // Catch: Throwable -> L8
            DataSource r5 = j();     // Catch: Throwable -> L8
            if (r5 == null) goto L10;
            Object r10 = r5.getResult();     // Catch: Throwable -> L8
            monitor-exit(this);
            return r10;
        L10:
            monitor-exit(this);
            return null;
        L8:
            th = move-exception;
            throw th;
        }

        public final void i() {
            if (this.f7719k == null) goto L5;
            return;
        L5:
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L7:
            if (this.f7719k != null) goto L16;
            int r5 = 0;
            this.f7719k = new AtomicInteger(0);     // Catch: Throwable -> L14
            int r10 = this.f7722n.f7715a.size();     // Catch: Throwable -> L14
            this.f7718j = r10;     // Catch: Throwable -> L14
            this.f7717i = r10;     // Catch: Throwable -> L14
            this.f7716h = new ArrayList(r10);     // Catch: Throwable -> L14
        L9:
            if (r5 >= r10) goto L16;
            DataSource r11 = (DataSource) ((Supplier) this.f7722n.f7715a.get(r5)).get();     // Catch: Throwable -> L14
            this.f7716h.add(r11);     // Catch: Throwable -> L14
            AbstractDataSource r12 = (AbstractDataSource) r11;     // Catch: Throwable -> L14
            r12.a(new InternalDataSubscriber(this, r5), CallerThreadExecutor.f7644a);     // Catch: Throwable -> L14
            if (r12.a() == true) goto L16;
            r5 = r5 + 1;     // Catch: Throwable -> L14
        L16:
            monitor-exit(this);     // Catch: Throwable -> L14
        }

        public final synchronized DataSource j() {
            monitor-enter(this);
            DataSource r5 = b(this.f7717i);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r5;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public final synchronized boolean a() {
            monitor-enter(this);
            this.f7722n.getClass();     // Catch: Throwable -> L10
            DataSource r5 = j();     // Catch: Throwable -> L10
            if (r5 == null) goto L12;
            if (r5.a() == false) goto L12;
            monitor-exit(this);
            return true;
        L12:
            monitor-exit(this);
            return false;
        L10:
            th = move-exception;
            throw th;
        }

        public static void a(IncreasingQualityDataSource r5, int r10, DataSource r11) {
            monitor-enter(r5);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r11 != r5.j()) goto L8;
            monitor-exit(r5);
            DataSource r12 = null;
        L16:
            if (r12 == null) goto L18;
            r12.close();
        L18:
            if (r10 != 0) goto L21;
            AbstractDataSource r13 = (AbstractDataSource) r11;
            r5.f7720l = r13.b();
            r5.f7721m = r13.f7703a;
        L21:
            if (r5.f7719k.incrementAndGet() != r5.f7718j) goto L30;
            Throwable r14 = r5.f7720l;
            if (r14 == null) goto L31;
            r5.a(r14, r5.f7721m);
            return;
        L31:
            return;
        L30:
            return;
        L8:
            if (r11 != r5.b(r10)) goto L14;
            r12 = r5.a(r10);     // Catch: Throwable -> L12
            monitor-exit(r5);     // Catch: Throwable -> L12
            goto L16
        L14:
            monitor-exit(r5);
            r12 = r11;
            goto L16
        }
    }

    public IncreasingQualityDataSourceSupplier(ArrayList r5) {
        if (r5.isEmpty() == true) goto L7;
        this.f7715a = r5;
        return;
    L7:
        throw new IllegalArgumentException("List of suppliers is empty!");
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof IncreasingQualityDataSourceSupplier) == true) goto L10;
        return false;
    L10:
        return Objects.a(this.f7715a, ((IncreasingQualityDataSourceSupplier) r5).f7715a);
    }

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        return new IncreasingQualityDataSource(this);
    }

    public final int hashCode() {
        return this.f7715a.hashCode();
    }

    public final String toString() {
        return new Objects.ToStringHelper(getClass().getSimpleName()).a("list", this.f7715a).toString();
    }
}
