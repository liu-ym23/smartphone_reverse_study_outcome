package com.bytedance.crash.entity;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ScheduleMsgItem {
    public static final int SCHEDULE_TYPE_IDLE = 0;
    public static final int SCHEDULE_TYPE_LAST_LONG_MSG = 4;
    public static final int SCHEDULE_TYPE_LONG_IDLE = 1;
    public static final int SCHEDULE_TYPE_LONG_MSG = 8;
    public static final int SCHEDULE_TYPE_MSG = 2;
    public static final int SCHEDULE_TYPE_MSGS = 9;
    public static final int SCHEDULE_TYPE_MSGS_IDLE = 7;
    public static final int SCHEDULE_TYPE_MSGS_LONG_IDLE = 5;
    public static final int SCHEDULE_TYPE_MSG_IDLE = 3;
    public static final int SCHEDULE_TYPE_MSG_LONG_IDLE = 6;
    public String mBlockStack;
    public long mDuration;
    public long mDurationCpuTime;
    public long mDurationTick;
    public boolean mIncluseIdle;
    public int mMsgs;
    public String mScheduleMsg;
    public String mSeriousBlockStack;
    public int mType;
    public String uuid;

    public ScheduleMsgItem() {
    }

    public boolean isIdle() {
        int r10 = this.mType;
        if (r10 == 0) goto L16;
        if (r10 != 1) goto L6;
        return true;
    L6:
        if (r10 != 3) goto L8;
        return true;
    L8:
        if (r10 != 6) goto L10;
        return true;
    L10:
        if (r10 != 7) goto L12;
        return true;
    L12:
        if (r10 == 5) goto L21;
        return false;
    L21:
        return true;
    L16:
        return true;
    }

    public JSONObject toJson() {
        JSONObject r10 = new JSONObject();
        r10.put(NotificationCompat.CATEGORY_MESSAGE, this.mScheduleMsg);     // Catch: JSONException -> L10
        r10.put("cpuDuration", this.mDurationCpuTime);     // Catch: JSONException -> L10
        r10.put("duration", this.mDuration);     // Catch: JSONException -> L10
        r10.put(WsConstants.KEY_CONNECTION_TYPE, this.mType);     // Catch: JSONException -> L10
        r10.put(CommonConsts.COUNT_TYPE, this.mMsgs);     // Catch: JSONException -> L10
        String r11 = this.mBlockStack;     // Catch: JSONException -> L10
        if (r11 == null) goto L6;
        r10.put("block_stack", r11);     // Catch: JSONException -> L10
        r10.put("block_uuid", this.uuid);     // Catch: JSONException -> L10
    L6:
        String r12 = this.mSeriousBlockStack;     // Catch: JSONException -> L10
        if (r12 == null) goto L12;
        r10.put("sblock_stack", r12);     // Catch: JSONException -> L10
        r10.put("sblock_uuid", this.uuid);     // Catch: JSONException -> L10
    L12:
        return r10;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public String toString() {
        int r10 = this.mType;
        if (r10 != 0) goto L10;
        StringBuilder r11 = new StringBuilder();
        String r12 = "[[[ IDLE  ]]] mDuration：";
    L5:
        r11.append(r12);
        r11.append(this.mDuration);
        r11.append(",cpuTime:");
    L6:
        r11.append(this.mDurationCpuTime);
    L8:
        return r11.toString();
    L10:
        if (r10 != 1) goto L13;
        r11 = new StringBuilder();
        r12 = "[[[ Long IDLE  ]]] mDuration：";
        goto L5
    L13:
        if (r10 != 2) goto L17;
        r11 = new StringBuilder();
        r11.append("[[[  1 msg  ]]] mDuration：");
        r11.append(this.mDuration);
        r11.append(",cpuTime:");
        r11.append(this.mDurationCpuTime);
        r11.append(", msg:");
    L15:
        r11.append(this.mScheduleMsg);
        goto L8
    L17:
        if (r10 != 3) goto L20;
        r11 = new StringBuilder();
        r12 = "[[[ 1 msg + IDLE  ]]] mDuration：";
        goto L5
    L20:
        if (r10 != 4) goto L24;
        r11 = new StringBuilder();
        r11.append("[[[ ");
        r11.append(this.mMsgs - 1);
        r11.append(" msgs  ]]] mDuration：");
        r11.append(this.mDuration);
        r11.append("cpuTime:");
    L22:
        r11.append(this.mDurationCpuTime);
        r11.append(" msg:");
        goto L15
    L24:
        if (r10 != 5) goto L28;
        r11 = new StringBuilder();
        r11.append("[[[ ");
        r11.append(this.mMsgs);
        String r13 = " msgs ]]]  mDuration：";
    L26:
        r11.append(r13);
        r11.append(this.mDuration);
        r11.append("cpuTime:");
        goto L6
    L28:
        if (r10 != 6) goto L31;
        r11 = new StringBuilder();
        r13 = "[[[  1 msg  ]]]  mDuration：";
        goto L26
    L31:
        if (r10 != 7) goto L35;
        r11 = new StringBuilder();
        r11.append("[[[ ");
        r11.append(this.mMsgs);
        String r14 = " msgs + IDLE  ]]] mDuration：";
    L33:
        r11.append(r14);
        r11.append(this.mDuration);
        r11.append(" cost cpuTime:");
        goto L6
    L35:
        if (r10 != 8) goto L38;
        r11 = new StringBuilder();
        r11.append("[[[ 1 msgs ]]] mDuration：");
        r11.append(this.mDuration);
        r11.append(" cost cpuTime:");
        goto L22
    L38:
        if (r10 != 9) goto L40;
        r11 = new StringBuilder();
        r11.append("[[[ ");
        r11.append(this.mMsgs);
        r14 = " msgs ]]] mDuration：";
        goto L33
    L40:
        r11 = new StringBuilder();
        r11.append("=========   UNKNOW =========  Type: msgs:");
        r11.append(this.mMsgs);
        goto L8
    }
}
