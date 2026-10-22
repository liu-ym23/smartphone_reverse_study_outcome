package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends FrameLayout {
    public final TextView a;
    public final TextView b;

    public final void setContentText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a.setText(r2);
    }

    public final void setTitleText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.b.setText(r2);
    }

    public e(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        LayoutInflater.from(r2).inflate(2131567649, this);
        this.b = (TextView) findViewById(2131388772);
        this.a = (TextView) findViewById(2131387553);
        if (r3 == null) goto L5;
        setTitleText(r3);
    L5:
        if (r4 == null) goto L8;
        setContentText(r4);
        return;
    }
}
