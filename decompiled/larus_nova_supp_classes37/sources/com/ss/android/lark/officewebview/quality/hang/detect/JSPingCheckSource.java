package com.ss.android.lark.officewebview.quality.hang.detect;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officewebview/quality/hang/detect/JSPingCheckSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AFTER_READY", "NOT_READY_DELAY", "DOUBLE_CHECK", "UNRESPONSIVE", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum JSPingCheckSource extends Enum<JSPingCheckSource> {
    public static final JSPingCheckSource AFTER_READY = null;
    public static final JSPingCheckSource DOUBLE_CHECK = null;
    public static final JSPingCheckSource NOT_READY_DELAY = null;
    public static final JSPingCheckSource UNRESPONSIVE = null;
    public static final /* synthetic */ JSPingCheckSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<JSPingCheckSource> getEntries() {
        return b;
    }

    static {
        JSPingCheckSource r0 = new JSPingCheckSource("AFTER_READY", 0, "afterReady");
        AFTER_READY = r0;
        JSPingCheckSource r1 = new JSPingCheckSource("NOT_READY_DELAY", 1, "notReady");
        NOT_READY_DELAY = r1;
        JSPingCheckSource r2 = new JSPingCheckSource("DOUBLE_CHECK", 2, "doubleCheck");
        DOUBLE_CHECK = r2;
        JSPingCheckSource r4 = new JSPingCheckSource("UNRESPONSIVE", 3, "unresponsive");
        UNRESPONSIVE = r4;
        JSPingCheckSource[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static JSPingCheckSource[] values() {
        return (JSPingCheckSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static JSPingCheckSource valueOf(String r1) {
        return (JSPingCheckSource) a.a(JSPingCheckSource.class, r1);
    }

    public JSPingCheckSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
