package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0007\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a2\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0013H\u0086\b¢\u0006\u0002\u0010\u0014\u001a-\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0013H\u0086\b\u001a2\u0010\u0017\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0013H\u0086\b¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"NONE", "Lkotlinx/coroutines/internal/Symbol;", "PENDING", "MutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "fuseStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/StateFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "getAndUpdate", "function", "Lkotlin/Function1;", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", BuildConfig.CHANNEL, "", "updateAndGet", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.aj f17428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.aj f17429b = null;

    static {
        f17428a = new kotlinx.coroutines.internal.aj("NONE");
        f17429b = new kotlinx.coroutines.internal.aj("PENDING");
    }

    public static final <T> ae<T> a(T r2) {
        if (r2 != null) goto L6;
        r2 = (T) kotlinx.coroutines.flow.internal.s.f17463a;
    L6:
        return (ae) ZeusTransformUtils.preCheckCast(new as(r2), ae.class, "com.obric.memorydata.plugin");
    }

    public static final <T> i<T> a(ar<? extends T> r4, CoroutineContext r5, int r6, BufferOverflow r7) {
        ar r8 = (ar) ZeusTransformUtils.wrapperContextForParams(r4, ar.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (kotlinx.coroutines.an.a() == true) goto L5;
    L12:
        if (r6 >= 0) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == true) goto L21;
        if (r6 == (-2)) goto L21;
    L25:
        return ak.a((ai) ZeusTransformUtils.preCheckCast(r8, ai.class, "com.obric.memorydata.plugin"), r9, r6, r7);
    L21:
        if (r7 != BufferOverflow.DROP_OLDEST) goto L25;
        return (i) ZeusTransformUtils.preCheckCast(r8, i.class, "com.obric.memorydata.plugin");
    L14:
        if (r6 >= 2) goto L16;
    L5:
        if (r6 == (-1)) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.aj a() {
        return f17428a;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.aj b() {
        return f17429b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(ae<T> r2, Function1<? super T, ? extends T> r3) {
        ae r4 = (ae) ZeusTransformUtils.wrapperContextForParams(r2, ae.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    L3:
        Object r0 = r4.c();
        if (r4.a(r0, r5.invoke(r0)) == false) goto L3;
    }
}
