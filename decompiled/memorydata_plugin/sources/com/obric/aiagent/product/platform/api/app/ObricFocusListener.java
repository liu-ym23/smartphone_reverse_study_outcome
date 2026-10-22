package com.obric.aiagent.product.platform.api.app;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&R\u001b\u0010\u0004\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricFocusListener;", "", "<init>", "()V", "obricStub", "getObricStub", "()Ljava/lang/Object;", "obricStub$delegate", "Lkotlin/Lazy;", "onFocusForeground", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "windowingMode", "", "onFreeformEntered", "onFreeformExited", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricFocusListener {
    private final Lazy obricStub$delegate;

    public ObricFocusListener() {
        this.obricStub$delegate = LazyKt.lazy(new $$Lambda$ObricFocusListener$s1WTKE6CeY8WmkoGG8J2I_Ge0Q(this));
    }

    /* JADX INFO: renamed from: lambda$s1WTKE6CeY8WmkoG-G8J2I_Ge0Q, reason: not valid java name */
    public static /* synthetic */ ObricFocusListener$obricStub$2$1 m157lambda$s1WTKE6CeY8WmkoGG8J2I_Ge0Q(ObricFocusListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricFocusListener$obricStub$2$1] */
    private static final ObricFocusListener$obricStub$2$1 obricStub_delegate$lambda$0(final ObricFocusListener r1) {
        return new ObricFocusListener$obricStub$2$1(r1);
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.getValue();
    }

    public abstract void onFocusForeground(String r1, int r2);

    public abstract void onFreeformEntered(String r1);

    public abstract void onFreeformExited(String r1);
}
