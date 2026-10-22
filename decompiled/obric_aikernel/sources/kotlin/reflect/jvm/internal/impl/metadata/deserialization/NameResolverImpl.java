package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class NameResolverImpl implements NameResolver {
    private final ProtoBuf.QualifiedNameTable qualifiedNames;
    private final ProtoBuf.StringTable strings;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            r10[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public NameResolverImpl(ProtoBuf.StringTable r10, ProtoBuf.QualifiedNameTable r11) {
        Intrinsics.checkNotNullParameter(r10, "strings");
        Intrinsics.checkNotNullParameter(r11, "qualifiedNames");
        this.strings = r10;
        this.qualifiedNames = r11;
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int r10) {
        LinkedList r11 = new LinkedList();
        LinkedList r12 = new LinkedList();
        boolean r13 = false;
    L4:
        if (r10 == (-1)) goto L17;
        ProtoBuf.QualifiedNameTable.QualifiedName r14 = this.qualifiedNames.getQualifiedName(r10);
        String r15 = this.strings.getString(r14.getShortName());
        ProtoBuf.QualifiedNameTable.QualifiedName.Kind r16 = r14.getKind();
        Intrinsics.checkNotNull(r16);
        int r17 = WhenMappings.$EnumSwitchMapping$0[r16.ordinal()];
        if (r17 != 1) goto L8;
        r12.addFirst(r15);
    L15:
        r10 = r14.getParentQualifiedName();
        goto L4
    L8:
        if (r17 != 2) goto L10;
        r11.addFirst(r15);
        goto L15
    L10:
        if (r17 != 3) goto L15;
        r12.addFirst(r15);
        r13 = true;
        goto L15
    L17:
        return new Triple(r11, r12, Boolean.valueOf(r13));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r11) {
        Triple<List<String>, List<String>, Boolean> r10 = traverseIds(r11);
        List<String> r12 = r10.component1();
        String r13 = CollectionsKt.joinToString$default(r10.component2(), ".", null, null, 0, null, null, 62, null);
        if (r12.isEmpty() == false) goto L6;
        return r13;
    L6:
        return CollectionsKt.joinToString$default(r12, "/", null, null, 0, null, null, 62, null) + '/' + r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r10) {
        String r11 = this.strings.getString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "strings.getString(index)");
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r10) {
        return traverseIds(r10).getThird().booleanValue();
    }
}
