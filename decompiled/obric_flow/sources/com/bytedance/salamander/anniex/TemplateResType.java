package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/salamander/anniex/TemplateResType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum TemplateResType extends Enum<TemplateResType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TemplateResType f7230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ TemplateResType[] f7231b = null;

    static {
        TemplateResType r5 = new TemplateResType("Gecko", 0);
        TemplateResType r10 = new TemplateResType("GeckoUpdate", 1);
        TemplateResType r11 = new TemplateResType("CDN", 2);
        TemplateResType r12 = new TemplateResType("CDNCache", 3);
        TemplateResType r13 = new TemplateResType("BuiltIn", 4);
        TemplateResType r14 = new TemplateResType("Offline", 5);
        TemplateResType r15 = new TemplateResType("TemplateBundle", 6);
        TemplateResType r16 = new TemplateResType("BinaryData", 7);
        TemplateResType r17 = new TemplateResType("Unknown", 8);
        f7230a = r17;
        f7231b = new TemplateResType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public TemplateResType(String r5, int r10) {
        super(r5, r10);
    }

    public static TemplateResType valueOf(String r5) {
        return (TemplateResType) Enum.valueOf(TemplateResType.class, r5);
    }

    public static TemplateResType[] values() {
        return (TemplateResType[]) f7231b.clone();
    }
}
