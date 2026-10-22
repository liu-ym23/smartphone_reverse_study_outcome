package com.obric.aiagent.product.platform.api.app;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001b\u0010\u0004\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricBackNavigationListener;", "", "<init>", "()V", "assistantStub", "getAssistantStub", "()Ljava/lang/Object;", "assistantStub$delegate", "Lkotlin/Lazy;", "obricStub", "getObricStub", "obricStub$delegate", "onBackNavigationStarted", "", "onBackNavigationDone", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricBackNavigationListener {
    private final Lazy assistantStub$delegate;
    private final Lazy obricStub$delegate;

    public ObricBackNavigationListener() {
        this.assistantStub$delegate = LazyKt.lazy(new $$Lambda$ObricBackNavigationListener$0Ll9OEQdoGvLPnUCOrmvaUfqJjg(this));
        this.obricStub$delegate = LazyKt.lazy(new $$Lambda$ObricBackNavigationListener$iwbdXMehYoylzsIuB5HAIm_iQ(this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener$assistantStub$2$1] */
    private static final ObricBackNavigationListener$assistantStub$2$1 assistantStub_delegate$lambda$0(final ObricBackNavigationListener r1) {
        return new ObricBackNavigationListener$assistantStub$2$1(r1);
    }

    public static /* synthetic */ ObricBackNavigationListener$assistantStub$2$1 lambda$0Ll9OEQdoGvLPnUCOrmvaUfqJjg(ObricBackNavigationListener r0) {
        return assistantStub_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$iwbdXMehYoylzsI-uB5HAIm-_iQ, reason: not valid java name */
    public static /* synthetic */ ObricBackNavigationListener$obricStub$2$1 m155lambda$iwbdXMehYoylzsIuB5HAIm_iQ(ObricBackNavigationListener r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener$obricStub$2$1] */
    private static final ObricBackNavigationListener$obricStub$2$1 obricStub_delegate$lambda$1(final ObricBackNavigationListener r1) {
        return new ObricBackNavigationListener$obricStub$2$1(r1);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.getValue();
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.getValue();
    }

    public void onBackNavigationDone() {
    }

    public void onBackNavigationStarted() {
    }
}
