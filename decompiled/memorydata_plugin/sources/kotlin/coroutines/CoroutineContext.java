package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¨\u0006\u0013"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface CoroutineContext {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static CoroutineContext plus(CoroutineContext r3, CoroutineContext r4) {
            CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
            CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "context");
            if (r6 != EmptyCoroutineContext.INSTANCE) goto L6;
            return r5;
        L6:
            return (CoroutineContext) ZeusTransformUtils.preCheckCast(r6.fold(r5, (Function2) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function2.class, "com.obric.memorydata.plugin")), CoroutineContext.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Element extends CoroutineContext {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static <R> R fold(Element r2, R r3, Function2<? super R, ? super Element, ? extends R> r4) {
                Element r5 = (Element) ZeusTransformUtils.wrapperContextForParams(r2, Element.class, "com.obric.memorydata.plugin");
                Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r6, "operation");
                return (R) r6.invoke(r3, r5);
            }

            public static <E extends Element> E get(Element r2, Key<E> r3) {
                E r4 = (E) ZeusTransformUtils.wrapperContextForParams(r2, Element.class, "com.obric.memorydata.plugin");
                Key r5 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "key");
                if (Intrinsics.areEqual(r4.getKey(), r5) == false) goto L5;
                Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return r4;
            L5:
                return null;
            }

            public static CoroutineContext minusKey(Element r2, Key<?> r3) {
                Element r4 = (Element) ZeusTransformUtils.wrapperContextForParams(r2, Element.class, "com.obric.memorydata.plugin");
                Key r5 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "key");
                boolean r6 = Intrinsics.areEqual(r4.getKey(), r5);
                Object r7 = r4;
                if (r6 == false) goto L6;
                r7 = EmptyCoroutineContext.INSTANCE;
            L6:
                return (CoroutineContext) ZeusTransformUtils.preCheckCast(r7, CoroutineContext.class, "com.obric.memorydata.plugin");
            }

            public static CoroutineContext plus(Element r2, CoroutineContext r3) {
                Element r4 = (Element) ZeusTransformUtils.wrapperContextForParams(r2, Element.class, "com.obric.memorydata.plugin");
                CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "context");
                return DefaultImpls.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(r4, CoroutineContext.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R r1, Function2<? super R, ? super Element, ? extends R> r2);

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> r1);

        Key<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        CoroutineContext minusKey(Key<?> r1);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Key<E extends Element> {
    }

    <R> R fold(R r1, Function2<? super R, ? super Element, ? extends R> r2);

    <E extends Element> E get(Key<E> r1);

    CoroutineContext minusKey(Key<?> r1);

    CoroutineContext plus(CoroutineContext r1);
}
