package androidx.room.jarjarred.kotlinx.metadata.impl;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.MutableVersionRequirementTable;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002J\u0012\u0010\u0014\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "", "strings", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/StringTable;", "contextExtensions", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContextExtension;", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;Ljava/util/List;)V", "getContextExtensions", "()Ljava/util/List;", "getStrings", "()Lorg/jetbrains/kotlin/metadata/serialization/StringTable;", "versionRequirements", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/MutableVersionRequirementTable;", "getVersionRequirements", "()Lorg/jetbrains/kotlin/metadata/serialization/MutableVersionRequirementTable;", "get", "", "string", "", "getClassName", "name", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class WriteContext {
    private final List<WriteContextExtension> contextExtensions;
    private final StringTable strings;
    private final MutableVersionRequirementTable versionRequirements;

    /* JADX WARN: Multi-variable type inference failed */
    public WriteContext(StringTable r5, List<? extends WriteContextExtension> r10) {
        Intrinsics.checkNotNullParameter(r5, "strings");
        Intrinsics.checkNotNullParameter(r10, "contextExtensions");
        this.strings = r5;
        this.contextExtensions = r10;
        this.versionRequirements = new MutableVersionRequirementTable();
    }

    public final int get(String r5) {
        Intrinsics.checkNotNullParameter(r5, "string");
        return this.strings.getStringIndex(r5);
    }

    public final int getClassName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return WriteUtilsKt.getClassNameIndex(this.strings, r5);
    }

    public final List<WriteContextExtension> getContextExtensions() {
        return this.contextExtensions;
    }

    public final StringTable getStrings() {
        return this.strings;
    }

    public final MutableVersionRequirementTable getVersionRequirements() {
        return this.versionRequirements;
    }

    public /* synthetic */ WriteContext(StringTable r5, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = CollectionsKt.emptyList();
    L5:
        this(r5, r10);
    }
}
