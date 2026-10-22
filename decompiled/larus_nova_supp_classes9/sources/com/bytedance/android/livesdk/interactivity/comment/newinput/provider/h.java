package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.livesdk.widget.EmojiEditView;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements z62.i {
    public final /* synthetic */ e.c a;

    @Override // z62.i
    public final void onUpdate() {
        e.c r0 = this.a;
        EmojiEditView r1 = r0.f;
        if (r1 == null) goto L6;
        TokenCert r2 = b72.a.a;
        r0.m = b72.a.c(r1, r0.b.m0());
        return;
    }

    public h(e.c r1) {
        this.a = r1;
    }
}
