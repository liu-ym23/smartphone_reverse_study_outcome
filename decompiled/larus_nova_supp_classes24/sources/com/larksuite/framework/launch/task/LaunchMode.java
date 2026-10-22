package com.larksuite.framework.launch.task;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum LaunchMode extends Enum<LaunchMode> {
    public static final LaunchMode ALL = null;
    public static final LaunchMode NORMAL = null;
    public static final LaunchMode SIMPLE = null;
    public static final LaunchMode UNAUTHORIZED = null;
    public static final /* synthetic */ LaunchMode[] a = null;
    private int value;

    static {
        LaunchMode r0 = new LaunchMode("NORMAL", 0, 0);
        NORMAL = r0;
        LaunchMode r1 = new LaunchMode("SIMPLE", 1, 1);
        SIMPLE = r1;
        LaunchMode r3 = new LaunchMode("UNAUTHORIZED", 2, 2);
        UNAUTHORIZED = r3;
        LaunchMode r5 = new LaunchMode("ALL", 3, 3);
        ALL = r5;
        a = new LaunchMode[]{r0, r1, r3, r5};
    }

    public static LaunchMode[] values() {
        return (LaunchMode[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static LaunchMode forNumber(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return NORMAL;
    L11:
        return ALL;
    L13:
        return SIMPLE;
    L15:
        return UNAUTHORIZED;
    }

    public static LaunchMode valueOf(String r1) {
        return (LaunchMode) a.a(LaunchMode.class, r1);
    }

    public LaunchMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
