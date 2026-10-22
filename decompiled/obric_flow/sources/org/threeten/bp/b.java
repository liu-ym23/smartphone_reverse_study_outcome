package org.threeten.bp;

import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21135a = null;

    static {
        int[] r5 = new int[ChronoUnit.values().length];
        f21135a = r5;
        r5[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L12:
        f21135a[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L14:
        f21135a[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L18:
        f21135a[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
        return;
    }
}
