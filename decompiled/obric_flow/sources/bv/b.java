package bv;

import org.sqlite.SQLiteConfig$DateClass;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1012a = null;

    static {
        int[] r5 = new int[SQLiteConfig$DateClass.values().length];
        f1012a = r5;
        r5[SQLiteConfig$DateClass.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f1012a[SQLiteConfig$DateClass.REAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
