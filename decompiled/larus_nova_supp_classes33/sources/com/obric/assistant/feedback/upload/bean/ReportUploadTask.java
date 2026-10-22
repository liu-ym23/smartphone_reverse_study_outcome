package com.obric.assistant.feedback.upload.bean;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ReportUploadTask {
    public final String a;
    public final String b;
    public final Status c;
    public final String d;
    public final boolean e;
    public final List<String> f;
    public final Date g;
    public final boolean h;
    public final Function1<Boolean, Unit> i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/feedback/upload/bean/ReportUploadTask$Status;", "", "description", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "SUCCESS", "BASIC_SUCCESS", "FAILED", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status BASIC_SUCCESS = null;
        public static final Status FAILED = null;
        public static final Status SUCCESS = null;
        public static final Status UNKNOWN = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String description;

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("SUCCESS", 0, "成功");
            SUCCESS = r0;
            Status r1 = new Status("BASIC_SUCCESS", 1, "基本成功");
            BASIC_SUCCESS = r1;
            Status r2 = new Status("FAILED", 2, "失败");
            FAILED = r2;
            Status r4 = new Status("UNKNOWN", 3, "未知");
            UNKNOWN = r4;
            Status[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public final String getDescription() {
            return this.description;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        public Status(String r1, int r2, String r3) {
            super(r1, r2);
            this.description = r3;
        }
    }

    public ReportUploadTask() {
        this(null, false, null, false, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ReportUploadTask) == true) goto L8;
        return false;
    L8:
        ReportUploadTask r6 = (ReportUploadTask) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Status r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        int r13 = 1231;
        if (this.e == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((r15 + r17) * 31) + this.g.hashCode()) * 31;
        if (this.h == true) goto L30;
        r13 = 1237;
    L30:
        int r19 = (r18 + r13) * 31;
        Function1<Boolean, Unit> r20 = this.i;
        if (r20 == null) goto L35;
        r1 = r20.hashCode();
    L35:
        return r19 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = 1237;
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReportUploadTask(sessionId=" + this.a + ", taskQuery=" + this.b + ", status=" + this.c + ", message=" + this.d + ", haveExtraData=" + this.e + ", extraDataPath=" + this.f + ", createTime=" + this.g + ", needLogcat=" + this.h + ", onReportUploadDone=" + this.i + ')';
    }

    public ReportUploadTask(String r8, boolean r9, List r10, boolean r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r12 & 8) == 0) goto L14;
        r8 = "";
    L14:
        if ((r12 & 16) == 0) goto L17;
        r9 = true;
    L17:
        if ((r12 & 32) == 0) goto L20;
        r10 = null;
    L20:
        if ((r12 & 64) == 0) goto L22;
        Date r2 = new Date(System.currentTimeMillis());
    L24:
        if ((r12 & 128) == 0) goto L26;
        r11 = true;
    L26:
        Intrinsics.checkNotNullParameter(r2, "createTime");
        this.a = r0;
        this.b = r3;
        this.c = null;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r2;
        this.h = r11;
        this.i = null;
        return;
    L22:
        r2 = null;
        goto L24
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
