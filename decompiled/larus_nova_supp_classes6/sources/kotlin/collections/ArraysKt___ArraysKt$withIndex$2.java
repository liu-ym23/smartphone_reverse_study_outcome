package kotlin.collections;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ArraysKt___ArraysKt$withIndex$2 extends Lambda implements Function0<Iterator<? extends Byte>> {
    final /* synthetic */ byte[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$2(byte[] r1) {
        this.$this_withIndex = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Iterator<Byte> m31invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m31invoke();
    }
}
