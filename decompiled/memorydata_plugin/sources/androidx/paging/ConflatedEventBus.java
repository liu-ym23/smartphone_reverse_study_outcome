package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/paging/ConflatedEventBus;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "(Ljava/lang/Object;)V", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "", "send", "", "data", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConflatedEventBus<T> {
    private final i<T> flow;
    private final ae<Pair<Integer, T>> state;

    public ConflatedEventBus() {
        DefaultConstructorMarker r0 = null;
        this(r0, 1, r0);
    }

    public ConflatedEventBus(T r3) {
        ae<Pair<Integer, T>> r4 = at.a(new Pair(Integer.MIN_VALUE, r3));
        this.state = r4;
        final i r5 = (i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.memorydata.plugin");
        this.flow = (i) ZeusTransformUtils.preCheckCast(new ConflatedEventBus$special$$inlined$mapNotNull$1(r5), i.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ ConflatedEventBus(Object r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final i<T> getFlow() {
        return this.flow;
    }

    public final void send(T r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.state.b(new Pair(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.state.c(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue() + 1), r5));
    }
}
