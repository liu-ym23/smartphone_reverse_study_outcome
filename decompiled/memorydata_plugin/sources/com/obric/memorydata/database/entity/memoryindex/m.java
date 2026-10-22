package com.obric.memorydata.database.entity.memoryindex;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0007J!\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0003¢\u0006\u0002\u0010\u000fR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/MemoryEntityToolEngineFactory;", "", "<init>", "()V", "entityToolEngine", "Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityToolEngine;", "getEntityToolEngine", "()Lcom/obric/memorydata/database/entity/memoryindex/IMemoryEntityToolEngine;", "entityToolEngine$delegate", "Lkotlin/Lazy;", "obtainToolEngine", "getGeneratedImplementation", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f9281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f9282b = null;

    static {
        f9281a = new m();
        f9282b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$m$EvJZDlHiJ1njyCiPA7iLqiAl6kE.INSTANCE);
    }

    private m() {
    }

    @JvmStatic
    public static final g a() {
        return f9281a.b();
    }

    @JvmStatic
    private static final <T> T a(Class<T> r5) {
        Package r1 = r5.getPackage();
        Intrinsics.checkNotNull(r1);
        String r2 = r1.getName();
        Intrinsics.checkNotNull(r2);     // Catch: InstantiationException -> L12 IllegalAccessException -> L14 ClassNotFoundException -> L16
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
        String r4 = "MemoryEntityToolEngine";
    L10:
        Class<?> r6 = Class.forName(r4, true, r5.getClassLoader());     // Catch: InstantiationException -> L12 IllegalAccessException -> L14 ClassNotFoundException -> L16
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.Class<T of com.obric.memorydata.database.entity.memoryindex.MemoryEntityToolEngineFactory.getGeneratedImplementation>");     // Catch: InstantiationException -> L12 IllegalAccessException -> L14 ClassNotFoundException -> L16
        return (T) r6.newInstance();
    L9:
        r4 = r2 + ".MemoryEntityToolEngine";     // Catch: InstantiationException -> L12 IllegalAccessException -> L14 ClassNotFoundException -> L16
        goto L10
    L6:
        r3 = false;
    L17:
        throw new RuntimeException("Cannot find implementation for " + r5.getCanonicalName() + ". MemoryEntityToolEngine does not exist");
    L15:
        throw new RuntimeException("Cannot access the constructor " + r5 + ".canonicalName");
    L13:
        throw new RuntimeException("Failed to create an instance of " + r5 + ".canonicalName");
    }

    private final g b() {
        return (g) ZeusTransformUtils.preCheckCast(f9282b.getValue(), g.class, "com.obric.memorydata.plugin");
    }

    private static final g c() {
        return (g) ZeusTransformUtils.preCheckCast(a(g.class), g.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ g lambda$EvJZDlHiJ1njyCiPA7iLqiAl6kE() {
        return c();
    }
}
