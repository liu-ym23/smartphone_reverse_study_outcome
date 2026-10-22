package com.ttnet.org.chromium.base.supplier;

import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.Callback;

/* JADX INFO: loaded from: classes2.dex */
public interface OneshotSupplier<T> extends Supplier<T> {
    @Nullable
    T onAvailable(Callback<T> r10);
}
