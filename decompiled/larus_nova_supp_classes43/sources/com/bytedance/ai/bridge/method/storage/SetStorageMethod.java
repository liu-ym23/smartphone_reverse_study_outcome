package com.bytedance.ai.bridge.method.storage;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationStorage;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.storage.AbsSetStorageMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/storage/SetStorageMethod;", "Lcom/bytedance/ai/bridge/storage/AbsSetStorageMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/storage/AbsSetStorageMethodIDL$EmptyMessageModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/storage/AbsSetStorageMethodIDL$SetStorageParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetStorageMethod extends AbsSetStorageMethodIDL {
    public final boolean b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ApplicationStorage.StorageError.values().length];
            r0[ApplicationStorage.StorageError.EXCEED_ITEM_MAX_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ApplicationStorage.StorageError.EXCEED_TOTAL_MAX_SIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public SetStorageMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r12, AbsSetStorageMethodIDL.b r13) {
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, key=");
        r1.append(r13.getKey());
        r1.append(", hasData=");
        boolean r10 = false;
        if (r13.getData() == null) goto L5;
        boolean r11 = true;
    L6:
        r1.append(r11);
        r0.i("AISDK_JSB_SetStorageMethod", r1.toString());
        if (r13.getKey().length() != 0) goto L10;
        r10 = true;
    L10:
        if (r10 == false) goto L14;
        StringBuilder r14 = new StringBuilder("call failed, errNo=");
        f3.a.C0156a r15 = f3.a.c;
        f3.a r16 = f3.b.a;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        f3.a r17 = f3.b.c;
        r14.append(r17.a);
        r14.append(", msg=key is empty");
        r0.e("AISDK_JSB_SetStorageMethod", r14.toString());
        Intrinsics.checkNotNullParameter(r15, "<this>");
        return new com.bytedance.ai.bridge.core.a.b(0, "key is empty", null, r17, 21);
    L14:
        if (r13.getKey().length() <= 1024) goto L17;
        StringBuilder r18 = new StringBuilder("call failed, errNo=");
        f3.a.C0156a r19 = f3.a.c;
        f3.a r20 = f3.b.a;
        Intrinsics.checkNotNullParameter(r19, "<this>");
        f3.a r21 = f3.b.d;
        r18.append(r21.a);
        r18.append(", msg=key exceeds max length");
        r0.e("AISDK_JSB_SetStorageMethod", r18.toString());
        Intrinsics.checkNotNullParameter(r19, "<this>");
        return new com.bytedance.ai.bridge.core.a.b(0, "key exceeds max length", null, r21, 21);
    L17:
        a0 r110 = r12.getContainerContext();
        if (r110 == null) goto L40;
        String r111 = r110.getAppletId();
        if (r111 == null) goto L40;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r22 = AppletAppManagerService.b(r111);
        if (r22 != null) goto L26;
        StringBuilder r112 = new StringBuilder("call failed, errNo=");
        f3.a r113 = f3.a.f;
        r112.append(r113.a);
        r112.append(", msg=app ");
        r112.append(r111);
        r112.append(" not found");
        r0.e("AISDK_JSB_SetStorageMethod", r112.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "app " + r111 + " not found", null, r113, 21);
    L26:
        ApplicationStorage.a r114 = ((ApplicationStorage) r22.h().d.getValue()).b(r13.getKey(), r13.getData());
        if ((r114 instanceof ApplicationStorage.a.C0015a) == false) goto L38;
        ApplicationStorage.a.C0015a r115 = (ApplicationStorage.a.C0015a) r114;
        int r116 = b.a[r115.a.ordinal()];
        if (r116 != 1) goto L31;
        f3.a.C0156a r117 = f3.a.c;
        f3.a r23 = f3.b.a;
        Intrinsics.checkNotNullParameter(r117, "<this>");
        f3.a r118 = f3.b.a;
    L36:
        f3.a r119 = r118;
        r0.e("AISDK_JSB_SetStorageMethod", "call failed, errNo=" + r119.a + ", msg=" + r115.a.getMsg());
        return new com.bytedance.ai.bridge.core.a.b(0, r115.a.getMsg(), null, r119, 21);
    L31:
        if (r116 != 2) goto L34;
        f3.a.C0156a r120 = f3.a.c;
        f3.a r24 = f3.b.a;
        Intrinsics.checkNotNullParameter(r120, "<this>");
        r118 = f3.b.b;
        goto L36
    L34:
        throw new NoWhenBranchMatchedException();
    L38:
        r0.i("AISDK_JSB_SetStorageMethod", "call success, key=" + r13.getKey());
        Intrinsics.checkNotNullParameter(AbsSetStorageMethodIDL.a.class, "<this>");
        return new com.bytedance.ai.bridge.core.a.c(c.a(AbsSetStorageMethodIDL.a.class));
    L40:
        StringBuilder r121 = new StringBuilder("call failed, errNo=");
        f3.a r122 = f3.a.f;
        r121.append(r122.a);
        r121.append(", msg=appId is null");
        r0.e("AISDK_JSB_SetStorageMethod", r121.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "appId is null", null, r122, 21);
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsSetStorageMethodIDL.b) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSetStorageMethodIDL.b r13 = (AbsSetStorageMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r10, r13), r12);
    }
}
