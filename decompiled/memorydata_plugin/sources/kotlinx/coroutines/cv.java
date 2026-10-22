package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/ThreadContextElement;", "S", "Lkotlin/coroutines/CoroutineContext$Element;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface cv<S> extends CoroutineContext.Element {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        public static <S, R> R a(cv<S> r2, R r3, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r4) {
            cv r5 = (cv) ZeusTransformUtils.wrapperContextForParams(r2, cv.class, "com.obric.memorydata.plugin");
            Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            return (R) CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r5, CoroutineContext.Element.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static <S> CoroutineContext a(cv<S> r2, CoroutineContext r3) {
            cv r4 = (cv) ZeusTransformUtils.wrapperContextForParams(r2, cv.class, "com.obric.memorydata.plugin");
            CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r4, CoroutineContext.Element.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    void a(CoroutineContext r1, S r2);

    S b(CoroutineContext r1);
}
