package com.bytedance.android.livesdk.interactivity.roomintro.view;

import android.graphics.drawable.Drawable;
import android.text.Html;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Html.ImageGetter {
    public final /* synthetic */ RoomIntroDialog a;

    public c(RoomIntroDialog r1) {
        this.a = r1;
    }

    @Override // android.text.Html.ImageGetter
    public final Drawable getDrawable(String r4) {
        Drawable r5 = this.a.getResources().getDrawable(2131250132);
        r5.setBounds(0, 0, r5.getIntrinsicWidth(), r5.getIntrinsicHeight());
        return r5;
    }
}
