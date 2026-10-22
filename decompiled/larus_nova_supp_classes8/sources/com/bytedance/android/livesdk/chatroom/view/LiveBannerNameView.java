package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveBannerNameView extends LinearLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    public View d;

    public LiveBannerNameView(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r3) {
        View r4 = LayoutInflater.from(r3).inflate(2131565218, this, true);
        this.d = r4;
        this.a = (TextView) r4.findViewById(2131363944);
        this.b = (TextView) this.d.findViewById(2131363946);
        this.c = (TextView) this.d.findViewById(2131363945);
    }

    public void setText(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L6;
        b(0, 8, 8);
        this.a.setText("");
        return;
    L6:
        int r0 = r9.length();
        if (r0 != 1) goto L9;
        b(8, 0, 8);
        this.b.setText(r9);
    L9:
        char[] r10 = r9.toCharArray();
        if (r0 != 2) goto L13;
        b(0, 4, 0);
        this.a.setText("" + r10[0]);
        this.c.setText("" + r10[1]);
    L13:
        if (r0 < 3) goto L16;
        b(0, 0, 0);
        this.a.setText("" + r10[0]);
        this.b.setText("" + r10[1]);
        this.c.setText("" + r10[2]);
        return;
    }

    public void setTextColor(int r2) {
        this.a.setTextColor(r2);
        this.b.setTextColor(r2);
        this.c.setTextColor(r2);
    }

    public LiveBannerNameView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public LiveBannerNameView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }

    public final void b(int r2, int r3, int r4) {
        this.a.setVisibility(r2);
        this.b.setVisibility(r3);
        this.c.setVisibility(r4);
    }
}
