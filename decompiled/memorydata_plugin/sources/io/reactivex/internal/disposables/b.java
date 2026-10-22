package io.reactivex.internal.disposables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements io.reactivex.disposables.b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<io.reactivex.disposables.b> f16714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f16715b;

    public b() {
    }

    void a(List<io.reactivex.disposables.b> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        ArrayList r5 = null;
        Iterator r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r6.next(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        if (r5 != null) goto L15;
        r5 = new ArrayList();
    L15:
        r5.add(th);
        goto L7
    L16:
        if (r5 != null) goto L18;
        return;
    L18:
        if (r5.size() != 1) goto L22;
        throw ExceptionHelper.a((Throwable) ZeusTransformUtils.preCheckCast(r5.get(0), Throwable.class, "com.obric.memorydata.plugin"));
    L22:
        throw new CompositeException(r5);
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean a(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "d is null");
        if (this.f16715b == true) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.f16715b == true) goto L13;
        List r0 = this.f16714a;     // Catch: Throwable -> L15
        if (r0 != null) goto L10;
        r0 = new LinkedList();     // Catch: Throwable -> L15
        this.f16714a = r0;     // Catch: Throwable -> L15
    L10:
        r0.add(r4);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    L18:
        r4.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean b(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (delete(r4) == false) goto L6;
        r4.dispose();
        return true;
    L6:
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean delete(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "Disposable item is null");
        if (this.f16715b == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f16715b == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L10:
        List<io.reactivex.disposables.b> r0 = this.f16714a;     // Catch: Throwable -> L20
        if (r0 != null) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L13:
        if (r0.remove(r4) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f16715b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f16715b == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        this.f16715b = true;     // Catch: Throwable -> L14
        List<io.reactivex.disposables.b> r0 = this.f16714a;     // Catch: Throwable -> L14
        this.f16714a = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        a(r0);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f16715b;
    }
}
