package com.bytedance;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.als.Observer;
import com.bytedance.als.h;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0016J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u0018\u0010\u0011\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/RxLiveEvent;", "T", "Lcom/bytedance/als/h;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/bytedance/als/Observer;", "observer", "", "observe", "observeForever", "t", "setValue", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "postValue", "removeObserver", "Lio/reactivex/subjects/PublishSubject;", "publishSubject", "Lio/reactivex/subjects/PublishSubject;", "perValue", "Ljava/lang/Object;", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "<init>", "()V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class RxLiveEvent<T> extends h<T> {
    private final Lazy handler$delegate;
    private T perValue;
    private final PublishSubject<T> publishSubject;

    public static final class a<T> implements Consumer<T> {
        public final /* synthetic */ Observer a;

        public a(Observer r1) {
            this.a = r1;
        }

        public final void accept(T r10) {
            this.a.onChanged(r10);
        }
    }

    public static final class b<T> implements Consumer<T> {
        public final /* synthetic */ Observer a;

        public b(Observer r1) {
            this.a = r1;
        }

        public final void accept(T r10) {
            this.a.onChanged(r10);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ RxLiveEvent a;
        public final /* synthetic */ Object b;

        public c(RxLiveEvent r1, Object r10) {
            this.a = r1;
            this.b = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.a.setValue(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private final Handler getHandler() {
        return (Handler) this.handler$delegate.getValue();
    }

    public RxLiveEvent() {
        this.publishSubject = PublishSubject.create();
        this.handler$delegate = LazyKt.lazy(RxLiveEvent$handler$2.INSTANCE);
    }

    @Override // com.bytedance.als.f
    public T getValue() {
        return this.perValue;
    }

    @Override // com.bytedance.als.f
    public void observeForever(Observer<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        this.publishSubject.subscribe(new b(r10));
    }

    @Override // com.bytedance.als.h, com.bytedance.als.f
    public void postValue(T r10) {
        getHandler().post(new c(this, r10));
    }

    @Override // com.bytedance.als.f
    public void removeObserver(Observer<T> r10) {
        throw new RuntimeException("user  lifecycleOwner instead");
    }

    @Override // com.bytedance.als.h, com.bytedance.als.f
    public void setValue(T r10) {
        this.perValue = r10;
        this.publishSubject.onNext(r10);
    }

    @Override // com.bytedance.als.f
    public void observe(LifecycleOwner r10, Observer<T> r11) {
        if (r10 == null) goto L10;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r10.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L8;
        return;
    L8:
        final Disposable r12 = this.publishSubject.subscribe(new a(r11));
        r10.getLifecycle().addObserver(new AnonymousClass1(r12));
        return;
    }
}
