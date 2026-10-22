package com.bytedance.android.live.browser.jsbridge.state;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class c<T> extends BaseObservableState<T> {
    public T e;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        return this.e;
    }

    public c(T r2) {
        super(false);
        this.e = r2;
    }
}
