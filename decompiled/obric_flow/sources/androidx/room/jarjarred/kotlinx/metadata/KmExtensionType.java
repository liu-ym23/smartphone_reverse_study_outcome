package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "", "klass", "Lkotlin/reflect/KClass;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionVisitor;", "(Lkotlin/reflect/KClass;)V", "equals", "", "other", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmExtensionType {
    private final KClass<? extends KmExtensionVisitor> klass;

    public KmExtensionType(KClass<? extends KmExtensionVisitor> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        this.klass = r5;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof KmExtensionType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.klass, ((KmExtensionType) r5).klass) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        return JvmClassMappingKt.getJavaClass(this.klass).getName();
    }
}
