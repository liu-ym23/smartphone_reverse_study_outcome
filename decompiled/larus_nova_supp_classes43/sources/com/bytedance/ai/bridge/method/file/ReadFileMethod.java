package com.bytedance.ai.bridge.method.file;

import android.util.Base64;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.filesystem.filemethods.AbsReadFileMethodIDL;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/ReadFileMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsReadFileMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsReadFileMethodIDL$ReadFileResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsReadFileMethodIDL$ReadFileParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadFileMethod extends AbsReadFileMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public ReadFileMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsReadFileMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        g r1 = g.a;
        StringBuilder r12 = new StringBuilder("call start, encoding=");
        r12.append(r11.getEncoding());
        r12.append(", appletId=");
        a0 r13 = r10.getContainerContext();
        if (r13 == null) goto L5;
        String r14 = r13.getAppletId();
    L6:
        r12.append(r14);
        r1.i("AISDK_JSB_ReadFileMethod", r12.toString());
        AppletFileManager r15 = x3.a.d(r10);
        if (r15 == null) goto L9;
        int r16 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L19
        byte[] r17 = r15.i(com.bytedance.ai.file.a.C0040a.a(r11.getFilePath()));     // Catch: AppletFileError -> L19
        String r18 = r11.getEncoding();     // Catch: AppletFileError -> L19
        if (Intrinsics.areEqual(r18, "utf-8") == false) goto L13;
    L16:
        String r19 = new String(r17, Charsets.UTF_8);     // Catch: AppletFileError -> L19
    L17:
        Intrinsics.checkNotNullParameter(AbsReadFileMethodIDL.b.class, "<this>");     // Catch: AppletFileError -> L19
        AbsReadFileMethodIDL.b r20 = (AbsReadFileMethodIDL.b) c.a(AbsReadFileMethodIDL.b.class);     // Catch: AppletFileError -> L19
        Intrinsics.checkNotNull(r19);     // Catch: AppletFileError -> L19
        r20.setData(r19);     // Catch: AppletFileError -> L19
        r1.i("AISDK_JSB_ReadFileMethod", "call success, size=" + r17.length);     // Catch: AppletFileError -> L19
        return new com.bytedance.ai.bridge.core.a.c(r20);
    L13:
        if (Intrinsics.areEqual(r18, "utf8") == true) goto L16;
        r19 = Base64.encodeToString(r17, 2);     // Catch: AppletFileError -> L19
    L19:
        e = move-exception;
        return x3.a.a("AISDK_JSB_ReadFileMethod", e);
    L9:
        return x3.a.b("AISDK_JSB_ReadFileMethod");
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsReadFileMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsReadFileMethodIDL.a r13 = (AbsReadFileMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
