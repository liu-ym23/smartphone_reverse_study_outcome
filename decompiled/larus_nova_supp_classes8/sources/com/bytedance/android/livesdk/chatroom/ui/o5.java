package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o5 extends Dialog {
    public View a;
    public TextView b;
    public TextView c;
    public TextView d;
    public View e;
    public Button f;
    public Button g;
    public TextView h;

    public o5(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 2131954708);
        setContentView(2131565402);
        setCanceledOnTouchOutside(false);
        this.b = (TextView) findViewById(2131384762);
        this.c = (TextView) findViewById(2131384757);
        this.d = (TextView) findViewById(2131388756);
        this.f = (Button) findViewById(2131384805);
        this.a = findViewById(2131388757);
        this.e = findViewById(2131388758);
        this.g = (Button) findViewById(2131384791);
        this.h = (TextView) findViewById(2131384761);
    }
}
