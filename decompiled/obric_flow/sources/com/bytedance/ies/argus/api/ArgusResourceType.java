package com.bytedance.ies.argus.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusResourceType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusResourceType extends Enum<ArgusResourceType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArgusResourceType f4952a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusResourceType f4953b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusResourceType f4954c = null;
    public static final ArgusResourceType d = null;
    public static final ArgusResourceType e = null;
    public static final ArgusResourceType f = null;
    public static final ArgusResourceType g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ ArgusResourceType[] f4955h = null;

    static {
        ArgusResourceType r5 = new ArgusResourceType("LYNX_MAIN_TEMPLATE", 0);
        f4952a = r5;
        ArgusResourceType r10 = new ArgusResourceType("LYNX_EXTERNAL_JS", 1);
        f4953b = r10;
        ArgusResourceType r11 = new ArgusResourceType("LYNX_COMPONENT", 2);
        f4954c = r11;
        ArgusResourceType r12 = new ArgusResourceType("LYNX_STATIC_RESOURCE", 3);
        d = r12;
        ArgusResourceType r13 = new ArgusResourceType("LYNX_CHILD_RESOURCE", 4);
        e = r13;
        ArgusResourceType r14 = new ArgusResourceType("OTHER", 5);
        f = r14;
        ArgusResourceType r15 = new ArgusResourceType("UNKNOWN", 6);
        g = r15;
        f4955h = new ArgusResourceType[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public ArgusResourceType(String r5, int r10) {
        super(r5, r10);
    }

    public static ArgusResourceType valueOf(String r5) {
        return (ArgusResourceType) Enum.valueOf(ArgusResourceType.class, r5);
    }

    public static ArgusResourceType[] values() {
        return (ArgusResourceType[]) f4955h.clone();
    }
}
