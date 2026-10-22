package com.larus.bmhome.bigimg.download;

import com.larus.bmhome.bigimg.ImageSave;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ImageDownloadLoadingMgr {
    public static final ImageDownloadLoadingMgr a = null;
    public static final StateFlowImpl b = null;
    public static final e c = null;
    public static final HashMap<String, Job> d = null;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function1<Boolean, Unit> a;
        public final /* synthetic */ String b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Boolean, Unit> r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r2, Continuation r3) {
            List r4 = (List) r2;
            this.a.invoke(Boxing.boxBoolean(((List) ImageDownloadLoadingMgr.b.getValue()).contains(this.b)));
            return Unit.INSTANCE;
        }
    }

    public ImageDownloadLoadingMgr() {
    }

    static {
        a = new ImageDownloadLoadingMgr();
        b = j1.a(CollectionsKt.emptyList());
        c = new e();
        d = new HashMap();
    }

    public final Object a(String r5, Function1<? super Boolean, Unit> r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof ImageDownloadLoadingMgr$collectLoadingStatus$1) == false) goto L7;
        ImageDownloadLoadingMgr$collectLoadingStatus$1 r0 = (ImageDownloadLoadingMgr$collectLoadingStatus$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L12;
        ResultKt.throwOnFailure(r8);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        StateFlowImpl r9 = b;
        a r4 = new a(r6, r5);
        r0.label = 1;
        if (r9.collect(r4, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new ImageDownloadLoadingMgr$collectLoadingStatus$1(this, r7);
        goto L8
    }

    public static void b(final String r7, Map r8, Function1 r9, final Function2 r10, boolean r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r7, "imageUrl");
        Job r0 = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ImageDownloadLoadingMgr$saveImage$updateLoadingJob$1(r7, null), 3, null);
        r0.invokeOnCompletion(new f(r7));
        d.put(r7, r0);
        ImageSave r1 = ImageSave.a;
        Function3 r3 = new g(r7, r10);
        r1.getClass();
        ImageSave.w(r7, r8, r3, r9, r12, r11);
    }

    public static /* synthetic */ void c(String r4, Map r5, Function2 r6, boolean r7, Function1 r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r9 & 8) == 0) goto L8;
        Function2 r2 = null;
    L10:
        if ((r9 & 16) == 0) goto L12;
        boolean r3 = false;
    L14:
        if ((r9 & 32) == 0) goto L16;
        Function1 r10 = null;
    L17:
        b(r4, r5, null, r2, r3, r10);
        return;
    L16:
        r10 = r8;
        goto L17
    L12:
        r3 = r7;
        goto L14
    L8:
        r2 = r6;
        goto L10
    }
}
