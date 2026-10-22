package kotlinx.coroutines.selects;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
@SourceDebugExtension({"SMAP\nSelectUnbiased.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2,2:69\n*S KotlinDebug\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n*L\n63#1:69,2\n*E\n"})
public class o<R> extends SelectImplementation<R> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<SelectImplementation<R>.a> f10692l;

    @PublishedApi
    static /* synthetic */ <R> Object F(o<R> r10, Continuation<? super R> r11) {
        r10.G();
        return super.r(r11);
    }

    private final void G() {
        Collections.shuffle(this.f10692l);     // Catch: Throwable -> L9
        Iterator<T> r10 = this.f10692l.iterator();     // Catch: Throwable -> L9
    L4:
        if (r10.hasNext() == false) goto L7;
        SelectImplementation.A(this, (SelectImplementation.a) r10.next(), false, 1, null);     // Catch: Throwable -> L9
        goto L4
    L7:
        this.f10692l.clear();
        return;
    L9:
        th = move-exception;
        this.f10692l.clear();
        throw th;
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.b
    public void b(d r11, Function1<? super Continuation<? super R>, ? extends Object> r12) {
        this.f10692l.add(new SelectImplementation.a(this, r11.b(), r11.a(), r11.d(), SelectKt.i(), r12, r11.c()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.b
    public <Q> void e(f<? extends Q> r11, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r12) {
        this.f10692l.add(new SelectImplementation.a(this, r11.b(), r11.a(), r11.d(), null, r12, r11.c()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation
    @PublishedApi
    public Object r(Continuation<? super R> r10) {
        return F(this, r10);
    }
}
