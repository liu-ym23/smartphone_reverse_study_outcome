package com.obric.cae.BWDL.BwdlDrop;

import com.sdk.bwdl.ExternalAPI.BWDLConstant;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropConstant {
    public static final String ACCEPT = "user accept";
    public static final String BWLD_DROP_DEVICE_ID = "device_id";
    public static final String BWLD_DROP_SESSION = "bwld_drop_session";
    public static final BWDLConstant.LinkType[] DATA_LINK_TYPES = null;
    public static final int DIRECTION_INBOUND = 1;
    public static final int DIRECTION_OUTBOUND = 0;
    public static final int DISCONNECT_CONTROL_LINK_TIMER = 120000;
    public static final long DROP_ACTIVITY_TIME_OUT = 30000;
    public static final long DROP_SWITCH_PERIOD = 30000;
    public static final long DROP_SWITCH_TIMEOUT = 600000;
    public static final int DROP_TRANSFER_PROCESS_MAX = 100;
    public static final int DROP_TRANSFER_PROCESS_MIN = 0;
    public static final int FAIL_BY_USER_OPERATION = 3;
    public static final int FAIL_FOR_EXTERNAL = 2;
    public static final String FAST_TRANSFER = "fast_transfer";
    public static final String FILE = "file";
    public static final String FILE_COUNT = "fileCount";
    public static final String FILE_NAME = "fileName";
    public static final String FILE_SIZE = "size";
    public static final int INTERRUPT = 4;
    public static final String MIME_TYPE = "mimeType";
    public static final int P2P_FAIL_FOR_SOFT_AP = 8;
    public static final String REASON = "reason";
    public static final String REASON_CAN_NOT_ACCESS = "cannot access";
    public static final String REASON_CONNECTION_LOST = "connection lost";
    public static final String REASON_FILE_NOT_FOUND = "file not found";
    public static final String REASON_NO_ENOUGH_SPACE = "no enough space";
    public static final String REASON_NO_RESPONSE = "no response";
    public static final String REASON_TRANSFER_COMPLETE = "transfer complete";
    public static final String REASON_TRANSFER_INTERRUPT = "transfer interrupt";
    public static final String REASON_USER_INTERRUPT = "user interrupt";
    public static final String REASON_USER_REFUSE = "user refuse";
    public static final int RECEIVER_REFUSE = 2;
    public static final String REJECT = "reject";
    public static final long REMOVE_LINK = 2000;
    public static final String SENDER_NAME = "senderName";
    public static final String SEND_REQUEST = "sendRequest";
    public static final String SEND_RESPONSE = "sendResponse";
    public static final String STATUS = "status";
    public static final String TASK_ID = "taskId";
    public static final int TASK_SUCCESS = 1;
    public static final String TIMEOUT = "timeout";
    public static final String TOTAL_SIZE = "totalSize";
    public static final int TRANSFERRING = 3;
    public static final int TRANSFERRING_BACKGROUND_STATE = 6;
    public static final int TRANSFERRING_STATE = 2;
    public static final int TRANSFER_CANCEL_STATE = 5;
    public static final int TRANSFER_COMPLETE = 5;
    public static final int TRANSFER_COMPLETE_STATE = 3;
    public static final int TRANSFER_FAILED_STATE = 4;
    public static final String TRANSFER_NOTIFY = "transferNotify";
    public static final String TYPE = "type";
    public static final int WAITING_RECEIVER_RESPONSE = 1;
    public static final int WAITING_STATE = 1;

    static {
        DATA_LINK_TYPES = new BWDLConstant.LinkType[]{BWDLConstant.LinkType.P2P, BWDLConstant.LinkType.SocketChannel};
    }

    public BwdlDropConstant() {
    }
}
