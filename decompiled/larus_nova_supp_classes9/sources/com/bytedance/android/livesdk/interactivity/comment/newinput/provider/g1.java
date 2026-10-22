package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g1 implements com.bytedance.android.livesdk.interactivity.api.expression.j {
    public final /* synthetic */ OGCFixedCommentSectionProvider.a a;

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void d(String r1, String r2) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final /* synthetic */ void e(com.bytedance.android.live.base.model.message.h r1, String r2) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final /* synthetic */ void f(com.bytedance.android.live.base.model.data.activityemoji.b r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final /* synthetic */ void h(com.bytedance.android.livesdk.interactivity.api.emoji.a r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final /* synthetic */ void i(String r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void dismissDialog() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.c.b;
        if (r0 == null) goto L6;
        r0.J();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final Object g() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.c.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.S();
    }

    public g1(OGCFixedCommentSectionProvider.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void c(BaseEmoji r3, String r4) {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.c.b;
        if (r0 == null) goto L6;
        r0.b(r3, r4, r0.a);
        return;
    }
}
