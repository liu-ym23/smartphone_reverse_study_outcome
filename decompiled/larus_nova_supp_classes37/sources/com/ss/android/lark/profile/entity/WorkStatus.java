package com.ss.android.lark.profile.entity;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.t;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class WorkStatus implements Serializable {
    private static final long serialVersionUID = -4077423738789762558L;
    public final String description;
    public final long endTime;
    public final boolean isCrossTenant;
    public final long startTime;
    public final Status status;

    public static final enum Status extends Enum<Status> {
        public static final Status ON_LEAVE = null;
        public static final Status ON_MEETING = null;
        public static final Status UNKNOWN = null;
        public static final /* synthetic */ Status[] a = null;
        private int value;

        static {
            Status r0 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Status r1 = new Status("ON_LEAVE", 1, 1);
            ON_LEAVE = r1;
            Status r3 = new Status("ON_MEETING", 2, 2);
            ON_MEETING = r3;
            a = new Status[]{r0, r1, r3};
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static /* synthetic */ int access$000(Status r0) {
            return r0.value;
        }

        public static Status valueOf(int r1) {
            if (r1 != 1) goto L6;
            return ON_LEAVE;
        L6:
            if (r1 != 2) goto L9;
            return ON_MEETING;
        L9:
            return UNKNOWN;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public String toString() {
        return "WorkStatus{status=" + this.status + ", description='" + this.description + "', startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
    }

    public WorkStatus() {
        this.status = Status.UNKNOWN;
        this.description = "";
        this.startTime = -1;
        this.endTime = -1;
        this.isCrossTenant = false;
    }

    public static boolean isInvalid(WorkStatus r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if (r3.status != Status.UNKNOWN) goto L10;
        Log.w("WorkStatus", "status is UNKNOWN ，" + r3.toString());
        return true;
    L10:
        if (r3.isCrossTenant == false) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof WorkStatus) == true) goto L5;
        return false;
    L5:
        WorkStatus r8 = (WorkStatus) r7;
        if (TextUtils.equals(this.description, r8.description) == true) goto L9;
        return false;
    L9:
        if (this.startTime == r8.startTime) goto L12;
        return false;
    L12:
        if (this.endTime == r8.endTime) goto L14;
        return false;
    L14:
        Status r0 = this.status;
        if (r0 != null) goto L17;
    L22:
        if (r0 == null) goto L24;
    L26:
        return false;
    L24:
        if (r8.status != null) goto L26;
        return true;
    L17:
        if (r8.status == null) goto L22;
        if (Status.access$000(r0) != Status.access$000(r8.status)) goto L27;
        return true;
    L27:
        return false;
    }

    public String getDisplayTextNoDuration(Context r2) {
        return a(r2, false);
    }

    public String getDisplayTextWithDuration(Context r2) {
        return a(r2, true);
    }

    public final String a(Context r9, boolean r10) {
        if (r10 == false) goto L10;
        long r0 = this.startTime * 1000;
        String[] r11 = t.a;
        String r1 = f.a(UIUtils.getString(r9, 2131891614), r0, null, null);
        String r12 = f.a(UIUtils.getString(r9, 2131891614), this.endTime * 1000, null, null);
        if (TextUtils.equals(r1, r12) == false) goto L8;
        return r1 + " " + this.description;
    L8:
        return r1 + "-" + r12 + " " + this.description;
    L10:
        return this.description;
    }

    public WorkStatus(Status r1, String r2, long r3, long r5, boolean r7) {
        this.status = r1;
        this.description = r2;
        this.startTime = r3;
        this.endTime = r5;
        this.isCrossTenant = r7;
    }
}
