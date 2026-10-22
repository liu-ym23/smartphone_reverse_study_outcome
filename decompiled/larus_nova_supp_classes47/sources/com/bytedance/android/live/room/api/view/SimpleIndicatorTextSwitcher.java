package com.bytedance.android.live.room.api.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/api/view/SimpleIndicatorTextSwitcher;", "Landroid/widget/TextSwitcher;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleIndicatorTextSwitcher extends TextSwitcher {
    public final TextView a(String r5) {
        TextView r0 = new TextView(getContext());
        r0.setSingleLine();
        r0.setTextSize(1, 15.0f);
        r0.setTextColor(r0.getResources().getColor(2131109391));
        r0.setText(r5);
        r0.setIncludeFontPadding(false);
        r0.setSingleLine(true);
        r0.setGravity(8388613);
        r0.setIncludeFontPadding(false);
        return r0;
    }

    public SimpleIndicatorTextSwitcher(Context r1, AttributeSet r2) {
        super(r1, r2);
        setInAnimation(AnimationUtils.loadAnimation(getContext(), 2130772001));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), 2130772002));
    }
}
