package com.bytedance.ai.bridge.method.file;

import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.filesystem.filemethods.AbsSaveFileMethodIDL;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/SaveFileMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsSaveFileMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsSaveFileMethodIDL$SaveFileResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsSaveFileMethodIDL$SaveFileParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveFileMethod extends AbsSaveFileMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public SaveFileMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsSaveFileMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        g r1 = g.a;
        StringBuilder r12 = new StringBuilder("call start, hasFilePath=");
        if (r11.getFilePath() == null) goto L5;
        boolean r13 = true;
    L6:
        r12.append(r13);
        r12.append(", appletId=");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L9;
        String r15 = r14.getAppletId();
    L10:
        r12.append(r15);
        r1.i("AISDK_JSB_SaveFileMethod", r12.toString());
        AppletFileManager r16 = x3.a.d(r10);
        if (r16 == null) goto L13;
        int r17 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L19
        com.bytedance.ai.file.a r18 = com.bytedance.ai.file.a.C0040a.a(r11.getTempFilePath());     // Catch: AppletFileError -> L19
        String r19 = r11.getFilePath();     // Catch: AppletFileError -> L19
        if (r19 != null) goto L17;
        r19 = "appletfile://user/" + System.currentTimeMillis() + '_' + StringsKt.substringAfterLast$default(r11.getTempFilePath(), '/', null, 2, null);     // Catch: AppletFileError -> L19
    L17:
        r16.c(r18, com.bytedance.ai.file.a.C0040a.a(r19));     // Catch: AppletFileError -> L19
        r16.j(r18, false);     // Catch: AppletFileError -> L19
        Intrinsics.checkNotNullParameter(AbsSaveFileMethodIDL.b.class, "<this>");     // Catch: AppletFileError -> L19
        AbsSaveFileMethodIDL.b r20 = (AbsSaveFileMethodIDL.b) c.a(AbsSaveFileMethodIDL.b.class);     // Catch: AppletFileError -> L19
        r20.setSavedFilePath(r19);     // Catch: AppletFileError -> L19
        r1.i("AISDK_JSB_SaveFileMethod", "call success");     // Catch: AppletFileError -> L19
        return new com.bytedance.ai.bridge.core.a.c(r20);
    L19:
        e = move-exception;
        return x3.a.a("AISDK_JSB_SaveFileMethod", e);
    L13:
        return x3.a.b("AISDK_JSB_SaveFileMethod");
    L9:
        r15 = null;
        goto L10
    L5:
        r13 = false;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsSaveFileMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSaveFileMethodIDL.a r13 = (AbsSaveFileMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
