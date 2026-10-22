package com.ss.android.lark.core.spi;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/core/spi/SpiChangeListener;", BuildConfig.FLAVOR, "onSpiChanged", BuildConfig.FLAVOR, "newSpi", "Lcom/ss/android/lark/core/spi/ISpiApi;", "onSpiRemoved", "removedSpi", "core-component-api-internal_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SpiChangeListener {
    void onSpiChanged(ISpiApi r1);

    void onSpiRemoved(ISpiApi r1);
}
