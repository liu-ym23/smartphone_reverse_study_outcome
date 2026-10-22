package com.bytedance.android.live.liveinteract.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.linkpanel.model.ActiveUser;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class OnlineFriendsCircleContainer extends RelativeLayout {
    public int a;
    public int b;
    public int c;
    public int d;

    public OnlineFriendsCircleContainer(Context r2) {
        this(r2, null);
    }

    public final void a(List r11) {
        removeAllViews();
        int r0 = r11.size();
        if (r0 < 3) goto L5;
        r0 = 3;
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        ActiveUser r3 = (ActiveUser) ListProtector.get(r11, r2);
        RelativeLayout r4 = new RelativeLayout(getContext());
        int r6 = this.b;
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(r6, r6);
        r5.leftMargin = (this.c * r2) + 0;
        addView(r4, r5);
        HSImageView r7 = new HSImageView(getContext());
        int r8 = this.b;
        r4.addView(r7, new RelativeLayout.LayoutParams(r8, r8));
        a1.y(r7, r3.user.getAvatarThumbKt(), 2131251677, ContextCompat.getColor(getContext(), 2131109391), t6.a(getContext(), 4.0f));
        if (r3.isActive == false) goto L10;
        View r9 = new HSImageView(getContext());
        int r10 = this.a;
        RelativeLayout.LayoutParams r12 = new RelativeLayout.LayoutParams(r10, r10);
        r12.addRule(12);
        r12.addRule(11);
        r12.rightMargin = this.d;
        r9.setImageResource(2131249665);
        r4.addView(r9, r12);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        int r13 = getChildCount() - 1;
    L12:
        if (r13 < 0) goto L14;
        getChildAt(r13).bringToFront();
        r13 = r13 - 1;
        goto L12
    }

    public OnlineFriendsCircleContainer(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public OnlineFriendsCircleContainer(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = (int) t6.a(getContext(), 64.0f);
        this.a = (int) t6.a(getContext(), 12.0f);
        this.c = (int) t6.a(getContext(), 40.0f);
        this.d = (int) t6.a(getContext(), 10.0f);
    }
}
