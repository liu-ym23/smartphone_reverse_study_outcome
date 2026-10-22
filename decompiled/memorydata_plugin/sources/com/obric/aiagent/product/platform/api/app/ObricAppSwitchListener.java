package com.obric.aiagent.product.platform.api.app;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&R\u001b\u0010\u0004\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricAppSwitchListener;", "", "<init>", "()V", "assistantStub", "getAssistantStub", "()Ljava/lang/Object;", "assistantStub$delegate", "Lkotlin/Lazy;", "obricStub", "getObricStub", "obricStub$delegate", "onAppForeground", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "onAppBackground", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricAppSwitchListener {
    private final Lazy assistantStub$delegate;
    private final Lazy obricStub$delegate;

    public ObricAppSwitchListener() {
        this.assistantStub$delegate = LazyKt.lazy(new $$Lambda$ObricAppSwitchListener$uU0p9FfYv6wggwD2Bygr7yejxU(this));
        this.obricStub$delegate = LazyKt.lazy(new $$Lambda$ObricAppSwitchListener$V3Rm4N35zdpUDgPkTSdxnFvDhQ(this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricAppSwitchListener$assistantStub$2$1] */
    private static final ObricAppSwitchListener$assistantStub$2$1 assistantStub_delegate$lambda$0(final ObricAppSwitchListener r1) {
        return new ObricAppSwitchListener$assistantStub$2$1(r1);
    }

    /* JADX INFO: renamed from: lambda$-uU0p9FfYv6wggwD2Bygr7yejxU, reason: not valid java name */
    public static /* synthetic */ ObricAppSwitchListener$assistantStub$2$1 m153lambda$uU0p9FfYv6wggwD2Bygr7yejxU(ObricAppSwitchListener r0) {
        return assistantStub_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$V3Rm-4N35zdpUDgPkTSdxnFvDhQ, reason: not valid java name */
    public static /* synthetic */ ObricAppSwitchListener$obricStub$2$1 m154lambda$V3Rm4N35zdpUDgPkTSdxnFvDhQ(ObricAppSwitchListener r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricAppSwitchListener$obricStub$2$1] */
    private static final ObricAppSwitchListener$obricStub$2$1 obricStub_delegate$lambda$1(final ObricAppSwitchListener r1) {
        return new ObricAppSwitchListener$obricStub$2$1(r1);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.getValue();
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.getValue();
    }

    public abstract void onAppBackground(String r1);

    public abstract void onAppForeground(String r1);
}
