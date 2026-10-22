package com.bytedance.pia.core.tracing;

import com.google.gson.annotations.SerializedName;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;

/* JADX INFO: loaded from: classes2.dex */
public final enum EventName extends Enum<EventName> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("0")
    public static final EventName f7091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST)
    public static final EventName f7092b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("2")
    public static final EventName f7093c = null;

    @SerializedName("3")
    public static final EventName d = null;

    @SerializedName("4")
    public static final EventName e = null;

    @SerializedName("5")
    public static final EventName f = null;

    @SerializedName("6")
    public static final EventName g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("7")
    public static final EventName f7094h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SerializedName("8")
    public static final EventName f7095i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SerializedName("9")
    public static final EventName f7096j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SerializedName("10")
    public static final EventName f7097k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @SerializedName("11")
    public static final EventName f7098l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SerializedName("12")
    public static final EventName f7099m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ EventName[] f7100n = null;

    static {
        EventName r5 = new EventName("NavigateStart", 0);
        f7091a = r5;
        EventName r10 = new EventName("WorkerEnvironmentInitializeStart", 1);
        f7092b = r10;
        EventName r11 = new EventName("WorkerEnvironmentInitializeEnd", 2);
        f7093c = r11;
        EventName r12 = new EventName("WorkerScriptRequestStart", 3);
        d = r12;
        EventName r13 = new EventName("WorkerScriptRequestEnd", 4);
        e = r13;
        EventName r14 = new EventName("WorkerExecuteStart", 5);
        f = r14;
        EventName r15 = new EventName("HTMLRequestStart", 6);
        g = r15;
        EventName r16 = new EventName("HTMLResponseStart", 7);
        f7094h = r16;
        EventName r17 = new EventName("HTMLResponseEnd", 8);
        f7095i = r17;
        EventName r18 = new EventName("ResourceInterceptStart", 9);
        f7096j = r18;
        EventName r19 = new EventName("ResourceInterceptEnd", 10);
        f7097k = r19;
        EventName r110 = new EventName("PreloadResourceStart", 11);
        f7098l = r110;
        EventName r111 = new EventName("PreloadResourceEnd", 12);
        f7099m = r111;
        f7100n = new EventName[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
    }

    public EventName(String r5, int r10) {
        super(r5, r10);
    }

    public static EventName valueOf(String r5) {
        return (EventName) Enum.valueOf(EventName.class, r5);
    }

    public static EventName[] values() {
        return (EventName[]) f7100n.clone();
    }
}
