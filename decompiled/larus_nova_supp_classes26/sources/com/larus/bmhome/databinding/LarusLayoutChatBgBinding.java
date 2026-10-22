package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.view.ImmerseBgVideoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutChatBgBinding implements ViewBinding {
    public final View a;
    public final ImmerseBgVideoView b;
    public final SimpleDraweeView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutChatBgBinding(View r1, ImmerseBgVideoView r2, SimpleDraweeView r3, ImageView r4, ImageView r5, ImageView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
