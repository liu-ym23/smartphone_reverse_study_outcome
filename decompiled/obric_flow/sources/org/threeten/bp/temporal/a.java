package org.threeten.bp.temporal;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21282a = null;

    static {
        int[] r5 = new int[IsoFields$Unit.values().length];
        f21282a = r5;
        r5[IsoFields$Unit.WEEK_BASED_YEARS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f21282a[IsoFields$Unit.QUARTER_YEARS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
