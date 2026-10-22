package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/forest/model/ErrorInfo$Type", "", "Lcom/bytedance/forest/model/ErrorInfo$Type;", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum ErrorInfo$Type extends Enum<ErrorInfo$Type> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ErrorInfo$Type f4309a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ErrorInfo$Type f4310b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ErrorInfo$Type f4311c = null;
    public static final ErrorInfo$Type d = null;
    public static final ErrorInfo$Type e = null;
    public static final ErrorInfo$Type f = null;
    public static final /* synthetic */ ErrorInfo$Type[] g = null;

    static {
        ErrorInfo$Type r5 = new ErrorInfo$Type("Pipeline", 0);
        f4309a = r5;
        ErrorInfo$Type r10 = new ErrorInfo$Type("Memory", 1);
        f4310b = r10;
        ErrorInfo$Type r11 = new ErrorInfo$Type("Gecko", 2);
        f4311c = r11;
        ErrorInfo$Type r12 = new ErrorInfo$Type("Builtin", 3);
        d = r12;
        ErrorInfo$Type r13 = new ErrorInfo$Type("CDN", 4);
        e = r13;
        ErrorInfo$Type r14 = new ErrorInfo$Type("PostProcess", 5);
        f = r14;
        g = new ErrorInfo$Type[]{r5, r10, r11, r12, r13, r14};
    }

    public ErrorInfo$Type(String r5, int r10) {
        super(r5, r10);
    }

    public static ErrorInfo$Type valueOf(String r5) {
        return (ErrorInfo$Type) Enum.valueOf(ErrorInfo$Type.class, r5);
    }

    public static ErrorInfo$Type[] values() {
        return (ErrorInfo$Type[]) g.clone();
    }
}
