package com.google.devtools.ksp;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import il.b;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lil/b;", ST.IMPLICIT_ARG_NAME, "invoke", "(Lil/b;)Ljava/lang/annotation/Annotation;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class UtilsKt$getAnnotationsByType$2 extends Lambda implements Function1<b, Annotation> {
    final /* synthetic */ KClass<Annotation> $annotationKClass;

    public UtilsKt$getAnnotationsByType$2(KClass<Annotation> r5) {
        this.$annotationKClass = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Annotation invoke(b r5) {
        j0.A(r5);
        return invoke2(null);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Annotation invoke2(b r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        JvmClassMappingKt.getJavaClass(this.$annotationKClass).getClassLoader();
        throw null;
    }
}
