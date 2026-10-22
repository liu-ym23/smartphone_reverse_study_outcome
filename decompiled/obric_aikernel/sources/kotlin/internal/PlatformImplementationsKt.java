package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class PlatformImplementationsKt {

    @JvmField
    public static final PlatformImplementations IMPLEMENTATIONS = null;

    static {
        IMPLEMENTATIONS = new JDK8PlatformImplementations();
    }

    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final boolean apiVersionIsAtLeast(int r10, int r11, int r12) {
        return KotlinVersion.CURRENT.isAtLeast(r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final /* synthetic */ <T> T castToBaseType(Object r10) {
        Intrinsics.reifiedOperationMarker(1, "T");     // Catch: ClassCastException -> L5
        return r10;
    L5:
        e = move-exception;
        ClassLoader r11 = r10.getClass().getClassLoader();
        Intrinsics.reifiedOperationMarker(4, "T");
        ClassLoader r12 = Object.class.getClassLoader();
        if (Intrinsics.areEqual(r11, r12) == false) goto L9;
        throw e;
    L9:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r11 + ", base type classloader: " + r12, e);
    }
}
