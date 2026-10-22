package com.bytedance.ai.bridge.method.file;

import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.filesystem.filemethods.AbsAccessMethodIDL;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/AccessMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsAccessMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsAccessMethodIDL$EmptyMessageModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsAccessMethodIDL$AccessParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccessMethod extends AbsAccessMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public AccessMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsAccessMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        g r1 = g.a;
        StringBuilder r12 = new StringBuilder("call start, appletId=");
        a0 r13 = r10.getContainerContext();
        if (r13 == null) goto L5;
        String r14 = r13.getAppletId();
    L6:
        r12.append(r14);
        r1.i("AISDK_JSB_AccessMethod", r12.toString());
        AppletFileManager r15 = x3.a.d(r10);
        if (r15 == null) goto L9;
        int r16 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L23
        com.bytedance.ai.file.a r17 = com.bytedance.ai.file.a.C0040a.a(r11.getPath());     // Catch: AppletFileError -> L23
        Intrinsics.checkNotNullParameter(r17, "file");     // Catch: AppletFileError -> L23
        if (r15.g.a(r17).exists() == true) goto L15;
        StringBuilder r18 = new StringBuilder("call failed, errNo=");     // Catch: AppletFileError -> L23
        f3.a r19 = f3.a.t;     // Catch: AppletFileError -> L23
        r18.append(r19.a);     // Catch: AppletFileError -> L23
        r18.append(", msg=no such file or directory");     // Catch: AppletFileError -> L23
        r1.e("AISDK_JSB_AccessMethod", r18.toString());     // Catch: AppletFileError -> L23
        return new com.bytedance.ai.bridge.core.a.b(0, "no such file or directory", null, r19, 21);
    L15:
        r1.i("AISDK_JSB_AccessMethod", "call success");     // Catch: AppletFileError -> L23
        Intrinsics.checkNotNullParameter(AbsAccessMethodIDL.b.class, "<this>");     // Catch: AppletFileError -> L23
        return new com.bytedance.ai.bridge.core.a.c(c.a(AbsAccessMethodIDL.b.class));
    L21:
        e = move-exception;
        throw e;     // Catch: AppletFileError -> L23
    L19:
        e = move-exception;
        throw e;     // Catch: AppletFileError -> L23
    L16:
        th = move-exception;
        throw new AppletFileError.IoError(th);     // Catch: AppletFileError -> L23
    L23:
        e = move-exception;
        return x3.a.a("AISDK_JSB_AccessMethod", e);
    L9:
        return x3.a.b("AISDK_JSB_AccessMethod");
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsAccessMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsAccessMethodIDL.a r13 = (AbsAccessMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
