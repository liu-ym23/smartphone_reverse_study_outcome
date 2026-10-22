package com.bytedance.ai.applet.render.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/applet/render/core/RenderType;", "", "type", "", "canReuse", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getType", "()Ljava/lang/String;", "getCanReuse", "()Z", "WEB", "LYNX", "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {
    public static final RenderType LYNX = null;
    public static final RenderType WEB = null;
    public static final /* synthetic */ RenderType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean canReuse;
    private final String type;

    public static EnumEntries<RenderType> getEntries() {
        return b;
    }

    static {
        RenderType r0 = new RenderType("WEB", 0, "webview", false);
        WEB = r0;
        RenderType r1 = new RenderType("LYNX", 1, "lynx", true);
        LYNX = r1;
        RenderType[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static RenderType[] values() {
        return (RenderType[]) a.clone();
    }

    public final boolean getCanReuse() {
        return this.canReuse;
    }

    public final String getType() {
        return this.type;
    }

    public static RenderType valueOf(String r1) {
        return (RenderType) a.a(RenderType.class, r1);
    }

    public RenderType(String r1, int r10, String r11, boolean r12) {
        super(r1, r10);
        this.type = r11;
        this.canReuse = r12;
    }
}
