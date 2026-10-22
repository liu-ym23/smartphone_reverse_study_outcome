package com.ss.android.lark.gadget.container.newcontainer.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum GadgetEvent$Error extends Enum<GadgetEvent$Error> {
    public static final GadgetEvent$Error FORBIDDEN = null;
    public static final GadgetEvent$Error INVALID_PARAM = null;
    public static final GadgetEvent$Error NONE = null;
    public static final GadgetEvent$Error NOT_FOUND = null;
    public static final GadgetEvent$Error UNKNOWN_ERROR = null;
    public static final /* synthetic */ GadgetEvent$Error[] a = null;

    static {
        GadgetEvent$Error r0 = new GadgetEvent$Error("NONE", 0);
        NONE = r0;
        GadgetEvent$Error r1 = new GadgetEvent$Error("NOT_FOUND", 1);
        NOT_FOUND = r1;
        GadgetEvent$Error r3 = new GadgetEvent$Error("INVALID_PARAM", 2);
        INVALID_PARAM = r3;
        GadgetEvent$Error r5 = new GadgetEvent$Error("UNKNOWN_ERROR", 3);
        UNKNOWN_ERROR = r5;
        GadgetEvent$Error r7 = new GadgetEvent$Error("FORBIDDEN", 4);
        FORBIDDEN = r7;
        a = new GadgetEvent$Error[]{r0, r1, r3, r5, r7};
    }

    public static GadgetEvent$Error[] values() {
        return (GadgetEvent$Error[]) a.clone();
    }

    public static GadgetEvent$Error valueOf(String r1) {
        return (GadgetEvent$Error) a.a(GadgetEvent$Error.class, r1);
    }

    public GadgetEvent$Error(String r1, int r2) {
        super(r1, r2);
    }
}
