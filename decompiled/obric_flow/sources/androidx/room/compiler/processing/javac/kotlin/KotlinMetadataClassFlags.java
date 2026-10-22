package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.Flag;
import androidx.room.jarjarred.kotlinx.metadata.jvm.KotlinClassMetadata;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\bJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\bJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\bJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\bJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u001a\u001a\u00060\u0014j\u0002`\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KotlinMetadataClassFlags;", "", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Class;", "classMetadata", "<init>", "(Ljava/lang/Object;)V", "", "isObject", "()Z", "isCompanionObject", "isAnnotationClass", "isInterface", "isClass", "isDataClass", "isValueClass", "isFunctionalInterface", "isExpect", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Class;", "getClassMetadata", "()Ljava/lang/Object;", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags$delegate", "Lkotlin/Lazy;", "getFlags", "()I", "flags", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinMetadataClassFlags {
    private final KotlinClassMetadata.Class classMetadata;
    private final Lazy flags$delegate;

    public KotlinMetadataClassFlags(KotlinClassMetadata.Class r5) {
        Intrinsics.checkNotNullParameter(r5, "classMetadata");
        this.classMetadata = r5;
        this.flags$delegate = LazyKt.lazy(new KotlinMetadataClassFlags$flags$2(this));
    }

    private final int getFlags() {
        return ((Number) this.flags$delegate.getValue()).intValue();
    }

    public final KotlinClassMetadata.Class getClassMetadata() {
        return this.classMetadata;
    }

    public final boolean isAnnotationClass() {
        return Flag.Class.IS_ANNOTATION_CLASS.invoke(getFlags());
    }

    public final boolean isClass() {
        return Flag.Class.IS_CLASS.invoke(getFlags());
    }

    public final boolean isCompanionObject() {
        return Flag.Class.IS_COMPANION_OBJECT.invoke(getFlags());
    }

    public final boolean isDataClass() {
        return Flag.Class.IS_DATA.invoke(getFlags());
    }

    public final boolean isExpect() {
        return Flag.Class.IS_EXPECT.invoke(getFlags());
    }

    public final boolean isFunctionalInterface() {
        return Flag.Class.IS_FUN.invoke(getFlags());
    }

    public final boolean isInterface() {
        return Flag.Class.IS_INTERFACE.invoke(getFlags());
    }

    public final boolean isObject() {
        return Flag.Class.IS_OBJECT.invoke(getFlags());
    }

    public final boolean isValueClass() {
        return Flag.Class.IS_VALUE.invoke(getFlags());
    }
}
