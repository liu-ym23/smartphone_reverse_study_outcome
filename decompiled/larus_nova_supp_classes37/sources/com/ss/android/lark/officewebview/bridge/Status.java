package com.ss.android.lark.officewebview.bridge;

import com.ss.android.lark.officesdk.api.OfficeSDKDriveErrorCodes;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officewebview/bridge/Status;", "", "status", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "SUCCESS", "FAILURE", "CANCEL", "TIMEOUT", "PROGRESS", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum Status extends Enum<Status> {
    public static final Status CANCEL = null;
    public static final Status FAILURE = null;
    public static final Status PROGRESS = null;
    public static final Status SUCCESS = null;
    public static final Status TIMEOUT = null;
    public static final /* synthetic */ Status[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String status;

    public static EnumEntries<Status> getEntries() {
        return b;
    }

    static {
        Status r0 = new Status("SUCCESS", 0, "success");
        SUCCESS = r0;
        Status r1 = new Status("FAILURE", 1, "failure");
        FAILURE = r1;
        Status r2 = new Status("CANCEL", 2, "cancel");
        CANCEL = r2;
        Status r4 = new Status("TIMEOUT", 3, OfficeSDKDriveErrorCodes.TIMEOUT);
        TIMEOUT = r4;
        Status r6 = new Status("PROGRESS", 4, "progress");
        PROGRESS = r6;
        Status[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static Status[] values() {
        return (Status[]) a.clone();
    }

    public final String getStatus() {
        return this.status;
    }

    public static Status valueOf(String r1) {
        return (Status) a.a(Status.class, r1);
    }

    public Status(String r1, int r2, String r3) {
        super(r1, r2);
        this.status = r3;
    }
}
