package io.reactivex.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements b, io.reactivex.internal.disposables.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    f<b> f16701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f16702b;

    public a() {
    }

    public int a() {
        int r1 = 0;
        if (this.f16702b == false) goto L5;
        return 0;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.f16702b == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L15
        return 0;
    L10:
        f<b> r0 = this.f16701a;     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        r1 = r0.c();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return r1;
    }

    void a(f<b> r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        ArrayList r6 = null;
        Object[] r8 = r7.b();
        int r0 = r8.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L17;
        Object r4 = r8[r2];
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L16;
        ((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin")).dispose();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        if (r6 != null) goto L15;
        r6 = new ArrayList();
    L15:
        r6.add(th);
    L16:
        r2 = r2 + 1;
        goto L6
    L17:
        if (r6 != null) goto L19;
        return;
    L19:
        if (r6.size() != 1) goto L23;
        throw ExceptionHelper.a((Throwable) ZeusTransformUtils.preCheckCast(r6.get(0), Throwable.class, "com.obric.memorydata.plugin"));
    L23:
        throw new CompositeException(r6);
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "disposable is null");
        if (this.f16702b == true) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.f16702b == true) goto L13;
        f<b> r0 = this.f16701a;     // Catch: Throwable -> L15
        if (r0 != null) goto L10;
        r0 = new f();     // Catch: Throwable -> L15
        this.f16701a = r0;     // Catch: Throwable -> L15
    L10:
        r0.a(r4);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    L18:
        r4.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (delete(r4) == false) goto L6;
        r4.dispose();
        return true;
    L6:
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean delete(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "disposables is null");
        if (this.f16702b == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f16702b == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L10:
        f<b> r0 = this.f16701a;     // Catch: Throwable -> L20
        if (r0 != null) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L13:
        if (r0.b(r4) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f16702b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f16702b == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        this.f16702b = true;     // Catch: Throwable -> L14
        f<b> r0 = this.f16701a;     // Catch: Throwable -> L14
        this.f16701a = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        a(r0);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f16702b;
    }
}
