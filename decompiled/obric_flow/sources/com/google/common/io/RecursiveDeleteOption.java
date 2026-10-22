package com.google.common.io;

/* JADX INFO: loaded from: classes2.dex */
public final enum RecursiveDeleteOption extends Enum<RecursiveDeleteOption> {
    public static final RecursiveDeleteOption ALLOW_INSECURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecursiveDeleteOption[] f9301a = null;

    static {
        RecursiveDeleteOption r5 = new RecursiveDeleteOption("ALLOW_INSECURE", 0);
        ALLOW_INSECURE = r5;
        f9301a = new RecursiveDeleteOption[]{r5};
    }

    public static RecursiveDeleteOption valueOf(String r5) {
        return (RecursiveDeleteOption) Enum.valueOf(RecursiveDeleteOption.class, r5);
    }

    public static RecursiveDeleteOption[] values() {
        return (RecursiveDeleteOption[]) f9301a.clone();
    }
}
