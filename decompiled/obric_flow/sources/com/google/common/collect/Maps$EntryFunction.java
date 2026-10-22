package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
abstract enum Maps$EntryFunction extends Enum<Maps$EntryFunction> implements com.google.common.base.q {
    public static final Maps$EntryFunction KEY = null;
    public static final Maps$EntryFunction VALUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Maps$EntryFunction[] f8850a = null;

    static {
        final String r5 = "KEY";
        final int r10 = 0;
        Maps$EntryFunction r11 = new AnonymousClass1(r5, r10);
        KEY = r11;
        final String r12 = "VALUE";
        final int r13 = 1;
        Maps$EntryFunction r14 = new AnonymousClass2(r12, r13);
        VALUE = r14;
        f8850a = new Maps$EntryFunction[]{r11, r14};
    }

    public Maps$EntryFunction(String r5, int r10, c7 r11) {
        super(r5, r10);
    }

    public static Maps$EntryFunction valueOf(String r5) {
        return (Maps$EntryFunction) Enum.valueOf(Maps$EntryFunction.class, r5);
    }

    public static Maps$EntryFunction[] values() {
        return (Maps$EntryFunction[]) f8850a.clone();
    }

    @Override // java.util.function.Function
    public abstract /* synthetic */ Object apply(Object r5);
}
