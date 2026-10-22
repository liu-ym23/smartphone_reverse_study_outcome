package com.bytedance.android.live.core.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private final CompositeDisposable compositeDisposable;
    private boolean isAttached;

    public abstract void bind(T r1, int r2);

    public boolean fullSpan() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T getData(Object r1) {
        return r1;
    }

    public void onViewAttachedToWindow() {
        this.isAttached = true;
    }

    public void onViewDetachedFromWindow() {
        this.isAttached = false;
    }

    public void unbind() {
        this.compositeDisposable.clear();
    }

    public boolean isAttached() {
        return this.isAttached;
    }

    public BaseViewHolder(View r1) {
        super(r1);
        this.isAttached = false;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void register(Disposable r2) {
        this.compositeDisposable.add(r2);
    }
}
