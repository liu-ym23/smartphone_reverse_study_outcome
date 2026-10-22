package com.bytedance.ai.bridge.method.file;

import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.filesystem.filemethods.AbsTruncateMethodIDL;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/TruncateMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsTruncateMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsTruncateMethodIDL$EmptyMessageModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsTruncateMethodIDL$TruncateParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TruncateMethod extends AbsTruncateMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public TruncateMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsTruncateMethodIDL.b r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, length=");
        Long r12 = r11.getLength();
        long r13 = 0;
        if (r12 == null) goto L5;
        long r14 = r12.longValue();
    L6:
        r1.append(r14);
        r1.append(", appletId=");
        a0 r15 = r10.getContainerContext();
        if (r15 == null) goto L9;
        String r16 = r15.getAppletId();
    L10:
        r1.append(r16);
        r0.i("AISDK_JSB_TruncateMethod", r1.toString());
        AppletFileManager r17 = x3.a.d(r10);
        if (r17 == null) goto L13;
        int r18 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L19
        com.bytedance.ai.file.a r19 = com.bytedance.ai.file.a.C0040a.a(r11.getFilePath());     // Catch: AppletFileError -> L19
        Long r20 = r11.getLength();     // Catch: AppletFileError -> L19
        if (r20 == null) goto L17;
        r13 = r20.longValue();     // Catch: AppletFileError -> L19
    L17:
        r17.o(r19, r13);     // Catch: AppletFileError -> L19
        r0.i("AISDK_JSB_TruncateMethod", "call success");     // Catch: AppletFileError -> L19
        Intrinsics.checkNotNullParameter(AbsTruncateMethodIDL.a.class, "<this>");     // Catch: AppletFileError -> L19
        return new com.bytedance.ai.bridge.core.a.c(c.a(AbsTruncateMethodIDL.a.class));
    L19:
        e = move-exception;
        return x3.a.a("AISDK_JSB_TruncateMethod", e);
    L13:
        return x3.a.b("AISDK_JSB_TruncateMethod");
    L9:
        r16 = null;
        goto L10
    L5:
        r14 = 0;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsTruncateMethodIDL.b) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsTruncateMethodIDL.b r13 = (AbsTruncateMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
