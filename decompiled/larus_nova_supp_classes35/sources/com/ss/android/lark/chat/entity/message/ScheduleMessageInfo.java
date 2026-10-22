package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001-B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020\u0003J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020 H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/ss/android/lark/chat/entity/message/ScheduleMessageInfo;", "Ljava/io/Serializable;", "item", "Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItem;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItem;)V", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "messageStatus", "Lcom/ss/android/lark/chat/entity/message/ScheduleMessageInfo$ScheduleMessageStatus;", "scheduleTime", BuildConfig.FLAVOR, "(Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItem;Lcom/ss/android/lark/chat/entity/message/Message;Lcom/ss/android/lark/chat/entity/message/ScheduleMessageInfo$ScheduleMessageStatus;J)V", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "setMessage", "(Lcom/ss/android/lark/chat/entity/message/Message;)V", "getMessageStatus", "()Lcom/ss/android/lark/chat/entity/message/ScheduleMessageInfo$ScheduleMessageStatus;", "setMessageStatus", "(Lcom/ss/android/lark/chat/entity/message/ScheduleMessageInfo$ScheduleMessageStatus;)V", "getScheduleTime", "()J", "setScheduleTime", "(J)V", "parentMessageInfo", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "getParentMessageInfo", "()Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "setParentMessageInfo", "(Lcom/ss/android/lark/chat/entity/message/MessageInfo;)V", "getId", BuildConfig.FLAVOR, "getMessageCId", "getScheduleMessageItem", "updateScheduleMessageItem", BuildConfig.FLAVOR, "newItem", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "ScheduleMessageStatus", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScheduleMessageInfo implements Serializable {
    private ScheduleMessageItem item;
    private Message message;
    private ScheduleMessageStatus messageStatus;
    private MessageInfo parentMessageInfo;
    private long scheduleTime;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/ScheduleMessageInfo$ScheduleMessageStatus;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "SEND_PENDING", "SEND_SUCCESS", "SEND_FAIL", "DELETE", "UPDATING", "UPDATE_FAIL", "CREATE_PENDING", "CREATE_FAIL", "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScheduleMessageStatus extends Enum<ScheduleMessageStatus> {
        public static final ScheduleMessageStatus CREATE_FAIL = null;
        public static final ScheduleMessageStatus CREATE_PENDING = null;
        public static final a Companion = null;
        public static final ScheduleMessageStatus DELETE = null;
        public static final ScheduleMessageStatus SEND_FAIL = null;
        public static final ScheduleMessageStatus SEND_PENDING = null;
        public static final ScheduleMessageStatus SEND_SUCCESS = null;
        public static final ScheduleMessageStatus UNKNOWN = null;
        public static final ScheduleMessageStatus UPDATE_FAIL = null;
        public static final ScheduleMessageStatus UPDATING = null;
        public static final /* synthetic */ ScheduleMessageStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ScheduleMessageStatus> getEntries() {
            return b;
        }

        static {
            ScheduleMessageStatus r0 = new ScheduleMessageStatus("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ScheduleMessageStatus r1 = new ScheduleMessageStatus("SEND_PENDING", 1, 1);
            SEND_PENDING = r1;
            ScheduleMessageStatus r3 = new ScheduleMessageStatus("SEND_SUCCESS", 2, 3);
            SEND_SUCCESS = r3;
            ScheduleMessageStatus r5 = new ScheduleMessageStatus("SEND_FAIL", 3, 4);
            SEND_FAIL = r5;
            ScheduleMessageStatus r8 = new ScheduleMessageStatus("DELETE", 4, 5);
            DELETE = r8;
            ScheduleMessageStatus r10 = new ScheduleMessageStatus("UPDATING", 5, 20);
            UPDATING = r10;
            ScheduleMessageStatus r12 = new ScheduleMessageStatus("UPDATE_FAIL", 6, 21);
            UPDATE_FAIL = r12;
            ScheduleMessageStatus r13 = new ScheduleMessageStatus("CREATE_PENDING", 7, 101);
            CREATE_PENDING = r13;
            ScheduleMessageStatus r11 = new ScheduleMessageStatus("CREATE_FAIL", 8, 102);
            CREATE_FAIL = r11;
            ScheduleMessageStatus[] r9 = {r0, r1, r3, r5, r8, r10, r12, r13, r11};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new a();
        }

        public static ScheduleMessageStatus[] values() {
            return (ScheduleMessageStatus[]) a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return name();
        }

        public final int getNumber() {
            return this.number;
        }

        @JvmStatic
        public static final ScheduleMessageStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L27;
            if (r1 == 3) goto L35;
            if (r1 == 4) goto L34;
            if (r1 == 5) goto L33;
            if (r1 == 20) goto L32;
            if (r1 == 21) goto L31;
            if (r1 == 101) goto L30;
            if (r1 == 102) goto L29;
            return UNKNOWN;
        L29:
            return CREATE_FAIL;
        L30:
            return CREATE_PENDING;
        L31:
            return UPDATE_FAIL;
        L32:
            return UPDATING;
        L33:
            return DELETE;
        L34:
            return SEND_FAIL;
        L35:
            return SEND_SUCCESS;
        L27:
            return SEND_PENDING;
        }

        public static ScheduleMessageStatus valueOf(String r1) {
            return (ScheduleMessageStatus) r27.a.a(ScheduleMessageStatus.class, r1);
        }

        public ScheduleMessageStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }

    public final String getId() {
        return this.item.getMessageId();
    }

    public final String getMessageCId() {
        Message r0 = this.message;
        if (r0 == null) goto L6;
        String r1 = r0.getcId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    public int hashCode() {
        Message r0 = this.message;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((r1 * 31) + this.messageStatus.hashCode()) * 31) + ((int) this.scheduleTime);
    L5:
        r1 = 0;
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.item);
        r0.append(", schedule message status = " + this.messageStatus);
        r0.append(", schedule time = " + this.scheduleTime);
        r0.append(", message content = " + this.message);
        return r0.toString();
    }

    public final Message getMessage() {
        return this.message;
    }

    public final ScheduleMessageStatus getMessageStatus() {
        return this.messageStatus;
    }

    public final MessageInfo getParentMessageInfo() {
        return this.parentMessageInfo;
    }

    public final ScheduleMessageItem getScheduleMessageItem() {
        return this.item;
    }

    public final long getScheduleTime() {
        return this.scheduleTime;
    }

    public ScheduleMessageInfo(ScheduleMessageItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        this.messageStatus = ScheduleMessageStatus.UNKNOWN;
        this.scheduleTime = -1;
        this.item = r3;
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof ScheduleMessageInfo) == true) goto L5;
        return false;
    L5:
        ScheduleMessageInfo r8 = (ScheduleMessageInfo) r7;
        if (Intrinsics.areEqual(this.message, r8.message) == true) goto L8;
        return false;
    L8:
        if (this.messageStatus == r8.messageStatus) goto L10;
        return false;
    L10:
        if (this.scheduleTime != r8.scheduleTime) goto L15;
        return true;
    L15:
        return false;
    }

    public final void setMessage(Message r1) {
        this.message = r1;
    }

    public final void setMessageStatus(ScheduleMessageStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.messageStatus = r2;
    }

    public final void setParentMessageInfo(MessageInfo r1) {
        this.parentMessageInfo = r1;
    }

    public final void setScheduleTime(long r1) {
        this.scheduleTime = r1;
    }

    public final void updateScheduleMessageItem(ScheduleMessageItem r2) {
        Intrinsics.checkNotNullParameter(r2, "newItem");
        this.item = r2;
    }

    public ScheduleMessageInfo(ScheduleMessageItem r2, Message r3, ScheduleMessageStatus r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r4, "messageStatus");
        ScheduleMessageStatus.a r0 = ScheduleMessageStatus.Companion;
        this.item = r2;
        this.message = r3;
        this.messageStatus = r4;
        this.scheduleTime = r5;
    }
}
