package com.bytedance.ai.bridge.method.file;

import android.util.Base64;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.filesystem.filemethods.AbsAppendFileMethodIDL;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/AppendFileMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsAppendFileMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsAppendFileMethodIDL$EmptyMessageModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsAppendFileMethodIDL$AppendFileParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppendFileMethod extends AbsAppendFileMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public AppendFileMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsAppendFileMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        AppletFileManager r0 = x3.a.d(r10);
        if (r0 == null) goto L5;
        String r12 = r11.getEncoding();
        String r13 = r11.getData();
        Intrinsics.checkNotNullParameter(r13, "data");
        String r14 = null;
        if (Intrinsics.areEqual(r12, "base64") == true) goto L25;
        byte[] r15 = r13.getBytes(Charsets.UTF_8);
    L13:
        if (r15 == null) goto L15;
        g r16 = g.a;
        StringBuilder r17 = new StringBuilder("call start, encoding=");
        r17.append(r11.getEncoding());
        r17.append(", size=");
        r17.append(r15.length);
        r17.append(", appletId=");
        a0 r18 = r10.getContainerContext();
        if (r18 == null) goto L19;
        r14 = r18.getAppletId();
    L19:
        r17.append(r14);
        r16.i("AISDK_JSB_AppendFileMethod", r17.toString());
        int r19 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L22
        r0.a(com.bytedance.ai.file.a.C0040a.a(r11.getFilePath()), r15);     // Catch: AppletFileError -> L22
        r16.i("AISDK_JSB_AppendFileMethod", "call success");     // Catch: AppletFileError -> L22
        Intrinsics.checkNotNullParameter(AbsAppendFileMethodIDL.b.class, "<this>");     // Catch: AppletFileError -> L22
        return new com.bytedance.ai.bridge.core.a.c(c.a(AbsAppendFileMethodIDL.b.class));
    L22:
        e = move-exception;
        return x3.a.a("AISDK_JSB_AppendFileMethod", e);
    L15:
        return x3.a.c("AISDK_JSB_AppendFileMethod");
    L25:
        r15 = Base64.decode(r13, 2);     // Catch: IllegalArgumentException -> L11
    L11:
        r15 = null;
        goto L13
    L5:
        return x3.a.b("AISDK_JSB_AppendFileMethod");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsAppendFileMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsAppendFileMethodIDL.a r13 = (AbsAppendFileMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
