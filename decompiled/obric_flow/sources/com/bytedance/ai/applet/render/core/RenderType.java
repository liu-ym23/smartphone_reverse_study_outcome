package com.bytedance.ai.applet.render.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/applet/render/core/RenderType;", "", "applet-render-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RenderType f1752c = null;
    public static final RenderType d = null;
    public static final RenderType e = null;
    public static final /* synthetic */ RenderType[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1754b;

    static {
        RenderType r5 = new RenderType("WEB", 0, "webview", false);
        f1752c = r5;
        RenderType r10 = new RenderType("LYNX", 1, "lynx", true);
        d = r10;
        RenderType r11 = new RenderType("RELAX", 2, "relax", false);
        e = r11;
        RenderType[] r12 = {r5, r10, r11};
        f = r12;
        EnumEntriesKt.enumEntries(r12);
    }

    public RenderType(String r5, int r10, String r11, boolean r12) {
        super(r5, r10);
        this.f1753a = r11;
        this.f1754b = r12;
    }

    public static RenderType valueOf(String r5) {
        return (RenderType) Enum.valueOf(RenderType.class, r5);
    }

    public static RenderType[] values() {
        return (RenderType[]) f.clone();
    }
}
