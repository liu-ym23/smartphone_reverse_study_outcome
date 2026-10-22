package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    Transformations$sam$androidx_lifecycle_Observer$0(Function1 r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "function");
        this.function = r4;
    }

    public final boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Observer.class) == true) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, FunctionAdapter.class) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) ZeusTransformUtils.preCheckCast(r3, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return (Function) ZeusTransformUtils.preCheckCast(this.function, Function.class, "com.obric.memorydata.plugin");
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object r1) {
        this.function.invoke(r1);
    }
}
