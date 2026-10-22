package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0005R\u0012\u0010\u0003\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "limitedParallelism", "parallelism", "", "toString", "", "toStringInternalImpl", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ci extends ah {
    public ci() {
    }

    public abstract ci a();

    public final String b() {
        ci r0 = ba.b();
        if (this != r0) goto L14;
        return "Dispatchers.Main";
    L14:
        ci r1 = r0.a();     // Catch: UnsupportedOperationException -> L9
    L10:
        if (this != r1) goto L13;
        return "Dispatchers.Main.immediate";
    L13:
        return null;
    L9:
        r1 = null;
        goto L10
    }

    @Override // kotlinx.coroutines.ah
    public ah limitedParallelism(int r2) {
        kotlinx.coroutines.internal.s.a(r2);
        return (ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.ah
    public String toString() {
        String r0 = b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ao.b(this) + '@' + ao.a(this);
    }
}
