package com.bytedance.ai.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/model/RenderType;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderType[] f2230a = null;

    static {
        RenderType[] r5 = {new RenderType("WEBVIEW", 0, "webview"), new RenderType("LYNX", 1, "lynx"), new RenderType("OTHER", 2, "other"), new RenderType("RELAXVIEW", 3, "relax")};
        f2230a = r5;
        EnumEntriesKt.enumEntries(r5);
    }

    public RenderType(String r5, int r10, String r11) {
        super(r5, r10);
    }

    public static RenderType valueOf(String r5) {
        return (RenderType) Enum.valueOf(RenderType.class, r5);
    }

    public static RenderType[] values() {
        return (RenderType[]) f2230a.clone();
    }
}
