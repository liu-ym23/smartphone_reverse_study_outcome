package com.bytedance.ai.bridge.method.file;

import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.filesystem.filemethods.AbsReaddirMethodIDL;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import java.io.File;
import java.util.List;
import k3.c;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/ReaddirMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsReaddirMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsReaddirMethodIDL$ReaddirResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsReaddirMethodIDL$ReaddirParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReaddirMethod extends AbsReaddirMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public ReaddirMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsReaddirMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        g r1 = g.a;
        StringBuilder r12 = new StringBuilder("call start, appletId=");
        a0 r13 = r10.getContainerContext();
        List<String> r14 = null;
        if (r13 == null) goto L5;
        String r15 = r13.getAppletId();
    L6:
        r12.append(r15);
        r1.i("AISDK_JSB_ReaddirMethod", r12.toString());
        AppletFileManager r16 = x3.a.d(r10);
        if (r16 == null) goto L9;
        int r17 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L24
        com.bytedance.ai.file.a r18 = com.bytedance.ai.file.a.C0040a.a(r11.getDirPath());     // Catch: AppletFileError -> L24
        Intrinsics.checkNotNullParameter(r18, "file");     // Catch: AppletFileError -> L24
        File r19 = r16.g.a(r18);     // Catch: AppletFileError -> L24
        if (r19.exists() == false) goto L23;
        if (r19.isDirectory() == false) goto L21;
        String[] r20 = r19.list();     // Catch: AppletFileError -> L24
        if (r20 == null) goto L17;
        r14 = ArraysKt.toList(r20);     // Catch: AppletFileError -> L24
    L17:
        if (r14 != null) goto L19;
        r14 = CollectionsKt.emptyList();     // Catch: AppletFileError -> L24
    L19:
        Intrinsics.checkNotNullParameter(AbsReaddirMethodIDL.b.class, "<this>");     // Catch: AppletFileError -> L24
        AbsReaddirMethodIDL.b r21 = (AbsReaddirMethodIDL.b) c.a(AbsReaddirMethodIDL.b.class);     // Catch: AppletFileError -> L24
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.util.List<kotlin.String>");     // Catch: AppletFileError -> L24
        r21.setFiles(r14);     // Catch: AppletFileError -> L24
        r1.i("AISDK_JSB_ReaddirMethod", "call success, count=" + r14.size());     // Catch: AppletFileError -> L24
        return new com.bytedance.ai.bridge.core.a.c(r21);
    L21:
        throw AppletFileError.NotDir.INSTANCE;     // Catch: AppletFileError -> L24
    L23:
        throw AppletFileError.NotExist.INSTANCE;     // Catch: AppletFileError -> L24
    L24:
        e = move-exception;
        return x3.a.a("AISDK_JSB_ReaddirMethod", e);
    L9:
        return x3.a.b("AISDK_JSB_ReaddirMethod");
    L5:
        r15 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsReaddirMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsReaddirMethodIDL.a r13 = (AbsReaddirMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
