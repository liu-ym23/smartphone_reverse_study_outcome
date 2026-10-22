package com.drakeet.multitype;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00050\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "position", "item", "Ljava/lang/Class;", "Lum/a;", "invoke", "(ILjava/lang/Object;)Ljava/lang/Class;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
final class OneToManyEndpoint$withKotlinClassLinker$2 extends Lambda implements Function2<Integer, Object, Class<? extends um.a>> {
    final /* synthetic */ Function2 $classLinker;

    public OneToManyEndpoint$withKotlinClassLinker$2(Function2 r5) {
        this.$classLinker = r5;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Class<? extends um.a> mo2invoke(Integer r5, Object r10) {
        return invoke(r5.intValue(), r10);
    }

    public final Class<? extends um.a> invoke(int r5, Object r10) {
        return JvmClassMappingKt.getJavaClass((KClass) this.$classLinker.mo2invoke(Integer.valueOf(r5), r10));
    }
}
