package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/CloseReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CLOSE", "RECORDING_END", "PARAMETER_INVALID", "WEBVIEW_CALLBACK_NORMAL", "WEBVIEW_CALLBACK_ERROR", "unexpectedError", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum CloseReason extends Enum<CloseReason> {
    public static final CloseReason PARAMETER_INVALID = null;
    public static final CloseReason RECORDING_END = null;
    public static final CloseReason USER_CLOSE = null;
    public static final CloseReason WEBVIEW_CALLBACK_ERROR = null;
    public static final CloseReason WEBVIEW_CALLBACK_NORMAL = null;
    public static final /* synthetic */ CloseReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CloseReason> getEntries() {
        return b;
    }

    static {
        CloseReason r0 = new CloseReason("USER_CLOSE", 0);
        USER_CLOSE = r0;
        CloseReason r1 = new CloseReason("RECORDING_END", 1);
        RECORDING_END = r1;
        CloseReason r3 = new CloseReason("PARAMETER_INVALID", 2);
        PARAMETER_INVALID = r3;
        CloseReason r5 = new CloseReason("WEBVIEW_CALLBACK_NORMAL", 3);
        WEBVIEW_CALLBACK_NORMAL = r5;
        CloseReason r7 = new CloseReason("WEBVIEW_CALLBACK_ERROR", 4);
        WEBVIEW_CALLBACK_ERROR = r7;
        CloseReason[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static CloseReason[] values() {
        return (CloseReason[]) a.clone();
    }

    public final boolean unexpectedError() {
        if (this != PARAMETER_INVALID) goto L5;
    L8:
        return true;
    L5:
        if (this == WEBVIEW_CALLBACK_ERROR) goto L8;
        return false;
    }

    public static CloseReason valueOf(String r1) {
        return (CloseReason) a.a(CloseReason.class, r1);
    }

    public CloseReason(String r1, int r2) {
        super(r1, r2);
    }
}
