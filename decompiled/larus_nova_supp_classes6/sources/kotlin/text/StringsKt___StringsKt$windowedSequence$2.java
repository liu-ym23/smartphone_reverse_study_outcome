package kotlin.text;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "R", "index", "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class StringsKt___StringsKt$windowedSequence$2<R> extends Lambda implements Function1<Integer, R> {
    final /* synthetic */ int $size;
    final /* synthetic */ CharSequence $this_windowedSequence;
    final /* synthetic */ Function1<CharSequence, R> $transform;

    /* JADX WARN: Multi-variable type inference failed */
    public StringsKt___StringsKt$windowedSequence$2(int r1, CharSequence r2, Function1<? super CharSequence, ? extends R> r3) {
        this.$size = r1;
        this.$this_windowedSequence = r2;
        this.$transform = r3;
        super(1);
    }

    public final R invoke(int r4) {
        int r0 = this.$size + r4;
        if (r0 >= 0) goto L5;
    L6:
        r0 = this.$this_windowedSequence.length();
    L8:
        return (R) this.$transform.invoke(this.$this_windowedSequence.subSequence(r4, r0));
    L5:
        if (r0 <= this.$this_windowedSequence.length()) goto L8;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}
