package com.bytedance.ai.bridge.method.file;

import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.filesystem.filemethods.AbsStatMethodIDL;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/StatMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsStatMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsStatMethodIDL$StatResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsStatMethodIDL$StatParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StatMethod extends AbsStatMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public StatMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsStatMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        g r1 = g.a;
        StringBuilder r12 = new StringBuilder("call start, appletId=");
        a0 r13 = r10.getContainerContext();
        if (r13 == null) goto L5;
        String r14 = r13.getAppletId();
    L6:
        r12.append(r14);
        r1.i("AISDK_JSB_StatMethod", r12.toString());
        AppletFileManager r15 = x3.a.d(r10);
        if (r15 == null) goto L9;
        int r16 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L12
        AppletFileManager.b r17 = r15.m(com.bytedance.ai.file.a.C0040a.a(r11.getPath()));     // Catch: AppletFileError -> L12
        Intrinsics.checkNotNullParameter(AbsStatMethodIDL.b.class, "<this>");     // Catch: AppletFileError -> L12
        AbsStatMethodIDL.b r18 = (AbsStatMethodIDL.b) c.a(AbsStatMethodIDL.b.class);     // Catch: AppletFileError -> L12
        r18.setSize(r17.a);     // Catch: AppletFileError -> L12
        r18.setLastModifiedTime(r17.b);     // Catch: AppletFileError -> L12
        r18.setDirectory(r17.c);     // Catch: AppletFileError -> L12
        r1.i("AISDK_JSB_StatMethod", "call success, size=" + r17.a + ", isDir=" + r17.c);     // Catch: AppletFileError -> L12
        return new com.bytedance.ai.bridge.core.a.c(r18);
    L12:
        e = move-exception;
        return x3.a.a("AISDK_JSB_StatMethod", e);
    L9:
        return x3.a.b("AISDK_JSB_StatMethod");
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsStatMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsStatMethodIDL.a r13 = (AbsStatMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
