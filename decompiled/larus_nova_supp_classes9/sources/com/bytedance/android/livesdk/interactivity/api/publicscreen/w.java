package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.text.Spanned;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenAccessibilityUtil;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a<s> {
    public final /* synthetic */ PSTextMessageViewHolder a;

    public w(PSTextMessageViewHolder r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
    public final void a(s r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "rendResult");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t.a r6 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t.a;
        NoMoreSpaceTextView r7 = this.a.c;
        CharSequence r8 = r5.a;
        if (r8 != null) goto L6;
        r8 = BuildConfig.FLAVOR;
    L6:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t.b(r7, r8);
        NoMoreSpaceTextView r9 = this.a.c;
        PublicScreenAccessibilityUtil r10 = PublicScreenAccessibilityUtil.a;
        CharSequence r0 = r9.getText();
        if ((r0 instanceof Spanned) == true) goto L9;
        r0 = null;
    L9:
        r10.getClass();
        PublicScreenAccessibilityUtil.a((Spanned) r0, r9, null);
    }
}
