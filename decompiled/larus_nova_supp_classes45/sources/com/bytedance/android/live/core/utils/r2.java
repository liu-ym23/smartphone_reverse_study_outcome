package com.bytedance.android.live.core.utils;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r2 {

    public static class a extends ViewOutlineProvider {
        public final float a;

        public a(float r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r6, Outline r7) {
            r7.setRoundRect(new Rect(r6.getPaddingLeft(), r6.getPaddingTop(), r6.getWidth() - r6.getPaddingRight(), r6.getHeight() - r6.getPaddingBottom()), this.a);
        }
    }

    public static void a(View r1, int r2) {
        r1.setOutlineProvider(new a(r2));
        r1.setClipToOutline(true);
    }
}
