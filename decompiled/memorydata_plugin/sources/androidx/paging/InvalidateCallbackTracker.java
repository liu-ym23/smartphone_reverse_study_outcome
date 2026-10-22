package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\r\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0016J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/paging/InvalidateCallbackTracker;", ExifInterface.GPS_DIRECTION_TRUE, "", "callbackInvoker", "Lkotlin/Function1;", "", "invalidGetter", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "callbacks", "", "<set-?>", "invalid", "getInvalid$paging_common", "()Z", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "callbackCount", "", "callbackCount$paging_common", "invalidate", "invalidate$paging_common", "registerInvalidatedCallback", "callback", "registerInvalidatedCallback$paging_common", "(Ljava/lang/Object;)V", "unregisterInvalidatedCallback", "unregisterInvalidatedCallback$paging_common", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InvalidateCallbackTracker<T> {
    private final Function1<T, Unit> callbackInvoker;
    private final List<T> callbacks;
    private boolean invalid;
    private final Function0<Boolean> invalidGetter;
    private final ReentrantLock lock;

    public InvalidateCallbackTracker(Function1<? super T, Unit> r3, Function0<Boolean> r4) {
        Function1<T, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "callbackInvoker");
        this.callbackInvoker = r5;
        this.invalidGetter = r6;
        this.lock = new ReentrantLock();
        this.callbacks = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ InvalidateCallbackTracker(Function1 r2, Function0 r3, int r4, DefaultConstructorMarker r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public final int callbackCount$paging_common() {
        return this.callbacks.size();
    }

    public final boolean getInvalid$paging_common() {
        return this.invalid;
    }

    public final boolean invalidate$paging_common() {
        if (this.invalid == false) goto L5;
        return false;
    L5:
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.lock, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
    L19:
        th = move-exception;
        r0.unlock();
        throw th;
    L7:
        if (this.invalid == false) goto L11;
        r0.unlock();
        return false;
    L11:
        this.invalid = true;     // Catch: Throwable -> L19
        List r2 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.callbacks, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        this.callbacks.clear();     // Catch: Throwable -> L19
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r0.unlock();
        if (r2 == null) goto L18;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Function1<T, Unit> r5 = this.callbackInvoker;
        Iterator<T> r3 = r1.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        r5.invoke(r3.next());
    L18:
        return true;
    }

    public final void registerInvalidatedCallback$paging_common(T r6) {
        Function0<Boolean> r0 = this.invalidGetter;
        boolean r2 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        invalidate$paging_common();
    L11:
        if (this.invalid == false) goto L14;
        this.callbackInvoker.invoke(r6);
        return;
    L14:
        Lock r3 = (Lock) ZeusTransformUtils.preCheckCast(this.lock, Lock.class, "com.obric.memorydata.plugin");
        r3.lock();
    L24:
        th = move-exception;
        r3.unlock();
        throw th;
    L16:
        if (this.invalid == false) goto L18;
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L20:
        r3.unlock();
        if (r2 == false) goto L28;
        this.callbackInvoker.invoke(r6);
        return;
    L28:
        return;
    L18:
        Boolean.valueOf(this.callbacks.add(r6));     // Catch: Throwable -> L24
        r2 = false;
        goto L20
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void unregisterInvalidatedCallback$paging_common(T r4) {
        Lock r0 = (Lock) ZeusTransformUtils.preCheckCast(this.lock, Lock.class, "com.obric.memorydata.plugin");
        r0.lock();
        this.callbacks.remove(r4);     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
