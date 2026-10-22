package com.bytedance.android.annie.bridge.method;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/OpenAPPTYPE;", "", "WEIXIN", "QQ", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum OpenAPPTYPE extends Enum<OpenAPPTYPE> {
    public static final OpenAPPTYPE QQ = null;
    public static final OpenAPPTYPE WEIXIN = null;
    public static final /* synthetic */ OpenAPPTYPE[] a = null;

    public static OpenAPPTYPE valueOf(String r1) {
        return (OpenAPPTYPE) r27.a.a(OpenAPPTYPE.class, r1);
    }

    public static OpenAPPTYPE[] values() {
        return (OpenAPPTYPE[]) a.clone();
    }

    static {
        OpenAPPTYPE r0 = new OpenAPPTYPE("WEIXIN", 0);
        WEIXIN = r0;
        OpenAPPTYPE r1 = new OpenAPPTYPE("QQ", 1);
        QQ = r1;
        a = new OpenAPPTYPE[]{r0, r1};
    }

    public OpenAPPTYPE(String r1, int r10) {
        super(r1, r10);
    }
}
