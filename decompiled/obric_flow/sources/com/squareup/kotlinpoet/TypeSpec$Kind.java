package com.squareup.kotlinpoet;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0004\b\t\u0010\u0007J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0004\b\u000b\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"com/squareup/kotlinpoet/TypeSpec$Kind", "", "Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "implicitPropertyModifiers$kotlinpoet", "(Ljava/util/Set;)Ljava/util/Set;", "implicitPropertyModifiers", "implicitFunctionModifiers$kotlinpoet", "implicitFunctionModifiers", "implicitTypeModifiers$kotlinpoet", "implicitTypeModifiers", "", "declarationKeyword", "Ljava/lang/String;", "getDeclarationKeyword$kotlinpoet", "()Ljava/lang/String;", "defaultImplicitPropertyModifiers", "Ljava/util/Set;", "getDefaultImplicitPropertyModifiers$kotlinpoet", "()Ljava/util/Set;", "defaultImplicitFunctionModifiers", "getDefaultImplicitFunctionModifiers$kotlinpoet", "defaultImplicitTypeModifiers", "getDefaultImplicitTypeModifiers$kotlinpoet", "CLASS", "OBJECT", "INTERFACE", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum TypeSpec$Kind extends Enum<TypeSpec$Kind> {
    public static final TypeSpec$Kind CLASS = null;
    public static final TypeSpec$Kind INTERFACE = null;
    public static final TypeSpec$Kind OBJECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeSpec$Kind[] f15071a = null;
    private final String declarationKeyword;
    private final Set<KModifier> defaultImplicitFunctionModifiers;
    private final Set<KModifier> defaultImplicitPropertyModifiers;
    private final Set<KModifier> defaultImplicitTypeModifiers;

    static {
        KModifier r10 = KModifier.PUBLIC;
        TypeSpec$Kind r11 = new TypeSpec$Kind("CLASS", 0, "class", SetsKt.setOf(r10), SetsKt.setOf(r10), SetsKt.emptySet());
        CLASS = r11;
        TypeSpec$Kind r5 = new TypeSpec$Kind("OBJECT", 1, "object", SetsKt.setOf(r10), SetsKt.setOf(r10), SetsKt.emptySet());
        OBJECT = r5;
        KModifier r12 = KModifier.ABSTRACT;
        TypeSpec$Kind r13 = new TypeSpec$Kind("INTERFACE", 2, "interface", SetsKt.setOf(new KModifier[]{r10, r12}), SetsKt.setOf(new KModifier[]{r10, r12}), SetsKt.emptySet());
        INTERFACE = r13;
        f15071a = new TypeSpec$Kind[]{r11, r5, r13};
    }

    public TypeSpec$Kind(String r5, int r10, String r11, Set r12, Set r13, Set r14) {
        super(r5, r10);
        this.declarationKeyword = r11;
        this.defaultImplicitPropertyModifiers = r12;
        this.defaultImplicitFunctionModifiers = r13;
        this.defaultImplicitTypeModifiers = r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set implicitFunctionModifiers$kotlinpoet$default(TypeSpec$Kind r5, Set r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 1) == 0) goto L7;
        r10 = SetsKt.emptySet();
    L7:
        return r5.implicitFunctionModifiers$kotlinpoet(r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: implicitFunctionModifiers");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set implicitTypeModifiers$kotlinpoet$default(TypeSpec$Kind r5, Set r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 1) == 0) goto L7;
        r10 = SetsKt.emptySet();
    L7:
        return r5.implicitTypeModifiers$kotlinpoet(r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: implicitTypeModifiers");
    }

    public static TypeSpec$Kind valueOf(String r5) {
        return (TypeSpec$Kind) Enum.valueOf(TypeSpec$Kind.class, r5);
    }

    public static TypeSpec$Kind[] values() {
        return (TypeSpec$Kind[]) f15071a.clone();
    }

    public final String getDeclarationKeyword$kotlinpoet() {
        return this.declarationKeyword;
    }

    public final Set<KModifier> getDefaultImplicitFunctionModifiers$kotlinpoet() {
        return this.defaultImplicitFunctionModifiers;
    }

    public final Set<KModifier> getDefaultImplicitPropertyModifiers$kotlinpoet() {
        return this.defaultImplicitPropertyModifiers;
    }

    public final Set<KModifier> getDefaultImplicitTypeModifiers$kotlinpoet() {
        return this.defaultImplicitTypeModifiers;
    }

    public final Set<KModifier> implicitFunctionModifiers$kotlinpoet(Set<? extends KModifier> r5) {
        Intrinsics.checkNotNullParameter(r5, "modifiers");
        Set<KModifier> r10 = this.defaultImplicitFunctionModifiers;
        if (r5.contains(KModifier.ANNOTATION) == false) goto L5;
        Set r11 = SetsKt.setOf(KModifier.ABSTRACT);
    L13:
        return SetsKt.plus(r10, r11);
    L5:
        KModifier r12 = KModifier.EXPECT;
        if (r5.contains(r12) == false) goto L8;
        r11 = SetsKt.setOf(r12);
        goto L13
    L8:
        KModifier r13 = KModifier.EXTERNAL;
        if (r5.contains(r13) == false) goto L11;
        r11 = SetsKt.setOf(r13);
        goto L13
    L11:
        r11 = SetsKt.emptySet();
        goto L13
    }

    public final Set<KModifier> implicitPropertyModifiers$kotlinpoet(Set<? extends KModifier> r5) {
        Intrinsics.checkNotNullParameter(r5, "modifiers");
        Set<KModifier> r10 = this.defaultImplicitPropertyModifiers;
        if (r5.contains(KModifier.ANNOTATION) == false) goto L5;
        Set r11 = SetsKt.emptySet();
    L13:
        return SetsKt.plus(r10, r11);
    L5:
        KModifier r12 = KModifier.EXPECT;
        if (r5.contains(r12) == false) goto L8;
        r11 = SetsKt.setOf(r12);
        goto L13
    L8:
        KModifier r13 = KModifier.EXTERNAL;
        if (r5.contains(r13) == false) goto L11;
        r11 = SetsKt.setOf(r13);
        goto L13
    L11:
        r11 = SetsKt.emptySet();
        goto L13
    }

    public final Set<KModifier> implicitTypeModifiers$kotlinpoet(Set<? extends KModifier> r5) {
        Intrinsics.checkNotNullParameter(r5, "modifiers");
        Set<KModifier> r10 = this.defaultImplicitTypeModifiers;
        KModifier r11 = KModifier.EXPECT;
        if (r5.contains(r11) == false) goto L5;
        Set r12 = SetsKt.setOf(r11);
    L10:
        return SetsKt.plus(r10, r12);
    L5:
        KModifier r13 = KModifier.EXTERNAL;
        if (r5.contains(r13) == false) goto L8;
        r12 = SetsKt.setOf(r13);
        goto L10
    L8:
        r12 = SetsKt.emptySet();
        goto L10
    }
}
