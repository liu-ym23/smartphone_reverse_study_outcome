package com.bytedance.lynx.service.security;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum LynxSecurityErrorCode extends Enum<LynxSecurityErrorCode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ LynxSecurityErrorCode[] f6859b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6860a;

    static {
        f6859b = new LynxSecurityErrorCode[]{new LynxSecurityErrorCode("LynxSecurityErrorCodeOk", 0, 0), new LynxSecurityErrorCode("LynxSecurityErrorCodeUnSigned", 1, 1), new LynxSecurityErrorCode("LynxSecurityErrorCodeErrorSign", 2, 2), new LynxSecurityErrorCode("LynxSecurityErrorCodeReadBlockFailed", 3, 3), new LynxSecurityErrorCode("LynxSecurityErrorCodePKNotFound", 4, 4)};
    }

    public LynxSecurityErrorCode(String r5, int r10, int r11) {
        super(r5, r10);
        this.f6860a = r11;
    }

    public static LynxSecurityErrorCode valueOf(String r5) {
        return (LynxSecurityErrorCode) Enum.valueOf(LynxSecurityErrorCode.class, r5);
    }

    public static LynxSecurityErrorCode[] values() {
        return (LynxSecurityErrorCode[]) f6859b.clone();
    }
}
