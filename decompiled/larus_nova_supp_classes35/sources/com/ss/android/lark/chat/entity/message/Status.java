package com.ss.android.lark.chat.entity.message;

import com.bytedance.lark.pb.basic.v1.AIReply;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/Status;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATUS", "START", "TRANSMIT", "OVER", "FAILED", "NO_RECOMENDATION", "NO_ANSWER", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Status extends Enum<Status> {
    public static final a Companion = null;
    public static final Status FAILED = null;
    public static final Status NO_ANSWER = null;
    public static final Status NO_RECOMENDATION = null;
    public static final Status OVER = null;
    public static final Status START = null;
    public static final Status TRANSMIT = null;
    public static final Status UNKNOWN_STATUS = null;
    public static final /* synthetic */ Status[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static Status a(AIReply.Status r3) {
            Intrinsics.checkNotNullParameter(r3, "status");
            int r4 = r3.getValue();
            Status r0 = Status.UNKNOWN_STATUS;
            if (r4 == r0.getValue()) goto L25;
            Status r1 = Status.START;
            if (r4 == r1.getValue()) goto L26;
            Status r2 = Status.TRANSMIT;
            if (r4 == r2.getValue()) goto L27;
            Status r5 = Status.OVER;
            if (r4 == r5.getValue()) goto L28;
            Status r6 = Status.FAILED;
            if (r4 == r6.getValue()) goto L29;
            Status r7 = Status.NO_RECOMENDATION;
            if (r4 == r7.getValue()) goto L30;
            Status r8 = Status.NO_ANSWER;
            if (r4 == r8.getValue()) goto L23;
            return r7;
        L23:
            return r8;
        L30:
            return r7;
        L29:
            return r6;
        L28:
            return r5;
        L27:
            return r2;
        L26:
            return r1;
        L25:
            return r0;
        }
    }

    public static EnumEntries<Status> getEntries() {
        return b;
    }

    @JvmStatic
    public static final Status parse(AIReply.Status r1) {
        Companion.getClass();
        return a.a(r1);
    }

    static {
        Status r0 = new Status("UNKNOWN_STATUS", 0, 0);
        UNKNOWN_STATUS = r0;
        Status r1 = new Status("START", 1, 1);
        START = r1;
        Status r3 = new Status("TRANSMIT", 2, 2);
        TRANSMIT = r3;
        Status r5 = new Status("OVER", 3, 3);
        OVER = r5;
        Status r7 = new Status("FAILED", 4, 4);
        FAILED = r7;
        Status r9 = new Status("NO_RECOMENDATION", 5, 5);
        NO_RECOMENDATION = r9;
        Status r11 = new Status("NO_ANSWER", 6, 6);
        NO_ANSWER = r11;
        Status[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static Status[] values() {
        return (Status[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Status valueOf(String r1) {
        return (Status) r27.a.a(Status.class, r1);
    }

    public Status(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
