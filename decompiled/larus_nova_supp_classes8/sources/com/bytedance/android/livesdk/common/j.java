package com.bytedance.android.livesdk.common;

import android.graphics.Paint;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface j {

    public interface a {
        void onEnd();

        void onStart();
    }

    void cancelAnimation();

    View getA11yDescView();

    String getContent();

    String getOriginText();

    Paint getPaint();

    void scrollToOrigin();

    void setIncludeFontPadding(boolean r1);

    void setMaxWidth(int r1);

    void setScrollEnd(boolean r1);

    void setSpeed(int r1);

    void setTextColor(int r1);

    void setTextSize(int r1, float r2);

    void setTextWithEllipsis(String r1);

    void setTextWithEllipsisImmediately(String r1);

    void setTextWithFading(String r1);

    void setTextWithFadingMode(String r1);

    void startMarqueeIfNeed(a r1);

    void startMarqueeIfNeed(Function1<? super Boolean, Unit> r1);

    void textNeedLeftEdge(boolean r1);
}
