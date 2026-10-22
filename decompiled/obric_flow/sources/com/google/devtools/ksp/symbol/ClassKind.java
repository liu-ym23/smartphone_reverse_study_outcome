package com.google.devtools.ksp.symbol;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/google/devtools/ksp/symbol/ClassKind;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "INTERFACE", "CLASS", "ENUM_CLASS", "ENUM_ENTRY", "OBJECT", "ANNOTATION_CLASS", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ClassKind extends Enum<ClassKind> {
    public static final ClassKind ANNOTATION_CLASS = null;
    public static final ClassKind CLASS = null;
    public static final ClassKind ENUM_CLASS = null;
    public static final ClassKind ENUM_ENTRY = null;
    public static final ClassKind INTERFACE = null;
    public static final ClassKind OBJECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClassKind[] f9451a = null;
    private final String type;

    static {
        ClassKind r5 = new ClassKind("INTERFACE", 0, "interface");
        INTERFACE = r5;
        ClassKind r10 = new ClassKind("CLASS", 1, "class");
        CLASS = r10;
        ClassKind r11 = new ClassKind("ENUM_CLASS", 2, "enum_class");
        ENUM_CLASS = r11;
        ClassKind r12 = new ClassKind("ENUM_ENTRY", 3, "enum_entry");
        ENUM_ENTRY = r12;
        ClassKind r13 = new ClassKind("OBJECT", 4, "object");
        OBJECT = r13;
        ClassKind r14 = new ClassKind("ANNOTATION_CLASS", 5, "annotation_class");
        ANNOTATION_CLASS = r14;
        f9451a = new ClassKind[]{r5, r10, r11, r12, r13, r14};
    }

    public ClassKind(String r5, int r10, String r11) {
        super(r5, r10);
        this.type = r11;
    }

    public static ClassKind valueOf(String r5) {
        return (ClassKind) Enum.valueOf(ClassKind.class, r5);
    }

    public static ClassKind[] values() {
        return (ClassKind[]) f9451a.clone();
    }

    public final String getType() {
        return this.type;
    }
}
