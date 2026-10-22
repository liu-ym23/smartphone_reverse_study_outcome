package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.jvm.KotlinClassMetadata;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003*\u00020\u0005H\u0000\u001a\u0012\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003*\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"KM_VOID_TYPE", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "readConstructors", "", "Landroidx/room/compiler/processing/javac/kotlin/KmConstructor;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Class;", "readFunctions", "Landroidx/room/compiler/processing/javac/kotlin/KmFunction;", "readProperties", "Landroidx/room/compiler/processing/javac/kotlin/KmProperty;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KotlinClassMetadataUtilsKt {
    private static final KmType KM_VOID_TYPE = null;

    static {
        KM_VOID_TYPE = new KmType(0, CollectionsKt.emptyList(), null, false);
    }

    public static final /* synthetic */ KmType access$getKM_VOID_TYPE$p() {
        return KM_VOID_TYPE;
    }

    public static final List<KmConstructor> readConstructors(KotlinClassMetadata.Class r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r10 = new ArrayList();
        r5.accept(new ConstructorReader(r10));
        return r10;
    }

    public static final List<KmFunction> readFunctions(KotlinClassMetadata.Class r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r10 = new ArrayList();
        r5.accept(new FunctionReader(r10));
        return r10;
    }

    public static final List<KmProperty> readProperties(KotlinClassMetadata.Class r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r10 = new ArrayList();
        r5.accept(new PropertyReader(r10));
        return r10;
    }
}
