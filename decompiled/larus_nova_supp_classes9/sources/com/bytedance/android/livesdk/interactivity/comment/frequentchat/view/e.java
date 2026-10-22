package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.comment.newinput.LivePortraitInputDialogV3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements com.bytedance.android.livesdk.interactivity.api.expression.j {
    public final /* synthetic */ FrequentChatSecondaryFragment a;

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void d(String r1, String r2) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void dismissDialog() {
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
    public final void a() {
        GradientEditText r0 = this.a.e;
        if (r0 == null) goto L7;
        r0.dispatchKeyEvent(new KeyEvent(0, 67));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final Object g() {
        return this.a.y.S();
    }

    public e(FrequentChatSecondaryFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void c(BaseEmoji r5, String r6) {
        FrequentChatSecondaryFragment r7 = this.a;
        GradientEditText r0 = r7.e;
        if (r0 == null) goto L16;
        if (r5 == null) goto L17;
        int r8 = r7.t + 1;
        Integer r2 = b72.a.f;
        if (r8 <= r2.intValue()) goto L11;
        f2.c(s1.C(2131917443, new Object[]{r2}), 0);
        return;
    L11:
        if (TextUtils.isEmpty(r5.getDescription()) == true) goto L18;
        int r9 = r0.getSelectionStart();
        Editable r1 = r0.getText();
        String r10 = r5.getDescription();
        int r3 = LivePortraitInputDialogV3.L;
        r1.insert(r9, ab2.a.f(r10, LivePortraitInputDialogV3.a.a()));
        return;
    L18:
        return;
    L17:
        return;
    }
}
