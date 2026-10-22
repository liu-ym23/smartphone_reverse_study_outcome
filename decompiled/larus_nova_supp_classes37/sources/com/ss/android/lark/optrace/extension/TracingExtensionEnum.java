package com.ss.android.lark.optrace.extension;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TracingExtensionEnum extends Enum<TracingExtensionEnum> {
    public static final TracingExtensionEnum CLIENT_DURATION = null;
    public static final TracingExtensionEnum CLIENT_REQUEST = null;
    public static final /* synthetic */ TracingExtensionEnum[] a = null;

    static {
        TracingExtensionEnum r0 = new TracingExtensionEnum("CLIENT_DURATION", 0);
        CLIENT_DURATION = r0;
        TracingExtensionEnum r1 = new TracingExtensionEnum("CLIENT_REQUEST", 1);
        CLIENT_REQUEST = r1;
        a = new TracingExtensionEnum[]{r0, r1};
    }

    public static TracingExtensionEnum[] values() {
        return (TracingExtensionEnum[]) a.clone();
    }

    public static TracingExtensionEnum valueOf(String r1) {
        return (TracingExtensionEnum) a.a(TracingExtensionEnum.class, r1);
    }

    public TracingExtensionEnum(String r1, int r2) {
        super(r1, r2);
    }
}
