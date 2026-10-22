package com.obric.aiagent.product.platform.api.app;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u001b\u0010\u0004\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "", "<init>", "()V", "assistantStub", "getAssistantStub", "()Ljava/lang/Object;", "assistantStub$delegate", "Lkotlin/Lazy;", "obricStub", "getObricStub", "obricStub$delegate", "onDisplaySecureChanged", "", "displayId", "", "secure", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricDisplayInfoCallback {
    private final Lazy assistantStub$delegate;
    private final Lazy obricStub$delegate;

    public ObricDisplayInfoCallback() {
        this.assistantStub$delegate = LazyKt.lazy(new $$Lambda$ObricDisplayInfoCallback$YWzrVSfZn4cVCmEFYPQh4XWrg(this));
        this.obricStub$delegate = LazyKt.lazy(new $$Lambda$ObricDisplayInfoCallback$5tRg7BFvkcSdDs7cqgg4RpbBANM(this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricDisplayInfoCallback$assistantStub$2$1] */
    private static final ObricDisplayInfoCallback$assistantStub$2$1 assistantStub_delegate$lambda$0(final ObricDisplayInfoCallback r1) {
        return new ObricDisplayInfoCallback$assistantStub$2$1(r1);
    }

    public static /* synthetic */ ObricDisplayInfoCallback$obricStub$2$1 lambda$5tRg7BFvkcSdDs7cqgg4RpbBANM(ObricDisplayInfoCallback r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$YWz-r-VSfZn4cVCmEFYPQh4XWrg, reason: not valid java name */
    public static /* synthetic */ ObricDisplayInfoCallback$assistantStub$2$1 m156lambda$YWzrVSfZn4cVCmEFYPQh4XWrg(ObricDisplayInfoCallback r0) {
        return assistantStub_delegate$lambda$0(r0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricDisplayInfoCallback$obricStub$2$1] */
    private static final ObricDisplayInfoCallback$obricStub$2$1 obricStub_delegate$lambda$1(final ObricDisplayInfoCallback r1) {
        return new ObricDisplayInfoCallback$obricStub$2$1(r1);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.getValue();
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.getValue();
    }

    public abstract void onDisplaySecureChanged(int r1, boolean r2);
}
