package com.ss.android.lark.officewebview.quality.hang.detect;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officewebview/quality/hang/detect/ResetPingSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Normal", "Error", "HangDetected", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum ResetPingSource extends Enum<ResetPingSource> {
    public static final ResetPingSource Error = null;
    public static final ResetPingSource HangDetected = null;
    public static final ResetPingSource Normal = null;
    public static final /* synthetic */ ResetPingSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ResetPingSource> getEntries() {
        return b;
    }

    static {
        ResetPingSource r0 = new ResetPingSource("Normal", 0, "normal");
        Normal = r0;
        ResetPingSource r1 = new ResetPingSource("Error", 1, "error");
        Error = r1;
        ResetPingSource r2 = new ResetPingSource("HangDetected", 2, "hangDetected");
        HangDetected = r2;
        ResetPingSource[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ResetPingSource[] values() {
        return (ResetPingSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ResetPingSource valueOf(String r1) {
        return (ResetPingSource) a.a(ResetPingSource.class, r1);
    }

    public ResetPingSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
