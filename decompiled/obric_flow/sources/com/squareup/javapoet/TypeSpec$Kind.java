package com.squareup.javapoet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public final enum TypeSpec$Kind extends Enum<TypeSpec$Kind> {
    public static final TypeSpec$Kind ANNOTATION = null;
    public static final TypeSpec$Kind CLASS = null;
    public static final TypeSpec$Kind ENUM = null;
    public static final TypeSpec$Kind INTERFACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeSpec$Kind[] f14947a = null;
    private final Set<Modifier> asMemberModifiers;
    private final Set<Modifier> implicitFieldModifiers;
    private final Set<Modifier> implicitMethodModifiers;
    private final Set<Modifier> implicitTypeModifiers;

    static {
        TypeSpec$Kind r10 = new TypeSpec$Kind("CLASS", 0, Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
        CLASS = r10;
        TypeSpec$Kind r5 = new TypeSpec$Kind("INTERFACE", 1, com.bytedance.android.anniex.base.service.f.y(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL})), com.bytedance.android.anniex.base.service.f.y(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.ABSTRACT})), com.bytedance.android.anniex.base.service.f.y(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC})), com.bytedance.android.anniex.base.service.f.y(Collections.singletonList(Modifier.STATIC)));
        INTERFACE = r5;
        TypeSpec$Kind r11 = new TypeSpec$Kind("ENUM", 2, Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.singleton(Modifier.STATIC));
        ENUM = r11;
        TypeSpec$Kind r12 = new TypeSpec$Kind("ANNOTATION", 3, com.bytedance.android.anniex.base.service.f.y(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL})), com.bytedance.android.anniex.base.service.f.y(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.ABSTRACT})), com.bytedance.android.anniex.base.service.f.y(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC})), com.bytedance.android.anniex.base.service.f.y(Collections.singletonList(Modifier.STATIC)));
        ANNOTATION = r12;
        f14947a = new TypeSpec$Kind[]{r10, r5, r11, r12};
    }

    public TypeSpec$Kind(String r5, int r10, Set r11, Set r12, Set r13, Set r14) {
        super(r5, r10);
        this.implicitFieldModifiers = r11;
        this.implicitMethodModifiers = r12;
        this.implicitTypeModifiers = r13;
        this.asMemberModifiers = r14;
    }

    public static /* synthetic */ Set access$1000(TypeSpec$Kind r5) {
        return r5.implicitMethodModifiers;
    }

    public static /* synthetic */ Set access$1100(TypeSpec$Kind r5) {
        return r5.implicitTypeModifiers;
    }

    public static /* synthetic */ Set access$800(TypeSpec$Kind r5) {
        return r5.asMemberModifiers;
    }

    public static /* synthetic */ Set access$900(TypeSpec$Kind r5) {
        return r5.implicitFieldModifiers;
    }

    public static TypeSpec$Kind valueOf(String r5) {
        return (TypeSpec$Kind) Enum.valueOf(TypeSpec$Kind.class, r5);
    }

    public static TypeSpec$Kind[] values() {
        return (TypeSpec$Kind[]) f14947a.clone();
    }
}
