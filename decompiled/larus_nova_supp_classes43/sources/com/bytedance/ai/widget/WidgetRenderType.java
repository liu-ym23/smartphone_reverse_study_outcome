package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/widget/WidgetRenderType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "UNKNOWN", "WEBVIEW", "LYNX", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WidgetRenderType extends Enum<WidgetRenderType> {
    public static final WidgetRenderType LYNX = null;
    public static final WidgetRenderType UNKNOWN = null;
    public static final WidgetRenderType WEBVIEW = null;
    public static final /* synthetic */ WidgetRenderType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<WidgetRenderType> getEntries() {
        return b;
    }

    static {
        WidgetRenderType r0 = new WidgetRenderType("UNKNOWN", 0, "unknown");
        UNKNOWN = r0;
        WidgetRenderType r1 = new WidgetRenderType("WEBVIEW", 1, "webview");
        WEBVIEW = r1;
        WidgetRenderType r10 = new WidgetRenderType("LYNX", 2, "lynx");
        LYNX = r10;
        WidgetRenderType[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static WidgetRenderType[] values() {
        return (WidgetRenderType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static WidgetRenderType valueOf(String r1) {
        return (WidgetRenderType) r27.a.a(WidgetRenderType.class, r1);
    }

    public WidgetRenderType(String r1, int r10, String r11) {
        super(r1, r10);
        this.type = r11;
    }
}
