package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a<s> {
    public final /* synthetic */ PublicScreenCombinedTextViewHolder a;
    public final /* synthetic */ NoMoreSpaceTextView b;

    public k(PublicScreenCombinedTextViewHolder r1, NoMoreSpaceTextView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
    public final void a(s r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "rendResult");
        t.a r4 = t.a;
        NoMoreSpaceTextView r5 = this.b;
        CharSequence r6 = r3.a;
        if (r6 != null) goto L6;
        r6 = BuildConfig.FLAVOR;
    L6:
        t.b(r5, r6);
        PublicScreenCombinedTextViewHolder r7 = this.a;
        NoMoreSpaceTextView r8 = this.b;
        int r0 = PublicScreenCombinedTextViewHolder.l;
        r7.Z3(r8);
    }
}
