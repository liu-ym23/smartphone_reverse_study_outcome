package com.obric.sva.sdk.session;

import com.obric.sva.framework.wrapper.SoundTriggerWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IWakeupSessionConstant {
    public static final String ACTION_RECOGNITION = "com.qualcomm.qti.sva.ACTION_RECOGNITION";
    public static final String KEY_EXTRA_SM_NAME = "smName";
    public static final int RC_BAD_VALUE = 0;
    public static final int RC_DEAD_OBJECT = 0;
    public static final int RC_ERROR = Integer.MIN_VALUE;
    public static final int RC_FAILURE = -1003;
    public static final int RC_FILE_NOT_EXIST = -1001;
    public static final int RC_INVALID_OPERATION = 0;
    public static final int RC_INVALID_PARAM = -1000;
    public static final int RC_INVALID_SM_MANAGER = -1004;
    public static final int RC_NO_INIT = 0;
    public static final int RC_OK = 0;
    public static final int RC_PERMISSION_DENIED = 0;
    public static final int RC_WRONG_STATUS = -1002;

    static {
        RC_PERMISSION_DENIED = SoundTriggerWrapper.RC_PERMISSION_DENIED;
        RC_NO_INIT = SoundTriggerWrapper.RC_NO_INIT;
        RC_BAD_VALUE = SoundTriggerWrapper.RC_BAD_VALUE;
        RC_DEAD_OBJECT = SoundTriggerWrapper.RC_DEAD_OBJECT;
        RC_INVALID_OPERATION = SoundTriggerWrapper.RC_INVALID_OPERATION;
    }
}
