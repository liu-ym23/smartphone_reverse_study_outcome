package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a8 extends FrameLayout {
    public final ViewGroup a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;

    public a8(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        LayoutInflater.from(getContext()).inflate(2131565622, this, true);
        this.a = (ViewGroup) findViewById(2131382381);
        this.b = (ImageView) findViewById(2131382387);
        this.c = (TextView) findViewById(2131382390);
        this.d = (TextView) findViewById(2131382388);
    }
}
