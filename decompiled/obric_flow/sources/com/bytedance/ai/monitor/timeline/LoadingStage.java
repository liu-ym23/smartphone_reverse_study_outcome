package com.bytedance.ai.monitor.timeline;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/LoadingStage;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum LoadingStage extends Enum<LoadingStage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingStage[] f2393a = null;

    static {
        LoadingStage[] r5 = {new LoadingStage("STAGE_CREATE_CONTAINER", 0, "createContainer"), new LoadingStage("STAGE_RUN_APPLET_RUNTIME", 1, "runAppletRuntime"), new LoadingStage("STAGE_LOAD_APPLET", 2, "loadApplet"), new LoadingStage("STAGE_LOAD_MAIN_JS", 3, "loadMainJS"), new LoadingStage("STAGE_RUN_MAIN_JS", 4, "runMainJS"), new LoadingStage("STAGE_LOAD_WIDGET", 5, "loadWidget"), new LoadingStage("STAGE_PREPARE_COMPONENT", 6, "prepareComponent"), new LoadingStage("STAGE_LOAD_WIDGET_TEMPLATE", 7, "loadWidgetTemplate"), new LoadingStage("STAGE_RENDER_TEMPLATE", 8, "renderTemplate"), new LoadingStage("STAGE_OPEN_PAGE", 9, "openPage")};
        f2393a = r5;
        EnumEntriesKt.enumEntries(r5);
    }

    public LoadingStage(String r5, int r10, String r11) {
        super(r5, r10);
    }

    public static LoadingStage valueOf(String r5) {
        return (LoadingStage) Enum.valueOf(LoadingStage.class, r5);
    }

    public static LoadingStage[] values() {
        return (LoadingStage[]) f2393a.clone();
    }
}
