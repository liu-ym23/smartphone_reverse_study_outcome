package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a*\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f*\u00060\rj\u0002`\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u0010\u0012\"\u00020\r2\u00020\r*\u001e\b\u0000\u0010\u0013\u001a\u0004\b\u0000\u0010\f\"\b\u0012\u0004\u0012\u0002H\f0\u00142\b\u0012\u0004\u0012\u0002H\f0\u0014¨\u0006\u0015"}, d2 = {"REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "identitySet", "", ExifInterface.LONGITUDE_EAST, "expectedSize", "", "removeFutureOnCancel", "", "executor", "Ljava/util/concurrent/Executor;", "withLock", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "WorkaroundAtomicReference", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f17578a = null;

    static {
        Method r0 = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L4
    L5:
        f17578a = r0;
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static final boolean a(Executor r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
    L14:
        return false;
    L4:
        if (ZeusTransformUtils.instanceOf(r6, ScheduledThreadPoolExecutor.class) == false) goto L6;
        ScheduledThreadPoolExecutor r7 = (ScheduledThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r6, ScheduledThreadPoolExecutor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L7:
        if (r7 != null) goto L9;
        return false;
    L9:
        Method r1 = f17578a;     // Catch: Throwable -> L14
        if (r1 != null) goto L12;
        return false;
    L12:
        r1.invoke(r7, new Object[]{true});     // Catch: Throwable -> L14
        return true;
    L6:
        r7 = null;
        goto L7
    }
}
