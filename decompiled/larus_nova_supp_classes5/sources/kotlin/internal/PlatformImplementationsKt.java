package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b¢\u0006\u0002\u0010\f\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS = null;

    static {
        IMPLEMENTATIONS = new JDK8PlatformImplementations();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T castToBaseType(Object r5) {
        Intrinsics.reifiedOperationMarker(1, "T");     // Catch: ClassCastException -> L5
        return r5;
    L5:
        e = move-exception;
        ClassLoader r6 = r5.getClass().getClassLoader();
        Intrinsics.reifiedOperationMarker(4, "T");
        ClassLoader r0 = Object.class.getClassLoader();
        if (Intrinsics.areEqual(r6, r0) == false) goto L9;
        throw e;
    L9:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r6 + ", base type classloader: " + r0, e);
    }

    public static final boolean apiVersionIsAtLeast(int r1, int r2, int r3) {
        return KotlinVersion.CURRENT.isAtLeast(r1, r2, r3);
    }
}
