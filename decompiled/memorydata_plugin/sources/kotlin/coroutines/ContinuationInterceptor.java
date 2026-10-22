package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key Key = null;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(ContinuationInterceptor r2, R r3, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r4) {
            ContinuationInterceptor r5 = (ContinuationInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, ContinuationInterceptor.class, "com.obric.memorydata.plugin");
            Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r5, CoroutineContext.Element.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor r4, CoroutineContext.Key<E> r5) {
            ContinuationInterceptor r6 = (ContinuationInterceptor) ZeusTransformUtils.wrapperContextForParams(r4, ContinuationInterceptor.class, "com.obric.memorydata.plugin");
            CoroutineContext.Key r7 = (CoroutineContext.Key) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.Key.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "key");
            if (ZeusTransformUtils.instanceOf(r7, AbstractCoroutineContextKey.class) == false) goto L11;
            if (((AbstractCoroutineContextKey) ZeusTransformUtils.preCheckCast(r7, AbstractCoroutineContextKey.class, "com.obric.memorydata.plugin")).isSubKey$kotlin_stdlib(r6.getKey()) == false) goto L14;
            E r8 = (E) ((AbstractCoroutineContextKey) ZeusTransformUtils.preCheckCast(r7, AbstractCoroutineContextKey.class, "com.obric.memorydata.plugin")).tryCast$kotlin_stdlib((CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r6, CoroutineContext.Element.class, "com.obric.memorydata.plugin"));
            if (ZeusTransformUtils.instanceOf(r8, CoroutineContext.Element.class) == true) goto L9;
            return null;
        L9:
            return r8;
        L14:
            return null;
        L11:
            if (ContinuationInterceptor.Key != r7) goto L16;
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return (E) ZeusTransformUtils.preCheckCast(r6, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        L16:
            return null;
        }

        public static CoroutineContext minusKey(ContinuationInterceptor r3, CoroutineContext.Key<?> r4) {
            ContinuationInterceptor r5 = (ContinuationInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, ContinuationInterceptor.class, "com.obric.memorydata.plugin");
            CoroutineContext.Key r6 = (CoroutineContext.Key) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.Key.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "key");
            if (ZeusTransformUtils.instanceOf(r6, AbstractCoroutineContextKey.class) == false) goto L11;
            boolean r0 = ((AbstractCoroutineContextKey) ZeusTransformUtils.preCheckCast(r6, AbstractCoroutineContextKey.class, "com.obric.memorydata.plugin")).isSubKey$kotlin_stdlib(r5.getKey());
            Object r7 = r5;
            if (r0 == false) goto L10;
            CoroutineContext.Element r8 = ((AbstractCoroutineContextKey) ZeusTransformUtils.preCheckCast(r6, AbstractCoroutineContextKey.class, "com.obric.memorydata.plugin")).tryCast$kotlin_stdlib((CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r5, CoroutineContext.Element.class, "com.obric.memorydata.plugin"));
            r7 = r5;
            if (r8 == null) goto L10;
            r7 = EmptyCoroutineContext.INSTANCE;
        L10:
            return (CoroutineContext) ZeusTransformUtils.preCheckCast(r7, CoroutineContext.class, "com.obric.memorydata.plugin");
        L11:
            Object r9 = r5;
            if (ContinuationInterceptor.Key != r6) goto L15;
            r9 = EmptyCoroutineContext.INSTANCE;
        L15:
            return (CoroutineContext) ZeusTransformUtils.preCheckCast(r9, CoroutineContext.class, "com.obric.memorydata.plugin");
        }

        public static CoroutineContext plus(ContinuationInterceptor r2, CoroutineContext r3) {
            ContinuationInterceptor r4 = (ContinuationInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, ContinuationInterceptor.class, "com.obric.memorydata.plugin");
            CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "context");
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r4, CoroutineContext.Element.class, "com.obric.memorydata.plugin"), r5);
        }

        public static void releaseInterceptedContinuation(ContinuationInterceptor r2, Continuation<?> r3) {
            ContinuationInterceptor r4 = (ContinuationInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, ContinuationInterceptor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"), "continuation");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ Key $$INSTANCE = null;

        static {
            $$INSTANCE = new Key();
        }

        private Key() {
        }
    }

    static {
        Key = Key.$$INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r1);

    <T> Continuation<T> interceptContinuation(Continuation<? super T> r1);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    CoroutineContext minusKey(CoroutineContext.Key<?> r1);

    void releaseInterceptedContinuation(Continuation<?> r1);
}
