package com.obric.widget.host;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/widget/host/WidgetRuntimeScenes;", "", "<init>", "()V", "INVALID_INSTANCE_ID", "", "ADD", "", "RESTORE", "MANUAL", "REFRESH_REASON_ON_ADD", "REFRESH_REASON_ON_RESTORE", "REFRESH_REASON_EVENT", "REFRESH_REASON_VISIBILITY_GAIN", "REFRESH_REASON_MANUAL", "REFRESH_REASON_PERIODIC", "REFRESH_REASON_PACKAGE_UPDATE", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRuntimeScenes {
    public static final String ADD = "add";
    public static final WidgetRuntimeScenes INSTANCE = null;
    public static final int INVALID_INSTANCE_ID = -1;
    public static final String MANUAL = "manual";
    public static final String REFRESH_REASON_EVENT = "event";
    public static final String REFRESH_REASON_MANUAL = "manual";
    public static final String REFRESH_REASON_ON_ADD = "onAdd";
    public static final String REFRESH_REASON_ON_RESTORE = "onRestore";
    public static final String REFRESH_REASON_PACKAGE_UPDATE = "packageUpdate";
    public static final String REFRESH_REASON_PERIODIC = "periodic";
    public static final String REFRESH_REASON_VISIBILITY_GAIN = "visibilityGain";
    public static final String RESTORE = "restore";

    static {
        INSTANCE = new WidgetRuntimeScenes();
    }

    private WidgetRuntimeScenes() {
    }
}
