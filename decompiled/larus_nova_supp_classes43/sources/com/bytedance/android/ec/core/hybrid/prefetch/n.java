package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends Converter.Factory {
    public n() {
    }

    public final Converter<TypedInput, ?> responseBodyConverter(Type r10, Annotation[] r11, Retrofit r12) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "annotations");
        Intrinsics.checkNotNullParameter(r12, "retrofit");
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L9;
        if (Intrinsics.areEqual(JvmClassMappingKt.getAnnotationClass(r11[r14]), Reflection.getOrCreateKotlinClass(NaPrefetch.class)) == true) goto L7;
        r14 = r14 + 1;
        goto L3
    L7:
        return new m();
    L9:
        return null;
    }
}
