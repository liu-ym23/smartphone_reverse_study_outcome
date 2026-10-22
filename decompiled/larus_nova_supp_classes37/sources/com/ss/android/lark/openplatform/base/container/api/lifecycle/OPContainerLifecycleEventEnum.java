package com.ss.android.lark.openplatform.base.container.api.lifecycle;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum OPContainerLifecycleEventEnum extends Enum<OPContainerLifecycleEventEnum> {
    public static final OPContainerLifecycleEventEnum ON_CREATE = null;
    public static final OPContainerLifecycleEventEnum ON_DESTROY = null;
    public static final OPContainerLifecycleEventEnum ON_HIDE = null;
    public static final OPContainerLifecycleEventEnum ON_SHOW = null;
    public static final OPContainerLifecycleEventEnum ON_STOP = null;
    public static final /* synthetic */ OPContainerLifecycleEventEnum[] a = null;

    static {
        OPContainerLifecycleEventEnum r0 = new OPContainerLifecycleEventEnum("ON_CREATE", 0);
        ON_CREATE = r0;
        OPContainerLifecycleEventEnum r1 = new OPContainerLifecycleEventEnum("ON_SHOW", 1);
        ON_SHOW = r1;
        OPContainerLifecycleEventEnum r3 = new OPContainerLifecycleEventEnum("ON_HIDE", 2);
        ON_HIDE = r3;
        OPContainerLifecycleEventEnum r5 = new OPContainerLifecycleEventEnum("ON_STOP", 3);
        ON_STOP = r5;
        OPContainerLifecycleEventEnum r7 = new OPContainerLifecycleEventEnum("ON_DESTROY", 4);
        ON_DESTROY = r7;
        a = new OPContainerLifecycleEventEnum[]{r0, r1, r3, r5, r7};
    }

    public static OPContainerLifecycleEventEnum[] values() {
        return (OPContainerLifecycleEventEnum[]) a.clone();
    }

    public static OPContainerLifecycleEventEnum valueOf(String r1) {
        return (OPContainerLifecycleEventEnum) a.a(OPContainerLifecycleEventEnum.class, r1);
    }

    public OPContainerLifecycleEventEnum(String r1, int r2) {
        super(r1, r2);
    }
}
