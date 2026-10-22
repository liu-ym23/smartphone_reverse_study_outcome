package com.ss.android.lark.keyboard.plugin.tool.photo;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface d {
    void onError(ErrorResult r1);

    void onFinish();

    void onSuccess(Map<String, FrameInfo> r1);
}
