package com.bytedance.ai.monitor.timeline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/LoadingStage;", "", "stageName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStageName", "()Ljava/lang/String;", "STAGE_CREATE_CONTAINER", "STAGE_RUN_APPLET_RUNTIME", "STAGE_LOAD_APPLET", "STAGE_LOAD_MAIN_JS", "STAGE_RUN_MAIN_JS", "STAGE_LOAD_WIDGET", "STAGE_PREPARE_COMPONENT", "STAGE_LOAD_WIDGET_TEMPLATE", "STAGE_RENDER_TEMPLATE", "STAGE_OPEN_PAGE", "STAGE_BIND_DATA_CANCELLED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadingStage extends Enum<LoadingStage> {
    public static final LoadingStage STAGE_BIND_DATA_CANCELLED = null;
    public static final LoadingStage STAGE_CREATE_CONTAINER = null;
    public static final LoadingStage STAGE_LOAD_APPLET = null;
    public static final LoadingStage STAGE_LOAD_MAIN_JS = null;
    public static final LoadingStage STAGE_LOAD_WIDGET = null;
    public static final LoadingStage STAGE_LOAD_WIDGET_TEMPLATE = null;
    public static final LoadingStage STAGE_OPEN_PAGE = null;
    public static final LoadingStage STAGE_PREPARE_COMPONENT = null;
    public static final LoadingStage STAGE_RENDER_TEMPLATE = null;
    public static final LoadingStage STAGE_RUN_APPLET_RUNTIME = null;
    public static final LoadingStage STAGE_RUN_MAIN_JS = null;
    public static final /* synthetic */ LoadingStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String stageName;

    public static EnumEntries<LoadingStage> getEntries() {
        return b;
    }

    static {
        LoadingStage r0 = new LoadingStage("STAGE_CREATE_CONTAINER", 0, "createContainer");
        STAGE_CREATE_CONTAINER = r0;
        LoadingStage r1 = new LoadingStage("STAGE_RUN_APPLET_RUNTIME", 1, "runAppletRuntime");
        STAGE_RUN_APPLET_RUNTIME = r1;
        LoadingStage r10 = new LoadingStage("STAGE_LOAD_APPLET", 2, "loadApplet");
        STAGE_LOAD_APPLET = r10;
        LoadingStage r11 = new LoadingStage("STAGE_LOAD_MAIN_JS", 3, "loadMainJS");
        STAGE_LOAD_MAIN_JS = r11;
        LoadingStage r12 = new LoadingStage("STAGE_RUN_MAIN_JS", 4, "runMainJS");
        STAGE_RUN_MAIN_JS = r12;
        LoadingStage r13 = new LoadingStage("STAGE_LOAD_WIDGET", 5, "loadWidget");
        STAGE_LOAD_WIDGET = r13;
        LoadingStage r14 = new LoadingStage("STAGE_PREPARE_COMPONENT", 6, "prepareComponent");
        STAGE_PREPARE_COMPONENT = r14;
        LoadingStage r15 = new LoadingStage("STAGE_LOAD_WIDGET_TEMPLATE", 7, "loadWidgetTemplate");
        STAGE_LOAD_WIDGET_TEMPLATE = r15;
        LoadingStage r16 = new LoadingStage("STAGE_RENDER_TEMPLATE", 8, "renderTemplate");
        STAGE_RENDER_TEMPLATE = r16;
        LoadingStage r17 = new LoadingStage("STAGE_OPEN_PAGE", 9, "openPage");
        STAGE_OPEN_PAGE = r17;
        LoadingStage r18 = new LoadingStage("STAGE_BIND_DATA_CANCELLED", 10, "bindDataCancelled");
        STAGE_BIND_DATA_CANCELLED = r18;
        LoadingStage[] r19 = {r0, r1, r10, r11, r12, r13, r14, r15, r16, r17, r18};
        a = r19;
        b = EnumEntriesKt.enumEntries(r19);
    }

    public static LoadingStage[] values() {
        return (LoadingStage[]) a.clone();
    }

    public final String getStageName() {
        return this.stageName;
    }

    public static LoadingStage valueOf(String r1) {
        return (LoadingStage) a.a(LoadingStage.class, r1);
    }

    public LoadingStage(String r1, int r10, String r11) {
        super(r1, r10);
        this.stageName = r11;
    }
}
