package com.larus.camera.impl.monitor;

import gx8.e;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/camera/impl/monitor/CameraEvent;", "Lcom/larus/camera/api/monitor/MonitorEvent;", "", "eventType", "", "uploadName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getEventType", "()Ljava/lang/String;", "getUploadName", "FIRST_FRAME_DURATION", "CAPTURE_DURATION", "CAPTURE_RESULT", "SAVE_LOCAL_RESULT", "PREVIEW_RENDER_FPS", "START_RECORD", "PREVIEW_RECORD", "RECORD_RESULT", "OPEN_CAMERA_RESULT", "OPEN_CAMERA_PAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CameraEvent extends Enum<CameraEvent> implements e {
    public static final CameraEvent CAPTURE_DURATION = null;
    public static final CameraEvent CAPTURE_RESULT = null;
    public static final CameraEvent FIRST_FRAME_DURATION = null;
    public static final CameraEvent OPEN_CAMERA_PAGE = null;
    public static final CameraEvent OPEN_CAMERA_RESULT = null;
    public static final CameraEvent PREVIEW_RECORD = null;
    public static final CameraEvent PREVIEW_RENDER_FPS = null;
    public static final CameraEvent RECORD_RESULT = null;
    public static final CameraEvent SAVE_LOCAL_RESULT = null;
    public static final CameraEvent START_RECORD = null;
    public static final /* synthetic */ CameraEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String eventType;
    private final String uploadName;

    public static EnumEntries<CameraEvent> getEntries() {
        return b;
    }

    static {
        CameraEvent r0 = new CameraEvent("FIRST_FRAME_DURATION", 0, "operation_open_camera", "basic_performance_operation_cost_time");
        FIRST_FRAME_DURATION = r0;
        CameraEvent r1 = new CameraEvent("CAPTURE_DURATION", 1, "operation_shoot", "basic_performance_operation_cost_time");
        CAPTURE_DURATION = r1;
        CameraEvent r5 = new CameraEvent("CAPTURE_RESULT", 2, "operation_shoot", "basic_performance_operation_count");
        CAPTURE_RESULT = r5;
        CameraEvent r7 = new CameraEvent("SAVE_LOCAL_RESULT", 3, "operation_shoot_save", "basic_performance_operation_count");
        SAVE_LOCAL_RESULT = r7;
        CameraEvent r8 = new CameraEvent("PREVIEW_RENDER_FPS", 4, "operation_camera_preview_fps", "basic_performance_operation_smooth");
        PREVIEW_RENDER_FPS = r8;
        CameraEvent r11 = new CameraEvent("START_RECORD", 5, "operation_start_record", "basic_performance_operation_cost_time");
        START_RECORD = r11;
        CameraEvent r13 = new CameraEvent("PREVIEW_RECORD", 6, "operation_record_preview", "basic_performance_operation_cost_time");
        PREVIEW_RECORD = r13;
        CameraEvent r14 = new CameraEvent("RECORD_RESULT", 7, "operation_record", "basic_performance_operation_count");
        RECORD_RESULT = r14;
        CameraEvent r12 = new CameraEvent("OPEN_CAMERA_RESULT", 8, "operation_open_camera", "basic_performance_operation_count");
        OPEN_CAMERA_RESULT = r12;
        CameraEvent r3 = new CameraEvent("OPEN_CAMERA_PAGE", 9, "operation_open_camera_page", "basic_performance_operation_cost_time");
        OPEN_CAMERA_PAGE = r3;
        CameraEvent[] r4 = {r0, r1, r5, r7, r8, r11, r13, r14, r12, r3};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static CameraEvent[] values() {
        return (CameraEvent[]) a.clone();
    }

    @Override // gx8.e
    public String getUniqueKey() {
        return e.a.a(this);
    }

    @Override // gx8.e
    public String getEventType() {
        return this.eventType;
    }

    @Override // gx8.e
    public String getUploadName() {
        return this.uploadName;
    }

    public static CameraEvent valueOf(String r1) {
        return (CameraEvent) a.a(CameraEvent.class, r1);
    }

    public CameraEvent(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.eventType = r3;
        this.uploadName = r4;
    }
}
