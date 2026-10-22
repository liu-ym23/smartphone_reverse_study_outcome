package com.cronutils.mapper;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeekDay f3408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeekDay f3409b = null;
    public static final WeekDay c = null;

    static {
        f3408a = new WeekDay(2, false);
        f3409b = new WeekDay(1, false);
        c = new WeekDay(1, true);
    }

    public static int a(WeekDay r0, WeekDay r1, int r2) {
        return r0.mapTo(r2, r1);
    }
}
