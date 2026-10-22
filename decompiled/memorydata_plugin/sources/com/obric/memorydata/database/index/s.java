package com.obric.memorydata.database.index;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0007J)\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0011R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/database/index/EntityIndexEngineFactory;", "", "<init>", "()V", "indexEngine", "Lcom/obric/memorydata/database/index/EntityIndexEngine;", "getIndexEngine", "()Lcom/obric/memorydata/database/index/EntityIndexEngine;", "indexEngine$delegate", "Lkotlin/Lazy;", "obtainIndexEngine", "getGeneratedImplementation", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "suffix", "", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f9436a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f9437b = null;

    static {
        f9436a = new s();
        f9437b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$s$cTDIomLS6EXtazZHVSzHsgHgV9w.INSTANCE);
    }

    private s() {
    }

    @JvmStatic
    public static final EntityIndexEngine a() {
        return f9436a.b();
    }

    @JvmStatic
    private static final <T> T a(Class<T> r13, String r14) {
        Package r1 = r13.getPackage();
        Intrinsics.checkNotNull(r1);
        String r2 = r1.getName();
        String r3 = r13.getCanonicalName();
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNull(r2);
        boolean r5 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L9;
        r3 = r3.substring(r2.length() + 1);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
    L9:
        String r15 = StringsKt.replace$default(r3, '.', '_', false, 4, null) + r14;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
        r5 = true;
    L13:
        if (r5 == false) goto L15;
        String r6 = r15;
    L16:
        Class<?> r7 = Class.forName(r6, true, r13.getClassLoader());     // Catch: InstantiationException -> L18 IllegalAccessException -> L20 ClassNotFoundException -> L22
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.Class<T of com.obric.memorydata.database.index.EntityIndexEngineFactory.getGeneratedImplementation>");     // Catch: InstantiationException -> L18 IllegalAccessException -> L20 ClassNotFoundException -> L22
        return (T) r7.newInstance();
    L15:
        r6 = r2 + '.' + r15;     // Catch: InstantiationException -> L18 IllegalAccessException -> L20 ClassNotFoundException -> L22
    L23:
        throw new RuntimeException("Cannot find implementation for " + r13.getCanonicalName() + ". " + r15 + " does not exist");
    L21:
        throw new RuntimeException("Cannot access the constructor " + r13 + ".canonicalName");
    L19:
        throw new RuntimeException("Failed to create an instance of " + r13 + ".canonicalName");
    L5:
        r4 = false;
        goto L6
    }

    private final EntityIndexEngine b() {
        return (EntityIndexEngine) ZeusTransformUtils.preCheckCast(f9437b.getValue(), EntityIndexEngine.class, "com.obric.memorydata.plugin");
    }

    private static final EntityIndexEngine c() {
        return (EntityIndexEngine) ZeusTransformUtils.preCheckCast(a(EntityIndexEngine.class, "Impl"), EntityIndexEngine.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ EntityIndexEngine lambda$cTDIomLS6EXtazZHVSzHsgHgV9w() {
        return c();
    }
}
