package com.larus.uaigc.bean.createpage.component.mediacontainer;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/UIStatus;", "", "<init>", "(Ljava/lang/String;I)V", "STATUS_INIT", "STATUS_FINISH", "STATUS_UPLOAD_FINISH", "STATUS_INSPECT_FAILED", "STATUS_PARSE_FAILED", "STATUS_REFRESH_PROGRESS", "STATUS_UPLOAD_FAIL", "STATUS_DELETE", "STATUS_COMPRESS_SUCCESS", "STATUS_UPDATE_VIDEO_COVER", "STATUS_UPDATE_RESOURCE_BAR_UI", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum UIStatus extends Enum<UIStatus> {
    public static final UIStatus STATUS_COMPRESS_SUCCESS = null;
    public static final UIStatus STATUS_DELETE = null;
    public static final UIStatus STATUS_FINISH = null;
    public static final UIStatus STATUS_INIT = null;
    public static final UIStatus STATUS_INSPECT_FAILED = null;
    public static final UIStatus STATUS_PARSE_FAILED = null;
    public static final UIStatus STATUS_REFRESH_PROGRESS = null;
    public static final UIStatus STATUS_UPDATE_RESOURCE_BAR_UI = null;
    public static final UIStatus STATUS_UPDATE_VIDEO_COVER = null;
    public static final UIStatus STATUS_UPLOAD_FAIL = null;
    public static final UIStatus STATUS_UPLOAD_FINISH = null;
    public static final /* synthetic */ UIStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UIStatus> getEntries() {
        return b;
    }

    static {
        UIStatus r0 = new UIStatus("STATUS_INIT", 0);
        STATUS_INIT = r0;
        UIStatus r1 = new UIStatus("STATUS_FINISH", 1);
        STATUS_FINISH = r1;
        UIStatus r3 = new UIStatus("STATUS_UPLOAD_FINISH", 2);
        STATUS_UPLOAD_FINISH = r3;
        UIStatus r5 = new UIStatus("STATUS_INSPECT_FAILED", 3);
        STATUS_INSPECT_FAILED = r5;
        UIStatus r7 = new UIStatus("STATUS_PARSE_FAILED", 4);
        STATUS_PARSE_FAILED = r7;
        UIStatus r9 = new UIStatus("STATUS_REFRESH_PROGRESS", 5);
        STATUS_REFRESH_PROGRESS = r9;
        UIStatus r11 = new UIStatus("STATUS_UPLOAD_FAIL", 6);
        STATUS_UPLOAD_FAIL = r11;
        UIStatus r13 = new UIStatus("STATUS_DELETE", 7);
        STATUS_DELETE = r13;
        UIStatus r15 = new UIStatus("STATUS_COMPRESS_SUCCESS", 8);
        STATUS_COMPRESS_SUCCESS = r15;
        UIStatus r14 = new UIStatus("STATUS_UPDATE_VIDEO_COVER", 9);
        STATUS_UPDATE_VIDEO_COVER = r14;
        UIStatus r12 = new UIStatus("STATUS_UPDATE_RESOURCE_BAR_UI", 10);
        STATUS_UPDATE_RESOURCE_BAR_UI = r12;
        UIStatus[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static UIStatus[] values() {
        return (UIStatus[]) a.clone();
    }

    public static UIStatus valueOf(String r1) {
        return (UIStatus) a.a(UIStatus.class, r1);
    }

    public UIStatus(String r1, int r2) {
        super(r1, r2);
    }
}
