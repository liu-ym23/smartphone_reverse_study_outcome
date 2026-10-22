package com.ss.android.lark.lynxkit.bridge;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeRuntimeProtocol;", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderConfigurator;", "factory", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;", "<init>", "(Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;)V", "configure", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderHandle;", "context", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolBuilderContext;", "attach", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolHandle;", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolContext;", "RuntimeBuilderHandle", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxBridgeRuntimeProtocol implements ILarkLynxBridgeProtocol, ILarkLynxBridgeProtocolBuilderConfigurator {
    private final ILarkLynxBridgeRuntimeFactory factory;

    public static final class a implements ILarkLynxBridgeProtocolBuilderHandle {
        public final ILarkLynxBridgeRuntime a;

        @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolBuilderHandle
        public final void dispose() {
            this.a.dispose();
        }

        public a(ILarkLynxBridgeRuntime r2) {
            Intrinsics.checkNotNullParameter(r2, "runtime");
            this.a = r2;
        }
    }

    public LarkLynxBridgeRuntimeProtocol(ILarkLynxBridgeRuntimeFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        this.factory = r2;
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocol
    public ILarkLynxBridgeProtocolHandle attach(LarkLynxBridgeProtocolContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ILarkLynxBridgeProtocolBuilderHandle r0 = r3.getBuilderHandle();
        if ((r0 instanceof a) == false) goto L5;
        a r1 = (a) r0;
    L6:
        if (r1 == null) goto L10;
        r1.a.attach(r3);
        return r1.a;
    L10:
        throw new IllegalStateException("bridge runtime builder handle missing");
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolBuilderConfigurator
    public ILarkLynxBridgeProtocolBuilderHandle configure(LarkLynxBridgeProtocolBuilderContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ILarkLynxBridgeRuntime r0 = this.factory.create(r2);
        r0.configure(r2);     // Catch: Throwable -> L6
        return new a(r0);
    L6:
        th = move-exception;
        r0.dispose();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L11
    }
}
