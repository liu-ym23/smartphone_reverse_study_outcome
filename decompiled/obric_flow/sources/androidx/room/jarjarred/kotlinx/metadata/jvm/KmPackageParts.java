package androidx.room.jarjarred.kotlinx.metadata.jvm;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KmPackageParts;", "", "fileFacades", "", "", "multiFileClassParts", "", "(Ljava/util/List;Ljava/util/Map;)V", "getFileFacades", "()Ljava/util/List;", "getMultiFileClassParts", "()Ljava/util/Map;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmPackageParts {
    private final List<String> fileFacades;
    private final Map<String, String> multiFileClassParts;

    public KmPackageParts(List<String> r5, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r5, "fileFacades");
        Intrinsics.checkNotNullParameter(r10, "multiFileClassParts");
        this.fileFacades = r5;
        this.multiFileClassParts = r10;
    }

    public final List<String> getFileFacades() {
        return this.fileFacades;
    }

    public final Map<String, String> getMultiFileClassParts() {
        return this.multiFileClassParts;
    }
}
