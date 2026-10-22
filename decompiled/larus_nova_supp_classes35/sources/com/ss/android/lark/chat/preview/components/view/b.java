package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends FrameLayout {
    public final LKUIRoundedImageView2 a;
    public final LKUIRoundedImageView2 b;

    public final LKUIRoundedImageView2 getThumbImage() {
        return this.a;
    }

    public final LKUIRoundedImageView2 getThumbImageMask() {
        return this.b;
    }

    public b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        LayoutInflater.from(r3).inflate(2131560081, this, true);
        this.a = findViewById(2131369274);
        this.b = findViewById(2131369273);
    }
}
