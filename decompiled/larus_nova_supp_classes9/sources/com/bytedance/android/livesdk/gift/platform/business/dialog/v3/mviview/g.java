package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.graphics.drawable.NinePatchDrawable;
import android.text.Spannable;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements a3.b {
    public final /* synthetic */ GiftMVIDetailView a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Spannable c;

    public final void onFail() {
        GiftMVIDetailView.v(this.a, this.c);
    }

    public final void a(NinePatchDrawable r3) {
        Intrinsics.checkNotNullParameter(r3, "ninePatchDrawable");
        this.a.w(this.b, this.c);
    }

    public g(GiftMVIDetailView r1, View r2, Spannable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
