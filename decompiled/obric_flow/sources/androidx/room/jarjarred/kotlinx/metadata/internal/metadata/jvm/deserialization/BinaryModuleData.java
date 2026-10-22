package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/BinaryModuleData;", "", "annotations", "", "", "optionalAnnotations", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class;", "nameResolver", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "(Ljava/util/List;Ljava/util/List;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;)V", "getAnnotations", "()Ljava/util/List;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getOptionalAnnotations", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BinaryModuleData {
    private final List<String> annotations;
    private final NameResolver nameResolver;
    private final List<ProtoBuf.Class> optionalAnnotations;

    public BinaryModuleData(List<String> r5, List<ProtoBuf.Class> r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Intrinsics.checkNotNullParameter(r10, "optionalAnnotations");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        this.annotations = r5;
        this.optionalAnnotations = r10;
        this.nameResolver = r11;
    }

    public final List<String> getAnnotations() {
        return this.annotations;
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final List<ProtoBuf.Class> getOptionalAnnotations() {
        return this.optionalAnnotations;
    }
}
