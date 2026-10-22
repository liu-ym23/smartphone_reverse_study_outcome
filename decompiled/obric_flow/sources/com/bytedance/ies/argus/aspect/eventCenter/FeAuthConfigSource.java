package com.bytedance.ies.argus.aspect.eventCenter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfigSource;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum FeAuthConfigSource extends Enum<FeAuthConfigSource> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FeAuthConfigSource f4987b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FeAuthConfigSource f4988c = null;
    public static final FeAuthConfigSource d = null;
    public static final /* synthetic */ FeAuthConfigSource[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4989a;

    static {
        FeAuthConfigSource r5 = new FeAuthConfigSource("CONTENT_V2_FROM_LYNX_UN_FOUND", 0, -3);
        f4987b = r5;
        FeAuthConfigSource r10 = new FeAuthConfigSource("LOGIC_ERROR", 1, -2);
        FeAuthConfigSource r11 = new FeAuthConfigSource("NOT_FOUND", 2, -1);
        FeAuthConfigSource r12 = new FeAuthConfigSource("UN_KNOWN", 3, 0);
        f4988c = r12;
        FeAuthConfigSource r13 = new FeAuthConfigSource("CONTENT_V2_FROM_CACHE", 4, 1);
        FeAuthConfigSource r14 = new FeAuthConfigSource("CONTENT_V2_FROM_CALL", 5, 2);
        FeAuthConfigSource r15 = new FeAuthConfigSource("CONTENT_V2_FROM_AUTO_MATCH", 6, 3);
        FeAuthConfigSource r16 = new FeAuthConfigSource("CONTENT_V1_FROM_MATCH", 7, 4);
        FeAuthConfigSource r17 = new FeAuthConfigSource("PRIVATE_DOMAINS", 8, 5);
        FeAuthConfigSource r18 = new FeAuthConfigSource("CONTENT_V1_FROM_CACHE", 9, 6);
        FeAuthConfigSource r19 = new FeAuthConfigSource("CONTENT_V2_FROM_LYNX", 10, 7);
        d = r19;
        e = new FeAuthConfigSource[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    public FeAuthConfigSource(String r5, int r10, int r11) {
        super(r5, r10);
        this.f4989a = r11;
    }

    public static FeAuthConfigSource valueOf(String r5) {
        return (FeAuthConfigSource) Enum.valueOf(FeAuthConfigSource.class, r5);
    }

    public static FeAuthConfigSource[] values() {
        return (FeAuthConfigSource[]) e.clone();
    }
}
