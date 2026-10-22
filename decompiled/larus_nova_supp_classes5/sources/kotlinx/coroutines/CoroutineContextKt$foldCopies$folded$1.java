package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class CoroutineContextKt$foldCopies$folded$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
    final /* synthetic */ boolean $isNewCoroutine;
    final /* synthetic */ Ref.ObjectRef<CoroutineContext> $leftoverContext;

    public CoroutineContextKt$foldCopies$folded$1(Ref.ObjectRef<CoroutineContext> r1, boolean r2) {
        this.$leftoverContext = r1;
        this.$isNewCoroutine = r2;
        super(2);
    }

    public final CoroutineContext invoke(CoroutineContext r4, CoroutineContext.Element r5) {
        if ((r5 instanceof w) == true) goto L7;
        return r4.plus(r5);
    L7:
        if (((CoroutineContext) this.$leftoverContext.element).get(r5.getKey()) != null) goto L13;
        w r6 = (w) r5;
        if (this.$isNewCoroutine == false) goto L12;
        r6 = r6.g();
    L12:
        return r4.plus(r6);
    L13:
        Ref.ObjectRef<CoroutineContext> r0 = this.$leftoverContext;
        r0.element = ((CoroutineContext) r0.element).minusKey(r5.getKey());
        return r4.plus(((w) r5).c());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineContext) r1, (CoroutineContext.Element) r2);
    }
}
