package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTask;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface m {
    void onFail();

    void onSuccess(Map<Long, ? extends Map<Long, AigcBackgroundImageGenerateTask>> r1);
}
