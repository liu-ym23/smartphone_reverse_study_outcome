package org.koin.java;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import vu.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class KoinJavaComponent$injectOrNull$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Class<?> $clazz;
    final /* synthetic */ Function0<a> $parameters;
    final /* synthetic */ wu.a $qualifier;

    /* JADX WARN: Multi-variable type inference failed */
    public KoinJavaComponent$injectOrNull$1(Class<?> r5, wu.a r10, Function0<? extends a> r11) {
        this.$clazz = r5;
        this.$qualifier = r10;
        this.$parameters = r11;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Class<?> r5 = this.$clazz;
        wu.a r10 = this.$qualifier;
        Function0<a> r11 = this.$parameters;
        Intrinsics.checkNotNullParameter(r5, "clazz");
        KClass r12 = JvmClassMappingKt.getKotlinClass(r5);
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L7;
        Intrinsics.checkNotNullParameter(r12, "clazz");
        return r13.f20999a.d.c(r11, r12, r10);
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }
}
