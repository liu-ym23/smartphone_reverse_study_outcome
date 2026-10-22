package com.bytedance.applog.map.api;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applog/map/api/MapSignalSource;", "", AILabCheckPermissionTask.KEY_SOURCE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSource", "CLICK_BEFORE", "CLICK_AFTER", "PAGE_ENTERED", "TIMER", "TIMER_UPDATE", "MORE_DELAY", "DIALOG_SHOW", "DIALOG_HIDDEN", "ROOT_VIEW_ADDED", "ROOT_VIEW_REMOVED", "COLD_START", "CUSTOM", "PLACEHOLDER", "map-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum MapSignalSource extends Enum<MapSignalSource> {
    private static final /* synthetic */ MapSignalSource[] $VALUES = null;
    public static final MapSignalSource CLICK_AFTER = null;
    public static final MapSignalSource CLICK_BEFORE = null;
    public static final MapSignalSource COLD_START = null;
    public static final MapSignalSource CUSTOM = null;
    public static final MapSignalSource DIALOG_HIDDEN = null;
    public static final MapSignalSource DIALOG_SHOW = null;
    public static final MapSignalSource MORE_DELAY = null;
    public static final MapSignalSource PAGE_ENTERED = null;
    public static final MapSignalSource PLACEHOLDER = null;
    public static final MapSignalSource ROOT_VIEW_ADDED = null;
    public static final MapSignalSource ROOT_VIEW_REMOVED = null;
    public static final MapSignalSource TIMER = null;
    public static final MapSignalSource TIMER_UPDATE = null;
    private final String source;

    private static final /* synthetic */ MapSignalSource[] $values() {
        return new MapSignalSource[]{CLICK_BEFORE, CLICK_AFTER, PAGE_ENTERED, TIMER, TIMER_UPDATE, MORE_DELAY, DIALOG_SHOW, DIALOG_HIDDEN, ROOT_VIEW_ADDED, ROOT_VIEW_REMOVED, COLD_START, CUSTOM, PLACEHOLDER};
    }

    static {
        CLICK_BEFORE = new MapSignalSource("CLICK_BEFORE", 0, "click_before");
        CLICK_AFTER = new MapSignalSource("CLICK_AFTER", 1, "click_after");
        PAGE_ENTERED = new MapSignalSource("PAGE_ENTERED", 2, "page_entered");
        TIMER = new MapSignalSource("TIMER", 3, CommonConsts.TIMER_TYPE);
        TIMER_UPDATE = new MapSignalSource("TIMER_UPDATE", 4, "timer_update");
        MORE_DELAY = new MapSignalSource("MORE_DELAY", 5, "more_delay");
        DIALOG_SHOW = new MapSignalSource("DIALOG_SHOW", 6, "dialog_show");
        DIALOG_HIDDEN = new MapSignalSource("DIALOG_HIDDEN", 7, "dialog_hidden");
        ROOT_VIEW_ADDED = new MapSignalSource("ROOT_VIEW_ADDED", 8, "root_view_added");
        ROOT_VIEW_REMOVED = new MapSignalSource("ROOT_VIEW_REMOVED", 9, "root_view_removed");
        COLD_START = new MapSignalSource("COLD_START", 10, "cold_start");
        CUSTOM = new MapSignalSource("CUSTOM", 11, "custom");
        PLACEHOLDER = new MapSignalSource("PLACEHOLDER", 12, "placeholder");
        $VALUES = $values();
    }

    private MapSignalSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.source = r3;
    }

    public static MapSignalSource valueOf(String r2) {
        return (MapSignalSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapSignalSource.class, r2), MapSignalSource.class, "com.obric.memorydata.plugin");
    }

    public static MapSignalSource[] values() {
        return (MapSignalSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapSignalSource[].class, "com.obric.memorydata.plugin");
    }

    public final String getSource() {
        return this.source;
    }
}
