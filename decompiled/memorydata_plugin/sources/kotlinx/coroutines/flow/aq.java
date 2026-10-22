package kotlinx.coroutines.flow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0017J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class aq implements an {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f17425b;
    private final long c;

    public aq(long r6, long r8) {
        this.f17425b = r6;
        this.c = r8;
        boolean r2 = true;
        if (r6 < 0) goto L5;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L17;
        if (r8 >= 0) goto L12;
        r2 = false;
    L12:
        if (r2 == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException(("replayExpiration(" + r8 + " ms) cannot be negative").toString());
    L17:
        throw new IllegalArgumentException(("stopTimeout(" + r6 + " ms) cannot be negative").toString());
    L5:
        r5 = false;
        goto L7
    }

    public static final /* synthetic */ long a(aq r2) {
        return r2.f17425b;
    }

    public static final /* synthetic */ long b(aq r2) {
        return r2.c;
    }

    @Override // kotlinx.coroutines.flow.an
    public i<SharingCommand> a(ar<Integer> r4) {
        return k.b(k.c(k.c((i) ZeusTransformUtils.preCheckCast((ar) ZeusTransformUtils.wrapperContextForParams(r4, ar.class, "com.obric.memorydata.plugin"), i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new StartedWhileSubscribed$command$1(this, null), Function3.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new StartedWhileSubscribed$command$2(null), Function2.class, "com.obric.memorydata.plugin")));
    }

    public boolean equals(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, aq.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f17425b != ((aq) ZeusTransformUtils.preCheckCast(r7, aq.class, "com.obric.memorydata.plugin")).f17425b) goto L9;
        if (this.c != ((aq) ZeusTransformUtils.preCheckCast(r7, aq.class, "com.obric.memorydata.plugin")).c) goto L9;
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f17425b) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        List r0 = CollectionsKt.createListBuilder(2);
        if (this.f17425b <= 0) goto L6;
        r0.add("stopTimeout=" + this.f17425b + "ms");
    L6:
        if (this.c >= Long.MAX_VALUE) goto L9;
        r0.add("replayExpiration=" + this.c + "ms");
    L9:
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r0), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null) + ')';
    }
}
