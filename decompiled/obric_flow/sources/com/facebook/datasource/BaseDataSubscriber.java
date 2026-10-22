package com.facebook.datasource;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    public BaseDataSubscriber() {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void a() {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public final void b(DataSource r5) {
        d(r5);     // Catch: Throwable -> L5
        r5.close();
        return;
    L5:
        th = move-exception;
        r5.close();
        throw th;
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void c(DataSource r5) {
    }

    public abstract void d(DataSource r5);

    public abstract void e(DataSource r5);

    @Override // com.facebook.datasource.DataSubscriber
    public final void a(DataSource r5) {
        AbstractDataSource r10 = (AbstractDataSource) r5;
        boolean r11 = r10.f();
        e(r10);     // Catch: Throwable -> L7
        if (r11 == false) goto L13;
        r10.close();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r11 == false) goto L10;
        r10.close();
    L10:
        throw th;
    }
}
