package org.threeten.bp.format;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21210a = null;

    static {
        int[] r5 = new int[SignStyle.values().length];
        f21210a = r5;
        r5[SignStyle.EXCEEDS_PAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L12:
        f21210a[SignStyle.ALWAYS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L14:
        f21210a[SignStyle.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L18:
        f21210a[SignStyle.NOT_NEGATIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
        return;
    }
}
