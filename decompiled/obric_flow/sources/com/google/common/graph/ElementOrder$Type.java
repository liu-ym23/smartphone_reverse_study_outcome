package com.google.common.graph;

/* JADX INFO: loaded from: classes2.dex */
public final enum ElementOrder$Type extends Enum<ElementOrder$Type> {
    public static final ElementOrder$Type INSERTION = null;
    public static final ElementOrder$Type SORTED = null;
    public static final ElementOrder$Type STABLE = null;
    public static final ElementOrder$Type UNORDERED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ElementOrder$Type[] f9251a = null;

    static {
        ElementOrder$Type r5 = new ElementOrder$Type("UNORDERED", 0);
        UNORDERED = r5;
        ElementOrder$Type r10 = new ElementOrder$Type("STABLE", 1);
        STABLE = r10;
        ElementOrder$Type r11 = new ElementOrder$Type("INSERTION", 2);
        INSERTION = r11;
        ElementOrder$Type r12 = new ElementOrder$Type("SORTED", 3);
        SORTED = r12;
        f9251a = new ElementOrder$Type[]{r5, r10, r11, r12};
    }

    public static ElementOrder$Type valueOf(String r5) {
        return (ElementOrder$Type) Enum.valueOf(ElementOrder$Type.class, r5);
    }

    public static ElementOrder$Type[] values() {
        return (ElementOrder$Type[]) f9251a.clone();
    }
}
