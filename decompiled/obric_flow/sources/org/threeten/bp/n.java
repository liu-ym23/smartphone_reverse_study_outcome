package org.threeten.bp;

import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21272a = null;

    static {
        int[] r5 = new int[ChronoField.values().length];
        f21272a = r5;
        r5[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f21272a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
