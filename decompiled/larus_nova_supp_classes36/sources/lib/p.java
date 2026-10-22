package lib;

import com.ss.android.lark.forwardv2.impl.utils.ForwardUtil$ReceiveAuthorizationState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class p {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ForwardUtil$ReceiveAuthorizationState.values().length];
        a = r0;
        r0[ForwardUtil$ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L14:
        a[ForwardUtil$ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L18:
        a[ForwardUtil$ReceiveAuthorizationState.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L22:
        a[ForwardUtil$ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_PASS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L16:
        a[ForwardUtil$ReceiveAuthorizationState.NORMAL_STATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
        return;
    }
}
