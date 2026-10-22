package com.bytedance.android.live.gift.tray;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/gift/tray/DialogStatus;", "", "DIALOG_OPEN", "DIALOG_CLOSE", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DialogStatus extends Enum<DialogStatus> {
    public static final DialogStatus DIALOG_CLOSE = null;
    public static final DialogStatus DIALOG_OPEN = null;
    public static final /* synthetic */ DialogStatus[] a = null;

    static {
        DialogStatus r1 = new DialogStatus("DIALOG_OPEN", 0);
        DIALOG_OPEN = r1;
        DialogStatus r2 = new DialogStatus("DIALOG_CLOSE", 1);
        DIALOG_CLOSE = r2;
        a = new DialogStatus[]{r1, r2};
    }

    public static DialogStatus valueOf(String r1) {
        return (DialogStatus) a.a(DialogStatus.class, r1);
    }

    public static DialogStatus[] values() {
        return (DialogStatus[]) a.clone();
    }

    public DialogStatus(String r1, int r2) {
        super(r1, r2);
    }
}
