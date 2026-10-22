package kotlin.internal;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PlatformImplementations$ReflectThrowable {
    public static final PlatformImplementations$ReflectThrowable INSTANCE = null;
    public static final Method addSuppressed = null;
    public static final Method getSuppressed = null;

    private PlatformImplementations$ReflectThrowable() {
    }

    static {
        INSTANCE = new PlatformImplementations$ReflectThrowable();
        Method[] r1 = Throwable.class.getMethods();
        Intrinsics.checkNotNull(r1);
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        Method r5 = null;
        if (r4 >= r2) goto L14;
        Method r6 = r1[r4];
        if (Intrinsics.areEqual(r6.getName(), "addSuppressed") == true) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == true) goto L15;
        r4 = r4 + 1;
    L15:
        addSuppressed = r6;
        int r0 = r1.length;
    L16:
        if (r3 >= r0) goto L21;
        Method r8 = r1[r3];
        if (Intrinsics.areEqual(r8.getName(), "getSuppressed") == true) goto L19;
        r3 = r3 + 1;
        goto L16
    L19:
        r5 = r8;
    L21:
        getSuppressed = r5;
        return;
    L8:
        if (Intrinsics.areEqual(ArraysKt.singleOrNull(r6.getParameterTypes()), Throwable.class) == false) goto L10;
        r7 = true;
        goto L11
    L14:
        r6 = null;
        goto L15
    }
}
