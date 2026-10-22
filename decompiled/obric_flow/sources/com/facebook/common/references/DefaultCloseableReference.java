package com.facebook.common.references;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultCloseableReference<T> extends CloseableReference<T> {
    public DefaultCloseableReference(SharedReference r5, CloseableReference.LeakHandler r10, Throwable r11) {
        super(r5, r10, r11);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m90clone() {
        return clone();
    }

    @Override // com.facebook.common.references.CloseableReference
    public final void finalize() {
        monitor-enter(this);     // Catch: Throwable -> L14
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L4:
        if (this.f7670a == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        super.finalize();
        return;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        this.f7672c.b();     // Catch: Throwable -> L14
        close();     // Catch: Throwable -> L14
        super.finalize();
        return;
    L14:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public DefaultCloseableReference(Object r5, ResourceReleaser r10, CloseableReference.LeakHandler r11, Throwable r12) {
        super(r5, r10, r11, r12);
    }

    @Override // com.facebook.common.references.CloseableReference
    public final CloseableReference clone() {
        monitor-enter(this);
        boolean r5 = this.f7670a;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r5 == true) goto L9;
        return new DefaultCloseableReference(this.f7671b, this.f7672c, this.d);
    L9:
        throw new IllegalStateException();
    L10:
        th = move-exception;
        throw th;
    }
}
