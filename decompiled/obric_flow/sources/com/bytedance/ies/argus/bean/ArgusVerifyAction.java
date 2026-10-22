package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusVerifyAction extends Enum<ArgusVerifyAction> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusVerifyAction f5092b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusVerifyAction f5093c = null;
    public static final ArgusVerifyAction d = null;
    public static final /* synthetic */ ArgusVerifyAction[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5094a;

    static {
        ArgusVerifyAction r5 = new ArgusVerifyAction("PASS", 0, "pass");
        f5092b = r5;
        ArgusVerifyAction r10 = new ArgusVerifyAction("BLOCK", 1, "block");
        f5093c = r10;
        ArgusVerifyAction r11 = new ArgusVerifyAction("REWRITE", 2, "rewrite");
        d = r11;
        e = new ArgusVerifyAction[]{r5, r10, r11};
    }

    public ArgusVerifyAction(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5094a = r11;
    }

    public static ArgusVerifyAction valueOf(String r5) {
        return (ArgusVerifyAction) Enum.valueOf(ArgusVerifyAction.class, r5);
    }

    public static ArgusVerifyAction[] values() {
        return (ArgusVerifyAction[]) e.clone();
    }
}
