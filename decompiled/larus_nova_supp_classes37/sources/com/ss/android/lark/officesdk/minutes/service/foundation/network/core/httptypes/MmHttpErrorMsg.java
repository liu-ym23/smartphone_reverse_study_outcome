package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg;", "Ljava/io/Serializable;", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "content", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg$MessageContent;", "getContent", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg$MessageContent;", "setContent", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg$MessageContent;)V", "isShow", "", "()Z", "setShow", "(Z)V", "isOverride", "setOverride", "ErrorDisplayType", "MessageContent", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmHttpErrorMsg implements Serializable {
    private MessageContent content;
    private boolean isOverride;
    private boolean isShow;
    private int type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg$ErrorDisplayType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALERT", "TOAST_NORMAL", "TOAST_SUCCEED", "TOAST_FAILED", "TOAST_INFO", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum ErrorDisplayType extends Enum<ErrorDisplayType> implements Serializable {
        public static final ErrorDisplayType ALERT = null;
        public static final a Companion = null;
        public static final ErrorDisplayType TOAST_FAILED = null;
        public static final ErrorDisplayType TOAST_INFO = null;
        public static final ErrorDisplayType TOAST_NORMAL = null;
        public static final ErrorDisplayType TOAST_SUCCEED = null;
        public static final ErrorDisplayType UNKNOWN = null;
        public static final /* synthetic */ ErrorDisplayType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ErrorDisplayType> getEntries() {
            return b;
        }

        static {
            ErrorDisplayType r0 = new ErrorDisplayType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ErrorDisplayType r1 = new ErrorDisplayType("ALERT", 1, 1);
            ALERT = r1;
            ErrorDisplayType r3 = new ErrorDisplayType("TOAST_NORMAL", 2, 2);
            TOAST_NORMAL = r3;
            ErrorDisplayType r5 = new ErrorDisplayType("TOAST_SUCCEED", 3, 3);
            TOAST_SUCCEED = r5;
            ErrorDisplayType r7 = new ErrorDisplayType("TOAST_FAILED", 4, 4);
            TOAST_FAILED = r7;
            ErrorDisplayType r9 = new ErrorDisplayType("TOAST_INFO", 5, 5);
            TOAST_INFO = r9;
            ErrorDisplayType[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new a();
        }

        public static ErrorDisplayType[] values() {
            return (ErrorDisplayType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ErrorDisplayType valueOf(String r1) {
            return (ErrorDisplayType) r27.a.a(ErrorDisplayType.class, r1);
        }

        public ErrorDisplayType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpErrorMsg$MessageContent;", "Ljava/io/Serializable;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "body", "getBody", "setBody", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class MessageContent implements Serializable {
        private String body;
        private String title;

        public MessageContent() {
        }

        public final String getBody() {
            return this.body;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setBody(String r1) {
            this.body = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }
    }

    public MmHttpErrorMsg() {
    }

    public final MessageContent getContent() {
        return this.content;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isOverride() {
        return this.isOverride;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setContent(MessageContent r1) {
        this.content = r1;
    }

    public final void setOverride(boolean r1) {
        this.isOverride = r1;
    }

    public final void setShow(boolean r1) {
        this.isShow = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }
}
