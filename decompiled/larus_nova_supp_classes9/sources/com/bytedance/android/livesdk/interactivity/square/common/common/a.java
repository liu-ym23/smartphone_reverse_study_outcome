package com.bytedance.android.livesdk.interactivity.square.common.common;

import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.bdlocation.BuildConfig;
import g52.e;
import h52.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements k.a<c> {
    public final /* synthetic */ CommonSquarePublicScreenViewHolder a;
    public final /* synthetic */ c b;
    public final /* synthetic */ NoMoreSpaceTextView c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
    public final void a(c r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "rendResult");
        if (Intrinsics.areEqual(this.c.getTag(2131389797), this.b) == false) goto L9;
        t.a r4 = t.a;
        NoMoreSpaceTextView r5 = this.c;
        CharSequence r6 = r3.a;
        if (r6 != null) goto L8;
        r6 = BuildConfig.FLAVOR;
    L8:
        t.b(r5, r6);
    L9:
        e r7 = this.a.e.e.getTextConfig();
        if (r7 == null) goto L13;
        r7.c(this.c);
        return;
    }

    public a(CommonSquarePublicScreenViewHolder r1, c r2, NoMoreSpaceTextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
