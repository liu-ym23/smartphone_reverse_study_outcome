package com.bytedance.ai.bridge.method.file;

import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.filesystem.filemethods.AbsGetFileInfoMethodIDL;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/GetFileInfoMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetFileInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetFileInfoMethodIDL$GetFileInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetFileInfoMethodIDL$GetFileInfoParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetFileInfoMethod extends AbsGetFileInfoMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetFileInfoMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsGetFileInfoMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        g r1 = g.a;
        StringBuilder r12 = new StringBuilder("call start, digestAlgorithm=");
        r12.append(r11.getDigestAlgorithm());
        r12.append(", appletId=");
        a0 r13 = r10.getContainerContext();
        if (r13 == null) goto L5;
        String r14 = r13.getAppletId();
    L6:
        r12.append(r14);
        r1.i("AISDK_JSB_GetFileInfoMethod", r12.toString());
        AppletFileManager r15 = x3.a.d(r10);
        if (r15 == null) goto L9;
        int r16 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L15
        com.bytedance.ai.file.a r17 = com.bytedance.ai.file.a.C0040a.a(r11.getFilePath());     // Catch: AppletFileError -> L15
        AppletFileManager.b r18 = r15.m(r17);     // Catch: AppletFileError -> L15
        Intrinsics.checkNotNullParameter(AbsGetFileInfoMethodIDL.b.class, "<this>");     // Catch: AppletFileError -> L15
        AbsGetFileInfoMethodIDL.b r19 = (AbsGetFileInfoMethodIDL.b) c.a(AbsGetFileInfoMethodIDL.b.class);     // Catch: AppletFileError -> L15
        r19.setSize(r18.a);     // Catch: AppletFileError -> L15
        if (r11.getDigestAlgorithm() == null) goto L13;
        String r20 = r11.getDigestAlgorithm();     // Catch: AppletFileError -> L15
        Intrinsics.checkNotNull(r20);     // Catch: AppletFileError -> L15
        r19.setDigest(r15.f(r17, r20));     // Catch: AppletFileError -> L15
    L13:
        r1.i("AISDK_JSB_GetFileInfoMethod", "call success, size=" + r18.a);     // Catch: AppletFileError -> L15
        return new com.bytedance.ai.bridge.core.a.c(r19);
    L15:
        e = move-exception;
        return x3.a.a("AISDK_JSB_GetFileInfoMethod", e);
    L9:
        return x3.a.b("AISDK_JSB_GetFileInfoMethod");
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsGetFileInfoMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetFileInfoMethodIDL.a r13 = (AbsGetFileInfoMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
