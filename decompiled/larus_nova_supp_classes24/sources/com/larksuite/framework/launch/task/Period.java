package com.larksuite.framework.launch.task;

import com.larus.audio.call.dora.CommandStatus;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum Period extends Enum<Period> {
    public static final Period APP_ONATTACHBASECONTEXT_AFTER_SUPER = null;
    public static final Period APP_ONATTACHBASECONTEXT_BEFORE_SUPER = null;
    public static final Period APP_ONATTACHBASECONTEXT_BEGIN = null;
    public static final Period APP_ONATTACHBASECONTEXT_END = null;
    public static final Period APP_ONCREATE_AFTER_SUPER = null;
    public static final Period APP_ONCREATE_BEFORE_SUPER = null;
    public static final Period APP_ONCREATE_BEGIN = null;
    public static final Period APP_ONCREATE_END = null;
    public static final Period APP_ON_CPU_IDLE = null;
    public static final Period APP_ON_FIRST_SCREEN_SHOWED = null;
    public static final Period NONE = null;
    public static final /* synthetic */ Period[] a = null;
    private int value;

    static {
        Period r0 = new Period("APP_ONATTACHBASECONTEXT_BEGIN", 0, 0);
        APP_ONATTACHBASECONTEXT_BEGIN = r0;
        Period r1 = new Period("APP_ONATTACHBASECONTEXT_BEFORE_SUPER", 1, 1);
        APP_ONATTACHBASECONTEXT_BEFORE_SUPER = r1;
        Period r3 = new Period("APP_ONATTACHBASECONTEXT_AFTER_SUPER", 2, 2);
        APP_ONATTACHBASECONTEXT_AFTER_SUPER = r3;
        Period r5 = new Period("APP_ONATTACHBASECONTEXT_END", 3, 3);
        APP_ONATTACHBASECONTEXT_END = r5;
        Period r7 = new Period("APP_ONCREATE_BEGIN", 4, 4);
        APP_ONCREATE_BEGIN = r7;
        Period r9 = new Period("APP_ONCREATE_BEFORE_SUPER", 5, 5);
        APP_ONCREATE_BEFORE_SUPER = r9;
        Period r11 = new Period("APP_ONCREATE_AFTER_SUPER", 6, 6);
        APP_ONCREATE_AFTER_SUPER = r11;
        Period r13 = new Period("APP_ONCREATE_END", 7, 7);
        APP_ONCREATE_END = r13;
        Period r15 = new Period("APP_ON_FIRST_SCREEN_SHOWED", 8, 8);
        APP_ON_FIRST_SCREEN_SHOWED = r15;
        Period r14 = new Period("APP_ON_CPU_IDLE", 9, 9);
        APP_ON_CPU_IDLE = r14;
        Period r12 = new Period("NONE", 10, CommandStatus.DORA_TRACE);
        NONE = r12;
        a = new Period[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
    }

    public static Period[] values() {
        return (Period[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static Period forNumber(int r0) {
        switch(r0) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return NONE;
    L6:
        return APP_ON_CPU_IDLE;
    L8:
        return APP_ON_FIRST_SCREEN_SHOWED;
    L10:
        return APP_ONCREATE_END;
    L12:
        return APP_ONCREATE_AFTER_SUPER;
    L14:
        return APP_ONCREATE_BEFORE_SUPER;
    L16:
        return APP_ONCREATE_BEGIN;
    L18:
        return APP_ONATTACHBASECONTEXT_END;
    L20:
        return APP_ONATTACHBASECONTEXT_AFTER_SUPER;
    L22:
        return APP_ONATTACHBASECONTEXT_BEFORE_SUPER;
    L24:
        return APP_ONATTACHBASECONTEXT_BEGIN;
    }

    public static Period valueOf(String r1) {
        return (Period) a.a(Period.class, r1);
    }

    public Period(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
