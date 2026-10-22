package com.bytedance.crash.entity;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
        int r2 = this.mType;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L6;
        return true;
    L6:
        if (r2 != 3) goto L8;
        return true;
    L8:
        if (r2 != 6) goto L10;
        return true;
    L10:
        if (r2 != 7) goto L12;
        return true;
    L12:
        if (r2 == 5) goto L21;
        return false;
    L21:
        return true;
    L16:
        return true;
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put(NotificationCompat.CATEGORY_MESSAGE, this.mScheduleMsg);     // Catch: JSONException -> L10
        r0.put("cpuDuration", this.mDurationCpuTime);     // Catch: JSONException -> L10
        r0.put("duration", this.mDuration);     // Catch: JSONException -> L10
        r0.put("type", this.mType);     // Catch: JSONException -> L10
        r0.put(CommonConsts.COUNT_TYPE, this.mMsgs);     // Catch: JSONException -> L10
        String r1 = this.mBlockStack;     // Catch: JSONException -> L10
        if (r1 == null) goto L6;
        r0.put("block_stack", r1);     // Catch: JSONException -> L10
        r0.put("block_uuid", this.uuid);     // Catch: JSONException -> L10
    L6:
        String r2 = this.mSeriousBlockStack;     // Catch: JSONException -> L10
        if (r2 == null) goto L12;
        r0.put("sblock_stack", r2);     // Catch: JSONException -> L10
        r0.put("sblock_uuid", this.uuid);     // Catch: JSONException -> L10
    L12:
        return r0;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public String toString() {
        int r0 = this.mType;
        if (r0 != 0) goto L10;
        StringBuilder r1 = new StringBuilder();
        String r2 = "[[[ IDLE  ]]] mDuration：";
    L5:
        StringBuilder r3 = r1.append(r2).append(this.mDuration).append(",cpuTime:");
    L6:
        StringBuilder r6 = r3.append(this.mDurationCpuTime);
    L8:
        return r6.toString();
    L10:
        if (r0 != 1) goto L13;
        r1 = new StringBuilder();
        r2 = "[[[ Long IDLE  ]]] mDuration：";
        goto L5
    L13:
        if (r0 != 2) goto L17;
        StringBuilder r4 = new StringBuilder().append("[[[  1 msg  ]]] mDuration：").append(this.mDuration).append(",cpuTime:").append(this.mDurationCpuTime).append(", msg:");
    L15:
        r6 = r4.append(this.mScheduleMsg);
        goto L8
    L17:
        if (r0 != 3) goto L20;
        r1 = new StringBuilder();
        r2 = "[[[ 1 msg + IDLE  ]]] mDuration：";
        goto L5
    L20:
        if (r0 != 4) goto L24;
        StringBuilder r5 = new StringBuilder().append("[[[ ").append(this.mMsgs - 1).append(" msgs  ]]] mDuration：").append(this.mDuration).append("cpuTime:");
    L22:
        r4 = r5.append(this.mDurationCpuTime).append(" msg:");
        goto L15
    L24:
        if (r0 != 5) goto L28;
        StringBuilder r7 = new StringBuilder().append("[[[ ").append(this.mMsgs);
        String r8 = " msgs ]]]  mDuration：";
    L26:
        r3 = r7.append(r8).append(this.mDuration).append("cpuTime:");
        goto L6
    L28:
        if (r0 != 6) goto L31;
        r7 = new StringBuilder();
        r8 = "[[[  1 msg  ]]]  mDuration：";
        goto L26
    L31:
        if (r0 != 7) goto L35;
        StringBuilder r9 = new StringBuilder().append("[[[ ").append(this.mMsgs);
        String r10 = " msgs + IDLE  ]]] mDuration：";
    L33:
        r3 = r9.append(r10).append(this.mDuration).append(" cost cpuTime:");
        goto L6
    L35:
        if (r0 != 8) goto L38;
        r5 = new StringBuilder().append("[[[ 1 msgs ]]] mDuration：").append(this.mDuration).append(" cost cpuTime:");
        goto L22
    L38:
        if (r0 != 9) goto L40;
        r9 = new StringBuilder().append("[[[ ").append(this.mMsgs);
        r10 = " msgs ]]] mDuration：";
        goto L33
    L40:
        r6 = new StringBuilder().append("=========   UNKNOW =========  Type: msgs:").append(this.mMsgs);
        goto L8
    }
}
