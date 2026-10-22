package com.ss.android.lark.forwardv2.impl.utils;

import lib.p;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum ForwardUtil$ReceiveAuthorizationState extends Enum<ForwardUtil$ReceiveAuthorizationState> {
    public static final ForwardUtil$ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_DENY = null;
    public static final ForwardUtil$ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_PASS = null;
    public static final ForwardUtil$ReceiveAuthorizationState MIDDLE_AUTHORIZATION_STATE = null;
    public static final ForwardUtil$ReceiveAuthorizationState NORMAL_STATE = null;
    public static final ForwardUtil$ReceiveAuthorizationState UNKNOWN = null;
    public static final /* synthetic */ ForwardUtil$ReceiveAuthorizationState[] a = null;

    static {
        ForwardUtil$ReceiveAuthorizationState r0 = new ForwardUtil$ReceiveAuthorizationState("UNKNOWN", 0);
        UNKNOWN = r0;
        ForwardUtil$ReceiveAuthorizationState r1 = new ForwardUtil$ReceiveAuthorizationState("MIDDLE_AUTHORIZATION_STATE", 1);
        MIDDLE_AUTHORIZATION_STATE = r1;
        ForwardUtil$ReceiveAuthorizationState r3 = new ForwardUtil$ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_PASS", 2);
        FINAL_AUTHORIZATION_STATE_PASS = r3;
        ForwardUtil$ReceiveAuthorizationState r5 = new ForwardUtil$ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_DENY", 3);
        FINAL_AUTHORIZATION_STATE_DENY = r5;
        ForwardUtil$ReceiveAuthorizationState r7 = new ForwardUtil$ReceiveAuthorizationState("NORMAL_STATE", 4);
        NORMAL_STATE = r7;
        a = new ForwardUtil$ReceiveAuthorizationState[]{r0, r1, r3, r5, r7};
    }

    public static ForwardUtil$ReceiveAuthorizationState[] values() {
        return (ForwardUtil$ReceiveAuthorizationState[]) a.clone();
    }

    public static int valueFrom(ForwardUtil$ReceiveAuthorizationState r2) {
        int r3 = p.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        return 1;
    L5:
        if (r3 != 2) goto L7;
        return 3;
    L7:
        if (r3 != 4) goto L9;
        return 2;
    L9:
        if (r3 == 5) goto L12;
        return 0;
    L12:
        return 4;
    }

    public static ForwardUtil$ReceiveAuthorizationState valueOf(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return UNKNOWN;
    L14:
        return NORMAL_STATE;
    L16:
        return FINAL_AUTHORIZATION_STATE_DENY;
    L18:
        return FINAL_AUTHORIZATION_STATE_PASS;
    L20:
        return MIDDLE_AUTHORIZATION_STATE;
    L22:
        return UNKNOWN;
    }

    public static ForwardUtil$ReceiveAuthorizationState valueOf(String r1) {
        return (ForwardUtil$ReceiveAuthorizationState) a.a(ForwardUtil$ReceiveAuthorizationState.class, r1);
    }

    public ForwardUtil$ReceiveAuthorizationState(String r1, int r2) {
        super(r1, r2);
    }
}
