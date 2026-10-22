package kotlinx.serialization.internal;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lambda f19332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.common.util.concurrent.r0 f19333b;

    /* JADX WARN: Multi-variable type inference failed */
    public q(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "compute");
        this.f19332a = (Lambda) r5;
        this.f19333b = new com.google.common.util.concurrent.r0(1);
    }

    @Override // kotlinx.serialization.internal.i1
    public final kotlinx.serialization.c b(final KClass r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        r0 r10 = (r0) androidx.room.b.b(this.f19333b, JvmClassMappingKt.getJavaClass(r5));
        Object r11 = r10.f19338a.get();
        if (r11 != null) goto L7;
        r11 = r10.a(new ClassValueCache$get$$inlined$getOrSet$1(this, r5));
    L7:
        return ((k) r11).f19302a;
    }
}
