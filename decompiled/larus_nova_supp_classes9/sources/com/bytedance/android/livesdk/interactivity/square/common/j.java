package com.bytedance.android.livesdk.interactivity.square.common;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class j extends i52.a {
    public j(MessageModelType r2, MessageBinderType r3, MessagePluginType r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "modelType");
        Intrinsics.checkNotNullParameter(r3, "binderType");
        Intrinsics.checkNotNullParameter(r4, "pluginType");
        super(r2, r3, r4, r5);
    }
}
