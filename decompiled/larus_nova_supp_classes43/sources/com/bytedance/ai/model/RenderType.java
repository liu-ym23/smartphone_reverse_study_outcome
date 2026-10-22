package com.bytedance.ai.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/model/RenderType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "WEBVIEW", "LYNX", "OTHER", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {
    public static final RenderType LYNX = null;
    public static final RenderType OTHER = null;
    public static final RenderType WEBVIEW = null;
    public static final /* synthetic */ RenderType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String typeName;

    public static EnumEntries<RenderType> getEntries() {
        return b;
    }

    static {
        RenderType r0 = new RenderType("WEBVIEW", 0, "webview");
        WEBVIEW = r0;
        RenderType r1 = new RenderType("LYNX", 1, "lynx");
        LYNX = r1;
        RenderType r10 = new RenderType("OTHER", 2, "other");
        OTHER = r10;
        RenderType[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static RenderType[] values() {
        return (RenderType[]) a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static RenderType valueOf(String r1) {
        return (RenderType) r27.a.a(RenderType.class, r1);
    }

    public RenderType(String r1, int r10, String r11) {
        super(r1, r10);
        this.typeName = r11;
    }
}
