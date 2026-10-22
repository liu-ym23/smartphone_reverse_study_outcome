package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements ak6.e {
    public final /* synthetic */ PublicScreenCombinedTextViewHolder a;
    public final /* synthetic */ NoMoreSpaceTextView b;
    public final /* synthetic */ g52.e c;

    public final void a(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    public final void b(ak6.g r3) {
        Intrinsics.checkNotNullParameter(r3, "rendResult");
        t.a r0 = t.a;
        t.b(this.b, r3.a);
        PublicScreenCombinedTextViewHolder r4 = this.a;
        NoMoreSpaceTextView r1 = this.b;
        int r2 = PublicScreenCombinedTextViewHolder.l;
        r4.Z3(r1);
        PublicScreenCombinedTextViewHolder r5 = this.a;
        TextView r6 = this.b;
        g52.e r7 = this.c;
        r5.getClass();
        if (r7 == null) goto L6;
        int r8 = g52.e.j;
        r7.a(r6, true);
        return;
    }

    public l(PublicScreenCombinedTextViewHolder r1, NoMoreSpaceTextView r2, g52.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
