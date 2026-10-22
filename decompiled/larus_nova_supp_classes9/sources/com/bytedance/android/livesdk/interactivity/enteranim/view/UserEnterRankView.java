package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class UserEnterRankView extends LinearLayout {
    public View a;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Context r0 = getContext();
        this.a = new View(r0);
        int r1 = s1.f(16.0f);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(r1, r1);
        r2.gravity = 16;
        ImageView r3 = new ImageView(r0);
        ViewGroup.LayoutParams r4 = new LinearLayout.LayoutParams(s1.f(30.0f), s1.f(14.0f));
        r2.gravity = 16;
        r3.setImageResource(2131251527);
        if (RTLUtil.isAppRTL(r0) == false) goto L5;
        addView(r3, 0, r4);
        addView(this.a, r2);
        return;
    L5:
        addView(this.a, 0, r2);
        addView(r3, r4);
    }

    public UserEnterRankView(Context r1) {
        super(r1);
    }

    public void setupUI(k32.a r4) {
        TextView r0 = (TextView) findViewById(2131390392);
        int r5 = r4.j;
        if (r5 != 0) goto L6;
        setVisibility(8);
        return;
    L6:
        if (r5 != 1) goto L9;
        this.a.setBackgroundResource(2131251605);
        r0.setText(2131918959);
        return;
    L9:
        if (r5 != 2) goto L12;
        this.a.setBackgroundResource(2131251606);
        r0.setText(2131918961);
        return;
    L12:
        if (r5 != 3) goto L15;
        this.a.setBackgroundResource(2131251607);
        r0.setText(2131918962);
        return;
    L15:
        if (r5 != 4) goto L17;
        this.a.setVisibility(8);
        r0.setText(2131918960);
        return;
    L17:
        setVisibility(8);
    }

    public UserEnterRankView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public UserEnterRankView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
