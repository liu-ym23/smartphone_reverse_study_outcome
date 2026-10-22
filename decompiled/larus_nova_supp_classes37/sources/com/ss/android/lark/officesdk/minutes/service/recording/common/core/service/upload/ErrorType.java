package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/ErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BIZ_SERVER_ERROR", "GATEWAY_ERROR", "CLIENT_ERROR", "OTHER", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum ErrorType extends Enum<ErrorType> {
    public static final ErrorType BIZ_SERVER_ERROR = null;
    public static final ErrorType CLIENT_ERROR = null;
    public static final ErrorType GATEWAY_ERROR = null;
    public static final ErrorType OTHER = null;
    public static final /* synthetic */ ErrorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ErrorType> getEntries() {
        return b;
    }

    static {
        ErrorType r0 = new ErrorType("BIZ_SERVER_ERROR", 0, 0);
        BIZ_SERVER_ERROR = r0;
        ErrorType r1 = new ErrorType("GATEWAY_ERROR", 1, 1);
        GATEWAY_ERROR = r1;
        ErrorType r3 = new ErrorType("CLIENT_ERROR", 2, 2);
        CLIENT_ERROR = r3;
        ErrorType r5 = new ErrorType("OTHER", 3, 3);
        OTHER = r5;
        ErrorType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ErrorType valueOf(String r1) {
        return (ErrorType) r27.a.a(ErrorType.class, r1);
    }

    public ErrorType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
