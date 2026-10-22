package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b"}, d2 = {"getPolymorphicElement", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CoroutineContextImplKt {
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element r4, CoroutineContext.Key<E> r5) {
        E r6 = (E) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        CoroutineContext.Key<?> r7 = (CoroutineContext.Key) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.Key.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "key");
        if (ZeusTransformUtils.instanceOf(r7, AbstractCoroutineContextKey.class) == false) goto L11;
        if (((AbstractCoroutineContextKey) ZeusTransformUtils.preCheckCast(r7, AbstractCoroutineContextKey.class, "com.obric.memorydata.plugin")).isSubKey$kotlin_stdlib(r6.getKey()) == false) goto L15;
        E r8 = (E) ((AbstractCoroutineContextKey) ZeusTransformUtils.preCheckCast(r7, AbstractCoroutineContextKey.class, "com.obric.memorydata.plugin")).tryCast$kotlin_stdlib(r6);
        if (ZeusTransformUtils.instanceOf(r8, CoroutineContext.Element.class) == true) goto L9;
        return null;
    L9:
        return r8;
    L15:
        return null;
    L11:
        if (r6.getKey() != r7) goto L14;
        return r6;
    L14:
        return null;
    }

    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element r3, CoroutineContext.Key<?> r4) {
        CoroutineContext.Element r5 = (CoroutineContext.Element) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        CoroutineContext.Key<?> r6 = (CoroutineContext.Key) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.Key.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "key");
        if (ZeusTransformUtils.instanceOf(r6, AbstractCoroutineContextKey.class) == false) goto L11;
        boolean r0 = ((AbstractCoroutineContextKey) ZeusTransformUtils.preCheckCast(r6, AbstractCoroutineContextKey.class, "com.obric.memorydata.plugin")).isSubKey$kotlin_stdlib(r5.getKey());
        Object r7 = r5;
        if (r0 == false) goto L10;
        CoroutineContext.Element r8 = ((AbstractCoroutineContextKey) ZeusTransformUtils.preCheckCast(r6, AbstractCoroutineContextKey.class, "com.obric.memorydata.plugin")).tryCast$kotlin_stdlib(r5);
        r7 = r5;
        if (r8 == null) goto L10;
        r7 = EmptyCoroutineContext.INSTANCE;
    L10:
        return (CoroutineContext) ZeusTransformUtils.preCheckCast(r7, CoroutineContext.class, "com.obric.memorydata.plugin");
    L11:
        CoroutineContext.Key<?> r1 = r5.getKey();
        Object r9 = r5;
        if (r1 != r6) goto L15;
        r9 = EmptyCoroutineContext.INSTANCE;
    L15:
        return (CoroutineContext) ZeusTransformUtils.preCheckCast(r9, CoroutineContext.class, "com.obric.memorydata.plugin");
    }
}
