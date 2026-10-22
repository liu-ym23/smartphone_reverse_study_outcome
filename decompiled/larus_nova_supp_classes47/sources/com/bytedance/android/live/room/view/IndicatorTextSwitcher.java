package com.bytedance.android.live.room.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/view/IndicatorTextSwitcher;", "Landroid/widget/TextSwitcher;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IndicatorTextSwitcher extends TextSwitcher {

    public static final class a implements ViewSwitcher.ViewFactory {
        public final /* synthetic */ IndicatorTextSwitcher a;

        public a(IndicatorTextSwitcher r1) {
            this.a = r1;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public final View makeView() {
            TextView r0 = new TextView(this.a.getContext());
            r0.setSingleLine();
            r0.setTextSize(1, 10.0f);
            r0.setTextColor(this.a.getResources().getColor(2131101254));
            r0.setIncludeFontPadding(false);
            r0.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return r0;
        }
    }

    public IndicatorTextSwitcher(Context r1, AttributeSet r2) {
        super(r1, r2);
        setFactory(new a(this));
        setInAnimation(AnimationUtils.loadAnimation(getContext(), 2130772001));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), 2130772002));
    }
}
