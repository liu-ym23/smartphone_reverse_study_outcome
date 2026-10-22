package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u0013\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0016\u001a\u00020\u000eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolverImpl;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/NameResolver;", "strings", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$StringTable;", "qualifiedNames", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$QualifiedNameTable;", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$StringTable;Lorg/jetbrains/kotlin/metadata/ProtoBuf$QualifiedNameTable;)V", "getQualifiedNames", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$QualifiedNameTable;", "getStrings", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$StringTable;", "getPackageFqName", "", "index", "", "getQualifiedClassName", "getString", "isLocalClassName", "", "traverseIds", "Lkotlin/Triple;", "", "startingIndex", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NameResolverImpl implements NameResolver {
    private final ProtoBuf.QualifiedNameTable qualifiedNames;
    private final ProtoBuf.StringTable strings;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            r5[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public NameResolverImpl(ProtoBuf.StringTable r5, ProtoBuf.QualifiedNameTable r10) {
        Intrinsics.checkNotNullParameter(r5, "strings");
        Intrinsics.checkNotNullParameter(r10, "qualifiedNames");
        this.strings = r5;
        this.qualifiedNames = r10;
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int r10) {
        LinkedList r5 = new LinkedList();
        LinkedList r11 = new LinkedList();
        boolean r12 = false;
    L4:
        if (r10 == (-1)) goto L17;
        ProtoBuf.QualifiedNameTable.QualifiedName r13 = this.qualifiedNames.getQualifiedName(r10);
        String r14 = this.strings.getString(r13.getShortName());
        ProtoBuf.QualifiedNameTable.QualifiedName.Kind r15 = r13.getKind();
        Intrinsics.checkNotNull(r15);
        int r16 = WhenMappings.$EnumSwitchMapping$0[r15.ordinal()];
        if (r16 != 1) goto L8;
        r11.addFirst(r14);
    L15:
        r10 = r13.getParentQualifiedName();
        goto L4
    L8:
        if (r16 != 2) goto L10;
        r5.addFirst(r14);
        goto L15
    L10:
        if (r16 != 3) goto L15;
        r11.addFirst(r14);
        r12 = true;
        goto L15
    L17:
        return new Triple(r5, r11, Boolean.valueOf(r12));
    }

    public final String getPackageFqName(int r10) {
        return CollectionsKt.q(traverseIds(r10).getFirst(), ".", null, null, 0, null, null, 62);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r10) {
        Triple<List<String>, List<String>, Boolean> r11 = traverseIds(r10);
        List<String> r5 = r11.component1();
        String r12 = CollectionsKt.q(r11.component2(), ".", null, null, 0, null, null, 62);
        if (r5.isEmpty() == false) goto L6;
        return r12;
    L6:
        return CollectionsKt.q(r5, "/", null, null, 0, null, null, 62) + '/' + r12;
    }

    public final ProtoBuf.QualifiedNameTable getQualifiedNames() {
        return this.qualifiedNames;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver
    public String getString(int r5) {
        return this.strings.getString(r5);
    }

    public final ProtoBuf.StringTable getStrings() {
        return this.strings;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r5) {
        return traverseIds(r5).getThird().booleanValue();
    }
}
