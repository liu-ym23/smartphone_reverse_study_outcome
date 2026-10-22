package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.text.TextUtils;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m1 implements z62.i {
    public final /* synthetic */ o1.a a;

    @Override // z62.i
    public final void onUpdate() {
        o1.a r0 = this.a;
        BaseCommentGiftGuideView r1 = r0.e.c;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r0.b.m0() == true) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r2 = this.a.b.V();
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r3 = r2.g;
        if (r3 == null) goto L13;
        boolean r4 = true;
        if ((!TextUtils.isEmpty(r3.f)) == true) goto L13;
    L14:
        r1.setGuideEnable(r4);
        return;
    L13:
        r4 = false;
        goto L14
    }

    public m1(o1.a r1) {
        this.a = r1;
    }
}
