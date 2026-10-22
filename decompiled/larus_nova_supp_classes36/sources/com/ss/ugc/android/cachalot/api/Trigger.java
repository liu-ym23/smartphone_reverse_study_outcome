package com.ss.ugc.android.cachalot.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/ugc/android/cachalot/api/Trigger;", "", "", "value", "I", "getValue", "()I", "SCROLL", "SCROLL_STOP", "FIRST_SCREEN_END", "PARALLEL_REFRESH", "PREDICTION", "SERIAL_PRELOADER", "ON_SET_DATA", "ON_SET_DATA_AFTER_LOAD_MORE", "OFF_SCREEN_FORECAST", "DATA_UPDATED", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final enum Trigger extends Enum<Trigger> {
    public static final Trigger DATA_UPDATED = null;
    public static final Trigger FIRST_SCREEN_END = null;
    public static final Trigger OFF_SCREEN_FORECAST = null;
    public static final Trigger ON_SET_DATA = null;
    public static final Trigger ON_SET_DATA_AFTER_LOAD_MORE = null;
    public static final Trigger PARALLEL_REFRESH = null;
    public static final Trigger PREDICTION = null;
    public static final Trigger SCROLL = null;
    public static final Trigger SCROLL_STOP = null;
    public static final Trigger SERIAL_PRELOADER = null;
    public static final /* synthetic */ Trigger[] a = null;
    private final int value;

    public static Trigger valueOf(String r1) {
        return (Trigger) a.a(Trigger.class, r1);
    }

    public static Trigger[] values() {
        return (Trigger[]) a.clone();
    }

    static {
        Trigger r0 = new Trigger("SCROLL", 0, 0);
        SCROLL = r0;
        Trigger r1 = new Trigger("SCROLL_STOP", 1, 1);
        SCROLL_STOP = r1;
        Trigger r3 = new Trigger("FIRST_SCREEN_END", 2, 2);
        FIRST_SCREEN_END = r3;
        Trigger r5 = new Trigger("PARALLEL_REFRESH", 3, 3);
        PARALLEL_REFRESH = r5;
        Trigger r7 = new Trigger("PREDICTION", 4, 4);
        PREDICTION = r7;
        Trigger r9 = new Trigger("SERIAL_PRELOADER", 5, 5);
        SERIAL_PRELOADER = r9;
        Trigger r11 = new Trigger("ON_SET_DATA", 6, 6);
        ON_SET_DATA = r11;
        Trigger r13 = new Trigger("ON_SET_DATA_AFTER_LOAD_MORE", 7, 7);
        ON_SET_DATA_AFTER_LOAD_MORE = r13;
        Trigger r15 = new Trigger("OFF_SCREEN_FORECAST", 8, 8);
        OFF_SCREEN_FORECAST = r15;
        Trigger r14 = new Trigger("DATA_UPDATED", 9, 9);
        DATA_UPDATED = r14;
        a = new Trigger[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    public final int getValue() {
        return this.value;
    }

    public Trigger(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
