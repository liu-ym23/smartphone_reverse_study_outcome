package com.ss.ugc.clientai.aiservice.ohr;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ)\u0010\n\u001a\u00020\u00072!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00070\fJ\u0013\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/ohr/AIPredictObservable;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addPredictObserver", "", "observer", "(Ljava/lang/Object;)V", "notifyPredictResult", "lambda", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "removePredictObserver", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<T> f15785a;

    public a() {
        this.f15785a = new CopyOnWriteArrayList();
    }

    public final void a(T r1) {
        this.f15785a.add(r1);
    }

    public final void a(Function1<? super T, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "lambda");
        Iterator<T> r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f15785a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r4.invoke(r2.next());
        goto L4
    }

    public final void b(T r1) {
        this.f15785a.remove(r1);
    }
}
