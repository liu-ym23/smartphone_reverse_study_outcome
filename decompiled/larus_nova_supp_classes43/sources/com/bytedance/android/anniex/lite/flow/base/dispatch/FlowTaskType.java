package com.bytedance.android.anniex.lite.flow.base.dispatch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/dispatch/FlowTaskType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "RouterInitTask", "EnginePreloadTask", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum FlowTaskType extends Enum<FlowTaskType> {
    public static final FlowTaskType EnginePreloadTask = null;
    public static final FlowTaskType RouterInitTask = null;
    public static final /* synthetic */ FlowTaskType[] a = null;
    private final String type;

    public static FlowTaskType valueOf(String r1) {
        return (FlowTaskType) a.a(FlowTaskType.class, r1);
    }

    public static FlowTaskType[] values() {
        return (FlowTaskType[]) a.clone();
    }

    static {
        FlowTaskType r0 = new FlowTaskType("RouterInitTask", 0, "router_init_task");
        RouterInitTask = r0;
        FlowTaskType r1 = new FlowTaskType("EnginePreloadTask", 1, "engine_preload_task");
        EnginePreloadTask = r1;
        a = new FlowTaskType[]{r0, r1};
    }

    public final String getType() {
        return this.type;
    }

    public FlowTaskType(String r1, int r10, String r11) {
        super(r1, r10);
        this.type = r11;
    }
}
