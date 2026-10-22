package androidx.room.compiler.processing.ksp;

import com.google.devtools.ksp.symbol.Variance;
import com.squareup.kotlinpoet.a0;
import com.squareup.kotlinpoet.b0;
import com.squareup.kotlinpoet.c;
import com.squareup.kotlinpoet.e0;
import com.squareup.kotlinpoet.g0;
import com.squareup.kotlinpoet.u;
import hl.d;
import il.i;
import il.p;
import il.q;
import il.r;
import il.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a=\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u000b\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\r\u001a;\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u000e\u001a;\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u0010\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0012\u001a;\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u0013\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0015\u001a;\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u0016\u001a-\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001e\"\u001e\u0010!\u001a\u00060\u001fj\u0002` 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$*(\b\u0002\u0010&\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002`\u0004`%2\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007¨\u0006'"}, d2 = {"Lil/s;", "Lhl/d;", "resolver", "Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeName;", "asKTypeName", "(Lil/s;Lhl/d;)Lcom/squareup/kotlinpoet/a0;", "Ljava/util/LinkedHashMap;", "Lil/i;", "Landroidx/room/compiler/processing/ksp/KTypeArgumentTypeLookup;", "typeArgumentTypeLookup", "(Lil/s;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/kotlinpoet/a0;", "Lil/d;", "(Lil/d;Lhl/d;)Lcom/squareup/kotlinpoet/a0;", "(Lil/d;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/kotlinpoet/a0;", "Lil/r;", "(Lil/r;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/kotlinpoet/a0;", "Lil/q;", "(Lil/q;Lhl/d;)Lcom/squareup/kotlinpoet/a0;", "(Lil/q;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/kotlinpoet/a0;", "Lil/p;", "(Lil/p;Lhl/d;)Lcom/squareup/kotlinpoet/a0;", "(Lil/p;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/kotlinpoet/a0;", "", "name", "", "bounds", "Lcom/squareup/kotlinpoet/e0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeVariableName;", "createModifiableTypeVariableName", "(Ljava/lang/String;Ljava/util/List;)Lcom/squareup/kotlinpoet/e0;", "Lcom/squareup/kotlinpoet/c;", "Lcom/squareup/kotlinpoet/javapoet/KClassName;", "ERROR_KTYPE_NAME", "Lcom/squareup/kotlinpoet/c;", "getERROR_KTYPE_NAME", "()Lcom/squareup/kotlinpoet/c;", "Lkotlin/collections/LinkedHashMap;", "KTypeArgumentTypeLookup", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KSTypeKotlinPoetExtKt {
    private static final c ERROR_KTYPE_NAME = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Variance.values().length];
            r5[Variance.CONTRAVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[Variance.COVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[Variance.STAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        ERROR_KTYPE_NAME = new c("error", new String[]{"NonExistentClass"});
    }

    public static final /* synthetic */ a0 access$asKTypeName(s r5, d r10, LinkedHashMap r11) {
        return asKTypeName(r5, r10, r11);
    }

    public static final a0 asKTypeName(s r5, d r10) {
        Intrinsics.checkNotNullParameter(r10, "resolver");
        return asKTypeName(r5, r10, new LinkedHashMap());
    }

    private static final a0 asKTypeName$resolveTypeName(q r5, d r10, LinkedHashMap<i, a0> r11) {
        return asKTypeName(r5.getType(), r10, r11);
    }

    private static final e0 createModifiableTypeVariableName(String r5, List<? extends a0> r10) {
        return KTypeVariableNameFactory.newInstance(r5, r10);
    }

    public static final c getERROR_KTYPE_NAME() {
        return ERROR_KTYPE_NAME;
    }

    private static final a0 asKTypeName(s r5, d r10, LinkedHashMap<i, a0> r11) {
        if (r5 == null) goto L6;
        r5.resolve();
        return asKTypeName(null, r10, r11);
    L6:
        return ERROR_KTYPE_NAME;
    }

    public static final a0 asKTypeName(il.d r5, d r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "resolver");
        return asKTypeName(r5, r10, new LinkedHashMap());
    }

    private static final a0 asKTypeName(il.d r5, d r10, LinkedHashMap<i, a0> r11) {
        r5.getQualifiedName();
        return ERROR_KTYPE_NAME;
    }

    private static final a0 asKTypeName(r r5, d r10, LinkedHashMap<i, a0> r11) {
        r5.getName();
        a0 r12 = r11.get(null);
        if (r12 == null) goto L5;
        return r12;
    L5:
        CollectionsKt.mutableListOf(new a0[]{a0.b(b0.f15080a, true, null, 2)});
        r5.getName();
        throw null;
    }

    public static final a0 asKTypeName(q r5, d r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "resolver");
        return asKTypeName(r5, r10, new LinkedHashMap());
    }

    private static final a0 asKTypeName(q r5, d r10, LinkedHashMap<i, a0> r11) {
        Variance r12 = r5.getVariance();
        int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r13 != 1) goto L5;
        a0 r14 = asKTypeName$resolveTypeName(r5, r10, r11);
        Intrinsics.checkNotNullParameter(r14, "inType");
        return new g0(CollectionsKt.listOf(b0.f15080a), CollectionsKt.listOf(r14));
    L5:
        if (r13 != 2) goto L7;
        a0 r15 = asKTypeName$resolveTypeName(r5, r10, r11);
        Intrinsics.checkNotNullParameter(r15, "outType");
        return new g0(CollectionsKt.listOf(r15), CollectionsKt.emptyList());
    L7:
        if (r13 == 3) goto L18;
        if (KSTypeExtKt.hasJvmWildcardAnnotation(r5) == false) goto L17;
        a0 r16 = asKTypeName$resolveTypeName(r5, r10, r11);
        Intrinsics.checkNotNullParameter(r16, "inType");
        return new g0(CollectionsKt.listOf(b0.f15080a), CollectionsKt.listOf(r16));
    L17:
        return asKTypeName$resolveTypeName(r5, r10, r11);
    L18:
        return b0.f15099y;
    }

    public static final a0 asKTypeName(p r5, d r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "resolver");
        return asKTypeName(r5, r10, new LinkedHashMap());
    }

    private static final a0 asKTypeName(p r5, d r10, LinkedHashMap<i, a0> r11) {
        u r12 = null;
        if (r5.getArguments().isEmpty() == false) goto L5;
    L15:
        r5.getDeclaration();
        a0 r13 = asKTypeName(null, r10, r11);
    L17:
        return a0.b(r13, r5.isMarkedNullable(), null, 2);
    L5:
        if (r10.a() == true) goto L15;
        List r14 = r5.getArguments();
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        r15.add(asKTypeName((q) r16.next(), r10, r11));
        goto L8
    L10:
        r5.getDeclaration();
        a0 r17 = asKTypeName(null, r10, r11);
        if ((r17 instanceof c) == false) goto L14;
        c r18 = (c) r17;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Intrinsics.checkNotNullParameter(r15, "typeArguments");
        r13 = new u(r12, r18, r15);
        goto L17
    L14:
        throw new IllegalStateException(("Unexpected type name for KSType: " + r17).toString());
    }
}
