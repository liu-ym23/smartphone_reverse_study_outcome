package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b"}, d2 = {"getPolymorphicElement", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Element;", STGroup.DICT_KEY, "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element r5, CoroutineContext.Key<E> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        if ((r10 instanceof AbstractCoroutineContextKey) == false) goto L11;
        AbstractCoroutineContextKey r11 = (AbstractCoroutineContextKey) r10;
        if (r11.isSubKey$kotlin_stdlib(r5.getKey()) == false) goto L15;
        E r12 = (E) r11.tryCast$kotlin_stdlib(r5);
        if (r12 != null) goto L9;
        return null;
    L9:
        return r12;
    L15:
        return null;
    L11:
        if (r5.getKey() != r10) goto L14;
        return r5;
    L14:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element r5, CoroutineContext.Key<?> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        if ((r10 instanceof AbstractCoroutineContextKey) == false) goto L11;
        AbstractCoroutineContextKey r11 = (AbstractCoroutineContextKey) r10;
        if (r11.isSubKey$kotlin_stdlib(r5.getKey()) == true) goto L7;
        return r5;
    L7:
        if (r11.tryCast$kotlin_stdlib(r5) != null) goto L9;
        return r5;
    L9:
        return EmptyCoroutineContext.INSTANCE;
    L11:
        if (r5.getKey() == r10) goto L13;
        return r5;
    L13:
        return EmptyCoroutineContext.INSTANCE;
    }
}
