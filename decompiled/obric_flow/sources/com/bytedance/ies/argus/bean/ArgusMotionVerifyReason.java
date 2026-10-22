package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusMotionVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/d;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusMotionVerifyReason extends Enum<ArgusMotionVerifyReason> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArgusMotionVerifyReason f5075a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ArgusMotionVerifyReason[] f5076b = null;

    static {
        ArgusMotionVerifyReason r5 = new ArgusMotionVerifyReason();
        f5075a = r5;
        f5076b = new ArgusMotionVerifyReason[]{r5};
    }

    public ArgusMotionVerifyReason() {
        super("MATCH_SCENE", 0);
    }

    public static ArgusMotionVerifyReason valueOf(String r5) {
        return (ArgusMotionVerifyReason) Enum.valueOf(ArgusMotionVerifyReason.class, r5);
    }

    public static ArgusMotionVerifyReason[] values() {
        return (ArgusMotionVerifyReason[]) f5076b.clone();
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final String a() {
        return "match scene";
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final int getCode() {
        return 1;
    }
}
