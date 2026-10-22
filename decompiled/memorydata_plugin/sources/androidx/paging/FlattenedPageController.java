package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bJ#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e0\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/paging/FlattenedPageController;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", Constants.KEY_LIST, "Landroidx/paging/FlattenedPageEventStorage;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "maxEventIndex", "", "getCachedEvent", "Landroidx/paging/PageEvent$Insert;", "getStateAsEvents", "", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "record", "", "event", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FlattenedPageController<T> {
    private final FlattenedPageEventStorage<T> list;
    private final a lock;
    private int maxEventIndex;

    /* JADX INFO: renamed from: androidx.paging.FlattenedPageController$getStateAsEvents$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", i = {0, 0}, l = {288}, m = "getStateAsEvents", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlattenedPageController<T> this$0;

        AnonymousClass1(FlattenedPageController<T> r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getStateAsEvents((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.FlattenedPageController$record$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", i = {0, 0, 0}, l = {288}, m = "record", n = {"this", "event", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class C09371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlattenedPageController<T> this$0;

        C09371(FlattenedPageController<T> r3, Continuation<? super C09371> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.record(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    public FlattenedPageController() {
        this.list = new FlattenedPageEventStorage();
        this.lock = c.a(false, 1, null);
        this.maxEventIndex = -1;
    }

    public final PageEvent.Insert<T> getCachedEvent() {
        PageEvent r4 = (PageEvent) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(this.list.getAsEvents()), PageEvent.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, PageEvent.Insert.class) == true) goto L7;
        return null;
    L7:
        if (((PageEvent.Insert) ZeusTransformUtils.preCheckCast(r4, PageEvent.Insert.class, "com.obric.memorydata.plugin")).getLoadType() == LoadType.REFRESH) goto L9;
        return null;
    L9:
        return (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r4, PageEvent.Insert.class, "com.obric.memorydata.plugin");
    }

    public final Object getStateAsEvents(Continuation<? super List<? extends IndexedValue<? extends PageEvent<T>>>> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r0.L$1, a.class, "com.obric.memorydata.plugin");
        FlattenedPageController<T> r1 = (FlattenedPageController) ZeusTransformUtils.preCheckCast(r0.L$0, FlattenedPageController.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        a r12 = r8;
        FlattenedPageController<T> this = r1;
    L30:
        List<PageEvent<T>> r4 = this.list.getAsEvents();     // Catch: Throwable -> L27
        int r13 = (this.maxEventIndex - r4.size()) + 1;     // Catch: Throwable -> L27
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        int r7 = 0;
        Iterator<T> r14 = r5.iterator();     // Catch: Throwable -> L27
    L19:
        if (r14.hasNext() == false) goto L24;
        T r15 = r14.next();     // Catch: Throwable -> L27
        int r16 = r7 + 1;     // Catch: Throwable -> L27
        if (r7 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L27
    L23:
        r6.add(new IndexedValue(r7 + r13, (PageEvent) ZeusTransformUtils.preCheckCast(r15, PageEvent.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L27
        r7 = r16;
        goto L19
    L24:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        r12.b(null);
        return r17;
    L27:
        th = move-exception;
        r12.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r12 = this.lock;
        r0.L$0 = this;
        r0.L$1 = r12;
        r0.label = 1;
        if (r12.a(null, r0) != r2) goto L30;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    public final Object record(IndexedValue<? extends PageEvent<T>> r7, Continuation<? super Unit> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C09371.class) == false) goto L7;
        C09371 r0 = (C09371) ZeusTransformUtils.preCheckCast(r9, C09371.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r0.L$2, a.class, "com.obric.memorydata.plugin");
        r7 = (IndexedValue) ZeusTransformUtils.preCheckCast(r0.L$1, IndexedValue.class, "com.obric.memorydata.plugin");
        FlattenedPageController<T> r1 = (FlattenedPageController) ZeusTransformUtils.preCheckCast(r0.L$0, FlattenedPageController.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
        a r11 = r6;
        FlattenedPageController<T> this = r1;
    L23:
        this.maxEventIndex = r7.getIndex();     // Catch: Throwable -> L20
        this.list.add((PageEvent) ZeusTransformUtils.preCheckCast(r7.getValue(), PageEvent.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r11.b(null);
        return Unit.INSTANCE;
    L20:
        th = move-exception;
        r11.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r11 = this.lock;
        r0.L$0 = this;
        r0.L$1 = r7;
        r0.L$2 = r11;
        r0.label = 1;
        if (r11.a(null, r0) != r2) goto L23;
        return r2;
    L7:
        r0 = new C09371(this, r9);
        goto L8
    }
}
