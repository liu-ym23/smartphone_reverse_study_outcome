package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/widget/WidgetRenderType;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WidgetRenderType extends Enum<WidgetRenderType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WidgetRenderType f2932b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WidgetRenderType f2933c = null;
    public static final WidgetRenderType d = null;
    public static final WidgetRenderType e = null;
    public static final /* synthetic */ WidgetRenderType[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2934a;

    static {
        WidgetRenderType r5 = new WidgetRenderType("UNKNOWN", 0, "unknown");
        f2932b = r5;
        WidgetRenderType r10 = new WidgetRenderType("WEBVIEW", 1, "webview");
        f2933c = r10;
        WidgetRenderType r11 = new WidgetRenderType("LYNX", 2, "lynx");
        d = r11;
        WidgetRenderType r12 = new WidgetRenderType("RELAX", 3, "relax");
        e = r12;
        WidgetRenderType[] r13 = {r5, r10, r11, r12};
        f = r13;
        EnumEntriesKt.enumEntries(r13);
    }

    public WidgetRenderType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f2934a = r11;
    }

    public static WidgetRenderType valueOf(String r5) {
        return (WidgetRenderType) Enum.valueOf(WidgetRenderType.class, r5);
    }

    public static WidgetRenderType[] values() {
        return (WidgetRenderType[]) f.clone();
    }
}
