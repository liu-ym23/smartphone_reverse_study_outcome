package kotlin.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b¢\u0006\u0002\u0010\f\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", ExifInterface.GPS_DIRECTION_TRUE, "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS = null;

    static {
        JDK8PlatformImplementations r1 = new JDK8PlatformImplementations();
        IMPLEMENTATIONS = (PlatformImplementations) ZeusTransformUtils.preCheckCast(r1, PlatformImplementations.class, "com.obric.memorydata.plugin");
        return;
    L6:
        e = move-exception;
        ClassLoader r2 = r1.getClass().getClassLoader();
        ClassLoader r3 = PlatformImplementations.class.getClassLoader();
        if (Intrinsics.areEqual(r2, r3) == false) goto L10;
        throw e;
    L10:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r2 + ", base type classloader: " + r3, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean apiVersionIsAtLeast(int r1, int r2, int r3) {
        return KotlinVersion.CURRENT.isAtLeast(r1, r2, r3);
    }

    private static final /* synthetic */ <T> T castToBaseType(Object r6) {
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: ClassCastException -> L5
        return (T) ZeusTransformUtils.preCheckCast(r6, Object.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        ClassLoader r7 = r6.getClass().getClassLoader();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ClassLoader r0 = ((Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin")).getClassLoader();
        if (Intrinsics.areEqual(r7, r0) == false) goto L9;
        throw e;
    L9:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r7 + ", base type classloader: " + r0, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
