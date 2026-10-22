package com.larus.bmhome.chat.list.cell.text.interceptor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/interceptor/ErrorEnum;", "", "errorCode", "", "errorMessage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "BLOCK_MESSAGE", "BLOCK_MESSAGE_CONTENT", "UNKNOW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ErrorEnum extends Enum<ErrorEnum> {
    public static final ErrorEnum BLOCK_MESSAGE = null;
    public static final ErrorEnum BLOCK_MESSAGE_CONTENT = null;
    public static final ErrorEnum UNKNOW = null;
    public static final /* synthetic */ ErrorEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int errorCode;
    private final String errorMessage;

    public static EnumEntries<ErrorEnum> getEntries() {
        return b;
    }

    static {
        ErrorEnum r0 = new ErrorEnum("BLOCK_MESSAGE", 0, -1000, "block message id");
        BLOCK_MESSAGE = r0;
        ErrorEnum r1 = new ErrorEnum("BLOCK_MESSAGE_CONTENT", 1, -1001, "block message content");
        BLOCK_MESSAGE_CONTENT = r1;
        ErrorEnum r2 = new ErrorEnum("UNKNOW", 2, -1111, "block message content");
        UNKNOW = r2;
        ErrorEnum[] r5 = {r0, r1, r2};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ErrorEnum[] values() {
        return (ErrorEnum[]) a.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public static ErrorEnum valueOf(String r1) {
        return (ErrorEnum) a.a(ErrorEnum.class, r1);
    }

    public ErrorEnum(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.errorCode = r3;
        this.errorMessage = r4;
    }
}
