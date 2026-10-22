package com.bytedance.android.annie.api.data.subscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b<T> extends BaseDataObsProvider<T> {
    public T b;

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final T g() {
        return this.b;
    }

    public b(T r1) {
        this.b = r1;
    }
}
