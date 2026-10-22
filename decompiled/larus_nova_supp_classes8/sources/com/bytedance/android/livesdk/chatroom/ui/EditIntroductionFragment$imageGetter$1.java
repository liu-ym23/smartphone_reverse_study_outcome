package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.drawable.Drawable;
import android.text.Html;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class EditIntroductionFragment$imageGetter$1 implements Html.ImageGetter {
    public final /* synthetic */ EditIntroductionFragment a;

    public EditIntroductionFragment$imageGetter$1(EditIntroductionFragment r1) {
        this.a = r1;
    }

    @Override // android.text.Html.ImageGetter
    public final Drawable getDrawable(String r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        EditIntroductionFragment r1 = this.a;
        Function2<String, Drawable, Unit> r2 = new EditIntroductionFragment$imageGetter$1$getDrawable$1(this);
        Function1<String, Unit> r3 = new EditIntroductionFragment$imageGetter$1$getDrawable$2(this);
        int r4 = EditIntroductionFragment.p;
        r1.U90(r6, r2, r3);
        return null;
    }
}
