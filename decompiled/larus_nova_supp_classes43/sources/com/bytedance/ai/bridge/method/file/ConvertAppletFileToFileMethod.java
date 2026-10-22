package com.bytedance.ai.bridge.method.file;

import com.bytedance.ai.bridge.convertAppletFileToFile.AbsConvertAppletFileToFileMethodIDL;
import com.bytedance.ai.bridge.core.a;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/ConvertAppletFileToFileMethod;", "Lcom/bytedance/ai/bridge/convertAppletFileToFile/AbsConvertAppletFileToFileMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/convertAppletFileToFile/AbsConvertAppletFileToFileMethodIDL$ConvertAppletFileToFileResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/convertAppletFileToFile/AbsConvertAppletFileToFileMethodIDL$ConvertAppletFileToFileParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConvertAppletFileToFileMethod extends AbsConvertAppletFileToFileMethodIDL {
    public final boolean b;

    public ConvertAppletFileToFileMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static a b(d r10, AbsConvertAppletFileToFileMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        AppletFileManager r12 = x3.a.d(r10);
        if (r12 == null) goto L5;
        int r0 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L8
        String r13 = r12.n(com.bytedance.ai.file.a.C0040a.a(r11.getPath())).getAbsolutePath();     // Catch: AppletFileError -> L8
        Intrinsics.checkNotNullParameter(AbsConvertAppletFileToFileMethodIDL.b.class, "<this>");     // Catch: AppletFileError -> L8
        AbsConvertAppletFileToFileMethodIDL.b r14 = (AbsConvertAppletFileToFileMethodIDL.b) c.a(AbsConvertAppletFileToFileMethodIDL.b.class);     // Catch: AppletFileError -> L8
        Intrinsics.checkNotNull(r13);     // Catch: AppletFileError -> L8
        r14.setRealPath(r13);     // Catch: AppletFileError -> L8
        return new a.c(r14);
    L8:
        e = move-exception;
        StringBuilder r1 = new StringBuilder("getRealPath:fail ");
        String r15 = e.getMessage();
        if (r15 != null) goto L12;
        r15 = e.getCode();
    L12:
        r1.append(r15);
        return new a.b(0, r1.toString(), null, null, 29);
    L5:
        return new a.b(0, "getRealPath:fail file manager not available", null, null, 29);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsConvertAppletFileToFileMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsConvertAppletFileToFileMethodIDL.a r13 = (AbsConvertAppletFileToFileMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
