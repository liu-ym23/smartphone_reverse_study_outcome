package com.obric.aiagent.product.platform.api.view;

import android.os.RemoteException;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH&R\u001b\u0010\u0004\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/obric/aiagent/product/platform/api/view/ObricWindowGestureListener;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "()V", "assistantStub", "getAssistantStub", "()Ljava/lang/Object;", "assistantStub$delegate", "Lkotlin/Lazy;", "obricStub", "getObricStub", "obricStub$delegate", "onHomeSwipeUp", NameKeys.UnloadStrategy_No_Strategy, "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ObricWindowGestureListener {
    private final Lazy assistantStub$delegate;
    private final Lazy obricStub$delegate;

    public static /* synthetic */ ObricWindowGestureListener$obricStub$2$1 a(ObricWindowGestureListener r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    public static /* synthetic */ ObricWindowGestureListener$assistantStub$2$1 b(ObricWindowGestureListener r0) {
        return assistantStub_delegate$lambda$0(r0);
    }

    public abstract void onHomeSwipeUp() throws RemoteException;

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.getValue();
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.getValue();
    }

    public ObricWindowGestureListener() {
        this.assistantStub$delegate = LazyKt.lazy(new a(this));
        this.obricStub$delegate = LazyKt.lazy(new b(this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.view.ObricWindowGestureListener$assistantStub$2$1] */
    private static final ObricWindowGestureListener$assistantStub$2$1 assistantStub_delegate$lambda$0(final ObricWindowGestureListener r1) {
        return new ObricWindowGestureListener$assistantStub$2$1(r1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.view.ObricWindowGestureListener$obricStub$2$1] */
    private static final ObricWindowGestureListener$obricStub$2$1 obricStub_delegate$lambda$1(final ObricWindowGestureListener r1) {
        return new ObricWindowGestureListener$obricStub$2$1(r1);
    }
}
