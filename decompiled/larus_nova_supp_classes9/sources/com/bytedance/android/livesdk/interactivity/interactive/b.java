package com.bytedance.android.livesdk.interactivity.interactive;

import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {
    String getTag();

    boolean isVisible();

    void ol();

    <T> AutoDisposeConverter<T> s7();

    LifecycleRegistry u9();
}
