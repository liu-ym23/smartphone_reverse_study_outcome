package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class NonEmptyDeserializedAnnotations extends DeserializedAnnotations {
    public NonEmptyDeserializedAnnotations(StorageManager r10, Function0<? extends List<? extends AnnotationDescriptor>> r11) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "compute");
        super(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return false;
    }
}
