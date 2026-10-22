package com.bytedance.android.livesdk.interactivity.textmessage.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q extends com.bytedance.android.livesdk.interactivity.api.entity.f<w8> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        int r0 = MessageCommonColorUtil.a;
        MessageSceneType r1 = MessageSceneType.DEFAULT;
        return MessageCommonColorUtil.d();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int r() {
        int r0 = MessageCommonColorUtil.a;
        MessageSceneType r1 = MessageSceneType.DEFAULT;
        return MessageCommonColorUtil.d();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getFromUser();
    }

    public q(w8 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super((com.bytedance.android.live.base.model.message.t) r2, 0);
    }
}
