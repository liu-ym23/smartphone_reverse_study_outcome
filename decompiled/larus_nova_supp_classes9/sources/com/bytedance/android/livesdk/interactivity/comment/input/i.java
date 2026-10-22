package com.bytedance.android.livesdk.interactivity.comment.input;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends Dialog {
    public TextView a;
    public TextView b;
    public CheckBox c;
    public TextView d;
    public Button e;
    public Button f;

    public i(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 2131954708);
        setContentView(2131567138);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.a = (TextView) findViewById(2131365427);
        this.b = (TextView) findViewById(2131365407);
        this.c = (CheckBox) findViewById(2131365404);
        TextView r3 = (TextView) findViewById(2131365405);
        this.d = r3;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkedText");
    L5:
        r3.setOnClickListener(new h(this));
        this.e = (Button) findViewById(2131377737);
        this.f = (Button) findViewById(2131384558);
    }
}
