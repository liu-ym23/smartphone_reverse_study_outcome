package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusLynxSSRUrlVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/d;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusLynxSSRUrlVerifyReason extends Enum<ArgusLynxSSRUrlVerifyReason> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusLynxSSRUrlVerifyReason f5051c = null;
    public static final ArgusLynxSSRUrlVerifyReason d = null;
    public static final ArgusLynxSSRUrlVerifyReason e = null;
    public static final /* synthetic */ ArgusLynxSSRUrlVerifyReason[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5053b;

    static {
        ArgusLynxSSRUrlVerifyReason r5 = new ArgusLynxSSRUrlVerifyReason("NOT_MATCH", 0, -1, "not match white list");
        f5051c = r5;
        ArgusLynxSSRUrlVerifyReason r10 = new ArgusLynxSSRUrlVerifyReason("CONFIG_IS_EMPTY", 1, 1, "config is empty");
        d = r10;
        ArgusLynxSSRUrlVerifyReason r11 = new ArgusLynxSSRUrlVerifyReason("MATCH", 2, 2, "match white list");
        e = r11;
        f = new ArgusLynxSSRUrlVerifyReason[]{r5, r10, r11};
    }

    public ArgusLynxSSRUrlVerifyReason(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f5052a = r11;
        this.f5053b = r12;
    }

    public static ArgusLynxSSRUrlVerifyReason valueOf(String r5) {
        return (ArgusLynxSSRUrlVerifyReason) Enum.valueOf(ArgusLynxSSRUrlVerifyReason.class, r5);
    }

    public static ArgusLynxSSRUrlVerifyReason[] values() {
        return (ArgusLynxSSRUrlVerifyReason[]) f.clone();
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final String a() {
        return this.f5053b;
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final int getCode() {
        return this.f5052a;
    }
}
