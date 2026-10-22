package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.util.IESUIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class EcomEnterTrayView extends LinearLayout {
    public TextView a;
    public HSImageView b;

    public EcomEnterTrayView(Context r2) {
        this(r2, null);
    }

    private void setEcomIcon(k32.b r2) {
        if (TextUtils.isEmpty(r2.u) == false) goto L5;
        this.b.setImageResource(2131251717);
        return;
    L5:
        ImageLoader.bindImage(this.b, r2.u);
    }

    private void setTextContent(k32.b r10) {
        if (TextUtils.isEmpty(r10.f) == false) goto L5;
        String r0 = getContext().getString(2131916324);
    L6:
        long r1 = r10.t;
        if (r1 != 1) goto L9;
        String r11 = getContext().getString(2131916326, new Object[]{r10.b, r0});
    L10:
        this.a.setText(r11);
        return;
    L9:
        String r2 = IESUIUtils.getDisplayCount(r1, "w");
        r11 = getContext().getString(2131916325, new Object[]{r10.b, r2, r0});
        goto L10
    L5:
        r0 = r10.f;
        goto L6
    }

    public final void a(k32.b r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        setTextContent(r1);
        setEcomIcon(r1);
        setBackgroundResource(2131249080);
    }

    public EcomEnterTrayView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public EcomEnterTrayView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LinearLayout.inflate(getContext(), 2131565834, this);
        this.a = (TextView) findViewById(2131390551);
        this.b = findViewById(2131376198);
        setGravity(16);
    }
}
