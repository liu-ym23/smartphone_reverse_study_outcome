package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.platform.depend.user.IHostUserActiveChangeCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements IHostUserActiveChangeCallback {
    public final /* synthetic */ MentionAvatarViewHolder a;

    public a(MentionAvatarViewHolder r1) {
        this.a = r1;
    }

    public final void onActiveChanged(boolean r3) {
        MentionAvatarViewHolder r0 = this.a;
        r0.g = r3;
        if (r3 == false) goto L5;
        r0.a.setCircleRadius(UtilityKotlinExtentionsKt.h(12));
        return;
    L5:
        l r4 = r0.e;
        if (r4 != null) goto L8;
    L9:
        r0.a.setCircleRadius(0.0f);
        return;
    L8:
        if (r4.b != true) goto L9;
    }
}
