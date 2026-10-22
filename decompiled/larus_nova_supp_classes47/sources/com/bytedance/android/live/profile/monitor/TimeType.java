package com.bytedance.android.live.profile.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/profile/monitor/TimeType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "description", "getDescription", "ReceiveOpenProfileEvent", "RequestStart", "RequestEnd", "DialogOnCreate", "DialogOnActivityCreated", "DialogOnCreateDialog", "DialogOnDismiss", "InflateViewStart", "InflateViewEnd", "DialogOnViewCreated", "AssemblePanelStart", "AssemblePanelEnd", "PrepareEnterAnim", "EnterAnimStart", "EnterAnimEnd", "ExitAnimStart", "ExitAnimEnd", "OpenPreLoadPanel", "FinalDataAvailable", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TimeType extends Enum<TimeType> {
    public static final TimeType AssemblePanelEnd = null;
    public static final TimeType AssemblePanelStart = null;
    public static final TimeType DialogOnActivityCreated = null;
    public static final TimeType DialogOnCreate = null;
    public static final TimeType DialogOnCreateDialog = null;
    public static final TimeType DialogOnDismiss = null;
    public static final TimeType DialogOnViewCreated = null;
    public static final TimeType EnterAnimEnd = null;
    public static final TimeType EnterAnimStart = null;
    public static final TimeType ExitAnimEnd = null;
    public static final TimeType ExitAnimStart = null;
    public static final TimeType FinalDataAvailable = null;
    public static final TimeType InflateViewEnd = null;
    public static final TimeType InflateViewStart = null;
    public static final TimeType OpenPreLoadPanel = null;
    public static final TimeType PrepareEnterAnim = null;
    public static final TimeType ReceiveOpenProfileEvent = null;
    public static final TimeType RequestEnd = null;
    public static final TimeType RequestStart = null;
    public static final /* synthetic */ TimeType[] a = null;
    private final String description;
    private final String key;

    public static TimeType valueOf(String r1) {
        return (TimeType) a.a(TimeType.class, r1);
    }

    public static TimeType[] values() {
        return (TimeType[]) a.clone();
    }

    static {
        TimeType r1 = new TimeType("ReceiveOpenProfileEvent", 0, "time_receive_open_profile_event", "接收到打开资料卡的事件");
        ReceiveOpenProfileEvent = r1;
        TimeType r2 = new TimeType("RequestStart", 1, "time_request_start", "发起请求");
        RequestStart = r2;
        TimeType r3 = new TimeType("RequestEnd", 2, "time_request_end", "请求结束");
        RequestEnd = r3;
        TimeType r4 = new TimeType("DialogOnCreate", 3, "time_dialog_on_create", "面板onCreate回调");
        DialogOnCreate = r4;
        TimeType r5 = new TimeType("DialogOnActivityCreated", 4, "time_dialog_on_activity_created", "面板onActivityCreated");
        DialogOnActivityCreated = r5;
        TimeType r6 = new TimeType("DialogOnCreateDialog", 5, "time_dialog_on_create_dialog", "面板onCreateDialog");
        DialogOnCreateDialog = r6;
        TimeType r7 = new TimeType("DialogOnDismiss", 6, "time_dialog_on_dismiss", "面板onDismiss");
        DialogOnDismiss = r7;
        TimeType r8 = new TimeType("InflateViewStart", 7, "time_inflate_view_start", "开始解析资料卡布局");
        InflateViewStart = r8;
        TimeType r9 = new TimeType("InflateViewEnd", 8, "time_inflate_view_end", "解析资料卡布局完成");
        InflateViewEnd = r9;
        TimeType r10 = new TimeType("DialogOnViewCreated", 9, "time_dialog_on_view_created", "面板onViewCreated");
        DialogOnViewCreated = r10;
        TimeType r12 = new TimeType("AssemblePanelStart", 10, "time_assemble_panel_start", "开始组装面板");
        AssemblePanelStart = r12;
        TimeType r13 = new TimeType("AssemblePanelEnd", 11, "time_assemble_panel_end", "组装面板结束");
        AssemblePanelEnd = r13;
        TimeType r14 = new TimeType("PrepareEnterAnim", 12, "time_prepare_enter_anim", "准备入场动画");
        PrepareEnterAnim = r14;
        TimeType r15 = new TimeType("EnterAnimStart", 13, "time_enter_anim_start", "入场动画开始");
        EnterAnimStart = r15;
        TimeType r16 = new TimeType("EnterAnimEnd", 14, "time_enter_anim_end", "入场动画结束");
        EnterAnimEnd = r16;
        TimeType r17 = new TimeType("ExitAnimStart", 15, "time_exit_anim_start", "出场动画开始");
        ExitAnimStart = r17;
        TimeType r18 = new TimeType("ExitAnimEnd", 16, "time_exit_anim_end", "出场动画结束");
        ExitAnimEnd = r18;
        TimeType r19 = new TimeType("OpenPreLoadPanel", 17, "time_open_preload_panel", "打开预加载面板");
        OpenPreLoadPanel = r19;
        TimeType r20 = new TimeType("FinalDataAvailable", 18, "time_final_data_available", "最终数据可用");
        FinalDataAvailable = r20;
        a = new TimeType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20};
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKey() {
        return this.key;
    }

    public TimeType(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.key = r3;
        this.description = r4;
    }
}
