package com.lynx.animax.base;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum AnimaXError extends Enum<AnimaXError> {
    public static final AnimaXError BLOCK_DEVICE = null;
    public static final AnimaXError LIBRARY_INIT_ERROR = null;
    public static final AnimaXError NO_ERROR = null;
    public static final AnimaXError RESOURCE_NOT_FOUND = null;
    public static final AnimaXError VIDEO_PLAYER_ERROR = null;
    public static final AnimaXError VIDEO_PLAYER_ERROR_HAS_OCCURRED = null;
    public static final /* synthetic */ AnimaXError[] a = null;
    private final int errorCode;

    static {
        AnimaXError r0 = new AnimaXError("NO_ERROR", 0, 0);
        NO_ERROR = r0;
        AnimaXError r1 = new AnimaXError("RESOURCE_NOT_FOUND", 1, 1);
        RESOURCE_NOT_FOUND = r1;
        AnimaXError r3 = new AnimaXError("LIBRARY_INIT_ERROR", 2, 12);
        LIBRARY_INIT_ERROR = r3;
        AnimaXError r5 = new AnimaXError("VIDEO_PLAYER_ERROR", 3, 100);
        VIDEO_PLAYER_ERROR = r5;
        AnimaXError r6 = new AnimaXError("VIDEO_PLAYER_ERROR_HAS_OCCURRED", 4, 101);
        VIDEO_PLAYER_ERROR_HAS_OCCURRED = r6;
        AnimaXError r8 = new AnimaXError("BLOCK_DEVICE", 5, 200);
        BLOCK_DEVICE = r8;
        a = new AnimaXError[]{r0, r1, r3, r5, r6, r8};
    }

    public static Map<String, Object> createBlockErrorParam() {
        HashMap r0 = new HashMap();
        r0.put(LynxResourceModule.CODE_KEY, Integer.valueOf(BLOCK_DEVICE.ordinal()));
        r0.put("msg", "The device is not support.");
        return r0;
    }

    public static Map<String, Object> createLibraryInitErrorParam() {
        HashMap r0 = new HashMap();
        r0.put(LynxResourceModule.CODE_KEY, Integer.valueOf(LIBRARY_INIT_ERROR.ordinal()));
        r0.put("msg", "Library init error.");
        return r0;
    }

    public static AnimaXError[] values() {
        return (AnimaXError[]) a.clone();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public static AnimaXError valueOf(String r1) {
        return (AnimaXError) a.a(AnimaXError.class, r1);
    }

    public AnimaXError(String r1, int r2, int r3) {
        super(r1, r2);
        this.errorCode = r3;
    }
}
