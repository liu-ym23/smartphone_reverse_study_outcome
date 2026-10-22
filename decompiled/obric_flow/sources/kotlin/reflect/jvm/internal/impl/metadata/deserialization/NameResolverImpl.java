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

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r10) {
        Triple<List<String>, List<String>, Boolean> r11 = traverseIds(r10);
        List<String> r5 = r11.component1();
        String r12 = CollectionsKt.q(r11.component2(), ".", null, null, 0, null, null, 62);
        if (r5.isEmpty() == false) goto L6;
        return r12;
    L6:
        return CollectionsKt.q(r5, "/", null, null, 0, null, null, 62) + '/' + r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r5) {
        return this.strings.getString(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r5) {
        return traverseIds(r5).getThird().booleanValue();
    }
}
