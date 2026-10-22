package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.DispatchCallbackLinearLayout;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static TextMessageRenderViewHolder.f a(Context r8) {
        NoMoreSpaceTextView r0 = new NoMoreSpaceTextView(r8);
        r0.setMinimumHeight((int) s1.e(24.0f));
        float r1 = r0.getLineSpacingMultiplier();
        if (PublicScreenStyleHelper.n == false) goto L5;
        float r2 = PublicScreenStyleHelper.g;
    L6:
        r0.setLineSpacing(r2, r1);
        r0.setPadding(s1.f(8.0f), s1.f(3.0f), s1.f(8.0f), s1.f(3.0f));
        r0.setTextIsSelectable(false);
        r0.setTextAlignment(5);
        r0.setGravity(16);
        r0.setTextSize(s1.e(15.0f));
        r0.setTypeface(Typeface.DEFAULT_BOLD);
        r0.setId(2131388367);
        DispatchCallbackLinearLayout r3 = new DispatchCallbackLinearLayout(r8, null);
        r3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r3.setId(2131377403);
        r3.setOrientation(1);
        r3.addView(r0);
        r3.setFocusable(true);
        r3.setFocusableInTouchMode(true);
        r3.setImportantForAccessibility(2);
        if (r3.getLayoutParams() != null) goto L9;
        r3.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
    L9:
        RelativeLayout r6 = new RelativeLayout(r8);
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r6.addView(r3);
        r6.setFocusable(true);
        r6.setFocusableInTouchMode(true);
        r6.setImportantForAccessibility(2);
        if (InteractivityOpt.b == false) goto L13;
        r3.setLayerType(2, null);
    L13:
        if (r6.getLayoutParams() != null) goto L16;
        r6.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L16:
        if (r3.getLayoutParams() != null) goto L19;
        r3.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
    L19:
        return new TextMessageRenderViewHolder.f(r6, r0, r3, r3);
    L5:
        r2 = PublicScreenStyleHelper.f;
        goto L6
    }
}
