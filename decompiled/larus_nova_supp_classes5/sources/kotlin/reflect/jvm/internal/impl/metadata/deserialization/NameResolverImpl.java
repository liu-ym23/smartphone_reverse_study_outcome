package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class NameResolverImpl implements NameResolver {
    private final ProtoBuf$QualifiedNameTable qualifiedNames;
    private final ProtoBuf$StringTable strings;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.values().length];
            r0[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int r8) {
        LinkedList r0 = new LinkedList();
        LinkedList r1 = new LinkedList();
        boolean r2 = false;
    L4:
        if (r8 == (-1)) goto L18;
        ProtoBuf$QualifiedNameTable.QualifiedName r9 = this.qualifiedNames.getQualifiedName(r8);
        String r3 = this.strings.getString(r9.getShortName());
        ProtoBuf$QualifiedNameTable.QualifiedName.Kind r4 = r9.getKind();
        Intrinsics.checkNotNull(r4);
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L8;
        r1.addFirst(r3);
    L16:
        r8 = r9.getParentQualifiedName();
        goto L4
    L8:
        if (r5 != 2) goto L10;
        r0.addFirst(r3);
        goto L16
    L10:
        if (r5 != 3) goto L13;
        r1.addFirst(r3);
        r2 = true;
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    L18:
        return new Triple(r0, r1, Boolean.valueOf(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r12) {
        Triple<List<String>, List<String>, Boolean> r13 = traverseIds(r12);
        List<String> r0 = r13.component1();
        String r14 = CollectionsKt.joinToString$default(r13.component2(), ".", null, null, 0, null, null, 62, null);
        if (r0.isEmpty() == false) goto L6;
        return r14;
    L6:
        return CollectionsKt.joinToString$default(r0, "/", null, null, 0, null, null, 62, null) + '/' + r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r2) {
        return this.strings.getString(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r1) {
        return traverseIds(r1).getThird().booleanValue();
    }

    public NameResolverImpl(ProtoBuf$StringTable r2, ProtoBuf$QualifiedNameTable r3) {
        Intrinsics.checkNotNullParameter(r2, "strings");
        Intrinsics.checkNotNullParameter(r3, "qualifiedNames");
        this.strings = r2;
        this.qualifiedNames = r3;
    }
}
