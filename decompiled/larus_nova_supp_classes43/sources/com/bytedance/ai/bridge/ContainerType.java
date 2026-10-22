package com.bytedance.ai.bridge;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/ContainerType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "WIDGET", "PAGE", "WORKER", "EMBED_WEB_VIEW", "NONE", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType EMBED_WEB_VIEW = null;
    public static final ContainerType NONE = null;
    public static final ContainerType PAGE = null;
    public static final ContainerType WIDGET = null;
    public static final ContainerType WORKER = null;
    public static final /* synthetic */ ContainerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String typeName;

    public static EnumEntries<ContainerType> getEntries() {
        return b;
    }

    static {
        ContainerType r0 = new ContainerType("WIDGET", 0, "widget");
        WIDGET = r0;
        ContainerType r1 = new ContainerType("PAGE", 1, AIStateLogRequest.SOURCE_PAGE);
        PAGE = r1;
        ContainerType r10 = new ContainerType("WORKER", 2, "worker");
        WORKER = r10;
        ContainerType r11 = new ContainerType("EMBED_WEB_VIEW", 3, "embed_webview");
        EMBED_WEB_VIEW = r11;
        ContainerType r12 = new ContainerType("NONE", 4, "unknown");
        NONE = r12;
        ContainerType[] r13 = {r0, r1, r10, r11, r12};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static ContainerType valueOf(String r1) {
        return (ContainerType) a.a(ContainerType.class, r1);
    }

    public ContainerType(String r1, int r10, String r11) {
        super(r1, r10);
        this.typeName = r11;
    }
}
