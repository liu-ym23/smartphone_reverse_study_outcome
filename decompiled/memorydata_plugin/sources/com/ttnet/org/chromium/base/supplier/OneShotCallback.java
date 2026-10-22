package com.ttnet.org.chromium.base.supplier;

import com.ttnet.org.chromium.base.Callback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public class OneShotCallback<E> {
    private final Callback<E> mCallback;
    private final Callback<E> mCallbackWrapper;
    private final WeakReference<ObservableSupplier<E>> mWeakSupplier;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.supplier.OneShotCallback$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class CallbackWrapper implements Callback<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ OneShotCallback this$0;

        static {
        }

        private CallbackWrapper(OneShotCallback r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CallbackWrapper(OneShotCallback r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.ttnet.org.chromium.base.Callback
        public void onResult(E r3) {
            OneShotCallback.access$100(this.this$0).onResult(r3);
            ((ObservableSupplier) ZeusTransformUtils.preCheckCast(OneShotCallback.access$200(this.this$0).get(), ObservableSupplier.class, "com.obric.memorydata.plugin")).removeObserver(OneShotCallback.access$300(this.this$0));
        }
    }

    public OneShotCallback(ObservableSupplier<E> r3, Callback<E> r4) {
        ObservableSupplier r5 = (ObservableSupplier) ZeusTransformUtils.wrapperContextForParams(r3, ObservableSupplier.class, "com.obric.memorydata.plugin");
        Callback<E> r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
        CallbackWrapper r0 = new CallbackWrapper(this, null);
        this.mCallbackWrapper = r0;
        this.mWeakSupplier = new WeakReference(r5);
        this.mCallback = r6;
        r5.addObserver(r0);
    }

    static /* synthetic */ Callback access$100(OneShotCallback r0) {
        return r0.mCallback;
    }

    static /* synthetic */ WeakReference access$200(OneShotCallback r0) {
        return r0.mWeakSupplier;
    }

    static /* synthetic */ Callback access$300(OneShotCallback r0) {
        return r0.mCallbackWrapper;
    }
}
