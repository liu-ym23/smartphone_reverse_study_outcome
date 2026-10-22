package com.bytedance.ai.bridge.method.file;

import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.filesystem.filemethods.AbsGetSavedFileListMethodIDL;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.c;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/file/GetSavedFileListMethod;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL$GetSavedFileListResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/filesystem/filemethods/AbsGetSavedFileListMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetSavedFileListMethod extends AbsGetSavedFileListMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetSavedFileListMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r11, AbsGetSavedFileListMethodIDL.a r12) {
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        g r13 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r11.getContainerContext();
        if (r1 == null) goto L5;
        String r10 = r1.getAppletId();
    L6:
        r0.append(r10);
        r13.i("AISDK_JSB_GetSavedFileListMethod", r0.toString());
        AppletFileManager r14 = x3.a.d(r11);
        if (r14 == null) goto L9;
        List<AppletFileManager.c> r15 = r14.g();     // Catch: AppletFileError -> L16
        Intrinsics.checkNotNullParameter(AbsGetSavedFileListMethodIDL.b.class, "<this>");     // Catch: AppletFileError -> L16
        AbsGetSavedFileListMethodIDL.b r16 = (AbsGetSavedFileListMethodIDL.b) c.a(AbsGetSavedFileListMethodIDL.b.class);     // Catch: AppletFileError -> L16
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));     // Catch: AppletFileError -> L16
        Iterator r18 = ((ArrayList) r15).iterator();     // Catch: AppletFileError -> L16
    L12:
        if (r18.hasNext() == false) goto L14;
        AppletFileManager.c r19 = (AppletFileManager.c) r18.next();     // Catch: AppletFileError -> L16
        r17.add(new AbsGetSavedFileListMethodIDL.FsSavedFileItem(r19.a, r19.b, r19.c));     // Catch: AppletFileError -> L16
        goto L12
    L14:
        r16.setFileList(r17);     // Catch: AppletFileError -> L16
        g.a.i("AISDK_JSB_GetSavedFileListMethod", "call success, count=" + ((ArrayList) r15).size());     // Catch: AppletFileError -> L16
        return new com.bytedance.ai.bridge.core.a.c(r16);
    L16:
        e = move-exception;
        return x3.a.a("AISDK_JSB_GetSavedFileListMethod", e);
    L9:
        return x3.a.b("AISDK_JSB_GetSavedFileListMethod");
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsGetSavedFileListMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetSavedFileListMethodIDL.a r13 = (AbsGetSavedFileListMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
