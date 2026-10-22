package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.TextAnswerSingleActionButton;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutTextMessageActionButtonBinding implements ViewBinding {
    public final View a;
    public final SimpleDraweeView b;
    public final LottieAdapterView c;
    public final AppCompatTextView d;
    public final LinearLayout e;
    public final SimpleDraweeView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutTextMessageActionButtonBinding(TextAnswerSingleActionButton r1, SimpleDraweeView r2, LottieAdapterView r3, AppCompatTextView r4, LinearLayout r5, SimpleDraweeView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
